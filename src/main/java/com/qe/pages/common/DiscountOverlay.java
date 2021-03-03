package com.qe.pages.common;

import com.qe.BaseTest;
import com.qe.pages.search.SearchCatalogPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;


public class DiscountOverlay extends BaseTest {
    TestUtils utils = new TestUtils();

    @iOSXCUITFindBy(id = "tooltip close")
    private MobileElement closeButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Price includes:\"]/preceding-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement priceHeader;

    @iOSXCUITFindBy(id = "Price includes:")
//    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Price includes:\"`]")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Price includes:\"]")
    private MobileElement priceIncludesHeader;

    @iOSXCUITFindBy(id = "New Customer Savings")
//    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"New Customer Savings\"`]")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"New Customer Savings\"]")
    private MobileElement newCustomerSavingsHeader;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"New Customer Savings\"]/following-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement newCustomerSavingsValue;

    public DiscountOverlay checkElementsPresence(String expectedPrice, String expectedNewCustomerSavings) {
        utils.log().info("Check elements presence on Discount overlay modal");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(closeButton.isDisplayed());
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
        click(closeButton, "Press ok on Discount overlay modal");
        return new SearchCatalogPage();
    }
}
