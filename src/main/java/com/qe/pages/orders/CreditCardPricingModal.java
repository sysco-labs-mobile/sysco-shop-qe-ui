package com.qe.pages.orders;

import com.qe.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

public class CreditCardPricingModal extends BaseTest {

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/alertTitle")
    @iOSXCUITFindBy(id = "Pricing, Taxes, & Fees")
    private MobileElement alertTitle;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/alertText")
    @iOSXCUITFindBy(id = "Your estimated total does not include applicable taxes. Product prices may vary slightly on your final invoice due to market fluctuations and your delivery date. If you are resale/tax exempt, please complete your Sysco Credit Application through the link you received via email to provide supporting tax documentation or submit your tax documentation to your Sysco Sales representative and update your tax status on subsequent purchases.")
    private MobileElement alertDescription;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/alertPrimaryButton")
    @iOSXCUITFindBy(id = "alert primary")
    private MobileElement okButton;

    public CreditCardPricingModal checkElementsPresence() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(alertTitle.isDisplayed());
        softAssert.assertTrue(alertDescription.isDisplayed());
        softAssert.assertTrue(okButton.isDisplayed());
        softAssert.assertAll();
        return this;
    }

    public CreditCardPricingModal pressOkButton() {
        click(okButton);
        return new CreditCardPricingModal();
    }
}
