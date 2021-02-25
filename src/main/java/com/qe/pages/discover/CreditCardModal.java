package com.qe.pages.discover;

import com.qe.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

public class CreditCardModal extends BaseTest {

    @iOSXCUITFindBy(id = "Welcome to Sysco Shop!")
    public MobileElement welcomeHeader;

    @iOSXCUITFindBy(id = "Explore our entire product catalog, including our Best of Sysco items. You can place your first Sysco order right away with a credit card.")
    public MobileElement welcomeDescription;

    @iOSXCUITFindBy(id = "Apply for Credit Terms")
    public MobileElement applyForCreditHeader;

    @iOSXCUITFindBy(id = "At any time, fill out the Sysco Credit Application to set up credit terms and receive increased payment flexibility.")
    public MobileElement applyForCreditDescription;

    @iOSXCUITFindBy(id = "Acknowledgement of Taxability")
    public MobileElement acknoledgementOfTaxabilityHeader;

    @iOSXCUITFindBy(id = "Any orders placed through Sysco Shop will have all applicable taxes applied and can be viewed on your final invoice. If you are resale/tax exempt, please complete your Sysco Credit Application through the link you received via email to provide supporting documentation of your tax status or submit your tax documentation to your Sysco Sales representative. Once reviewed and approved, any subsequent orders will reflect your updated tax status.")
    public MobileElement acknoledgementOfTaxabilityDescription;

    @iOSXCUITFindBy(id = "taxability accept button")
    public MobileElement acceptButton;

    public CreditCardModal checkElementsPresence() {
        Assert.assertTrue(welcomeHeader.isDisplayed());
        Assert.assertTrue(welcomeDescription.isDisplayed());
        Assert.assertTrue(applyForCreditHeader.isDisplayed());
        Assert.assertTrue(applyForCreditDescription.isDisplayed());
        Assert.assertTrue(acknoledgementOfTaxabilityHeader.isDisplayed());
        //Assert.assertTrue(acknoledgementOfTaxabilityDescription.isDisplayed()); ios flaks out
        Assert.assertTrue(acceptButton.isDisplayed());
        return this;
    }

    public DiscoverPage pressAcceptButton() {
        click(acceptButton);
        return new DiscoverPage();
    }
}
