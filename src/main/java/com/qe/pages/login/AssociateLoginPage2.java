package com.qe.pages.login;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.Keys;
import org.testng.asserts.SoftAssert;

public class AssociateLoginPage2 extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Back\"])[1]")
    private MobileElement backArrowButton;

    @AndroidFindBy(xpath = ("//android.widget.EditText[@resource-id='userInput']"))
    @iOSXCUITFindBy(xpath = ("//XCUIElementTypeStaticText[@name='Enter your Sysco Network ID:']"))
    private MobileElement syscoNetworkIdTextInput;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Next']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Next'])[1]")
    private MobileElement nextButton;

    public void checkElementsPresence() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(syscoNetworkIdTextInput.isDisplayed());
        softAssert.assertTrue(nextButton.isDisplayed());
        softAssert.assertAll();
    }

    public LoginPage pressBackArrowButton() {
        click(backArrowButton);
        return new LoginPage();
    }

    public AssociateLoginPage2 inputSyscoNetworkId(String syscoNetworkId) {
        sendKeys(syscoNetworkIdTextInput, syscoNetworkId, "Input sysco network id " + syscoNetworkId);
        return this;
    }

    public AssociateLoginPage3 pressNextButton() {
        if(!getIosTablet().equalsIgnoreCase("true")) {
            click(nextButton, "Press next button xpath");
        }
        if(getIosTablet().equalsIgnoreCase("true")) {
            utils.log().info("Starting to hide keyboard");
            getDriver().hideKeyboard();
            utils.log().info("Done with hiding keyboard");
            utils.log().info("Sending enter key from syscoNetworkIdTextInput");
            syscoNetworkIdTextInput.sendKeys(Keys.ENTER);
        }
        return new AssociateLoginPage3();
    }

}
