package scenarios.stepDefinitions;

import context.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.WelcomePage;
import utilities.ConfigLoader;
import utilities.CredsLoader;

public class WelcomeStepdefs {
    private static final Logger log = LoggerFactory.getLogger(WelcomeStepdefs.class);
    private final WelcomePage welcomePage;
    CredsLoader credsLoader;
    ConfigLoader configLoader;
    Scenario scenario;

    public WelcomeStepdefs(TestContext context) {
        welcomePage = context.welcomePage;
        this.credsLoader = context.credsLoader;
        this.configLoader = context.configLoader;
        this.scenario = context.scenario;
    }

//    public WelcomeStepdefs(WelcomePage welcomePage) {
//        this.welcomePage = welcomePage;
//    }

    @Given("User click the Welcome arrows")
    public void userClickTheWelcomeArrows() {
       welcomePage.clickWelcomeArrow();
    }

    @And("user should enter password")
    public void userShouldEnterPassword() {
    }
}
