package pages;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;


public class WelcomePage extends BasePage {

    By WelcomearrowTick = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View");


    public WelcomePage(AppiumDriver driver){
            super(driver);

    }

    public void clickWelcomeArrow(){
        click(WelcomearrowTick);
        click(WelcomearrowTick);
    }
}
