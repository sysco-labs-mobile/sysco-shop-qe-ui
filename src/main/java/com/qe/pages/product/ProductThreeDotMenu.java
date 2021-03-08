package com.qe.pages.product;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ProductThreeDotMenu extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add to list']")
    @iOSXCUITFindBy(id = "Add to list")
    private MobileElement addToListButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Remove item']")
    @iOSXCUITFindBy(id = "Remove item")
    private MobileElement removeItemButton;

    @iOSXCUITFindBy(id = "Cancel")
    private MobileElement cancelButton;
}
