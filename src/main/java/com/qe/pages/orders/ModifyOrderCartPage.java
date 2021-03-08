package com.qe.pages.orders;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ModifyOrderCartPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @iOSXCUITFindBy(id = "Back")
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private MobileElement backButton;

    @iOSXCUITFindBy(id = "app nav dot menu button")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    private MobileElement threeDotButton;


    //not present on android
    @iOSXCUITFindBy(id = "$32.97")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='$32.97']")
    private MobileElement navBarPriceValue;//dev env 4487633 barley Pearled 1#

    @iOSXCUITFindBy(id = "1 CS | 0 EA")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='1 CS | 0 EA']")
    private MobileElement navBarCsAndEaValues;//dev env 4487633 barley Pearled 1#

    @iOSXCUITFindBy(id = "search filter view - search input")
    @AndroidFindBy(id = "editText")
    private MobileElement searchFilterTextInputField;

    @iOSXCUITFindBy(id = "**/XCUIElementTypeButton[`label == \"filter\"`][1]")
    @AndroidFindBy(id = "groupBy")
    private MobileElement filterButton;

    @iOSXCUITFindBy(id = "Cancel")
    @AndroidFindBy(id = "cancelModifiedOrderChanges")
    private MobileElement cancelModificationButton;

    @iOSXCUITFindBy(id = "Proceed to Checkout")
    @AndroidFindBy(id = "proceedToCheckout")
    private MobileElement proceedToCheckoutButton;

    @iOSXCUITFindBy(id = "orderLineItem-0-0")
    private MobileElement orderLineItem1;

    @iOSXCUITFindBy(id = "Barley Pearled 1#")
    private MobileElement orderLineItem1ProductTitle;

    @iOSXCUITFindBy(id = "4487633 | 24/1 LB | JACK RABBIT")
    @AndroidFindBy(id = "productInfo")
    private MobileElement orderLineItem1ProductDescription;

    @iOSXCUITFindBy(id = "$32.17 CS")
    private MobileElement orderLineItem1PricePerItem;

    @iOSXCUITFindBy(id = "$32.17")
    private MobileElement orderLineItem1PriceTotal;

    @iOSXCUITFindBy(id = "dot menu button")
    private MobileElement orderLineItem1DotMenuButton;

    @iOSXCUITFindBy(id = "decrease quantity button")
    @AndroidFindBy(id = "addToCartMinus")
    private MobileElement decreaseQuantityButton;

    @iOSXCUITFindBy(id = "quantity text field")
    @AndroidFindBy(id = "cartItemCount")
    private MobileElement quantityInputField;

    @iOSXCUITFindBy(id = "increase quantity button")
    @AndroidFindBy(id = "addToCartPlus")
    private MobileElement increaseQuantityButton;


    public OrderCartReviewOrderPage pressProceedToCheckoutButton() {
        click(proceedToCheckoutButton);
        return new OrderCartReviewOrderPage();
    }
}
