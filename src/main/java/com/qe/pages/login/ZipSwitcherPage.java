package com.qe.pages.login;

import com.qe.BaseTest;
import com.qe.pages.discover.DiscoverPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

public class ZipSwitcherPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/browseProductCatalogText")
    @iOSXCUITFindBy(id = "Browse Our Product Catalog")
    private MobileElement header;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/browseProductCatalogSubText")
    @iOSXCUITFindBy(id = "Sysco has products for all of your needs.")
    private MobileElement description;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/zipCodeField")
    @iOSXCUITFindBy(id = "zip code text input text field")
    private MobileElement zipCodeInputTextField;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/zipCodeField")
    @iOSXCUITFindBy(id = "Delivery Zip Code*")
    private MobileElement zipCodeInputText;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/startShopping")
    @iOSXCUITFindBy(id = "start shopping button")
    private MobileElement startShoppingButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/signIn")
    @iOSXCUITFindBy(id = "Sign In")
    private MobileElement signInButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/becomeACustomer")
    @iOSXCUITFindBy(id = "Become A Customer")
    private MobileElement becomeACustomerButton;


    /** Unavailable zip elements */

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/currentlyNotAvailableText")
    @iOSXCUITFindBy(id = "We're Currently Not Available In:")
    private MobileElement unavailableHeader;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/inTheMeanTimeText")
    @iOSXCUITFindBy(id = "In the meantime, browse some premium Sysco products that may be available in your area soon.")
    private MobileElement unavailableDescription;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/browseSyscoProducts")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Browse Sysco Products\"`]")
    private MobileElement browseSyscoProductsButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/unmatchedZipCode")
    @iOSXCUITFindBy(id = "zip code label")
    private MobileElement zipCodeLabel;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/tryADifferentZipCode")
    @iOSXCUITFindBy(id = "Try A Different Zip Code")
    private MobileElement tryDifferentZipButton;

    public ZipSwitcherPage checkElementsPresence() {
        Assert.assertTrue(header.isDisplayed());
        Assert.assertTrue(description.isDisplayed());
        Assert.assertTrue(zipCodeInputTextField.isDisplayed());
        Assert.assertTrue(zipCodeInputText.isDisplayed());
        Assert.assertTrue(startShoppingButton.isDisplayed());
        Assert.assertTrue(signInButton.isDisplayed());
        Assert.assertTrue(becomeACustomerButton.isDisplayed());
        return this;
    }

    public ZipSwitcherPage checkElementsPresenceForNotAvailableZip(String expectedZip) {
        Assert.assertEquals(zipCodeLabel.getText(), expectedZip);
        Assert.assertTrue(unavailableHeader.isDisplayed());
        Assert.assertTrue(unavailableDescription.isDisplayed());
        Assert.assertTrue(browseSyscoProductsButton.isDisplayed());
        Assert.assertTrue(tryDifferentZipButton.isDisplayed());
        return this;
    }


    public ZipSwitcherPage inputZip(String zip) {
        sendKeys(zipCodeInputText, zip, "Input zip " + zip);
        return this;
    }

    public ZipSwitcherPage pressStartShoppingButtonForNotAvailableZip() {
        click(startShoppingButton);
        return new ZipSwitcherPage();
    }

    public DiscoverPage pressStartShoppingButtonForValidZip() {
        click(startShoppingButton);
        return new DiscoverPage();
    }

    public LoginPage pressSignInButton() {
        click(signInButton);
        return new LoginPage();
    }

    public void pressBecomeCustomerButton() {
        click(becomeACustomerButton);
    }


    /** Unavailable zip actions */

    public ZipSwitcherPage pressTryDifferentZipButton() {
        click(tryDifferentZipButton);
        return new ZipSwitcherPage();
    }

    public DiscoverPage pressBrowseSyscoProductsButton() {
        click(browseSyscoProductsButton);
        return new DiscoverPage();
    }
}
