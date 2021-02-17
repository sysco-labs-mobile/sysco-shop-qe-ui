package com.qe.tests;

import com.qe.BaseTest;
import com.qe.pages.common.NavDrawer;
import com.qe.pages.discover.DiscoverPage;
import com.qe.pages.login.LoginPage;
import com.qe.pages.orders.OrderCartOrderPlacedPage;
import com.qe.pages.orders.OrderCartPage;
import com.qe.pages.orders.OrderCartReviewOrderPage;
import com.qe.pages.search.SearchCatalogPage;
import com.qe.pages.search.TypeAheadPage;
import com.qe.utils.TestUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class OrderCartTests extends BaseTest {
    LoginPage loginPage;
    DiscoverPage discoverPage;
    NavDrawer navDrawer;
    TypeAheadPage typeAheadPage;
    SearchCatalogPage searchCatalogPage;
    OrderCartPage orderCartPage;
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
        orderCartReviewOrderPage = new OrderCartReviewOrderPage();
        orderCartOrderPlacedPage = new OrderCartOrderPlacedPage();
        loginPage.enterEmail(BaseTest.users.getJSONObject("customer").getString("email"));
        loginPage = loginPage.pressNextButton();
        loginPage.enterPassword(BaseTest.users.getJSONObject("customer").getString("password"));
        discoverPage = loginPage.pressLoginButton();
    }

    @Test
    public void order() throws InterruptedException {
        if(getPlatform().equalsIgnoreCase("iOS")) {
            //precondition
            searchCatalogPage = discoverPage.inputSearch("beef ground bulk");
            searchCatalogPage.checkElementsPresenceForSupc0566709();
            searchCatalogPage.inputCaseQuantityForFirstProduct("1");

            //test
            orderCartPage = searchCatalogPage.pressCartButton();
            orderCartReviewOrderPage = orderCartPage.pressProceedToCheckoutButton();
            orderCartOrderPlacedPage = orderCartReviewOrderPage.pressSubmitOrderButton();
            orderCartOrderPlacedPage.checkElementPresence();
        }
        if(getPlatform().equalsIgnoreCase("Android")) {
            //precondition
            typeAheadPage = discoverPage.inputSearchForTypeAhead("beef ground bulk");
            searchCatalogPage = typeAheadPage.pressSearchResultFirst();
            searchCatalogPage.checkElementsPresenceForSupc0566709();
            searchCatalogPage.pressPlusQuantityForFirstProduct();

            //test
            orderCartPage = searchCatalogPage.pressCartButton();
            orderCartReviewOrderPage = orderCartPage.pressProceedToCheckoutButton();
            orderCartOrderPlacedPage = orderCartReviewOrderPage.pressSubmitOrderButton();
            orderCartOrderPlacedPage.checkElementPresence();
        }
    }
}
