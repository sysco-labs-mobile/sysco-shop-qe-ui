package com.qe.pages.search;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class FilterCategoryPage extends BaseTest {
    TestUtils utils = new TestUtils();

    //this page object is valid ONLY when ALL categories are present on the page
    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(id = "")
    private MobileElement closeButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(id = "")
    private MobileElement categoryHeader;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RadioButton")
    @iOSXCUITFindBy(id = "")
    private MobileElement firstCategoryCannedAndDrySelector;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RadioButton")
    @iOSXCUITFindBy(id = "")
    private MobileElement firstCategorySuppAndEquipSelector;


}
