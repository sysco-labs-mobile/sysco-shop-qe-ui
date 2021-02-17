package com.qe.pages.orders;

import com.qe.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class OrderThreeDotButtonMenu extends BaseTest {

    @iOSXCUITFindBy(id = "Cancel")
    private MobileElement threeDotButtonCancelButton;

    @iOSXCUITFindBy(id = "Cancel Order")
    private MobileElement threeDotButtonCancelOrderButton;
}
