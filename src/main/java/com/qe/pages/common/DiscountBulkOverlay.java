package com.qe.pages.common;

import com.qe.BaseTest;
import com.qe.pages.search.SearchCatalogPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class DiscountBulkOverlay extends BaseTest {
    TestUtils utils = new TestUtils();

    @iOSXCUITFindBy(id = "tooltip close")
    private MobileElement closeButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"tooltip close\"]/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
    private MobileElement productTitle;

    @iOSXCUITFindBy(id = "Cases")
//    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Cases\"`]")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Cases\"]")
    private MobileElement productCasesHeader;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Cases\"]/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText")
    private List<MobileElement> productCasesTierValues;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Cases\"]/following-sibling::XCUIElementTypeOther[2]/XCUIElementTypeStaticText")
    private List<MobileElement> productCasesTierPrices;

    public DiscountBulkOverlay checkElementsPresenceForCase(String expectedTitle, List<String> expectedTiersCases, List<String> expectedTiersPrices) {
        utils.log().info("Check elements presence on Discount Bulk Overlay modal");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(closeButton.isDisplayed(), "closeButton");
        softAssert.assertTrue(productTitle.isDisplayed(), "productTitle");
        softAssert.assertTrue(productCasesHeader.isDisplayed(), "productCasesHeader");
        softAssert.assertEquals(productTitle.getText(), expectedTitle, "productTitle equals " + expectedTitle);
        softAssert.assertEquals(productCasesTierValues.size(), expectedTiersCases.size(), "productCasesTierValues.size() equals expectedTiersCases.size()");
        if(productCasesTierValues.size() == expectedTiersCases.size()) {
            for (int i = 0; i < productCasesTierValues.size(); i++) {
                softAssert.assertEquals(productCasesTierValues.get(i).getText(), expectedTiersCases.get(i));
            }
        }
        softAssert.assertEquals(productCasesTierPrices.size(), expectedTiersPrices.size(), "productCasesTierPrices.size() equals expectedTiersPrices.size()");
        if(productCasesTierPrices.size() == expectedTiersPrices.size()) {
            for (int i = 0; i < productCasesTierPrices.size(); i++) {
                softAssert.assertEquals(productCasesTierPrices.get(i).getText(), expectedTiersPrices.get(i));
            }
        }
        softAssert.assertAll();
        return this;
    }

    public SearchCatalogPage pressCloseButtonToReturnToSearchPage() {
        click(closeButton, "Press close button on Discount Bulk Overlay");
        return new SearchCatalogPage();
    }
}
