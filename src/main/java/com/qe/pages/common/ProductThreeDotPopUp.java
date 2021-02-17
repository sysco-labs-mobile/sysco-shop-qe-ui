package com.qe.pages.common;

import com.qe.BaseTest;
import com.qe.pages.lists.AddToListPage;
import com.qe.pages.lists.ListPage;
import com.qe.pages.lists.RemoveFromListModal;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ProductThreeDotPopUp extends BaseTest {
    TestUtils utils = new TestUtils();

    //from search
    @AndroidFindBy(id = "android:id/title")
    //from list
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    @iOSXCUITFindBy(id = "Add to list")
    private MobileElement addToListButton;

    //from list
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    @iOSXCUITFindBy(id = "Remove item")
    private MobileElement removeItemButton;

    @iOSXCUITFindBy(id = "Cancel")
    private MobileElement cancelButton;

    public AddToListPage pressAddToListButton() {
        click(addToListButton);
        return new AddToListPage();
    }

    public RemoveFromListModal pressRemoveFromListButton() {
        click(removeItemButton);
        return new RemoveFromListModal();
    }

    public ListPage pressCancelButton() {
        click(cancelButton);
        return new ListPage();
    }
}
