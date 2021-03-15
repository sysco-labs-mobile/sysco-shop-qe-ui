package com.qe.pages.lists.par;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ParSettingsPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Back")
    private MobileElement backButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private MobileElement parPageTitle;

    @AndroidFindBy(id = "saveProductList")
    private MobileElement saveButton;

    @AndroidFindBy(id = "parNameField")
    private MobileElement parGroupNameField;

    @AndroidFindBy(id = "deleteParGroupContainer")
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
