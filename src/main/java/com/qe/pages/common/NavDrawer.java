package com.qe.pages.common;

import com.qe.BaseTest;
import com.qe.pages.NotificationsPage;
import com.qe.pages.discover.DiscoverPage;
import com.qe.pages.lists.ListsPage;
import com.qe.pages.login.LogOutPage;
import com.qe.pages.login.LoginPage;
import com.qe.pages.orders.OrdersPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

public class NavDrawer extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(id = "Sysco Shop")
    @iOSXCUITFindBy(id = "drawer header logo image")
    private MobileElement drawerLogo;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"SHOP\"`]")
    private MobileElement shopHeader;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/nav_discover")
    @iOSXCUITFindBy(id = "drawer-0-0")
    private MobileElement discoverButton;

    @iOSXCUITFindBy(id = "discover")
    private MobileElement discoverIcon;

    @iOSXCUITFindBy(id = "Discover")
    private MobileElement discoverButtonText;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/nav_lists")
    @iOSXCUITFindBy(id = "drawer-0-1")
    private MobileElement listButton;

    @iOSXCUITFindBy(id = "lists")
    private MobileElement listsIcon;

    @iOSXCUITFindBy(id = "Lists")
    private MobileElement listButtonText;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/nav_orders")
    @iOSXCUITFindBy(id = "drawer-0-2")
    private MobileElement ordersButton;

    @iOSXCUITFindBy(id = "orders")
    private MobileElement ordersIcon;

    @iOSXCUITFindBy(id = "Orders")
    private MobileElement ordersButtonText;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"PROFILE\"`]")
    private MobileElement profileHeader;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/nav_notifications")
    @iOSXCUITFindBy(id = "drawer-1-0")
    private MobileElement notificationsButton;

    @iOSXCUITFindBy(id = "notifications")
    private MobileElement notificationsIcon;

    @iOSXCUITFindBy(id = "Notifications")
    private MobileElement notificationsButtonText;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/nav_help")
    @iOSXCUITFindBy(id = "drawer-1-1")
    private MobileElement helpButton;

    @iOSXCUITFindBy(id = "help")
    private MobileElement helpIcon;

    @iOSXCUITFindBy(id = "Help")
    private MobileElement helpButtonText;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/nav_log_out")
    @iOSXCUITFindBy(id = "drawer-1-2")
    private MobileElement logoutButton;

    @iOSXCUITFindBy(id = "signout")
    private MobileElement logoutIcon;

    @iOSXCUITFindBy(id = "Log out")
    private MobileElement logoutText;

    public DiscoverPage pressDiscoverPageButton() {
        click(discoverButton);
        return new DiscoverPage();
    }

    public ListsPage pressListsButton() {
        click(listButton);
        return new ListsPage();
    }

    public OrdersPage pressOrdersButton() {
        click(ordersButton);
        return new OrdersPage();
    }

    public NotificationsPage pressNotificationsButton() {
        click(notificationsButton);
        return new NotificationsPage();
    }

    public LogOutPage pressLogOutButtonForiOS() {
        click(logoutButton);
        return new LogOutPage();
    }

    public LoginPage pressLogOutButtonForAndroid() {
        click(logoutButton);
        return new LoginPage();
    }

    public void checkElementsPresence() {
        //Assert.assertTrue(drawerLogo.isDisplayed());
        //Assert.assertTrue(shopHeader.isDisplayed());
        Assert.assertTrue(discoverButton.isDisplayed());
        //Assert.assertTrue(discoverIcon.isDisplayed());
        //Assert.assertTrue(discoverButtonText.isDisplayed());
        Assert.assertTrue(listButton.isDisplayed());
        //Assert.assertTrue(listsIcon.isDisplayed());
        //Assert.assertTrue(listButtonText.isDisplayed());
        Assert.assertTrue(ordersButton.isDisplayed());
        //Assert.assertTrue(ordersIcon.isDisplayed());
        //Assert.assertTrue(ordersButtonText.isDisplayed());
        //Assert.assertTrue(profileHeader.isDisplayed());
        Assert.assertTrue(notificationsButton.isDisplayed());
        //Assert.assertTrue(notificationsIcon.isDisplayed());
        //Assert.assertTrue(notificationsButtonText.isDisplayed());
        Assert.assertTrue(helpButton.isDisplayed());
        //Assert.assertTrue(helpIcon.isDisplayed());
        //Assert.assertTrue(helpButtonText.isDisplayed());
        Assert.assertTrue(logoutButton.isDisplayed());
        //Assert.assertTrue(logoutIcon.isDisplayed());
        //Assert.assertTrue(logoutText.isDisplayed());
    }
}
