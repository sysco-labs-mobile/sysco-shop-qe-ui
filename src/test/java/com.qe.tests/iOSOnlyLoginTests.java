package com.qe.tests;

import com.qe.BaseTest;
import com.qe.pages.discover.DiscoverPage;
import com.qe.pages.login.ForgotPasswordPage;
import com.qe.pages.login.ForgotPasswordPage2;
import com.qe.pages.login.LoginPage;
import com.qe.utils.TestUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class iOSOnlyLoginTests extends BaseTest {
    LoginPage loginPage;
    DiscoverPage discoverPage;
    ForgotPasswordPage forgotPasswordPage;
    TestUtils utils = new TestUtils();

    @BeforeMethod
    public void beforeMethod(Method m) {
        utils.log().info("******  Starting test:" + m.getName() + "    ******" + "\n");
        loginPage = new LoginPage();
        loginPage = new LoginPage();
        discoverPage = new DiscoverPage();
    }

    @AfterMethod
    public void afterEachTest(Method m) {
        utils.log().info("******   Ended test:" + m.getName() + "     ******" + "\n");
    }

    @Test(groups = { "WebView" })
    public void forgotPassword() throws InterruptedException {
        loginPage.enterEmail(users.getJSONObject("customerInvalidPassword").getString("email"));
        loginPage = loginPage.pressNextButton();
        forgotPasswordPage = loginPage.pressForgotPasswordButton();
        Thread.sleep(10000);
        //forgotPasswordPage.checkElementsPresence();
        forgotPasswordPage = forgotPasswordPage
                .inputEmail(users.getJSONObject("customerInvalidPassword").getString("email"));
        ForgotPasswordPage2 forgotPasswordPage2 = forgotPasswordPage.pressRequestPasswordResetButton();
        forgotPasswordPage2 = forgotPasswordPage2.checkElementsPresence();
        LoginPage loginPage = forgotPasswordPage2.pressBackArrowButton();
        loginPage.checkElementsPresence();
    }
}
