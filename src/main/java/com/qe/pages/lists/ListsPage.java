package com.qe.pages.lists;

import com.qe.BaseTest;
import com.qe.pages.common.NavDrawer;
import com.qe.pages.search.SearchCatalogPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ListsPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Open navigation drawer")
    @iOSXCUITFindBy(id = "app bar left button")
    private MobileElement navBarDrawerButton;

    @AndroidFindBy(id = "editText")
    @iOSXCUITFindBy(id = "app nav search bar text field")
    private MobileElement searchTextField;

    @AndroidFindBy(id = "indeterminateProgressBar")
    @iOSXCUITFindBy(id = "loading bar")
    private MobileElement progressBar;

    @AndroidFindBy(id = "title")
    @iOSXCUITFindBy(id = "lists header title")
    private MobileElement listsHeader;

    @AndroidFindBy(id = "createProductListFab")
    @iOSXCUITFindBy(id = "floating action button")
    private MobileElement createListButton;

    @AndroidFindBy(id = "loadingView")
    private MobileElement androidLoadingItemViews;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]")
    @iOSXCUITFindBy(id = "list0-0")
    private MobileElement purchaseHistoryButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]/android.widget.TextView[1]")
    @iOSXCUITFindBy(id = "Purchase History")
    private MobileElement purchaseHistoryText;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]/android.widget.TextView[2]")
    private MobileElement purchaseHistoryProductCountText;

    @AndroidFindBy(id = "listName")
    private List<MobileElement> androidListsNames;

    @AndroidFindBy(id = "allListsNumItems")
    private List<MobileElement> androidListsCounts;

    /** Retry elements */

    @AndroidFindBy(id = "couldNotLoad")
    @iOSXCUITFindBy(id = "load error view - title")
    private MobileElement loadErrorTitle;

    @AndroidFindBy(accessibility = "Tap to Retry")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Tap to Retry')]")
    @iOSXCUITFindBy(id = "load error view - retry button")
    private MobileElement retryButton;

    @iOSXCUITFindBy(id = "lists refresh error banner")
    private MobileElement listsRefreshErrorBanner;

    @iOSXCUITFindBy(id = "Could not refresh lists.")
    private MobileElement refreshListsError;

    @iOSXCUITFindBy(id = "banner action button")
    private MobileElement listsRefreshRetryButton;

    private ListsPage ifFailedReload() {
        try {
            if (retryButton.isDisplayed()) {
                click(retryButton, "Press retry button on Lists page");
            }
        } catch (NoSuchElementException noSuchElementException) {
            utils.log().info("Retry to load Lists Page is not needed");
        }
        return new ListsPage();
    }

    public ListsPage checkPageIsLoadedAndIfNotReload() {
        utils.log().info("Check if reload is needed for Lists page");
        ifFailedReload();
        return new ListsPage();
    }

    public ListsPage checkElementsPresence() {
        utils.log().info("Check elements presence on Lists page");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(navBarDrawerButton.isDisplayed(), "navBarDrawerButton");
        softAssert.assertTrue(listsHeader.isDisplayed(), "listsHeader");
        softAssert.assertTrue(createListButton.isDisplayed(), "createListButton");
        softAssert.assertTrue(purchaseHistoryText.isDisplayed(), "purchaseHistoryText");
//        softAssert.assertTrue(purchaseHistoryButton.isDisplayed(), "purchaseHistoryButton);
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
        click(navBarDrawerButton, "Press nav drawer button on Lists page");
        return new NavDrawer();
    }

    public ListSettingsPage pressCreateListButton() {
        click(createListButton, "Press create list button on Lists page");
        return new ListSettingsPage();
    }

    public SearchCatalogPage inputSearch(String searchQuery) {
        sendKeys(searchTextField, searchQuery, "Input search " + searchQuery + " and hide keyboard on Lists Page");
        getDriver().getKeyboard().sendKeys("\n");
        if(getPlatform().equalsIgnoreCase("Android")) {
            click(searchTextField);
            ((AndroidDriver) getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
        }
        return new SearchCatalogPage();
    }

    public ListPage pressList(String listName) {
        utils.log().info("Press on list with name " + listName + " on Lists page");
        if(getPlatform().equalsIgnoreCase("iOS")) {
            String locator = "//XCUIElementTypeStaticText[@name='" + listName + "']/..";
            getDriver().findElement(new By.ByXPath(locator)).click();
        }
        if(getPlatform().equalsIgnoreCase("Android")) {
            for (MobileElement androidListsName : androidListsNames) {
                if (androidListsName.getText().equalsIgnoreCase(listName)) {
                    click(androidListsName);
                    break;
                }
            }
        }
        return new ListPage();
    }
}
