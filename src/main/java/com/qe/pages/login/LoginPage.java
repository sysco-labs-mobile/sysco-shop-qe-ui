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
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
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
        utils.log().info("Check elements presence");
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
        utils.log().info("Check Customer related elements presence");
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
//        softAssert.assertTrue(rightsReservedLabel.isDisplayed()); hidden by keyboard
//        softAssert.assertTrue(privacyButton.isDisplayed());
//        softAssert.assertTrue(helpButton.isDisplayed());
        softAssert.assertAll();
        return this;
    }

    public LoginPage enterEmail(String email) {
        waitForVisibility(emailTxtField, "emailTxtField");
        sendKeys(emailTxtField, email, "Enter email " + email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        sendKeys(passwordTxtField, password);
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

    public DiscoverPage pressLoginButton() {
        click(nextAndLoginButton, "Press login button on Login page");
        return new DiscoverPage();
    }

    public CreditCardModal pressLoginButtonForCreditCardUser() {
        click(nextAndLoginButton, "Press login button for Credit card user on Login page");
        //retry
        try {
            waitForInvisibility(nextAndLoginButton, "loginButton", 3);
        } catch (NoSuchElementException noSuchElementException) {
            utils.log().info("Login retry was not needed and lead to NoSuchElementException of login button");
        } catch (StaleElementReferenceException staleElementReferenceException) {
            utils.log().info("Login retry was not needed and lead to StaleElementReferenceException of login button");
        } catch (TimeoutException timeoutException) {
            utils.log().info("Login retry is needed because loginButton is still visible");
            click(nextAndLoginButton, "Retry login button on Login page");
        }

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
