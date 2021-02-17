package com.qe.pages.orders;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

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

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/shippingAddress")
    @iOSXCUITFindBy(id = "289 St George St Duxbury, MA 02332")
    private MobileElement shippingAddressValue;//ssmcust9@grr.la

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

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Total Quantity\"`][1]")
    private MobileElement totalQuantityHeader;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[2]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"1 CS | 0 EA\"`][1]")
    private MobileElement totalQuantityValue;
    //ios andr 1 CS | 0 EA

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]  ")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Total Line Items\"`][1]")
    private MobileElement totalLineItemsHeader;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"1\"`][1]")
    private MobileElement totalLineItemsValue;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Credit Card Surcharge\"`][1]")
    private MobileElement creditCardSurchargeHeader;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/infoBubble")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"infobubble\"`][1]")
    private MobileElement creditCardSurchargeInfoBubble;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[2]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"$0.80\"`][1]")
    private MobileElement creditCardSurchargeValue;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.TextView[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Estimated Total\"`][1]")
    private MobileElement estimatedTotalHeader;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.TextView[2]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"$32.97\"`][1]")
    private MobileElement estimatedTotalValue;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/pricingDisclaimerText")
    @iOSXCUITFindBy(id = "Pricing displayed reflects current pricing and may be updated based on your delivery date.")
    private MobileElement pricingInfoMessage;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/itemsHeader")
    @iOSXCUITFindBy(id = "Items")
    private MobileElement itemsHeader;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup")
    @iOSXCUITFindBy(id = "ordersubmissionitem-0-0")
    private MobileElement orderLineItem1;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/productDescription")
    @iOSXCUITFindBy(id = "Barley Pearled 1#")
    private MobileElement orderLineItem1ProductTitle;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/productInfo")
    @iOSXCUITFindBy(id = "4487633 | 24/1 LB | JACK RABBIT")
    private MobileElement orderLineItem1ProductDescription;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/priceLabel")
    @iOSXCUITFindBy(id = "$32.17 CS")
    private MobileElement orderLineItem1PricePerItem;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/totalPriceLabel")
    @iOSXCUITFindBy(id = "$32.17")
    private MobileElement orderLineItem1PriceTotal;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/orderLineItemCountLabel")
    private MobileElement orderLineItem1CaseCount;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/submitOrderModification")
    @iOSXCUITFindBy(id = "submit order button")
    private MobileElement submitOrderButton;

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

    public OrderCartReviewOrderPage checkElementsPresenceForErrorMAApproval() {
        //Assert.assertTrue(errorIcon.isDisplayed());
        Assert.assertTrue(errorMAApprovalLabel.isDisplayed());
        if(getPlatform().equalsIgnoreCase("Android")) {
            Assert.assertEquals(errorMAApprovalLabel.getText(), "This order requires approval. Please modify, approve and submit in Shop Web.");
            Assert.assertFalse(submitOrderButton.isEnabled());
        }
        return this;
    }

}
