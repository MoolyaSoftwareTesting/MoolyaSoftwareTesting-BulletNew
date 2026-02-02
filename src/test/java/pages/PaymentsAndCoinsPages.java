package pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Collections;

public class PaymentsAndCoinsPages extends BasePage{

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Complete tasks and earn coins\"]")
    public WebElement completeTasksAndEarnCoins;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Bullet coin image\"])[1]")
    public WebElement coinsPresent;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Your coin transactions\"]")
    public WebElement coinsTransaction;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"150\"]")
    public WebElement coinsPresent1;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"300\"]")
    public WebElement coinsPresent2;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"389\"]")
    public WebElement coinsPresent3;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"600 + 60\"]")
    public WebElement coinsPresent4;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"750 + 113\"]")
    public WebElement coinsPresent5;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"1060 + 265\"]")
    public WebElement coinsPresent6;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"1515 + 530\"]")
    public WebElement coinsPresent7;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"2999 + 1500\"]")
    public WebElement coinsPresent8;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"5999 + 3600\"]")
    public WebElement coinsPresent9;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"8888 + 6666\"]")
    public WebElement coinsPresent10;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Coins')]")
    public WebElement coinVerification;




    public PaymentsAndCoinsPages(AppiumDriver driver) {
        super(driver);
    }

    public boolean isCompleteTasksAndEarnCoinsDisplayed(){
        return isElementDisplayed(completeTasksAndEarnCoins);
    }

    public boolean isCoinsPresentDisplayed(){
        return isElementDisplayed(coinsPresent);
    }

    public boolean isCoinTransactionDisplayed(){
        return isElementDisplayed(coinsTransaction);
    }

    public boolean isCoins1Displayed(){
        return isElementDisplayed(coinsPresent1);
    }

    public boolean isCoins2Displayed(){
        return isElementDisplayed(coinsPresent2);
    }

    public boolean isCoins3Displayed(){
        return isElementDisplayed(coinsPresent3);
    }

    public boolean isCoins4Displayed(){
        return isElementDisplayed(coinsPresent4);
    }

    public void click600Coins(){
        click(coinsPresent4);
    }

    public boolean isCoins5Displayed(){
        return isElementDisplayed(coinsPresent5);
    }

    public void click750Coins(){
        click(coinsPresent5);
    }

    public boolean isCoin6Displayed(){
        return isElementDisplayed(coinsPresent6);
    }

    public void click1060Coins(){
        click(coinsPresent6);
    }

    public boolean isCoin7Displayed(){
        return  isElementDisplayed(coinsPresent7);
    }

    public void click1515Coins(){
        click(coinsPresent7);
    }

    public boolean isCoin8Displayed(){
        return isElementDisplayed(coinsPresent8);
    }

    public void click2999Coins(){
        click(coinsPresent8);
    }

    public boolean isCoin9Displayed(){
        return isElementDisplayed(coinsPresent9);
    }

    public void click5999Coins(){
        click(coinsPresent9);
    }

    public boolean isCoin10Displayed(){
        scrollDown(driver);
        return isElementDisplayed(coinsPresent10);
    }

    public void click8888Coins(){
        scrollDown(driver);
        click(coinsPresent10);
    }
    public void scrollDown(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.3);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    public boolean isCorrectPackageDisplayed(){
        return isElementDisplayed(coinVerification);
    }

    public void click300Coins(){
        click(coinsPresent2);
    }

    public void click389Coins(){
        click(coinsPresent3);
    }
}
