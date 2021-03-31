package com.qe.pages.lists.par;

import com.qe.BaseTest;
import com.qe.pages.lists.ListSettingsPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

public class CreateParPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Back")
    @iOSXCUITFindBy(id = "create par list back button")
    private MobileElement backButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Create New Par Group\"`]")
    private MobileElement parPageTitle;

    @AndroidFindBy(id = "saveParGroup")
    @iOSXCUITFindBy(id = "create par list save button")
    private MobileElement saveButton;

    @AndroidFindBy(id = "parGroupNameField")
    @iOSXCUITFindBy(id = "create par list text input text field")
    private MobileElement parGroupNameField;


    public CreateParPage checkElementsPresence() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(backButton.isDisplayed(), "backButton");
        softAssert.assertTrue(parPageTitle.isDisplayed(), "parPageTitle");
        softAssert.assertTrue(saveButton.isDisplayed(), "saveButton");
        softAssert.assertTrue(parGroupNameField.isDisplayed(), "parGroupNameField");
        softAssert.assertAll();
        return this;

    }
    public CreateParPage inputParName(String inputParName) {
        sendKeys(parGroupNameField, inputParName, "Input par name " + inputParName);
        return new CreateParPage();
    }

    public ListSettingsPage pressSaveButtonToReturnToSettingsPage() {
        click(saveButton,"saveButton");
        return new ListSettingsPage();
    }

    public SelectParPage pressSaveButtonToReturnToParSelectorPage() {
        click(saveButton,"saveButton");
        return new SelectParPage();
    }

    public ListSettingsPage pressBackButton() {
        click(backButton, "backButton");
        return new ListSettingsPage();
    }
}
