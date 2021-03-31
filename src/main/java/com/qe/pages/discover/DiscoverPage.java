package com.qe.pages.discover;

import com.qe.BaseTest;
import com.qe.pages.common.NavDrawer;
import com.qe.pages.search.SearchCatalogPage;
import com.qe.pages.search.TypeAheadPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class DiscoverPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Open navigation drawer")
    @iOSXCUITFindBy(id = "app bar left button")
    private MobileElement navBarDrawerButton;

    @AndroidFindBy(id = "editText")
    @iOSXCUITFindBy(id = "app nav search bar text field")
    private MobileElement searchTextField; //getValue contains search input

    @AndroidFindBy(id = "editText")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Shop by category\"`][1]")
    private MobileElement searchTextFieldText;

    @AndroidFindBy(id = "action_cart")
    @iOSXCUITFindBy(id = "cart button")
    private MobileElement cartButton;

    @AndroidFindBy(id = "dashboardIndeterminateProgressBar")
    private MobileElement androidProgressBar;

    @AndroidFindBy(id = "currentCustomerLayout")
    @iOSXCUITFindBy(id = "account selector button")
    private MobileElement accountSelectorButton;

    @AndroidFindBy(id = "currentCustomerName")
    @iOSXCUITFindBy(id = "current account name label")
    private MobileElement currentAccountNameLabel;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Welcome to Sysco Shop\"]/following-sibling::android.widget.LinearLayout[1]/android.widget.TextView[1]")
    @iOSXCUITFindBy(id = "dashboard welcome label")
    private MobileElement dashboardWelcomeLabel;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Welcome to Sysco Shop\"]/following-sibling::android.widget.LinearLayout[1]/android.widget.TextView[2]")
    @iOSXCUITFindBy(id = "dashboard tagline label")
    private MobileElement dashboardTaglineLabel;


    /** Delivery section elements */

    @iOSXCUITFindBy(id = "delivery summary todays delivery label")
    private MobileElement deliverySummaryHeader;


    @iOSXCUITFindBy(id = "account selector logo image")
    private MobileElement deliveryIcon;


    @iOSXCUITFindBy(id = "delivery place label")
    private MobileElement deliveryPlaceLabel;


    @iOSXCUITFindBy(id = "delivery summary todays delivery label")
    private MobileElement deliveryStatusLabel;


    @iOSXCUITFindBy(id = "delivery timeo image")
    private MobileElement deliveryTimeIcon;


    @iOSXCUITFindBy(id = "estimated delivery label")
    private MobileElement estimatedDeliveryLabel;


    @iOSXCUITFindBy(id = "deliveryTimeLabel")
    private MobileElement deliveryTimeLabel;


    @iOSXCUITFindBy(id = "view delivery button")
    private MobileElement viewDeliveryButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'deliveryLoadError')]")
    private MobileElement viewDeliveryErrorLoading;


    /** Suggestions for you elements */

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")
    @iOSXCUITFindBy(id = "Suggestions for you")
    private MobileElement suggestionsForYouHeader;


    @iOSXCUITFindBy(id = "suggestions for you collection")
    private MobileElement suggestionsForYouCollection;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`name == \"suggestion-0-0\"`]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    private MobileElement suggestionsForYouItem1;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`name == \"suggestion-0-1\"`]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    private MobileElement suggestionsForYouItem2;


    /** Categories elements */
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'categoryList')]/preceding-sibling::android.widget.TextView[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Shop by category\"`][2]")
    private MobileElement shopByCategoryHeader;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'categoryList')]/*")
    private List<MobileElement> androidCategoriesByXpath;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'categoryText')]/*")
    private List<MobileElement> androidCategoriesNamesByXpath;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'categoryList')]/android.widget.LinearLayout[1]")
    @iOSXCUITFindBy(id = "meats")
    private MobileElement meatsCategoryButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'categoryList')]/android.widget.LinearLayout[2]")
    @iOSXCUITFindBy(id = "seafood")
    private MobileElement seaCategoryButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'categoryList')]/android.widget.LinearLayout[3]")
    @iOSXCUITFindBy(id = "poultry")
    private MobileElement poultryCategoryButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'categoryList')]/android.widget.LinearLayout[4]")
    @iOSXCUITFindBy(id = "frozen")
    private MobileElement frozenCategoryButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'categoryList')]/android.widget.LinearLayout[5]")
    @iOSXCUITFindBy(id = "canned")
    private MobileElement cannedCategoryButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'categoryList')]/android.widget.LinearLayout[6]")
    @iOSXCUITFindBy(id = "produce")
    private MobileElement produceCategoryButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'categoryList')]/android.widget.LinearLayout[7]")
    @iOSXCUITFindBy(id = "dairy")
    private MobileElement dairyCategoryButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'categoryList')]/android.widget.LinearLayout[8]")
    @iOSXCUITFindBy(id = "dispenser-beverage")
    private MobileElement dispenserCategoryButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'categoryList')]/android.widget.LinearLayout[9]")
    @iOSXCUITFindBy(id = "supplies-and-equipment")
    private MobileElement suppliesCategoryButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'categoryList')]/android.widget.LinearLayout[10]")
    @iOSXCUITFindBy(id = "paper-and-display")
    private MobileElement paperCategoryButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'categoryList')]/android.widget.LinearLayout[11]")
    @iOSXCUITFindBy(id = "chemical-and-janitorial")
    private MobileElement chemicalCategoryButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'categoryList')]/android.widget.LinearLayout[12]")
    @iOSXCUITFindBy(id = "healthcare-and-hospitality")
    private MobileElement healthcareCategoryButton;


    /** Guest User specific elements */

    @AndroidFindBy(id = "zip_code_container")
    @iOSXCUITFindBy(id = "current zip code button")
    private MobileElement zipCodeSwitcherButton;

    @AndroidFindBy(id = "delivery_zip_code")
    @iOSXCUITFindBy(id = "current zip code label")
    private MobileElement currentZipLabel;

    @AndroidFindBy(id = "become_a_customer")
    @iOSXCUITFindBy(id = "become a customer button")
    private MobileElement becomeCustomerButton;


    public DiscoverPage checkElementsPresence() {
        utils.log().info("Check elements presence");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(navBarDrawerButton.isDisplayed(), "navBarDrawerButton");
        softAssert.assertTrue(searchTextField.isDisplayed(), "searchTextField");
        softAssert.assertTrue(searchTextFieldText.isDisplayed(), "searchTextFieldText");
        softAssert.assertTrue(cartButton.isDisplayed(), "cartButton");
        softAssert.assertTrue(dashboardWelcomeLabel.isDisplayed(), "dashboardWelcomeLabel");
        softAssert.assertTrue(dashboardTaglineLabel.isDisplayed(), "dashboardTaglineLabel");
        if(getPlatform().equalsIgnoreCase("Android")) {
            softAssert.assertEquals(dashboardWelcomeLabel.getText(), "Welcome to Sysco Shop");
            softAssert.assertEquals(dashboardTaglineLabel.getText(), "Keeping you on trend and stocked with fresh products and fresh ideas.");
        }
        softAssert.assertAll();
        return this;
    }


    public DiscoverPage checkElementsPresenceForCategories() {
        utils.log().info("Check elements presence");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(shopByCategoryHeader.isDisplayed(), "shopByCategoryHeader");
        softAssert.assertTrue(meatsCategoryButton.isDisplayed(), "meatsCategoryButton");
        softAssert.assertTrue(seaCategoryButton.isDisplayed(), "seaCategoryButton");
        scrollDownByCoordinates();
        softAssert.assertTrue(poultryCategoryButton.isDisplayed(), "poultryCategoryButton");
        softAssert.assertTrue(frozenCategoryButton.isDisplayed(), "frozenCategoryButton");
        softAssert.assertTrue(cannedCategoryButton.isDisplayed(), "cannedCategoryButton");
        softAssert.assertTrue(produceCategoryButton.isDisplayed(), "produceCategoryButton");
        softAssert.assertTrue(dairyCategoryButton.isDisplayed(), "dairyCategoryButton");
        softAssert.assertTrue(dispenserCategoryButton.isDisplayed(), "dispenserCategoryButton");
        softAssert.assertTrue(suppliesCategoryButton.isDisplayed(), "suppliesCategoryButton");
        softAssert.assertTrue(paperCategoryButton.isDisplayed(), "paperCategoryButton.");
        softAssert.assertTrue(chemicalCategoryButton.isDisplayed(), "chemicalCategoryButton");
        softAssert.assertTrue(healthcareCategoryButton.isDisplayed(), "healthcareCategoryButton");
        softAssert.assertAll();
        return this;
    }

    public DiscoverPage checkElementsPresenceForDeliveryWidget() {
        utils.log().info("Check elements presence");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(deliverySummaryHeader.isDisplayed(), "deliverySummaryHeader");
        softAssert.assertTrue(deliveryIcon.isDisplayed(), "deliveryIcon");
        softAssert.assertTrue(deliveryPlaceLabel.isDisplayed(), "deliveryPlaceLabel");
        softAssert.assertTrue(deliveryStatusLabel.isDisplayed(), "deliveryStatusLabel");
        softAssert.assertTrue(deliveryTimeIcon.isDisplayed(), "deliveryTimeIcon");
        softAssert.assertTrue(estimatedDeliveryLabel.isDisplayed(), "estimatedDeliveryLabel");
        softAssert.assertTrue(deliveryTimeLabel.isDisplayed(), "deliveryTimeLabel");
        softAssert.assertTrue(viewDeliveryButton.isDisplayed(), "viewDeliveryButton");
        softAssert.assertAll();
        return this;
    }

    public DiscoverPage checkElementsPresenceForSuggestionsForYou() {
        utils.log().info("Check elements presence");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(suggestionsForYouHeader.isDisplayed(), "suggestionsForYouHeader");
        softAssert.assertTrue(suggestionsForYouCollection.isDisplayed(), "suggestionsForYouCollection");
        softAssert.assertTrue(suggestionsForYouItem1.isDisplayed(), "suggestionsForYouItem1");
        softAssert.assertAll();
        return this;
    }

    public DiscoverPage checkElementsPresenceForAccountSelector(String expectedAccount) {
        utils.log().info("Check elements presence for Account selector");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(accountSelectorButton.isDisplayed(), "accountSelectorButton");
        softAssert.assertEquals(currentAccountNameLabel.getText(), expectedAccount, "currentAccountNameLabel.getText() equals " + expectedAccount);
        softAssert.assertAll();
        return this;
    }

    public NavDrawer pressNavBarDrawerButton() {
        click(navBarDrawerButton, "Press nav drawer button");
        return new NavDrawer();
    }

    public SearchCatalogPage inputSearch(String searchQuery) {
        sendKeys(searchTextField, searchQuery, "Input search " + searchQuery);
        getDriver().getKeyboard().sendKeys("\n");
        if(getPlatform().equalsIgnoreCase("Android")) {
            click(searchTextField);
            ((AndroidDriver) getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
        }
        return new SearchCatalogPage();
    }

    public TypeAheadPage inputSearchForTypeAhead(String searchQuery) throws InterruptedException {
        sendKeys(searchTextField, searchQuery, "Input search " + searchQuery);
        Thread.sleep(12000);
        return new TypeAheadPage();
    }

    public AccountSelectorPage pressAccountSelectorButton() {
        click(accountSelectorButton, "press accountSelectorButton");
        return new AccountSelectorPage();
    }

    public SearchCatalogPage pressMeatButton() {
        click(meatsCategoryButton, "press meatsCategoryButton");
        return new SearchCatalogPage();
    }

    public SearchCatalogPage pressSeaButton() {
        click(seaCategoryButton);
        return new SearchCatalogPage();
    }

    public SearchCatalogPage pressPoultryButton() {
        click(poultryCategoryButton);
        return new SearchCatalogPage();
    }

    public SearchCatalogPage pressFrozenButton() {
        click(frozenCategoryButton);
        return new SearchCatalogPage();
    }

    public SearchCatalogPage pressCannedButton() {
        click(cannedCategoryButton);
        return new SearchCatalogPage();
    }

    public SearchCatalogPage pressProduceButton() {
        click(produceCategoryButton);
        return new SearchCatalogPage();
    }

    public SearchCatalogPage pressDairyButton() {
        click(dairyCategoryButton);
        return new SearchCatalogPage();
    }

    public SearchCatalogPage pressDispencerButton() {
        click(dispenserCategoryButton);
        return new SearchCatalogPage();
    }

    public SearchCatalogPage pressSuppliesButton() {
        click(suppliesCategoryButton);
        return new SearchCatalogPage();
    }

    public SearchCatalogPage pressPaperButton() {
        click(paperCategoryButton);
        return new SearchCatalogPage();
    }

    public SearchCatalogPage pressChemicalButton() {
        click(chemicalCategoryButton);
        return new SearchCatalogPage();
    }

    public SearchCatalogPage pressHealthcareButton() {
        click(healthcareCategoryButton);
        return new SearchCatalogPage();
    }

    /** Guest User specific action */

    public DiscoverPage checkGuestElementsPresence(String expectedAssignedZip) {
        utils.log().info("Check Guest Elements Presence");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(navBarDrawerButton.isDisplayed());
        softAssert.assertTrue(searchTextField.isDisplayed());
        softAssert.assertTrue(searchTextFieldText.isDisplayed());
        softAssert.assertTrue(dashboardWelcomeLabel.isDisplayed());
        softAssert.assertTrue(dashboardTaglineLabel.isDisplayed());
        softAssert.assertTrue(shopByCategoryHeader.isDisplayed());
        if(getPlatform().equalsIgnoreCase("iOS")) {
            softAssert.assertEquals(currentZipLabel.getText(), expectedAssignedZip);
        }
        if(getPlatform().equalsIgnoreCase("Android")) {
            softAssert.assertEquals(currentZipLabel.getText(), "Delivering to " + expectedAssignedZip);
            softAssert.assertEquals(dashboardWelcomeLabel.getText(), "Welcome to Sysco Shop");
            softAssert.assertEquals(dashboardTaglineLabel.getText(), "Keeping you on trend and stocked with fresh products and fresh ideas.");
        }
        softAssert.assertAll();
        return this;
    }

    public ZipSwitcherModal pressZipSwitcherButton() {
        click(zipCodeSwitcherButton, "Press zipCodeSwitcherButton");
        return new ZipSwitcherModal();
    }

}
