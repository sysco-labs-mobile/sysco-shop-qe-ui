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

public class ProductCardNutritionPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(id = "Back")
    private MobileElement backButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Nutrition Info']")
    @iOSXCUITFindBy(id = "nutrition info title label")
    private MobileElement nutritionInfoTitle;

    @AndroidFindBy(xpath = "//android.webkit.WebView")
    @iOSXCUITFindBy(id = "Nutrition Facts")
    private MobileElement nutritionFactsTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Ingredients']")
    @iOSXCUITFindBy(id = "Ingredients")
    private MobileElement ingredientsHeader;

    @AndroidFindBy(id = "ingredientsText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Ingredients']/following-sibling::XCUIElementTypeStaticText")
    private MobileElement ingredientsListText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Disclaimer']")
    @iOSXCUITFindBy(id = "Disclaimer")
    private MobileElement disclaimerHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Disclaimer']/following-sibling::android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Disclaimer']/following-sibling::XCUIElementTypeStaticText")
    private MobileElement disclaimerText;


    public ProductCardNutritionPage checkElementsPresence() {
        utils.log().info("Check elements presence on Product card page for case price");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(backButton.isDisplayed(), "itemCasePrice");
        softAssert.assertTrue(nutritionInfoTitle.isDisplayed(), "nutritionInfoTitle");
        softAssert.assertTrue(nutritionFactsTitle.isDisplayed(), "nutritionFactsTitle");
        softAssert.assertAll();
        scrollDownByCoordinates();
        softAssert = new SoftAssert();
        softAssert.assertTrue(ingredientsHeader.isDisplayed(), "ingredientsHeader");
        softAssert.assertTrue(ingredientsListText.isDisplayed(), "quantityCaseInputField");
        softAssert.assertTrue(disclaimerHeader.isDisplayed(), "disclaimerHeader");
        softAssert.assertTrue(disclaimerText.isDisplayed(), "disclaimerText");
        softAssert.assertAll();
        return this;
    }

    public ProductCardPage pressBackButton() {
        click(backButton);
        return new ProductCardPage();
    }

}
