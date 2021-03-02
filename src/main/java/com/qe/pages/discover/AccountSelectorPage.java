package com.qe.pages.discover;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AccountSelectorPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.ImageButton")
    @iOSXCUITFindBy(id = "account selector close button")
    private MobileElement closeButton;

    @AndroidFindBy(id = "Sysco Shop Logo")
    @iOSXCUITFindBy(id = "account selector logo image")
    private MobileElement logo;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/editText")
    @iOSXCUITFindBy(id = "account selector search input text field")
    private MobileElement accountSearchInputTextField;

    @iOSXCUITFindBy(id = "Search by Customer ID or name")
    private MobileElement accountSearchInputText;

    @AndroidFindBy(accessibility = "Filter")
    @iOSXCUITFindBy(id = "account selector filter button")
    private MobileElement filterButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/numResultsForSearch")
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

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/customerList")
    @iOSXCUITFindBy(id = "accounts list")
    private MobileElement accountList;

    //salem account on romith@gmail.com
    @AndroidFindBy(xpath = "//*[@resource-id=\"com.syscocorp.mss.enterprise.dev:id/customerList\"]/android.widget.LinearLayout[1]")
    @iOSXCUITFindBy(id = "account-0-0")
    private MobileElement firstItemInAccountList;

    //sodex account on romith@gmail.com
    @AndroidFindBy(xpath = "//*[@resource-id=\"com.syscocorp.mss.enterprise.dev:id/customerList\"]/android.widget.LinearLayout[5]")
    @iOSXCUITFindBy(id = "account-0-4")
    private MobileElement fifthItemInAccountList;

    //@iOSXCUITFindBy(id = "CHE 12791 SALEM STA CENTRAL0") Not usable as dynamic and test should be atomic and independent
    private MobileElement firstItemInListAccountHeader;

    //@iOSXCUITFindBy(id = "#017244")
    private MobileElement firstItemInListAccountNumber;

    //@iOSXCUITFindBy(id = "352 LAFAYETTE ST SALEM, MA 01970")
    private MobileElement firstItemInListAddress;

    public AccountSelectorPage checkElementsPresence() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(closeButton.isDisplayed());
        softAssert.assertTrue(accountSearchInputTextField.isDisplayed());
        softAssert.assertTrue(filterButton.isDisplayed());
        softAssert.assertTrue(accountCountLabel.isDisplayed());
        softAssert.assertTrue(firstItemInAccountList.isDisplayed());
        if(getPlatform().equalsIgnoreCase("iOS")) {
            softAssert.assertTrue(accountSearchInputText.isDisplayed());
        }
        if(getPlatform().equalsIgnoreCase("Android")) {
            softAssert.assertEquals(accountSearchInputTextField.getText(),"Search by Customer ID or name");
        }
        softAssert.assertAll();
        return this;
    }

    public DiscoverPage pressOnFirstAccount() {
        click(firstItemInAccountList);
        return new DiscoverPage();
    }
}
