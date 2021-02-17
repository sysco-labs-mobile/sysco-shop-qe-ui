package com.qe.pages;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class NotificationsPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Open navigation drawer")
    @iOSXCUITFindBy(id = "app bar left button")
    private MobileElement navBarDrawerButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/editText")
    private MobileElement searchTextInputField;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/action_cart")
    private MobileElement cartButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/title")
    private MobileElement notificationsHeader;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup")
    private MobileElement firstNotificationInList;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/notificationTitle")
    private List<MobileElement> notificationTitles;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/notificationBody")
    private List<MobileElement>  notificationDescriptions;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/notificationTimestamp")
    private List<MobileElement>  notificationTimestamps;

}
