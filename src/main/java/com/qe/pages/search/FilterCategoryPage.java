package com.qe.pages.search;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class FilterCategoryPage extends BaseTest {
    TestUtils utils = new TestUtils();


    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Filters\"]")
    private MobileElement closeButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Category\"]")
    private MobileElement categoryHeader;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RadioButton")
    @iOSXCUITFindBy(id = "groupBy-0-0")
    private MobileElement firstCategorySelector;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RadioButton")
    @iOSXCUITFindBy(id = "groupBy-0-1")
    private MobileElement secondCategorySelector;

    public FilterCategoryPage pressFirstCategorySelector() {
        click(firstCategorySelector, "Press on first category displayed");
        return new FilterCategoryPage();
    }

    public FilterCategoryPage pressSecondCategorySelector() {
        click(secondCategorySelector, "Press on second category displayed");
        return new FilterCategoryPage();
    }

    public FilterCategoryPage pressBack() {
        click(closeButton);
        return new FilterCategoryPage();
    }

}
