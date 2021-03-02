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
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(closeButton.isDisplayed());
        softAssert.assertTrue(productTitle.isDisplayed());
        softAssert.assertTrue(productCasesHeader.isDisplayed());
        softAssert.assertEquals(productTitle.getText(), expectedTitle);
        softAssert.assertEquals(productCasesTierValues.size(), expectedTiersCases.size());
        if(productCasesTierValues.size() == expectedTiersCases.size()) {
            for (int i = 0; i < productCasesTierValues.size(); i++) {
                softAssert.assertEquals(productCasesTierValues.get(i).getText(), expectedTiersCases.get(i));
            }
        }
        softAssert.assertEquals(productCasesTierPrices.size(), expectedTiersPrices.size());
        if(productCasesTierPrices.size() == expectedTiersPrices.size()) {
            for (int i = 0; i < productCasesTierPrices.size(); i++) {
                softAssert.assertEquals(productCasesTierPrices.get(i).getText(), expectedTiersPrices.get(i));
            }
        }
        softAssert.assertAll();
        return this;
    }

    public SearchCatalogPage pressCloseButtonToReturnToSearchPage() {
        click(closeButton);
        return new SearchCatalogPage();
    }
}
