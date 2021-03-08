package com.qe.pages.search;

import com.qe.BaseTest;
import com.qe.pages.common.DiscountBulkOverlay;
import com.qe.pages.common.DiscountOverlay;
import com.qe.pages.common.NavDrawer;
import com.qe.pages.lists.AddToListPage;
import com.qe.pages.orders.OrderCartPage;
import com.qe.pages.product.ProductCardPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

public class SearchCatalogPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @iOSXCUITFindBy(id = "app bar left button")
    private MobileElement navBarDrawerButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/searchField")
    @iOSXCUITFindBy(id = "app nav search bar text field")
    private MobileElement searchTextField;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/editText")
    @iOSXCUITFindBy(id = "app nav search bar text field")
    private MobileElement searchTextFieldText;

    @iOSXCUITFindBy(id = "app bar cancel search")
    private MobileElement cancelSearchButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/cart_icon")
    @iOSXCUITFindBy(id = "cart button")
    private MobileElement cartButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/cart_badge")
    @iOSXCUITFindBy(id = "badge - text")
    private MobileElement cartBadgeCount;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/numResults")
    @iOSXCUITFindBy(id = "result count label")
    private MobileElement resultCountLabel;

    @AndroidFindBy(id = "Filter")
    @iOSXCUITFindBy(id = "search filter view - filter button")
    private MobileElement filterButton;

    /** Banner - Add to list */

    @iOSXCUITFindBy(id = "app navigation controller - banner")
    private MobileElement bannerItemAddedToList;

    @iOSXCUITFindBy(id = "Item added to List(s)")
    private MobileElement bannerItemAddedToListText;

    /** Products elements */

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/resultView")
    @iOSXCUITFindBy(id = "catalog search results table")
    private MobileElement catalogSearchResultsTable;

    @AndroidFindBy(xpath = "//*[contains(@text, '0566709')]")
    //@AndroidFindBy(xpath = "//*[@resource-id=\"com.syscocorp.mss.enterprise.dev:id/resultView\"]/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]")
    private MobileElement firstProduct;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/productDescription")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]")
    private MobileElement firstProductTitleText;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/popupMenu")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeButton[@name=\"dot menu button\"]")
    private MobileElement firstProductDotMenuButton;

    @iOSXCUITFindBy(id = "Add to list")
    private MobileElement addToListButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/productInfo")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[2]")
    private MobileElement firstProductDescriptionText;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/priceLabel")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[3]")
    private MobileElement firstProductCasePrice;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/cartItemCount")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`name == \"case quantity text field\"`][1]")
    private MobileElement firstProductCaseQuantityField;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/addToCartMinus")
    @iOSXCUITFindBy(id = "decrease quantity button")
    private MobileElement firstProductCaseQuantityMinusButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/addToCartPlus")
    @iOSXCUITFindBy(id = "increase quantity button")
    private MobileElement firstProductCaseQuantityPlusButton;


    /** Android specific elements */

    @AndroidFindBy(accessibility = "Navigate up")
    private MobileElement androidNavBackButton;


    /** Discount Pricing Elements */

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeButton[@name=\"bulk discounts button\"]")
    private MobileElement firstProductBulkDiscountsAvailableButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeButton[@name=\"discounts info bubble\"]")
    private MobileElement firstProductDiscountInfoBubble;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[@name=\"product strikethrough label\"]")
    private MobileElement firstProductStrikethroughCasePrice;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[@name=\"product strikethrough label\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement firstProductBulkDiscountCasePrice;


    /** Guest user element */

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup")
    @iOSXCUITFindBy(id = "catalog search result 0-0")
    private MobileElement firstProductInResultsTableGuestPageOnly;

    public SearchCatalogPage checkElementsPresenceForBannerItemAddedToList() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(bannerItemAddedToList.isDisplayed(), "bannerItemAddedToList");
        softAssert.assertTrue(bannerItemAddedToListText.isDisplayed(), "bannerItemAddedToListText");
        softAssert.assertAll();
        return this;
    }

    public SearchCatalogPage checkElementsPresence(String expectedSearchQuery) {
        utils.log().info("Check search page elements");
        SoftAssert softAssert = new SoftAssert();
        waitForVisibility(navBarDrawerButton, "navBarDrawerButton");
        softAssert.assertTrue(navBarDrawerButton.isDisplayed(), "navBarDrawerButton");
        softAssert.assertTrue(searchTextField.isDisplayed(), "searchTextField");
        softAssert.assertTrue(searchTextFieldText.isDisplayed(), "searchTextFieldText");
        softAssert.assertTrue(cartButton.isDisplayed(), "cartButton");
        //softAssert.assertTrue(resultCountLabel.isDisplayed());ios flaks out
        softAssert.assertTrue(filterButton.isDisplayed(), "filterButton");
        softAssert.assertTrue(catalogSearchResultsTable.isDisplayed(), "catalogSearchResultsTable");
        softAssert.assertTrue(searchTextFieldText.getText().toLowerCase().contains(expectedSearchQuery), "searchTextFieldText");
        softAssert.assertAll();
        return this;
    }

    public SearchCatalogPage checkElementsPresenceForFirstItemCase(String expectedTitle, String expectedDescription, String expectedCasePrice) {
        utils.log().info("Check search page elements for first item");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(firstProduct.isDisplayed());
        softAssert.assertTrue(firstProductTitleText.isDisplayed());
        softAssert.assertTrue(firstProductDescriptionText.isDisplayed());
        softAssert.assertTrue(firstProductDotMenuButton.isDisplayed());
        softAssert.assertTrue(firstProductCasePrice.isDisplayed());
        softAssert.assertTrue(firstProductCaseQuantityField.isDisplayed());
        softAssert.assertTrue(firstProductCaseQuantityMinusButton.isDisplayed());
        softAssert.assertTrue(firstProductCaseQuantityPlusButton.isDisplayed());
        softAssert.assertEquals(firstProductTitleText.getText(), expectedTitle);
        softAssert.assertEquals(firstProductDescriptionText.getText(), expectedDescription);
        softAssert.assertEquals(firstProductCasePrice.getText(), expectedCasePrice);
        softAssert.assertAll();
        return this;
    }

    public SearchCatalogPage checkElementsPresenceForFirstItemBulkDiscountCase(String expectedTitle,
                                                                               String expectedDescription,
                                                                               String expectedStrikethroughCasePrice,
                                                                               String expectedBulkDiscountCasePrice) {
        utils.log().info("Check search page elements for first item with bulk discounts");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(firstProduct.isDisplayed());
//        softAssert.assertTrue(firstProductTitleText.isDisplayed());
//        softAssert.assertTrue(firstProductDescriptionText.isDisplayed());
        softAssert.assertTrue(firstProductDotMenuButton.isDisplayed(), "firstProductDotMenuButton");
        //softAssert.assertTrue(firstProductStrikethroughCasePrice.isDisplayed(), "firstProductStrikethroughCasePrice");
        softAssert.assertTrue(firstProductBulkDiscountCasePrice.isDisplayed(), "firstProductBulkDiscountCasePrice");
        softAssert.assertTrue(firstProductDiscountInfoBubble.isDisplayed(), "firstProductDiscountInfoBubble");
        softAssert.assertTrue(firstProductCaseQuantityField.isDisplayed(), "firstProductCaseQuantityField");
        softAssert.assertTrue(firstProductCaseQuantityMinusButton.isDisplayed(),"firstProductCaseQuantityMinusButton");
        softAssert.assertTrue(firstProductCaseQuantityPlusButton.isDisplayed(), "firstProductCaseQuantityPlusButton");
        //pricing messes up ios indexes in xpath locator
        //softAssert.assertEquals(firstProductTitleText.getText(), expectedTitle);
        //softAssert.assertEquals(firstProductDescriptionText.getText(), expectedDescription);
        softAssert.assertEquals(firstProductStrikethroughCasePrice.getText(), expectedStrikethroughCasePrice);
        softAssert.assertEquals(firstProductBulkDiscountCasePrice.getText(), expectedBulkDiscountCasePrice);
        softAssert.assertAll();
        return this;
    }

    public SearchCatalogPage inputCaseQuantityForFirstProduct(String quantity) {
        waitForVisibility(firstProductCaseQuantityField, "firstProductCaseQuantityField");
        click(firstProductCaseQuantityField);
        sendKeys(firstProductCaseQuantityField, quantity, "Input quantity " + quantity + " in first item on Search page");
        getDriver().getKeyboard().sendKeys("\n");
        return this;
    }

    public ProductCardPage pressOnFirstProduct() {
        click(firstProduct, "Press on first item on Search page");
        return new ProductCardPage();
    }

    public SearchCatalogPage pressPlusQuantityForFirstProductCase() {
        click(firstProductCaseQuantityPlusButton, "Press + quantity on first item on Search page");
        return this;
    }

    public OrderCartPage pressCartButton() {
        waitForVisibility(cartBadgeCount, "cartBadgeCount", 3);
        click(cartButton, "Press cart button on Search page");
        return new OrderCartPage();
    }

    public SearchCatalogPage pressFirstProductDotButton() {
        waitForVisibility(firstProductDotMenuButton, "firstProductDotMenuButton");
        click(firstProductDotMenuButton, "Press on three dot button in first item on Search page");
        return this;
    }

    public AddToListPage pressAddToListButton() {
        click(addToListButton, "Press add to list button on Search page");
        return new AddToListPage();
    }

    public NavDrawer pressNavBar() {
        click(navBarDrawerButton, "Press on nav drawer button on Search page");
        return new NavDrawer();

    }
    /** Discounts feature methods */

    public DiscountBulkOverlay pressFirstItemBulkDiscountsAvailableButton() {
        click(firstProductBulkDiscountsAvailableButton, "Press on first product's bulk discount button on Search page");
        return new DiscountBulkOverlay();
    }

    public DiscountOverlay pressFirstItemDiscountInfoBubble() {
        click(firstProductDiscountInfoBubble, "Press on first product's discount info buble on Search page");
        return new DiscountOverlay();
    }
}
