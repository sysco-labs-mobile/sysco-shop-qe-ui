package com.qe.pages.orders;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

public class OrderCartOrderPlacedPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Open navigation drawer")
    @iOSXCUITFindBy(id = "app bar left button")
    private MobileElement navBarDrawerButton;

    @AndroidFindBy(id = "editText")
    @iOSXCUITFindBy(id = "app nav search bar text field")
    private MobileElement searchTextField;

    @AndroidFindBy(id = "action_cart")
    @iOSXCUITFindBy(id = "cart button")
    private MobileElement cartButton;

    @AndroidFindBy(id = "successTitle")
    @iOSXCUITFindBy(id = "Your order has been placed!")
    private MobileElement orderPlacedHeader;

    @AndroidFindBy(id = "sc_disclaimer")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"If any non-warehouse items existed in the order, contact your SC to verify the order. \"]")
    private MobileElement orderNoteText;

    @AndroidFindBy(id = "order_name")
    @iOSXCUITFindBy(id = "Order Summary")
    private MobileElement orderSummaryHeader;

    @AndroidFindBy(id = "order_number")
    private MobileElement androidOrderNumber;

    @AndroidFindBy(id = "order_quantity")
    @iOSXCUITFindBy(xpath = "//*[@name='Order Summary']/following-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement caseQuantityHeaderAndValue;

    @AndroidFindBy(id = "order_total")
    @iOSXCUITFindBy(xpath = "//*[@name='Order Summary']/following-sibling::XCUIElementTypeStaticText[2]")
    private MobileElement orderTotalHeaderAndValue;

    @AndroidFindBy(id = "delivery_date")
    @iOSXCUITFindBy(xpath = "//*[@name='Order Summary']/following-sibling::XCUIElementTypeStaticText[3]")
    private MobileElement deliveryHeaderAndValue;

    @AndroidFindBy(id = "view_in_orders_button")
    @iOSXCUITFindBy(id = "view in orders button")
    private MobileElement viewOrdersButton;

    public OrderCartOrderPlacedPage checkElementPresence() {
        utils.log().info("Check elements presence on Order Placed page");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(navBarDrawerButton.isDisplayed());
        softAssert.assertTrue(searchTextField.isDisplayed());
        softAssert.assertTrue(cartButton.isDisplayed());
        softAssert.assertTrue(orderPlacedHeader.isDisplayed());
        softAssert.assertTrue(orderNoteText.isDisplayed());
        softAssert.assertTrue(orderSummaryHeader.isDisplayed());
        softAssert.assertTrue(caseQuantityHeaderAndValue.isDisplayed());
        softAssert.assertTrue(orderTotalHeaderAndValue.isDisplayed());
        softAssert.assertTrue(deliveryHeaderAndValue.isDisplayed());
        softAssert.assertTrue(viewOrdersButton.isDisplayed());
        softAssert.assertTrue(orderSummaryHeader.getText().length() > 1);
        softAssert.assertTrue(deliveryHeaderAndValue.getText().length() > 1);
        if(getPlatform().equalsIgnoreCase("Android")) {
            softAssert.assertTrue(androidOrderNumber.isDisplayed());
            softAssert.assertTrue(androidOrderNumber.getText().length() > 1);
        }
        softAssert.assertAll();
        return this;
    }

    public OrderCartOrderPlacedPage checkElementPresence(String expectedTotalCount, String expectedAmount) {
        utils.log().info("Check elements presence on Order Placed page");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(caseQuantityHeaderAndValue.getText().contains(expectedTotalCount));
        softAssert.assertTrue(orderTotalHeaderAndValue.getText().contains(expectedAmount));
        softAssert.assertAll();
        return this;
    }

    public OrdersPage pressViewInOrdersButton() {
        click(viewOrdersButton);
        return new OrdersPage();
    }
}
