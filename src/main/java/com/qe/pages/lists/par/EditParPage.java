package com.qe.pages.lists.par;

import com.qe.BaseTest;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class EditParPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Back")
    private MobileElement backButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private MobileElement editParPageTitle;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/productImage")
    private List<MobileElement> productImages;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/productDescription")
    private List<MobileElement> productTitles;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/productInfo")
    private List<MobileElement> productDescriptions;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/priceLabel")
    private List<MobileElement> productCasesPars;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/addToCartMinus")
    private List<MobileElement> productParQuantityMinusButtons;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/cartItemCount")
    private List<MobileElement> productParQuantityInputFields;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/addToCartPlus")
    private List<MobileElement> productParQuantityPlusButtons;

    public ParPage pressBackButton() {
        click(backButton);
        return new ParPage();
    }

    public EditParPage pressFirstPlusButton() {
        click(productParQuantityPlusButtons.get(0));
        return new EditParPage();
    }

    public EditParPage pressFirstMinusButton() {
        click(productParQuantityMinusButtons.get(0));
        return new EditParPage();
    }

    public EditParPage inputParValue(String inputPar) {
        sendKeys(productParQuantityInputFields.get(0), inputPar, "Input par value " + inputPar);
        return new EditParPage();
    }

}
