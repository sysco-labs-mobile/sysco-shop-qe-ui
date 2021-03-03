package com.qe.tests;

import com.qe.BaseTest;
import com.qe.pages.common.NavDrawer;
import com.qe.pages.discover.AccountSelectorPage;
import com.qe.pages.discover.DiscoverPage;
import com.qe.pages.login.LoginPage;
import com.qe.pages.orders.OrderCartPage;
import com.qe.pages.orders.OrderCartReviewOrderPage;
import com.qe.pages.search.SearchCatalogPage;
import com.qe.pages.search.TypeAheadPage;
import com.qe.utils.TestUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class MultibuyerTests extends BaseTest {
    LoginPage loginPage;
    DiscoverPage discoverPage;
    AccountSelectorPage accountSelectorPage;
    SearchCatalogPage searchCatalogPage;
    TypeAheadPage typeAheadPage;
    OrderCartPage orderCartPage;
    NavDrawer navDrawer;
    OrderCartReviewOrderPage orderCartReviewOrderPage;
    TestUtils utils = new TestUtils();

    @BeforeMethod
    public void beforeMethod(Method m) {
        utils.log().info("\n       Starting test:" + m.getName());
        loginPage = new LoginPage();
        discoverPage = new DiscoverPage();
        navDrawer = new NavDrawer();
        searchCatalogPage = new SearchCatalogPage();
        typeAheadPage = new TypeAheadPage();
        accountSelectorPage = new AccountSelectorPage();
        orderCartPage = new OrderCartPage();
        orderCartReviewOrderPage = new OrderCartReviewOrderPage();
        loginPage.enterEmail(BaseTest.users.getJSONObject("multibuyer").getString("email"));
        loginPage = loginPage.pressNextButton();
        loginPage.enterPassword(BaseTest.users.getJSONObject("multibuyer").getString("password"));
        discoverPage = loginPage.pressLoginButton();
    }

    @Test
    public void multibuyerAccountSelection() {
        accountSelectorPage = discoverPage.pressAccountSelectorButton();
        accountSelectorPage.checkElementsPresence();
        discoverPage = accountSelectorPage.pressOnFirstAccount();
        String expectedFirstAccountInListTitle = ((JSONObject) BaseTest.users.getJSONObject("multibuyer").getJSONArray("accounts").get(0)).getString("accountTitle");
        discoverPage.checkElementsPresenceForAccountSelector(expectedFirstAccountInListTitle);
    }

    @Test
    public void multibuyerCannotSubmitOrder() throws InterruptedException {
        if(getPlatform().equalsIgnoreCase("iOS")) {
            searchCatalogPage = discoverPage.inputSearch("beef ground bulk");
            searchCatalogPage.inputCaseQuantityForFirstProduct("1");

            orderCartPage = searchCatalogPage.pressCartButton();
            orderCartReviewOrderPage = orderCartPage.pressProceedToCheckoutButton();
            orderCartReviewOrderPage.pressSubmitOrderButton();
            orderCartReviewOrderPage.checkElementsPresenceForErrorMAApproval();
        }
        if(getPlatform().equalsIgnoreCase("Android")) {
            typeAheadPage = discoverPage.inputSearchForTypeAhead("beef ground bulk");
            searchCatalogPage = typeAheadPage.pressSearchResultFirst();
            searchCatalogPage.pressPlusQuantityForFirstProductCase();

            orderCartPage = searchCatalogPage.pressCartButton();
            orderCartReviewOrderPage = orderCartPage.pressProceedToCheckoutButton();
            orderCartReviewOrderPage.pressSubmitOrderButton();
            orderCartReviewOrderPage.checkElementsPresenceForErrorMAApproval();
        }
    }

}
