package com.qe.tests;

import com.qe.BaseTest;
import com.qe.pages.common.NavDrawer;
import com.qe.pages.search.SearchCatalogPage;
import com.qe.pages.discover.DiscoverPage;
import com.qe.pages.login.LoginPage;
import com.qe.pages.search.TypeAheadPage;
import com.qe.utils.TestUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class SearchCatalogTests extends BaseTest {
    LoginPage loginPage;
    DiscoverPage discoverPage;
    NavDrawer navDrawer;
    SearchCatalogPage searchCatalogPage;
    TypeAheadPage typeAheadPage;
    TestUtils utils = new TestUtils();

    @BeforeMethod
    public void beforeMethod(Method m)  throws InterruptedException  {
        loginPage = new LoginPage();
        discoverPage = new DiscoverPage();
        navDrawer = new NavDrawer();
        searchCatalogPage = new SearchCatalogPage();
        typeAheadPage = new TypeAheadPage();
        loginPage.enterEmail(BaseTest.users.getJSONObject("customer").getString("email"));
        loginPage = loginPage.pressNextButton();
        loginPage.enterPassword(BaseTest.users.getJSONObject("customer").getString("password"));
        discoverPage = loginPage.pressLoginButton();
    }

    @Test
    public void search() throws InterruptedException {
        typeAheadPage = discoverPage.inputSearchForTypeAhead("beef ground bulk");
        SearchCatalogPage searchCatalogPage = typeAheadPage.pressSearchResultFirst();
        //searchCatalogPage.checkElementsPresenceForSupc0566709();
    }

    @Test
    public void searchTypeAhead() throws InterruptedException {
         typeAheadPage = discoverPage.inputSearchForTypeAhead("beef");
        typeAheadPage.checkElementsPresence("beef");
    }
}
