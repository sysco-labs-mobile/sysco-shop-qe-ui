package com.qe.pages.orders;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

public class OrderCartPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(id = "Back")
    private MobileElement backButton;

    @AndroidFindBy(accessibility = "More options")
    @iOSXCUITFindBy(id = "app nav dot menu button")
    private MobileElement orderDotMenuButton;

    @AndroidFindBy(id = "title")
    @iOSXCUITFindBy(id = "Delete Order")
    private MobileElement deleteOrderButton;

    @AndroidFindBy(id = "title")
    @iOSXCUITFindBy(id = "Cancel")
    private MobileElement cancelOrderButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'toolbar')]/android.widget.TextView[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == 'app navigation bar'`]/XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
    private MobileElement navBarPriceValue;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'toolbar')]/android.widget.TextView[2]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == 'app navigation bar'`]/XCUIElementTypeOther/XCUIElementTypeStaticText[2]")
    private MobileElement navBarCsAndEaValues;

    @AndroidFindBy(id = "editText")
    @iOSXCUITFindBy(id = "search filter view - search input")
    private MobileElement searchFilterTextInputField;

    @AndroidFindBy(accessibility = "Filter")
    @AndroidFindBy(id = "groupBy")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'filter'`][1]")
    private MobileElement filterButton;

    @AndroidFindBy(id = "proceedToCheckoutButton")
    @iOSXCUITFindBy(id = "proceed to checkout button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"proceed to checkout button\"]")
    private MobileElement proceedToCheckoutButton;

    @AndroidFindBy(id = "resultCount")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name='cart list']/XCUIElementTypeStaticText[1]")
    private MobileElement filterResultCount;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]")
    @iOSXCUITFindBy(id = "orderLineItem-0-0")
    private MobileElement orderLineItem1;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'productDescription')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='orderLineItem-0-0']/XCUIElementTypeStaticText[1]")
    private MobileElement orderLineItem1ProductTitle;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]/*[contains(@resource-id, 'productInfoContainer')]/*[contains(@resource-id, 'productInfo')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='orderLineItem-0-0']/XCUIElementTypeStaticText[2]")
    private MobileElement orderLineItem1ProductDescription;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'priceLabel')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='orderLineItem-0-0']/XCUIElementTypeStaticText[4]")
    private MobileElement orderLineItem1PricePerItem;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'totalPriceLabel')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='orderLineItem-0-0']/XCUIElementTypeStaticText[3]")
    private MobileElement orderLineItem1PriceTotal;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'popupMenu')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='orderLineItem-0-0']/XCUIElementTypeButton[@name='dot menu button']")
    private MobileElement orderLineItem1DotMenuButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'addToCartMinus')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='orderLineItem-0-0']/XCUIElementTypeButton[@name='decrease quantity button']")
    private MobileElement orderLineItem1DecreaseQuantityButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'cartItemCount')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='orderLineItem-0-0']/XCUIElementTypeTextField[@name='case quantity text field']")
    private MobileElement orderLineItem1QuantityInputField;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'addToCartPlus')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='orderLineItem-0-0']/XCUIElementTypeButton[@name='increase quantity button']")
    private MobileElement orderLineItem1IncreaseQuantityButton;

    @AndroidFindBy(id = "snackbar_text")
    @iOSXCUITFindBy(id = "cart error banner")
    public MobileElement errorMAApprovalLabel;

    /** Order item three dot menu */

//    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Add to list')]")
    @iOSXCUITFindBy(id = "Add to list")
    private MobileElement addToListButton;

    //    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Remove item')]")
    @iOSXCUITFindBy(id = "Remove item")
    private MobileElement removeItemButton;

    //not on android
    @iOSXCUITFindBy(id = "Cancel")
    private MobileElement cancelButton;


    /** Credit Card elements */

    @AndroidFindBy(id = "customerCreditBanner")
    @iOSXCUITFindBy(id = "prospect shop message")
    private MobileElement prospectShopLabelContainer;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'customerCreditBanner')]/android.widget.TextView[1]")
    @iOSXCUITFindBy(id = "Fill out your Sysco Credit Application for credit terms and payment flexibility. You were emailed a link to your credit application when you registered to become a Sysco customer, and it should take 15 minutes to complete.")
    private MobileElement prospectShopText;

    @AndroidFindBy(id = "customerCreditBannerClose")
    @iOSXCUITFindBy(id = "prospect shop message close")
    private MobileElement prospectShopCloseButton;


    /** Filter elements */

    @AndroidFindBy(id = "categoryName")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == 'MEATS'`]")
    private MobileElement filterCategoryMeatLabel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name='cart list']/XCUIElementTypeStaticText[2]")
    private MobileElement iosSearchQueryLabel;


    public OrderCartPage checkElementsPresence(String expectedTotalPrice, String expectedCsAndEaValues) {
        utils.log().info("Check elements presence on Order Cart Page");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(backButton.isDisplayed(), "backButton");
        softAssert.assertTrue(orderDotMenuButton.isDisplayed(), "orderDotMenuButton");
        softAssert.assertTrue(navBarPriceValue.isDisplayed(), "navBarPriceValue");
        softAssert.assertTrue(navBarCsAndEaValues.isDisplayed(), "navBarCsAndEaValues");
        softAssert.assertTrue(searchFilterTextInputField.isDisplayed(), "searchFilterTextInputField");
        softAssert.assertTrue(filterButton.isDisplayed(), "filterButton");
        softAssert.assertTrue(proceedToCheckoutButton.isDisplayed(), "proceedToCheckoutButton");
        softAssert.assertTrue(filterResultCount.isDisplayed(), "filterResultCount");
        softAssert.assertEquals(navBarPriceValue.getText(), expectedTotalPrice);
        softAssert.assertTrue(navBarCsAndEaValues.getText().contains(expectedCsAndEaValues));
        softAssert.assertAll();
        return this;
    }

    public OrderCartPage checkElementsPresenceForFirstOrderLineItem(
            String expectedTitle, String expectedDescription, String expectedPricePerCS,  String expectedPricePerEA, String expectedPriceTotal) {
        utils.log().info("Check elements presence for first order item on Order Cart Page");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(orderLineItem1.isDisplayed(), "orderLineItem1");
        softAssert.assertTrue(orderLineItem1ProductTitle.isDisplayed(), "orderLineItem1ProductTitle");
        //Assert.assertTrue(orderLineItem1ProductDescription.isDisplayed());
        //Assert.assertTrue(orderLineItem1PricePerItem.isDisplayed());
        softAssert.assertTrue(orderLineItem1PriceTotal.isDisplayed(), "orderLineItem1PriceTotal");
        softAssert.assertTrue(orderLineItem1DotMenuButton.isDisplayed(), "orderLineItem1DotMenuButton");
        softAssert.assertTrue(orderLineItem1DecreaseQuantityButton.isDisplayed(), "orderLineItem1DecreaseQuantityButton");
        softAssert.assertTrue(orderLineItem1QuantityInputField.isDisplayed(), "orderLineItem1QuantityInputField");
        softAssert.assertTrue(orderLineItem1IncreaseQuantityButton.isDisplayed(), "orderLineItem1IncreaseQuantityButton");
        softAssert.assertEquals(orderLineItem1ProductTitle.getText(), expectedTitle);
        softAssert.assertEquals(orderLineItem1ProductDescription.getText(), expectedDescription);
        if(expectedPricePerCS != null) {
            softAssert.assertEquals(orderLineItem1PricePerItem.getText().replace("\n", ""), expectedPricePerCS);
        }
        if(expectedPricePerEA != null) {
            softAssert.assertEquals(orderLineItem1PricePerItem.getText().replace("\n", ""), expectedPricePerEA);
        }
        softAssert.assertEquals(orderLineItem1PriceTotal.getText(), expectedPriceTotal);
        softAssert.assertAll();
        return this;
    }

    public OrderCartPage checkElementsPresenceForCreditCardUser() {
        utils.log().info("Check elements presence for Credit Card user on Order Cart Page");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(prospectShopLabelContainer.isDisplayed(), "prospectShopLabelContainer");
        softAssert.assertTrue(prospectShopText.isDisplayed(), "prospectShopText");
        softAssert.assertTrue(prospectShopCloseButton.isDisplayed(), "prospectShopCloseButton");
        if(getPlatform().equalsIgnoreCase("Android")){
            softAssert.assertEquals(prospectShopText.getText(), "Fill out your Sysco Credit Application for credit terms and payment flexibility. You were emailed a link to your credit application when you registered to become a Sysco customer, and it should take 15 minutes to complete.");
        }
        softAssert.assertAll();
        return this;
    }

    public OrderCartReviewOrderPage pressProceedToCheckoutButton() {
        click(proceedToCheckoutButton, "Press proceed to checkout button on Order Cart page");
        return new OrderCartReviewOrderPage();
    }

    public ForgottenItemsPage pressProceedToCheckoutButtonToOpenForgottenItems() {
        click(proceedToCheckoutButton, "Press proceed to checkout button on Order Cart page");
        return new ForgottenItemsPage();
    }

    public OrderCartPage pressProspectShopCloseButton() {
        click(prospectShopCloseButton, "Press on close button in Credit Card user lable on Order Cart page");
        return new OrderCartPage();
    }

    public OrderCartPage inputSearchCartText(String searchQuery) {
        sendKeys(searchFilterTextInputField, searchQuery, "Input search in cart " + searchQuery);
        return new OrderCartPage();
    }

    public OrderCartFilterPage pressFilterButton() {
        click(filterButton, "Press filter button on Order Cart page");
        return new OrderCartFilterPage();
    }

    public OrderCartPage checkElementsPresenceForErrorMAApprovalOnIos() {
        utils.log().info("Check elements presence for Error banner - MA approval needed on Order Cart page");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(errorMAApprovalLabel.isDisplayed());
        softAssert.assertAll();
        return this;
    }
}