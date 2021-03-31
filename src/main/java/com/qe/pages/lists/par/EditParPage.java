package com.qe.pages.lists.par;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class EditParPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Back")
    @iOSXCUITFindBy(id = "edit par items back button")
    private MobileElement backButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'editProductListToolbar')]/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar")
    private MobileElement editParPageTitle;

    @AndroidFindBy(id = "productImage")
    private List<MobileElement> productImages;

    @AndroidFindBy(id = "productDescription")
    private List<MobileElement> productTitles;

    @AndroidFindBy(id = "productInfo")
    private List<MobileElement> productDescriptions;

    @AndroidFindBy(id = "priceLabel")
    private List<MobileElement> productCasesPars;

    @AndroidFindBy(id = "addToCartMinus")
    @iOSXCUITFindBy(id = "decrease quantity button")
    private List<MobileElement> productParQuantityMinusButtons;

    @AndroidFindBy(id = "cartItemCount")
    @iOSXCUITFindBy(id = "case quantity text field")
    private List<MobileElement> productParQuantityInputFields;

    @AndroidFindBy(id = "addToCartPlus")
    @iOSXCUITFindBy(id = "increase quantity button")
    private List<MobileElement> productParQuantityPlusButtons;

    public ParPage pressBackButton() {
        click(backButton);
        return new ParPage();
    }

    public EditParPage pressFirstItemsPlusButton() {
        click(productParQuantityPlusButtons.get(0));
        return new EditParPage();
    }

    public EditParPage pressFirstItemsMinusButton() {
        click(productParQuantityMinusButtons.get(0));
        return new EditParPage();
    }

    public EditParPage inputFirstItemsParValue(String inputPar) {
        sendKeys(productParQuantityInputFields.get(0), inputPar, "Input par value " + inputPar);
        if(getPlatform().equalsIgnoreCase("iOS")) {
            getDriver().getKeyboard().sendKeys("\n");
        }
        if(getPlatform().equalsIgnoreCase("Android")) {
            click(productParQuantityInputFields.get(0));
            ((AndroidDriver) getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
        }
        return new EditParPage();
    }

}

