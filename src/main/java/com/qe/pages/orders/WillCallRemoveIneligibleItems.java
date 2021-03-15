package com.qe.pages.orders;
import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class WillCallRemoveIneligibleItems extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Close")
    @iOSXCUITFindBy(id = "cancel remove items button")
    private MobileElement cancelButton;

    @AndroidFindBy(id = "remove_ineligible_items")
    @iOSXCUITFindBy(id = "Remove Ineligible Items")
    private MobileElement removeIneligibleItemsHeader;

    @AndroidFindBy(id = "remove_ineligible_items_description")
    @iOSXCUITFindBy(id = "Will call orders cannot be submitted if they contain non-stock or remote items. This order contains 1 ineligible items:")
    private MobileElement removeIneligibleItemsDescription;

    @AndroidFindBy(id = "ineligible_items_list")
    @iOSXCUITFindBy(id = "ineligible items list")
    private MobileElement ineligibleItemsList;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    @iOSXCUITFindBy(id = "ineligibleitems-0-0")
    private MobileElement firstIneligibleItemInList;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[1]")
    @iOSXCUITFindBy(id = "Seasoning Powder Carrot")//ssmcust9 8055681
    private MobileElement firstItemTitle;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[2]")
    @iOSXCUITFindBy(id = "8055681 | 1/14OZ | D'ALLASANDRO")//ssmcust9 8055681
    private MobileElement firstItemDescription;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[3]")
    @iOSXCUITFindBy(id = "SPECIAL DELIVERY (REMOTE)")//ssmcust9 8055681
    private MobileElement firstItemRemoteLabel;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")
    @iOSXCUITFindBy(id = "case price label")
    private MobileElement firstItemRemoteLabelCasePriceLabel;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView")
    @iOSXCUITFindBy(id = "total case price label")
    private MobileElement firstItemRemoteLabelTotalCasePriceLabel;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(id = "case quantity label")
    private MobileElement firstItemRemoteLabelCaseQuantityLabel;

    @AndroidFindBy(id = "remove_items_button")
    @iOSXCUITFindBy(id = "remove items button")
    private MobileElement removeItemsButton;

    @AndroidFindBy(id = "ship_by_ground_button")
    @iOSXCUITFindBy(id = "Keep Items and Ship by Ground")
    private MobileElement shipByGroundButton;
}
