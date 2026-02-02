package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchPages extends BasePage{
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Explore...\"]")
    public WebElement searchBar;

    @AndroidFindBy(xpath = "//android.widget.EditText/android.widget.Button")
    public WebElement searchIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Last Searched\"]")
    public WebElement firstContent;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    public WebElement searchBar2;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Amma Hendathi Drama poster\"]")
    public WebElement firstContentSelect;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Bullet watermark\"]")
    public WebElement bulletWaterMark;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Khara Aaropi Kon?\"]")
    public WebElement seriesListed;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Cancel\"]")
    public WebElement cancelIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Home\"]")
    public WebElement homeNavigationIcon;


    public SearchPages(AppiumDriver driver) {
        super(driver);

    }

    public boolean isSearchBarDisplayed(){
        return isElementDisplayed(searchBar);
    }

    public void searchBarClick(){
        click(searchBar);
    }

    public void searchEpisode(String Content){
//        enterTextOnElement(searchBar2, Content);
        sendKeys(searchBar2, Content);
        click(searchIcon);

    }

    public boolean isFirstContentDisplayed(String content){
        return isElementDisplayed(firstContent);
    }

    public void firstContentSelect(){
        click(firstContentSelect);
    }

    public boolean isWaterMarkDisplayed(String content){
        return isElementDisplayed(bulletWaterMark);
    }

    public boolean isSeriesListed(){
        return isElementDisplayed(seriesListed);
    }

    public boolean isCancelIconDisplayed(){
        return isElementDisplayed(cancelIcon);
    }

    public void clickCancelIcon(){
        click(cancelIcon);
    }

    public boolean isHomeScreenDisplayed(){
        return isElementDisplayed(homeNavigationIcon);
    }

    public boolean isKeyboardVisible() {
        try {
            return ((AndroidDriver)driver).isKeyboardShown();
        } catch (Exception e) {
            return false;
        }
    }
}
