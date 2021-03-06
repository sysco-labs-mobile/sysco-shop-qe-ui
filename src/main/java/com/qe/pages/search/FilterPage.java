package com.qe.pages.search;

import com.qe.BaseTest;
import com.qe.pages.lists.filter.FilterSyscoCategoryPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;


public class FilterPage extends BaseTest {
   TestUtils utils = new TestUtils();

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageButton")
    @iOSXCUITFindBy(id = "filters close button")
    private MobileElement closeButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Filters']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Filters\"`]")
    private MobileElement filterTitle;

    @AndroidFindBy(id = "filterReset")
    @iOSXCUITFindBy(id = "filters reset button")
    private MobileElement filterResetButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]")
    @iOSXCUITFindBy(id = "Category")
    private MobileElement categoryButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]")
    @iOSXCUITFindBy(id = "Brand")
    private MobileElement brandButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]")
    @iOSXCUITFindBy(id = "Pack Size")
    private MobileElement packSizeButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]")
    @iOSXCUITFindBy(id = "Storage Type")
    private MobileElement storageTypeButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]")
    @iOSXCUITFindBy(id = "Sysco Specialty")
    private MobileElement syscoSpecialtyButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[6]")
    @iOSXCUITFindBy(id = "Stock Type")
    private MobileElement stockTypeButton;

    @AndroidFindBy(id = "doneButton")
    @iOSXCUITFindBy(id = "filters cta button")
    private MobileElement doneButton;


    public FilterSyscoCategoryPage pressCategoryButton() {
        click(categoryButton);
        return new FilterSyscoCategoryPage();
    }
    
    public FilterPage pressBrandButton() {
        click(brandButton);
        return new FilterPage();
    }

    public FilterPage pressPackSizeButton() {
        click(packSizeButton);
        return new FilterPage();
    }

    public FilterPage pressStorageTypeButton() {
        click(storageTypeButton);
        return new FilterPage();
    }

    public FilterPage pressSyscoSpecialtyButton() {
        click(syscoSpecialtyButton);
        return new FilterPage();
    }

    public FilterPage pressStockTypeButton() {
        click(stockTypeButton);
        return new FilterPage();
    }

    public SearchCatalogPage pressDoneButton() {
        click(doneButton);
        return new SearchCatalogPage();
    }

    public SearchCatalogPage pressResetButton() {
        click(filterResetButton);
        return new SearchCatalogPage();
    }

    public SearchCatalogPage pressCloseButton() {
        click(closeButton);
        return new SearchCatalogPage();
    }

    public FilterPage checkElementsPresenceForCatalogMenuFilters() {
        utils.log().info("Check elements presence for catalog filter header and filter options");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(filterTitle.isDisplayed(), "Filter Title is displayed");
        softAssert.assertTrue(closeButton.isDisplayed(), "closeButton");
        softAssert.assertTrue(filterResetButton.isDisplayed(), "filterResetButton");
        softAssert.assertTrue(categoryButton.isDisplayed(), "categoryButton");
        softAssert.assertTrue(brandButton.isDisplayed(), "brandButton");
        softAssert.assertTrue(packSizeButton.isDisplayed(), "packSizeButton");
        softAssert.assertTrue(storageTypeButton.isDisplayed(), "storageTypeButton");
        softAssert.assertTrue(syscoSpecialtyButton.isDisplayed(), "syscoSpecialtyButton");
        softAssert.assertTrue(filterResetButton.isDisplayed(), "filterResetButton");
        softAssert.assertTrue(stockTypeButton.isDisplayed(), "stockTypeButton");
        softAssert.assertTrue(doneButton.isDisplayed(), "doneButton");
        softAssert.assertAll();
        return this;
    }
}
