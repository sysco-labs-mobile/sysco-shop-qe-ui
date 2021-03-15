package com.qe.pages.product;

import com.qe.BaseTest;
import com.qe.pages.lists.AddToListPage;
import com.qe.pages.login.LoginPage;
import com.qe.pages.orders.OrderCartPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ProductCardPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(id = "Back")
    private MobileElement backButton;

    @AndroidFindBy(id = "action_add_to_list")
    @iOSXCUITFindBy(id = "product info add to list")
    private MobileElement addToListButton;

    @AndroidFindBy(id = "cart_icon")
    @iOSXCUITFindBy(id = "cart button")
    private MobileElement cartButton;

    @AndroidFindBy(id = "cart_badge")
    @iOSXCUITFindBy(id = "badge - text")
    private MobileElement cartBadge;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"product info carousel\"`]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeImage")
    private MobileElement firstProductImage;

    @AndroidFindBy(id = "pager")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"product info carousel\"`]/XCUIElementTypeScrollView")
    private MobileElement productImageScrollView;

    @AndroidFindBy(id = "title")
    @iOSXCUITFindBy(id = "product info description")
    private MobileElement productInfoTitle;

    @AndroidFindBy(id = "basicInfo")
    @iOSXCUITFindBy(id = "product info data")
    private MobileElement productInfoDescriptionText;

    @AndroidFindBy(id = "lastOrdered")
    @iOSXCUITFindBy(id = "product info last ordered")
    private MobileElement lastOrderedLabel;

    @AndroidFindBy(id = "itemFlag")
    @iOSXCUITFindBy(id = "product info replacement button")
    private MobileElement productInfoReplacementButton;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"product info case pricing\"]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[@name=\"pricing cost button\"]")
    private MobileElement caseHandPricingButton;

    @AndroidFindBy(id = "priceLabel")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"product info case pricing\"]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]")
    private MobileElement itemCasePrice;

    @AndroidFindBy(id = "addToCartMinus")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"product info case pricing\"]/XCUIElementTypeOther[2]/XCUIElementTypeButton[@name=\"decrease quantity button\"]")
    private MobileElement decreaseCaseQuantityButton;

    @AndroidFindBy(id = "cartItemCount")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"product info case pricing\"]/XCUIElementTypeOther[2]/XCUIElementTypeTextField[@name=\"quantity text field\"]")
    private MobileElement quantityCaseInputField;

    @AndroidFindBy(id = "addToCartPlus")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"product info case pricing\"]/XCUIElementTypeOther[2]//XCUIElementTypeButton[@name=\"increase quantity button\"]")
    private MobileElement increaseCaseQuantityButton;

//    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Product Details']")
    @AndroidFindBy(accessibility = "Product Details")
    @iOSXCUITFindBy(id = "Product Details")
    private MobileElement productDetailsButton;

//    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Nutrition']")
    @AndroidFindBy(accessibility = "Nutrition")
    @iOSXCUITFindBy(id = "Nutrition")
    private MobileElement nutritionButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"product details label\"]/XCUIElementTypeStaticText")
    private MobileElement text;

    @AndroidFindBy(id = "showMoreShowLess")
    @iOSXCUITFindBy(id = "collapsable read button")
    private MobileElement readMoreButton;

    @AndroidFindBy(id = "attributesRecycler")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"product details\"`]/XCUIElementTypeOther[2]")
    private MobileElement productDetailsTable;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stock Status']")
    @iOSXCUITFindBy(id = "Stock Status")
    private MobileElement stockStatus;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stock Status']//following-sibling::android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Stock Status\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement stockStatusValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='GTIN']")
    @iOSXCUITFindBy(id = "GTIN")
    private MobileElement gtin;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='GTIN']/following-sibling::android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"GTIN\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement gtinValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Manufacturer UPC']")
    @iOSXCUITFindBy(id = "Manufacturer UPC")
    private MobileElement manufacturerUpc;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Manufacturer UPC']/following-sibling::android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Manufacturer UPC\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement manufacturerUpcValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Storage Location']")
    @iOSXCUITFindBy(id = "Storage Location")
    private MobileElement storageLocation;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Storage Location']/following-sibling::android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Storage Location\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement storageLocationValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Split']")
    @iOSXCUITFindBy(id = "Split Detail")
    private MobileElement splitDetails;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Split']/following-sibling::android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Split Detail\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement splitDetailsValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Average Weight']")
    @iOSXCUITFindBy(id = "Average Weight")
    private MobileElement averageWeight;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Average Weight']/following-sibling::android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Average Weight\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement averageWeightValue;

    @AndroidFindBy(xpath = "//android.view.View[@text='Nutrition Facts']")
    @iOSXCUITFindBy(id = "Nutrition Facts")
    private MobileElement nutritionFactsTitle;

    @AndroidFindBy(id = "ingredientsText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"product info header selector\"]/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
    private MobileElement ingredientsListText;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Disclaimer')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"product info header selector\"]/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText[2]")
    private MobileElement disclaimerText;


    /** Guest user elements */

    @AndroidFindBy(id = "becomeACustomer")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Become A Customer\"`]")
    private MobileElement becomeACustomerButton;

    @AndroidFindBy(id = "signInText") //this does not work
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
        softAssert.assertEquals(productInfoTitle.getText(), expectedTitle, productInfoTitle.getText() + " productInfoTitle.getText() to equal " + expectedTitle);
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
        softAssert.assertEquals(itemCasePrice.getText().replace("\n", ""), expectedCasePrice);
        softAssert.assertAll();
        return this;
    }

    public ProductCardPage checkElementsPresenceOnProductDetailsTab(String expectedStock, String expectedGtin,
                                                                    String expectedManufacturerUpc, String expectedStorageLocation,
                                                                    String expectedSplitDetails, String expectedAverageWeight) {
        utils.log().info("Check elements presence on Product card page on Product Details tab");
        SoftAssert softAssert =new SoftAssert();
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
        click(increaseCaseQuantityButton, "Press + button for case quantity");
        return new ProductCardPage();
    }

    public ProductCardPage inputCaseQuantity(String quantity) {
        sendKeys(quantityCaseInputField, quantity, "Input quantity " + quantity + " and hide keyboard");
        if(getPlatform().equalsIgnoreCase("iOS")) {
            getDriver().getKeyboard().sendKeys("\n");
        }
        if(getPlatform().equalsIgnoreCase("Android")) {
            click(quantityCaseInputField);
            ((AndroidDriver) getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
        }
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
