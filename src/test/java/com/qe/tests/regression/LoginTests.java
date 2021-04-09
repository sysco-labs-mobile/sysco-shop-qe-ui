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

    @Test(retryAnalyzer = com.qe.utils.RetryAnalyzer.class)
    public void associateLoginCxmobile003() throws InterruptedException {
        loginPage.enterEmailAssociate(BaseTest.users.getJSONObject("associate3").getString("email"));
        getDriver().getKeyboard();

        if(getPlatform().equalsIgnoreCase("Android")){
            Thread.sleep(10000);
            associateLoginPage2.inputSyscoNetworkId(BaseTest.users.getJSONObject("associate3").getString("networkId"));
        }
        if(getPlatform().equalsIgnoreCase("iOS")){
            Thread.sleep(14000);
            associateLoginPage2.inputSyscoNetworkId(BaseTest.users.getJSONObject("associate3").getString("networkId"));
        }
        associateLoginPage2.pressNextButton();
        Thread.sleep(4000);
        associateLoginPage3.inputPassword(BaseTest.users.getJSONObject("associate3").getString("password"));
        associateLoginPage3.pressSignInButton();
        if(getPlatform().equalsIgnoreCase("Android")){
            Thread.sleep(115000);
            utils.log().info("Waited 115 sec");
        }
        if(getPlatform().equalsIgnoreCase("iOS")){
            Thread.sleep(30000);
        }
        discoverPage.checkElementsPresence();
    }

    @Ignore
    @Test(retryAnalyzer = com.qe.utils.RetryAnalyzer.class)
    public void associateLoginCxmobile001() throws InterruptedException {
        loginPage.enterEmailAssociate(BaseTest.users.getJSONObject("associate").getString("email"));
        getDriver().getKeyboard();

        if(getPlatform().equalsIgnoreCase("Android")){
            Thread.sleep(10000);
            associateLoginPage2.inputSyscoNetworkId(BaseTest.users.getJSONObject("associate").getString("networkId"));
        }
        if(getPlatform().equalsIgnoreCase("iOS")){
            Thread.sleep(14000);
            associateLoginPage2.inputSyscoNetworkId(BaseTest.users.getJSONObject("associate").getString("networkId"));
        }
        associateLoginPage2.pressNextButton();
        Thread.sleep(4000);
        associateLoginPage3.inputPassword(BaseTest.users.getJSONObject("associate").getString("password"));
        associateLoginPage3.pressSignInButton();
        if(getPlatform().equalsIgnoreCase("Android")){
            Thread.sleep(210000);
            utils.log().info("Waited 210 sec");
        }
        if(getPlatform().equalsIgnoreCase("iOS")){
            Thread.sleep(30000);
        }
        discoverPage.checkElementsPresence();
    }
}
