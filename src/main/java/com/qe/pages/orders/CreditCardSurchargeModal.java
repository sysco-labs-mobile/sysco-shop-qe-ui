package com.qe.pages.orders;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CreditCardSurchargeModal extends BaseTest {
        TestUtils utils = new TestUtils();

        @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/alertTitle")
        @iOSXCUITFindBy(id = "Credit Card Surcharge")
        private MobileElement creditCardSurchargeTitle;
        //android Credit Card Surchage

        @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/alertText")
        @iOSXCUITFindBy(id = "We impose a surcharge of 2.50% on the total credit card transaction, which is not greater than our cost of acceptance.")
        private MobileElement creditCardSurchargeHeader;
        //android We impose a surcharge of 2.50% on the total credit card transaction, which is not greater than our cost of acceptance.

        @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/alertPrimaryButton")
        @iOSXCUITFindBy(id = "alert primary")
        private MobileElement okButton;

        public CreditCardSurchargeModal checkElementsPresence() {
                SoftAssert softAssert = new SoftAssert();
                softAssert.assertTrue(creditCardSurchargeTitle.isDisplayed());
                softAssert.assertTrue(creditCardSurchargeHeader.isDisplayed());
                softAssert.assertTrue(okButton.isDisplayed());
                softAssert.assertAll();
                return this;
        }

        public OrderCartReviewOrderPage pressOkButton() {
                click(okButton);
                return new OrderCartReviewOrderPage();
        }
}
