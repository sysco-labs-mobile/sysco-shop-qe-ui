package com.qe.tests;

import com.qe.BaseTest;
import com.qe.pages.discover.DiscoverPage;
import com.qe.pages.common.NavDrawer;
import com.qe.pages.lists.*;
import com.qe.pages.login.LoginPage;
import com.qe.pages.search.SearchCatalogPage;
import com.qe.utils.TestUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

//TODO Android: Used here pages are missing Android locators and maybe some specific android test code
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
    public void beforeMethod(Method m) {
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
    public void openNavDrawer() {
        navDrawer = listsPage.pressNavBarDrawerButton();
        navDrawer.checkElementsPresence();
        ListsPage listsPage = navDrawer.pressListsButton();
        listsPage.checkElementsPresence();
    }

    @Test
    public void openAndCloseNewListPage() {
        listSettingsPage = listsPage.pressCreateListButton();
        listSettingsPage = listSettingsPage.checkElementsPresence();
        listsPage = listSettingsPage.pressCloseButtonFromNewListPage();
        listsPage.checkElementsPresence();
    }

    @Test @Ignore
    public void createNewList() throws InterruptedException {
        String newListName = "AL " + Math.random();
        listSettingsPage = listsPage.pressCreateListButton();
        listSettingsPage.enterListName(newListName);
        listPage = listSettingsPage.pressSaveListButton();
        Thread.sleep(10000);
        listPage.checkElementsPresenceForEmptyList();
        listPage.checkListName(newListName);
        listsPage = listPage.pressBackButton();
        listsPage.checkPageIsLoadedAndIfNotReload();
        listsPage.checkElementsPresence();
    }

    @Test
    public void createNewDefaultList() throws InterruptedException {
        String newListName = "AL " + Math.random();
        listSettingsPage = listsPage.pressCreateListButton();
        listSettingsPage.enterListName(newListName);
        listSettingsPage.pressDefaultListCheckbox();
        listPage = listSettingsPage.pressSaveListButton();
        listPage.checkDefaultListElementsPresence();
        listPage.checkListName(newListName);
    }

    //ios has bug in here
    @Test @Ignore
    public void createListAndChangeSettings() throws InterruptedException {
        String newListName = "AL " + Math.random();
        String changedListName = "AL2 " + Math.random();
        listSettingsPage = listsPage.pressCreateListButton();
        listSettingsPage.enterListName(newListName);
        listPage = listSettingsPage.pressSaveListButton();
        listPage.checkListName(newListName);
        listSettingsPage = listPage.pressListSettingsButton();
        listSettingsPage.clearListName();
        listSettingsPage.enterListName(changedListName);
        listSettingsPage.pressPrivateListOption();
        listSettingsPage.pressDefaultListCheckbox();
        listPage = listSettingsPage.pressSaveListButton();
        listPage.checkListName(changedListName);
        listPage.checkDefaultListElementsPresence();
    }

    @Test
    public void createListAndDelete() throws InterruptedException {
        String newListName = "AL " + Math.random();
        listSettingsPage = listsPage.pressCreateListButton();
        listSettingsPage.enterListName(newListName);
        listPage = listSettingsPage.pressSaveListButton();
        listPage.checkListName(newListName);
        listSettingsPage = listPage.pressListSettingsButton();
        listDeleteAlert = listSettingsPage.pressDeleteListButton();
        listDeleteAlert.checkElementsPresence();
        listsPage = listDeleteAlert.pressYes();
        listsPage.checkPageIsLoadedAndIfNotReload();
        listsPage.checkElementsPresence();
    }

    @Test
    public void createListAndDoNotDelete() throws InterruptedException {
        String newListName = "AL " + Math.random();
        listSettingsPage = listsPage.pressCreateListButton();
        listSettingsPage.enterListName(newListName);
        listPage = listSettingsPage.pressSaveListButton();
        listPage.checkListName(newListName);
        listSettingsPage = listPage.pressListSettingsButton();
        listDeleteAlert = listSettingsPage.pressDeleteListButton();
        listDeleteAlert.checkElementsPresence();
        listSettingsPage = listDeleteAlert.pressNo();
        listPage = listSettingsPage.pressCloseButton();
        listPage.checkElementsPresenceForEmptyList();
    }


    @Test
    public void createListAndAddToList() throws InterruptedException {
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
        searchCatalogPage.checkElementsPresenceForBannerItemAddedToList();
        Thread.sleep(2500);
        searchCatalogPage.checkElementsPresence("0566709");
        listsPage = searchCatalogPage.pressNavBar().pressListsButton();
        listsPage.checkPageIsLoadedAndIfNotReload();
        listsPage.checkElementsPresence();
        listPage = listsPage.pressList(newListName);
        listPage.checkElementsPresence();
        listPage.checkElementsPresenceForFirstItemCase(
                BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("title"),
                BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("description"),
                BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("pricePerCsCatchweight")
        );
    }
}
