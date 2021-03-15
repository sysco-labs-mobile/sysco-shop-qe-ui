package com.qe.pages.common;

import com.qe.BaseTest;
import com.qe.pages.login.LoginPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class IntercomPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(id = "intercom_toolbar_close")
    @iOSXCUITFindBy(id = "intercom close button")
    private MobileElement closeButton;

    public LoginPage pressCloseButton() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(closeButton);
        return new LoginPage();
    }
}
