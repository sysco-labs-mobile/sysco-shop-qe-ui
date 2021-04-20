package com.qe.pages.login;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

public class LogOutPage extends BaseTest {
    TestUtils utils = new TestUtils();

    /** Only on iOS page */

    @iOSXCUITFindBy(id = "logout")
    private MobileElement logoutIcon;

    @iOSXCUITFindBy(id = "Login Signed Out")
    private MobileElement logoutHeader;

    @iOSXCUITFindBy(id = "You have been successfully logged out")
    private MobileElement logoutDescription;

    @iOSXCUITFindBy(id = "Back to Login Button")
    private MobileElement backToLoginButton;

    public LogOutPage checkElementsPresence() {
        utils.log().info("Check elements presence for log out page");
        SoftAssert softAssert = new SoftAssert();
        //softAssert.assertTrue(logoutHeader.isDisplayed());
        softAssert.assertTrue(logoutDescription.isDisplayed());
        softAssert.assertTrue(backToLoginButton.isDisplayed());
        softAssert.assertAll();
        return this;
    }

    public LoginPage pressBackToLoginButton() {
        click(backToLoginButton, "Press back to login button on Log out page");
        return new LoginPage();
    }

}
