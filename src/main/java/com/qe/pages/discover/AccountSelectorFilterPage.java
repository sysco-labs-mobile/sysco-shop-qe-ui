package com.qe.pages.discover;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AccountSelectorFilterPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ImageButton")
    @iOSXCUITFindBy(id = "account filter menu close button")
    private MobileElement closeButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(id = "Filters")
    private MobileElement filtersHeader;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/filterReset")
    @iOSXCUITFindBy(id = "Reset")
    private MobileElement resetButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/deliveryDayFilter")
    @iOSXCUITFindBy(id = "filter-0-0")
    private MobileElement deliveryDaysButton;

    @iOSXCUITFindBy(id = "Delivery Day")
    private MobileElement deliveryDayTextLabel;

    @iOSXCUITFindBy(id = "Monday")
    private MobileElement appliedFilterForMonday;

    @iOSXCUITFindBy(id = "Monday, Tuesday, Wednesday, Thursday, Friday, Saturday")
    private MobileElement appliedFilterForMonToSat;

    @iOSXCUITFindBy(id = "disclosure")
    private MobileElement deliveryDayArrowIcon;

    @iOSXCUITFindBy(id = "account filter show results button")
    private MobileElement filterResultsButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/seeResultsButton")
    @iOSXCUITFindBy(id = "See Results")
    private MobileElement filterResultsButtonText;

}
