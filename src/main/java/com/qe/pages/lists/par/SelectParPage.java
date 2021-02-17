package com.qe.pages.lists.par;

import com.qe.BaseTest;
import com.qe.pages.lists.ListPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SelectParPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Back")
    @iOSXCUITFindBy(id = "Back")
    private MobileElement backButton;

    //android Show Par Group
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private MobileElement showParGroupPageTitle;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/createNewParGroupContainer")
    private MobileElement createNewParGroupButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RadioButton")
    private MobileElement selectorForNone;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RadioButton")
    private MobileElement selectorForFirstParGroupInList;

    public ListPage pressBackButton() {
        click(backButton);
        return new ListPage();
    }

    public SelectParPage selectNone() {
        click(selectorForNone);
        return this;
    }

    public SelectParPage selectFirstParGroupInList() {
        click(selectorForFirstParGroupInList);
        return this;
    }

    public CreateParPage pressCreateParGroupButton() {
        click(createNewParGroupButton);
        return new CreateParPage();
    }
}
