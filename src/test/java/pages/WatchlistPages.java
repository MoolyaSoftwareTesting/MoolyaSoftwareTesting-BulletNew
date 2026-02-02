package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WatchlistPages extends BasePage{

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"My List\"]")
    public WebElement myListClick;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Add to watchlist\"]")
    public WebElement watchlistClick;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Edit my watchlist\"]")
    public WebElement editWatchlistClick;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Remove from watchlist\"]")
    public WebElement deleteFromWatchlist;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Save\"]")
    public WebElement afterDeleteSave;




    public WatchlistPages(AppiumDriver driver) {
        super(driver);
    }
    public void myListClick(){
        click(myListClick);
    }

    public int getWatchlistCount() {
        try {
            // Adjust the xpath according to actual Android UI text
            WebElement watchlistElement = driver.findElement(By.xpath(
                    "//android.widget.TextView[contains(@text,'titles have been added to')]")
            );

            String text = watchlistElement.getAttribute("text");
            // Example: "3 titles have been added to"
            String numberPart = text.replaceAll("(\\d+).*", "$1");

            return Integer.parseInt(numberPart);

        } catch (NoSuchElementException e) {
            return 0; // empty case
        }
    }

    public void watchlistClick(){
        click(watchlistClick);
    }

    public void clickEditWatchlist(){
        click(editWatchlistClick);
    }

    public void clickDeleteShowWatchlist(){
        click(deleteFromWatchlist);
    }

    public void afterDeleteSaveWatchlist(){
        click(afterDeleteSave);
    }
}
