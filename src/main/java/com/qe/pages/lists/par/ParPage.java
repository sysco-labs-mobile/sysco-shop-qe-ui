package com.qe.pages.lists.par;

import com.qe.BaseTest;
import com.qe.pages.lists.ListSettingsPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

public class ParPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Back")
    @iOSXCUITFindBy(id = "edit par menu back button")
    private MobileElement closeButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'editProductListToolbar')]/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar")
    private MobileElement parNamePageTitle;

    @AndroidFindBy(id = "parSettingsContainer")
    @iOSXCUITFindBy(id = "Par Settings")
    private MobileElement parSettingsButton;

    @AndroidFindBy(id = "editParItemsContainer")
    @iOSXCUITFindBy(id = "Edit Par Items")
    private MobileElement editParItemsButton;

    public ParPage checkParName(String expectedParName) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(parNamePageTitle.isDisplayed());
        softAssert.assertEquals(parNamePageTitle.getText(), expectedParName);
        softAssert.assertAll();
        return this;
    }

    public ListSettingsPage pressBackButton() {
        click(closeButton);
        return new ListSettingsPage();
    }

    public ParSettingsPage pressParSettings() {
        click(parSettingsButton);
        return new ParSettingsPage();
    }

    public EditParPage pressEditParItemsButton() {
        click(editParItemsButton);
        return new EditParPage();
    }
}
