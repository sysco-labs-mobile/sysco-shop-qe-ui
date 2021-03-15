package com.qe.pages.discover;

import com.qe.BaseTest;
import com.qe.pages.login.ZipSwitcherPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

public class ZipSwitcherModal extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(id = "zip_entry_title")
    @iOSXCUITFindBy(id = "Zipcode")
    private MobileElement zipHeader;

    @AndroidFindBy(id = "zip_entry_subtitle")
    @iOSXCUITFindBy(id = "Tell us your zipcode so we can show you accurate inventory in your area!")
    private MobileElement zipModalDescription;

    @AndroidFindBy(id = "zip_code_entry_field")
    @iOSXCUITFindBy(id = "zip code text input text field")
    private MobileElement zipInputTextField;

    @AndroidFindBy(id = "cancel_button")
    @iOSXCUITFindBy(id = "cancel update zip code button")
    private MobileElement cancelButton;

    @AndroidFindBy(id = "update_button")
    @iOSXCUITFindBy(id = "update zip code button")
    private MobileElement updateButton;

    public ZipSwitcherModal checkElementsPresence() {
        utils.log().info("Check elements presence on Zip Switcher modal");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(zipHeader.isDisplayed(), "zipHeader");
        softAssert.assertTrue(zipModalDescription.isDisplayed(), "zipModalDescription");
        softAssert.assertTrue(zipInputTextField.isDisplayed(), "zipInputTextField");
        softAssert.assertTrue(cancelButton.isDisplayed(), "cancelButton");
        softAssert.assertTrue(updateButton.isDisplayed(), "updateButton");
        return this;
    }

    public ZipSwitcherModal inputZip(String inputZip) {
        sendKeys(zipInputTextField, inputZip, "Input zip " + inputZip);
        return this;
    }

    public DiscoverPage pressCancelButton() {
        click(cancelButton, "Press cancel button on Zip Switcher Modal");
        return new DiscoverPage();
    }

    public DiscoverPage pressUpdateButtonForAvailableZip() {
        click(updateButton, "Press update button on Zip Switcher Modal");
        return new DiscoverPage();
    }

    public ZipSwitcherPage pressUpdateButtonForUnavailableZip() {
        click(updateButton, "Press update button on Zip Switcher Modal for Unavailable Zip");
        return new ZipSwitcherPage();
    }

}
