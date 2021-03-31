package com.qe.pages.lists.par;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ParSettingsPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Back")
    @iOSXCUITFindBy(id = "edit par list back button")
    private MobileElement backButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'editProductListToolbar')]/android.widget.TextView[1]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Par Settings\"")
    private MobileElement parPageTitle;

    @AndroidFindBy(id = "saveProductList")
    @iOSXCUITFindBy(id = "edit par list save button")
    private MobileElement saveButton;

    @AndroidFindBy(id = "parNameField")
    @iOSXCUITFindBy(id = "edit par list text input text field")
    private MobileElement parGroupNameField;

    @AndroidFindBy(id = "deleteParGroupContainer")
    @iOSXCUITFindBy(id = "delete settings view delete button")
    private MobileElement deleteParButton;

    public ParSettingsPage inputParName(String inputParName) {
        sendKeys(parGroupNameField, inputParName, "Input par name " + inputParName);
        return new ParSettingsPage();
    }

    public ParPage pressSaveButton() {
        click(saveButton);
        return new ParPage();
    }

    public ParPage pressBackButton() {
        click(backButton);
        return new ParPage();
    }

    public DeleteParModal pressDeleteParButton() {
        click(deleteParButton);
        return new DeleteParModal();
    }
}
