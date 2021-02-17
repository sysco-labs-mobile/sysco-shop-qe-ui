package com.qe.pages.lists;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

public class ListDeleteAlert extends BaseTest {
    TestUtils utils = new TestUtils();

    @iOSXCUITFindBy(id = "delete list alert")
    private MobileElement deleteListAlert;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/alertTitle")
    @iOSXCUITFindBy(id = "Delete ListLisshchchhchs")
    private MobileElement deleteListTitle;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/alertText")
    @iOSXCUITFindBy(id = "This action cannot be undone. Do you want to continue?")
    private MobileElement deleteListDescription;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/alertSecondaryButton")
    @iOSXCUITFindBy(id = "alert secondary")
    private MobileElement alertNoButton;

    @iOSXCUITFindBy(id = "no")
    private MobileElement alertNoButtonText;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/alertPrimaryButton")
    @iOSXCUITFindBy(id = "alert primary")
    private MobileElement alertYesButton;

    @iOSXCUITFindBy(id = "yes")
    private MobileElement alertYesButtonText;

    public void checkElementsPresence() {
        //Assert.assertTrue(deleteListTitle.isDisplayed());
        Assert.assertTrue(deleteListDescription.isDisplayed());
        Assert.assertTrue(alertNoButton.isDisplayed());
//        Assert.assertTrue(alertNoButtonText.isDisplayed());
        Assert.assertTrue(alertYesButton.isDisplayed());
//        Assert.assertTrue(alertYesButtonText.isDisplayed());
    }

    public ListsPage pressYes() {
        click(alertYesButton);
        return new ListsPage();
    }

    public ListSettingsPage pressNo() {
        click(alertNoButton);
        return new ListSettingsPage();
    }
}
