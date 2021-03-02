package com.qe.pages.discover;

import com.qe.BaseTest;
import com.qe.pages.common.NavDrawer;
import com.qe.pages.login.LoginPage;
import com.qe.pages.search.SearchCatalogPage;
import com.qe.pages.search.TypeAheadPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class DiscoverPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Open navigation drawer")
    @iOSXCUITFindBy(id = "app bar left button")
    private MobileElement navBarDrawerButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/editText")
    @iOSXCUITFindBy(id = "app nav search bar text field")
    private MobileElement searchTextField; //getValue contains search input

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/editText")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Shop by category\"`][1]")
    private MobileElement searchTextFieldText;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/action_cart")
    @iOSXCUITFindBy(id = "cart button")
    private MobileElement cartButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/currentCustomerLayout")
    @iOSXCUITFindBy(id = "account selector button")
    private MobileElement accountSelectorButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/currentCustomerName")
    @iOSXCUITFindBy(id = "current account name label")
    private MobileElement currentAccountNameLabel;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[1]", priority = 1)
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[1]", priority = 0)
    @iOSXCUITFindBy(id = "dashboard welcome label")
    private MobileElement dashboardWelcomeLabel;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[2]", priority = 1)
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[2]", priority = 0)
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

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Shop by category\"`][2]")
    private MobileElement shopByCategoryHeader;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.syscocorp.mss.enterprise.dev:id/categoryList\"]/*")
    private List<MobileElement> categoriesByXpath;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.syscocorp.mss.enterprise.dev:id/categoryList\"]/android.widget.LinearLayout[1]")
    @iOSXCUITFindBy(id = "meats")
    private MobileElement meatsCategoryButton;

    @AndroidFindBy(id = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]")
    @iOSXCUITFindBy(id = "seafood")
    private MobileElement seaCategoryButton;

    @AndroidFindBy(id = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]")
    @iOSXCUITFindBy(id = "poultry")
    private MobileElement poultryCategoryButton;

    @AndroidFindBy(id = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]")
    @iOSXCUITFindBy(id = "frozen")
    private MobileElement frozenCategoryButton;


    @iOSXCUITFindBy(id = "canned")
    private MobileElement cannedCategoryButton;


    @iOSXCUITFindBy(id = "produce")
    private MobileElement produceCategoryButton;


    @iOSXCUITFindBy(id = "dairy")
    private MobileElement dairyCategoryButton;


    @iOSXCUITFindBy(id = "dispenser-beverage")
    private MobileElement dispenserCategoryButton;


    @iOSXCUITFindBy(id = "supplies-and-equipment")
    private MobileElement suppliesCategoryButton;


    @iOSXCUITFindBy(id = "paper-and-display")
    private MobileElement paperCategoryButton;


    @iOSXCUITFindBy(id = "chemical-and-janitorial")
    private MobileElement chemicalCategoryButton;


    @iOSXCUITFindBy(id = "healthcare-and-hospitality")
    private MobileElement healthcareCategoryButton;


    /** Guest User specific elements */

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/zip_code_container")
    @iOSXCUITFindBy(id = "current zip code button")
    private MobileElement zipCodeSwitcherButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/delivery_zip_code")
    @iOSXCUITFindBy(id = "current zip code label")
    private MobileElement currentZipLabel;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/become_a_customer")
    @iOSXCUITFindBy(id = "become a customer button")
    private MobileElement becomeCustomerButton;


    public DiscoverPage checkElementsPresence() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(navBarDrawerButton.isDisplayed());
        softAssert.assertTrue(searchTextField.isDisplayed());
        softAssert.assertTrue(searchTextFieldText.isDisplayed());
        softAssert.assertTrue(cartButton.isDisplayed());
//        softAssert.assertTrue(dashboardWelcomeLabel.isDisplayed()); android flaks out
//        softAssert.assertTrue(dashboardTaglineLabel.isDisplayed()); android flaks out
//        softAssert.assertTrue(deliverySummaryHeader.isDisplayed());
//        softAssert.assertTrue(deliveryIcon.isDisplayed());
//        softAssert.assertTrue(deliveryPlaceLabel.isDisplayed());
//        softAssert.assertTrue(deliveryStatusLabel.isDisplayed());
//        softAssert.assertTrue(deliveryTimeIcon.isDisplayed());
//        softAssert.assertTrue(estimatedDeliveryLabel.isDisplayed());
//        softAssert.assertTrue(deliveryTimeLabel.isDisplayed());
//        softAssert.assertTrue(viewDeliveryButton.isDisplayed());
//        softAssert.assertTrue(suggestionsForYouHeader.isDisplayed());
//        softAssert.assertTrue(suggestionsForYouCollection.isDisplayed());
//        softAssert.assertTrue(suggestionsForYouItem1.isDisplayed());
//        softAssert.assertTrue(shopByCategoryHeader.isDisplayed());  android flaks out
//        softAssert.assertTrue(meatsCategoryButton.isDisplayed());
//        softAssert.assertTrue(seaCategoryButton.isDisplayed());
        softAssert.assertAll();
        return this;
    }

    public DiscoverPage checkElementsPresenceForAccountSelector(String expectedAccount) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(accountSelectorButton.isDisplayed());
        softAssert.assertEquals(currentAccountNameLabel.getText(), expectedAccount);
        softAssert.assertAll();
        return this;
    }

    public NavDrawer pressNavBarDrawerButton() {
        click(navBarDrawerButton);
        return new NavDrawer();
    }

    public TypeAheadPage inputTypeAhead(String typeAheadQuery) {
        sendKeys(searchTextField, typeAheadQuery, "Input search " + typeAheadQuery);
        return new TypeAheadPage();
    }

    public SearchCatalogPage inputSearch(String searchQuery) throws InterruptedException {
        sendKeys(searchTextField, searchQuery, "Input search " + searchQuery);
        getDriver().getKeyboard().sendKeys("\n");
        return new SearchCatalogPage();
    }

    public TypeAheadPage inputSearchForTypeAhead(String searchQuery) throws InterruptedException {
        sendKeys(searchTextField, searchQuery, "Input search " + searchQuery);
        Thread.sleep(10000);
        return new TypeAheadPage();
    }

    public AccountSelectorPage pressAccountSelectorButton() {
        click(accountSelectorButton);
        return new AccountSelectorPage();
    }

    public SearchCatalogPage pressMeatButton() {
        click(meatsCategoryButton);
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
        SoftAssert softAssert = new SoftAssert();
        if(getPlatform().equalsIgnoreCase("iOS")) {
            softAssert.assertEquals(currentZipLabel.getText(), expectedAssignedZip);
        }
        if(getPlatform().equalsIgnoreCase("Android")) {
            softAssert.assertEquals(currentZipLabel.getText(), "Delivering to " + expectedAssignedZip);
        }
        softAssert.assertTrue(navBarDrawerButton.isDisplayed());
        softAssert.assertTrue(searchTextField.isDisplayed());
        softAssert.assertTrue(searchTextFieldText.isDisplayed());
//        softAssert.assertTrue(dashboardWelcomeLabel.isDisplayed()); android flaks out
//        softAssert.assertTrue(dashboardTaglineLabel.isDisplayed()); android flaks out
        softAssert.assertTrue(shopByCategoryHeader.isDisplayed());
        softAssert.assertAll();
        return this;
    }

    public ZipSwitcherModal pressZipSwitcherButton() {
        click(zipCodeSwitcherButton);
        return new ZipSwitcherModal();
    }

}
