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
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Shop by category\"`][1]")
    private MobileElement searchTextFieldText;

    @iOSXCUITFindBy(id = "app bar cancel search")
    private MobileElement cancelSearchButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/cart_icon")
    @iOSXCUITFindBy(id = "cart button")
    private MobileElement cartButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/cart_badge")
    @iOSXCUITFindBy(id = "badge - text")
    private MobileElement cartBadgeCount;//getValue() or getLabel()

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/numResults")
    @iOSXCUITFindBy(id = "result count label")
    private MobileElement resultCountLabel;//getValue()
    //SHOWING 2906 RESULTS FOR "MEATS"
    //SHOWING 82 RESULTS FOR "CARROT"

    @AndroidFindBy(id = "Filter")
    @iOSXCUITFindBy(id = "search filter view - filter button")
    private MobileElement filterButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/resultView")
    @iOSXCUITFindBy(id = "catalog search results table")
    private MobileElement catalogSearchResultsTable;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.syscocorp.mss.enterprise.dev:id/resultView\"/android.widget.TextView[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable[`name == \"catalog search results table\"`]/XCUIElementTypeAny[1]/XCUIElementTypeOther") //unreliable accessibility id
    private MobileElement firstProductInResultsTable;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/productDescription")
    //getText() Beef Ground Bulk 81%-19% Chub
    @iOSXCUITFindBy(id = "Beef Ground Bulk 81%-19% Chub") //unreliable accessibility id
    private MobileElement firstProductInResultsTableTitleText;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/popupMenu")
    @iOSXCUITFindBy(id = "dot menu button")
    private MobileElement firstProductDotMenuButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/productInfo")
    //0566709 | 4/5#AV | FIRE RIVER FARMS CLASSIC
    @iOSXCUITFindBy(id = "0566709 | 4/5#AV | FIRE RIVER FARMS CLASSIC")
    private MobileElement firstProductInResultsTableDescriptionText;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/priceLabel")
    //CS (avg. 20.37LB) @ $2.654/LB
    @iOSXCUITFindBy(id = "CS (avg. 20.37LB) @ $2.657/LB")
    private MobileElement firstProductInResultsTablePrice;

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

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable[`name == \"catalog search results table\"`]/XCUIElementTypeAny[1]/XCUIElementTypeOther/XCUIElementTypeOther")
    private MobileElement firstProductByClassChain;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable[`name == \"catalog search results table\"`]/XCUIElementTypeAny/XCUIElementTypeOther/XCUIElementTypeOther")
    private List<MobileElement> allProductByClassChain;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`name == \"case quantity text field\"`]")
    private List<MobileElement> allQuantityFields;

    //TODO: add Request exception price

    public SearchCatalogPage inputCaseQuantityForFirstProduct(String quantity) {
        click(firstProductCaseQuantityField);
        sendKeys(firstProductCaseQuantityField, quantity, "Input quantity " + quantity + " in first product in search results ");
        getDriver().getKeyboard().sendKeys("\n");
        return this;
    }

    public SearchCatalogPage pressPlusQuantityForFirstProduct() {
        click(firstProductCaseQuantityPlusButton);
        return this;
    }

    public OrderCartPage pressCartButton() {
        click(cartButton);
        return new OrderCartPage();
    }

    public SearchCatalogPage checkElementsPresenceForSupc0566709() {
        if(getPlatform().equalsIgnoreCase("iOS")) {
            Assert.assertTrue(firstProductInResultsTableTitleText.isDisplayed());
        }
        if(getPlatform().equalsIgnoreCase("Android")) {
            Assert.assertTrue(firstProductInResultsTableTitleText.isDisplayed());
            Assert.assertEquals(firstProductInResultsTableTitleText.getText(), "Beef Ground Bulk 81%-19% Chub");
        }
        return this;
    }

    public ProductCardPage pressFirstItemInListGuestPageOnly() {
        click(firstProductInResultsTableGuestPageOnly);
        return new ProductCardPage();
    }
}
