package com.qe.pages.search;

import com.qe.BaseTest;
import com.qe.pages.discover.DiscoverPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

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

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.syscocorp.mss.enterprise.dev:id/typeAheadView\"]/android.widget.TextView[1]")
    @iOSXCUITFindBy(id = "type ahead suggestion carrot")
    private MobileElement searchResultFirst;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.syscocorp.mss.enterprise.dev:id/typeAheadView\"]/android.widget.TextView[2]")
    private MobileElement searchResultSecond;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.syscocorp.mss.enterprise.dev:id/typeAheadView\"]/android.widget.TextView[3]")
    private MobileElement searchResultThird;

    public TypeAheadPage checkElementsPresence(String expectedResult) {
        Assert.assertTrue(searchResultFirst.isDisplayed());
        Assert.assertTrue(navBarDrawerButton.isDisplayed());
        Assert.assertTrue(searchTextField.isDisplayed());
        Assert.assertTrue(clearTextButton.isDisplayed());
        if(getPlatform().equalsIgnoreCase("Android")) {
            Assert.assertEquals(popularSearchesLabel.getText(), "POPULAR SEARCHES");
            Assert.assertTrue(searchResultFirst.getText().toLowerCase().contains(expectedResult));
            Assert.assertTrue(searchResultSecond.getText().toLowerCase().contains(expectedResult));
            Assert.assertTrue(searchResultThird.getText().toLowerCase().contains(expectedResult));
            Assert.assertTrue(clearTextButton.isDisplayed());
            Assert.assertTrue(cartButton.isDisplayed());
        }
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
