package com.qe.pages.lists;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ListSettingsPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageButton")
    @iOSXCUITFindBy(id = "list settings close button")
    private MobileElement closeButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Create New List\"`]")
    private MobileElement createNewListHeader;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"List Settings\"`]")
    private MobileElement listSettingsHeader;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/saveProductList")
    @iOSXCUITFindBy(id = "list settings save button")
    private MobileElement saveListButton;

    @iOSXCUITFindBy(id = "List Name")
    private MobileElement listNameLabel;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/listNameField")
    @iOSXCUITFindBy(id = "list name input text field")
    private MobileElement listNameInputTextField;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/setAsDefaultListCheckbox")
    @iOSXCUITFindBy(id = "default list checkbox")
    private MobileElement defaultListCheckbox;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/productListPrivacyLabel")
    @iOSXCUITFindBy(id = "Privacy")
    private MobileElement privacyHeader;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/publicProductList")
    @iOSXCUITFindBy(id = "public setting")
    private MobileElement publicSettingButton;

    @iOSXCUITFindBy(id = "public setting - filled circle")
    private MobileElement publicSettingFilledSettingButton;

    @iOSXCUITFindBy(id = "public setting - empty circle")
    private MobileElement publicSettingEmptySettingButton;

    @iOSXCUITFindBy(id = "public")
    private MobileElement publicLabel;

    @iOSXCUITFindBy(id = "All users on the account can view")
    private MobileElement publicDescription;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/privateProductList")
    @iOSXCUITFindBy(id = "private setting")
    private MobileElement privateSettingButton;

    @iOSXCUITFindBy(id = "private setting - empty circle")
    private MobileElement privateSettingEmptyCircleButton;

    @iOSXCUITFindBy(id = "private setting - filled circle")
    private MobileElement privateSettingFilledCircleButton;

    @iOSXCUITFindBy(id = "private")
    private MobileElement privateLabel;

    @iOSXCUITFindBy(id = "Only you can view")
    private MobileElement privateDescription;

    @iOSXCUITFindBy(id = "Delete list")
    private MobileElement deleteListLabel;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/deleteListContainer")
    @iOSXCUITFindBy(id = "delete settings view delete button")
    private MobileElement deleteListButton;

    /** View By section */

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/productListViewByLabel")
    private MobileElement viewByHeader;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/uncategorized")
    private MobileElement uncategorizedSelector;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/syscoCategories")
    private MobileElement syscoCategoriesSelector;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/customCategories")
    private MobileElement customCategoriesSelector;


    /** Par section */

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/parManagementLabel")
    private MobileElement parManagementLabel;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/parManagementSwitch")
    private MobileElement parManagementSwitch;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/createNewParGroupContainer")
    private MobileElement createNewParGroupButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    private MobileElement firstParGroupButton;

    public ListSettingsPage checkElementsPresence() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(closeButton.isDisplayed());
        softAssert.assertTrue(createNewListHeader.isDisplayed());
        softAssert.assertTrue(saveListButton.isDisplayed());
//        softAssert.assertTrue(listNameLabel.isDisplayed());
        softAssert.assertTrue(listNameInputTextField.isDisplayed());
        softAssert.assertTrue(defaultListCheckbox.isDisplayed());
        softAssert.assertTrue(privacyHeader.isDisplayed());
        softAssert.assertTrue(publicSettingButton.isDisplayed());
//        softAssert.assertTrue(publicSettingFilledSettingButton.isDisplayed()); only ios
//        softAssert.assertTrue(publicLabel.isDisplayed());
//        softAssert.assertTrue(publicDescription.isDisplayed());
        softAssert.assertTrue(privateSettingButton.isDisplayed());
//        softAssert.assertTrue(privateSettingEmptyCircleButton.isDisplayed()); only ios
//        softAssert.assertTrue(privateLabel.isDisplayed());
//        softAssert.assertTrue(privateDescription.isDisplayed());
        softAssert.assertAll();
        return this;
    }

    public ListPage pressCloseButton() {
        click(closeButton);
        return new ListPage();
    }

    public ListsPage pressCloseButtonFromNewListPage() {
        click(closeButton);
        return new ListsPage();
    }

    public ListPage pressSaveListButton() {
        click(saveListButton);
        return new ListPage();
    }

    public ListSettingsPage clearListName() {
        listNameInputTextField.clear();
        return this;
    }

    public ListSettingsPage enterListName(String listName) {
        sendKeys(listNameInputTextField, listName, "Input list name " + listName);
        return this;
    }

    public void pressDefaultListCheckbox() {
        click(defaultListCheckbox);
    }

    public void pressPublicListOption() {
        click(publicSettingButton);
    }

    public void pressPrivateListOption() {
        click(privateSettingButton);
    }

    public ListDeleteAlert pressDeleteListButton() {
        click(deleteListButton);
        return new ListDeleteAlert();
    }
}
