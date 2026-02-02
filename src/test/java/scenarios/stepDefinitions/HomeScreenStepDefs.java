package scenarios.stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import context.TestContext;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pages.EmailNavigatorPage;
import pages.HomeScreenPages;
import utilities.ConfigLoader;
import utilities.CredsLoader;


public class HomeScreenStepDefs {
    private static final Logger log = LoggerFactory.getLogger(HomeScreenStepDefs.class);
    private final HomeScreenPages homeScreenPages;
    private final TestContext context;
    private EmailNavigatorPage emailNavigatorPage;
    CredsLoader credsLoader;
    ConfigLoader configLoader;
    Scenario scenario;

    public HomeScreenStepDefs(TestContext context) {
        this.context=context;
        homeScreenPages = context.homeScreenPages;
    }


    @Then("User should click on Home navigation icon")
    public void userShouldClickOnHomeNavigationIcon() {
        context.homeScreenPages.CloseAddIfPresent();
        homeScreenPages.homeNavigatorClick();
    }

    @Then("User should swipe the screen")
    public void userShouldSwipeTheScreen(){
        homeScreenPages.bannerSwipe();
        homeScreenPages.screenSwipe();

    }


    @Then("User should see the banners for SFD series")
    public void userShouldSeeTheBannersForSFDSeries() {
        Assert.assertTrue(homeScreenPages.isSFDBannerDisplay(),"SDF banner is not displayed");
    }

    @Then("User should click on a SFD series banner")
    public void userShouldClickOnASFDSeriesBanner() {
//        Assert.assertTrue(homeScreenPages.isSFDBannerClick(),"SDF banner is not clicked");
       homeScreenPages.SFDBannerClick();
    }

    @Then("User should verify that he can able to see related series")
    public void userShouldVerifyThatHeCanAbleToSeeRelatedSeries() {
        Assert.assertTrue(homeScreenPages.isrelatedSeriesDisplayed(),"Related series not displayed");
    }

    @Then("User should scroll the rails horizontally for thumbnails view {int},{int},{int}")
    public void userShouldScrollTheRailsHorizontallyForThumbnailsView(int startXPercent, int endXPercent, int yPercent) throws InterruptedException {

      // homeScreenPages.thumbnailSwipe("LEFT");
//        homeScreenPages.scrollRailToEnd();

        //Scroll down and try horizontal swipe 2-3 times
//        homeScreenPages.scrollDownAndHorizontal(4, 4);

        homeScreenPages.swipeHorizontal(startXPercent / 100, endXPercent / 100, yPercent / 100);

    }

    @Then("User should scroll the rails")
    public void userShouldScrollTheRails() {
        homeScreenPages.scrollRailFrontAndBack();
    }

    @Then("User should click on Explore navigation icon")
    public void userShouldClickOnExploreNavigationIcon() {
       homeScreenPages.exploreClick();
    }

    @Then("User should verify whether landed on explore screen")
    public void userShouldVerifyWhetherLandedOnExploreScreen() {
        Assert.assertTrue(homeScreenPages.isExploreScreenDisplayed(),"Explore screen not displayed");
    }

    @Then("User should click on My List icon")
    public void userShouldClickOnMyListIcon() {
        homeScreenPages.myListClick();
    }


    @Then("User should click on Wallet icon")
    public void userShouldClickOnWalletIcon() {
       homeScreenPages.walletIconClick();
    }

    @Then("User should verify whether landed on Wallet screen")
    public void userShouldVerifyWhetherLandedOnWalletScreen() {
        Assert.assertTrue(homeScreenPages.isWalletIconClickDisplayed(),"Wallet screen not displayed");
    }

    @Then("User should click on search icon")
    public void userShouldClickOnSearchIcon() {
        homeScreenPages.searchButtonClick();
    }

    @Then("user should verify whether landed on search icon page")
    public void userShouldVerifyWhetherLandedOnSearchIconPage() {
        Assert.assertTrue(homeScreenPages.isSeachIconClickDisplayed(),"Search field not displayed");
    }

    @Then("User should click on cancel icon")
    public void userShouldClickOnCancelIcon() {
       homeScreenPages.searchCancelButtonClick();
    }

    @Then("User should click on Profile Icon")
    public void userShouldClickOnProfileIcon() {
       homeScreenPages.profileIconClick();
    }

    @Then("user should verify whether landed on profile icon page")
    public void userShouldVerifyWhetherLandedOnProfileIconPage() {
       Assert.assertTrue(homeScreenPages.IsProfileIconClickDisplayed(),"Profile field not Displayed");
    }

    @Then("User should verify the show is displayed after the SFD series banner is clicked")
    public void userShouldVerifyTheShowIsDisplayedAfterTheSFDSeriesBannerIsClicked() {
        Assert.assertTrue(homeScreenPages.isShowDisplayedAfterClickOnSDFBanner(), "Show not played");
    }

    @Then("User should click on back icon")
    public void userShouldClickOnBackIcon() {
        homeScreenPages.backIconClick();
    }

    @Then("User click on close sheet")
    public void userClickOnCloseSheet() {
        homeScreenPages.closeSheet();
    }


    @Then("User should cancel the subscription preview")
    public void userShouldCancelTheSubscriptionPreview() {
        context.homeScreenPages.CloseSubscriptionRecommendation();
    }
}
