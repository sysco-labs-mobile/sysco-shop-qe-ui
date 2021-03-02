package com.qe.pages.search;

import com.qe.BaseTest;
import com.qe.pages.discover.DiscoverPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TypeAheadPage extends BaseTest {

    @AndroidFindBy(accessibility = "Open navigation drawer")
    @iOSXCUITFindBy(id = "app bar left button")
    private MobileElement navBarDrawerButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/editText")
    @iOSXCUITFindBy(id = "app nav search bar text field")
    private MobileElement searchTextField;

    @AndroidFindBy(accessibility = "Cancel")
    @iOSXCUITFindBy(id = "clear text")
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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name=\"type ahead suggestions\"]/XCUIElementTypeCell[1]")
    private MobileElement searchResultFirst;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.syscocorp.mss.enterprise.dev:id/typeAheadView\"]/android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name=\"type ahead suggestions\"]/XCUIElementTypeCell[2]")
    private MobileElement searchResultSecond;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.syscocorp.mss.enterprise.dev:id/typeAheadView\"]/android.widget.TextView[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name=\"type ahead suggestions\"]/XCUIElementTypeCell[3]")
    private MobileElement searchResultThird;

    public TypeAheadPage checkElementsPresence(String expectedResult) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(searchResultFirst.isDisplayed());
        softAssert.assertTrue(navBarDrawerButton.isDisplayed());
        softAssert.assertTrue(searchTextField.isDisplayed());
        softAssert.assertTrue(clearTextButton.isDisplayed());
        softAssert.assertTrue(searchResults.size() > 1);
        softAssert.assertTrue(searchResults
                .stream()
                .allMatch(searchResult -> searchResult.getText().equalsIgnoreCase(expectedResult)));
        if(getPlatform().equalsIgnoreCase("Android")) {
            softAssert.assertEquals(popularSearchesLabel.getText(), "POPULAR SEARCHES");
//            softAssert.assertTrue(searchResultFirst.getText().toLowerCase().contains(expectedResult));
//            softAssert.assertTrue(searchResultSecond.getText().toLowerCase().contains(expectedResult));
//            softAssert.assertTrue(searchResultThird.getText().toLowerCase().contains(expectedResult));
            softAssert.assertTrue(clearTextButton.isDisplayed());
            softAssert.assertTrue(cartButton.isDisplayed());
        }
        softAssert.assertAll();
        return this;
    }

    public DiscoverPage pressCancelSearchButton() {
        click(cancelSearchButton);
        return new DiscoverPage();
    }

    public SearchCatalogPage pressSearchResultFirst() {
        click(searchResultFirst);
        return new SearchCatalogPage();
    }

}
