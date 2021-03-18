package com.qe.tests.smoke;

import com.qe.BaseTest;
import com.qe.pages.common.DiscountBulkOverlay;
import com.qe.pages.common.DiscountOverlay;
import com.qe.pages.common.NavDrawer;
import com.qe.pages.discover.DiscoverPage;
import com.qe.pages.login.LoginPage;
import com.qe.pages.search.SearchCatalogPage;
import com.qe.pages.search.TypeAheadPage;
import com.qe.utils.TestUtils;
import org.testng.annotations.*;

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
    }

    @Test(retryAnalyzer = com.qe.utils.RetryAnalyzer.class)
    public void itemWithBulkDiscountsOnSearchPage() throws InterruptedException {
        loginPage.enterEmail(BaseTest.users.getJSONObject("customerDiscounts1").getString("email"));
        loginPage = loginPage.pressNextButton();
        loginPage.enterPassword(BaseTest.users.getJSONObject("customerDiscounts1").getString("password"));
        discoverPage = loginPage.pressLoginButton();
        searchCatalogPage = discoverPage.inputSearch("2388746");
        searchCatalogPage.checkElementsPresence("2388746");
        Thread.sleep(10000);
        DiscountOverlay discountOverlay = searchCatalogPage.pressFirstItemCaseDiscountInfoBubble();
        searchCatalogPage = discountOverlay.pressCloseButtonToReturnToSearchPage();
        searchCatalogPage.checkElementsPresence("2388746");
        discountBulkOverlay = searchCatalogPage.pressFirstItemBulkDiscountsAvailableButton();
    }

}
