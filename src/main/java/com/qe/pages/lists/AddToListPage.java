package com.qe.pages.lists;

import com.qe.BaseTest;
import com.qe.pages.search.SearchCatalogPage;
import com.qe.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddToListPage  extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility = "Back")
    @iOSXCUITFindBy(id = "add to lists close button")
    private MobileElement closeButton;

    //Android Add to List
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Add to another list\"`]")
    private MobileElement addToAnotherListTitle;

    //android save button
    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/addProductToListDone")
    @iOSXCUITFindBy(id = "add to lists save button")
    private MobileElement doneButton;

    @AndroidFindBy(id = "com.syscocorp.mss.enterprise.dev:id/createNewProductListContainer")
    @iOSXCUITFindBy(id = "Create New List")
    private MobileElement createNewListButton;

    @iOSXCUITFindBy(id = "checkbox list")
    private MobileElement checkboxList;

    @iOSXCUITFindBy(id = "checkbox-0-0")
    private MobileElement list1;

    @iOSXCUITFindBy(id = "checkbox-0-1")
    private MobileElement list2;

    @iOSXCUITFindBy(id = "checkbox-0-6")
    private MobileElement list7;


    //android this contains par name
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.CheckBox")
    @iOSXCUITFindBy(id = "**/XCUIElementTypeButton[`label == \"squareUncheckedEnabled\"`][1]")
    private MobileElement checkbox1;

    @iOSXCUITFindBy(id ="Admin Tools Bulk List Test 1")
    private MobileElement list1Name;

    @iOSXCUITFindBy(id = "**/XCUIElementTypeButton[`label == \"squareUncheckedEnabled\"`][2]")
    private MobileElement checkbox2;

    @iOSXCUITFindBy(id ="Admin Tools Bulk List Test 7")
    private MobileElement list2Name;

    @iOSXCUITFindBy(id = "checkbox-0-2")
    private MobileElement list3;

    @iOSXCUITFindBy(id = "**/XCUIElementTypeButton[`label == \"squareUncheckedEnabled\"`][3]")
    private MobileElement checkbox3;

    @iOSXCUITFindBy(id ="custom test list admin tools")
    private MobileElement list3Name;

    @iOSXCUITFindBy(id = "checkbox-0-3")
    private MobileElement list4OrCreateList;

    public ListPage pressCloseButtonToReturnToList() {
        click(closeButton);
        return new ListPage();
    }
    public AddToListPage pressOnFirstListCheckbox() {
        click(checkbox1);
        return new AddToListPage();
    }

    public SearchCatalogPage pressSaveDoneButtonToReturnToSearch() {
        click(doneButton);
        return new SearchCatalogPage();
    }

    public ListSettingsPage pressCreateNewListButton() {
        click(createNewListButton);
        return new ListSettingsPage();
    }

    public AddToListPage pressAddToList(String listName) {
        if(getPlatform().equalsIgnoreCase("iOS")) {
            String locator = "//XCUIElementTypeStaticText[@name='" + listName + "']/..";
            WebElement listButton = getDriver().findElement(new By.ByXPath(locator));
            waitForVisibility(listButton, "List button with name " + listName);
            listButton.click();
        }
        return new AddToListPage();
    }
}
