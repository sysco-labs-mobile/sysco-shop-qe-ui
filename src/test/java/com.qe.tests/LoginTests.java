package com.qe.tests;

import com.qe.BaseTest;
import com.qe.pages.common.IntercomPage;
import com.qe.pages.common.PrivacyPage;
import com.qe.pages.discover.DiscoverPage;
import com.qe.pages.login.*;
import com.qe.utils.TestUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class LoginTests extends BaseTest {
    LoginPage loginPage;
    DiscoverPage discoverPage;
    ForgotPasswordPage forgotPasswordPage;
    TestUtils utils = new TestUtils();

    @BeforeMethod
    public void beforeMethod(Method m) {
        utils.log().info("******  Starting test:" + m.getName() + "    ******" + "\n");
        loginPage = new LoginPage();
        discoverPage = new DiscoverPage();
    }

    @Test
    public void customerLogin() {
        loginPage.checkElementsPresence();
        loginPage.enterEmail(BaseTest.users.getJSONObject("customer").getString("email"));
        loginPage = loginPage.pressNextButton();

        loginPage.checkCustomerElementsPresence();
        loginPage.enterPassword(BaseTest.users.getJSONObject("customer").getString("password"));
        discoverPage = loginPage.pressLoginButton();
        discoverPage.checkElementsPresence();
    }

    @Test
    public void multibuyerLogin() {
        loginPage.checkElementsPresence();
        loginPage.enterEmail(BaseTest.users.getJSONObject("multibuyer").getString("email"));
        loginPage = loginPage.pressNextButton();
        getDriver().hideKeyboard();
        loginPage.checkCustomerElementsPresence();
        loginPage.enterPassword(BaseTest.users.getJSONObject("multibuyer").getString("password"));
        discoverPage = loginPage.pressLoginButton();
        discoverPage.checkElementsPresence();
        if(getPlatform().equalsIgnoreCase("iOS")) {
            discoverPage.checkElementsPresenceForAccountSelector(BaseTest.users.getJSONObject("multibuyer").getString("iOSDefaultAccountTitle"));
        }
        if(getPlatform().equalsIgnoreCase("Android")) {
            discoverPage.checkElementsPresenceForAccountSelector(BaseTest.users.getJSONObject("multibuyer").getString("AndroidDefaultAccountTitle"));
        }
    }

    @Test @Ignore
    public void loginInvalidPassword() throws InterruptedException {
        loginPage.enterEmail(users.getJSONObject("customerInvalidPassword").getString("email"));
        loginPage = loginPage.pressNextButton();
        loginPage.enterPassword(users.getJSONObject("customerInvalidPassword").getString("password"));
        loginPage.checkInvalidPasswordMessagePresence();
    }

    @Test(groups = { "WebView" })
    public void openAndCloseForgotPassword() {
        loginPage.enterEmail(users.getJSONObject("customerInvalidPassword").getString("email"));
        loginPage = loginPage.pressNextButton();
        getDriver().hideKeyboard();
        forgotPasswordPage = loginPage.pressForgotPasswordButton();
        //forgotPasswordPage.checkElementsPresence();
        LoginPage loginPage = forgotPasswordPage.pressBackArrowButton();
        loginPage.checkElementsPresence();
    }

    @Test
    public void openAndCloseIntercom() {
        getDriver().hideKeyboard();
        IntercomPage intercomPage = loginPage.pressHelpButton();
        LoginPage loginPage = intercomPage.pressCloseButton();
        loginPage.checkElementsPresence();
    }

    @Test @Ignore
    public void openAndClosePrivacyPage() {
        getDriver().hideKeyboard();
        PrivacyPage privacyPage = loginPage.pressPrivacyButton();
        LoginPage loginPage = privacyPage.pressBackButton();
        loginPage.checkElementsPresence();
    }

    @Test(groups = { "WebView" }) @Ignore
    public void associateLogin() {
        AssociateLoginPage1 associateLoginPage1 = loginPage.pressAssociateLoginButton();
        associateLoginPage1.inputEmail(BaseTest.users.getJSONObject("associate").getString("email"));
        AssociateLoginPage2 associateLoginPage2 = associateLoginPage1.pressNextButton();
        associateLoginPage2.checkElementsPresence();
        associateLoginPage2.inputSyscoNetworkId(BaseTest.users.getJSONObject("associate").getString("networkId"));
        AssociateLoginPage3 associateLoginPage3 = associateLoginPage2.pressNextButton();
        associateLoginPage3.checkElementsPresence();
        associateLoginPage3.inputPassword(BaseTest.users.getJSONObject("associate").getString("password"));
        DiscoverPage discoverPage = associateLoginPage3.pressSignInButton();
        discoverPage.checkElementsPresence();
    }

    @Test(groups = { "WebView" })
    public void openAndCloseAssociateLogin() {
        loginPage.pressAssociateLoginButton()
                .pressBackButton()
                .checkElementsPresence();
    }
}
