package scenarios.stepDefinitions;

import context.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ApiDemosPage;
import pages.UiKitCatalogPage;
import utilities.ConfigLoader;
import utilities.CredsLoader;

public class ApiDemosSteps {
    ApiDemosPage apiDemosPage;
    CredsLoader credsLoader;
    ConfigLoader configLoader;
    Scenario scenario;

    public ApiDemosSteps(TestContext context) {
        apiDemosPage = new ApiDemosPage(context.driver);
        this.credsLoader = context.credsLoader;
        this.configLoader = context.configLoader;
        this.scenario = context.scenario;
    }

    @Given("User click on Preference option")
    public void userClickOnPreferenceOption() {
        apiDemosPage.clickOnPreference();
        System.out.println("it is executing the step");
    }

    @When("User click on Preference Dependencies option")
    public void userClickOnPreferenceDependenciesOption() {
        apiDemosPage.clickOnPreferenceDependencies();
    }

    @And("User enables the Wifi")
    public void userEnablesTheWifi() {
        apiDemosPage.selectWifiCheckbox();
    }

    @Then("Verify Wifi option is enabled")
    public void verifyWhetherTheWifiIsEnabledOrNot() {
        Assert.assertTrue(apiDemosPage.isWifiEnabled(), "Wifi option is not enabled");
    }

    @Then("Verify Wifi option is not enabled")
    public void verifyWifiOptionIsNotEnabled() {
        Assert.assertFalse(apiDemosPage.isWifiEnabled(), "Wifi option is enabled");
    }
}
