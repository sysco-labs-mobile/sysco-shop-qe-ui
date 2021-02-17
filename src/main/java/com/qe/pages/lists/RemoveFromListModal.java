package com.qe.pages.lists;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RemoveFromListModal extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/alertTitle")
    private MobileElement removeHeader;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/alertText")
    private MobileElement removeDescription;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/alertPrimaryButton")
    private MobileElement yesButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/alertSecondaryButton")
    private MobileElement noButton;

    public ListPage pressYesButton() {
        click(yesButton);
        return new ListPage();
    }

    public ListPage pressNotButton() {
        click(noButton);
        return new ListPage();
    }
}
