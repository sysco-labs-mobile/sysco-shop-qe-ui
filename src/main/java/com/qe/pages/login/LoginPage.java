package com.qe.pages.login;

import com.qe.BaseTest;
import com.qe.pages.common.IntercomPage;
import com.qe.pages.common.PrivacyPage;
import com.qe.pages.discover.CreditCardModal;
import com.qe.pages.discover.DiscoverPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(id = "Sysco Shop Logo")
    @iOSXCUITFindBy(id = "shoplogo")
    private MobileElement shopLogo;

    @AndroidFindBy(id = "loginTagline")
    @iOSXCUITFindBy(id = "Welcome back! To continue, please provide your email.")
    private MobileElement loginTagline;

    @iOSXCUITFindBy(id = "Email*")
    private MobileElement emailLabel;

    @AndroidFindBy(id = "usernameField")
    @iOSXCUITFindBy(id = "Login Email Text Input")
    private MobileElement emailTxtField;

    @AndroidFindBy(id = "loginProgress")
    private MobileElement loginProgress;

    @iOSXCUITFindBy(id = "Password")
    private MobileElement passwordLabel;

    @AndroidFindBy(id = "passwordField")
    @iOSXCUITFindBy(id = "Login Password Text Input")
    private MobileElement passwordTxtField;

    @AndroidFindBy(id = "textinput_error")
    @iOSXCUITFindBy(id = "Invalid combination. Please try again.")
    private MobileElement invalidPasswordMessage;

    @iOSXCUITFindBy(id = "Network error. Please try again.")
    private MobileElement iosErrorMessage;

    @AndroidFindBy(id = "textinput_error")
    private MobileElement androidErrorMessage;

    @AndroidFindBy(id = "loginButton")
    @iOSXCUITFindBy(id = "Login Button")
    private MobileElement nextAndLoginButton;

    @AndroidFindBy(id = "forgotMyPasswordLink")
    @iOSXCUITFindBy(id = "forgot password")
    private MobileElement forgotPasswordButton;

    @AndroidFindBy(id = "dividerOr")
    @iOSXCUITFindBy(id = "OR")
    private MobileElement orLabel;

    @iOSXCUITFindBy(id = "Sysco Associate?")
    private MobileElement syscoAssociateLabel;

    @AndroidFindBy(id = "checkUsOutText")
    @iOSXCUITFindBy(id = "Check us out and join today!")
    private MobileElement guestTagline;

    @AndroidFindBy(id = "maLoginLink")
    @iOSXCUITFindBy(id = "associate login here")
    private MobileElement associateLoginButton;

    @AndroidFindBy(id = "becomeACustomerButton")
    @iOSXCUITFindBy(id = "become a customer button")
    private MobileElement becomeCustomerButton;

    @AndroidFindBy(id = "continueAsGuestButton")
    @iOSXCUITFindBy(id = "Continue As Guest")
    private MobileElement continueAsGuestButton;

    @AndroidFindBy(id = "typeLabel")
    @iOSXCUITFindBy(id = "©2019 All Rights Reserved. Sysco Corporation")
    private MobileElement rightsReservedLabel;

    @AndroidFindBy(id = "privacyLink")
    @iOSXCUITFindBy(id = "privacy")
    private MobileElement privacyButton;

    @AndroidFindBy(id = "helpLink")
    @iOSXCUITFindBy(id = "help")
    private MobileElement helpButton;

    @AndroidFindBy(id = "loginVersion")
    private MobileElement appBuildVersion;

    /** Errors */
    @iOSXCUITFindBy(id = "User service error")
    private MobileElement iosUserServiceError;


    public LoginPage checkElementsPresence(){
        utils.log().info("Check elements presence");
        waitForVisibility(emailTxtField, "emailTxtField");
        waitForVisibility(associateLoginButton, "associateLoginButton");
        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertTrue(shopLogo.isDisplayed());
//        softAssert.assertTrue(loginTagline.isDisplayed()); flaky in guest tests
//        softAssert.assertTrue(emailLabel.isDisplayed()); flaky in guest tests
        softAssert.assertTrue(emailTxtField.isDisplayed(), "emailTxtField");
        softAssert.assertTrue(associateLoginButton.isDisplayed(), "associateLoginButton");
        softAssert.assertAll();
        return this;
    }

    public LoginPage checkCustomerElementsPresence(){
        utils.log().info("Check Customer related elements presence");
        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertTrue(shopLogo.isDisplayed());
//        softAssert.assertTrue(loginTagline.isDisplayed()); flaky
//        softAssert.assertTrue(emailLabel.isDisplayed());
        softAssert.assertTrue(emailTxtField.isDisplayed(), "emailTxtField");
//        softAssert.assertTrue(passwordLabel.isDisplayed());
        softAssert.assertTrue(passwordTxtField.isDisplayed(), "passwordTxtField");
        softAssert.assertTrue(forgotPasswordButton.isDisplayed(), "forgotPasswordButton");
        softAssert.assertTrue(associateLoginButton.isDisplayed(), "associateLoginButton");
//        softAssert.assertTrue(rightsReservedLabel.isDisplayed()); hidden by keyboard
        softAssert.assertAll();
        return this;
    }

    public LoginPage enterEmail(String email) {
        if (getPlatform().equalsIgnoreCase("iOS") && !getIosTablet().equals("true")){
            utils.log().info("hiding keyboard start");
            getDriver().hideKeyboard();
            utils.log().info("hiding keyboard finished");
        }
        if (getPlatform().equalsIgnoreCase("iOS") && getIosTablet().equals("true")){
            scrollDownByCoordinatesOnTablet();
        }
        waitForVisibility(emailTxtField, "emailTxtField");
        sendKeys(emailTxtField, email, "Enter email " + email);
        if (getPlatform().equalsIgnoreCase("iOS") && !getIosTablet().equals("true")){
            utils.log().info("hiding keyboard start");
            getDriver().hideKeyboard();
            utils.log().info("hiding keyboard finished");
        }
        if (getPlatform().equalsIgnoreCase("iOS") && getIosTablet().equals("true")){
            scrollDownByCoordinatesOnTablet();
        }
        return this;
    }

    public LoginPage enterPassword(String password) {
        if (getPlatform().equalsIgnoreCase("iOS") && !getIosTablet().equals("true")){
            getDriver().hideKeyboard();
        }
        if (getPlatform().equalsIgnoreCase("iOS") && getIosTablet().equals("true")){
            scrollDownByCoordinatesOnTablet();
        }
        sendKeys(passwordTxtField, password);
        if (getPlatform().equalsIgnoreCase("iOS") && !getIosTablet().equals("true")){
            getDriver().hideKeyboard();
        }
        if (getPlatform().equalsIgnoreCase("iOS") && getIosTablet().equals("true")){
            scrollDownByCoordinatesOnTablet();
        }
        return this;
    }

    public LoginPage checkInvalidPasswordMessagePresence() {
        Assert.assertTrue(invalidPasswordMessage.isDisplayed());
        return this;
    }

    public LoginPage pressNextButton(){
        utils.log().info("Press next button");
        waitForVisibility(nextAndLoginButton, "nextAndLoginButton");
        click(nextAndLoginButton);
        //retry
        try {
            try {
                waitForVisibility(passwordTxtField, "passwordTxtField", 2);
            } catch (TimeoutException timeoutException) {
                click(nextAndLoginButton);
                utils.log().info("retry login attempt ");
            }
        } catch (NoSuchElementException noSuchElementException) {
            utils.log().info("retry login attempt went noSuchElementException: ");
        }
        return new LoginPage();
    }

    public DiscoverPage pressLoginButton() throws InterruptedException {
        click(nextAndLoginButton, "Press login button on Login page");
        return new DiscoverPage();
    }

    public CreditCardModal pressLoginButtonForCreditCardUser() {
        click(nextAndLoginButton, "Press login button for Credit card user on Login page");
        return new CreditCardModal();
    }

    public ForgotPasswordPage pressForgotPasswordButton() {
        click(forgotPasswordButton, "Press forgot password button on Login page");
        return new ForgotPasswordPage();
    }

    public PrivacyPage pressPrivacyButton() {
        click(privacyButton, "Press privacy button on Login page");
        return new PrivacyPage();
    }

    public IntercomPage pressHelpButton() {
        click(helpButton, "Press help button on Login Page");
        return new IntercomPage();
    }

    public AssociateLoginPage1 pressAssociateLoginButton() {
        click(associateLoginButton, "Press Associate login button on Login page");
        return new AssociateLoginPage1();
    }

    public void pressBecomeCustomerButton() {
        click(becomeCustomerButton, "PRess become customer button on Login Page");
    }

    public ZipSwitcherPage pressContinueAsGuestButton() {
        click(continueAsGuestButton, "Press continue as guest button on Login Page");
        return new ZipSwitcherPage();
    }
}
