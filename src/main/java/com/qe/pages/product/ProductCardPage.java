package com.qe.pages.product;

import com.qe.BaseTest;
import com.qe.pages.lists.AddToListPage;
import com.qe.pages.login.LoginPage;
import com.qe.pages.orders.OrderCartPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ProductCardPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(id = "Navigate up")
    @iOSXCUITFindBy(id = "Back")
    private MobileElement backButton;

    @iOSXCUITFindBy(id = "product info add to list")
    private MobileElement addToListButton;

    @iOSXCUITFindBy(id = "cart button")
    private MobileElement cartButton;

    @iOSXCUITFindBy(id = "badge - text")
    private MobileElement cartBadge;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"product info carousel\"`]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeImage")
    private MobileElement firstProductImage;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/pager")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"product info carousel\"`]/XCUIElementTypeScrollView")
    private MobileElement productImageScrollView;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/title")
    @iOSXCUITFindBy(id = "product info description")
    private MobileElement productInfoTitle;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/basicInfo")
    @iOSXCUITFindBy(id = "product info data")
    private MobileElement productInfoDescriptionText;

    @iOSXCUITFindBy(id = "product info last ordered")
    private MobileElement lastOrderedLabel;

    @iOSXCUITFindBy(id = "product info replacement button")
    private MobileElement productInfoReplacementButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"product info case pricing\"]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[@name=\"pricing cost button\"]")
    private MobileElement caseHandPricingButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"product info case pricing\"]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]")
    private MobileElement itemCasePrice;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"product info case pricing\"]/XCUIElementTypeOther[2]/XCUIElementTypeButton[@name=\"decrease quantity button\"]")
    private MobileElement decreaseCaseQuantityButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"product info case pricing\"]/XCUIElementTypeOther[2]/XCUIElementTypeTextField[@name=\"quantity text field\"]")
    private MobileElement quantityCaseInputField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"product info case pricing\"]/XCUIElementTypeOther[2]//XCUIElementTypeButton[@name=\"increase quantity button\"]")
    private MobileElement increaseCaseQuantityButton;

    @AndroidFindBy(id = "Product Details")
    @iOSXCUITFindBy(id = "Product Details")
    private MobileElement productDetailsButton;

    @AndroidFindBy(id = "Nutrition")
    @iOSXCUITFindBy(id = "Nutrition")
    private MobileElement nutritionButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"product details label\"]/XCUIElementTypeStaticText")
    private MobileElement text;

    @iOSXCUITFindBy(id = "collapsable read button")
    private MobileElement readMoreButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"product details\"`]/XCUIElementTypeOther[2]")
    private MobileElement productDetailsTable;

    @iOSXCUITFindBy(id = "Stock Status")
    private MobileElement stockStatus;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Stock Status\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement stockStatusValue;

    @iOSXCUITFindBy(id = "GTIN")
    private MobileElement gtin;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"GTIN\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement gtinValue;

    @iOSXCUITFindBy(id = "Manufacturer UPC")
    private MobileElement manufacturerUpc;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Manufacturer UPC\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement manufacturerUpcValue;

    @iOSXCUITFindBy(id = "Storage Location")
    private MobileElement storageLocation;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Storage Location\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement storageLocationValue;

    @iOSXCUITFindBy(id = "Split Detail")
    private MobileElement splitDetails;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Split Detail\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement splitDetailsValue;

    @iOSXCUITFindBy(id = "Average Weight")
    private MobileElement averageWeight;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Average Weight\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement averageWeightValue;

    @iOSXCUITFindBy(id = "Nutrition Facts")
    private MobileElement nutritionFactsTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"product info header selector\"]/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
    private MobileElement ingredientsListText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"product info header selector\"]/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText[2]")
    private MobileElement disclaimerText;


    /** Guest user elements */

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/becomeACustomer")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Become A Customer\"`]")
    private MobileElement becomeACustomerButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/signInText") //this does not work
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"guest sign in view\"`]/XCUIElementTypeButton[2]")
    private MobileElement guestSignInButton;


    public ProductCardPage checkElementsPresence(String expectedTitle, String expectedDescription) {
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(backButton.isDisplayed());
        softAssert.assertTrue(addToListButton.isDisplayed());
        softAssert.assertTrue(cartButton.isDisplayed());
        softAssert.assertTrue(productImageScrollView.isDisplayed());
        softAssert.assertTrue(productInfoTitle.isDisplayed());
        softAssert.assertTrue(productInfoDescriptionText.isDisplayed());
        softAssert.assertTrue(itemCasePrice.isDisplayed());
        softAssert.assertTrue(decreaseCaseQuantityButton.isDisplayed());
        softAssert.assertTrue(quantityCaseInputField.isDisplayed());
        softAssert.assertTrue(increaseCaseQuantityButton.isDisplayed());
        softAssert.assertTrue(productDetailsButton.isDisplayed());
        softAssert.assertTrue(nutritionButton.isDisplayed());
        softAssert.assertEquals(productInfoTitle.getText(), expectedTitle);
        softAssert.assertEquals(productInfoDescriptionText.getText(), expectedDescription);
        softAssert.assertAll();
        return this;
    }

    public ProductCardPage checkElementsPresenceForCase(String expectedCasePrice) {
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(itemCasePrice.isDisplayed());
        softAssert.assertTrue(decreaseCaseQuantityButton.isDisplayed());
        softAssert.assertTrue(quantityCaseInputField.isDisplayed());
        softAssert.assertTrue(increaseCaseQuantityButton.isDisplayed());
        softAssert.assertEquals(itemCasePrice.getText(), expectedCasePrice);
        softAssert.assertAll();
        return this;
    }

    public ProductCardPage checkElementsPresenceOnProductDetailsTab(String expectedStock, String expectedGtin,
                                                                    String expectedManufacturerUpc, String expectedStorageLocation,
                                                                    String expectedSplitDetails, String expectedAverageWeight) {
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(readMoreButton.isDisplayed());
        softAssert.assertAll();
        scrollDownByCoordinates();
        softAssert.assertTrue(productDetailsTable.isDisplayed());
        softAssert.assertTrue(stockStatus.isDisplayed());
        softAssert.assertTrue(stockStatusValue.isDisplayed());
        softAssert.assertTrue(gtin.isDisplayed());
        softAssert.assertTrue(gtinValue.isDisplayed());
        softAssert.assertTrue(manufacturerUpc.isDisplayed());
        softAssert.assertTrue(manufacturerUpcValue.isDisplayed());
        softAssert.assertTrue(storageLocation.isDisplayed());
        softAssert.assertTrue(storageLocationValue.isDisplayed());
        softAssert.assertTrue(splitDetails.isDisplayed());
        softAssert.assertTrue(splitDetailsValue.isDisplayed());
        softAssert.assertTrue(averageWeight.isDisplayed());
        softAssert.assertTrue(averageWeightValue.isDisplayed());
        softAssert.assertEquals(stockStatusValue.getText(), expectedStock);
        softAssert.assertEquals(gtinValue.getText(), expectedGtin);
        softAssert.assertEquals(manufacturerUpcValue.getText(), expectedManufacturerUpc);
        softAssert.assertEquals(storageLocationValue.getText(), expectedStorageLocation);
        softAssert.assertEquals(splitDetailsValue.getText(), expectedSplitDetails);
        softAssert.assertEquals(averageWeightValue.getText(), expectedAverageWeight);
        softAssert.assertAll();
        return this;
    }

    public ProductCardPage checkCaseQuantityFieldValue(String expectedQuantity) {
        Assert.assertEquals(quantityCaseInputField.getText(), expectedQuantity);
        return this;
    }

    public ProductCardPage checkCartBadgeValue(String expectedCartCount) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(cartBadge.isDisplayed());
        softAssert.assertEquals(cartBadge.getText(), expectedCartCount);
        softAssert.assertAll();
        return this;
    }

    public ProductCardPage checkElementsPresenceOnNutritionTab() {
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(nutritionFactsTitle.isDisplayed());
        softAssert.assertAll();
        scrollDownByCoordinates();
        softAssert.assertTrue(ingredientsListText.isDisplayed());
        softAssert.assertTrue(disclaimerText.isDisplayed());
        softAssert.assertAll();
        return this;
    }

    public AddToListPage pressAddToListButton() {
        click(addToListButton);
        return new AddToListPage();
    }

    public OrderCartPage pressOrderCartButton() {
        click(cartButton);
        return new OrderCartPage();
    }

    public ProductCardPage pressCaseMinusButton() {
        click(decreaseCaseQuantityButton);
        return new ProductCardPage();
    }

    public ProductCardPage pressCasePlusButton() {
        click(increaseCaseQuantityButton);
        return new ProductCardPage();
    }

    public ProductCardPage inputCaseQuantity(String quantity) {
        sendKeys(quantityCaseInputField, quantity, "Input quantity " + quantity);
        getDriver().getKeyboard().sendKeys("\n");
        return new ProductCardPage();
    }

    public HandPricingPage pressCaseHandPricingButton() {
        click(caseHandPricingButton);
        return new HandPricingPage();
    }

    public ProductCardPage pressProductDetailsButton() {
        click(productDetailsButton);
        return new ProductCardPage();
    }

    public ProductCardPage pressNutritionButton() {
        click(nutritionButton);
        return new ProductCardPage();
    }


    /** Guest user actions */

    public void pressBecomeCustomerButton() {
        click(becomeACustomerButton);
    }

    public LoginPage pressSignIn() {
        waitForVisibility(guestSignInButton, "guestSignInButton");
        click(guestSignInButton); // does not work on android
        return new LoginPage();
    }
}
