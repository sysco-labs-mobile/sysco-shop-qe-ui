package com.qe.pages.search;

import com.qe.BaseTest;
import com.qe.pages.common.DiscountBulkOverlay;
import com.qe.pages.common.DiscountOverlay;
import com.qe.pages.common.NavDrawer;
import com.qe.pages.discover.DiscoverPage;
import com.qe.pages.lists.AddToListPage;
import com.qe.pages.lists.ListsPage;
import com.qe.pages.orders.OrderCartPage;
import com.qe.pages.orders.OrdersPage;
import com.qe.pages.product.ProductCardPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SearchCatalogPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Navigate up")
    private MobileElement androidNavBackButton;

    @iOSXCUITFindBy(id = "app bar left button")
    private MobileElement iosNavBarDrawerButton;

    @AndroidFindBy(id = "searchField")
    @iOSXCUITFindBy(id = "app nav search bar text field")
    private MobileElement searchTextField;

    @AndroidFindBy(id = "editText")
    @iOSXCUITFindBy(id = "app nav search bar text field")
    private MobileElement searchTextFieldText;

    @iOSXCUITFindBy(id = "app bar cancel search")
    private MobileElement cancelSearchButton;

    @AndroidFindBy(id = "cart_icon")
    @iOSXCUITFindBy(id = "cart button")
    private MobileElement cartButton;

    @AndroidFindBy(id = "cart_badge")
    @iOSXCUITFindBy(id = "badge - text")
    private MobileElement cartBadgeCount;

    @AndroidFindBy(id = "loadingView")
    private MobileElement loadingView;

    @AndroidFindBy(id = "couldNotLoad")
    private MobileElement errorLoadingHeader;

    @AndroidFindBy(accessibility = "Tap to Retry")
    private MobileElement retryButton;

    @AndroidFindBy(id = "numResults")
    @iOSXCUITFindBy(id = "result count label")
    private MobileElement resultCountLabel;

    @AndroidFindBy(accessibility = "Filter")
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"search filter view - filter button\"])[1]")
    @iOSXCUITFindBy(id = "search filter view - filter button")
    private MobileElement filterButton;

    /** Banner - Add to list */

    @AndroidFindBy(id = "snackbar_text")
    @iOSXCUITFindBy(id = "app navigation controller - banner")
    private MobileElement bannerItemAddedToList;

    @iOSXCUITFindBy(id = "Item added to List(s)")
    private MobileElement bannerItemAddedToListText;

    /** First Product's elements */

    @AndroidFindBy(id = "resultView")
    @iOSXCUITFindBy(id = "catalog search results table")
    private MobileElement catalogSearchResultsTable;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]")
    private MobileElement firstProduct;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'productDescription')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]")
    private MobileElement firstProductTitleText;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'popupMenu')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeButton[@name=\"dot menu button\"]")
    private MobileElement firstProductDotMenuButton;

    @AndroidFindBy(id = "itemFlag")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"special flag label\"])[1]")
    private MobileElement firstSpecialFlagLabel;

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

    /** Discount Pricing Elements */

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'bulkDiscountsAvailableLayout')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeButton[@name=\"bulk discounts button\"]")
    private MobileElement firstProductBulkDiscountsAvailableButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'casePriceContainer')]//*[contains(@resource-id, 'discountsAppliedTooltip')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeButton[@name=\"discounts info bubble\"]")
    private MobileElement firstProductCaseDiscountInfoBubble;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'casePriceContainer')]//*[contains(@resource-id, 'strikeThroughPriceLabel')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[@name=\"product strikethrough label\"]")
    private MobileElement firstProductCaseStrikethroughCasePrice;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'casePriceContainer')]//*[contains(@resource-id, 'priceLabel')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[@name=\"product strikethrough label\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement firstProductCaseBulkDiscountCasePrice;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'eachPriceContainer')]//*[contains(@resource-id, 'discountsAppliedTooltip')]")
    private MobileElement firstProductEachDiscountInfoBubble;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'eachPriceContainer')]//*[contains(@resource-id, 'strikeThroughPriceLabel')]")
    private MobileElement firstProductEachStrikethroughCasePrice;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'resultView')]/android.view.ViewGroup[1]//*[contains(@resource-id, 'eachPriceContainer')]//*[contains(@resource-id, 'priceLabel')]")
    private MobileElement firstProductEachBulkDiscountCasePrice;


    public SearchCatalogPage pressCatalogFilter() {
        click(filterButton);
        return new SearchCatalogPage();
    }

    public SearchCatalogPage checkElementsPresenceForSpecialtyLabel() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(firstSpecialFlagLabel.isDisplayed(), "Special Flag Label");
        softAssert.assertAll();
        return this;
    }

    /** Guest user element */

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup")
    @iOSXCUITFindBy(id = "catalog search result 0-0")
    private MobileElement firstProductInResultsTableGuestPageOnly;

    public SearchCatalogPage checkElementsPresenceForBannerItemAddedToList() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(bannerItemAddedToList.isDisplayed(), "bannerItemAddedToList");
        if(getPlatform().equalsIgnoreCase("iOS")) {
            softAssert.assertTrue(bannerItemAddedToListText.isDisplayed(), "bannerItemAddedToListText");
        }
        if(getPlatform().equalsIgnoreCase("Android")) {
            softAssert.assertEquals(bannerItemAddedToList.getText(), "Item added to list(s)");
        }
        softAssert.assertAll();
        return this;
    }

    public SearchCatalogPage checkElementsPresence(String expectedSearchQuery) {
        utils.log().info("Check search page elements");
        SoftAssert softAssert = new SoftAssert();
        if(getPlatform().equalsIgnoreCase("iOS")) {
            waitForVisibility(iosNavBarDrawerButton, "iosNavBarDrawerButton");
            softAssert.assertTrue(iosNavBarDrawerButton.isDisplayed(), "iosNavBarDrawerButton");
        }
        if(getPlatform().equalsIgnoreCase("Android")) {
            waitForVisibility(androidNavBackButton, "androidNavBackButton");
            softAssert.assertTrue(androidNavBackButton.isDisplayed(), "androidNavBackButton");
        }
        softAssert.assertTrue(searchTextField.isDisplayed(), "searchTextField");
        softAssert.assertTrue(searchTextFieldText.isDisplayed(), "searchTextFieldText");
        softAssert.assertTrue(cartButton.isDisplayed(), "cartButton");
//        softAssert.assertTrue(resultCountLabel.isDisplayed());//ios flaks out
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
//        softAssert.assertTrue(firstProductStrikethroughCasePrice.isDisplayed(), "firstProductStrikethroughCasePrice");
        softAssert.assertTrue(firstProductCaseBulkDiscountCasePrice.isDisplayed(), "firstProductBulkDiscountCasePrice");
        softAssert.assertTrue(firstProductCaseDiscountInfoBubble.isDisplayed(), "firstProductDiscountInfoBubble");
        softAssert.assertTrue(firstProductCaseQuantityField.isDisplayed(), "firstProductCaseQuantityField");
        softAssert.assertTrue(firstProductCaseQuantityMinusButton.isDisplayed(),"firstProductCaseQuantityMinusButton");
        softAssert.assertTrue(firstProductCaseQuantityPlusButton.isDisplayed(), "firstProductCaseQuantityPlusButton");
//      ios pricing messes up ios indexes in xpath locator
        if(getPlatform().equalsIgnoreCase("Android")) {
            softAssert.assertEquals(firstProductTitleText.getText(), expectedTitle);
            softAssert.assertEquals(firstProductDescriptionText.getText(), expectedDescription);
        }
        softAssert.assertEquals(firstProductCaseStrikethroughCasePrice.getText(), expectedStrikethroughCasePrice);
        softAssert.assertEquals(firstProductCaseBulkDiscountCasePrice.getText(), expectedBulkDiscountCasePrice);
        softAssert.assertAll();
        return this;
    }

    public SearchCatalogPage inputCaseQuantityForFirstProduct(String quantity) {
        waitForVisibility(firstProductCaseQuantityField, "firstProductCaseQuantityField");
        click(firstProductCaseQuantityField);
        sendKeys(firstProductCaseQuantityField, quantity, "Input quantity " + quantity + " in first item on Search page");
        getDriver().getKeyboard().sendKeys("\n");
        if(getPlatform().equalsIgnoreCase("Android")) {
            click(searchTextField);
            ((AndroidDriver) getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
        }
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

    public NavDrawer pressIosNavBarDrawerButton() {
        click(iosNavBarDrawerButton, "Press on nav drawer button on Search page");
        return new NavDrawer();
    }

    public DiscoverPage pressAndroidBackButtonToDiscoverPage() {
        click(androidNavBackButton);
        return new DiscoverPage();
    }

    public ListsPage pressAndroidBackButtonToListsPage() {
        click(androidNavBackButton);
        return new ListsPage();
    }

    public OrdersPage pressAndroidBackButtonToOrdersPage() {
        click(androidNavBackButton);
        return new OrdersPage();
    }

    public TypeAheadPage inputSearchForTypeAhead(String searchQuery) throws InterruptedException {
        sendKeys(searchTextField, searchQuery, "Input search " + searchQuery);
        Thread.sleep(12000);
        return new TypeAheadPage();
    }

    /** Discounts feature methods */

    public DiscountBulkOverlay pressFirstItemBulkDiscountsAvailableButton() {
        click(firstProductBulkDiscountsAvailableButton, "Press on first product's bulk discount button on Search page");
        return new DiscountBulkOverlay();
    }

    public DiscountOverlay pressFirstItemCaseDiscountInfoBubble() {
        click(firstProductCaseDiscountInfoBubble, "Press on first product's discount info bubble on Search page");
        return new DiscountOverlay();
    }

    public String getSearchResultsText() {
        Assert.assertTrue(resultCountLabel.isDisplayed());
        return resultCountLabel.getText();
    }

}
