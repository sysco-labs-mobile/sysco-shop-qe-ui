package com.qe.pages.lists.filter;

import com.qe.BaseTest;
import com.qe.pages.lists.ListPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ListFilterPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ImageButton")
    private MobileElement closeButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ImageButton")
    private MobileElement filterPageTitle;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ImageButton")
    private MobileElement clearButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/productListSortBy")
    private MobileElement sortByButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/productListCategory")
    private MobileElement syscoCategoryButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/seeResultsButton")
    private MobileElement seeResultsButton;

    public ListPage pressCloseButton() {
        click(closeButton);
        return new ListPage();
    }

    public ListPage pressSeeResultsButton() {
        click(seeResultsButton);
        return new ListPage();
    }

    public SortByPage pressSortByButton() {
        click(sortByButton);
        return new SortByPage();
    }

    public FilterSyscoCategoryPage pressCategoriesButton() {
        click(syscoCategoryButton);
        return new FilterSyscoCategoryPage();
    }
}
