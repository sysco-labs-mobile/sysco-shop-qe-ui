package com.qe.pages.orders;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

public class OrderCartReviewOrderPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(id = "Back")
    private MobileElement backButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'toolbar')]/android.widget.TextView[1]")
    @iOSXCUITFindBy(id = "Review Order")
    private MobileElement reviewOrderTitle;

    @AndroidFindBy(id = "orderDetailsHeader")
    @iOSXCUITFindBy(id = "Order Details")
    private MobileElement orderDetailsHeader;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'shippingAddressContainer')]/android.widget.TextView[1]")
    @iOSXCUITFindBy(id = "Shipping Address")
    private MobileElement shippingAddressHeader;

    @AndroidFindBy(id = "shippingAddress")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Shipping Address']/following-sibling::XCUIElementTypeStaticText")
    private MobileElement shippingAddressValue;


    /** Editable Order info fields */

    @AndroidFindBy(id = "orderName")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Order Name\"])[1]/preceding-sibling::XCUIElementTypeTextField[1]")
    private MobileElement orderNameTextInputField;

    @AndroidFindBy(id = "poNumber")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"PO Number (Optional)\"])[1]/preceding-sibling::XCUIElementTypeTextField[1]")
    private MobileElement poNumberTextInputField;

    @AndroidFindBy(id = "shippingTypeSpinner")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`name == 'shipping type option picker'`][1]")
    private MobileElement shippingTypeOptionPicker;

    @AndroidFindBy(id = "deliveryDate")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`name == 'delivery date date picker'`][1]")
    private MobileElement deliveryDatePicker;

    @AndroidFindBy(id = "deliveryInstructions")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Delivery Instructions (Optional)\"])[1]/preceding-sibling::XCUIElementTypeTextField[1]")
    private MobileElement deliveryInstructionTextInputField;

    @AndroidFindBy(id = "invoiceSeparately")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Order will be invoiced separately'`][1]")
    private MobileElement invoiceCheckbox;


    /** Order totals info elements */

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'orderTotalQuantity')]/*[contains(@resource-id, 'keyText')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Total Quantity'`][1]")
    private MobileElement totalQuantityHeader;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'orderTotalQuantity')]/*[contains(@resource-id, 'valueText')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Total Quantity']/following-sibling::XCUIElementTypeStaticText")
    private MobileElement totalQuantityValue;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'orderTotalLineItems')]/*[contains(@resource-id, 'keyText')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Total Line Items'`][1]")
    private MobileElement totalLineItemsHeader;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'orderTotalLineItems')]/*[contains(@resource-id, 'valueText')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Total Line Items'][1]/following-sibling::XCUIElementTypeStaticText  ")
    private MobileElement totalLineItemsValue;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'orderEstimatedTotal')]/*[contains(@resource-id, 'keyText')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Estimated Total'`][1]")
    private MobileElement estimatedTotalHeader;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'orderEstimatedTotal')]/*[contains(@resource-id, 'valueText')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Estimated Total'][1]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement estimatedTotalValue;

    @AndroidFindBy(id = "pricingDisclaimerText")
    @iOSXCUITFindBy(id = "Pricing displayed reflects current pricing and may be updated based on your delivery date.")
    private MobileElement pricingInfoMessage;


    /** Items section elements */

    @AndroidFindBy(id = "itemsHeader")
    @iOSXCUITFindBy(id = "Items")
    private MobileElement itemsHeader;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'orderLineItems')]/android.view.ViewGroup[1]")
    @iOSXCUITFindBy(id = "ordersubmissionitem-0-0")
    private MobileElement orderLineItem1;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'orderLineItems')]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/*[contains(@resource-id, 'productDescription')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='ordersubmissionitem-0-0']/XCUIElementTypeStaticText[1]")
    private MobileElement orderLineItem1ProductTitle;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'orderLineItems')]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/*[contains(@resource-id, 'productInfo')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='ordersubmissionitem-0-0']/XCUIElementTypeStaticText[2]")
    private MobileElement orderLineItem1ProductDescription;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'orderLineItems')]//android.view.ViewGroup[contains(@resource-id, 'casePriceContainer')]//android.widget.TextView[contains(@resource-id, 'priceLabel')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='ordersubmissionitem-0-0']/XCUIElementTypeStaticText[@name='case price label']")
    private MobileElement orderLineItem1CasePricePerItem;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'orderLineItems')]//android.view.ViewGroup[contains(@resource-id, 'casePriceContainer')]//android.widget.TextView[contains(@resource-id, 'totalPriceLabel')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='ordersubmissionitem-0-0']/XCUIElementTypeStaticText[@name='total case price label']")
    private MobileElement orderLineItem1CasePriceTotal;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'orderLineItems')]//android.view.ViewGroup[contains(@resource-id, 'casePriceContainer')]//android.widget.TextView[contains(@resource-id, 'orderLineItemCountLabel')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='ordersubmissionitem-0-0']/XCUIElementTypeStaticText[@name='case quantity label']")
    private MobileElement orderLineItem1CaseCount;

    @AndroidFindBy(id = "submitOrderModification")
    @iOSXCUITFindBy(id = "submit order button")
    private MobileElement submitOrderButton;

    @iOSXCUITFindBy(id = "proceed to checkout button")
    private MobileElement proceedToCheckout;


    /** Credit card elements */

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'orderTotalSurcharge')]/*[contains(@resource-id, 'keyText')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Credit Card Surcharge'`][1]")
    private MobileElement creditCardSurchargeHeader;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'orderTotalSurcharge')]/*[contains(@resource-id, 'infoBubble')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='credit card surcharge info bubble'][1]")
    private MobileElement creditCardSurchargeInfoBubble;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'orderTotalSurcharge')]/*[contains(@resource-id, 'keyText')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Credit Card Surcharge']/following-sibling::XCUIElementTypeStaticText")
    private MobileElement creditCardSurchargeValue;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'orderEstimatedTotal')]/*[contains(@resource-id, 'infoBubble')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='estimated total info bubble'][1]")
    private MobileElement estimatedTotalInfoBubble;

    @AndroidFindBy(id = "pricingDisclaimerText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Credit cards will be charged the night before delivery. If your account has insufficient funds, your card will be declined.']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Items']/preceding-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement creditCardText;

    @AndroidFindBy(id = "submitOrderModification")
    @iOSXCUITFindBy(id = "proceed to payment button")
    private MobileElement proceedToPayment;

    /** Error modal elements only*/

    @iOSXCUITFindBy(id = "error")
    public MobileElement errorIcon;

    @AndroidFindBy(id = "snackbar_text")
    @iOSXCUITFindBy(id = "This order requires approval. Please modify, approve and submit in Shop Web.")
    public MobileElement errorMAApprovalLabel;


    public OrderCartOrderPlacedPage pressSubmitOrderButton() {
        click(submitOrderButton);
        return new OrderCartOrderPlacedPage();
    }

    public OrderCartReviewOrderPage pressSubmitOrderButtonExpectingError() {
        click(submitOrderButton);
        return new OrderCartReviewOrderPage();
    }

    public OrderCartReviewOrderPage checkElementsPresence(String expectedShippingAddress, String expectedTotalQuantity,
                                                          String expectedTotalLineItems, String expectedEstimatedTotal) {
        waitForVisibility(shippingAddressValue, "shippingAddressValue");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(backButton.isDisplayed(), "backButton");
        softAssert.assertTrue(reviewOrderTitle.isDisplayed(), "reviewOrderTitle");
        softAssert.assertTrue(orderDetailsHeader.isDisplayed(), "orderDetailsHeader");
        softAssert.assertTrue(shippingAddressHeader.isDisplayed(), "shippingAddressHeader");
        softAssert.assertTrue(shippingAddressValue.isDisplayed(), "shippingAddressValue");
        softAssert.assertEquals(shippingAddressValue.getText().replace("\n"," ").toLowerCase(), expectedShippingAddress.toLowerCase());
        softAssert.assertTrue(orderNameTextInputField.isDisplayed(), "orderNameTextInputField");
        softAssert.assertTrue(poNumberTextInputField.isDisplayed(), "poNumberTextInputField");
        softAssert.assertTrue(shippingTypeOptionPicker.isDisplayed(), "shippingTypeOptionPicker");
        softAssert.assertTrue(deliveryDatePicker.isDisplayed(), "deliveryDatePicker");
        softAssert.assertTrue(deliveryInstructionTextInputField.isDisplayed(), "deliveryInstructionTextInputField");
        softAssert.assertTrue(invoiceCheckbox.isDisplayed(), "invoiceCheckbox");
        scrollDownByCoordinates();
        softAssert.assertTrue(totalQuantityHeader.isDisplayed(), "totalQuantityHeader");
        softAssert.assertTrue(totalQuantityValue.isDisplayed(), "totalQuantityValue");
        softAssert.assertTrue(totalLineItemsValue.isDisplayed(), "totalLineItemsValue");
        softAssert.assertTrue(estimatedTotalHeader.isDisplayed(), "estimatedTotalHeader");
        softAssert.assertTrue(estimatedTotalValue.isDisplayed(), "estimatedTotalValue");
        softAssert.assertTrue(pricingInfoMessage.isDisplayed(), "pricingInfoMessage");
        softAssert.assertTrue(itemsHeader.isDisplayed(), "itemsHeader");
        softAssert.assertAll();
        scrollDownByCoordinates();
        softAssert.assertTrue(orderLineItem1.isDisplayed(),"orderLineItem1");
        softAssert.assertTrue(submitOrderButton.isDisplayed(), "submitOrderButton");
        softAssert.assertEquals(totalQuantityValue.getText(), expectedTotalQuantity);
        softAssert.assertEquals(totalLineItemsValue.getText(), expectedTotalLineItems);
        softAssert.assertEquals(estimatedTotalValue.getText(), expectedEstimatedTotal);
        softAssert.assertAll();
        return this;
    }

    public OrderCartReviewOrderPage checkElementsPresenceOfFirstOrderLineItem(
            String expectedTitle, String expectedDescription, String expectedPricePerCS,  String expectedPriceTotal, String expectedCaseCount) {

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(orderLineItem1.isDisplayed(), "orderLineItem1");
        softAssert.assertTrue(orderLineItem1ProductTitle.isDisplayed(), "orderLineItem1ProductTitle");
//        softAssert.assertTrue(orderLineItem1ProductDescription.isDisplayed());
        softAssert.assertTrue(orderLineItem1CasePricePerItem.isDisplayed(), "orderLineItem1PricePerItem");
        softAssert.assertTrue(orderLineItem1CasePriceTotal.isDisplayed(), "orderLineItem1PriceTotal");
        softAssert.assertTrue(orderLineItem1CaseCount.isDisplayed(), "orderLineItem1CaseCount");
        softAssert.assertEquals(orderLineItem1ProductTitle.getText(), expectedTitle);
        softAssert.assertEquals(orderLineItem1ProductDescription.getText(), expectedDescription, "orderLineItem1ProductDescription");
        softAssert.assertEquals(orderLineItem1CasePricePerItem.getText().replace("\n", ""), expectedPricePerCS, "orderLineItem1CasePricePerItem");
        softAssert.assertEquals(orderLineItem1CasePriceTotal.getText(), expectedPriceTotal, "orderLineItem1CasePriceTotal");
        softAssert.assertEquals(orderLineItem1CaseCount.getText(), expectedCaseCount, "orderLineItem1CaseCount");
        softAssert.assertAll();
        return this;
    }
    public OrderCartReviewOrderPage checkElementsPresenceForCreditCardUser() {
        utils.log().info("Check elements presence for Credit Card user on Review Order page");
        SoftAssert softAssert = new SoftAssert();
        scrollDownByCoordinates();
        softAssert.assertTrue(creditCardSurchargeHeader.isDisplayed(), "creditCardSurchargeHeader");
        softAssert.assertTrue(creditCardSurchargeInfoBubble.isDisplayed(), "creditCardSurchargeInfoBubble"); //ios flaks out
        softAssert.assertTrue(creditCardSurchargeValue.isDisplayed(), "creditCardSurchargeValue");
        softAssert.assertTrue(proceedToPayment.isDisplayed(), "proceedToPayment");
        if (getPlatform().equalsIgnoreCase("Android")) {
            softAssert.assertTrue(estimatedTotalInfoBubble.isDisplayed()); //ios flaks out
            softAssert.assertTrue(creditCardText.isDisplayed()); //ios flaks out
            softAssert.assertTrue(creditCardText.isDisplayed(), "creditCardText");
            softAssert.assertEquals(creditCardText.getText(),"Credit cards will be charged the night before delivery. If your account has insufficient funds, your card will be declined.", "creditCardText");
            softAssert.assertEquals(proceedToPayment.getText(), "Proceed to Payment");
        }
        softAssert.assertAll();
        return this;
    }

    public OrderCartReviewOrderPage checkElementsPresenceForErrorMAApproval() {
        utils.log().info("Check elements presence for Error banner - MA approval needed on Order Cart page");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(errorMAApprovalLabel.isDisplayed());
        if(getPlatform().equalsIgnoreCase("Android")) {
            softAssert.assertEquals(errorMAApprovalLabel.getText(), "This order requires approval. Please modify, approve and submit in Shop Web.");
            softAssert.assertFalse(submitOrderButton.isEnabled());
        }
        softAssert.assertAll();
        return this;
    }

    public CreditCardSurchargeModal pressCreditCardSurchargeBubble() {
        click(creditCardSurchargeInfoBubble, "Press on Credit card surcharge bubble for credit card user on Review Order Page");
        return new CreditCardSurchargeModal();
    }

    public CreditCardPricingModal pressEstimatedTotalInfoBubble() {
        click(estimatedTotalInfoBubble, "Press on Estimated total info bubble for credit card user on Review Order Page");
        return new CreditCardPricingModal();
    }
}
