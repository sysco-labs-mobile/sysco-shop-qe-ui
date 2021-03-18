package com.qe.pages.orders;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ForgottenItemsPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(id = "Back")
    @iOSXCUITFindBy(id = "Back")
    private MobileElement backButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'toolbar')]/android.widget.TextView[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == 'app navigation bar'`]/XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
    private MobileElement navBarPriceValue;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'toolbar')]/android.widget.TextView[2]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == 'app navigation bar'`]/XCUIElementTypeOther/XCUIElementTypeStaticText[2]")
    private MobileElement navBarCsAndEaValues;

    @AndroidFindBy(id = "did_you_forget_title")
    @iOSXCUITFindBy(id = "Did you forget?")
    private MobileElement forgottenItemsPageHeader;

    @AndroidFindBy(id = "did_you_forget_description")
    @iOSXCUITFindBy(id = "Items you typically order are missing from your cart.")
    private MobileElement forgottenItemsPageDescription;

    @AndroidFindBy(id = "next_button")
    @iOSXCUITFindBy(id = "forgotten items next button")
    private MobileElement nextButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name='order forgotten items list']/XCUIElementTypeCell")
    private List<MobileElement> forgottenItems;

    /** First Product's elements */

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]")
    private MobileElement firstProduct;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'productDescription')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]")
    private MobileElement firstProductTitleText;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'popupMenu')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeButton[@name=\"dot menu button\"]")
    private MobileElement firstProductDotMenuButton;

    @AndroidFindBy(id = "android:id/content")
    @iOSXCUITFindBy(id = "Add to list")
    private MobileElement addToListButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'productInfoContainer')]//*[contains(@resource-id, 'productInfo')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[2]")
    private MobileElement firstProductDescriptionText;

    /** First Product's elements - for case price */

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'casePriceContainer')]//*[contains(@resource-id, 'priceLabel')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[3]")
    private MobileElement firstProductCasePrice;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'casePriceContainer')]//*[contains(@resource-id, 'cartItemCount')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`name == \"case quantity text field\"`][1]")
    private MobileElement firstProductCaseQuantityField;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'casePriceContainer')]//*[contains(@resource-id, 'addToCartMinus')]")
    @iOSXCUITFindBy(id = "decrease quantity button")
    private MobileElement firstProductCaseQuantityMinusButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'casePriceContainer')]//*[contains(@resource-id, 'addToCartPlus')]")
    @iOSXCUITFindBy(id = "increase quantity button")
    private MobileElement firstProductCaseQuantityPlusButton;

    /** First Product's elements - for each price */

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'eachPriceContainer')]//*[contains(@resource-id, 'priceLabel')]")
    private MobileElement firstProductEachPrice;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'eachPriceContainer')]//*[contains(@resource-id, 'cartItemCount')]")
    private MobileElement firstProductEachQuantityField;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'eachPriceContainer')]//*[contains(@resource-id, 'addToCartMinus')]")
    private MobileElement firstProductEachQuantityMinusButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'eachPriceContainer')]//*[contains(@resource-id, 'addToCartPlus')]")
    private MobileElement firstProductEachQuantityPlusButton;

    public ForgottenItemsPage checkElementsPresence(String expectedTotalPrice, String expectedCsAndEaValues) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(backButton.isDisplayed());
        softAssert.assertTrue(navBarPriceValue.isDisplayed());
        softAssert.assertTrue(navBarCsAndEaValues.isDisplayed());
        softAssert.assertTrue(forgottenItemsPageHeader.isDisplayed());
        softAssert.assertTrue(forgottenItemsPageDescription.isDisplayed());
        softAssert.assertTrue(nextButton.isDisplayed());
        softAssert.assertTrue(firstProduct.isDisplayed());
        softAssert.assertEquals(navBarPriceValue.getText(), expectedTotalPrice);
        softAssert.assertEquals(navBarCsAndEaValues.getText(), expectedCsAndEaValues);
        return this;
    }

    public ForgottenItemsPage checkElementsPresenceForFirstElement(String expectedTitle, String expectedDescription, String expectedCasePrice) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(firstProductTitleText.isDisplayed());
        softAssert.assertTrue(firstProductDescriptionText.isDisplayed());
        softAssert.assertTrue(firstProductDotMenuButton.isDisplayed());
        softAssert.assertTrue(firstProductCasePrice.isDisplayed());
        softAssert.assertTrue(firstProductCaseQuantityMinusButton.isDisplayed());
        softAssert.assertTrue(firstProductCaseQuantityPlusButton.isDisplayed());
        softAssert.assertEquals(firstProductTitleText.getText(), expectedTitle);
        softAssert.assertEquals(firstProductDescriptionText.getText(), expectedDescription);
        softAssert.assertEquals(firstProductCasePrice.getText(), expectedCasePrice);
        return this;
    }

    public OrderCartReviewOrderPage pressNextButton() {
        click(nextButton, "nextButton");
        return new OrderCartReviewOrderPage();
    }

    public OrderCartPage pressBackButton() {
        click(backButton, "backButton");
        return new OrderCartPage();
    }
}
