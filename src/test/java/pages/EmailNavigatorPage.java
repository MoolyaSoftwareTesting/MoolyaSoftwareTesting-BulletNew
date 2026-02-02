package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailNavigatorPage extends BasePage {

    private AppiumDriver driver;

    public EmailNavigatorPage(AppiumDriver driver) {
        super(driver);
    }

    public String retrieveOtpFromGmail() {
        try {
            // Open Gmail app
            ((AndroidDriver) driver).activateApp("com.google.android.gm");
            Thread.sleep(3000);

            // Click on the first email in the inbox
            WebElement firstEmail = driver.findElement(By.xpath(
                    "//android.view.ViewGroup[@resource-id='com.google.android.gm:id/conversation_list_item']"
            ));
            firstEmail.click();
            Thread.sleep(2000);

            // Get all text elements inside the email body
            List<WebElement> emailTexts = driver.findElements(
                    By.className("android.widget.TextView")
            );

            String otp = null;
            for (WebElement txt : emailTexts) {
                String text = txt.getText();
                if (text != null && text.matches(".*\\b\\d{4,6}\\b.*")) {
                    Matcher matcher = Pattern.compile("\\b\\d{4,6}\\b").matcher(text);
                    if (matcher.find()) {
                        otp = matcher.group();
                        break;
                    }
                }
            }

            if (otp == null) {
                throw new RuntimeException("OTP not found in Gmail email body.");
            }

            System.out.println("OTP from Gmail: " + otp);
            return otp;

        } catch (Exception ex) {
            throw new RuntimeException("Failed to retrieve OTP from Gmail: " + ex.getMessage(), ex);
        }
    }
}

