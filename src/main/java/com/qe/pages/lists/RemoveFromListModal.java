package com.qe.pages.lists;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RemoveFromListModal extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(id = "alertTitle")
    private MobileElement removeHeader;

    @AndroidFindBy(id = "alertText")
    private MobileElement removeDescription;

    @AndroidFindBy(id = "alertPrimaryButton")
    private MobileElement yesButton;

    @AndroidFindBy(id = "alertSecondaryButton")
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
