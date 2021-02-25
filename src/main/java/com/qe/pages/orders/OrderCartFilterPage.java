package com.qe.pages.orders;

import com.qe.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

public class OrderCartFilterPage extends BaseTest {

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Group By\"`]")
    public MobileElement pageHeader;

    @iOSXCUITFindBy(id = "groupBy-0-0")
    public MobileElement noneSelector;

    @iOSXCUITFindBy(id = "groupBy-0-1")
    public MobileElement categoriesSelector;

    @iOSXCUITFindBy(id = "done button")
    public MobileElement doneButton;

    public OrderCartFilterPage checkElementsPresence() {
        Assert.assertTrue(pageHeader.isDisplayed());
        Assert.assertTrue(noneSelector.isDisplayed());
        Assert.assertTrue(categoriesSelector.isDisplayed());
        Assert.assertTrue(doneButton.isDisplayed());
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
