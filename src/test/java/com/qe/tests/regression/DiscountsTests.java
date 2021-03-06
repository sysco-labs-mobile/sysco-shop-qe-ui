package com.qe.tests.regression;

import com.qe.BaseTest;
import com.qe.pages.common.DiscountBulkOverlay;
import com.qe.pages.common.DiscountOverlay;
import com.qe.pages.common.NavDrawer;
import com.qe.pages.discover.DiscoverPage;
import com.qe.pages.login.LoginPage;
import com.qe.pages.search.SearchCatalogPage;
import com.qe.pages.search.TypeAheadPage;
import com.qe.utils.TestUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class DiscountsTests extends BaseTest {
    LoginPage loginPage;
    DiscoverPage discoverPage;
    NavDrawer navDrawer;
    TypeAheadPage typeAheadPage;
    SearchCatalogPage searchCatalogPage;
    DiscountOverlay discountOverlay;
    DiscountBulkOverlay discountBulkOverlay;
    TestUtils utils = new TestUtils();

    @BeforeMethod
    public void beforeMethod(Method m) throws InterruptedException {
        utils.log().info("\n       Starting test:" + m.getName());
        loginPage = new LoginPage();
        discoverPage = new DiscoverPage();
        navDrawer = new NavDrawer();
        searchCatalogPage = new SearchCatalogPage();
        typeAheadPage = new TypeAheadPage();
        discountOverlay = new DiscountOverlay();
        discountBulkOverlay = new DiscountBulkOverlay();
        loginPage.enterEmail(BaseTest.users.getJSONObject("customerDiscounts1").getString("email"));
        loginPage = loginPage.pressNextButton();
        loginPage.enterPassword(BaseTest.users.getJSONObject("customerDiscounts1").getString("password"));
        discoverPage = loginPage.pressLoginButton();
    }

    @Test(retryAnalyzer = com.qe.utils.RetryAnalyzer.class)
    public void itemWithBulkDiscountsOnSearchPage() throws InterruptedException {
            //Expected values
            List<String> expectedTierCases = new ArrayList<>();
            expectedTierCases.add("4+");
            expectedTierCases.add("2 - 3");
            List<String> expectedTierPrices = new ArrayList<>();
            expectedTierPrices.add("$45.51");
            expectedTierPrices.add("$50.50");

            //precondition
            searchCatalogPage = discoverPage.inputSearch("2388746");
            searchCatalogPage.checkElementsPresence("2388746");
            Thread.sleep(10000);
            searchCatalogPage.checkElementsPresenceForFirstItemBulkDiscountCase(
                    BaseTest.products.getJSONObject("product-2388746-on-019-125609").getString("title"),
                    BaseTest.products.getJSONObject("product-2388746-on-019-125609").getString("description"),
                    BaseTest.products.getJSONObject("product-2388746-on-019-125609").getString("strikethroughPricePerCs"),
                    BaseTest.products.getJSONObject("product-2388746-on-019-125609").getString("discountBulkPrice")
            );
            DiscountOverlay discountOverlay = searchCatalogPage.pressFirstItemCaseDiscountInfoBubble();
            discountOverlay.checkElementsPresenceForNewCustomerWelcome(
                    BaseTest.products.getJSONObject("product-2388746-on-019-125609").getString("maxPricePerCS"),
                    BaseTest.products.getJSONObject("product-2388746-on-019-125609").getString("newCustomerSavings")
            );

            searchCatalogPage = discountOverlay.pressCloseButtonToReturnToSearchPage();
            searchCatalogPage.checkElementsPresence("2388746");
            discountBulkOverlay = searchCatalogPage.pressFirstItemBulkDiscountsAvailableButton();
            discountBulkOverlay.checkElementsPresenceForCase(
                    BaseTest.products.getJSONObject("product-2388746-on-019-125609").getString("title") + " Bulk Pricing",
                    expectedTierCases,
                    expectedTierPrices
            );
            discountBulkOverlay.pressCloseButtonToReturnToSearchPage();
            searchCatalogPage.checkElementsPresence("2388746");
    }
}
