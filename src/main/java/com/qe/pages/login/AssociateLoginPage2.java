package com.qe.pages.login;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

public class AssociateLoginPage2 extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(id = "back")
    private MobileElement backArrowButton;

    @AndroidFindBy(id = "userInput", priority = 0)
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.widget.EditText\n", priority = 1)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == \"Enter your Sysco Network ID:\"`]")
    private MobileElement syscoNetworkIdTextInput;

    @AndroidFindBy(id = "userNameFormSubmit", priority = 0)
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[3]/android.widget.Button", priority = 1)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Next\"`][1]")
    private MobileElement nextButton;

    public void checkElementsPresence() {
        SoftAssert softAssert = new SoftAssert();
        //softAssert.assertTrue(backArrowButton.isDisplayed());//Can't locate an element by this strategy: By.chained({By.id: back})
        softAssert.assertTrue(syscoNetworkIdTextInput.isDisplayed());
        softAssert.assertTrue(nextButton.isDisplayed());
        softAssert.assertAll();
    }

    public LoginPage pressBackArrowButton() {
        click(backArrowButton);
        return new LoginPage();
    }

    public AssociateLoginPage2 inputSyscoNetworkId(String syscoNetworkId) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sendKeys(syscoNetworkIdTextInput, syscoNetworkId, "Input sysco network id " + syscoNetworkId);
        return this;
    }

    public AssociateLoginPage3 pressNextButton() {
        click(nextButton);
        return new AssociateLoginPage3();
    }
}
