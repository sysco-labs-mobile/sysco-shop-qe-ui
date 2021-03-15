package com.qe.pages.orders;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class WillCallInfoPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Close")
    @iOSXCUITFindBy(id = "will call done button")
    private MobileElement doneButton;

    @AndroidFindBy(id = "title\n")
    @iOSXCUITFindBy(id = "Will Call Order Information")
    private MobileElement willCallOrderInfoHeader;

    @AndroidFindBy(id = "pickup_location_title")
    @iOSXCUITFindBy(id = "Pickup Location")
    private MobileElement pickUpLocationHeader;

    @AndroidFindBy(id = "pickup_location")
    @iOSXCUITFindBy(id = "Sysco Boston 99 Spring Street Plympton, MA 02367 US 781-422-2300")//ssmcust9@grr.la
    private MobileElement pickUplocationValue;

    @AndroidFindBy(id = "ordering_hours_title")
    @iOSXCUITFindBy(id = "Ordering Hours")
    private MobileElement orderingHoursHeader;

    @AndroidFindBy(id = "ordering_hours")
    @iOSXCUITFindBy(id = "Monday - Friday 8:00am - 2:00pm Saturday 8:00am - 10:00am")//ssmcust9@grr.la
    private MobileElement orderingHoursValue;

    @AndroidFindBy(id = "pickup_hours_title")
    @iOSXCUITFindBy(id = "Pickup Hours")
    private MobileElement pickUpHoursHeader;

    @AndroidFindBy(id = "pickup_hours")
    @iOSXCUITFindBy(id = "Monday - Friday 8:00am - 4:30pm Saturday 8:00am - 12:00pm")//ssmcust9@grr.la
    private MobileElement pickUpHoursValue;

    @AndroidFindBy(id = "disclaimer\n")
    @iOSXCUITFindBy(id = "will call disclaimer")
    private MobileElement willCallDisclaimer;

}
