package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.remote.RemoteWebElement;

import javax.xml.xpath.XPath;
import java.security.PublicKey;
import java.time.Duration;
import java.util.*;

public class HomeScreenPages extends BasePage {
    @AndroidFindBy( xpath = "//android.widget.TextView[@text=\"Home\"]")
    public WebElement HomeNavClick;
    @AndroidFindBy( xpath = "//android.widget.ImageView[@content-desc=\"App logo\"]")
    public WebElement SFDBannerDisplay;
    @AndroidFindBy( xpath = "//android.view.View[@content-desc=\"Dear Didimoni poster\"]")
    public WebElement SFDBannerClick;
    @AndroidFindBy( xpath = "//android.widget.FrameLayout[@resource-id=\"com.bulletshorts:id/exo_subtitles\"]/android.view.View")
    public WebElement relatedEpisodeVerify;
    @AndroidFindBy( xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[1]")
    public WebElement horizontalRail;
    @AndroidFindBy( xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[1]")
    public WebElement getBanner;
    @AndroidFindBy( xpath = "//android.widget.TextView[@text=\"Explore\"]")
    public WebElement exploreClick;
    @AndroidFindBy (xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[8]")
    public WebElement episodesListButton;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"My List\"]")
    public WebElement myListClick;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Wallet\"]")
    public WebElement walletIconClick;
    @AndroidFindBy (xpath = "//android.widget.ImageView[@content-desc=\"App logo\"]")
    public WebElement bulletImageDisplay;
    @AndroidFindBy (xpath = "//android.view.View[@content-desc=\"Search\"]")
    public WebElement searchIconHomePage;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"SEARCH\"]")
    public WebElement searchTextView;
    @AndroidFindBy (xpath = "//android.view.View[@content-desc=\"Cancel\"]")
    public WebElement searchCancelButton;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Profile\"]")
    public WebElement profileIconHomePage;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"PROFILE\"]")
    public WebElement profileTextView;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Episodes\"]")
    public WebElement SFDBannerVerify;
    @AndroidFindBy (xpath = "//android.view.View[@content-desc=\"Back\"]")
    public WebElement backIconClick;
    @AndroidFindBy (xpath = "//android.view.View[@content-desc=\"Close sheet\"]")
    public WebElement closeSheet;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Close\"]")
    public  WebElement CloseAddButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Explore Unlimited Shows\"]")
    public WebElement subscriptionCancel;







    public HomeScreenPages(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    public boolean isElementPresent(WebElement locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            wait.until((ExpectedConditions.visibilityOf(locator)));
//            return wait.until(ExpectedConditions.presenceOfElementLocated(locator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void homeNavigatorClick() {
        Assert.assertTrue(HomeNavClick.isDisplayed());
        click(HomeNavClick);
    }
    public boolean isHomeNavButtonVisible(){
        return isElementPresent(HomeNavClick);
    }
    public void clickIfPresent(WebElement locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));
            el.click();

            System.out.println("clickIfPresent: ");
        } catch (Exception e) {
            System.out.println("clickIfPresent: ");
        }
    }
    public void CloseAddIfPresent(){
        clickIfPresent(CloseAddButton);
    }

    public void CloseSubscriptionRecommendation(){
        clickIfPresent(subscriptionCancel);
    }


    public void screenSwipe() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO,
                PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.RIGHT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), endY, startX));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(swipe));
    }

    public void bannerSwipe() {
        WebElement banner = driver.findElement(By.xpath("//Q0.s0/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[1]"));


        int startX = banner.getRect().getX() + (int) (banner.getSize().width * 0.8);
        int endX = banner.getRect().getX() + (int) (banner.getSize().width * 0.2);
        int y = banner.getRect().getY() + banner.getSize().height / 2;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(2000), PointerInput.Origin.viewport(), endX, y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));


        driver.perform(Arrays.asList(swipe));
    }

    public boolean isSFDBannerDisplay() {

        return isElementPresent(SFDBannerDisplay);
    }

    public boolean isSFDBannerClick(){
        return isElementPresent(SFDBannerClick);
    }

    public void SFDBannerClick() {
        click(SFDBannerClick);
    }

    public boolean isrelatedSeriesDisplayed() {

        return isElementPresent(relatedEpisodeVerify);
    }



    public void swipeHorizontal(int startXPercent, int endXPercent, int yPercent) {
            int screenWidth = driver.manage().window().getSize().width;
            int screenHeight = driver.manage().window().getSize().height;

            int startX = screenWidth * startXPercent;
            int endX = screenWidth * endXPercent;
            int y = screenHeight * yPercent;

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);

            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX, y));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Arrays.asList(swipe));
        }

    // Scroll rail to end and back
    public void scrollRailFrontAndBack() {
        // Scroll Right till end (left → right)
        for (int i = 0; i < 3; i++) {   // Adjust iterations depending on rail length
            swipeHorizontal(1, 3, 1);
        }

        // Scroll Left back to start (right → left)
        for (int i = 0; i < 3; i++) {
            swipeHorizontal(1, 3, 1);
        }
    }

    public void exploreClick(){
        click(exploreClick);
    }

    public boolean isExploreScreenDisplayed() {
        return isElementPresent(episodesListButton);
    }

    public void myListClick(){
        click(myListClick);
    }

    public void walletIconClick(){
        click(walletIconClick);
    }

    public boolean isWalletIconClickDisplayed(){
        return isElementPresent(bulletImageDisplay);
    }

    public void searchButtonClick(){
        click(searchIconHomePage);
    }

    public boolean isSeachIconClickDisplayed(){
        return isElementPresent(searchTextView);
    }

    public void searchCancelButtonClick(){
        click(searchCancelButton);
    }

    public void profileIconClick(){
        click(profileIconHomePage);
    }

    public boolean IsProfileIconClickDisplayed(){
        return isElementPresent(profileTextView);
    }

    public boolean isShowDisplayedAfterClickOnSDFBanner(){
        return isElementPresent(SFDBannerVerify);
    }

    public void backIconClick(){
        click(backIconClick);
    }

    public void closeSheet(){
        click(closeSheet);
    }



}







