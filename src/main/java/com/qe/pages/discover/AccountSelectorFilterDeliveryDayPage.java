package com.qe.pages.discover;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AccountSelectorFilterDeliveryDayPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(id = "Navigate up")
    @iOSXCUITFindBy(id = "Back")
    private MobileElement backButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")//getText() Delivery Day
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Delivery Day\"`]")
    private MobileElement deliveryDayHeader;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/filterList")
    @iOSXCUITFindBy(id = "checkbox list")
    private MobileElement checkboxList;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]")
    @iOSXCUITFindBy(id = "**/XCUIElementTypeCell[`name == \"checkbox-0-0\"`]/XCUIElementTypeOther[1]")
    private MobileElement firstButtonInCheckboxList;

    @iOSXCUITFindBy(id = "Monday")
    private MobileElement mondayButtonText;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.CheckBox")
    //checkable = true getText = monday
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`name == \"checkbox-0-0\"`]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private MobileElement firstCheckboxInCheckboxList;
    //check enabled = false and then true after tap

}
