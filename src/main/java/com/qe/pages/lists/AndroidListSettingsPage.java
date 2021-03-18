package com.qe.pages.lists;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AndroidListSettingsPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Back")
    private MobileElement closeButton;

    @AndroidFindBy(id = "parGroupsSettingsContainer")
    private MobileElement parListsButton;

    @AndroidFindBy(id = "listSettingsContainer")
    private MobileElement listSettingsButton;

    public ListSettingsPage pressListSettingsButtonOnAndroid() {
        click(listSettingsButton);
        return new ListSettingsPage();
    }
}
