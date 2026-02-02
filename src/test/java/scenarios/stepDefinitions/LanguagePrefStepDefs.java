package scenarios.stepDefinitions;

import context.TestContext;
import io.cucumber.java.PendingException;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.EmailNavigatorPage;
import pages.LanguagePreference;
import utilities.ConfigLoader;
import utilities.CredsLoader;


public class LanguagePrefStepDefs {
    private static final Logger log = LoggerFactory.getLogger(LanguagePrefStepDefs.class);
    private final TestContext context;
    private final LanguagePreference languagePreference;
    private EmailNavigatorPage emailNavigatorPage;
    CredsLoader credsLoader;
    ConfigLoader configLoader;
    Scenario scenario;


    public LanguagePrefStepDefs(TestContext context) {
        this.context=context;
        languagePreference = context.languagePreference;
    }


    @Then("User should select the language preference for new user")
    public void userShouldSelectTheLanguagePreferenceForNewUser() {
//        context.languagePreference.CloseAddIfPresent();
        languagePreference.languageSelectforNewUsers();
    }

    @Then("User should see the login bonus coins")
    public void userShouldSeeTheLoginBonusCoins() {
        languagePreference.getStartedClick();
    }

    @Then("User is on home screen")
    public void userIsOnHomeScreen() {

//        homeScreenPages.CloseAddIfPresent();
//        Assert.assertTrue(homeScreenPages.isHomeNavButtonVisible(),"Home Nav button not visible");
        languagePreference.CloseAddIfPresent();

    }
}

