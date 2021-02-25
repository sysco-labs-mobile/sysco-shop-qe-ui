package com.qe.pages.product;

import com.qe.BaseTest;
import com.qe.pages.lists.AddToListPage;
import com.qe.pages.login.LoginPage;
import com.qe.pages.orders.OrderCartPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductCardPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(id = "Navigate up")
    @iOSXCUITFindBy(id = "Back")
    private MobileElement backButton;

    @iOSXCUITFindBy(id = "product info add to list")
    private MobileElement addToListButton;

    @iOSXCUITFindBy(id = "cart button")
    private MobileElement cartButton;

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
        Assert.assertTrue(backButton.isDisplayed());
        Assert.assertTrue(addToListButton.isDisplayed());
        Assert.assertTrue(cartButton.isDisplayed());
        Assert.assertTrue(productImageScrollView.isDisplayed());
        Assert.assertTrue(productInfoTitle.isDisplayed());
        Assert.assertTrue(productInfoDescriptionText.isDisplayed());
        Assert.assertTrue(itemCasePrice.isDisplayed());
        Assert.assertTrue(decreaseCaseQuantityButton.isDisplayed());
        Assert.assertTrue(quantityCaseInputField.isDisplayed());
        Assert.assertTrue(increaseCaseQuantityButton.isDisplayed());
        Assert.assertTrue(productDetailsButton.isDisplayed());
        Assert.assertTrue(nutritionButton.isDisplayed());
        Assert.assertEquals(productInfoTitle.getText(), expectedTitle);
        Assert.assertEquals(productInfoDescriptionText.getText(), expectedDescription);
        return this;
    }

    public ProductCardPage checkElementsPresenceForCase(String expectedCasePrice) {
        Assert.assertTrue(itemCasePrice.isDisplayed());
        Assert.assertTrue(decreaseCaseQuantityButton.isDisplayed());
        Assert.assertTrue(quantityCaseInputField.isDisplayed());
        Assert.assertTrue(increaseCaseQuantityButton.isDisplayed());
        Assert.assertEquals(itemCasePrice.getText(), expectedCasePrice);
        return this;
    }

    public ProductCardPage checkElementsPresenceOnProductDetailsTab(String expectedStock, String expectedGtin,
                                                                    String expectedManufacturerUpc, String expectedStorageLocation,
                                                                    String expectedSplitDetails, String expectedAverageWeight) {
        Assert.assertTrue(readMoreButton.isDisplayed());
        if(getPlatform().equalsIgnoreCase("iOS")) {
            scrollDownByCoordinates();
        }
        if(getPlatform().equalsIgnoreCase("Android")) {
            //androidScrollDown();
        }
        Assert.assertTrue(productDetailsTable.isDisplayed());
        Assert.assertTrue(stockStatus.isDisplayed());
        Assert.assertTrue(stockStatusValue.isDisplayed());
        Assert.assertTrue(gtin.isDisplayed());
        Assert.assertTrue(gtinValue.isDisplayed());
        Assert.assertTrue(manufacturerUpc.isDisplayed());
        Assert.assertTrue(manufacturerUpcValue.isDisplayed());
        Assert.assertTrue(storageLocation.isDisplayed());
        Assert.assertTrue(storageLocationValue.isDisplayed());
        Assert.assertTrue(splitDetails.isDisplayed());
        Assert.assertTrue(splitDetailsValue.isDisplayed());
        Assert.assertTrue(averageWeight.isDisplayed());
        Assert.assertTrue(averageWeightValue.isDisplayed());
        Assert.assertEquals(stockStatusValue.getText(), expectedStock);
        Assert.assertEquals(gtinValue.getText(), expectedGtin);
        Assert.assertEquals(manufacturerUpcValue.getText(), expectedManufacturerUpc);
        Assert.assertEquals(storageLocationValue.getText(), expectedStorageLocation);
        Assert.assertEquals(splitDetailsValue.getText(), expectedSplitDetails);
        Assert.assertEquals(averageWeightValue.getText(), expectedAverageWeight);
        return this;
    }

    public ProductCardPage checkElementsPresenceOnNutritionTab() {
        Assert.assertTrue(nutritionFactsTitle.isDisplayed());
        if(getPlatform().equalsIgnoreCase("iOS")) {
            scrollDownByCoordinates();
        }
        if(getPlatform().equalsIgnoreCase("Android")) {
            //androidScrollDown();
        }
        Assert.assertTrue(ingredientsListText.isDisplayed());
        Assert.assertTrue(disclaimerText.isDisplayed());
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
        click(decreaseCaseQuantityButton);
        return new ProductCardPage();
    }

    public ProductCardPage inputCaseQuantity(String quantity) {
        sendKeys(quantityCaseInputField, quantity, "Input quantity " + quantity);
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
        waitForVisibility(guestSignInButton);
        click(guestSignInButton); // does not work on android
        return new LoginPage();
    }
}
