package com.qe.pages.discover;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

public class AccountSelectorPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.ImageButton")
    @iOSXCUITFindBy(id = "account selector close button")
    private MobileElement closeButton;

    @AndroidFindBy(id = "Sysco Shop Logo")
    @iOSXCUITFindBy(id = "account selector logo image")
    private MobileElement logo;

    @AndroidFindBy(id = "editText")
    @iOSXCUITFindBy(id = "account selector search input text field")
    private MobileElement accountSearchInputTextField;

    @iOSXCUITFindBy(id = "Search by Customer ID or name")
    private MobileElement accountSearchInputText;

    @AndroidFindBy(accessibility = "Filter")
    @iOSXCUITFindBy(id = "account selector filter button")
    private MobileElement filterButton;

    @AndroidFindBy(id = "numResultsForSearch")
    @iOSXCUITFindBy(id = "account selector show results label")
    private MobileElement accountCountLabel;
    //3 results for Monday  vs 5 total //Android: SHOWING 3 RESULTS
    // 1 result for salem //Android: SHOWING 1 RESULT FOR "SALEM"
    // Android: SHOWING 1 RESULT FOR "SALEM"

    @AndroidFindBy(id = "Cancel")
    @iOSXCUITFindBy(id = "Clear text")
    private MobileElement clearSearchText;

    @iOSXCUITFindBy(id = "salem")
    private MobileElement salemResultsLabel;//absent on android

    @AndroidFindBy(id = "customerList")
    @iOSXCUITFindBy(id = "accounts list")
    private MobileElement accountList;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'customerList')]/android.widget.LinearLayout[1]")
    @iOSXCUITFindBy(id = "account-0-0")
    private MobileElement firstItemInAccountList;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'customerList')]/android.widget.LinearLayout[5]")
    @iOSXCUITFindBy(id = "account-0-4")
    private MobileElement fifthItemInAccountList;


    public AccountSelectorPage checkElementsPresence() {
        utils.log().info("Check elements presence on Account Selector page");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(closeButton.isDisplayed(), "closeButton");
        softAssert.assertTrue(accountSearchInputTextField.isDisplayed(), "accountSearchInputTextField");
        softAssert.assertTrue(filterButton.isDisplayed(), "filterButton");
        softAssert.assertTrue(accountCountLabel.isDisplayed(), "accountCountLabel");
        softAssert.assertTrue(firstItemInAccountList.isDisplayed(), "firstItemInAccountList");
        if(getPlatform().equalsIgnoreCase("iOS")) {
            softAssert.assertTrue(accountSearchInputText.isDisplayed(), "firstItemInAccountList");
        }
        if(getPlatform().equalsIgnoreCase("Android")) {
            softAssert.assertEquals(accountSearchInputTextField.getText(),"Search by Customer ID or name");
        }
        softAssert.assertAll();
        return this;
    }

    public DiscoverPage pressOnFirstAccount() {
        click(firstItemInAccountList, "Press on first account on Account Selector page");
        return new DiscoverPage();
    }
}
