package com.qe.pages.lists;

import com.qe.BaseTest;
import com.qe.pages.common.NavDrawer;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

public class ListsPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Open navigation drawer")
    @iOSXCUITFindBy(id = "app bar left button")
    private MobileElement navBarDrawerButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/editText")
    @iOSXCUITFindBy(id = "lists header title")
    private MobileElement listsHeader;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/createProductListFab")
    @iOSXCUITFindBy(id = "floating action button")
    private MobileElement createListButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[1]")
    @iOSXCUITFindBy(id = "Purchase History")
    private MobileElement purchaseHistoryText;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[2]")
    private MobileElement purchaseHistoryProductCountText;

    @AndroidFindBy(id = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    @iOSXCUITFindBy(id = "list0-0")
    private MobileElement purchaseHistoryButton;

    public void checkElementsPresence() {
        Assert.assertTrue(navBarDrawerButton.isDisplayed());
        Assert.assertTrue(listsHeader.isDisplayed());
        Assert.assertTrue(createListButton.isDisplayed());
        Assert.assertTrue(purchaseHistoryText.isDisplayed());
//        Assert.assertTrue(purchaseHistoryButton.isDisplayed());
    }

    public NavDrawer pressNavBarDrawerButton() {
        click(navBarDrawerButton);
        return new NavDrawer();
    }

    public ListSettingsPage pressCreateListButton() {
        click(createListButton);
        return new ListSettingsPage();
    }
}
