package com.qe.pages.lists.par;

import com.qe.BaseTest;
import com.qe.pages.lists.ListSettingsPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ParPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Back")
    private MobileElement closeButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private MobileElement parNamePageTitle;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/parSettingsContainer")
    private MobileElement parSettingsButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/editParItemsContainer")
    private MobileElement editParItemsButton;

    public ListSettingsPage pressBackButton() {
        click(closeButton);
        return new ListSettingsPage();
    }

    public ParSettingsPage pressParSettings() {
        click(parSettingsButton);
        return new ParSettingsPage();
    }

    public EditParPage pressEditParItemsButton() {
        click(editParItemsButton);
        return new EditParPage();
    }
}
