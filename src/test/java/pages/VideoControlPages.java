package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class VideoControlPages extends BasePage{

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Pause\"]")
    public WebElement playbackPauseIcon;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Play\"]")
    public WebElement playbackPlayIcon;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Mute/Unmute player\"]")
    public WebElement unmuteButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Player settings\"]")
    public WebElement settingButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"REPORT VIDEO\"]")
    public WebElement reportVideo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sexual Content\"]")
    public WebElement reasonToReportVideo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Submit\"]")
    public WebElement submitButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Bullet watermark\"]")
    public WebElement bulletWatermark;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Understood\"]")
    public WebElement UnderstoodButton;



    public VideoControlPages(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void playbackPauseIcon(){
        click(playbackPauseIcon);
    }

    public boolean isPlaybackIconDisplayed(){
        return isElementDisplayed(playbackPauseIcon);
    }

    public boolean isPlaybackPlayIcon(){
        return isElementDisplayed(playbackPlayIcon);
    }


//        public void tapOnVideo(AppiumDriver driver) {
//            Dimension size = driver.manage().window().getSize();
//            int x = size.width / 2;   // center X
//            int y = size.height / 2;  // center Y
//
//            Map<String, Object> params = new HashMap<>();
//            params.put("x", x);
//            params.put("y", y);
//
//            driver.executeScript("mobile: clickGesture", params);
//    }

    public void playbackPlayIcon(){
        click(playbackPlayIcon);
        }

        public boolean isPlaybackAudioMuted(){
        return isElementDisplayed(unmuteButton);
        }

        public void clickUnmuteIcon(){
        click(unmuteButton);
        }

        public boolean isSettingsButtonDisplayed(){
        return isElementDisplayed(settingButton);
        }

        public void settingButton(int maxWaitInSeconds){
            click(settingButton);
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxWaitInSeconds));
//            clickIfPresent(UnderstoodButton);
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



    public boolean isReportVideoDisplayed(){
        return isElementDisplayed(reportVideo);
        }

        public void reportVideo(){
        click(reportVideo);
        }

        public boolean isReportReasonsSeen(){
        return isElementDisplayed(reasonToReportVideo);
        }

        public void reportReasonClick(){
        click(reasonToReportVideo);
        }

        public void submitButtonClick(){
        click(submitButton);
        }

        public boolean isBulletWatermarkDisplayed(){
        return isElementDisplayed(bulletWatermark);
        }

//        public boolean isVideoRunningInBackground(){
//        return isElementDisplayed();
//        }


    public static boolean isVideoPlayingInBackground(AndroidDriver driver, int waitSeconds) {
        try {
            // Locate the top View area (where video is shown)
            WebElement videoArea = driver.findElement(By.xpath("//android.view.View[@content-desc='Close sheet']"));

            // Take first frame screenshot
            File frame1 = videoArea.getScreenshotAs(OutputType.FILE);
            BufferedImage img1 = ImageIO.read(frame1);

            // Wait few seconds
            Thread.sleep(waitSeconds * 1000);

            // Take second frame
            File frame2 = videoArea.getScreenshotAs(OutputType.FILE);
            BufferedImage img2 = ImageIO.read(frame2);

            // Compare frames
            long diff = 0;
            for (int y = 0; y < img1.getHeight(); y++) {
                for (int x = 0; x < img1.getWidth(); x++) {
                    diff += Math.abs(img1.getRGB(x, y) - img2.getRGB(x, y));
                }
            }

            // Threshold — adjust if needed
            return diff > 1000000;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
