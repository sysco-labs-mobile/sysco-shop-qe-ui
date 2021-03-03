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
    public void beforeMethod(Method m) {
        utils.log().info("\n       Starting test:" + m.getName());
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
            searchCatalogPage.inputCaseQuantityForFirstProduct("1");
        }
        if(getPlatform().equalsIgnoreCase("Android")) {
            //precondition
            typeAheadPage = discoverPage.inputSearchForTypeAhead("beef ground bulk");
            searchCatalogPage = typeAheadPage.pressSearchResultFirst();
            searchCatalogPage.pressPlusQuantityForFirstProductCase();
        }

        //test
        orderCartPage = searchCatalogPage.pressCartButton();
        orderCartReviewOrderPage = orderCartPage.pressProceedToCheckoutButton();
        orderCartOrderPlacedPage = orderCartReviewOrderPage.pressSubmitOrderButton();
        orderCartOrderPlacedPage.checkElementPresence();
    }

    @Test
    public void orderCartPages() throws InterruptedException {
        if(getPlatform().equalsIgnoreCase("iOS")) {
            //precondition
            searchCatalogPage = discoverPage.inputSearch("0566709");
            searchCatalogPage.checkElementsPresence("0566709");
            Thread.sleep(10000);
            searchCatalogPage.inputCaseQuantityForFirstProduct("1");

            //test
            orderCartPage = searchCatalogPage.pressCartButton();
            orderCartPage.checkElementsPresence("$55.36", "1 CS | 0 EA");
            orderCartPage.checkElementsPresenceOfFirstOrderLineItem(
                    BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("title"),
                    BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("description"),
                    BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("pricePerCsCatchweight"),
                    null,
                    BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("totalPrice1CS")
            );
            orderCartReviewOrderPage = orderCartPage.pressProceedToCheckoutButton();
            orderCartReviewOrderPage.checkElementsPresence(
                    BaseTest.users.getJSONObject("customer").getString("shippingAddress"),
                    "1 CS | 0 EA",
                    "1",
                    "$55.36");
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
        }
        if(getPlatform().equalsIgnoreCase("Android")) {
            //precondition
            typeAheadPage = discoverPage.inputSearchForTypeAhead("beef ground bulk");
            searchCatalogPage = typeAheadPage.pressSearchResultFirst();
            //searchCatalogPage.checkElementsPresenceForSupc0566709();
            searchCatalogPage.pressPlusQuantityForFirstProductCase();

            //test
            orderCartPage = searchCatalogPage.pressCartButton();
            orderCartReviewOrderPage = orderCartPage.pressProceedToCheckoutButton();
            orderCartOrderPlacedPage = orderCartReviewOrderPage.pressSubmitOrderButton();
            orderCartOrderPlacedPage.checkElementPresence();
            //TODO Android: increase coverage as on iOS, Used here pages are missing Android locators and maybe some specific android test code
        }
    }
}
