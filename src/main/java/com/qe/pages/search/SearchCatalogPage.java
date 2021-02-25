package com.qe.pages.search;

import com.qe.BaseTest;
import com.qe.pages.orders.OrderCartPage;
import com.qe.pages.product.ProductCardPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

import java.util.List;

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

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/resultView")
    @iOSXCUITFindBy(id = "catalog search results table")
    private MobileElement catalogSearchResultsTable;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.syscocorp.mss.enterprise.dev:id/resultView\"/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]")
    private MobileElement firstProduct;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/productDescription")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]")
    private MobileElement firstProductTitleText;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/popupMenu")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeButton[@name=\"dot menu button\"]")
    private MobileElement firstProductDotMenuButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/productInfo")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[2]")
    private MobileElement firstProductDescriptionText;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/priceLabel")
    @iOSXCUITFindBy(id = "CS (avg. 20.37LB) @ $2.657/LB")
    private MobileElement firstProductCasePrice;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/cartItemCount")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`name == \"case quantity text field\"`][1]")
    private MobileElement firstProductCaseQuantityField;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/addToCartMinus")
    private MobileElement firstProductCaseQuantityMinusButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/addToCartPlus")
    private MobileElement firstProductCaseQuantityPlusButton;


    /** Android specific elements */

    @AndroidFindBy(accessibility = "Navigate up")
    private MobileElement androidNavBackButton;


    /** Guest user element */

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup")
    @iOSXCUITFindBy(id = "catalog search result 0-0")
    private MobileElement firstProductInResultsTableGuestPageOnly;

    //TODO: add Request exception price


    public SearchCatalogPage checkElementsPresence(String expectedSearchQuery) {
        Assert.assertTrue(navBarDrawerButton.isDisplayed());
        Assert.assertTrue(searchTextField.isDisplayed());
        Assert.assertTrue(searchTextFieldText.isDisplayed());
        Assert.assertTrue(cartButton.isDisplayed());
        //Assert.assertTrue(resultCountLabel.isDisplayed());ios flaks out
        Assert.assertTrue(filterButton.isDisplayed());
        Assert.assertTrue(catalogSearchResultsTable.isDisplayed());
        Assert.assertEquals(searchTextFieldText.getText(), expectedSearchQuery);
        return this;
    }

    public SearchCatalogPage checkElementsPresenceForFirstItemCase(String expectedTitle, String expectedDescription) {
        Assert.assertTrue(firstProduct.isDisplayed());
        Assert.assertTrue(firstProductTitleText.isDisplayed());
        Assert.assertTrue(firstProductDescriptionText.isDisplayed());
        Assert.assertTrue(firstProductDotMenuButton.isDisplayed());
        //Assert.assertTrue(firstProductCasePrice.isDisplayed());
        Assert.assertTrue(firstProductCaseQuantityField.isDisplayed());
        Assert.assertTrue(firstProductCaseQuantityMinusButton.isDisplayed());
        Assert.assertTrue(firstProductCaseQuantityPlusButton.isDisplayed());
        Assert.assertEquals(firstProductTitleText.getText(), expectedTitle);
        Assert.assertEquals(firstProductDescriptionText.getText(), expectedDescription);
        //Assert.assertEquals(firstProductCasePrice.getText(), expectedCasePrice);
        return this;
    }

    public SearchCatalogPage inputCaseQuantityForFirstProduct(String quantity) {
        click(firstProductCaseQuantityField);
        sendKeys(firstProductCaseQuantityField, quantity, "Input quantity " + quantity + " in first product in search results ");
        getDriver().getKeyboard().sendKeys("\n");
        return this;
    }

    public ProductCardPage pressOnFirstProduct() {
        click(firstProduct);
        return new ProductCardPage();
    }

    public SearchCatalogPage pressPlusQuantityForFirstProductCase() {
        click(firstProductCaseQuantityPlusButton);
        return this;
    }

    public OrderCartPage pressCartButton() {
        click(cartButton);
        return new OrderCartPage();
    }

    public ProductCardPage pressFirstItemInListGuestPageOnly() {
        click(firstProductInResultsTableGuestPageOnly);
        return new ProductCardPage();
    }
}
