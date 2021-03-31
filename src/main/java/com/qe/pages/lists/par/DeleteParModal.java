package com.qe.pages.lists.par;

import com.qe.BaseTest;
import com.qe.pages.lists.ListPage;
import com.qe.pages.lists.ListSettingsPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class DeleteParModal extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(id = "alertTitle")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"edit par list delete alert\"]/XCUIElementTypeOther/XCUIElementTypeStaticText")
    private MobileElement modalTitle;

    @AndroidFindBy(id = "alertText")
    @iOSXCUITFindBy(id = "This action cannot be undone. Do you want to continue?")
    private MobileElement modalDescription;

    @AndroidFindBy(id = "alertSecondaryButton")
    @iOSXCUITFindBy(id = "alert secondary")
    private MobileElement noButton;

    @AndroidFindBy(id = "alertPrimaryButton")
    @iOSXCUITFindBy(id = "alert primary")
    private MobileElement yesButton;

    public ListSettingsPage pressYesButton() {
        click(yesButton);
        return new ListSettingsPage();
    }

    public ParSettingsPage pressNoButton() {
        click(noButton);
        return new ParSettingsPage();
    }
}
