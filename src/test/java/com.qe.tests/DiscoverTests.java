package com.qe.tests;

import com.qe.BaseTest;
import com.qe.pages.discover.DiscoverPage;
import com.qe.pages.common.NavDrawer;
import com.qe.pages.login.LoginPage;
import com.qe.utils.TestUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DiscoverTests extends BaseTest {
    LoginPage loginPage;
    DiscoverPage discoverPage;
    NavDrawer navDrawer;
    TestUtils utils = new TestUtils();

    @BeforeMethod
    public void beforeMethod(Method m)  throws InterruptedException  {
        utils.log().info("****** starting test:" + m.getName() + "******" + "\n");
        loginPage = new LoginPage();
        discoverPage = new DiscoverPage();
        navDrawer = new NavDrawer();
        loginPage.enterEmail(BaseTest.users.getJSONObject("customer").getString("email"));
        loginPage = loginPage.pressNextButton();
        loginPage.enterPassword(BaseTest.users.getJSONObject("customer").getString("password"));
        discoverPage = loginPage.pressLoginButton();
    }

    @Test
    public void openAndCloseNavDrawer() throws InterruptedException {
        navDrawer = discoverPage.checkElementsPresence().pressNavBarDrawerButton();
        navDrawer.checkElementsPresence();
        navDrawer.pressDiscoverPageButton();
    }
}
