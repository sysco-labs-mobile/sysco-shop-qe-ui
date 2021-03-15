package com.qe.pages.login;

import com.qe.BaseTest;
import com.qe.pages.discover.DiscoverPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

public class ZipSwitcherPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(id = "browseProductCatalogText")
    @iOSXCUITFindBy(id = "Browse Our Product Catalog")
    private MobileElement header;

    @AndroidFindBy(id = "browseProductCatalogSubText")
    @iOSXCUITFindBy(id = "Sysco has products for all of your needs.")
    private MobileElement description;

    @AndroidFindBy(id = "zipCodeField")
    @iOSXCUITFindBy(id = "zip code text input text field")
    private MobileElement zipCodeInputTextField;

    @AndroidFindBy(id = "zipCodeField")
    @iOSXCUITFindBy(id = "Delivery Zip Code*")
    private MobileElement zipCodeInputText;

    @AndroidFindBy(id = "startShopping")
    @iOSXCUITFindBy(id = "start shopping button")
    private MobileElement startShoppingButton;

    @AndroidFindBy(id = "signIn")
    @iOSXCUITFindBy(id = "Sign In")
    private MobileElement signInButton;

    @AndroidFindBy(id = "becomeACustomer")
    @iOSXCUITFindBy(id = "Become A Customer")
    private MobileElement becomeACustomerButton;


    /** Unavailable zip elements */

    @AndroidFindBy(id = "currentlyNotAvailableText")
    @iOSXCUITFindBy(id = "We're Currently Not Available In:")
    private MobileElement unavailableHeader;

    @AndroidFindBy(id = "inTheMeanTimeText")
    @iOSXCUITFindBy(id = "In the meantime, browse some premium Sysco products that may be available in your area soon.")
    private MobileElement unavailableDescription;

    @AndroidFindBy(id = "browseSyscoProducts")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Browse Sysco Products\"`]")
    private MobileElement browseSyscoProductsButton;

    @AndroidFindBy(id = "unmatchedZipCode")
    @iOSXCUITFindBy(id = "zip code label")
    private MobileElement zipCodeLabel;

    @AndroidFindBy(id = "tryADifferentZipCode")
    @iOSXCUITFindBy(id = "Try A Different Zip Code")
    private MobileElement tryDifferentZipButton;

    public ZipSwitcherPage checkElementsPresence() {
        utils.log().info("Check elements presence on Zip Switcher Page");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(header.isDisplayed());
        softAssert.assertTrue(description.isDisplayed());
        softAssert.assertTrue(zipCodeInputTextField.isDisplayed());
        softAssert.assertTrue(zipCodeInputText.isDisplayed());
        softAssert.assertTrue(startShoppingButton.isDisplayed());
        softAssert.assertTrue(signInButton.isDisplayed());
        softAssert.assertTrue(becomeACustomerButton.isDisplayed());
        softAssert.assertAll();
        return this;
    }

    public ZipSwitcherPage checkElementsPresenceForNotAvailableZip(String expectedZip) {
        utils.log().info("Check elements presence on Not Available Zip Switcher Page");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(zipCodeLabel.getText(), expectedZip);
        softAssert.assertTrue(unavailableHeader.isDisplayed());
        softAssert.assertTrue(unavailableDescription.isDisplayed());
        softAssert.assertTrue(browseSyscoProductsButton.isDisplayed());
        softAssert.assertTrue(tryDifferentZipButton.isDisplayed());
        softAssert.assertAll();
        return this;
    }


    public ZipSwitcherPage inputZip(String zip) {
        sendKeys(zipCodeInputText, zip, "Input zip " + zip);
        return this;
    }

    public ZipSwitcherPage pressStartShoppingButtonForNotAvailableZip() {
        click(startShoppingButton, "Press start shopping button on Zip Switcher Page expecting not available zip");
        return new ZipSwitcherPage();
    }

    public DiscoverPage pressStartShoppingButtonForValidZip() {
        click(startShoppingButton, "Press start shopping button on Zip Switcher Page expecting available zip");
        waitForInvisibility(startShoppingButton, "startShoppingButton", 30);
        return new DiscoverPage();
    }

    public LoginPage pressSignInButton() {
        click(signInButton, "Press sign in button on Zip Switcher Page");
        return new LoginPage();
    }

    public void pressBecomeCustomerButton() {
        click(becomeACustomerButton);
    }


    /** Unavailable zip actions */

    public ZipSwitcherPage pressTryDifferentZipButton() {
        click(tryDifferentZipButton, "Press try different zip button on Zip Switcher page");
        return new ZipSwitcherPage();
    }

    public DiscoverPage pressBrowseSyscoProductsButton() {
        click(browseSyscoProductsButton, "Press browse sysco products button");
        return new DiscoverPage();
    }
}
