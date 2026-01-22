package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ShowScreenPages extends BasePage {
    public ShowScreenPages(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Explore\"]")
    public WebElement ExploreClick;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Add To Watchlist\"]")
    public WebElement WatchlistClick;

    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]")
    public WebElement ageRestrictionText;

    @AndroidFindBy(xpath = "//android.widget.TextView")
    public List<WebElement> languageLabels;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Episodes\"]")
    public WebElement episodeView;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"START\"]")
    public WebElement startViewText;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Add to watchlist\"]")
    public WebElement watchListButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Like\"]")
    public WebElement likeButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Content share\"]")
    public WebElement shareButton;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.bulletshorts:id/exo_subtitles\"]/android.view.View")
    public WebElement FirstTrailerCell;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.bulletshorts:id/exo_subtitles\"]/android.view.View")
    public WebElement CurrentTrailerCell;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Understood\"]")
    public WebElement UnderstoodButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Mute/Unmute player\"]")
    public WebElement muteUnmuteButtonClick;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Pause\"]")
    public WebElement startNavigation;

    @AndroidFindBy(xpath = "new UiSelector().text(\"Episode 10\")")
    public WebElement episodeNumber10;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"E1\"]")
    public WebElement episodeNumber01;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Episodes\"]")
    public WebElement episodesClick;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Episodes\"]")
    public WebElement episodePopup;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"1 – 10\"]")
    public WebElement isEpisodesDisplayed;


    @AndroidFindBy(xpath = "//Q0.s0/android.view.View/android.view.View/android.view.View/android.view.View[2]")
    public WebElement isBackButtonDisplayed;

    @AndroidFindBy( xpath = "//android.widget.TextView[@text=\"Home\"]")
    public WebElement HomeNavClick;




    public void exploreIconSelect() {
        click(ExploreClick);
    }

    public void addToWatchlistClick() {
        click(WatchlistClick);
    }

    public boolean isExpisodeAndStartButtonDisplayed() {
        return isElementPresent(episodeView) && isElementPresent(startViewText);
    }

    public boolean isWatchlistButtonDisplayed() {
        return isElementDisplayed(watchListButton);
    }

    public boolean isLikeButtonDisplayed() {
        return isElementDisplayed(likeButton);
    }

    public boolean isShareButtonDisplayed() {
        return isElementDisplayed(shareButton);
    }

    public boolean waitForTrailerAutoScroll(int maxWaitInSeconds) {
        // Capture first trailer's internal Appium ID
        String firstId = ((RemoteWebElement) FirstTrailerCell).getId();
        System.out.println("🎬 Initial Trailer elementId: " + firstId);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxWaitInSeconds));
        clickIfPresent(UnderstoodButton);

        try {
            boolean scrolled = wait.until(driver -> {
                String currentId = ((RemoteWebElement) CurrentTrailerCell).getId();
                return !currentId.equals(firstId);  //  Wait until ID changes
            });

            String newId = ((RemoteWebElement) CurrentTrailerCell).getId();
            System.out.println("🎬 Trailer auto-scrolled to new elementId: " + newId);
            return scrolled;

        } catch (TimeoutException e) {
            System.out.println("⏱ No auto-scroll detected within " + maxWaitInSeconds + "s");
            return false;
        }
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

    public void startButtonClick() {
        click(startViewText);
    }

    public boolean muteUnmuteClick() {
        return isElementPresent(muteUnmuteButtonClick);
    }

    public void muteButtonClick() {
        click(muteUnmuteButtonClick);
    }

    public void increaseVolume(int times) throws InterruptedException {

        for (int i = 0; i < times; i++) {
            try {
                Runtime.getRuntime().exec("adb shell input keyevent 24"); // 24 = KEYCODE_VOLUME_UP
            } catch (Exception e) {
                throw new RuntimeException("Failed to press volume up: " + e.getMessage());
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        }
    }

    public void decreaseVolume(int times) throws InterruptedException {
        for (int i = 0; i < times; i++) {
            try {
                Runtime.getRuntime().exec("adb shell input keyevent 25"); // 25 = KEYCODE_VOLUME_DOWN
            } catch (Exception e) {
                throw new RuntimeException("Failed to press volume down: " + e.getMessage());
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        }
    }

    public boolean isStartPageNavigationDisplayed() {
        return isElementDisplayed(startNavigation);
    }


    public boolean isEpisodeOnePlayingFromStaticText() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait until all text elements are visible
            List<WebElement> staticTexts = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath("//android.widget.TextView")
            ));

            // Loop through all text elements and check for match
            for (WebElement textElement : staticTexts) {
                String textValue = textElement.getText();

                if (textValue != null && (textValue.contains("S1") || textValue.contains("E1"))) {
                    System.out.println("Found matching static text: " + textValue);
                    return true;
                }
            }

            System.out.println("No static text found containing 'S1' or 'E1'.");
            return false;
        } catch (Exception e) {
            System.out.println("Exception while verifying episode text: " + e.getMessage());
            return false;
        }
    }

//    public void printAllStaticTexts() {
//        try {
//            // Find all TextView elements (static text in Android)
//            List<WebElement> allTexts = driver.findElements(By.className("android.widget.TextView"));
//            if (allTexts.isEmpty()) {
//                System.out.println(":warning: No static text elements found!");
//            } else {
//                System.out.println(":page_facing_up: Static Text Elements Found: " + allTexts.size());
//                for (WebElement textElement : allTexts) {
//                    String text = textElement.getText().trim();
//                    if (!text.isEmpty()) {
//                        System.out.println(":arrow_right: " + text);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            System.out.println(":x: Failed to fetch static texts: " + e.getMessage());
//        }
//    }

    public void understandClick() {
        clickIfPresent(UnderstoodButton);
    }

    public void clickOnEpisode() {
        click(episodesClick);
    }

    public boolean episodePopupVisible() {
        return isElementDisplayed(episodePopup);
    }

    public boolean episodesAreVisible() {
        return isElementDisplayed(isEpisodesDisplayed);
    }

    public void clickFirstEpisode() {
        click(isEpisodesDisplayed);
    }

    public void runAppInBackgroundFor5Secs() {
        ((InteractsWithApps) driver).runAppInBackground(Duration.ofSeconds(5));
    }

    public boolean isAppCameToForeground() {
        return isElementPresent(episodeView) && isElementPresent(startViewText);
    }


    public void ScrollDownNTimes(int times) {
        for (int i = 0; i < times; i++) {
            scrollDown();
        }
    }

    public void ScrollUpNTimes(int times) {
        for (int i = 0; i < times; i++) {
            scrollUp();
        }

    }
    public void scrollDown() {
        if (!(driver instanceof AndroidDriver)) {
            throw new UnsupportedOperationException("scrollDown() is only supported on Android");
        }

        Dimension size = driver.manage().window().getSize();

        int safeTop = (int) (size.height * 0.15);   // skip status bar & top area
        int safeHeight = (int) (size.height * 0.7); // use only middle 70% for swipe

        driver.executeScript("mobile: swipeGesture", Map.of(
                "left", 0,
                "top", safeTop,
                "width", size.width,
                "height", safeHeight,
                "direction", "up",
                "percent", 0.45
        ));
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void scrollUp() {
        if (!(driver instanceof AndroidDriver)) {
            throw new UnsupportedOperationException("scrollUp() is only supported on Android");
        }

        Dimension size = driver.manage().window().getSize();

        int safeTop = (int) (size.height * 0.15);   // skip status bar & top area
        int safeHeight = (int) (size.height * 0.7); // use only middle 70% for swipe

        driver.executeScript("mobile: swipeGesture", Map.of(
                "left", 0,
                "top", safeTop,
                "width", size.width,
                "height", safeHeight,
                "direction", "down",
                "percent", 0.45
        ));
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isBackButtonPresent(){
        return isElementPresent(isBackButtonDisplayed);
    }

    public void homeNavigation(){
        click(HomeNavClick);
    }




}

