package com.qe.pages.lists;

import com.qe.BaseTest;
import com.qe.pages.common.ProductThreeDotPopUp;
import com.qe.pages.lists.filter.ListFilterPage;
import com.qe.pages.lists.par.SelectParPage;
import com.qe.pages.orders.OrderCartPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ListPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(id = "Back")
    private MobileElement backButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'toolbar')]/android.widget.TextView[1]")
    @iOSXCUITFindBy(id = "list details - title label")
    private MobileElement listNameLabel;

    @AndroidFindBy(id = "action_cart")
    @iOSXCUITFindBy(id = "cart button")
    private MobileElement cartButton;

    @AndroidFindBy(id = "editText")
    @iOSXCUITFindBy(id = "search filter view - search input text field")
    private MobileElement listSearchInputField;

    @iOSXCUITFindBy(id = "Search in Listname")
    private MobileElement iosListSearchInputFieldLabel;

    @AndroidFindBy(accessibility = "Cancel")
    @AndroidFindBy(id = "iconEnd")
    private MobileElement listSearchCancelButton;

    @AndroidFindBy(id = "resetProductList")
    private MobileElement resetButton;

    @AndroidFindBy(accessibility = "Edit")
    @iOSXCUITFindBy(id = "list details - settings button")
    private MobileElement listSettingsButton;

    @AndroidFindBy(accessibility = "Filter")
    @iOSXCUITFindBy(id = "search filter view - filter button")
    private MobileElement listFilterButton;

    @AndroidFindBy(id = "numResultsForSearch")
    @iOSXCUITFindBy(className = "list details - item count label")
    private MobileElement itemCountLabel;

    @AndroidFindBy(id = "appliedFilters")
    private MobileElement appliedFiltersLabel;


    /** First Products elements */

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'listOfProducts')]/android.view.ViewGroup[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]")
    private MobileElement firstProduct;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'listOfProducts')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'productDescription')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]")
    private MobileElement firstProductTitleText;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'listOfProducts')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'popupMenu')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeButton[@name='dot menu button']")
    private MobileElement firstProductDotMenuButton;

    @iOSXCUITFindBy(id = "Add to list")
    private MobileElement addToListButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'listOfProducts')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'productInfoContainer')]//*[contains(@resource-id, 'productInfo')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[2]")
    private MobileElement firstProductDescriptionText;

    /** First Product's elements - for case price */

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'listOfProducts')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'casePriceContainer')]//*[contains(@resource-id, 'priceLabel')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[3]")
    private MobileElement firstProductCasePrice;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'listOfProducts')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'casePriceContainer')]//*[contains(@resource-id, 'cartItemCount')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`name == 'case quantity text field'`][1]")
    private MobileElement firstProductCaseQuantityField;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'listOfProducts')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'casePriceContainer')]//*[contains(@resource-id, 'addToCartMinus')]")
    @iOSXCUITFindBy(id = "decrease quantity button")
    private MobileElement firstProductCaseQuantityMinusButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'listOfProducts')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'casePriceContainer')]//*[contains(@resource-id, 'addToCartPlus')]")
    @iOSXCUITFindBy(id = "increase quantity button")
    private MobileElement firstProductCaseQuantityPlusButton;

    /** First Product's elements - for each price */

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'listOfProducts')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'eachPriceContainer')]//*[contains(@resource-id, 'priceLabel')]")
    private MobileElement firstProductEachPrice;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'listOfProducts')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'eachPriceContainer')]//*[contains(@resource-id, 'cartItemCount')]")
    private MobileElement firstProductEachQuantityField;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'listOfProducts')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'eachPriceContainer')]//*[contains(@resource-id, 'addToCartMinus')]")
    private MobileElement firstProductEachQuantityMinusButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'listOfProducts')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'eachPriceContainer')]//*[contains(@resource-id, 'addToCartPlus')]")
    private MobileElement firstProductEachQuantityPlusButton;

    /** All products elements */

    @AndroidFindBy(id = "productImage")
    private List<MobileElement> androidProductsImages;

    @AndroidFindBy(id = "productDescription")
    private List<MobileElement> androidProductsTitles;

    @AndroidFindBy(id = "productInfo")
    private List<MobileElement> androidProductsDescriptions;

    @AndroidFindBy(id = "popupMenu")
    private List<MobileElement> androidProductsThreeDotButtons;

    @AndroidFindBy(id = "priceLabel")
    private List<MobileElement> androidProductsPrices;

    @AndroidFindBy(id = "addToCartMinus")
    private List<MobileElement> androidProductsDecreaseQuantityButtons;

    @AndroidFindBy(id = "cartItemCount")
    private List<MobileElement> androidProductsInputQuantityFields;

    @AndroidFindBy(id = "addToCartPlus")
    private List<MobileElement> androidProductsIncreaseQuantityButtons;


    /** Default list elements */

    //only ios
    @iOSXCUITFindBy(id = "goldStar")
    private MobileElement defaultIcon;

    @AndroidFindBy(id = "detailDefaultProductList")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='DEFAULT LIST'])[1]")
    private MobileElement defaultListLabel;


    /** Empty list elements */

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.LinearLayout[2]/android.widget.ImageView")
    @iOSXCUITFindBy(id = "empty view - image")
    private MobileElement emptyListIcon;

    //android List Is Empty
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'productListEmptyState')]/android.widget.TextView[1]")
    @iOSXCUITFindBy(id = "empty view - title")
    private MobileElement listIsEmptyText;

    //android Add items to your list
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'productListEmptyState')]/android.widget.TextView[2]")
    @iOSXCUITFindBy(id = "empty view - subtitle")
    private MobileElement addItemsToYourListText;


    /** Par group elements */

    @AndroidFindBy(id = "parGroupSelector")
    private MobileElement parGroupSelector;

    //Default android Select Par Group
    @AndroidFindBy(id = "parGroupSelection")
    private MobileElement parGroupNameLabel;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private MobileElement parValueOnFirstProductInList;

    public ListPage checkElementsPresence() {
        utils.log().info("Check elements presence on List page");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(backButton.isDisplayed());
        softAssert.assertTrue(listNameLabel.isDisplayed());
        softAssert.assertTrue(cartButton.isDisplayed());
        softAssert.assertTrue(listSearchInputField.isDisplayed());
//      softAssert.assertTrue(listSearchInputFieldLabel.isDisplayed());
        softAssert.assertTrue(listSettingsButton.isDisplayed());
        softAssert.assertTrue(listFilterButton.isDisplayed());
        softAssert.assertTrue(itemCountLabel.isDisplayed());
        softAssert.assertAll();
        return this;
    }

    public ListPage checkElementsPresenceForEmptyList() {
        utils.log().info("Check elements presence for empty list on List page");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(backButton.isDisplayed());
        softAssert.assertTrue(listNameLabel.isDisplayed());
        softAssert.assertTrue(cartButton.isDisplayed());
        softAssert.assertTrue(listSearchInputField.isDisplayed());
//      softAssert.assertTrue(listSearchInputFieldLabel.isDisplayed());
        softAssert.assertTrue(listSettingsButton.isDisplayed());
        softAssert.assertTrue(listFilterButton.isDisplayed());
        softAssert.assertTrue(itemCountLabel.isDisplayed());
//      softAssert.assertTrue(emptyListIcon.isDisplayed());
        softAssert.assertTrue(listIsEmptyText.isDisplayed());
        softAssert.assertTrue(addItemsToYourListText.isDisplayed());

        if(getPlatform().equalsIgnoreCase("Android")) {
            softAssert.assertEquals(listIsEmptyText.getText(), "List is Empty");
            softAssert.assertEquals(addItemsToYourListText.getText(), "Add items to your list");
        }
        softAssert.assertAll();
        return this;
    }

    public ListPage checkElementsPresenceForFirstItemCase(String expectedTitle, String expectedDescription, String expectedCasePrice) {
        utils.log().info("Check elements presence for first case item on List page");
        SoftAssert softAssert = new SoftAssert();
        waitForVisibility(firstProductTitleText, "firstProductTitleText");
        softAssert.assertTrue(firstProduct.isDisplayed(), "firstProduct");
        softAssert.assertTrue(firstProductTitleText.isDisplayed(), "firstProductTitleText");
        if(getPlatform().equalsIgnoreCase("Android")) {
            softAssert.assertTrue(firstProductDescriptionText.isDisplayed(), "firstProductDescriptionText");
        }
        softAssert.assertTrue(firstProductDotMenuButton.isDisplayed(), "firstProductDotMenuButton");
        //softAssert.assertTrue(firstProductCasePrice.isDisplayed(), "firstProductCasePrice"); ios not visible
        softAssert.assertTrue(firstProductCaseQuantityField.isDisplayed(), "firstProductCaseQuantityField");
        softAssert.assertTrue(firstProductCaseQuantityMinusButton.isDisplayed(), "firstProductCaseQuantityMinusButton");
        softAssert.assertTrue(firstProductCaseQuantityPlusButton.isDisplayed(), "firstProductCaseQuantityPlusButton");
        softAssert.assertEquals(firstProductTitleText.getText(), expectedTitle, "firstProductTitleText equality check");
        softAssert.assertEquals(firstProductDescriptionText.getText(), expectedDescription, "firstProductDescriptionText equality check");
        softAssert.assertEquals(firstProductCasePrice.getText().replace("\n", ""), expectedCasePrice, "firstProductCasePrice equality check");
        softAssert.assertAll();
        return this;
    }

    public void checkDefaultListElementsPresence() {
        utils.log().info("Check elements presence for default list on List page");
        //Assert.assertTrue(defaultIcon.isDisplayed());
        Assert.assertTrue(defaultListLabel.isDisplayed(), "defaultListLabel");
    }

    public void checkListName(String expectedListName) throws InterruptedException {
        utils.log().info("Check list name to be equal to " + expectedListName + " on List page");
        Thread.sleep(200);
        Assert.assertEquals(listNameLabel.getText(), expectedListName);
    }

    public ListsPage pressBackButton() {
        click(backButton, "Press back button on List Page");
        return new ListsPage();
    }

    public OrderCartPage pressCartButton() {
        click(cartButton, "Press cart button on List page");
        return new OrderCartPage();
    }

    public ListPage inputSearch(String searchListText) {
        sendKeys(listSearchInputField, searchListText, "Search list for " + searchListText);
        return new ListPage();
    }

    public ListSettingsPage pressListSettingsButton() {
        click(listSettingsButton, "Press Settings button on List page");
        return new ListSettingsPage();
    }

    public ListFilterPage pressListFilterButton() {
        click(listFilterButton, "Press filter button on List page");
        return new ListFilterPage();
    }

    public ProductThreeDotPopUp pressOnFirstProductThreeDotButtons() {
        click(androidProductsThreeDotButtons.get(0), "Press on first product's three dot button on List Page");
        return new ProductThreeDotPopUp();
    }

    public SelectParPage pressParGroupSelector() {
        click(parGroupSelector, "Press par group selector on List page");
        return new SelectParPage();
    }
}
