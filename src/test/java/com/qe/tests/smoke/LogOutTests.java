package com.qe.tests.smoke;

import com.qe.BaseTest;
import com.qe.pages.common.NavDrawer;
import com.qe.pages.discover.DiscoverPage;
import com.qe.pages.login.LogOutPage;
import com.qe.pages.login.LoginPage;
import com.qe.utils.TestUtils;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class LogOutTests extends BaseTest {
    LoginPage loginPage;
    DiscoverPage discoverPage;
    LogOutPage logOutPage;
    NavDrawer navDrawer;
    TestUtils utils = new TestUtils();

    @BeforeMethod
    public void beforeMethod(Method m) {
        utils.log().info("\n       Starting test:" + m.getName());

        loginPage = new LoginPage();
        navDrawer = new NavDrawer();
        logOutPage = new LogOutPage();
        discoverPage = new DiscoverPage();
    }

    @Test(retryAnalyzer = com.qe.utils.RetryAnalyzer.class)
    public void customerLogout() throws InterruptedException {
        loginPage.enterEmail(BaseTest.users.getJSONObject("customer").getString("email"));
        loginPage = loginPage.pressNextButton();
        loginPage.enterPassword(BaseTest.users.getJSONObject("customer").getString("password"));
        discoverPage = loginPage.pressLoginButton();
        navDrawer = discoverPage.pressNavBarDrawerButton();
        if(getPlatform().equalsIgnoreCase("iOS")) {
            logOutPage = navDrawer.pressLogOutButtonForiOS();
            logOutPage.checkElementsPresence();
            loginPage = logOutPage.pressBackToLoginButton();
            getDriver().hideKeyboard();
            loginPage.checkElementsPresence();
        }
        if(getPlatform().equalsIgnoreCase("Android")) {
            loginPage = navDrawer.pressLogOutButtonForAndroid();
            getDriver().hideKeyboard();
            loginPage.checkElementsPresence();
        }
    }

}
