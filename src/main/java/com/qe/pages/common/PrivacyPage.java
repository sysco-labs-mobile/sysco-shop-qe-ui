package com.qe.pages.common;

import com.qe.BaseTest;
import com.qe.pages.login.LoginPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PrivacyPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(id = "Navigate up")
    @iOSXCUITFindBy(id = "back")
    private MobileElement backButton;

    public LoginPage pressBackButton() {
        click(backButton);
        return new LoginPage();
    }
}
