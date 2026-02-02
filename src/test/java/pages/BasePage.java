package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class BasePage {
    protected AppiumDriver driver;
    protected WebDriverWait wait;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(35));
        PageFactory.initElements(
                new AppiumFieldDecorator(driver, Duration.ofSeconds(20)),
                this
        );
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForStaleness(WebElement element) {

        wait.until(ExpectedConditions.stalenessOf(element));
    }

    public void waitForVisibility(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public boolean elementExistOrNot(By element) {
        try {
            if (driver.findElements(element).size() > 0)
                return true;
        } catch (Exception err) {
            return false;
        }
        return false;
    }

    public void clear(By element) {
        WebElement ele = driver.findElement(element);
        waitForVisibility(ele);
        ele.clear();
    }

    public void clear(WebElement element) {
        waitForVisibility(element);
        element.clear();
    }

    public void sendKeys(WebElement element, String txt) {
        waitForVisibility(element);
        clear(element);
        element.sendKeys(txt);
    }

    public void click(By element) {
        waitForVisibility(element);
        driver.findElement(element).click();
    }

    public void click(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    public String getText(WebElement element) {
        waitForVisibility(element);
        return element.getText();
    }

    public String getAttribute(WebElement element, String attribute) {
        waitForVisibility(element);
        return element.getAttribute(attribute);
    }

    public void swipeScreenUp() {
        PointOption pointOptionStart, pointOptionEnd;
        Dimension dims = driver.manage().window().getSize();
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
        pointOptionEnd = PointOption.point(dims.width / 2, (dims.height / 2) - 100);
        try {
            new TouchAction((PerformsTouchActions) driver).press(pointOptionStart).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                    .moveTo(pointOptionEnd).release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }
    }

    public void swipeScreen(Direction dir) {
        final int ANIMATION_TIME = 200;
        final int PRESS_TIME = 200;
        int edgeBorder = 10;
        PointOption pointOptionStart, pointOptionEnd;
        Dimension dims = driver.manage().window().getSize();
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN:
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP:
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT:
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT:
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        try {
            new TouchAction((PerformsTouchActions) driver).press(pointOptionStart)
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME))).moveTo(pointOptionEnd).release()
                    .perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
        }
    }

    public enum Direction {
        UP, DOWN, LEFT, RIGHT;
    }

    public void clickOnDeviceBackButton() {
        driver.navigate().back();
    }

    public void verifyElementWithText(By element) {
        Assert.assertTrue(driver.findElement(element).isDisplayed());
    }

    public boolean isElementDisplayed(By element) {
        try {
            waitForVisibility(element);
        } catch (TimeoutException | NoSuchElementException exception) {
            return false;
        }
        return true;
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            waitForVisibility(element);
        } catch (TimeoutException | NoSuchElementException exception) {
            return false;
        }
        return true;
    }

    public void switchToContext(String contextName) {
//        driver.context(contextName);
    }

    public String generateDate(String dateFormat, int dateDiff) {
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, dateDiff);
        dt = c.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        String date = simpleDateFormat.format(dt);
        return date;
    }

    public String generateTimeInUtc(String timeFormat, int timeDiff) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(timeFormat);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, timeDiff);
        String date = simpleDateFormat.format(cal.getTime());
        return date;
    }

    public boolean isElementPresentWithText(String elementText) {
        return isElementDisplayed(By.xpath("//*[contains(@text,'" + elementText + "')]"));
    }
    public void enterTextOnElement(WebElement element, String value) {

        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(value);
    }
    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }

}
