package com.qe.tests;

import com.qe.BaseTest;
import com.qe.pages.common.NavDrawer;
import com.qe.pages.discover.CreditCardModal;
import com.qe.pages.discover.DiscoverPage;
import com.qe.pages.login.LoginPage;
import com.qe.pages.orders.*;
import com.qe.pages.search.SearchCatalogPage;
import com.qe.pages.search.TypeAheadPage;
import com.qe.utils.TestUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

//TODO Android: Used here pages are missing Android locators and maybe some specific android test code
public class CreditCardTests extends BaseTest {
    LoginPage loginPage;
    CreditCardModal creditCardModal;
    DiscoverPage discoverPage;
    NavDrawer navDrawer;
    TypeAheadPage typeAheadPage;
    SearchCatalogPage searchCatalogPage;
    OrderCartPage orderCartPage;
    OrdersPage ordersPage;
    OrderCartReviewOrderPage orderCartReviewOrderPage;
    CreditCardSurchargeModal creditCardSurchargeModal;
    CreditCardPricingModal creditCardPricingModal;

    TestUtils utils = new TestUtils();

    @BeforeMethod
    public void beforeMethod(Method m) {
        utils.log().info("\n       Starting test:" + m.getName());
        loginPage = new LoginPage();
        creditCardModal = new CreditCardModal();
        discoverPage = new DiscoverPage();
        navDrawer = new NavDrawer();
        orderCartPage = new OrderCartPage();
        searchCatalogPage = new SearchCatalogPage();
        typeAheadPage = new TypeAheadPage();
        ordersPage = new OrdersPage();
        orderCartReviewOrderPage = new OrderCartReviewOrderPage();
        creditCardSurchargeModal = new CreditCardSurchargeModal();
        creditCardPricingModal = new CreditCardPricingModal();
        loginPage.enterEmail(BaseTest.users.getJSONObject("customerCC").getString("email"));
        loginPage = loginPage.pressNextButton();
        loginPage.enterPassword(BaseTest.users.getJSONObject("customerCC").getString("password"));
        creditCardModal = loginPage.pressLoginButtonForCreditCardUser();
    }

    @Test
    public void creditCardWelcomeModal() {
        DiscoverPage discoverPage = creditCardModal
                .checkElementsPresence()
                .pressAcceptButton();

        discoverPage.checkElementsPresence();
    }


    @Test
    public void creditCardOrderCartLabel() {
        //precondition
        DiscoverPage discoverPage = creditCardModal.pressAcceptButton();
        ordersPage = discoverPage.pressNavBarDrawerButton().pressOrdersButton();

        if(getPlatform().equalsIgnoreCase("iOS")) {
            searchCatalogPage = discoverPage.inputSearch("0566709");
            searchCatalogPage.checkElementsPresence("0566709");
            searchCatalogPage.inputCaseQuantityForFirstProduct("1");
            orderCartPage = searchCatalogPage.pressCartButton();

            //test
            orderCartPage.checkElementsPresenceForCreditCardUser();
        }
    }

    @Test
    public void creditCardReviewOrderButtonAndModal() {
        //precondition
        DiscoverPage discoverPage = creditCardModal.pressAcceptButton();
        ordersPage = discoverPage.pressNavBarDrawerButton().pressOrdersButton();

        if(getPlatform().equalsIgnoreCase("iOS")) {
            searchCatalogPage = discoverPage.inputSearch("0566709");
            searchCatalogPage.checkElementsPresence("0566709");
            searchCatalogPage.inputCaseQuantityForFirstProduct("1");
            orderCartPage = searchCatalogPage.pressCartButton();
            orderCartReviewOrderPage = orderCartPage.pressProceedToCheckoutButton();

            //test
            scrollDownByCoordinates();
            orderCartReviewOrderPage.checkElementsPresenceForCreditCardUser();
            creditCardSurchargeModal = orderCartReviewOrderPage.pressCreditCardSurchargeBubble();
            creditCardSurchargeModal.checkElementsPresence();
            orderCartReviewOrderPage = creditCardSurchargeModal.pressOkButton();
            creditCardPricingModal = orderCartReviewOrderPage.pressEstimatedTotalInfoBubble();
            creditCardPricingModal.checkElementsPresence();
            creditCardPricingModal.pressOkButton();
        }
    }
}
