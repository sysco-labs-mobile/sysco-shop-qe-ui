package com.qe.pages.login;

import com.qe.BaseTest;
import com.qe.pages.discover.DiscoverPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AssociateLoginPage3 extends BaseTest {
    TestUtils utils = new TestUtils();

    @iOSXCUITFindBy(id = "Back")
    private MobileElement backArrowButton;

    @AndroidFindBy(id = "password", priority = 0)
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText", priority = 1)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"main\"`]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]")
    private MobileElement password;

    @AndroidFindBy(id = "signIn", priority = 0)
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[4]/android.widget.Button", priority = 1)
    @iOSXCUITFindBy(id = "Sign in")
    private MobileElement signInButton;

    public AssociateLoginPage3 checkElementsPresence() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(backArrowButton.isDisplayed());
        softAssert.assertTrue(password.isDisplayed());
        softAssert.assertTrue(signInButton.isDisplayed());
        softAssert.assertAll();
        return this;
    }

    public LoginPage pressBackArrowButton() {
        click(backArrowButton);
        return new LoginPage();
    }

    public AssociateLoginPage3 inputPassword(String password) {
        sendKeys(this.password, password, "Input password");
        return this;
    }

    public DiscoverPage pressSignInButton() {
        click(signInButton);
        return new DiscoverPage();
    }
}
