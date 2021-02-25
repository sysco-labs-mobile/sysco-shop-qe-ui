package com.qe.tests;

import com.qe.BaseTest;
import com.qe.pages.common.NavDrawer;
import com.qe.pages.discover.DiscoverPage;
import com.qe.pages.login.LoginPage;
import com.qe.pages.orders.*;
import com.qe.pages.product.ProductCardPage;
import com.qe.pages.search.SearchCatalogPage;
import com.qe.pages.search.TypeAheadPage;
import com.qe.utils.TestUtils;
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
    ProductCardPage productCardPage;
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
        productCardPage = new ProductCardPage();
        loginPage.enterEmail(BaseTest.users.getJSONObject("customer").getString("email"));
        loginPage = loginPage.pressNextButton();
        loginPage.enterPassword(BaseTest.users.getJSONObject("customer").getString("password"));
        discoverPage = loginPage.pressLoginButton();
    }

    @Test
    public void productCard() throws InterruptedException {
        if(getPlatform().equalsIgnoreCase("iOS")) {
            //precondition
            searchCatalogPage = discoverPage.inputSearch("0566709");
            searchCatalogPage.checkElementsPresence("0566709");
            Thread.sleep(10000);
            productCardPage = searchCatalogPage.pressOnFirstProduct();

            //test
            productCardPage.checkElementsPresence(
                    BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("title"),
                    BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("description")
            );
            productCardPage.checkElementsPresenceForCase(
                    BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("pricePerCsCatchweight"));
            productCardPage.checkElementsPresenceOnProductDetailsTab(
                    BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("stockStatus"),
                    BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("gtin"),
                    BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("manufacturerUPC"),
                    BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("storageLocation"),
                    BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("splitDetail"),
                    BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("averageWeight")
            );
            productCardPage.pressCasePlusButton();
            productCardPage.pressNutritionButton();
            productCardPage.checkElementsPresenceOnNutritionTab();
        }
        if(getPlatform().equalsIgnoreCase("Android")) {
            //precondition
            typeAheadPage = discoverPage.inputSearchForTypeAhead("beef ground bulk");
            searchCatalogPage = typeAheadPage.pressSearchResultFirst();
            //searchCatalogPage.checkElementsPresenceForSupc0566709();
            searchCatalogPage.pressPlusQuantityForFirstProductCase();

            //test

        }
    }

}