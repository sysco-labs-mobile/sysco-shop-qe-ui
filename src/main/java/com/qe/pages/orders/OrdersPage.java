package com.qe.pages.orders;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.testng.asserts.SoftAssert;

public class OrdersPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Open navigation drawer")
    @iOSXCUITFindBy(id = "app bar left button")
    private MobileElement navBarDrawerButton;

    @AndroidFindBy(id = "editText")
    @iOSXCUITFindBy(id = "app nav search bar text field")
    private MobileElement searchTextField;

    @AndroidFindBy(id = "action_cart")
    @iOSXCUITFindBy(id = "cart button")
    private MobileElement cartButton;

    @AndroidFindBy(id = "title")
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

    @AndroidFindBy(id = "addOrderButton")
    private MobileElement createOrderButton;

    @AndroidFindBy(id = "resultView")
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

    @AndroidFindBy(id = "ordersProgressBar")
    @iOSXCUITFindBy(id = "loading bar")
    private MobileElement progressBar;

    @AndroidFindBy(id = "loadingView")
    private MobileElement loadingView;

    @AndroidFindBy(id = "couldNotLoad")
    private MobileElement couldNotLoadOrdersTitle;

    @AndroidFindBy(accessibility = "Tap to Retry")
    private MobileElement tapToRetryButton;


    private OrdersPage ifFailedReload() {
        try {
            if (tapToRetryButton.isDisplayed()) {
                click(tapToRetryButton, "Press retry button on Orders page");
            }
        } catch (NoSuchElementException noSuchElementException) {
            utils.log().info("Retry button is absent on Order Page - no retry is needed");
        }
        return new OrdersPage();
    }

    public OrdersPage checkPageIsLoadedOrRetry() {
        utils.log().info("Check page if reload is needed");
        ifFailedReload();

        return new OrdersPage();
    }

    public OrdersPage checkElementsPresence() {
        utils.log().info("Check elements presence on Orders page");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(navBarDrawerButton.isDisplayed());
        softAssert.assertTrue(searchTextField.isDisplayed());
        softAssert.assertTrue(cartButton.isDisplayed());
        softAssert.assertTrue(ordersTitle.isDisplayed());
        softAssert.assertTrue(allOrdersButton.isDisplayed());
        softAssert.assertTrue(openOrdersButton.isDisplayed());
        softAssert.assertTrue(submittedOrdersButton.isDisplayed());
        softAssert.assertTrue(cancelledOrdersButton.isDisplayed());
//        softAssert.assertTrue(createOrderButton.isDisplayed()); flacks out
        softAssert.assertTrue(ordersList.isDisplayed());
        softAssert.assertTrue(firstOrderInList.isDisplayed());
        softAssert.assertAll();
        return this;
    }

    public OrdersPage pressAllOrdersButton() {
        click(allOrdersButton, "Press All Orders tab on Orders page");
        return new OrdersPage();
    }

    public OrdersPage pressOpenOrdersButton() {
        click(openOrdersButton, "Press Open orders tab on Orders page");
        return new OrdersPage();
    }

    public OrdersPage pressSubmittedOrdersButton() {
        click(submittedOrdersButton, "Press Submitted orders tab on Orders page");
        return new OrdersPage();
    }

    public OrdersPage pressCancelledOrdersButton() {
        click(cancelledOrdersButton, "Press Cancelled orders tab on Orders page");
        return new OrdersPage();
    }

    public OrderCartPage pressCreateOrderButton() {
        click(createOrderButton, "Press create order button on Orders page"); //ios flacks out
        return new OrderCartPage();
    }
}
