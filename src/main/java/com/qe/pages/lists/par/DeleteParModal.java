package com.qe.pages.lists.par;

import com.qe.BaseTest;
import com.qe.pages.lists.ListPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DeleteParModal extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(id = "alertTitle")
    private MobileElement modalTitle;

    @AndroidFindBy(id = "alertText")
    private MobileElement modalDescription;

    @AndroidFindBy(id = "alertSecondaryButton")
    private MobileElement noButton;

    @AndroidFindBy(id = "alertPrimaryButton")
    private MobileElement yesButton;

    public ListPage pressYesButton() {
        click(yesButton);
        return new ListPage();
    }

    public ListPage pressNoButton() {
        click(noButton);
        return new ListPage();
    }
}
