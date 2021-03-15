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
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Back\"`][1]")
    private MobileElement backButton;

    @AndroidFindBy(id = "i0116", priority = 0)
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[3]/android.view.View/android.view.View[4]/android.view.View/android.widget.EditText", priority = 1)
    @iOSXCUITFindBy(id = "Next")
    private MobileElement nextButton;

    public void checkElementsPresence() {
        SoftAssert softAssert = new SoftAssert();
        //softAssert.assertTrue(backArrowButton.isDisplayed());
        softAssert.assertTrue(emailFieldInput.isDisplayed());
        softAssert.assertTrue(backButton.isDisplayed());
        softAssert.assertTrue(nextButton.isDisplayed());
        softAssert.assertAll();
    }

    public LoginPage pressBackButton() {
        click(backButton);
        return new LoginPage();
    }

    public AssociateLoginPage1 inputEmail(String email) {
        click(emailFieldInput);
        sendKeys(emailFieldInput, email, "Input ma email " + email);
        click(backButton);
        return new AssociateLoginPage1();
    }

    public AssociateLoginPage2 pressNextButton() {
        click(nextButton);
        return new AssociateLoginPage2();
    }
}
