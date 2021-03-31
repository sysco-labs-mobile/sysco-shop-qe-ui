package com.qe.pages.search;

import com.qe.BaseTest;
import com.qe.pages.lists.filter.FilterSyscoCategoryPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class FilterPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageButton")
    @iOSXCUITFindBy(id = "filters close button")
    private MobileElement closeButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView\n")
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
    @iOSXCUITFindBy(id = "filters cta button")
    private MobileElement doneButton;

    public FilterSyscoCategoryPage pressCategoryButton() {
        click(categoryButton);
        return new FilterSyscoCategoryPage();
    }

    public SearchCatalogPage pressBrandButton() {
        click(brandButton);
        return new SearchCatalogPage();
    }

    public SearchCatalogPage pressPackSizeButton() {
        click(packSizeButton);
        return new SearchCatalogPage();
    }

    public SearchCatalogPage pressStorageTypeButton() {
        click(storageTypeButton);
        return new SearchCatalogPage();
    }

    public SearchCatalogPage pressSyscoSpecialtyButton() {
        click(syscoSpecialtyButton);
        return new SearchCatalogPage();
    }

    public SearchCatalogPage pressDoneButton() {
        click(doneButton);
        return new SearchCatalogPage();
    }
}
