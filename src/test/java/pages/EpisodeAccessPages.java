package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EpisodeAccessPages extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Low Balance\"]")
    public WebElement unlockVideoPopup;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Refill wallet and unlock\"]")
    public WebElement refillWalletButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'WATCH AD TO UNLOCK EPISODES')]")
    public WebElement watchAdButton;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout//android.view.View[@content-desc=\"Locked\"]")
    public WebElement lockedEpisodeClick;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"REFILL WALLET & WATCH\"]")
    public WebElement refillCoinScreenPopup;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"150\"]")
    public WebElement firstPaymentSelect;

    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@resource-id=\"com.android.vending:id/0_resource_name_obfuscated\"])[4]/android.widget.LinearLayout[1]")
    public WebElement paymentGateway;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.android.vending:id/button_group\"]")
    public WebElement buyCoinsButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Bullet watermark\"]")
    public WebElement bulletIcon;

    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@resource-id=\"com.android.vending:id/0_resource_name_obfuscated\"])[10]/android.widget.ImageView")
    public WebElement selectPaymentContrast;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Test card, always approves\"]")
    public WebElement testCardAlwaysApprove;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Episode Unlocked\"])[1]")
    public WebElement isEpisodeUnlocked;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Test card, always declines\"]")
    public WebElement testCardAlwaysDecline;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Error\"]")
    public WebElement paymentDeclineError;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.android.vending:id/button_group\"]")
    public WebElement gotItButtonClick;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Play\"]")
    public WebElement pauseButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Mute/Unmute Ad\"]")
    public WebElement adMuteorUnmute;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Pause\"]")
    public WebElement playButton;


    public EpisodeAccessPages(AppiumDriver driver) {
        super(driver);
    }

    public boolean isUnlockVideoPopupDisplayed() {
        return isElementDisplayed(unlockVideoPopup);
    }

    public boolean isRefillWalletUnlockButtonDisplayed() {
        return isElementDisplayed(refillWalletButton);
    }

    public boolean isWatchAddButtonDisplayed() {
        return isElementDisplayed(watchAdButton);
    }

//    public void lockedEpisode() {
//        click(lockedEpisodeClick);
//    }

    public void lockedEpisode(){
        // XPaths
        String tab1XPath = "//android.widget.TextView[@text=\"1 – 10\"]";  // replace with your Tab 1 XPath
        String tab2XPath = "//android.widget.TextView[@text=\"11 – 20\"]";  // replace with your Tab 2 XPath
        String lockXPath = "//android.widget.FrameLayout//android.view.View[@content-desc=\"Locked\"]";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

// --- Step 1: Switch to Tab 1 ---
        driver.findElement(By.xpath(tab1XPath)).click();

// --- Step 2: Check for lock in Tab 1 ---
        List<WebElement> locksTab1 = driver.findElements(By.xpath(lockXPath));
        if (!locksTab1.isEmpty()) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lockXPath))).click();
            System.out.println("Clicked lock in Tab 1");
        } else {
            // --- Step 3: Switch to Tab 2 ---
            driver.findElement(By.xpath(tab2XPath)).click();
            System.out.println("Switched to Tab 2");

            // --- Step 4: Check for lock in Tab 2 ---
            List<WebElement> locksTab2 = driver.findElements(By.xpath(lockXPath));
            if (!locksTab2.isEmpty()) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lockXPath))).click();
                System.out.println("Clicked lock in Tab 2");
            } else {
                System.out.println("No lock found in either tab");
            }
        }
    }

    public void clickRefillWallet() {
        click(refillWalletButton);
    }

    public boolean isRefillCoinScreenDisplayed() {
        return isElementDisplayed(refillCoinScreenPopup);
    }

    public void clickOnCoins() {
        click(firstPaymentSelect);
    }

    public boolean isPaymentGatewayDisplayed() {
        return isElementDisplayed(paymentGateway);
    }

    public void buyCoinsButton() {
        click(buyCoinsButton);
    }

    public void clickOnBulletIcon() {
        click(bulletIcon);
    }

    public void paymentTestCardSelect() {
        click(selectPaymentContrast);
    }

    public void testCardAlwaysApprove() {
        click(testCardAlwaysApprove);

    }

    public void coinsTransactionShouldBeDeductedForEpisodeUnlocked() {
        // Check if episode is unlocked
        boolean episodeUnlocked = isElementDisplayed(isEpisodeUnlocked);  // Replace with your locator

        if (episodeUnlocked) {
            System.out.println("Coin is deducted for unlocked episode with purchased package");
            // Add verification code for coin deduction here
        } else {
            System.out.println("Coin is NOT deducted - either episode locked or package not purchased");
        }
    }

    public void testCardAlwaysDecline() {
        click(testCardAlwaysDecline);
    }

    public boolean paymentDeclineError() {
        return isElementDisplayed(paymentDeclineError);
    }

    public void paymentFailedErrorGotItButtonClick() {
        click(gotItButtonClick);
    }

    public void tapOutsidePopup() throws InterruptedException {
        // Get screen size
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int y = (int) (size.height * 0.10);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(tap));
        System.out.println("Tapped outside popup to close it.");

        synchronized (driver) {
            driver.wait(5000); // works now
        }
    }

    public void selectTestCard(String status) {
        if (status.equalsIgnoreCase("Success")) {

            By successButton = By.xpath("//android.widget.TextView[@text='Test card, always approves']");

            try {
                driver.findElement(successButton).click();
            } catch (StaleElementReferenceException e) {
                // Re-locate and try again
                driver.findElement(successButton).click();
            }

        } else if (status.equalsIgnoreCase("Decline")) {
            By declineButton = By.xpath("//android.widget.TextView[@text='Test card, always declines']");

            try {

                driver.findElement(declineButton).click();
            } catch (StaleElementReferenceException e) {
                // Re-locate and try again
                driver.findElement(declineButton).click();
            }
        }
    }

    public boolean isPauseButtonVisible() throws InterruptedException {
        tapOutsidePopup();
        return isElementDisplayed(pauseButton);
    }

    public void clickOnWatchAdButton(){
        click(watchAdButton);
    }

    public boolean isAdDisplayed(){
        return isElementDisplayed(adMuteorUnmute);
    }

    public boolean isPlayButtonVisible() throws InterruptedException {
//        return (playButton).isDisplayed();
        tapIfElementNotVisibleClickElement(playButton);
        return false;
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

    private void tapOnScreen() {
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
}
