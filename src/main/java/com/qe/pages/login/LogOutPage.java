package com.qe.pages.login;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

public class LogOutPage extends BaseTest {
    TestUtils utils = new TestUtils();

    /** Only on iOS page */

    @iOSXCUITFindBy(id = "logout")
    private MobileElement logoutIcon;

    @iOSXCUITFindBy(id = "Login Signed Out")
    private MobileElement logoutHeader;

    @iOSXCUITFindBy(id = "Login Successfully Signed Out")
    private MobileElement logoutDescription;

    @iOSXCUITFindBy(id = "Back to Login Button")
    private MobileElement backToLoginButton;

    public LogOutPage checkElementsPresence() {
        //Assert.assertTrue(logoutHeader.isDisplayed());
        Assert.assertTrue(logoutDescription.isDisplayed());
        Assert.assertTrue(backToLoginButton.isDisplayed());
        return this;
    }

    public LoginPage pressBackToLoginButton() {
        click(backToLoginButton);
        return new LoginPage();
    }

}
