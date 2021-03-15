package com.qe.pages.login;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LogOutUnsyncedChangesAlert extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(id = "alertTitle")
    private MobileElement unsyncedChangesTitle;

    @AndroidFindBy(id = "alertText")
    private MobileElement unsyncedChangesDescription;

    @iOSXCUITFindBy(id = "alert secondary")
    private MobileElement alertNoButton;

    @AndroidFindBy(id = "alertSecondaryButton")
    private MobileElement alertNoButtonText;

    @AndroidFindBy(id = "alertPrimaryButton")
    private MobileElement alertYesButton;
}
