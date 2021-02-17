package com.qe.pages.orders;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

public class OrderCartOrderPlacedPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Open navigation drawer")
    @iOSXCUITFindBy(id = "app bar left button")
    private MobileElement navBarDrawerButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/editText")
    @iOSXCUITFindBy(id = "app nav search bar text field")
    private MobileElement searchTextField; //getValue contains search input

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/action_cart")
    @iOSXCUITFindBy(id = "cart button")
    private MobileElement cartButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/successTitle")
    @iOSXCUITFindBy(id = "Your order has been placed!")
    private MobileElement orderPlacedHeader;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/sc_disclaimer")
    @iOSXCUITFindBy(id = "If any non-warehouse items existed in the order, contact your SC to verify the order.")
    private MobileElement orderNoteText;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/order_name")
    @iOSXCUITFindBy(id = "Order Summary")
    private MobileElement orderSummaryHeader;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/order_number")
    private MobileElement orderNumber;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/order_quantity")
    @iOSXCUITFindBy(id = "Case Qty: 1 CS")
    private MobileElement caseQuantityHeaderAndValue;
    //android 1 CS | 0 EA

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/order_total")
    @iOSXCUITFindBy(id = "Total: $32.97")
    private MobileElement orderTotalHeaderAndValue;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/delivery_date")
    @iOSXCUITFindBy(id = "Delivery: Friday 02/05/2021")
    private MobileElement deliveryHeaderAndValue;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/view_in_orders_button")
    @iOSXCUITFindBy(id = "view in orders button")
    private MobileElement viewOrdersButton;

    public OrderCartOrderPlacedPage checkElementPresence() {
        Assert.assertTrue(orderPlacedHeader.isDisplayed());
        return this;
    }
}
