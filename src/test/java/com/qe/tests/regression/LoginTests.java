package com.qe.tests.regression;

import com.qe.BaseTest;
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
    AssociateLoginPage2 associateLoginPage2;
    AssociateLoginPage3 associateLoginPage3;
    TestUtils utils = new TestUtils();

    @BeforeMethod
    public void beforeMethod(Method m) {
        utils.log().info("\n       Starting test:" + m.getName());
        loginPage = new LoginPage();
        discoverPage = new DiscoverPage();
        associateLoginPage2 = new AssociateLoginPage2();
        associateLoginPage3 = new AssociateLoginPage3();
    }

    @Test @Ignore
    public void customerLogin() throws InterruptedException {
        loginPage.checkElementsPresence();
        loginPage.enterEmail(BaseTest.users.getJSONObject("customer").getString("email"));
        loginPage = loginPage.pressNextButton();
        loginPage.checkCustomerElementsPresence();
        loginPage.enterPassword(BaseTest.users.getJSONObject("customer").getString("password"));
        discoverPage = loginPage.pressLoginButton();
        discoverPage.checkElementsPresence();
    }

    @Test @Ignore
    public void multibuyerLogin() throws InterruptedException {
        loginPage.checkElementsPresence();
        loginPage.enterEmail(BaseTest.users.getJSONObject("multibuyer").getString("email"));
        loginPage = loginPage.pressNextButton();
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

    @Test @Ignore
    public void openAndClosePrivacyPage() {
        if (!getIosTablet().equals("true")){
            getDriver().hideKeyboard();
        }
        if (getPlatform().equalsIgnoreCase("iOS") && getIosTablet().equals("true")){
            scrollDownByCoordinatesOnTablet();
        }
        PrivacyPage privacyPage = loginPage.pressPrivacyButton();
        LoginPage loginPage = privacyPage.pressBackButton();
        loginPage.checkElementsPresence();
    }

    @Test
    public void associateLogin() {
        loginPage.enterEmailAssociate(BaseTest.users.getJSONObject("associate").getString("email"));
        getDriver().getKeyboard();
        associateLoginPage2.inputSyscoNetworkId(BaseTest.users.getJSONObject("associate").getString("networkId"));
        associateLoginPage2.pressNextButton();
        associateLoginPage3.inputPassword(BaseTest.users.getJSONObject("associate").getString("password"));
        associateLoginPage3.pressSignInButton();
        discoverPage.checkElementsPresence();
    }
}
