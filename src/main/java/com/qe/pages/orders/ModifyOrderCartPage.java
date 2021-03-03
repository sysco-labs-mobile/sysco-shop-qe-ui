package com.qe.pages.orders;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ModifyOrderCartPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @iOSXCUITFindBy(id = "Back")
    private MobileElement backButton;

    @iOSXCUITFindBy(id = "app nav dot menu button")
    private MobileElement threeDotButton;

    //not present on android
    @iOSXCUITFindBy(id = "$32.97")
    private MobileElement navBarPriceValue;//dev env 4487633 barley Pearled 1#

    @iOSXCUITFindBy(id = "1 CS | 0 EA")
    private MobileElement navBarCsAndEaValues;//dev env 4487633 barley Pearled 1#

    @iOSXCUITFindBy(id = "search filter view - search input")
    private MobileElement searchFilterTextInputField;

    @iOSXCUITFindBy(id = "**/XCUIElementTypeButton[`label == \"filter\"`][1]")
    private MobileElement filterButton;

    @iOSXCUITFindBy(id = "Cancel")
    private MobileElement cancelModificationButton;

    @iOSXCUITFindBy(id = "Proceed to Checkout")
    private MobileElement proceedToCheckoutButton;

    @iOSXCUITFindBy(id = "orderLineItem-0-0")
    private MobileElement orderLineItem1;

    @iOSXCUITFindBy(id = "Barley Pearled 1#")
    private MobileElement orderLineItem1ProductTitle;

    @iOSXCUITFindBy(id = "4487633 | 24/1 LB | JACK RABBIT")
    private MobileElement orderLineItem1ProductDescription;

    @iOSXCUITFindBy(id = "$32.17 CS")
    private MobileElement orderLineItem1PricePerItem;

    @iOSXCUITFindBy(id = "$32.17")
    private MobileElement orderLineItem1PriceTotal;

    @iOSXCUITFindBy(id = "dot menu button")
    private MobileElement orderLineItem1DotMenuButton;

    @iOSXCUITFindBy(id = "decrease quantity button")
    private MobileElement decreaseQuantityButton;

    @iOSXCUITFindBy(id = "quantity text field")
    private MobileElement quantityInputField;

    @iOSXCUITFindBy(id = "increase quantity button")
    private MobileElement increaseQuantityButton;


    public OrderCartReviewOrderPage pressProceedToCheckoutButton() {
        click(proceedToCheckoutButton);
        return new OrderCartReviewOrderPage();
    }
}
