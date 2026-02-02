package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;

public class LikeUnlikePages extends BasePage{

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Like\"]")
    public WebElement likeButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Content share\"]")
    public WebElement shareButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Share To\"]")
    public WebElement shareButtonVerify;


    public LikeUnlikePages(AppiumDriver driver) {
        super(driver);
    }
    public void tapIfElementNotVisibleClickElement(WebElement element) {
        try {
            if (element.isDisplayed()) {
                System.out.println("Element is visible. No need to tap.");
                click(element);
            } else {
                System.out.println("Element not visible. Performing tap on screen...");
                tapOnScreen();
                click(element);
                System.out.println("Clicked element");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element not found. Performing tap on screen...");
            tapOnScreen();
            click(element);
        } catch (Exception e) {
            System.err.println("Error while checking element visibility: " + e.getMessage());
            tapOnScreen();
            click(element);
        }
    }

    public void clickLikeButton(){
        tapIfElementNotVisibleClickElement(likeButton);
    }

    public void tapOnScreen() {
        try {
            // Get screen size
            Dimension size = driver.manage().window().getSize();

            // Tap slightly above center (middle of video area)
            int x = size.width / 2;
            int y = (int) (size.height * 0.45); // 45% from top

            // Create finger input
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            Sequence tap = new Sequence(finger, 1);

            tap.addAction(finger.createPointerMove(Duration.ZERO,
                    PointerInput.Origin.viewport(), x, y));
            tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            tap.addAction(new Pause(finger, Duration.ofMillis(100))); // tiny hold improves reliability
            tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            // Perform tap
            driver.perform(Collections.singletonList(tap));

            System.out.println("Tapped on screen at (" + x + "," + y + ") to reveal controls.");

        } catch (Exception e) {
            System.err.println("Failed to tap on screen: " + e.getMessage());
        }
    }

    public boolean islikeButtonDisplayed() {
        return isElementDisplayed(likeButton);
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

        public void scrollDownAndClicksLikeButton(int times){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            for (int i = 0; i < times; i++) {
                scrollDown();
                click(likeButton);

                // Explicit wait after click
                wait.until(ExpectedConditions.elementToBeClickable(likeButton));
            }
        }

        public void shareButtonClick(){
            tapIfElementNotVisibleClickElement(shareButton);
        }

        public boolean shareButtonVerify(){
        return isElementDisplayed(shareButtonVerify);
        }
    }





