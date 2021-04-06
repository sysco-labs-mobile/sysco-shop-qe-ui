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

    @AndroidFindBy(id = "brand")
    @iOSXCUITFindBy(id = "product brand button")
    private MobileElement productBrandButton;

    @AndroidFindBy(id = "brand")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='product brand button']/XCUIElementTypeStaticText")
    private MobileElement productBrandText;

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

    @AndroidFindBy(id = "stockStatus")
    @iOSXCUITFindBy(id = "opco name")
    private MobileElement stockStatus;

    @AndroidFindBy(id = "buttonDetails")
    @iOSXCUITFindBy(id = "product detail section")
    private MobileElement detailsButton;

    @AndroidFindBy(id = "buttonNutrition")
    @iOSXCUITFindBy(id = "nutrition facts section")
    private MobileElement nutritionButton;


    /** Guest user elements */

    @AndroidFindBy(id = "becomeACustomer")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Become A Customer\"`]")
    private MobileElement becomeACustomerButton;

    @AndroidFindBy(id = "signInText") //this does not work
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"guest sign in view\"`]/XCUIElementTypeButton[2]")
    private MobileElement guestSignInButton;


    public ProductCardPage checkElementsPresence() {
        utils.log().info("Check elements presence on Product card page");
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(backButton.isDisplayed(), "backButton");
        softAssert.assertTrue(addToListButton.isDisplayed(), "addToListButton");
        softAssert.assertTrue(cartButton.isDisplayed(), "cartButton");
        softAssert.assertTrue(productImageScrollView.isDisplayed(), "productImageScrollView");
        softAssert.assertTrue(productBrandButton.isDisplayed(), "productBrandButton");
        softAssert.assertTrue(productBrandText.isDisplayed(), "productBrandText");
        softAssert.assertTrue(productInfoTitle.isDisplayed(), "productInfoTitle");
        softAssert.assertTrue(productInfoDescriptionText.isDisplayed(), "productInfoDescriptionText");
        softAssert.assertTrue(itemCasePrice.isDisplayed(), "itemCasePrice");
        softAssert.assertTrue(decreaseCaseQuantityButton.isDisplayed(), "decreaseCaseQuantityButton");
        softAssert.assertTrue(quantityCaseInputField.isDisplayed(), "quantityCaseInputField");
        softAssert.assertTrue(increaseCaseQuantityButton.isDisplayed(), "increaseCaseQuantityButton");
        scrollDownByCoordinates();
        softAssert.assertTrue(detailsButton.isDisplayed(), "productDetailsButton");
        softAssert.assertTrue(nutritionButton.isDisplayed(), "nutritionButton");
        softAssert.assertAll();
        return this;
    }

    public ProductCardPage checkElementsPresence(String expectedBrand, String expectedTitle, String expectedDescription) {
        checkElementsPresence();
        utils.log().info("Check elements data equality on Product card page");
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertEquals(productBrandText.getText(), expectedBrand, " productBrandText.getText() to equal " + expectedBrand);
        softAssert.assertEquals(productInfoTitle.getText(), expectedTitle, " productInfoTitle.getText() to equal " + expectedTitle);
        softAssert.assertEquals(productInfoDescriptionText.getText(), expectedDescription, " productInfoDescriptionText.getText() to equal expectedDescription");
        softAssert.assertAll();
        return this;
    }

    public ProductCardPage checkElementsPresenceForPriceCase() {
        utils.log().info("Check elements presence on Product card page for case price");
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(itemCasePrice.isDisplayed(), "itemCasePrice");
        softAssert.assertTrue(decreaseCaseQuantityButton.isDisplayed(), "decreaseCaseQuantityButton");
        softAssert.assertTrue(quantityCaseInputField.isDisplayed(), "quantityCaseInputField");
        softAssert.assertTrue(increaseCaseQuantityButton.isDisplayed(), "increaseCaseQuantityButton");
        softAssert.assertAll();
        return this;
    }

    public ProductCardPage checkElementsPresenceForPriceCase(String expectedCasePrice) {
        checkElementsPresenceForPriceCase();
        utils.log().info("Check elements data equality on Product card page for case price");
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertEquals(itemCasePrice.getText().replace("\n", ""), expectedCasePrice);
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

    public ProductCardDetailsPage pressProductDetailsButton() {
        click(detailsButton, "Press product details on Product card page");
        return new ProductCardDetailsPage();
    }

    public ProductCardNutritionPage pressNutritionButton() {
        click(nutritionButton, "Press nutrition on Product card page");
        return new ProductCardNutritionPage();
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
