package com.qe.pages.login;

import com.qe.BaseTest;
import com.qe.pages.common.IntercomPage;
import com.qe.pages.common.PrivacyPage;
import com.qe.pages.discover.CreditCardModal;
import com.qe.pages.discover.DiscoverPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;

import static java.time.temporal.ChronoUnit.SECONDS;

public class LoginPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(id = "Sysco Shop Logo")
    @iOSXCUITFindBy(id = "shoplogo")
    private MobileElement shopLogo;

    @WithTimeout(time = 5, chronoUnit = SECONDS)
    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/loginTagline")
    @iOSXCUITFindBy(id = "Welcome back! To continue, please provide your email.") //changed in 2021.02.09
    private MobileElement loginTagline;

    @iOSXCUITFindBy(id = "Email*") //changed in 2021.02.09
    private MobileElement emailLabel;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/usernameField")
    @iOSXCUITFindBy(id = "Login Email Text Input") //changed in 2021.02.09
    private MobileElement emailTxtField;

    @iOSXCUITFindBy(id = "Password")
    private MobileElement passwordLabel;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/passwordField")
    @iOSXCUITFindBy(id = "Login Password Text Input")
    private MobileElement passwordTxtField;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/textinput_error")
    @iOSXCUITFindBy(id = "Invalid combination. Please try again.")
    private MobileElement invalidPasswordMessage;

    @iOSXCUITFindBy(id = "Network error. Please try again.")
    private MobileElement iosErrorMessage;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/textinput_error")
    private MobileElement androidErrorMessage;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/loginButton")
    @iOSXCUITFindBy(id = "Login Button")
    private MobileElement nextAndLoginButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/forgotMyPasswordLink")
    @iOSXCUITFindBy(id = "forgot password")
    private MobileElement forgotPasswordButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/dividerOr")
    @iOSXCUITFindBy(id = "OR")
    private MobileElement orLabel;

    @iOSXCUITFindBy(id = "Sysco Associate?") //changed in 2021.02.09
    private MobileElement syscoAssociateLabel;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/checkUsOutText")
    @iOSXCUITFindBy(id = "Check us out and join today!")
    private MobileElement guestTagline;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/maLoginLink")
    @iOSXCUITFindBy(id = "associate login here")
    private MobileElement associateLoginButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/becomeACustomerButton")
    @iOSXCUITFindBy(id = "become a customer button")
    private MobileElement becomeCustomerButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/continueAsGuestButton")
    @iOSXCUITFindBy(id = "Continue As Guest")
    private MobileElement continueAsGuestButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/typeLabel")
    @iOSXCUITFindBy(id = "©2019 All Rights Reserved. Sysco Corporation")
    private MobileElement rightsReservedLabel;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/privacyLink")
    @iOSXCUITFindBy(id = "privacy")
    private MobileElement privacyButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/helpLink")
    @iOSXCUITFindBy(id = "help")
    private MobileElement helpButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/loginVersion")
    private MobileElement appBuildVersion;

    /** Errors */
    @iOSXCUITFindBy(id = "User service error")
    private MobileElement userServiceError;


    public LoginPage checkElementsPresence(){
        waitForVisibility(emailTxtField, "emailTxtField");
        waitForVisibility(associateLoginButton, "associateLoginButton");
        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertTrue(shopLogo.isDisplayed());
//        softAssert.assertTrue(loginTagline.isDisplayed()); flaky in guest tests
//        softAssert.assertTrue(emailLabel.isDisplayed()); flaky in guest tests
        softAssert.assertTrue(emailTxtField.isDisplayed());
//        softAssert.assertTrue(syscoAssociateLabel.isDisplayed());
//        softAssert.assertTrue(guestTagline.isDisplayed());
        softAssert.assertTrue(associateLoginButton.isDisplayed());
//        softAssert.assertTrue(rightsReservedLabel.isDisplayed());
//        softAssert.assertTrue(privacyButton.isDisplayed());
//        softAssert.assertTrue(helpButton.isDisplayed());
        softAssert.assertAll();
        return this;
    }

    public LoginPage checkCustomerElementsPresence(){
//        waitForVisibility(loginTagline);

        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertTrue(shopLogo.isDisplayed());
//        softAssert.assertTrue(loginTagline.isDisplayed()); flaky
//        softAssert.assertTrue(emailLabel.isDisplayed());
        softAssert.assertTrue(emailTxtField.isDisplayed());
//        softAssert.assertTrue(passwordLabel.isDisplayed());
        softAssert.assertTrue(passwordTxtField.isDisplayed());
        softAssert.assertTrue(forgotPasswordButton.isDisplayed());
//        softAssert.assertTrue(orLabel.isDisplayed());
//        softAssert.assertTrue(syscoAssociateLabel.isDisplayed());
        softAssert.assertTrue(associateLoginButton.isDisplayed());
        //softAssert.assertTrue(rightsReservedLabel.isDisplayed()); hidden by keyboard
        //softAssert.assertTrue(privacyButton.isDisplayed());
        //softAssert.assertTrue(helpButton.isDisplayed());
        softAssert.assertAll();
        return this;
    }

    public LoginPage enterEmail(String email) {
        waitForVisibility(emailTxtField, "emailTxtField");
        sendKeys(emailTxtField, email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        sendKeys(passwordTxtField, password);
        return this;
    }

    public LoginPage checkInvalidPasswordMessagePresence() throws InterruptedException{
        Assert.assertTrue(invalidPasswordMessage.isDisplayed());
        return this;
    }

    public LoginPage checkElementsPresenceWhenNoInternet() {
        SoftAssert softAssert = new SoftAssert();
        if(getPlatform().equalsIgnoreCase("iOS")) {
            softAssert.assertTrue(iosErrorMessage.isDisplayed());
        }
        if(getPlatform().equalsIgnoreCase("Android")) {
            softAssert.assertTrue(androidErrorMessage.isDisplayed());
            softAssert.assertEquals(androidErrorMessage.getText(), "Network error. Please try again.");
        }
        softAssert.assertAll();
        return this;
    }

    public LoginPage pressNextButton(){
        waitForVisibility(nextAndLoginButton, "nextAndLoginButton");
        click(nextAndLoginButton);
        return new LoginPage();
    }

    public LoginPage ensurePasswordIsDisplayedOrRetryThreeTimes() {
        for(int i = 0; i < 3; i++) {
            if (!passwordTxtField.isDisplayed()) {
                click(nextAndLoginButton);
            }
        }
        return new LoginPage();
    }

    public DiscoverPage pressLoginButton() {
        click(nextAndLoginButton);
        return new DiscoverPage();
    }

    public DiscoverPage pressLoginButtonWithRetries() {
        click(nextAndLoginButton);
        try {
            if (userServiceError.getId() != null) {
                click(nextAndLoginButton);
            }
        } catch(NoSuchElementException noSuchElementException) {
            utils.log().info("Retried to login but caught " + noSuchElementException.getCause() + "\n" + Arrays.toString(noSuchElementException.getStackTrace()));
        }
        return new DiscoverPage();
    }

    public DiscoverPage ensureLoginSuccessOrRetryThreeTimes() {
        for(int i = 0; i < 3; i++) {
            try {
                if (nextAndLoginButton.isDisplayed()) {
                    click(nextAndLoginButton);
                    utils.log().info("retry login attempt: " + i);
                }
            } catch (NoSuchElementException noSuchElementException) {
                utils.log().info("retry login attempt went noSuchElementException: " + i);
            };
        }
        return new DiscoverPage();
    }

    public CreditCardModal pressLoginButtonForCreditCardUser() {
        click(nextAndLoginButton);
        return new CreditCardModal();
    }

    public ForgotPasswordPage pressForgotPasswordButton() {
        click(forgotPasswordButton);
        return new ForgotPasswordPage();
    }

    public PrivacyPage pressPrivacyButton() {
        click(privacyButton);
        return new PrivacyPage();
    }

    public IntercomPage pressHelpButton() {
        click(helpButton);
        return new IntercomPage();
    }

    public AssociateLoginPage1 pressAssociateLoginButton() {
        click(associateLoginButton);
        return new AssociateLoginPage1();
    }

    public void pressBecomeCustomerButton() {
        click(becomeCustomerButton);
        //todo: write util method to check webpage safari open and respective object
    }

    public ZipSwitcherPage pressContinueAsGuestButton() {
        click(continueAsGuestButton);
        return new ZipSwitcherPage();
    }
}
