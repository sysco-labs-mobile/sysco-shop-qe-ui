package com.qe.pages.lists;

import com.qe.BaseTest;
import com.qe.pages.common.ProductThreeDotPopUp;
import com.qe.pages.lists.filter.ListFilterPage;
import com.qe.pages.lists.par.SelectParPage;
import com.qe.pages.orders.OrderCartPage;
import com.qe.pages.search.SearchCatalogPage;
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

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.syscocorp.mss.enterprise.dev:id/toolbar\"]/android.widget.TextView[1]")
    @iOSXCUITFindBy(id = "list details - title label")
    private MobileElement listNameLabel;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/action_cart")
    @iOSXCUITFindBy(id = "cart button")
    private MobileElement cartButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/editText")
    @iOSXCUITFindBy(id = "search filter view - search input text field")
    private MobileElement listSearchInputField;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/editText")//same element as above
    @iOSXCUITFindBy(id = "Search in Listname")
    private MobileElement listSearchInputFieldLabel;

    @AndroidFindBy(accessibility = "Cancel")
    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/iconEnd")
    private MobileElement listSearchCancelButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/resetProductList")
    private MobileElement resetButton;

    @AndroidFindBy(accessibility = "Edit")
    @iOSXCUITFindBy(id = "list details - settings button")
    private MobileElement listSettingsButton;

    @AndroidFindBy(accessibility = "Filter")
    @iOSXCUITFindBy(id = "search filter view - filter button")
    private MobileElement listFilterButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/numResultsForSearch")
    @iOSXCUITFindBy(className = "list details - item count label")
    private MobileElement itemCountLabel;

    //android for ex A-Z
    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/appliedFilters")
    private MobileElement appliedFiltersLabel;


    @AndroidFindBy(xpath = "//*[@resource-id=\"com.syscocorp.mss.enterprise.dev:id/resultView\"/android.widget.TextView[1]")
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

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/productImage")
    private List<MobileElement> listOfProductImages;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/productDescription")
    private List<MobileElement> listOfProductTitles;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/productInfo")
    private List<MobileElement> listOfProductDescriptions;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/popupMenu")
    private List<MobileElement> listOfProductThreeDotButtons;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/priceLabel")
    private List<MobileElement> listOfProductPrices;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/addToCartMinus")
    private List<MobileElement> listOfProductDecreaseQuantityButtons;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/cartItemCount")
    private List<MobileElement> listOfProductInputQuantityFields;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/addToCartPlus")
    private List<MobileElement> listOfProductIncreaseQuantityButtons;


    /** Default list elements */

    //only ios
    @iOSXCUITFindBy(id = "goldStar")
    private MobileElement defaultIcon;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/detailDefaultProductList")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"DEFAULT LIST\"`][1]")
    private MobileElement defaultListLabel;


    /** Empty list elements */

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.LinearLayout[2]/android.widget.ImageView")
    @iOSXCUITFindBy(id = "empty view - image")
    private MobileElement emptyListIcon;

    //android List Is Empty
    @AndroidFindBy(xpath = "//*[@resource-id=\"com.syscocorp.mss.enterprise.dev:id/productListEmptyState\"]/android.widget.TextView[1]")
    @iOSXCUITFindBy(id = "empty view - title")
    private MobileElement listIsEmptyText;

    //android Add items to your list
    @AndroidFindBy(xpath = "//*[@resource-id=\"com.syscocorp.mss.enterprise.dev:id/productListEmptyState\"]/android.widget.TextView[2]")
    @iOSXCUITFindBy(id = "empty view - subtitle")
    private MobileElement addItemsToYourListText;


    /** Par group elements */

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/parGroupSelector")
    private MobileElement parGroupSelector;

    //Default android Select Par Group
    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/parGroupSelection")
    private MobileElement parGroupNameLabel;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private MobileElement parValueOnFirstProductInList;

    public ListPage checkElementsPresence() {
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
        SoftAssert softAssert = new SoftAssert();
        waitForVisibility(firstProductTitleText, "firstProductTitleText");
        softAssert.assertTrue(firstProduct.isDisplayed(), "firstProduct");
        softAssert.assertTrue(firstProductTitleText.isDisplayed(), "firstProductTitleText");
        softAssert.assertTrue(firstProductDescriptionText.isDisplayed(), "firstProductDescriptionText");
        softAssert.assertTrue(firstProductDotMenuButton.isDisplayed(), "firstProductDotMenuButton");
        //softAssert.assertTrue(firstProductCasePrice.isDisplayed(), "firstProductCasePrice"); ios not visible
        softAssert.assertTrue(firstProductCaseQuantityField.isDisplayed(), "firstProductCaseQuantityField");
        softAssert.assertTrue(firstProductCaseQuantityMinusButton.isDisplayed(), "firstProductCaseQuantityMinusButton");
        softAssert.assertTrue(firstProductCaseQuantityPlusButton.isDisplayed(), "firstProductCaseQuantityPlusButton");
        softAssert.assertEquals(firstProductTitleText.getText(), expectedTitle, "firstProductTitleText equality check");
        softAssert.assertEquals(firstProductDescriptionText.getText(), expectedDescription, "firstProductDescriptionText equality check");
        softAssert.assertEquals(firstProductCasePrice.getText(), expectedCasePrice, "firstProductCasePrice equality check");
        softAssert.assertAll();
        return this;
    }

    public void checkDefaultListElementsPresence() {
        //Assert.assertTrue(defaultIcon.isDisplayed());
        Assert.assertTrue(defaultListLabel.isDisplayed());
    }

    public void checkListName(String expectedListName) {
        Assert.assertEquals(listNameLabel.getText(), expectedListName);
    }

    public ListsPage pressBackButton() {
        click(backButton);
        return new ListsPage();
    }

    public OrderCartPage pressCartButton() {
        click(cartButton);
        return new OrderCartPage();
    }

    public ListPage inputSearch(String searchListText) {
        sendKeys(listSearchInputField, searchListText, "Search list for " + searchListText);
        return new ListPage();
    }

    public ListSettingsPage pressListSettingsButton() {
        click(listSettingsButton);
        return new ListSettingsPage();
    }

    public ListFilterPage pressListFilterButton() {
        click(listFilterButton);
        return new ListFilterPage();
    }

    public ProductThreeDotPopUp pressOnFirstProductThreeDotButtons() {
        click(listOfProductThreeDotButtons.get(0));
        return new ProductThreeDotPopUp();
    }

    public SelectParPage pressParGroupSelector() {
        click(parGroupSelector);
        return new SelectParPage();
    }
}
