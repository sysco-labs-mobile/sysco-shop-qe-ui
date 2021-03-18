package com.qe.tests.smoke;

import com.qe.BaseTest;
import com.qe.pages.discover.DiscoverPage;
import com.qe.pages.common.NavDrawer;
import com.qe.pages.login.LoginPage;
import com.qe.utils.TestUtils;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class DiscoverTests extends BaseTest {
    LoginPage loginPage;
    DiscoverPage discoverPage;
    NavDrawer navDrawer;
    TestUtils utils = new TestUtils();

    @BeforeMethod
    public void beforeMethod(Method m) {
        utils.log().info("\n       Starting test:" + m.getName());

        loginPage = new LoginPage();
        discoverPage = new DiscoverPage();
        navDrawer = new NavDrawer();
    }

    @Test(retryAnalyzer = com.qe.utils.RetryAnalyzer.class)
    public void openAndCloseNavDrawer() throws InterruptedException {
        loginPage.enterEmail(BaseTest.users.getJSONObject("customer").getString("email"));
        loginPage = loginPage.pressNextButton();
        loginPage.enterPassword(BaseTest.users.getJSONObject("customer").getString("password"));
        discoverPage = loginPage.pressLoginButton();
        navDrawer = discoverPage.checkElementsPresence().pressNavBarDrawerButton();
        navDrawer.checkElementsPresence();
        navDrawer.pressDiscoverPageButton();
    }

}
