package com.qe.pages.login;

import com.qe.BaseTest;
import com.qe.pages.common.IntercomPage;
import com.qe.pages.common.PrivacyPage;
import com.qe.pages.discover.DiscoverPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

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

    public LoginPage checkElementsPresence(){
//        Assert.assertTrue(shopLogo.isDisplayed());
        //Assert.assertTrue(loginTagline.isDisplayed()); flaky in guest tests
        //Assert.assertTrue(emailLabel.isDisplayed()); flaky in guest tests
        Assert.assertTrue(emailTxtField.isDisplayed());
//        Assert.assertTrue(syscoAssociateLabel.isDisplayed());TODO: org.openqa.selenium.NoSuchElementException: Can't locate an element by this strategy: By.chained({By.id: Sysco Associate})
//        Assert.assertTrue(guestTagline.isDisplayed());
        Assert.assertTrue(associateLoginButton.isDisplayed());
//        Assert.assertTrue(rightsReservedLabel.isDisplayed());//TODO:
//        Assert.assertTrue(privacyButton.isDisplayed()); TODO:
//        Assert.assertTrue(helpButton.isDisplayed()); TODO:
        return this;
    }

    public LoginPage checkCustomerElementsPresence(){
//        waitForVisibility(loginTagline);
//        Assert.assertTrue(shopLogo.isDisplayed());
//        Assert.assertTrue(loginTagline.isDisplayed()); flaky
//        Assert.assertTrue(emailLabel.isDisplayed());
        Assert.assertTrue(emailTxtField.isDisplayed());
//        Assert.assertTrue(passwordLabel.isDisplayed());
        Assert.assertTrue(passwordTxtField.isDisplayed());
        Assert.assertTrue(forgotPasswordButton.isDisplayed());
//        Assert.assertTrue(orLabel.isDisplayed());
//        Assert.assertTrue(syscoAssociateLabel.isDisplayed());
        Assert.assertTrue(associateLoginButton.isDisplayed());
        //Assert.assertTrue(rightsReservedLabel.isDisplayed()); hidden by keyboard
        //Assert.assertTrue(privacyButton.isDisplayed());
        //Assert.assertTrue(helpButton.isDisplayed());
        return this;
    }

    public LoginPage enterEmail(String email) {
        waitForVisibility(emailTxtField);
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
        if(getPlatform().equalsIgnoreCase("iOS")) {
            Assert.assertTrue(iosErrorMessage.isDisplayed());
        }
        if(getPlatform().equalsIgnoreCase("Android")) {
            Assert.assertTrue(androidErrorMessage.isDisplayed());
            Assert.assertEquals(androidErrorMessage.getText(), "Network error. Please try again.");
        }
        return this;
    }

    public LoginPage pressNextButton(){
        waitForVisibility(nextAndLoginButton);
        click(nextAndLoginButton);
        return new LoginPage();
    }

    public DiscoverPage pressLoginButton() {
        click(nextAndLoginButton);
        return new DiscoverPage();
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
