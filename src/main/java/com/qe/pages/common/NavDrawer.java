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
import org.testng.asserts.SoftAssert;

public class NavDrawer extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(id = "Sysco Shop")
    @iOSXCUITFindBy(id = "drawer header logo image")
    private MobileElement drawerLogo;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"SHOP\"`]")
    private MobileElement shopHeader;

    @AndroidFindBy(id = "nav_discover")
    @iOSXCUITFindBy(id = "drawer-0-0")
    private MobileElement discoverButton;

    @iOSXCUITFindBy(id = "discover")
    private MobileElement discoverIcon;

    @iOSXCUITFindBy(id = "Discover")
    private MobileElement discoverButtonText;

    @AndroidFindBy(id = "nav_lists")
    @iOSXCUITFindBy(id = "drawer-0-1")
    private MobileElement listButton;

    @iOSXCUITFindBy(id = "lists")
    private MobileElement listsIcon;

    @iOSXCUITFindBy(id = "Lists")
    private MobileElement listButtonText;

    @AndroidFindBy(id = "nav_orders")
    @iOSXCUITFindBy(id = "drawer-0-2")
    private MobileElement ordersButton;

    @iOSXCUITFindBy(id = "orders")
    private MobileElement ordersIcon;

    @iOSXCUITFindBy(id = "Orders")
    private MobileElement ordersButtonText;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"PROFILE\"`]")
    private MobileElement profileHeader;

    @AndroidFindBy(id = "nav_notifications")
    @iOSXCUITFindBy(id = "drawer-1-0")
    private MobileElement notificationsButton;

    @iOSXCUITFindBy(id = "notifications")
    private MobileElement notificationsIcon;

    @iOSXCUITFindBy(id = "Notifications")
    private MobileElement notificationsButtonText;

    @AndroidFindBy(id = "nav_help")
    @iOSXCUITFindBy(id = "drawer-1-1")
    private MobileElement helpButton;

    @iOSXCUITFindBy(id = "help")
    private MobileElement helpIcon;

    @iOSXCUITFindBy(id = "Help")
    private MobileElement helpButtonText;

    @AndroidFindBy(id = "nav_log_out")
    @iOSXCUITFindBy(id = "drawer-1-2")
    private MobileElement logoutButton;

    @iOSXCUITFindBy(id = "signout")
    private MobileElement logoutIcon;

    @iOSXCUITFindBy(id = "Log out")
    private MobileElement logoutText;

    public DiscoverPage pressDiscoverPageButton() {
        click(discoverButton, "Press discover button in nav drawer");
        return new DiscoverPage();
    }

    public ListsPage pressListsButton() {
        click(listButton, "Press lists button in nav drawer");
        return new ListsPage();
    }

    public OrdersPage pressOrdersButton() {
        click(ordersButton, "Press orders button in nav drawer");
        return new OrdersPage();
    }

    public NotificationsPage pressNotificationsButton() {
        click(notificationsButton, "Press notification button in nav drawer");
        return new NotificationsPage();
    }

    public LogOutPage pressLogOutButtonForiOS() {
        click(logoutButton, "Press logout button in nav drawer");
        return new LogOutPage();
    }

    public LoginPage pressLogOutButtonForAndroid() {
        click(logoutButton, "Press logout button in nav drawer");
        return new LoginPage();
    }

    public NavDrawer checkElementsPresence() {
        utils.log().info("Check elements presence in nav drawer");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(discoverButton.isDisplayed());
        softAssert.assertTrue(listButton.isDisplayed());
        softAssert.assertTrue(ordersButton.isDisplayed());
        softAssert.assertTrue(notificationsButton.isDisplayed());
        softAssert.assertTrue(helpButton.isDisplayed());
        softAssert.assertTrue(logoutButton.isDisplayed());
        softAssert.assertAll();
        return this;
    }
}
