package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WalletPage extends BasePage{

    public WalletPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Wallet\"]")
    public WebElement WalletButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"App logo\"]")
    public WebElement BulletLogo;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Search\"]")
    public WebElement SearchIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Profile\"]")
    public WebElement ProfileIcon;

    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[1]")
    public WebElement CurrectBalance;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"UID:\"]")
    public WebElement WalletID;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Copy to clipboard\"]")
    public WebElement CopyIDButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Free coins\"]")
    public WebElement FreeCoinsTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Buy coins\"]")
    public WebElement BuyCoinsTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Coins history\"]")
    public WebElement CoinHistoryTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Your wallet\"]")
    public WebElement walletText;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"₹25\"]")
    public WebElement coinsSelect;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Google Play\"]")
    public WebElement paymentGateway;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Your coin transactions\"]")
    public WebElement CoinHistoryIsDisplayed;

    @AndroidFindBy (xpath = "//Q0.s0/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[6]/android.view.View/android.view.View")
    public WebElement coinHistory;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Collect free coins\"]")
    public WebElement CollectFreeCoinButton;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Thanks for Check in\"]")
    public WebElement thanksCheckIn;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Okay\"]")
     public WebElement CheckinOkayButton;

    @AndroidFindBy (xpath = "//android.widget.ImageView[@content-desc=\"Close\"]")
    public WebElement CoinWatchAddCancel;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Complete Your Profile\"]")
    public WebElement completeProfileTask;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Turn on Notifications\"]")
    public WebElement TurnOnNotificationTask;

    @AndroidFindBy (xpath = "(//android.widget.TextView[@text=\"Go\"])[7]")
    public WebElement completeProfileClick;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"EDIT PROFILE\"]")
    public WebElement editProfileText;

    @AndroidFindBy (xpath = "//android.widget.EditText[@text=\"Guest\"]")
    public WebElement fullNameTextField;

    @AndroidFindBy (xpath = "//Q0.s0/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText")
    public WebElement fullName;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"18-24 years\"]")
    public WebElement ageSelect;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Male\"]")
    public WebElement genderSelect;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Save\"]")
    public WebElement saveButtonClick;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Enjoy Binging\"]")
    public WebElement coinsPopupEditProfile;

    @AndroidFindBy (xpath = "(//android.widget.TextView[@text=\"Go\"])[5]")
    public WebElement turnOnNotificationClick;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Thanks for Following Bullet\"]")
    public WebElement notificationPopup;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Okay\"]")
    public WebElement notificationOkayButton;

    @AndroidFindBy (xpath = "//android.view.View[@content-desc=\"Cancel\"]")
    public WebElement profileCancel;







    public void ClickWalletButton(){
        click(WalletButton);
    }
    public boolean BulletLogoIsDisplayed() {
        return isElementPresent(BulletLogo);
    }
    public boolean SearchIconIsDisplayed() {
        return isElementPresent(SearchIcon);
    }
    public boolean ProfileIconIsDisplayed() {
        return isElementPresent(ProfileIcon);
    }
    public boolean currectBalanceIsDisplayed() {
        return isElementPresent(CurrectBalance);
    }
    public boolean WalletIDWithCopyButtonIsDisplayed() {
        return isElementPresent(WalletID) && isElementPresent(CopyIDButton);
    }
    public boolean FreeCoinsTabIsDisplayed() {
        return isElementPresent(FreeCoinsTab);
    }
    public boolean CoinHistoryTabIsDisplayed() {
        return isElementPresent(CoinHistoryTab);
    }
    public  boolean BuyCoinsTabIsDisplayed() {
        return isElementPresent(BuyCoinsTab);
    }
    public boolean YourWalletIsDisplayed() {
        return isElementPresent(walletText);
    }

    public void buyCoinsClick(){
        click(BuyCoinsTab);
    }

    public void coinsSelect(){
        click(coinsSelect);
    }

    public boolean PaymentNavigationIsDisplayed(){
        return isElementPresent(paymentGateway);

    }

    public void coinsHistoryClick(){
        click(CoinHistoryTab);
    }

    public boolean CoinHistoryIsDisplayed(){
        return isElementPresent(CoinHistoryIsDisplayed);
    }

    public boolean coinsUsage(){
        return isElementPresent(coinHistory);

    }

    public void coinsCount(){
        System.out.println(coinHistory);
    }


    public void freeCoinsTab(){
        click(FreeCoinsTab);
    }

    public boolean collectFreeCoinsButtonIsDisplayed(){
        return isElementPresent(CollectFreeCoinButton);
    }

    public void collectFreeCoinsButtonClick(){
        click(CollectFreeCoinButton);
    }

    public boolean checkInPopUpIsDisplayed(){
        return isElementPresent(thanksCheckIn);
    }

    public void coinCheckInOkayButtonClick(){
        click(CheckinOkayButton);
    }

    public void CoinsCheckInCancelClick(){
        click(CoinWatchAddCancel);
    }

    public boolean completeProfileTaskIsDisplayed(){
        return isElementPresent(completeProfileTask);
    }

    public void swipeScreen(){
        // Scroll until element with text "Turn on Notifications" is visible
        WebElement element = driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().text(\"Turn on Notifications\"));"
                )
        );

        // Now you can interact with it
        element.click();
    }

    public boolean NotificationTurnOnTaskIsDisplayed(){
        return isElementPresent(TurnOnNotificationTask);
    }

    public void completeYourProfileClick(){
            click(completeProfileClick);
    }

    public boolean editProfilePageCheck(){
        return isElementPresent(editProfileText);
    }

    public void fullNameEntry(){
       fullNameTextField.clear();


//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        driver.switchTo().activeElement().sendKeys(nameField);
//        WebElement element = driver.findElement(By.xpath("//android.widget.EditText[contains(@text,'Guest') or contains(@text,'Full Name')]"));
//        element.sendKeys(nameField);
//       fullNameTextField.sendKeys(nameField);.
    }

    public void enterName(String nameField){
        fullName.sendKeys(nameField);
    }

    public void ageGroupSelection(){
        click(ageSelect);
    }

    public void genderSelectAndSave(){
        click(genderSelect);
        click(saveButtonClick);
    }

    public void editProfileCoinPopupScreen(){
        click(coinsPopupEditProfile);
    }

    public void turnNotificationOnClick(){
        click(turnOnNotificationClick);
    }

    public boolean notificationPopupCheck(){
        return isElementPresent(notificationPopup);
    }

    public void notificationClickOkay(){
        click(notificationOkayButton);
    }
    public void coinHistoryprint(){
        System.out.println(coinHistory.getText());

    }

    public void profileCancelClick(){
        click(profileCancel);
    }

}
