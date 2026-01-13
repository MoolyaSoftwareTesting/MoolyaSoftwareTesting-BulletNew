package hooks;

import context.TestContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import pages.*;
import utilities.ConfigLoader;
import utilities.CredsLoader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Hooks {
    private AppiumDriver driver;
    private String executionMode;
    private static String buildName;
    private final TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }


    @Before
    public void setUp(Scenario scenario) throws MalformedURLException {
        context.credsLoader = new CredsLoader();
        context.configLoader = new ConfigLoader();
        context.scenario = scenario;
        initializeDriver();
        context.driver = driver;
        context.loginPage = new LoginPage(context.driver);
        context.emailNavigatorPage = new EmailNavigatorPage(context.driver);
        context.welcomePage = new WelcomePage(context.driver);
        context.languagePreference = new LanguagePreference(context.driver);
        context.homeScreenPages = new HomeScreenPages(context.driver);
        context.walletPage = new WalletPage(context.driver);
        context.showScreen = new ShowScreenPages(context.driver);
        context.episodeAccessPages = new EpisodeAccessPages(context.driver);
        context.videoControlPages = new VideoControlPages(context.driver);
        context.watchlistPages = new WatchlistPages(context.driver);
        context.likeUnlikePages = new LikeUnlikePages(context.driver);
        context.otp = new String(String.valueOf(context.driver));
        context.profileScreenPages = new ProfileScreenPages(context.driver);
        context.searchPages = new SearchPages(context.driver);
        context.paymentsAndCoinsPages = new PaymentsAndCoinsPages(context.driver);
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "image");
        }



            if (driver != null) {
                driver.quit();
                driver = null; // prevents re-use of dead driver
            }

    }

    public void initializeDriver() throws MalformedURLException {
        System.out.println("driver initialization started******************");
        executionMode = System.getProperty("executionMode");
        String platformName = System.getProperty("platformName");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("appium:deviceName", System.getProperty("deviceName"));

        if (executionMode.equalsIgnoreCase("local")) {
            if (platformName.equalsIgnoreCase("Android")) {
                capabilities.setCapability("appium:automationName", "uiAutomator2");
                String appPath = System.getProperty("appPath");
                if(appPath == null || !(new File(appPath).exists())) {
                    throw new RuntimeException("APK path is invalid or missing: " + appPath);
                }
                capabilities.setCapability("appium:app", appPath);

//                capabilities.setCapability("appium:" + "appPackage","com.bulletshorts");
//                capabilities.setCapability("appium:appActivity","com.bullet.MainActivity");
            } else if (platformName.equalsIgnoreCase("iOS")) {
                capabilities.setCapability("appium:automationName", "xcuitest");
                capabilities.setCapability("appium:udid", "6AF6C6C9-B963-4CE2-ADE6-D2F8E4CFCFBA");
                capabilities.setCapability("appium:noReset", true);
                capabilities.setCapability("appium:forceAppLaunch", true);
//            capabilities.setCapability("appium:app", "com.example.apple-samplecode.UICatalog");
            }

            capabilities.setCapability("appium:newCommandTimeout", 300);

            if(System.getProperty("platformName").equalsIgnoreCase("Android")){
                driver = new AndroidDriver(new URL("http://localhost:4723"), capabilities);
            }else{
                driver = new IOSDriver(new URL("http://localhost:4723"), capabilities);
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        } else if (executionMode.equalsIgnoreCase("BrowserStack")) {
            //BrowserStack capabilities
        }

        System.out.println("driver initialization completed******************");
    }

}
