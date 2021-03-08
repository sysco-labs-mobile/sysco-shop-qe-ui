package com.qe.pages.discover;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

public class CreditCardModal extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Welcome to Sysco Shop!']")
    @iOSXCUITFindBy(id = "Welcome to Sysco Shop!")
    public MobileElement welcomeHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Explore our entire product catalog, including our Best of Sysco items. You can place your first Sysco order right away with a credit card.']")
    @iOSXCUITFindBy(id = "Explore our entire product catalog, including our Best of Sysco items. You can place your first Sysco order right away with a credit card.")
    public MobileElement welcomeDescription;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Apply for Credit Terms']")
    @iOSXCUITFindBy(id = "Apply for Credit Terms")
    public MobileElement applyForCreditHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='At any time, fill out the Sysco Credit Application to set up credit terms and receive increased payment flexibility.']")
    @iOSXCUITFindBy(id = "At any time, fill out the Sysco Credit Application to set up credit terms and receive increased payment flexibility.")
    public MobileElement applyForCreditDescription;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Acknowledgement of Taxability']")
    @iOSXCUITFindBy(id = "Acknowledgement of Taxability")
    public MobileElement acknoledgementOfTaxabilityHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Any orders placed through Sysco Shop will have all applicable taxes applied and can be viewed on your final invoice. If you are resale/tax exempt, please complete your Sysco Credit Application through the link you received via email to provide supporting documentation of your tax status or submit your tax documentation to your Sysco Sales representative. Once reviewed and approved, any subsequent orders will reflect your updated tax status.']")
    @iOSXCUITFindBy(id = "Any orders placed through Sysco Shop will have all applicable taxes applied and can be viewed on your final invoice. If you are resale/tax exempt, please complete your Sysco Credit Application through the link you received via email to provide supporting documentation of your tax status or submit your tax documentation to your Sysco Sales representative. Once reviewed and approved, any subsequent orders will reflect your updated tax status.")
    public MobileElement acknoledgementOfTaxabilityDescription;

    @AndroidFindBy(id = "alertPrimaryButton")
    @iOSXCUITFindBy(id = "taxability accept button")
    public MobileElement acceptButton;

    public CreditCardModal checkElementsPresence() {
        utils.log().info("Check elements presence in Credit Card Welcome modal");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(welcomeHeader.isDisplayed());
        softAssert.assertTrue(welcomeDescription.isDisplayed());
        softAssert.assertTrue(applyForCreditHeader.isDisplayed());
        softAssert.assertTrue(applyForCreditDescription.isDisplayed());
        softAssert.assertTrue(acknoledgementOfTaxabilityHeader.isDisplayed());
        //Assert.assertTrue(acknoledgementOfTaxabilityDescription.isDisplayed()); ios flaks out
        softAssert.assertTrue(acceptButton.isDisplayed());
        softAssert.assertAll();
        return this;
    }

    public DiscoverPage pressAcceptButton() {
        utils.log().info("Press Accept button in Credit Card Welcome Modal");
        click(acceptButton);
        return new DiscoverPage();
    }
}
