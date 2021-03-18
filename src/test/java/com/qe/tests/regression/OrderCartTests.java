package com.qe.tests.regression;

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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

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
    public void beforeMethod(Method m) throws InterruptedException {
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
        loginPage.enterEmail(BaseTest.users.getJSONObject("customer").getString("email"));
        loginPage = loginPage.pressNextButton();
        loginPage.enterPassword(BaseTest.users.getJSONObject("customer").getString("password"));
        discoverPage = loginPage.pressLoginButton();
    }

    @Test @Ignore
    public void orderCartPages() throws InterruptedException {
        //precondition
        searchCatalogPage = discoverPage.inputSearch("0566709");
        searchCatalogPage.checkElementsPresence("0566709");
        searchCatalogPage.inputCaseQuantityForFirstProduct("1");
        Thread.sleep(10000);

        //test
        orderCartPage = searchCatalogPage.pressCartButton();
        Thread.sleep(5000);
        orderCartPage.checkElementsPresence("$60.98", "1 CS | 0 EA");
        orderCartPage.checkElementsPresenceForFirstOrderLineItem(
                BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("title"),
                BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("description"),
                BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("pricePerCsCatchweight"),
                null,
                BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("totalPrice1CS")
        );
        forgottenItemsPage = orderCartPage.pressProceedToCheckoutButtonToOpenForgottenItems();
        forgottenItemsPage.checkElementsPresence("$60.98", "1 CS | 0 EA");
        forgottenItemsPage.checkElementsPresenceForFirstElement(
                BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("title"),
                BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("description"),
                BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("pricePerCsCatchweight")
        );
        orderCartReviewOrderPage = forgottenItemsPage.pressNextButton();
        orderCartReviewOrderPage.checkElementsPresence(
                BaseTest.users.getJSONObject("customer").getString("shippingAddress"),
                "1 CS | 0 EA",
                "1",
                "$60.98");
        scrollDownByCoordinates();
        orderCartReviewOrderPage.checkElementsPresenceOfFirstOrderLineItem(
                BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("title"),
                BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("description"),
                BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("pricePerCsCatchweight"),
                BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("totalPrice1CS"),
                "1 CS"
        );
        orderCartOrderPlacedPage = orderCartReviewOrderPage.pressSubmitOrderButton();
        orderCartOrderPlacedPage.checkElementPresence();
        orderCartOrderPlacedPage.checkElementPresence("1 CS", "$55.36");
    }
}
