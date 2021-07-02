package com.qe.tests.smoke;

import com.qe.BaseTest;
import com.qe.pages.common.NavDrawer;
import com.qe.pages.discover.DiscoverPage;
import com.qe.pages.login.LoginPage;
import com.qe.pages.search.*;
import com.qe.utils.TestUtils;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;

public class SearchCatalogFilterTests extends BaseTest {
    LoginPage loginPage;
    DiscoverPage discoverPage;
    NavDrawer navDrawer;
    SearchCatalogPage searchCatalogPage;
    TypeAheadPage typeAheadPage;
    FilterPage filterPage;
    FilterCategoryPage filterCategoryPage;
    FilterStockTypePage filterStockTypePage;

    TestUtils utils = new TestUtils();

    @BeforeMethod
    public void beforeMethod(Method m) {
        utils.log().info("\n       Starting test:" + m.getName());

        loginPage = new LoginPage();
        discoverPage = new DiscoverPage();
        navDrawer = new NavDrawer();
        searchCatalogPage = new SearchCatalogPage();
        typeAheadPage = new TypeAheadPage();
        filterPage = new FilterPage();
        filterCategoryPage = new FilterCategoryPage();
        filterStockTypePage = new FilterStockTypePage();
    }

    @Test(retryAnalyzer = com.qe.utils.RetryAnalyzer.class)
    public void filterOnSearchPage() throws InterruptedException {
        loginPage.enterEmail(BaseTest.users.getJSONObject("customer").getString("email"));
        loginPage = loginPage.pressNextButton();
        loginPage.enterPassword(BaseTest.users.getJSONObject("customer").getString("password"));
        discoverPage = loginPage.pressLoginButton();
        typeAheadPage = discoverPage.inputSearchForTypeAhead("beef ground bulk");
        typeAheadPage.checkElementsPresence("beef");
        searchCatalogPage = typeAheadPage.pressSearchResultFirst();
        searchCatalogPage.checkElementsPresence("beef");
        String beforeNumResultsText = searchCatalogPage.getSearchResultsText();
        searchCatalogPage.pressCatalogFilter();
        filterPage.checkElementsPresenceForCatalogMenuFilters();
        filterPage.pressCloseButton();
        searchCatalogPage.pressCatalogFilter();
        filterPage.pressCategoryButton();
        filterCategoryPage.pressFirstCategorySelector();
        filterCategoryPage.pressBack();
        searchCatalogPage = filterPage.pressDoneButton();
        Thread.sleep(3000);
        String numResultsText = searchCatalogPage.getSearchResultsText();
        Assert.assertNotEquals(beforeNumResultsText, numResultsText);
        searchCatalogPage.pressCatalogFilter();
        filterPage.pressStockTypeButton();
        filterStockTypePage.pressStockSelector();
        filterStockTypePage.pressBack();
        filterPage.pressDoneButton();
        Thread.sleep(1000);
        String lastNumResultsText = searchCatalogPage.getSearchResultsText();
        Assert.assertNotEquals(numResultsText, lastNumResultsText);
    }

}
