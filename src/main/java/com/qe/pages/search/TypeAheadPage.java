package com.qe.pages.search;

import com.qe.BaseTest;
import com.qe.pages.discover.DiscoverPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Locale;

public class TypeAheadPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Open navigation drawer")
    @iOSXCUITFindBy(id = "app bar left button")
    private MobileElement navBarDrawerButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/editText")
    @iOSXCUITFindBy(id = "app nav search bar text field")
    private MobileElement searchTextField;

    @AndroidFindBy(accessibility = "Cancel")
    @iOSXCUITFindBy(id = "Clear text")
    private MobileElement clearTextButton;

    //only android
    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/action_cart")
    private MobileElement cartButton;

    //only ios
    @iOSXCUITFindBy(id = "app bar cancel search")
    private MobileElement cancelSearchButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/typeAheadView")
    @iOSXCUITFindBy(id = "type ahead suggestions")
    private MobileElement typeAheadSuggestions;

    //android getText() POPULAR SEARCHES
    @AndroidFindBy(xpath = "//*[@resource-id=\"com.syscocorp.mss.enterprise.dev:id/typeAheadView\"]/android.widget.FrameLayout/android.widget.TextView[1]")
    @iOSXCUITFindBy(id = "POPULAR SEARCHES")
    private MobileElement popularSearchesLabel;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.syscocorp.mss.enterprise.dev:id/typeAheadView\"]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name=\"type ahead suggestions\"]/XCUIElementTypeCell")
    private List<MobileElement> searchResults;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.syscocorp.mss.enterprise.dev:id/typeAheadView\"]/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name=\"type ahead suggestions\"]/XCUIElementTypeCell[1]/XCUIElementTypeStaticText")
    private MobileElement searchResultFirst;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.syscocorp.mss.enterprise.dev:id/typeAheadView\"]/android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name=\"type ahead suggestions\"]/XCUIElementTypeCell[2]/XCUIElementTypeStaticText")
    private MobileElement searchResultSecond;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.syscocorp.mss.enterprise.dev:id/typeAheadView\"]/android.widget.TextView[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name=\"type ahead suggestions\"]/XCUIElementTypeCell[3]/XCUIElementTypeStaticText")
    private MobileElement searchResultThird;

    public TypeAheadPage checkElementsPresence(String expectedResult) {
        utils.log().info("Check elements presence in typeahead for " + expectedResult);
        waitForVisibility(searchResults.get(0), "searchResults.get(0)");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(searchResultFirst.isDisplayed(), "searchResultFirst");
        softAssert.assertTrue(searchTextField.isDisplayed(), "searchTextField");
        softAssert.assertTrue(clearTextButton.isDisplayed(), "clearTextButton");
        softAssert.assertTrue(searchResultFirst.getText().toLowerCase().contains(expectedResult.toLowerCase()),
                searchResultFirst.getText().toLowerCase() + " contains " + expectedResult);
        softAssert.assertTrue(searchResultSecond.getText().toLowerCase().contains(expectedResult.toLowerCase()),
                searchResultSecond.getText().toLowerCase() + " contains " + expectedResult);
        softAssert.assertTrue(searchResultThird.getText().toLowerCase().contains(expectedResult.toLowerCase()),
                searchResultThird.getText().toLowerCase() + " contains " + expectedResult);
        if(getPlatform().equalsIgnoreCase("Android")) {
            softAssert.assertTrue(navBarDrawerButton.isDisplayed(), "navBarDrawerButton");
            softAssert.assertEquals(popularSearchesLabel.getText(), "POPULAR SEARCHES", "popularSearchesLabel.getText() equals POPULAR SEARCHES");
            softAssert.assertTrue(clearTextButton.isDisplayed(), "clearTextButton");
            softAssert.assertTrue(cartButton.isDisplayed(), "cartButton");
        }
        softAssert.assertAll();
        return this;
    }

    public DiscoverPage pressCancelSearchButton() {
        click(cancelSearchButton, "Press cancel search button");
        return new DiscoverPage();
    }

    public SearchCatalogPage pressSearchResultFirst() {
        click(searchResultFirst, "Press first search result item");
        return new SearchCatalogPage();
    }
}
