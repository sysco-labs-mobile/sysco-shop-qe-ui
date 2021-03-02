package com.qe.pages.orders;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.logging.log4j.core.config.Order;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class OrderCartPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(id = "Back")
    private MobileElement backButton;

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
    //@iOSXCUITFindBy(id = "$55.36")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"app navigation bar\"`]/XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
    private MobileElement navBarPriceValue;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView[2]")
    //@iOSXCUITFindBy(id = "1 CS | 0 EA")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"app navigation bar\"`]/XCUIElementTypeOther/XCUIElementTypeStaticText[2]")
    private MobileElement navBarCsAndEaValues;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/editText")
    @iOSXCUITFindBy(id = "search filter view - search input")
    private MobileElement searchFilterTextInputField;

    @AndroidFindBy(id = "Filter")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"filter\"`][1]")
    private MobileElement filterButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/proceedToCheckoutButton")
    @iOSXCUITFindBy(id = "proceed to checkout button")
    private MobileElement proceedToCheckoutButton;//getEnabled()

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/resultCount")
    //@iOSXCUITFindBy(id = "1 LINE ITEM")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name=\"cart list\"]/XCUIElementTypeStaticText[1]")
    private MobileElement filterResultCount;//android 1 LINE ITEM

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup")
    @iOSXCUITFindBy(id = "orderLineItem-0-0")
    private MobileElement orderLineItem1;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/productDescription")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"orderLineItem-0-0\"]/XCUIElementTypeStaticText[1]")
    private MobileElement orderLineItem1ProductTitle;
    //android Beef Ground Bulk 81%-19% Chub

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/productInfo")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"orderLineItem-0-0\"]/XCUIElementTypeStaticText[2]")
    private MobileElement orderLineItem1ProductDescription;
    //android 0566709 | 4/5#AV | FIRE RIVER FARMS CLASSIC

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/priceLabel")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"orderLineItem-0-0\"]/XCUIElementTypeStaticText[4]")
    private MobileElement orderLineItem1PricePerItem;
    //android CS (avg. 20.37LB) @ $2.652/LB

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/totalPriceLabel")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"orderLineItem-0-0\"]/XCUIElementTypeStaticText[3]")
    private MobileElement orderLineItem1PriceTotal;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/popupMenu")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"orderLineItem-0-0\"]/XCUIElementTypeButton[@name=\"dot menu button\"]")
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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"orderLineItem-0-0\"]/XCUIElementTypeButton[@name=\"decrease quantity button\"]")
    private MobileElement orderLineItem1DecreaseQuantityButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/cartItemCount")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"orderLineItem-0-0\"]/XCUIElementTypeTextField[@name=\"case quantity text field\"]")
    private MobileElement orderLineItem1QuantityInputField;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/addToCartPlus")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"orderLineItem-0-0\"]/XCUIElementTypeButton[@name=\"increase quantity button\"]")
    private MobileElement orderLineItem1IncreaseQuantityButton;


    /** Credit Card elements */

    @iOSXCUITFindBy(id = "prospect shop message")
    private MobileElement prospectShopLabelContainer;

    @iOSXCUITFindBy(id = "Fill out your Sysco Credit Application for credit terms and payment flexibility. You were emailed a link to your credit application when you registered to become a Sysco customer, and it should take 15 minutes to complete.")
    private MobileElement prospectShopText;

    @iOSXCUITFindBy(id = "prospect shop message close")
    private MobileElement prospectShopCloseButton;


    /** Filter elements */

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"MEATS\"`]")
    private MobileElement filterCategoryMeatLabel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name=\"cart list\"]/XCUIElementTypeStaticText[2]")
    private MobileElement searchQueryLabel;

    public OrderCartPage checkElementsPresence(String expectedTotalPrice, String expectedCsAndEaValues) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(backButton.isDisplayed());
        softAssert.assertTrue(orderDotMenuButton.isDisplayed());
        softAssert.assertTrue(navBarPriceValue.isDisplayed());
        softAssert.assertTrue(navBarCsAndEaValues.isDisplayed());
        softAssert.assertTrue(searchFilterTextInputField.isDisplayed());
        softAssert.assertTrue(filterButton.isDisplayed());
        softAssert.assertTrue(proceedToCheckoutButton.isDisplayed());
        softAssert.assertTrue(filterResultCount.isDisplayed());
        softAssert.assertAll();
        return this;
    }

    public OrderCartPage checkElementsPresenceOfFirstOrderLineItem(
            String expectedTitle, String expectedDescription, String expectedPricePerCS,  String expectedPricePerEA, String expectedPriceTotal) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(orderLineItem1.isDisplayed());
        softAssert.assertTrue(orderLineItem1ProductTitle.isDisplayed());
        //Assert.assertTrue(orderLineItem1ProductDescription.isDisplayed());
        //Assert.assertTrue(orderLineItem1PricePerItem.isDisplayed());
        softAssert.assertTrue(orderLineItem1PriceTotal.isDisplayed());
        softAssert.assertTrue(orderLineItem1DotMenuButton.isDisplayed());
        softAssert.assertTrue(orderLineItem1DecreaseQuantityButton.isDisplayed());
        softAssert.assertTrue(orderLineItem1QuantityInputField.isDisplayed());
        softAssert.assertTrue(orderLineItem1IncreaseQuantityButton.isDisplayed());
        softAssert.assertEquals(orderLineItem1ProductTitle.getText(), expectedTitle);
        softAssert.assertEquals(orderLineItem1ProductDescription.getText(), expectedDescription);
        if(expectedPricePerCS != null) {
            softAssert.assertEquals(orderLineItem1PricePerItem.getText(), expectedPricePerCS);
        }
        if(expectedPricePerEA != null) {
            softAssert.assertEquals(orderLineItem1PricePerItem.getText(), expectedPricePerEA);
        }
        softAssert.assertEquals(orderLineItem1PriceTotal.getText(), expectedPriceTotal);
        softAssert.assertAll();
        return this;
    }

    public OrderCartPage checkElementsPresenceForCreditCardUser() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(prospectShopLabelContainer.isDisplayed());
        softAssert.assertTrue(prospectShopText.isDisplayed());
        softAssert.assertTrue(prospectShopCloseButton.isDisplayed());
        softAssert.assertAll();
        return this;
    }
    public OrderCartReviewOrderPage pressProceedToCheckoutButton() {
        click(proceedToCheckoutButton);
        return new OrderCartReviewOrderPage();
    }

    public OrderCartPage pressProspectShopCloseButton() {
        click(prospectShopCloseButton);
        return new OrderCartPage();
    }

    public OrderCartPage inputSearchCartText(String searchQuery) {
        sendKeys(searchFilterTextInputField, searchQuery, "Input search in cart " + searchQuery);
        return new OrderCartPage();
    }

    public OrderCartFilterPage pressFilterButton() {
        click(filterButton);
        return new OrderCartFilterPage();
    }
}