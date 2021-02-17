package com.qe.tests;

import com.qe.BaseTest;
import com.qe.pages.common.NavDrawer;
import com.qe.pages.discover.DiscoverPage;
import com.qe.pages.login.LogOutPage;
import com.qe.pages.login.LoginPage;
import com.qe.utils.TestUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class LogOutTests extends BaseTest {
    LoginPage loginPage;
    DiscoverPage discoverPage;
    LogOutPage logOutPage;
    NavDrawer navDrawer;
    TestUtils utils = new TestUtils();

    @BeforeMethod
    public void beforeMethod(Method m) {
        utils.log().info("******  Starting test:" + m.getName() + "    ******" + "\n");
        loginPage = new LoginPage();
        navDrawer = new NavDrawer();
        logOutPage = new LogOutPage();
        discoverPage = new DiscoverPage();
    }

    @Test
    public void customerLogout() throws InterruptedException  {
        loginPage.checkElementsPresence();
        loginPage.enterEmail(BaseTest.users.getJSONObject("customer").getString("email"));
        loginPage = loginPage.pressNextButton();

        loginPage.checkCustomerElementsPresence();
        loginPage.enterPassword(BaseTest.users.getJSONObject("customer").getString("password"));
        discoverPage = loginPage.pressLoginButton();
        navDrawer = discoverPage.pressNavBarDrawerButton();
        if(getPlatform().equalsIgnoreCase("iOS")) {
            logOutPage = navDrawer.pressLogOutButtonForiOS();
            logOutPage.checkElementsPresence();
            loginPage = logOutPage.pressBackToLoginButton();
            loginPage.checkElementsPresence();

        }
        if(getPlatform().equalsIgnoreCase("Android")) {
            loginPage = navDrawer.pressLogOutButtonForAndroid();
            loginPage.checkElementsPresence();
        }
    }
}
