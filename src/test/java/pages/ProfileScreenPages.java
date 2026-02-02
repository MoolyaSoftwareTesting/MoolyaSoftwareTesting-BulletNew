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

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

public class ProfileScreenPages extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"UID:\"]")
    public WebElement nameWithId;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"User profile picture\"]")
    public WebElement profilePhoto;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Edit profile\"]")
    public WebElement editIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Your wallet\"]")
    public WebElement walletInfo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Earn Rewards\"]")
    public WebElement earnRewardTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"My Watchlist\"]")
    public WebElement myWatchlist;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"App Settings\"]\n")
    public WebElement appSettings;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Language Preferences\"]")
    public WebElement languagePreferences;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Help Centre\"]")
    public WebElement helpCentre;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Log out\"]")
    public WebElement logout;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Terms & Conditions\"]")
    public WebElement termsAndConditions;

    @AndroidFindBy(xpath = "//Q0.s0/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View")
    public WebElement deactivateAccount;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Are you sure you want to deactivate your account? By doing so, you'll lose access to your account.\"]")
    public WebElement deactivatePopup;


    public ProfileScreenPages(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    public boolean isNameandIDDisplayed(){
        return isElementDisplayed(nameWithId);
    }

    public boolean isProfilePhotoDisplayed(){
        return isElementDisplayed(profilePhoto);
    }

    public boolean isEditIconDisplayed(){
        return isElementDisplayed(editIcon);
    }

    public boolean isWalletInfoDisplayed(){
        return isElementDisplayed(walletInfo);
    }

    public boolean isEarnRewardTabDisplayed(){
        return isElementDisplayed(earnRewardTab);
    }

    public boolean isMyWatchlistDisplayed(){
        return isElementDisplayed(myWatchlist);
    }

    public boolean isAppSettingsDisplayed(){
        return isElementDisplayed(appSettings);
    }

    public boolean isLanguagePreferencesDisplayed(){
        return isElementDisplayed(languagePreferences);
    }

    public boolean isHelpCentreDisplayed(){
        return isElementDisplayed(helpCentre);
    }

    public boolean isLogoutDisplayed(){
        return isElementDisplayed(logout);
    }

    public boolean isTermsAndConditionsDisplayed(){
        return isElementDisplayed(termsAndConditions);
    }

    public void clickEditIcon(){
        click(editIcon);
    }

    public void appSettingClick(){
        click(appSettings);
    }

    public boolean isDeactivateAccountDisplayed(){
        return isElementDisplayed(deactivateAccount);
    }

    public void deactivateAccountClick(){
        click(deactivateAccount);
    }

    public boolean isDeactivatePopupDisplayed(){
        return isElementDisplayed(deactivatePopup);
    }
}
