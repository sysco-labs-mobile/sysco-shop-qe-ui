package com.qe.pages.lists;

import com.qe.BaseTest;
import com.qe.pages.common.NavDrawer;
import com.qe.pages.search.SearchCatalogPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ListsPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Open navigation drawer")
    @iOSXCUITFindBy(id = "app bar left button")
    private MobileElement navBarDrawerButton;

    @iOSXCUITFindBy(id = "app nav search bar text field")
    private MobileElement searchTextField;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/editText")
    @iOSXCUITFindBy(id = "lists header title")
    private MobileElement listsHeader;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/createProductListFab")
    @iOSXCUITFindBy(id = "floating action button")
    private MobileElement createListButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[1]")
    @iOSXCUITFindBy(id = "Purchase History")
    private MobileElement purchaseHistoryText;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[2]")
    private MobileElement purchaseHistoryProductCountText;

    @AndroidFindBy(id = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    @iOSXCUITFindBy(id = "list0-0")
    private MobileElement purchaseHistoryButton;

    /** Retry elements */

    @iOSXCUITFindBy(id = "load error view - title")
    private MobileElement loadErrorTitle;

    @iOSXCUITFindBy(id = "load error view - retry button")
    private MobileElement retryButton;

    @iOSXCUITFindBy(id = "lists refresh error banner")
    private MobileElement listsRefreshErrorBanner;

    @iOSXCUITFindBy(id = "Could not refresh lists.")
    private MobileElement refreshListsError;

    @iOSXCUITFindBy(id = "banner action button")
    private MobileElement listsRefreshRetryButton;


    public ListsPage checkElementsPresence() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(navBarDrawerButton.isDisplayed());
        softAssert.assertTrue(listsHeader.isDisplayed());
        softAssert.assertTrue(createListButton.isDisplayed());
        softAssert.assertTrue(purchaseHistoryText.isDisplayed());
//        softAssert.assertTrue(purchaseHistoryButton.isDisplayed());
        softAssert.assertAll();
        return this;
    }

    public ListsPage retryIfNotLoaded(int count) {
        for(int i = 0; i < count; i++ ) {
            if (retryButton.isDisplayed()) {
                click(retryButton);
            }
        }
        return new ListsPage();
    }

    public NavDrawer pressNavBarDrawerButton() {
        click(navBarDrawerButton);
        return new NavDrawer();
    }

    public ListSettingsPage pressCreateListButton() {
        click(createListButton);
        return new ListSettingsPage();
    }

    public SearchCatalogPage inputSearch(String searchQuery) throws InterruptedException {
        sendKeys(searchTextField, searchQuery, "Input search " + searchQuery);
        getDriver().getKeyboard().sendKeys("\n");
        return new SearchCatalogPage();
    }

    public ListPage pressList(String listName) {
        if(getPlatform().equalsIgnoreCase("iOS")) {
            String locator = "//XCUIElementTypeStaticText[@name=\'" + listName + "\']/..";
            getDriver().findElement(new By.ByXPath(locator)).click();
        }
        return new ListPage();
    }
}
