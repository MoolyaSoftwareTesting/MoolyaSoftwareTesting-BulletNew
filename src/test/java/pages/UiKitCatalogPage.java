package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class UiKitCatalogPage extends BasePage {

    @iOSXCUITFindBy(id = "Alert views")
    private WebElement alertViewsMenu;

    @iOSXCUITFindBy(id = "Okay / Cancel")
    private WebElement okCancelOption;

    @iOSXCUITFindBy(id = "Text Entry")
    private WebElement textEntry;

    @iOSXCUITFindBy(id = "Cancel")
    private WebElement cancelTextEntry;

    @iOSXCUITFindBy(id = "OK")
    private WebElement okTextEntry;

    @iOSXCUITFindBy(id = "Search")
    private WebElement searchMenu;

    @iOSXCUITFindBy(id = "Default")
    private WebElement defaultSearch;

    @iOSXCUITFindBy(id = "Custom")
    private WebElement customSearch;

    @iOSXCUITFindBy(id = "Scope One")
    private WebElement scopeOneDefault;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Custom Search Bar\"]")
    private WebElement customSearchPage;

    public UiKitCatalogPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickOnAlertViews() {
        driver.findElement(AppiumBy.name("Alert Views")).click();
    }

    public void clickOnTextEntry() {
        click(textEntry);
    }

    public boolean isPopUpDisplayed() {
        return cancelTextEntry.isDisplayed();
    }

    public void cancelTextEntry() {
        click(cancelTextEntry);
    }

    public void okTextEntry() {
        click(okTextEntry);
    }

    public void clickOnSearchOption() {
        click(searchMenu);
    }

    public void clickOnDefaultSearch() {
        click(defaultSearch);
    }

    public boolean isDefaultPageDisplayed() {
        return scopeOneDefault.isDisplayed();
    }

    public void clickOnSearchToGoBack() {
        click(searchMenu);
    }

    public void clickOnCustomSearch() {
        click(customSearch);
    }

    public boolean isCustomPageDisplayed() {
        return customSearchPage.isDisplayed();
    }

}
