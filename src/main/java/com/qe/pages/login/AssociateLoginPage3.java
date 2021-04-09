package com.qe.pages.login;

import com.qe.BaseTest;
import com.qe.pages.discover.DiscoverPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.Keys;
import org.testng.asserts.SoftAssert;

public class AssociateLoginPage3 extends BaseTest {
    TestUtils utils = new TestUtils();

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Back\"])[1]")
    private MobileElement backButton;

    @AndroidFindBy(xpath = ("//android.widget.EditText[@resource-id='password']"))
    @iOSXCUITFindBy(xpath = ("//XCUIElementTypeOther[@name='main']/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeSecureTextField"))
    private MobileElement password;

    @AndroidFindBy(xpath = ("//android.view.View[@resource-id='nextBtnField']"))
    @iOSXCUITFindBy(xpath = ("//XCUIElementTypeButton[@name='Sign in']"))
    private MobileElement signInButton;

    public AssociateLoginPage3 checkElementsPresence() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(backButton.isDisplayed());
        softAssert.assertTrue(password.isDisplayed());
        softAssert.assertTrue(signInButton.isDisplayed());
        softAssert.assertAll();
        return this;
    }

    public LoginPage pressBackArrowButton() {
        click(backButton);
        return new LoginPage();
    }

    public AssociateLoginPage3 inputPassword(String password) {
        click(this.password, "Press on password input field");
        sendKeys(this.password, password, "Input password");
        return this;
    }

    public DiscoverPage pressSignInButton() {
        if(!getIosTablet().equalsIgnoreCase("true")) {
            click(signInButton, "Press next button xpath");
        }
        if(getIosTablet().equalsIgnoreCase("true")) {
            utils.log().info("Sending enter key from passwordInputField");
            password.sendKeys(Keys.ENTER);
        }
        return new DiscoverPage();
    }
}
