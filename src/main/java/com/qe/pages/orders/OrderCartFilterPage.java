package com.qe.pages.orders;

import com.qe.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

public class OrderCartFilterPage extends BaseTest {

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Group By\"`]")
    public MobileElement pageHeader;

    @iOSXCUITFindBy(id = "groupBy-0-0")
    @AndroidFindBy(id = "groupByNone")
    public MobileElement noneSelector;

    @iOSXCUITFindBy(id = "groupBy-0-1")
    @AndroidFindBy(id = "groupByCategories")
    public MobileElement categoriesSelector;

    @iOSXCUITFindBy(id = "done button")
    @AndroidFindBy(id = "doneButton")
    public MobileElement doneButton;

    public OrderCartFilterPage checkElementsPresence() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(pageHeader.isDisplayed());
        softAssert.assertTrue(noneSelector.isDisplayed());
        softAssert.assertTrue(categoriesSelector.isDisplayed());
        softAssert.assertTrue(doneButton.isDisplayed());
        softAssert.assertAll();
        return this;
    }

    public OrderCartPage pressDoneButton() {
        click(doneButton);
        return new OrderCartPage();
    }

    public OrderCartFilterPage selectNoneSelector() {
        click(noneSelector);
        return new OrderCartFilterPage();
    }

    public OrderCartFilterPage pressCategoriesSelector() {
        click(categoriesSelector);
        return new OrderCartFilterPage();
    }
}
