package com.qe.tests.smoke;

import com.qe.BaseTest;
import com.qe.pages.common.IntercomPage;
import com.qe.pages.discover.DiscoverPage;
import com.qe.pages.login.*;
import com.qe.utils.TestUtils;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class LoginPageTests extends BaseTest {
    LoginPage loginPage;
    DiscoverPage discoverPage;
    ForgotPasswordPage forgotPasswordPage;
    TestUtils utils = new TestUtils();

    @BeforeMethod
    public void beforeMethod(Method m) {
        utils.log().info("\n       Starting test:" + m.getName());
        loginPage = new LoginPage();
        discoverPage = new DiscoverPage();
    }

    @Test(retryAnalyzer = com.qe.utils.RetryAnalyzer.class)
    public void openAndCloseForgotPassword() {
        loginPage.enterEmail(users.getJSONObject("customerInvalidPassword").getString("email"));
        loginPage = loginPage.pressNextButton();
        if (getPlatform().equalsIgnoreCase("iOS")){
            getDriver().hideKeyboard();
        }
        forgotPasswordPage = loginPage.pressForgotPasswordButton();
        LoginPage loginPage = forgotPasswordPage.pressBackArrowButton();
        if (getPlatform().equalsIgnoreCase("iOS")){
            loginPage.enterEmail(users.getJSONObject("customerInvalidPassword").getString("email"));
            getDriver().hideKeyboard();
        }
        loginPage.checkElementsPresence();
    }

    @Test(retryAnalyzer = com.qe.utils.RetryAnalyzer.class)
    public void openAndCloseIntercom() {
        getDriver().hideKeyboard();
        IntercomPage intercomPage = loginPage.pressHelpButton();
        LoginPage loginPage = intercomPage.pressCloseButton();
        loginPage.checkElementsPresence();
    }

    @Test(retryAnalyzer = com.qe.utils.RetryAnalyzer.class)
    public void openAndCloseAssociateLogin() {
        if (getPlatform().equalsIgnoreCase("iOS")){
            getDriver().hideKeyboard();
        }
        loginPage.pressAssociateLoginButton()
                .pressBackButton();
        if (getPlatform().equalsIgnoreCase("iOS")){
            getDriver().hideKeyboard();
        }
        loginPage.checkElementsPresence();
    }

}
