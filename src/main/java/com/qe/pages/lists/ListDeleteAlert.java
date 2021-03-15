package com.qe.pages.lists;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

public class ListDeleteAlert extends BaseTest {
    TestUtils utils = new TestUtils();

    @iOSXCUITFindBy(id = "delete list alert")
    private MobileElement deleteListAlert;

    @AndroidFindBy(id = "alertTitle")
    @iOSXCUITFindBy(id = "Delete ListLisshchchhchs")
    private MobileElement deleteListTitle;

    @AndroidFindBy(id = "alertText")
    @iOSXCUITFindBy(id = "This action cannot be undone. Do you want to continue?")
    private MobileElement deleteListDescription;

    @AndroidFindBy(id = "alertSecondaryButton")
    @iOSXCUITFindBy(id = "alert secondary")
    private MobileElement alertNoButton;

    @iOSXCUITFindBy(id = "no")
    private MobileElement alertNoButtonText;

    @AndroidFindBy(id = "alertPrimaryButton")
    @iOSXCUITFindBy(id = "alert primary")
    private MobileElement alertYesButton;

    @iOSXCUITFindBy(id = "yes")
    private MobileElement alertYesButtonText;

    public void checkElementsPresence() {
        utils.log().info("Check elements presence on List Delete alert");
        SoftAssert softAssert = new SoftAssert();
//      softAssert.assertTrue(deleteListTitle.isDisplayed());
        softAssert.assertTrue(deleteListDescription.isDisplayed());
        softAssert.assertTrue(alertNoButton.isDisplayed());
        softAssert.assertTrue(alertYesButton.isDisplayed());
        softAssert.assertAll();
    }

    public ListsPage pressYes() {
        click(alertYesButton, "Press yes on List Delete alert");
        return new ListsPage();
    }

    public ListSettingsPage pressNo() {
        click(alertNoButton, "Press no on List Delete alert");
        return new ListSettingsPage();
    }
}
