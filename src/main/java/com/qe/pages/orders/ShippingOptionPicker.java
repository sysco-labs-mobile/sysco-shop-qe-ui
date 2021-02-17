package com.qe.pages.orders;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ShippingOptionPicker extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypePickerWheel[`value == \"Ground\"`]/XCUIElementTypeOther[1]")
    private MobileElement groundOption1;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypePickerWheel[`value == \"Ground\"`]/XCUIElementTypeOther[2]")
    private MobileElement willCallOption1;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypePickerWheel[`value == \"Will Call\"`]/XCUIElementTypeOther[1]\n")
    private MobileElement groundOption2;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypePickerWheel[`value == \"Will Call\"`]/XCUIElementTypeOther[2]")
    private MobileElement willCallOption2;
}
