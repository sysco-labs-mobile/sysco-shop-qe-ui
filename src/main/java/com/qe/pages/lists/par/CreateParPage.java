package com.qe.pages.lists.par;

import com.qe.BaseTest;
import com.qe.pages.lists.ListSettingsPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CreateParPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Back")
    private MobileElement backButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private MobileElement parPageTitle;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/saveParGroup")
    private MobileElement saveButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/parGroupNameField")
    private MobileElement parGroupNameField;

    public CreateParPage inputParName(String inputParName) {
        sendKeys(parGroupNameField, inputParName, "Input par name " + inputParName);
        return new CreateParPage();
    }

    public ListSettingsPage pressSaveButton() {
        click(saveButton);
        return new ListSettingsPage();
    }

    public ListSettingsPage pressBackButton() {
        click(backButton);
        return new ListSettingsPage();
    }
}
