package com.qe.pages.login;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LogOutUnsyncedChangesAlert extends BaseTest {
    TestUtils utils = new TestUtils();

    //Unsynced Changes
    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/alertTitle")
    private MobileElement unsyncedChangesTitle;

    //Pending and unsynced changes will be lost. Do you want to continue logging out?
    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/alertText")
    private MobileElement unsyncedChangesDescription;

    @iOSXCUITFindBy(id = "alert secondary")
    private MobileElement alertNoButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/alertSecondaryButton")
    private MobileElement alertNoButtonText;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/alertPrimaryButton")
    private MobileElement alertYesButton;
}
