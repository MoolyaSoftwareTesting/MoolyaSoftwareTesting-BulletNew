package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LanguagePreference extends BasePage{
    @AndroidFindBy( xpath = "//android.widget.TextView[@text=\"Hindi\"]")
    private WebElement HindiLanguageSelect;
    @AndroidFindBy( xpath = "//android.widget.TextView[@text=\"Kannada\"]")
    private WebElement KannadaSelect;
    @AndroidFindBy( xpath = "//android.widget.TextView[@text=\"Tamil\"]")
    private WebElement TamilSelect;
    @AndroidFindBy( xpath = "//android.widget.TextView[@text=\"Telugu\"]")
    private WebElement TeluguSelect;
    @AndroidFindBy( xpath = "//android.widget.TextView[@text=\"Malayalam\"]")
    private WebElement MalayalamSelect;
    @AndroidFindBy( xpath = "//android.widget.TextView[@text=\"Marathi\"]")
    private WebElement MarathiSelect;
    @AndroidFindBy( xpath = "//android.widget.TextView[@text=\"Bengali\"]")
    private WebElement BengaliSelect;
    @AndroidFindBy( xpath = "//android.widget.TextView[@text=\"Tap to add preferences\"]")
    private WebElement GetStarted;
    @AndroidFindBy( xpath = "//android.widget.ImageView[@content-desc=\"Close\"]")
    private WebElement closeAddBanner;


    public LanguagePreference(AppiumDriver driver) {
        super(driver);
    }

    public void languageSelectforNewUsers(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated((By) closeAddBanner));
            element.click();
        } catch (Exception e) {
            System.out.println("Element not found, skipping click");
        }
        click(HindiLanguageSelect);
        click(KannadaSelect);
        click(TamilSelect);


    }

    public void getStartedClick(){
        click(GetStarted);
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
        clickIfPresent(closeAddBanner);
    }
}
