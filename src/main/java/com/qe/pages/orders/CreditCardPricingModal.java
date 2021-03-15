package com.qe.pages.orders;

import com.qe.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

public class CreditCardPricingModal extends BaseTest {

    @AndroidFindBy(id = "dialog_title")
    @iOSXCUITFindBy(id = "Pricing, Taxes, & Fees")
    private MobileElement alertTitle;

    @iOSXCUITFindBy(id = "Your estimated total does not include applicable taxes. Product prices may vary slightly on your final invoice due to market fluctuations and your delivery date. If you are resale/tax exempt, please complete your Sysco Credit Application through the link you received via email to provide supporting tax documentation or submit your tax documentation to your Sysco Sales representative and update your tax status on subsequent purchases.")
    private MobileElement iosAlertDescription;

    @AndroidFindBy(id = "alertPrimaryButton")
    @iOSXCUITFindBy(id = "alert primary")
    private MobileElement okButton;

    @AndroidFindBy(id = "pricing_and_fees_header")
    private MobileElement androidPricingFeesHeader;

    @AndroidFindBy(id = "pricing_and_fees_text")
    private MobileElement androidPricingFeesDescription;

    @AndroidFindBy(id = "taxes_header")
    private MobileElement androidTaxesHeader;

    @AndroidFindBy(id = "taxes_text")
    private MobileElement androidTaxesDescription;


    public CreditCardPricingModal checkElementsPresence() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(alertTitle.isDisplayed());
        if(getPlatform().equalsIgnoreCase("iOS")) {
            softAssert.assertTrue(iosAlertDescription.isDisplayed());
        }
        softAssert.assertTrue(okButton.isDisplayed());
        if(getPlatform().equalsIgnoreCase("Android")){
            softAssert.assertTrue(androidPricingFeesHeader.isDisplayed());
            softAssert.assertTrue(androidPricingFeesDescription.isDisplayed());
            softAssert.assertTrue(androidTaxesHeader.isDisplayed());
            softAssert.assertTrue(androidTaxesDescription.isDisplayed());
            softAssert.assertEquals(alertTitle.getText(), "Pricing, Taxes, & Fees");
            softAssert.assertEquals(androidPricingFeesHeader.getText(), "Pricing & Fees");
            softAssert.assertEquals(androidPricingFeesDescription.getText(), "Product prices may vary slightly on your final invoice due to market fluctuations and your delivery date. Your estimated total does not include possible applicable fees. Contact your Sysco Sales representative with questions or concerns.");
            softAssert.assertEquals(androidTaxesHeader.getText(), "Taxes");
            softAssert.assertEquals(androidTaxesDescription.getText(), "Any orders placed through Sysco Shop may have applicable taxes applied and can be viewed on your final invoice. If you are resale/tax exempt, please complete your Sysco Credit Application through the link you received via email to provide supporting documentation of your tax status or submit your tax documentation to your Sysco Sales representative. Once reviewed and approved, any subsequent orders will reflect your updated tax status.");
        }
        softAssert.assertAll();
        return this;
    }

    public CreditCardPricingModal pressOkButton() {
        click(okButton);
        return new CreditCardPricingModal();
    }
}
