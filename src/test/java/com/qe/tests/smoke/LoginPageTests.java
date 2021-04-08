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
    IntercomPage intercomPage;
    TestUtils utils = new TestUtils();

    @BeforeMethod
    public void beforeMethod(Method m) {
        utils.log().info("\n       Starting test:" + m.getName());
        loginPage = new LoginPage();
        discoverPage = new DiscoverPage();
        intercomPage = new IntercomPage();
    }

    @Test(retryAnalyzer = com.qe.utils.RetryAnalyzer.class)
    public void openAndCloseForgotPassword() throws InterruptedException {
        loginPage.enterEmail(users.getJSONObject("customerInvalidPassword").getString("email"));
        loginPage = loginPage.pressNextButton();
        forgotPasswordPage = loginPage.pressForgotPasswordButton();
        Thread.sleep(1000);
        loginPage = forgotPasswordPage.pressBackArrowButton();
        Thread.sleep(1000);
        if (getPlatform().equalsIgnoreCase("iOS")){
            if (!getIosTablet().equals("true")){
                getDriver().hideKeyboard();
            }
            if (getIosTablet().equals("true")){
                scrollDownByCoordinatesOnTablet();
            }
        }
        loginPage.checkElementsPresence();
    }

    @Ignore
    @Test(retryAnalyzer = com.qe.utils.RetryAnalyzer.class)
    public void openAndCloseIntercom() {
        if (!getIosTablet().equals("true")){
            getDriver().hideKeyboard();
        }
        if (getIosTablet().equals("true")){
            scrollDownByCoordinatesOnTablet();
        }
        intercomPage = loginPage.pressHelpButton();
        loginPage = intercomPage.pressCloseButton();
        loginPage.checkElementsPresence();
    }

    @Ignore
    @Test(retryAnalyzer = com.qe.utils.RetryAnalyzer.class)
    public void openAndCloseAssociateLogin() throws InterruptedException {
        if (getPlatform().equalsIgnoreCase("iOS") && !getIosTablet().equals("true")){
            getDriver().hideKeyboard();
        }
        if (getPlatform().equalsIgnoreCase("iOS") && getIosTablet().equals("true")){
            scrollDownByCoordinatesOnTablet();
        }
        loginPage.pressAssociateLoginButton()
                .pressBackButton();
        Thread.sleep(1000);
        if (getPlatform().equalsIgnoreCase("iOS") && !getIosTablet().equals("true")){
            getDriver().hideKeyboard();
        }
        if (getPlatform().equalsIgnoreCase("iOS") && getIosTablet().equals("true")){
            scrollDownByCoordinatesOnTablet();
        }
        loginPage.checkElementsPresence();
    }

}
