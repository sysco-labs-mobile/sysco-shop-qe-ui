package com.qe.pages.common;

import com.qe.BaseTest;
import com.qe.pages.discover.DiscoverPage;
import com.qe.pages.login.LoginPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

public class GuestNavDrawer extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(id = "Sysco Shop")
    @iOSXCUITFindBy(id = "drawer header logo image")
    private MobileElement drawerLogo;

    @AndroidFindBy(id = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"SHOP\"`]")
    private MobileElement shopHeader;

    @AndroidFindBy(id = "nav_discover")
    @iOSXCUITFindBy(id = "drawer-0-0")
    private MobileElement discoverButton;

    @iOSXCUITFindBy(id = "discover")
    private MobileElement discoverIcon;

    @AndroidFindBy(id = "nav_discover")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"PROFILE\"`]")
    private MobileElement profileHeader;

    @AndroidFindBy(id = "nav_help")
    @iOSXCUITFindBy(id = "drawer-1-0")
    private MobileElement helpButton;

    @iOSXCUITFindBy(id = "help")
    private MobileElement helpIcon;

    @AndroidFindBy(id = "nav_sign_in")
    @iOSXCUITFindBy(id = "drawer-1-1")
    private MobileElement signinButton;

    @AndroidFindBy(id = "nav_discover")
    @iOSXCUITFindBy(id = "signin")
    private MobileElement signingIcon;


    public GuestNavDrawer checkElementsPresence() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(shopHeader.isDisplayed());
        softAssert.assertTrue(discoverButton.isDisplayed());
        softAssert.assertTrue(profileHeader.isDisplayed());
        softAssert.assertTrue(helpButton.isDisplayed());
        softAssert.assertAll();
        return this;
    }

    public DiscoverPage pressDiscoverPageButton() {
        click(discoverButton);
        return new DiscoverPage();
    }

    public IntercomPage pressHelpButton() {
        click(helpButton);
        return new IntercomPage();
    }

    public LoginPage pressSignInButton() {
        click(signinButton);
        return new LoginPage();
    }


}
