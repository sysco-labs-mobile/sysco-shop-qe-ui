package com.qe.pages.login;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.Set;

public class ForgotPasswordPage extends BaseTest {
    TestUtils utils = new TestUtils();


    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(id = "Back")
    private MobileElement backArrowButton;

    @AndroidFindBy(xpath = "//div[@id=\"root\"]/div/div[1]/div/span")
    //"**/XCUIElementTypeOther[`label == \"Sysco | Reset Password\"`]/XCUIElementTypeOther[1]"
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Sysco | Reset Password\"]/XCUIElementTypeOther[1]")
    private MobileElement closeIconButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.Button")
    //iOSClassChain = "**/XCUIElementTypeButton[`label == "close icon"`]"
    @iOSXCUITFindBy(id = "close icon")
    private MobileElement closeIcon;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == \"Email*\"`]", priority = 1)
    private MobileElement emailInputTextField;

    @AndroidFindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[4]/android.widget.Button")
    @iOSXCUITFindBy(id = "Request Password Reset")
    private MobileElement requestPasswordResetButton;

    public void checkElementsPresence() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(emailInputTextField.isDisplayed());
        softAssert.assertTrue(backArrowButton.isDisplayed());
        softAssert.assertAll();
    }

    public LoginPage pressBackArrowButton() {
        click(backArrowButton);
        return new LoginPage();
    }

    public LoginPage pressCloseButton() {
        click(closeIconButton);
        return new LoginPage();
    }

    public LoginPage pressCloseIcon() {
        click(closeIcon);
        return new LoginPage();
    }

    public ForgotPasswordPage inputEmail(String email) {
        if(getPlatform().equalsIgnoreCase("iOS")) {
            sendKeys(emailInputTextField, email, "Input reset email " + email);
        }
        if(getPlatform().equalsIgnoreCase("Android")) {
            Set<String> contextNames = getDriver().getContextHandles();
            for (String contextName : contextNames) {
                utils.log().info("Context: " + contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
            }
            getDriver().context((String) contextNames.toArray()[1]); // set context to WEBVIEW_1

            WebElement webEmailInputTextField = getDriver().findElement(By.className("android.widget.EditText"));
            webEmailInputTextField.sendKeys(email);
        }
        return new ForgotPasswordPage();
    }

    public ForgotPasswordPage2 pressRequestPasswordResetButton() {
        if(getPlatform().equalsIgnoreCase("iOS")) {
            click(requestPasswordResetButton, "Press request password reset button");
        }
        if(getPlatform().equalsIgnoreCase("Android")) {
            WebElement webRequestPasswordResetButton = getDriver().findElement(By.xpath("//*[text()='Request Password Reset']"));
            webRequestPasswordResetButton.click();
        }
        return new ForgotPasswordPage2();
    }

}
