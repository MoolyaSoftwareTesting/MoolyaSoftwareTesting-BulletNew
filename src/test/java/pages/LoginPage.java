package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginPage extends BasePage {
    @AndroidFindBy( xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View")
    public WebElement arrowTick;
    @AndroidFindBy(xpath = "//android.widget.EditText")
    public WebElement mobileNum;
    @AndroidFindBy (xpath = "//android.view.View[@content-desc=\"Submit phone number\"]")
    public WebElement nextArrow;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Enter OTP\"]")
    public WebElement otp;
    @AndroidFindBy (xpath = "//android.widget.Button[@resource-id=\"com.google.android.gms:id/positive_button\"]")
    public WebElement otpAllowButton;
    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View")
    public WebElement HindiSelect;
    @AndroidFindBy (xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View")
    public WebElement KannadaSelect;
    @AndroidFindBy (xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[3]/android.view.View")
    public WebElement TamilSelect;
    @AndroidFindBy (xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[4]/android.view.View")
    public WebElement TeluguSelect;
    @AndroidFindBy (xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[5]/android.view.View")
    public WebElement MalayalamSelect;
    @AndroidFindBy (xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[6]/android.view.View")
    public WebElement MarathiSelect;
    @AndroidFindBy (xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[7]/android.view.View")
    public WebElement BengaliSelect;
    @AndroidFindBy (xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[8]/android.view.View")
    public WebElement EnglishSelect;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Tap to add preferences\"]")
    public WebElement addPreferenceButton;
    @AndroidFindBy (xpath = "//android.view.View[@content-desc=\"Switch to Email\"]")
    public WebElement emailIcon;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Enter OTP\"]")
    public WebElement OtpField;
    @AndroidFindBy (xpath = "//android.view.View[@content-desc=\"Signin with google\"]")
    public WebElement googleIcon;
    @AndroidFindBy (xpath = "(//android.widget.LinearLayout[@resource-id=\"com.google.android.gms:id/container\"])[1]/android.widget.LinearLayout")
    public WebElement googleAccountSelect;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"RESEND\"]")
    public WebElement resendButton;
    @AndroidFindBy (xpath = "//android.widget.Toast[@text=\"Either OTP is not valid or has expired\"]")
    public WebElement otpTextValidation;
    @AndroidFindBy (xpath = "//android.widget.EditText")
    public WebElement emailTextField;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"or\"]")
    public WebElement orText;
    @AndroidFindBy (xpath="//android.widget.TextView[contains(@text,'Terms of Use & Privacy Policy')]")
    public WebElement termsConditions;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Terms of Use\"]")
    public WebElement termsOfUse;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"30 when you sign up!\"]")
    public WebElement signInBonusBanner;
    @AndroidFindBy (xpath = "//android.view.View[@content-desc=\"Back\"]")
    public WebElement backArrowClick;

    public LoginPage(AppiumDriver driver){
        super(driver);

    }

//    public boolean isElementPresent(WebElement locator) {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//            return wait.until(ExpectedConditions.presenceOfElementLocated((By) locator)).isDisplayed();
//        } catch (Exception e) {
//            return false;
//        }
//    }
    public void clickarrowTick() throws InterruptedException {
        click(arrowTick);
        click(arrowTick);
    }

    public void enterMobileNum(String mobileNumber){

        enterTextOnElement(mobileNum,mobileNumber);

        }

        public void enterTextInMail(String mail){
        enterTextOnElement(emailTextField, mail);
        }

        public boolean isMobileNumberDisplayed(){
            return isElementPresent((WebElement) mobileNum);

        }

    public void clickNextArrow(){

        click(nextArrow);
    }
    public void clickOTP(){
        click(otpAllowButton);
    }

    public void selectLanguagePreference(){
        click(HindiSelect);
        click(KannadaSelect);
        click(TamilSelect);
        click(TeluguSelect);
        click(MalayalamSelect);
        click(MarathiSelect);
        click(BengaliSelect);
        click(EnglishSelect);
    }

    public void languageAddButton(){

        click(addPreferenceButton);
    }

    public boolean isLanguageAddButtonDisplayed(){
        return isElementPresent(addPreferenceButton);

    }

    public void emailIconClick(){

        click(emailIcon);
    }

    public boolean OTPFieldVisible(){
        return isElementPresent(OtpField);
    }

    public void OTPCLick(){
        click(OtpField);
    }

    public void otpEntry() {
        click(OtpField);

// cast to AndroidDriver
        AndroidDriver driver = (AndroidDriver) this.driver;

// send OTP digit by digit
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_9));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_8));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_7));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_3));


    }

    public boolean isOTPfieldisDisplayed(){
        return isElementPresent(OtpField);
    }

    public void googleIconClick(){
        click(googleIcon);
    }

    public void googleAccountSelection(){

        click(googleAccountSelect);
    }

    public boolean isGoogleAccountSelectisDisplayed(){
        return isElementPresent(googleAccountSelect);
    }

    public void resendButtonClick() throws InterruptedException {
        Thread.sleep(65000);
        click(resendButton);

    }

    public void wrongOtpEntry(){

        driver.findElement(By.xpath("//android.widget.TextView[@text=\"Enter OTP\"]")).click();
// cast to AndroidDriver
        AndroidDriver driver = (AndroidDriver) this.driver;
// send OTP digit by digit
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_6));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
// Wait until the toast appears
        WebElement toast = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//android.widget.Toast[@text='Either OTP is not valid or has expired']")
                )
        );

// Get the toast text
        String message = toast.getText();
        System.out.println("Error message is : " + message);
//        driver.quit();
    }

    public void mobileNumberValidation(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
// Wait until the toast appears
        WebElement toast = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//android.widget.Toast[@text='Please provide valid mobile number']")
                )
        );

// Get the toast text
        String message = toast.getText();
        System.out.println("Error message is : " + message);
        driver.quit();
    }

    public void otpResentSuccessfullyMessageReader(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
// Wait until the toast appears
        WebElement toast = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//android.widget.Toast[@text='OTP resent successfully']")
                )
        );

// Get the toast text
        String message = toast.getText();
        System.out.println("Error message is : " + message);
        driver.quit();
    }

    public void emailTextField(String EmailField){
        click(emailTextField);

        // cast to AndroidDriver
        AndroidDriver driver = (AndroidDriver) this.driver;
// send OTP digit by digit
        driver.pressKey(new KeyEvent(AndroidKey.S));
        driver.pressKey(new KeyEvent(AndroidKey.U));
        driver.pressKey(new KeyEvent(AndroidKey.R));
        driver.pressKey(new KeyEvent(AndroidKey.E));
        driver.pressKey(new KeyEvent(AndroidKey.N));
        driver.pressKey(new KeyEvent(AndroidKey.D));
        driver.pressKey(new KeyEvent(AndroidKey.I));
        driver.pressKey(new KeyEvent(AndroidKey.R));
        driver.pressKey(new KeyEvent(AndroidKey.A));
        driver.pressKey(new KeyEvent(AndroidKey.N));
        driver.pressKey(new KeyEvent(AndroidKey.PERIOD));
        driver.pressKey(new KeyEvent(AndroidKey.N));
        driver.pressKey(new KeyEvent(AndroidKey.AT));
        driver.pressKey(new KeyEvent(AndroidKey.M));
        driver.pressKey(new KeyEvent(AndroidKey.O));
        driver.pressKey(new KeyEvent(AndroidKey.O));
        driver.pressKey(new KeyEvent(AndroidKey.L));
        driver.pressKey(new KeyEvent(AndroidKey.Y));
        driver.pressKey(new KeyEvent(AndroidKey.A));
        driver.pressKey(new KeyEvent(AndroidKey.PERIOD)); // for '.'
        driver.pressKey(new KeyEvent(AndroidKey.C));
        driver.pressKey(new KeyEvent(AndroidKey.O));
        driver.pressKey(new KeyEvent(AndroidKey.M));




        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


    }

    public String getOtpFromGmailAndroid() {
        try {
            Thread.sleep(10000);
            ((AndroidDriver) driver).activateApp("com.google.android.gm");


            // Open first email in inbox
            WebElement firstEmail = driver.findElement(By.xpath("(//android.widget.FrameLayout[@resource-id=\"com.google.android.gm:id/content_without_bottom_nav_bar\"])"));
            firstEmail.click();
            Thread.sleep(5000);


            // Read email text content
            List<WebElement> emailTexts = driver.findElements(By.xpath("//android.widget.TextView"));
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

            if (otp == null) throw new RuntimeException("OTP not found in Gmail");
            return otp;

        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve OTP from Gmail (Android): " + e.getMessage(), e);
        }
    }

    public void enterOtpInBulletAndroid(String otp) {
        try {
            // Switch to Bullet app
            ((AndroidDriver) driver).activateApp("com.bulletshorts"); // replace with actual Bullet package name

            // Locate OTP field and enter value
            WebElement otpField = driver.findElement(By.xpath("//android.widget.EditText"));
            otpField.sendKeys(otp);

            System.out.println("OTP entered successfully: " + otp);

        } catch (Exception e) {
            throw new RuntimeException("Failed to enter OTP in Bullet app (Android): " + e.getMessage(), e);
        }
    }

    public boolean isArrowKeyDisplayed(){
        return isElementPresent(orText);
    }

    public boolean isTermsDisplayed(){
        return isElementPresent(termsConditions);
    }

    public void clickTermsConditions(){
        click(termsConditions);
    }

    public boolean isTermsOfUseDisplayed(){
        return isElementPresent(termsOfUse);
    }

    public boolean isSigninBonusBannerDisplayed(){
        return isElementPresent(signInBonusBanner);
    }

    public void backButtonClick(){
        click(backArrowClick);
    }

}


