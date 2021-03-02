package com.qe.pages.login;
import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ForgotPasswordPage2 extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(id = "Back")
    private MobileElement backArrowButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.Button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Sysco | Reset Password\"]/XCUIElementTypeOther[1]")
    private MobileElement closeIconButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Email Sent!\"`]")
    private MobileElement emailSentLabel;

    public ForgotPasswordPage2 checkElementsPresence() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(emailSentLabel.isDisplayed());
        softAssert.assertTrue(backArrowButton.isDisplayed());
        softAssert.assertAll();
        return this;
    }
    public LoginPage pressBackArrowButton() {
        click(backArrowButton);
        return new LoginPage();
    }

    public LoginPage pressCloseButton() {
        click(closeIconButton);
        return new LoginPage();
    }
}
