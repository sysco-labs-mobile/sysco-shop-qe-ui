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

public class ProductCardDetailsPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(id = "Back")
    private MobileElement backButton;

    @AndroidFindBy(id = "description")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"product details label\"]/XCUIElementTypeStaticText")
    private MobileElement text;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='GTIN']")
    @iOSXCUITFindBy(id = "GTIN")
    private MobileElement gtin;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='GTIN']/following-sibling::android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"GTIN\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement gtinValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Storage Location']")
    @iOSXCUITFindBy(id = "Storage Location")
    private MobileElement storageLocation;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Storage Location']/following-sibling::android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Storage Location\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement storageLocationValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Manufacturer UPC']")
    @iOSXCUITFindBy(id = "Manufacturer UPC")
    private MobileElement manufacturerUpc;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Manufacturer UPC']/following-sibling::android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Manufacturer UPC\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement manufacturerUpcValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Average Weight']")
    @iOSXCUITFindBy(id = "Average Weight")
    private MobileElement averageWeight;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Average Weight']/following-sibling::android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Average Weight\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement averageWeightValue;

    public ProductCardDetailsPage checkElementsPresence() {
        utils.log().info("Check elements presence on Product card page on Product Details tab");
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertAll();
        scrollDownByCoordinates();
        softAssert.assertTrue(gtin.isDisplayed(), "gtin");
        softAssert.assertTrue(gtinValue.isDisplayed(), "gtinValue");
        softAssert.assertTrue(manufacturerUpc.isDisplayed(), "manufacturerUpc");
        softAssert.assertTrue(manufacturerUpcValue.isDisplayed(), "manufacturerUpcValue");
        softAssert.assertTrue(storageLocation.isDisplayed(), "storageLocation");
        softAssert.assertTrue(storageLocationValue.isDisplayed(), "storageLocationValue");
        softAssert.assertTrue(averageWeight.isDisplayed(), "averageWeight");
        softAssert.assertTrue(averageWeightValue.isDisplayed(), "averageWeightValue");
        softAssert.assertAll();
        return this;
    }

    public ProductCardDetailsPage checkElementsPresence(String expectedGtin, String expectedManufacturerUpc,
                                                        String expectedStorageLocation, String expectedAverageWeight) {
        utils.log().info("Check elements presence on Product card page on Product Details tab");
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertAll();
        softAssert.assertTrue(gtin.isDisplayed(), "gtin");
        softAssert.assertTrue(gtinValue.isDisplayed(), "gtinValue");
        softAssert.assertTrue(manufacturerUpc.isDisplayed(), "manufacturerUpc");
        softAssert.assertTrue(manufacturerUpcValue.isDisplayed(), "manufacturerUpcValue");
        softAssert.assertTrue(storageLocation.isDisplayed(), "storageLocation");
        softAssert.assertTrue(storageLocationValue.isDisplayed(), "storageLocationValue");
        softAssert.assertTrue(averageWeight.isDisplayed(), "averageWeight");
        softAssert.assertTrue(averageWeightValue.isDisplayed(), "averageWeightValue");
        softAssert.assertEquals(gtinValue.getText(), expectedGtin, " gtinValue.getText() to equal " + expectedGtin);
        softAssert.assertEquals(manufacturerUpcValue.getText(), expectedManufacturerUpc, " manufacturerUpcValue.getText() to equal " + expectedManufacturerUpc);
        softAssert.assertEquals(storageLocationValue.getText(), expectedStorageLocation, " storageLocationValue.getText() to equal " + storageLocationValue.getText());
        softAssert.assertEquals(averageWeightValue.getText(), expectedAverageWeight, " averageWeightValue.getText() to equal " + averageWeightValue.getText());
        softAssert.assertAll();
        return this;
    }

    public ProductCardPage pressBackButton() {
        click(backButton);
        return new ProductCardPage();
    }
}
