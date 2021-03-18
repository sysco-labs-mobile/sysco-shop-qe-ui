package com.qe.tests.smoke;

import com.qe.BaseTest;
import com.qe.pages.common.NavDrawer;
import com.qe.pages.search.SearchCatalogPage;
import com.qe.pages.discover.DiscoverPage;
import com.qe.pages.login.LoginPage;
import com.qe.pages.search.TypeAheadPage;
import com.qe.utils.TestUtils;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class SearchCatalogTests extends BaseTest {
    LoginPage loginPage;
    DiscoverPage discoverPage;
    NavDrawer navDrawer;
    SearchCatalogPage searchCatalogPage;
    TypeAheadPage typeAheadPage;
    TestUtils utils = new TestUtils();

    @BeforeMethod
    public void beforeMethod(Method m) {
        utils.log().info("\n       Starting test:" + m.getName());

        loginPage = new LoginPage();
        discoverPage = new DiscoverPage();
        navDrawer = new NavDrawer();
        searchCatalogPage = new SearchCatalogPage();
        typeAheadPage = new TypeAheadPage();
    }

    @Test(retryAnalyzer = com.qe.utils.RetryAnalyzer.class)
    public void search() throws InterruptedException {
        loginPage.enterEmail(BaseTest.users.getJSONObject("customer").getString("email"));
        loginPage = loginPage.pressNextButton();
        loginPage.enterPassword(BaseTest.users.getJSONObject("customer").getString("password"));
        discoverPage = loginPage.pressLoginButton();
        typeAheadPage = discoverPage.inputSearchForTypeAhead("beef ground bulk");
        typeAheadPage.checkElementsPresence("beef");
        searchCatalogPage = typeAheadPage.pressSearchResultFirst();
        searchCatalogPage.checkElementsPresence("beef");
    }

}
