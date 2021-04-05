package com.qe.tests.smoke;

import com.qe.BaseTest;
import com.qe.pages.common.NavDrawer;
import com.qe.pages.discover.DiscoverPage;
import com.qe.pages.lists.*;
import com.qe.pages.lists.par.*;
import com.qe.pages.login.LoginPage;
import com.qe.utils.TestUtils;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class ParTests extends BaseTest {
    TestUtils utils = new TestUtils();
    LoginPage loginPage;
    DiscoverPage discoverPage;
    NavDrawer navDrawer;
    ListsPage listsPage;
    ListSettingsPage listSettingsPage;
    ListPage listPage;
    ParPage parPage;
    SelectParPage selectParPage;
    CreateParPage createParPage;
    EditParPage editParPage;
    ParSettingsPage parSettingsPage;
    DeleteParModal deleteParModal;

    @BeforeMethod
    public void beforeMethod(Method m) {
        utils.log().info("\n       Starting test:" + m.getName());

        loginPage = new LoginPage();
        discoverPage = new DiscoverPage();
        listsPage = new ListsPage();
        navDrawer = new NavDrawer();
        listSettingsPage = new ListSettingsPage();
        listPage = new ListPage();
        parPage = new ParPage();
        selectParPage = new SelectParPage();
        createParPage = new CreateParPage();
        editParPage = new EditParPage();
        parSettingsPage = new ParSettingsPage();
        deleteParModal = new DeleteParModal();
    }

    @Test(retryAnalyzer = com.qe.utils.RetryAnalyzer.class)
    public void createParListAddQtyAndDelete() throws InterruptedException {
        String newParListName = "" + Math.random();
        loginPage.enterEmail(BaseTest.users.getJSONObject("customerForParTests").getString("email"));
        loginPage = loginPage.pressNextButton();
        loginPage.enterPassword(BaseTest.users.getJSONObject("customerForParTests").getString("password"));
        discoverPage = loginPage.pressLoginButton();
        listsPage = discoverPage.pressNavBarDrawerButton().pressListsButton();
        listsPage.checkPageIsLoadedAndIfNotReload();
        listPage = listsPage.pressList("Appium Par Test (do not delete)");
        listSettingsPage = listPage.pressListSettingsButton();
        listSettingsPage.toggleParManagement();
        scrollDownByCoordinates();
        createParPage = listSettingsPage.pressCreateParListButton();
        listSettingsPage = createParPage
                .inputParName(newParListName)
                .pressSaveButtonToReturnToSettingsPage();
        scrollDownByCoordinates();
        parPage = listSettingsPage
                .pressOnParWithName(newParListName);
        editParPage = parPage.pressEditParItemsButton();
        parPage = editParPage
                .inputFirstItemsParValue("14")
                .pressBackButton();
        listSettingsPage = parPage.pressBackButton();
        if (getPlatform().equalsIgnoreCase("Android")) {
            listPage = listSettingsPage.pressCloseButton();
        }
        if (getPlatform().equalsIgnoreCase("iOS")) {
            listPage = listSettingsPage.pressSaveListButton();
            Thread.sleep(2500);
        }
        selectParPage = listPage.pressParGroupSelector();
        listPage = selectParPage.pressOnParWithName(newParListName)
                .pressBackButton();
        if (getPlatform().equalsIgnoreCase("iOS")) {
            listPage.checkElementsPresenceForFirstItemCasePar("PAR 14.00 CS");
        }
        if (getPlatform().equalsIgnoreCase("Android")) {
            listPage.checkElementsPresenceForFirstItemCasePar("PAR 14 CS");
        }
        parPage = listPage.pressListSettingsButton().pressOnParWithName(newParListName);
        parSettingsPage = parPage.pressParSettings();
        deleteParModal = parSettingsPage.pressDeleteParButton();
        listSettingsPage = deleteParModal.pressYesButton();
        listPage = listSettingsPage.pressCloseButton();
        listPage.checkParSelectorIsEmpty();
    }

}
