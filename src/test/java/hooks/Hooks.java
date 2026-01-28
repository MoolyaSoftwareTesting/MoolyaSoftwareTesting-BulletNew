package hooks;

import context.TestContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.hu.De;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;
import utilities.ConfigLoader;
import utilities.CredsLoader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;

public class Hooks {
    private AppiumDriver driver;
    private String executionMode;
    private final TestContext context;
    private static String buildName;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @BeforeAll
    public static void suiteSetUp() {
        Date dateNow = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddhhmm");
        String datetime = dateFormat.format(dateNow);
        buildName = "mobile-sdk-tests-" + datetime;
    }

    @Before
    public void setUp(Scenario scenario) throws MalformedURLException {
        context.credsLoader = new CredsLoader();
        context.configLoader = new ConfigLoader();
        context.scenario = scenario;
        initializeDriver(context.scenario);
        context.driver = driver;

        // Initialize all pages
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
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed() && driver != null) {
            try {
                File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
                scenario.attach(fileContent, "image/png", "image");
            } catch (Exception e) {
                System.out.println("Could not capture screenshot: " + e.getMessage());
            }
        }
        try {
            if (driver != null) {
                // Mark session status explicitly
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                String status = scenario.isFailed() ? "failed" : "passed";
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\""
                        + status + "\", \"reason\": \"" + scenario.getName() + "\"}}");
            }
        } finally {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        }
    }

    public void initializeDriver(Scenario scenario) throws MalformedURLException {
        System.out.println("driver initialization started******************");
        executionMode = System.getProperty("executionMode", "local");
        String platformName = System.getProperty("platformName", "Android");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("appium:deviceName", System.getProperty("deviceName", "Testdevice"));

        if (executionMode.equalsIgnoreCase("local")) {
            if (platformName.equalsIgnoreCase("Android")) {
                capabilities.setCapability("appium:automationName", "UiAutomator2");
                String appPath = System.getProperty("appPath");
                if (appPath == null || appPath.trim().isEmpty()) {
                    System.out.println("WARNING: No appPath provided, skipping app capability");
                } else if (!(new File(appPath).exists())) {
                    System.out.println("WARNING: APK file not found at: " + appPath);
                } else {
                    capabilities.setCapability("appium:app", appPath);
                }
                driver = new AndroidDriver(new URL("http://localhost:4723"), capabilities);
            } else if (platformName.equalsIgnoreCase("iOS")) {
                capabilities.setCapability("appium:automationName", "XCUITest");
                capabilities.setCapability("appium:udid", "6AF6C6C9-B963-4CE2-ADE6-D2F8E4CFCFBA");
                capabilities.setCapability("appium:noReset", true);
                capabilities.setCapability("appium:forceAppLaunch", true);
                driver = new IOSDriver(new URL("http://localhost:4723"), capabilities);
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        } else if (executionMode.equalsIgnoreCase("BrowserStack")) {

            DesiredCapabilities caps = new DesiredCapabilities();
            HashMap<String, Object> bstackOptions = new HashMap<>();

            bstackOptions.put("userName", System.getProperty("browserstackUser"));
            bstackOptions.put("accessKey", System.getProperty("browserstackKey"));

            bstackOptions.put("deviceName", System.getProperty("deviceName"));
            bstackOptions.put("osVersion", System.getProperty("platformVersion"));

            bstackOptions.put("consoleLogs", "info");
            bstackOptions.put("buildName", buildName);
            bstackOptions.put("sessionName", scenario.getName());

            caps.setCapability("platformName", System.getProperty("platformName"));
            caps.setCapability("appium:app", System.getProperty("appPath"));
            caps.setCapability("bstack:options", bstackOptions);

            driver = new AndroidDriver(
                    new URL("https://hub-cloud.browserstack.com/wd/hub"),
                    caps
            );

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        }

        System.out.println("driver initialization completed******************");
    }
}
