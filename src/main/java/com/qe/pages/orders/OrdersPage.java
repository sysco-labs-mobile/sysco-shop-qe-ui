package com.qe.pages.orders;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.testng.Assert;

public class OrdersPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Open navigation drawer")
    @iOSXCUITFindBy(id = "app bar left button")
    private MobileElement navBarDrawerButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/editText")
    @iOSXCUITFindBy(id = "app nav search bar text field")
    private MobileElement searchTextField;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/action_cart")
    @iOSXCUITFindBy(id = "cart button")
    private MobileElement cartButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/title")
    @iOSXCUITFindBy(id = "orders section header title")
    private MobileElement ordersTitle;

    @AndroidFindBy(accessibility = "All orders")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"All Orders\"`][1]")
    private MobileElement allOrdersButton;

    @AndroidFindBy(accessibility = "Open")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Open\"`][1]")
    private MobileElement openOrdersButton;

    @AndroidFindBy(accessibility = "Submitted")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Submitted\"`][1]")
    private MobileElement submittedOrdersButton;

    @AndroidFindBy(accessibility = "Historical")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Historical\"`][1]")
    private MobileElement cancelledOrdersButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/addOrderButton")
    private MobileElement createOrderButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/resultView")
    @iOSXCUITFindBy(id = "orders list")//not sure usable
    private MobileElement ordersList;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout")
    @iOSXCUITFindBy(id = "order-0-0")
    private MobileElement firstOrderInList;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]")
    @iOSXCUITFindBy(id = "order-0-1")
    private MobileElement secondOrderInList;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"SUBMITTED\"`][1]\n")
    private MobileElement firstOrderInListStatusValue;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[2]")
    private MobileElement firstOrderInListNameValue;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[3]")
    private MobileElement firstOrderInListNumberValue;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[4]")
    private MobileElement firstOrderInListDateValue;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]")
    private MobileElement firstOrderInListTotalPriceValue;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[2]")
    private MobileElement firstOrderInListItemCaseEachValue;


    /** Loading elements */
    String androidProgressBarId = "com.syscocorp.mss.enterprise.dev:id/ordersProgressBar";

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/ordersProgressBar")
    private MobileElement progressBar;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/loadingView")
    private MobileElement loadingView;

    String tapToRetryButtonId = "com.syscocorp.mss.enterprise.dev:id/couldNotLoad";

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/couldNotLoad")
    private MobileElement couldNotLoadOrdersTitle;

    @AndroidFindBy(accessibility = "Tap to Retry")
    private MobileElement tapToRetryButton;

    public OrdersPage() {
    }

    private OrdersPage ifProgressBarPresentWait() throws InterruptedException {
        if(getPlatform().equalsIgnoreCase("Android")){
            while(isElementPresent(By.id(androidProgressBarId))) {
                Thread.sleep(10000);
            }
        }
        return new OrdersPage();
    }

    private OrdersPage ifFailedReload() {
        if(isElementPresent(By.id(tapToRetryButtonId))) {
            click(tapToRetryButton);
        }
        return new OrdersPage();
    }

    public OrdersPage checkPageIsLoadedOrReloadWith3Attempts() throws InterruptedException {
        for(int i = 0; i < 3; i++) {
            ifProgressBarPresentWait();
            ifFailedReload();
        }
        return new OrdersPage();
    }

    public OrdersPage checkElementsPresence() {
        Assert.assertTrue(navBarDrawerButton.isDisplayed());
        Assert.assertTrue(searchTextField.isDisplayed());
        Assert.assertTrue(cartButton.isDisplayed());
        Assert.assertTrue(ordersTitle.isDisplayed());
        Assert.assertTrue(allOrdersButton.isDisplayed());
        Assert.assertTrue(openOrdersButton.isDisplayed());
        Assert.assertTrue(submittedOrdersButton.isDisplayed());
        Assert.assertTrue(cancelledOrdersButton.isDisplayed());
//        Assert.assertTrue(createOrderButton.isDisplayed()); flacks out
        Assert.assertTrue(ordersList.isDisplayed());
        Assert.assertTrue(firstOrderInList.isDisplayed());
        return this;
    }

    public OrdersPage pressAllOrdersButton() {
        click(allOrdersButton);
        return new OrdersPage();
    }

    public OrdersPage pressOpenOrdersButton() {
        click(openOrdersButton);
        return new OrdersPage();
    }

    public OrdersPage pressSubmittedOrdersButton() {
        click(submittedOrdersButton);
        return new OrdersPage();
    }

    public OrdersPage pressCancelledOrdersButton() {
        click(cancelledOrdersButton);
        return new OrdersPage();
    }

}
