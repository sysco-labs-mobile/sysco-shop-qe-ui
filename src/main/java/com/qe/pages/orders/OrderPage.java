package com.qe.pages.orders;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class OrderPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(id = "Back")
    private MobileElement backButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView[1]")
    private MobileElement navBarOrderName;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView[2]")
    private MobileElement navBarOrderNumber;

    @AndroidFindBy(accessibility = "More options")
    @iOSXCUITFindBy(id = "app nav dot menu button")
    private MobileElement threeDotButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/modifyOrder")
    @iOSXCUITFindBy(id = "order details modify order")
    private MobileElement modifyButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/orderInvoicedSeparately")
    @iOSXCUITFindBy(id = "order details invoice separate")
    private MobileElement invoiceCheckbox;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/priceLabel")
    @iOSXCUITFindBy(id = "case price label")
    private MobileElement firstItemCasePriceLabel;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/totalPriceLabel")
    @iOSXCUITFindBy(id = "total case price label")
    private MobileElement firstItemTotalCasePriceLabel;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/orderLineItemCountLabel")
    @iOSXCUITFindBy(id = "case quantity label")
    private MobileElement firstItemCaseQuantityLabel;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/title")
    @iOSXCUITFindBy(id = "Cancel Order")
    private MobileElement cancelOrderButton;

    @iOSXCUITFindBy(id = "Cancel")
    private MobileElement cancelButton;
}
