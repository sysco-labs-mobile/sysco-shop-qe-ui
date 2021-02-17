package com.qe.pages.login;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OnboardingPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.Button[1]")
    private MobileElement closeButton;

    public LoginPage pressCloseButton() {
        click(closeButton);
        return new LoginPage();
    }
}
