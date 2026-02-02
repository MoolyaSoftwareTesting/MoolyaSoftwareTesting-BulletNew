package scenarios.stepDefinitions;

import context.TestContext;
import io.cucumber.java.PendingException;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pages.ShowScreenPages;
import utilities.ConfigLoader;
import utilities.CredsLoader;

public class ShowScreenStepDefs {
    private static final Logger log = LoggerFactory.getLogger(ShowScreenStepDefs.class);
    private final ShowScreenPages showScreen;
    CredsLoader credsLoader;
    ConfigLoader configLoader;
    Scenario scenario;

    public ShowScreenStepDefs(TestContext context) {
        showScreen = context.showScreen;
        this.credsLoader = context.credsLoader;
        this.configLoader = context.configLoader;
        this.scenario = context.scenario;
    }

    @And("User Clicked  on the Explore Tab in Home")
    public void userClickedOnTheExploreTabInHome() {
        showScreen.exploreIconSelect();
    }

    @And("User should click on add to watchlist button")
    public void userShouldClickOnAddToWatchlistButton() {
        showScreen.addToWatchlistClick();
    }


    @And("User should see the Start Button and Episodes Button")
    public void userShouldSeeTheStartButtonAndEpisodesButton() {
        showScreen.understandClick();
        Assert.assertTrue(showScreen.isExpisodeAndStartButtonDisplayed(),"Start button is not displayed");
    }

    @And("User should see The Watchlist buton")
    public void userShouldSeeTheWatchlistButon() {
       Assert.assertTrue(showScreen.isWatchlistButtonDisplayed(),"Watchlist button is not displayed");
    }

    @And("User should see the Like Button")
    public void userShouldSeeTheLikeButton() {
        Assert.assertTrue(showScreen.isLikeButtonDisplayed(),"Like button is not displayed");
    }

    @And("User should see the Share Button")
    public void userShouldSeeTheShareButton() {
        Assert.assertTrue(showScreen.isShareButtonDisplayed(),"Share button is not displayed");
    }

    @Then("Trailer should auto scroll once playback is completed")
    public void trailerShouldAutoScrollOncePlaybackIsCompleted() {
        Assert.assertTrue(showScreen.waitForTrailerAutoScroll(90),"Trailer is not displayed");
    }

    @And("User Clicks on the Start Button")
    public void userClicksOnTheStartButton() {
        showScreen.startButtonClick();
    }

    @Then("User should see MuteUnmute Icon")
    public void userShouldSeeMuteUnmuteIcon() {
        Assert.assertTrue(showScreen.muteUnmuteClick(),"Mute icon is not Displayed");
    }

    @And("User Clicks on mute Icon")
    public void userClicksOnMuteIcon() {
      showScreen.muteButtonClick();
    }

    @And("User increases the device volume")
    public void userIncreasesTheDeviceVolume() throws InterruptedException {
        showScreen.increaseVolume(6);
    }

    @Then("User decreases the device volume")
    public void userDecreasesTheDeviceVolume() throws InterruptedException {
        showScreen.decreaseVolume(4);
    }

    @Then("User should land on episode feed")
    public void userShouldLandOnEpisodeFeed() {
        showScreen.understandClick();
        Assert.assertTrue(showScreen.isEpisodeOnePlayingFromStaticText(),"Episode Number is not displayed");
    }

    @And("The first episode should start playing")
    public void theFirstEpisodeShouldStartPlaying() {
        showScreen.understandClick();
        Assert.assertTrue(showScreen.isStartPageNavigationDisplayed(),"Start page is not displayed");
    }

    @And("User Clicks on the Episodes Button")
    public void userClicksOnTheEpisodesButton() {
       showScreen.clickOnEpisode();
    }

    @Then("Episodes PopUp should visible")
    public void episodesPopUpShouldVisible() {
        Assert.assertTrue(showScreen.episodePopupVisible(),"Episode popup is not displayed");
    }

    @And("Verify All Episodes of the series season is displaying")
    public void verifyAllEpisodesOfTheSeriesSeasonIsDisplaying() {
       Assert.assertTrue(showScreen.episodesAreVisible(),"Episodes are not displayed");
    }

    @And("User see First Episode")
    public void userSeeFirstEpisode() {
       showScreen.clickFirstEpisode();
    }

    @When("User puts the app in background for {int} seconds")
    public void userPutsTheAppInBackgroundForSeconds(int seconds) {
        showScreen.runAppInBackgroundFor5Secs();
    }

    @And("User brings the app to foreground")
    public void userBringsTheAppToForeground() {
        Assert.assertTrue(showScreen.isAppCameToForeground(),"The screen is not visible");
    }

    @Then("Trailer playback should resume from where it left off")
    public void trailerPlaybackShouldResumeFromWhereItLeftOff() {
        Assert.assertTrue(showScreen.isAppCameToForeground(),"The screen is not visible");
    }

    @And("User scrolls down {int} times")
    public void userScrollsDownTimes(int time) {
            showScreen.ScrollDownNTimes(time);
    }

    @Then("User scrolls Up {int} times")
    public void userScrollsUpTimes(int time) {
        showScreen.ScrollUpNTimes(time);
    }

    @And("User should see Back Icon")
    public void userShouldSeeBackIcon() {
        showScreen.understandClick();
        Assert.assertTrue(showScreen.isBackButtonPresent(),"Back button is not displayed");
    }

    @Then("User navigate back to Home")
    public void userNavigateBackToHome() {
        showScreen.understandClick();
        showScreen.homeNavigation();
    }
}
