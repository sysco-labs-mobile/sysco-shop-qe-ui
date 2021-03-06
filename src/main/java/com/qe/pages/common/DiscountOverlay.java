package com.qe.pages.common;

import com.qe.BaseTest;
import com.qe.pages.search.SearchCatalogPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;


public class DiscountOverlay extends BaseTest {
    TestUtils utils = new TestUtils();

    @iOSXCUITFindBy(id = "tooltip close")
    private MobileElement closeButton;

    @AndroidFindBy(id = "discounted_price")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Price includes:\"]/preceding-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement priceHeader;

    @AndroidFindBy(id = "price_includes_header")
    @iOSXCUITFindBy(id = "Price includes:")
    private MobileElement priceIncludesHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='New Customer Savings']")
    @iOSXCUITFindBy(id = "New Customer Savings")
    private MobileElement newCustomerSavingsHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='New Customer Savings']/following-sibling::android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"New Customer Savings\"]/following-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement newCustomerSavingsValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bulk Discount']")
    @iOSXCUITFindBy(id = "Bulk Discount")
    private MobileElement bulkDiscountHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bulk Discount']/following-sibling::android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Bulk Discount\"]/following-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement bulkDiscountValue;

    public DiscountOverlay checkElementsPresenceForNewCustomerWelcome(String expectedPrice, String expectedNewCustomerSavings) {
        utils.log().info("Check elements presence on Discount overlay modal");
        SoftAssert softAssert = new SoftAssert();
        if(getPlatform().equalsIgnoreCase("iOS")) {
            softAssert.assertTrue(closeButton.isDisplayed());
        }
        softAssert.assertTrue(priceHeader.isDisplayed());
        softAssert.assertTrue(priceIncludesHeader.isDisplayed());
        softAssert.assertTrue(newCustomerSavingsHeader.isDisplayed());
        softAssert.assertTrue(newCustomerSavingsValue.isDisplayed());
        softAssert.assertEquals(priceHeader.getText(), expectedPrice);
        softAssert.assertEquals(newCustomerSavingsValue.getText(), expectedNewCustomerSavings);
        softAssert.assertAll();
        return this;
    }

    public SearchCatalogPage pressCloseButtonToReturnToSearchPage() {
        if(getPlatform().equalsIgnoreCase("iOS")) {
            click(closeButton, "Press ok on Discount overlay modal");
        }
        if(getPlatform().equalsIgnoreCase("Android")) {
            clickAndroidBackButton();
        }
        return new SearchCatalogPage();
    }
}