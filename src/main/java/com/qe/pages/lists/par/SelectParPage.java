package com.qe.pages.lists.par;

import com.qe.BaseTest;
import com.qe.pages.lists.ListPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;

import java.util.List;

public class SelectParPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Back")
    @iOSXCUITFindBy(id = "show par group close button")
    private MobileElement backButton;

    //android Show Par Group
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'parGroupSelectionToolbar')]/android.widget.TextView[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Show Par Group\"`]")
    private MobileElement showParGroupPageTitle;

    @AndroidFindBy(id = "createNewParGroupContainer")
    @iOSXCUITFindBy(id = "show par group - create new par group")
    private MobileElement createNewParGroupButton;

    @AndroidFindBy(id = "parGroupRadio")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText")
    private List<MobileElement> androidParNames;

    @AndroidFindBy(id = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RadioButton")
    @iOSXCUITFindBy(id = "show par group - 0-0")
    private MobileElement selectorForNone;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RadioButton")
    @iOSXCUITFindBy(id = "show par group - 0-1")
    private MobileElement selectorForFirstParGroupInList;

    public ListPage pressBackButton() {
        click(backButton);
        return new ListPage();
    }

    public SelectParPage selectNone() {
        click(selectorForNone);
        return this;
    }

    public SelectParPage selectFirstParGroupInList() {
        click(selectorForFirstParGroupInList);
        return this;
    }

    public CreateParPage pressCreateParGroupButton() {
        click(createNewParGroupButton);
        return new CreateParPage();
    }

    public SelectParPage pressOnParWithName(String expectedParName) {
        utils.log().info("Press on Par with name " + expectedParName + " on Select Par page");
        if(getPlatform().equalsIgnoreCase("iOS")) {
            String locator = "//XCUIElementTypeStaticText[@name='" + expectedParName + "']/..";
            getDriver().findElement(new By.ByXPath(locator)).click();
        }
        if(getPlatform().equalsIgnoreCase("Android")) {
            for (MobileElement androidParName : androidParNames) {
                if (androidParName.getText().equalsIgnoreCase(expectedParName)) {
                    click(androidParName);
                    break;
                }
            }
        }
        return new SelectParPage();
    }
}
