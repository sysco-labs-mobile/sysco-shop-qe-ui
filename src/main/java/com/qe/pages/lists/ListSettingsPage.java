package com.qe.pages.lists;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
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

    @AndroidFindBy(id = "saveProductList")
    @iOSXCUITFindBy(id = "list settings save button")
    private MobileElement saveListButton;

    @iOSXCUITFindBy(id = "List Name")
    private MobileElement listNameLabel;

    @AndroidFindBy(id = "listNameField")
    @iOSXCUITFindBy(id = "list name input text field")
    private MobileElement listNameInputTextField;

    @AndroidFindBy(id = "setAsDefaultListCheckbox")
    @iOSXCUITFindBy(id = "default list checkbox")
    private MobileElement defaultListCheckbox;

    @AndroidFindBy(id = "productListPrivacyLabel")
    @iOSXCUITFindBy(id = "Privacy")
    private MobileElement privacyHeader;

    @AndroidFindBy(id = "publicProductList")
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

    @AndroidFindBy(id = "privateProductList")
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

    @AndroidFindBy(id = "deleteListContainer")
    @iOSXCUITFindBy(id = "delete settings view delete button")
    private MobileElement deleteListButton;

    /** View By section */

    @AndroidFindBy(id = "productListViewByLabel")
    private MobileElement viewByHeader;

    @AndroidFindBy(id = "uncategorized")
    private MobileElement uncategorizedSelector;

    @AndroidFindBy(id = "syscoCategories")
    private MobileElement syscoCategoriesSelector;

    @AndroidFindBy(id = "customCategories")
    private MobileElement customCategoriesSelector;


    /** Par section */

    @AndroidFindBy(id = "parManagementLabel")
    private MobileElement parManagementLabel;

    @AndroidFindBy(id = "parManagementSwitch")
    private MobileElement parManagementSwitch;

    @AndroidFindBy(id = "createNewParGroupContainer")
    private MobileElement createNewParGroupButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    private MobileElement firstParGroupButton;

    public ListSettingsPage checkElementsPresence() {
        utils.log().info("Check elements presence on List Settings Page");
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
        softAssert.assertTrue(privateSettingButton.isDisplayed());
//        softAssert.assertTrue(privateSettingEmptyCircleButton.isDisplayed()); only ios
        softAssert.assertAll();
        return this;
    }

    public ListPage pressCloseButton() {
        click(closeButton, "Press close button on List Settings page");
        return new ListPage();
    }

    public ListsPage pressCloseButtonFromNewListPage() {
        click(closeButton,"Press close button on New List page");
        return new ListsPage();
    }

    public ListPage pressSaveListButton() {
        click(saveListButton, "Press save list button on List Settings page");
        return new ListPage();
    }

    public ListSettingsPage clearListName() {
        utils.log().info("Clear list name from text field on List Settings page");
        listNameInputTextField.clear();
        return this;
    }

    public ListSettingsPage enterListName(String listName) {
        sendKeys(listNameInputTextField, listName, "Input list name " + listName);
        return this;
    }

    public void pressDefaultListCheckbox() {
        click(defaultListCheckbox, "Toggle Default list checkbox on List Settings Page");
    }

    public void pressPublicListOption() {
        click(publicSettingButton, "Toggle public settings option on List Settings page");
    }

    public void pressPrivateListOption() {
        click(privateSettingButton, "Toggle private settings option on List Settings page");
    }

    public ListDeleteAlert pressDeleteListButton() {
        click(deleteListButton, "Press delete list button on List Settings page");
        return new ListDeleteAlert();
    }
}
