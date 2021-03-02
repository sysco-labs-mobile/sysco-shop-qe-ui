package com.qe.pages.orders;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class OrderCartReviewOrderPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(id = "Back")
    private MobileElement backButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(id = "Review Order")
    private MobileElement reviewOrderTitle;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/orderDetailsHeader")
    @iOSXCUITFindBy(id = "Order Details")
    private MobileElement orderDetailsHeader;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.TextView[1]")
    @iOSXCUITFindBy(id = "Shipping Address")
    private MobileElement shippingAddressHeader;


    /** Editable Order info fields */

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/shippingAddress")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Shipping Address\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement shippingAddressValue;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/orderName")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable[`label == \"Empty list\"`]/XCUIElementTypeOther[1]")
    private MobileElement orderNameTextInputField;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/poNumber")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable[`label == \"Empty list\"`]/XCUIElementTypeOther[2]")
    private MobileElement poNumberTextInputField;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/shippingTypeSpinner")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`name == \"shipping type option picker\"`][1]")
    private MobileElement shippingTypeOptionPicker;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/deliveryDate")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`name == \"delivery date date picker\"`][1]")
    private MobileElement deliveryDatePicker;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/deliveryInstructions")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable[`label == \"Empty list\"`]/XCUIElementTypeOther[5]")
    private MobileElement deliveryInstructionTextInputField;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/invoiceSeparately")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Order will be invoiced separately\"`][1]")
    private MobileElement invoiceCheckbox;


    /** Order totals info elements */

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Total Quantity\"`][1]")
    private MobileElement totalQuantityHeader;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Total Quantity\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement totalQuantityValue;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]  ")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Total Line Items\"`][1]")
    private MobileElement totalLineItemsHeader;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Total Line Items\"][1]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement totalLineItemsValue;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.TextView[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Estimated Total\"`][1]")
    private MobileElement estimatedTotalHeader;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Estimated Total\"][1]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement estimatedTotalValue;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/pricingDisclaimerText")
    @iOSXCUITFindBy(id = "Pricing displayed reflects current pricing and may be updated based on your delivery date.")
    private MobileElement pricingInfoMessage;


    /** Items section elements */

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/itemsHeader")
    @iOSXCUITFindBy(id = "Items")
    private MobileElement itemsHeader;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup")
    @iOSXCUITFindBy(id = "ordersubmissionitem-0-0")
    private MobileElement orderLineItem1;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/productDescription")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"ordersubmissionitem-0-0\"]/XCUIElementTypeStaticText[1]")
    private MobileElement orderLineItem1ProductTitle;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/productInfo")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"ordersubmissionitem-0-0\"]/XCUIElementTypeStaticText[2]")
    private MobileElement orderLineItem1ProductDescription;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/priceLabel")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"ordersubmissionitem-0-0\"]/XCUIElementTypeStaticText[@name=\"case price label\"]")
    private MobileElement orderLineItem1PricePerItem;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/totalPriceLabel")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"ordersubmissionitem-0-0\"]/XCUIElementTypeStaticText[@name=\"total case price label\"]")
    private MobileElement orderLineItem1PriceTotal;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/orderLineItemCountLabel")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"ordersubmissionitem-0-0\"]/XCUIElementTypeStaticText[@name=\"case quantity label\"]")
    private MobileElement orderLineItem1CaseCount;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/submitOrderModification")
    @iOSXCUITFindBy(id = "submit order button")
    private MobileElement submitOrderButton;

    @iOSXCUITFindBy(id = "proceed to checkout button")
    private MobileElement proceedToPayment;


    /** Credit card elements */

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Credit Card Surcharge\"`][1]")
    private MobileElement creditCardSurchargeHeader;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/infoBubble")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"infobubble\"`][1]")
    private MobileElement creditCardSurchargeInfoBubble;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Credit Card Surcharge\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement creditCardSurchargeValue;

    @iOSXCUITFindBy(id = "Credit cards will be charged the night before delivery. If your account has insufficient funds, your card will be declined.")
    private MobileElement creditCardText;


    /** Error modal elements only*/

    @iOSXCUITFindBy(id = "error")
    public MobileElement errorIcon;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/snackbar_text")
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
        softAssert.assertTrue(backButton.isDisplayed());
        softAssert.assertTrue(reviewOrderTitle.isDisplayed());
        softAssert.assertTrue(orderDetailsHeader.isDisplayed());
        softAssert.assertTrue(shippingAddressHeader.isDisplayed());
        softAssert.assertTrue(shippingAddressValue.isDisplayed());
        softAssert.assertTrue(orderNameTextInputField.isDisplayed());
        softAssert.assertTrue(poNumberTextInputField.isDisplayed());
        softAssert.assertTrue(shippingTypeOptionPicker.isDisplayed());
        softAssert.assertTrue(deliveryDatePicker.isDisplayed());
        softAssert.assertTrue(deliveryInstructionTextInputField.isDisplayed());
        softAssert.assertTrue(invoiceCheckbox.isDisplayed());
        softAssert.assertTrue(totalQuantityHeader.isDisplayed());
        softAssert.assertTrue(totalQuantityValue.isDisplayed());
        softAssert.assertTrue(totalLineItemsValue.isDisplayed());
        softAssert.assertTrue(estimatedTotalHeader.isDisplayed());
        softAssert.assertTrue(estimatedTotalValue.isDisplayed());
        softAssert.assertTrue(pricingInfoMessage.isDisplayed());
        softAssert.assertTrue(itemsHeader.isDisplayed());
        softAssert.assertAll();
        scrollDownByCoordinates();
        softAssert.assertTrue(orderLineItem1.isDisplayed());
        softAssert.assertTrue(submitOrderButton.isDisplayed());
        softAssert.assertEquals(shippingAddressValue.getText(), expectedShippingAddress);
        softAssert.assertEquals(totalQuantityValue.getText(), expectedTotalQuantity);
        softAssert.assertEquals(totalLineItemsValue.getText(), expectedTotalLineItems);
        softAssert.assertEquals(estimatedTotalValue.getText(), expectedEstimatedTotal);
        softAssert.assertAll();
        return this;
    }

    public OrderCartReviewOrderPage checkElementsPresenceOfFirstOrderLineItem(
            String expectedTitle, String expectedDescription, String expectedPricePerCS,  String expectedPriceTotal, String expectedCaseCount) {

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(orderLineItem1.isDisplayed());
        softAssert.assertTrue(orderLineItem1ProductTitle.isDisplayed());
        //softAssert.assertTrue(orderLineItem1ProductDescription.isDisplayed());
        softAssert.assertTrue(orderLineItem1PricePerItem.isDisplayed());
        softAssert.assertTrue(orderLineItem1PriceTotal.isDisplayed());
        softAssert.assertTrue(orderLineItem1CaseCount.isDisplayed());
        softAssert.assertEquals(orderLineItem1ProductTitle.getText(), expectedTitle);
        softAssert.assertEquals(orderLineItem1ProductDescription.getText(), expectedDescription);
        softAssert.assertEquals(orderLineItem1PricePerItem.getText(), expectedPricePerCS);
        softAssert.assertEquals(orderLineItem1PriceTotal.getText(), expectedPriceTotal);
        softAssert.assertEquals(orderLineItem1CaseCount.getText(), expectedCaseCount);
        softAssert.assertAll();
        return this;
    }
    public OrderCartReviewOrderPage checkElementsPresenceForCreditCardUser() {

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(creditCardSurchargeHeader.isDisplayed());
        //Assert.assertTrue(creditCardSurchargeInfoBubble.isDisplayed());ios flaks out
        softAssert.assertTrue(creditCardSurchargeValue.isDisplayed());
        softAssert.assertTrue(creditCardText.isDisplayed());
        softAssert.assertTrue(proceedToPayment.isDisplayed());
        softAssert.assertAll();
        return this;
    }

    public OrderCartReviewOrderPage checkElementsPresenceForErrorMAApproval() {

        SoftAssert softAssert = new SoftAssert();
        //Assert.assertTrue(errorIcon.isDisplayed());
        softAssert.assertTrue(errorMAApprovalLabel.isDisplayed());
        if(getPlatform().equalsIgnoreCase("Android")) {
            softAssert.assertEquals(errorMAApprovalLabel.getText(), "This order requires approval. Please modify, approve and submit in Shop Web.");
            softAssert.assertFalse(submitOrderButton.isEnabled());
        }
        softAssert.assertAll();
        return this;
    }

    public CreditCardSurchargeModal pressCreditCardSurchargeBubble() {
        click(creditCardSurchargeInfoBubble);
        return new CreditCardSurchargeModal();
    }

}
