package com.qe.tests.smoke;

import com.qe.BaseTest;
import com.qe.pages.discover.DiscoverPage;
import com.qe.pages.common.NavDrawer;
import com.qe.pages.lists.*;
import com.qe.pages.login.LoginPage;
import com.qe.pages.search.SearchCatalogPage;
import com.qe.utils.TestUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ListsTests extends BaseTest {
    TestUtils utils = new TestUtils();
    LoginPage loginPage;
    DiscoverPage discoverPage;
    NavDrawer navDrawer;
    ListsPage listsPage;
    ListSettingsPage listSettingsPage;
    ListPage listPage;
    ListDeleteAlert listDeleteAlert;
    AddToListPage addToListPage;
    SearchCatalogPage searchCatalogPage;

    @BeforeMethod
    public void beforeMethod(Method m) throws InterruptedException {
        utils.log().info("\n       Starting test:" + m.getName());
        loginPage = new LoginPage();
        discoverPage = new DiscoverPage();
        listsPage = new ListsPage();
        navDrawer = new NavDrawer();
        listSettingsPage = new ListSettingsPage();
        listPage = new ListPage();
        listDeleteAlert = new ListDeleteAlert();
        searchCatalogPage = new SearchCatalogPage();
        addToListPage = new AddToListPage();
        loginPage.enterEmail(BaseTest.users.getJSONObject("customerForListsTests").getString("email"));
        loginPage = loginPage.pressNextButton();
        loginPage.enterPassword(BaseTest.users.getJSONObject("customerForListsTests").getString("password"));
        discoverPage = loginPage.pressLoginButton();
        listsPage = discoverPage.pressNavBarDrawerButton().pressListsButton();
        listsPage.checkPageIsLoadedAndIfNotReload();
    }

    @Test
    public void createListWithProductAndDelete() throws InterruptedException {
        String newListName = "AL " + Math.random();
        listSettingsPage = listsPage.pressCreateListButton();
        listSettingsPage.enterListName(newListName);
        listPage = listSettingsPage.pressSaveListButton();
        listPage.checkListName(newListName);
        listsPage = listPage.pressBackButton();
        listsPage.checkPageIsLoadedAndIfNotReload();
        searchCatalogPage = listsPage.inputSearch("0566709");
        addToListPage = searchCatalogPage.pressFirstProductDotButton()
                .pressAddToListButton();
        addToListPage.selectListWithName(newListName);
        searchCatalogPage = addToListPage.pressSaveDoneButtonToReturnToSearch();
        Thread.sleep(1500);
        searchCatalogPage.checkElementsPresenceForBannerItemAddedToList();
        Thread.sleep(2500);
        searchCatalogPage.checkElementsPresence("0566709");
        if(getPlatform().equalsIgnoreCase("iOS")) {
            listsPage = searchCatalogPage
                    .pressIosNavBarDrawerButton()
                    .pressListsButton();
        }
        if(getPlatform().equalsIgnoreCase("Android")) {
            listsPage = searchCatalogPage
                    .pressAndroidBackButtonToListsPage()
                    .pressNavBarDrawerButton()
                    .pressListsButton();
        }
        listsPage.checkPageIsLoadedAndIfNotReload();
        listsPage.checkElementsPresence();
        listPage = listsPage.pressList(newListName);
        listPage.checkElementsPresence();
        listPage.checkElementsPresenceForFirstItemCase(
                BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("title"),
                BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("description"),
                BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("pricePerCsCatchweight")
        );
        listSettingsPage = listPage.pressListSettingsButton();
        listDeleteAlert = listSettingsPage.pressDeleteListButton();
        listDeleteAlert.checkElementsPresence();
        listsPage = listDeleteAlert.pressYes();
        listsPage.checkPageIsLoadedAndIfNotReload();
        listsPage.checkElementsPresence();
    }
}
