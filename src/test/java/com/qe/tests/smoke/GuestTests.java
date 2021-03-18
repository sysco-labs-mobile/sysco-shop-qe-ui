package com.qe.tests.smoke;

import com.qe.BaseTest;
import com.qe.pages.discover.DiscoverPage;
import com.qe.pages.discover.ZipSwitcherModal;
import com.qe.pages.login.LoginPage;
import com.qe.pages.login.ZipSwitcherPage;
import com.qe.pages.product.ProductCardPage;
import com.qe.pages.search.SearchCatalogPage;
import com.qe.utils.TestUtils;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class GuestTests extends BaseTest {
    TestUtils utils = new TestUtils();
    LoginPage loginPage;
    ZipSwitcherPage zipSwitcherPage;
    ZipSwitcherModal zipSwitcherModal;
    DiscoverPage discoverPage;
    ProductCardPage productCardPage;
    SearchCatalogPage searchCatalogPage;

    @BeforeMethod
    public void beforeMethod(Method m) {
        utils.log().info("\n       Starting test:" + m.getName());

        loginPage = new LoginPage();
        loginPage = new LoginPage();
        zipSwitcherPage = new ZipSwitcherPage();
        zipSwitcherModal = new ZipSwitcherModal();
        discoverPage = new DiscoverPage();
        productCardPage = new ProductCardPage();
        searchCatalogPage = new SearchCatalogPage();
    }

    @Test(retryAnalyzer = com.qe.utils.RetryAnalyzer.class)
    public void loginAsGuest() {
        zipSwitcherPage = loginPage.pressContinueAsGuestButton();
        zipSwitcherPage.inputZip(BaseTest.users.getJSONObject("guestCorrectZipcode1").getString("zipInput"));
        discoverPage = zipSwitcherPage.pressStartShoppingButtonForValidZip();
        discoverPage.checkGuestElementsPresence(BaseTest.users.getJSONObject("guestCorrectZipcode1").getString("zipInput"));
    }

    @Test(retryAnalyzer = com.qe.utils.RetryAnalyzer.class)
    public void loginAsGuestForNotAvailableZip() {
        zipSwitcherPage = loginPage.pressContinueAsGuestButton();
        zipSwitcherPage = zipSwitcherPage.inputZip(BaseTest.users.getJSONObject("guestNotAvailableZipcode1").getString("zipInput"));
        zipSwitcherPage = zipSwitcherPage.pressStartShoppingButtonForNotAvailableZip();
        zipSwitcherPage.checkElementsPresenceForNotAvailableZip(BaseTest.users.getJSONObject("guestNotAvailableZipcode1").getString("zipInput"));
        discoverPage = zipSwitcherPage.pressBrowseSyscoProductsButton();
        discoverPage.checkGuestElementsPresence(BaseTest.users.getJSONObject("guestCorrectZipcode1").getString("zipInput"));
    }

    @Test(retryAnalyzer = com.qe.utils.RetryAnalyzer.class)
    public void navigateToLoginFromZipSwitcher() {
        //precondition
        zipSwitcherPage = loginPage.pressContinueAsGuestButton();

        //test
        loginPage = zipSwitcherPage.pressSignInButton();
        loginPage.checkElementsPresence();
    }

    @Test(retryAnalyzer = com.qe.utils.RetryAnalyzer.class)
    public void loginAsGuestAndSwitchZip() throws InterruptedException {
        //precondition
        zipSwitcherPage = loginPage.pressContinueAsGuestButton();
        zipSwitcherPage.inputZip(BaseTest.users.getJSONObject("guestCorrectZipcode1").getString("zipInput"));
        discoverPage = zipSwitcherPage.pressStartShoppingButtonForValidZip();
        discoverPage.checkGuestElementsPresence(BaseTest.users.getJSONObject("guestCorrectZipcode1").getString("zipInput"));

        //test
        zipSwitcherModal = discoverPage.pressZipSwitcherButton();
        zipSwitcherModal.inputZip(BaseTest.users.getJSONObject("guestCorrectZipcode2").getString("zipInput"));
        discoverPage = zipSwitcherModal.pressUpdateButtonForAvailableZip();
        Thread.sleep(4000);
        discoverPage.checkGuestElementsPresence(BaseTest.users.getJSONObject("guestCorrectZipcode2").getString("zipInput"));
    }

}
