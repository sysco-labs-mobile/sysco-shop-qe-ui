package com.qe.pages.discover;

import com.qe.BaseTest;
import com.qe.pages.login.ZipSwitcherPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ZipSwitcherModal extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/zip_entry_title")
    @iOSXCUITFindBy(id = "Zipcode")
    private MobileElement zipHeader;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/zip_entry_subtitle")
    @iOSXCUITFindBy(id = "Tell us your zipcode so we can show you accurate inventory in your area!")
    private MobileElement zipModalDiscription;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/zip_code_entry_field")
    @iOSXCUITFindBy(id = "zip code text input text field")
    private MobileElement zipInputTextField;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/cancel_button")
    @iOSXCUITFindBy(id = "cancel update zip code button")
    private MobileElement cancelButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/update_button")
    @iOSXCUITFindBy(id = "update zip code button")
    private MobileElement updateButton;

    public ZipSwitcherModal inputZip(String inputZip) {
        sendKeys(zipInputTextField, inputZip, "Input zip " + inputZip);
        return this;
    }

    public DiscoverPage pressCancelButton() {
        click(cancelButton);
        return new DiscoverPage();
    }

    public DiscoverPage pressUpdateButtonForAvailableZip() {
        click(updateButton);
        return new DiscoverPage();
    }

    public ZipSwitcherPage pressUpdateButtonForUnavailableZip() {
        click(updateButton);
        return new ZipSwitcherPage();
    }

}
