package com.qe.tests;

import com.qe.BaseTest;
import com.qe.pages.common.NavDrawer;
import com.qe.pages.discover.DiscoverPage;
import com.qe.pages.login.LoginPage;
import com.qe.pages.orders.OrderCartOrderPlacedPage;
import com.qe.pages.orders.OrderCartPage;
import com.qe.pages.orders.OrderCartReviewOrderPage;
import com.qe.pages.orders.OrdersPage;
import com.qe.pages.search.SearchCatalogPage;
import com.qe.pages.search.TypeAheadPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DebugTests extends BaseTest {
    LoginPage loginPage;
    DiscoverPage discoverPage;
    NavDrawer navDrawer;
    TypeAheadPage typeAheadPage;
    SearchCatalogPage searchCatalogPage;
    OrderCartPage orderCartPage;
    OrdersPage ordersPage;
    OrderCartReviewOrderPage orderCartReviewOrderPage;
    OrderCartOrderPlacedPage orderCartOrderPlacedPage;
    TestUtils utils = new TestUtils();

    @BeforeMethod
    public void beforeMethod(Method m)  throws InterruptedException  {
        utils.log().info("****** starting test:" + m.getName() + "******" + "\n");
        loginPage = new LoginPage();
        discoverPage = new DiscoverPage();
        navDrawer = new NavDrawer();
        orderCartPage = new OrderCartPage();
        searchCatalogPage = new SearchCatalogPage();
        typeAheadPage = new TypeAheadPage();
        ordersPage = new OrdersPage();
        orderCartReviewOrderPage = new OrderCartReviewOrderPage();
        orderCartOrderPlacedPage = new OrderCartOrderPlacedPage();
        loginPage.enterEmail(BaseTest.users.getJSONObject("customer").getString("email"));
        loginPage = loginPage.pressNextButton();
        loginPage.enterPassword(BaseTest.users.getJSONObject("customer").getString("password"));
        discoverPage = loginPage.pressLoginButton();
    }


    @Test @Ignore
    public void offlineCustomer() throws InterruptedException  {
        loginPage.checkElementsPresence();
        loginPage.enterEmail(BaseTest.users.getJSONObject("customer").getString("email"));
        ((AndroidDriver) getDriver()).toggleWifi();
        ((AndroidDriver) getDriver()).toggleAirplaneMode();

        if(getPlatform().equalsIgnoreCase("Android")) {
            ((AndroidDriver) getDriver()).toggleAirplaneMode();
        }
        loginPage = loginPage.pressNextButton();

        loginPage.checkElementsPresenceWhenNoInternet();
    }
}
