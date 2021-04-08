package com.qe.pages.login;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

public class AssociateLoginPage1 extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(id = "i0116")
    @iOSXCUITFindBy(accessibility = "Enter your email, phone, or Skype.")
    private MobileElement emailFieldInput;

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Back\"])[1]")
    private MobileElement backArrowButton;


    @AndroidFindBy(xpath = "//android.widget.Button[@text='Next']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Next']")
    private MobileElement nextButton;

    public void checkElementsPresence() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(backArrowButton.isDisplayed());
        softAssert.assertTrue(emailFieldInput.isDisplayed());
        softAssert.assertTrue(nextButton.isDisplayed());
        softAssert.assertAll();
    }

    public void pressBackButton() {
        click(backArrowButton);
    }

    public AssociateLoginPage1 inputEmail(String email) {
        click(emailFieldInput);
        sendKeys(emailFieldInput, email, "Input ma email " + email);
        click(nextButton);
        return new AssociateLoginPage1();
    }

    public void pressNextButton() {
        click(nextButton);
    }
}
