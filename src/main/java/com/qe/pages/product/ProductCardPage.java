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
        utils.log().info("Check elements presence on Product card page");
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(backButton.isDisplayed(), "backButton");
        softAssert.assertTrue(addToListButton.isDisplayed(), "addToListButton");
        softAssert.assertTrue(cartButton.isDisplayed(), "cartButton");
        softAssert.assertTrue(productImageScrollView.isDisplayed(), "productImageScrollView");
        softAssert.assertTrue(productInfoTitle.isDisplayed(), "productInfoTitle");
        softAssert.assertTrue(productInfoDescriptionText.isDisplayed(), "productInfoDescriptionText");
        softAssert.assertTrue(itemCasePrice.isDisplayed(), "itemCasePrice");
        softAssert.assertTrue(decreaseCaseQuantityButton.isDisplayed(), "decreaseCaseQuantityButton");
        softAssert.assertTrue(quantityCaseInputField.isDisplayed(), "quantityCaseInputField");
        softAssert.assertTrue(increaseCaseQuantityButton.isDisplayed(), "increaseCaseQuantityButton");
        softAssert.assertTrue(productDetailsButton.isDisplayed(), "productDetailsButton");
        softAssert.assertTrue(nutritionButton.isDisplayed(), "nutritionButton");
        softAssert.assertEquals(productInfoTitle.getText(), expectedTitle, productInfoTitle.getText() + "productInfoTitle.getText() to equal " + expectedTitle);
        softAssert.assertEquals(productInfoDescriptionText.getText(), expectedDescription, productInfoDescriptionText.getText() + " productInfoDescriptionText.getText() to equal expectedDescription");
        softAssert.assertAll();
        return this;
    }

    public ProductCardPage checkElementsPresenceForCase(String expectedCasePrice) {
        utils.log().info("Check elements presence on Product card page for case price");
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(itemCasePrice.isDisplayed(), "itemCasePrice");
        softAssert.assertTrue(decreaseCaseQuantityButton.isDisplayed(), "decreaseCaseQuantityButton");
        softAssert.assertTrue(quantityCaseInputField.isDisplayed(), "quantityCaseInputField");
        softAssert.assertTrue(increaseCaseQuantityButton.isDisplayed(), "increaseCaseQuantityButton");
        softAssert.assertEquals(itemCasePrice.getText(), expectedCasePrice, itemCasePrice.getText() + "itemCasePrice.getText() to equal " + expectedCasePrice);
        softAssert.assertAll();
        return this;
    }

    public ProductCardPage checkElementsPresenceOnProductDetailsTab(String expectedStock, String expectedGtin,
                                                                    String expectedManufacturerUpc, String expectedStorageLocation,
                                                                    String expectedSplitDetails, String expectedAverageWeight) {
        utils.log().info("Check elements presence on Product card page on Product Details tab");
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(readMoreButton.isDisplayed(), "readMoreButton");
        softAssert.assertAll();
        scrollDownByCoordinates();
        softAssert.assertTrue(productDetailsTable.isDisplayed(), "productDetailsTable");
        softAssert.assertTrue(stockStatus.isDisplayed(), "stockStatus");
        softAssert.assertTrue(stockStatusValue.isDisplayed(), "stockStatusValue");
        softAssert.assertTrue(gtin.isDisplayed(), "gtin");
        softAssert.assertTrue(gtinValue.isDisplayed(), "gtinValue");
        softAssert.assertTrue(manufacturerUpc.isDisplayed(), "manufacturerUpc");
        softAssert.assertTrue(manufacturerUpcValue.isDisplayed(), "manufacturerUpcValue");
        softAssert.assertTrue(storageLocation.isDisplayed(), "storageLocation");
        softAssert.assertTrue(storageLocationValue.isDisplayed(), "storageLocationValue");
        softAssert.assertTrue(splitDetails.isDisplayed(), "splitDetails");
        softAssert.assertTrue(splitDetailsValue.isDisplayed(), "splitDetailsValue");
        softAssert.assertTrue(averageWeight.isDisplayed(), "averageWeight");
        softAssert.assertTrue(averageWeightValue.isDisplayed(), "averageWeightValue");
        softAssert.assertEquals(stockStatusValue.getText(), expectedStock, stockStatusValue.getText() + " stockStatusValue.getText() to equal " +expectedStock);
        softAssert.assertEquals(gtinValue.getText(), expectedGtin, gtinValue.getText() + " gtinValue.getText() to equal " + expectedGtin);
        softAssert.assertEquals(manufacturerUpcValue.getText(), expectedManufacturerUpc, manufacturerUpcValue.getText() + " manufacturerUpcValue.getText() to equal " + expectedManufacturerUpc);
        softAssert.assertEquals(storageLocationValue.getText(), expectedStorageLocation, storageLocationValue.getText() + " storageLocationValue.getText() to equal " + storageLocationValue.getText());
        softAssert.assertEquals(splitDetailsValue.getText(), expectedSplitDetails, splitDetailsValue.getText() + " splitDetailsValue.getText() to equal " + expectedSplitDetails);
        softAssert.assertEquals(averageWeightValue.getText(), expectedAverageWeight, averageWeightValue.getText() + " averageWeightValue.getText() to equal " + averageWeightValue.getText());
        softAssert.assertAll();
        return this;
    }

    public ProductCardPage checkCaseQuantityFieldValue(String expectedQuantity) {
        utils.log().info("Check case quantity input field on Product page to have value " + expectedQuantity);
        Assert.assertEquals(quantityCaseInputField.getText(), expectedQuantity);
        return this;
    }

    public ProductCardPage checkCartBadgeValue(String expectedCartCount) {
        utils.log().info("Check cart count on Product page to have value " + expectedCartCount);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(cartBadge.isDisplayed());
        softAssert.assertEquals(cartBadge.getText(), expectedCartCount);
        softAssert.assertAll();
        return this;
    }

    public ProductCardPage checkElementsPresenceOnNutritionTab() {
        utils.log().info("Check elements presence on Nutrition tab");
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(nutritionFactsTitle.isDisplayed(), "nutritionFactsTitle");
        softAssert.assertAll();
        scrollDownByCoordinates();
        softAssert.assertTrue(ingredientsListText.isDisplayed(), "ingredientsListText");
        softAssert.assertTrue(disclaimerText.isDisplayed(), "disclaimerText");
        softAssert.assertAll();
        return this;
    }

    public AddToListPage pressAddToListButton() {
        click(addToListButton, "Press add to list button on Product Card page");
        return new AddToListPage();
    }

    public OrderCartPage pressOrderCartButton() {
        click(cartButton, "Press order car button on Product Card page");
        return new OrderCartPage();
    }

    public ProductCardPage pressCaseMinusButton() {
        click(decreaseCaseQuantityButton, "Press - button for case quantity");
        return new ProductCardPage();
    }

    public ProductCardPage pressCasePlusButton() {
        click(increaseCaseQuantityButton, "Press + button for case quantity\"");
        return new ProductCardPage();
    }

    public ProductCardPage inputCaseQuantity(String quantity) {
        sendKeys(quantityCaseInputField, quantity, "Input quantity " + quantity + " and hide keyboard");
        getDriver().getKeyboard().sendKeys("\n");
        return new ProductCardPage();
    }

    public HandPricingPage pressCaseHandPricingButton() {
        click(caseHandPricingButton, "Press hand pricing button on Product card page");
        return new HandPricingPage();
    }

    public ProductCardPage pressProductDetailsButton() {
        click(productDetailsButton, "Press product details tab on Product card page");
        return new ProductCardPage();
    }

    public ProductCardPage pressNutritionButton() {
        click(nutritionButton, "Press nutirtion tab on Product card page");
        return new ProductCardPage();
    }


    /** Guest user actions */

    public void pressBecomeCustomerButton() {
        click(becomeACustomerButton, "Press become customer button on Product card page");
    }

    public LoginPage pressSignIn() {
        waitForVisibility(guestSignInButton, "guestSignInButton");
        click(guestSignInButton, "Press sign in button on Product Card page"); // does not work on android
        return new LoginPage();
    }
}
