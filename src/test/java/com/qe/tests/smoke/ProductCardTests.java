package com.qe.tests.smoke;

import com.qe.BaseTest;
import com.qe.pages.common.NavDrawer;
import com.qe.pages.discover.DiscoverPage;
import com.qe.pages.login.LoginPage;
import com.qe.pages.product.ProductCardDetailsPage;
import com.qe.pages.product.ProductCardNutritionPage;
import com.qe.pages.product.ProductCardPage;
import com.qe.pages.search.SearchCatalogPage;
import com.qe.pages.search.TypeAheadPage;
import com.qe.utils.TestUtils;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class ProductCardTests extends BaseTest {
    LoginPage loginPage;
    DiscoverPage discoverPage;
    NavDrawer navDrawer;
    TypeAheadPage typeAheadPage;
    SearchCatalogPage searchCatalogPage;
    ProductCardPage productCardPage;
    ProductCardDetailsPage productCardDetailsPage;
    ProductCardNutritionPage productCardNutritionPage;
    TestUtils utils = new TestUtils();

    @BeforeMethod
    public void beforeMethod(Method m) {
        utils.log().info("\n       Starting test:" + m.getName());

        loginPage = new LoginPage();
        discoverPage = new DiscoverPage();
        navDrawer = new NavDrawer();
        searchCatalogPage = new SearchCatalogPage();
        typeAheadPage = new TypeAheadPage();
        productCardPage = new ProductCardPage();
        productCardDetailsPage = new ProductCardDetailsPage();
        productCardNutritionPage = new ProductCardNutritionPage();
    }

    @Test(retryAnalyzer = com.qe.utils.RetryAnalyzer.class)
    public void productCard() throws InterruptedException {
        //precondition
        loginPage.enterEmail(BaseTest.users.getJSONObject("customer").getString("email"));
        loginPage = loginPage.pressNextButton();
        loginPage.enterPassword(BaseTest.users.getJSONObject("customer").getString("password"));
        discoverPage = loginPage.pressLoginButton();
        searchCatalogPage = discoverPage.inputSearch("0566709");
        searchCatalogPage.checkElementsPresence("0566709");
        Thread.sleep(10000);
        productCardPage = searchCatalogPage.pressOnFirstProduct();
        //test
        productCardPage.checkElementsPresence(
                BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("brand"),
                BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("title"),
                BaseTest.products.getJSONObject("product-0566709-on-056-148283").getString("description")
        );
        productCardPage
                .checkCaseQuantityFieldValue("Add")
                .pressCasePlusButton()
                .checkCaseQuantityFieldValue("1")
                .checkCartBadgeValue("1")
                .pressCaseMinusButton()
                .checkCaseQuantityFieldValue("Add")
                .inputCaseQuantity("3")
                .checkCaseQuantityFieldValue("3")
                .checkCartBadgeValue("3");
        productCardDetailsPage = productCardPage.pressProductDetailsButton();
        productCardPage = productCardDetailsPage
                .checkElementsPresence()
                .pressBackButton();
        Thread.sleep(1500);
        scrollDownByCoordinates();
        productCardNutritionPage = productCardPage.pressNutritionButton();
        Thread.sleep(1500);
        productCardPage = productCardNutritionPage
                .checkElementsPresence()
                .pressBackButton();
    }

}
