package com.qe.pages.product;

import com.qe.BaseTest;
import com.qe.pages.login.LoginPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

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
    private MobileElement lastOrderedLabel;//not always present

    @iOSXCUITFindBy(id = "product info replacement button")
    private MobileElement productInfoReplacementButton;//not always present

    @iOSXCUITFindBy(id = "pricing cost button")
    private MobileElement handPricingButton;//not always present, after qty input

    @iOSXCUITFindBy(id = "CS (avg. 20.37LB) @ $2.657/LB")
    private MobileElement itemPrice;

    @iOSXCUITFindBy(id = "decrease quantity button")
    private MobileElement decreaseQuantityButton;

    @iOSXCUITFindBy(id = "quantity text field")
    private MobileElement quantityInputField;

    @iOSXCUITFindBy(id = "increase quantity button")
    private MobileElement increaseQuantityButton;

    @AndroidFindBy(id = "Product Details")
    @iOSXCUITFindBy(id = "Product Details")
    private MobileElement productDetailsButton;

    @AndroidFindBy(id = "Nutrition")
    @iOSXCUITFindBy(id = "Nutrition")
    private MobileElement nutritionButton;

    @iOSXCUITFindBy(id = "collapsable read button")
    private MobileElement readMoreButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"product details\"`]/XCUIElementTypeOther[2]")
    private MobileElement productDetailsTable;

    @iOSXCUITFindBy(id = "Stock Status")
    private MobileElement stockStatus;

    @iOSXCUITFindBy(id = "S")
    private MobileElement stockStatusValue;

    @iOSXCUITFindBy(id = "GTIN")
    private MobileElement gtin;

    @iOSXCUITFindBy(id = "90734730297203")
    private MobileElement gtinValue;

    @iOSXCUITFindBy(id = "Manufacturer UPC")
    private MobileElement manufacturerUpc;

    @iOSXCUITFindBy(id = "66709")
    private MobileElement manufacturerUpcValue;

    @iOSXCUITFindBy(id = "Storage Location")
    private MobileElement storageLocation;

    @iOSXCUITFindBy(id = "C")
    private MobileElement storageLocationValue;

    @iOSXCUITFindBy(id = "Split Detail")
    private MobileElement splitDetails;

    @iOSXCUITFindBy(id = "N")
    private MobileElement splitDetailsValue;

    @iOSXCUITFindBy(id = "Average Weight")
    private MobileElement averageWeight;

    @iOSXCUITFindBy(id = "20.366")
    private MobileElement averageWeightValue;

    @iOSXCUITFindBy(id = "Nutrition Facts")
    private MobileElement nutritionFactsTitle;

    @iOSXCUITFindBy(id = "Ingredients: GROUND BEEF")
    private MobileElement ingredientsListText;

    @iOSXCUITFindBy(id = "The % Daily Value (DV) tells you how much a nutrient in a serving of food contributes to a daily diet. 2000 calories a day is used for general nutrition advice.")
    private MobileElement nutrientServingInfoText;

    @iOSXCUITFindBy(id = "Disclaimer The nutrition information, ingredients/allergens and attributes/diet types displayed as well as any corresponding claims related thereto, including without limitation, claims regarding the vegetarian, vegan, Kosher, and gluten-free status of a product or item (collectively, “Product Information & Attributes/Diet Types/Claims”) are provided by product manufacturers and suppliers. Such information may not be complete and/or up to date. You should defer to the product packaging and/or consult with the product manufacturer for complete and current product information. Determination of whether or not a product or item meets the parameters of a specific lifestyle/diet is at your discretion and risk. Sysco and its affiliates do not guarantee the validity, accuracy or completeness of any Product Information & Attributes/Diet Types/Claim, and you hereby release Sysco and its affiliates for all claims in any way related to the Product Information & Attributes/Diet Types/Claims. Note that if an item is linked to nutrition information from the USDA National Nutrient Database for Standard Reference, ingredients and allergens will not be displayed. Percent Daily Values are based on 1990 NLEA regulations.")
    private MobileElement disclaimerText;

    /** Guest user elements */
    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/becomeACustomer")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Become A Customer\"`]")
    private MobileElement becomeACustomerButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/signInText") //this does not work
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"guest sign in view\"`]/XCUIElementTypeButton[2]")
    private MobileElement guestSignInButton;

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
