package com.qe.tests;

import com.qe.BaseTest;
import com.qe.pages.discover.DiscoverPage;
import com.qe.pages.common.NavDrawer;
import com.qe.pages.lists.*;
import com.qe.pages.login.LoginPage;
import com.qe.utils.TestUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ListsTests extends BaseTest {
    TestUtils utils = new TestUtils();
    LoginPage loginPage;
    DiscoverPage discoverPage;
    ListsPage listsPage;
    NavDrawer navDrawer;
    ListSettingsPage listSettingsPage;
    ListPage listPage;
    ListDeleteAlert listDeleteAlert;

    @BeforeMethod
    public void beforeMethod(Method m) throws InterruptedException {
        utils.log().info("****** starting test:" + m.getName() + "******" + "\n");
        loginPage = new LoginPage();
        discoverPage = new DiscoverPage();
        listsPage = new ListsPage();
        navDrawer = new NavDrawer();
        listSettingsPage = new ListSettingsPage();
        listPage = new ListPage();
        listDeleteAlert = new ListDeleteAlert();
        loginPage.enterEmail(BaseTest.users.getJSONObject("customerForListsTests").getString("email"));
        loginPage = loginPage.pressNextButton();
        loginPage.enterPassword(BaseTest.users.getJSONObject("customerForListsTests").getString("password"));
        discoverPage = loginPage.pressLoginButton();
        discoverPage.pressNavBarDrawerButton().pressListsButton();
    }

    @Test
    public void openNavDrawer() throws InterruptedException {
        navDrawer = listsPage.pressNavBarDrawerButton();
        navDrawer.checkElementsPresence();
        ListsPage listsPage = navDrawer.pressListsButton();
        listsPage.checkElementsPresence();
    }

    @Test
    public void openAndCloseNewListPage() throws InterruptedException {
        listSettingsPage = listsPage.pressCreateListButton();
        listSettingsPage = listSettingsPage.checkElementsPresence();
        listsPage = listSettingsPage.pressCloseButtonFromNewListPage();
        listsPage.checkElementsPresence();
    }

    @Test
    public void createNewList() throws InterruptedException {
        String newListName = "AppiumTestList " + Math.random();
        listSettingsPage = listsPage.pressCreateListButton();
        listSettingsPage.enterListName(newListName);
        listPage = listSettingsPage.pressSaveListButton();
        Thread.sleep(10000);
        listPage.checkElementsPresence();
        listPage.checkListName(newListName);
        listsPage = listPage.pressBackButton();
        listsPage.checkElementsPresence();
    }

    @Test
    public void createNewDefaultList() throws InterruptedException {
        String newListName = "AppiumTestList " + Math.random();
        listSettingsPage = listsPage.pressCreateListButton();
        listSettingsPage.enterListName(newListName);
        listSettingsPage.pressDefaultListCheckbox();
        listPage = listSettingsPage.pressSaveListButton();
        listPage.checkDefaultListElementsPresence();
        listPage.checkListName(newListName);
    }

    @Test
    public void createListAndChangeSettings() throws InterruptedException {
        String newListName = "AppiumTestList " + Math.random();
        String changedListName = "AppiumTestListChanged " + Math.random();
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
        String newListName = "AppiumTestListToDelete " + Math.random();
        listSettingsPage = listsPage.pressCreateListButton();
        listSettingsPage.enterListName(newListName);
        listPage = listSettingsPage.pressSaveListButton();
        listPage.checkListName(newListName);
        listSettingsPage = listPage.pressListSettingsButton();
        listDeleteAlert = listSettingsPage.pressDeleteListButton();
        listDeleteAlert.checkElementsPresence();
        listsPage = listDeleteAlert.pressYes();
        listsPage.checkElementsPresence();
    }

    @Test
    public void createListAndDoNotDelete() throws InterruptedException {
        String newListName = "AppiumTestListToDelete " + Math.random();
        listSettingsPage = listsPage.pressCreateListButton();
        listSettingsPage.enterListName(newListName);
        listPage = listSettingsPage.pressSaveListButton();
        listPage.checkListName(newListName);
        listSettingsPage = listPage.pressListSettingsButton();
        listDeleteAlert = listSettingsPage.pressDeleteListButton();
        listDeleteAlert.checkElementsPresence();
        listSettingsPage = listDeleteAlert.pressNo();
        listPage = listSettingsPage.pressCloseButton();
        listPage.checkElementsPresence();
    }
}
