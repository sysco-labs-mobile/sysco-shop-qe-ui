package com.qe.tests.smoke;

import com.qe.BaseTest;
import com.qe.pages.common.NavDrawer;
import com.qe.pages.discover.DiscoverPage;
import com.qe.pages.login.LoginPage;
import com.qe.pages.orders.ForgottenItemsPage;
import com.qe.pages.orders.OrderCartOrderPlacedPage;
import com.qe.pages.orders.OrderCartPage;
import com.qe.pages.orders.OrderCartReviewOrderPage;
import com.qe.pages.search.SearchCatalogPage;
import com.qe.pages.search.TypeAheadPage;
import com.qe.utils.TestUtils;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class OrderCartTests extends BaseTest {
    LoginPage loginPage;
    DiscoverPage discoverPage;
    NavDrawer navDrawer;
    TypeAheadPage typeAheadPage;
    SearchCatalogPage searchCatalogPage;
    OrderCartPage orderCartPage;
    ForgottenItemsPage forgottenItemsPage;
    OrderCartReviewOrderPage orderCartReviewOrderPage;
    OrderCartOrderPlacedPage orderCartOrderPlacedPage;
    TestUtils utils = new TestUtils();

    @BeforeMethod
    public void beforeMethod(Method m) {
        utils.log().info("\n       Starting test:" + m.getName());

        loginPage = new LoginPage();
        discoverPage = new DiscoverPage();
        navDrawer = new NavDrawer();
        searchCatalogPage = new SearchCatalogPage();
        typeAheadPage = new TypeAheadPage();
        orderCartPage = new OrderCartPage();
        forgottenItemsPage = new ForgottenItemsPage();
        orderCartReviewOrderPage = new OrderCartReviewOrderPage();
        orderCartOrderPlacedPage = new OrderCartOrderPlacedPage();
    }

    @Test(retryAnalyzer = com.qe.utils.RetryAnalyzer.class)
    public void order() throws InterruptedException {
        loginPage.enterEmail(BaseTest.users.getJSONObject("customer").getString("email"));
        loginPage = loginPage.pressNextButton();
        loginPage.enterPassword(BaseTest.users.getJSONObject("customer").getString("password"));
        discoverPage = loginPage.pressLoginButton();
        searchCatalogPage = discoverPage.inputSearch("0566709");
        searchCatalogPage.inputCaseQuantityForFirstProduct("1");

        //test
        orderCartPage = searchCatalogPage.pressCartButton();
        forgottenItemsPage = orderCartPage.pressProceedToCheckoutButtonToOpenForgottenItems();
        orderCartReviewOrderPage = forgottenItemsPage.pressNextButton();
        Thread.sleep(1500);
        orderCartOrderPlacedPage = orderCartReviewOrderPage.pressSubmitOrderButton();
        orderCartOrderPlacedPage.checkElementPresence();
    }

}
