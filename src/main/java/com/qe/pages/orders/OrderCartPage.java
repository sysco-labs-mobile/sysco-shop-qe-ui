package com.qe.pages.orders;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class OrderCartPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(id = "Back")
    private MobileElement backButton;

    //not on android
    @AndroidFindBy(accessibility = "More options")
    @iOSXCUITFindBy(id = "app nav dot menu button")
    private MobileElement orderDotMenuButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/title")
    @iOSXCUITFindBy(id = "Delete Order")
    private MobileElement deleteOrderButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/title")
    @iOSXCUITFindBy(id = "Cancel")
    private MobileElement cancelOrderButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView[1]")
    @iOSXCUITFindBy(id = "$32.97")
    private MobileElement navBarPriceValue;//dev env 4487633 barley Pearled 1#

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView[2]")
    @iOSXCUITFindBy(id = "1 CS | 0 EA")
    private MobileElement navBarCsAndEaValues;//dev env 4487633 barley Pearled 1#

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/editText")
    @iOSXCUITFindBy(id = "search filter view - search input")
    private MobileElement searchFilterTextInputField;

    @AndroidFindBy(id = "Filter")
    @iOSXCUITFindBy(id = "**/XCUIElementTypeButton[`label == \"filter\"`][1]")
    private MobileElement filterButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/proceedToCheckoutButton")
    @iOSXCUITFindBy(id = "proceed to checkout button")
    private MobileElement proceedToCheckoutButton;//getEnabled()

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/resultCount")
    private MobileElement filterResultCount;//android 1 LINE ITEM

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup")
    @iOSXCUITFindBy(id = "orderLineItem-0-0")
    private MobileElement orderLineItem1;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/productDescription")
    @iOSXCUITFindBy(id = "Barley Pearled 1#")
    private MobileElement orderLineItem1ProductTitle;
    //android Beef Ground Bulk 81%-19% Chub

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/productInfo")
    @iOSXCUITFindBy(id = "4487633 | 24/1 LB | JACK RABBIT")
    private MobileElement orderLineItem1ProductDescription;
    //android 0566709 | 4/5#AV | FIRE RIVER FARMS CLASSIC

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/priceLabel")
    @iOSXCUITFindBy(id = "$32.17 CS")
    private MobileElement orderLineItem1PricePerItem;
    //android CS (avg. 20.37LB) @ $2.652/LB

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/totalPriceLabel")
    @iOSXCUITFindBy(id = "$32.17")
    private MobileElement orderLineItem1PriceTotal;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/popupMenu")
    @iOSXCUITFindBy(id = "dot menu button")
    private MobileElement orderLineItem1DotMenuButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    @iOSXCUITFindBy(id = "Add to list")
    private MobileElement addToListButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    @iOSXCUITFindBy(id = "Remove item")
    private MobileElement removeItemButton;

    //not on android
    @iOSXCUITFindBy(id = "Cancel")
    private MobileElement cancelButton;


    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/addToCartMinus")
    @iOSXCUITFindBy(id = "decrease quantity button")
    private MobileElement decreaseQuantityButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/cartItemCount")
    @iOSXCUITFindBy(id = "quantity text field")
    private MobileElement quantityInputField;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/addToCartPlus")
    @iOSXCUITFindBy(id = "increase quantity button")
    private MobileElement increaseQuantityButton;

    public OrderCartReviewOrderPage pressProceedToCheckoutButton() {
        click(proceedToCheckoutButton);
        return new OrderCartReviewOrderPage();
    }
}