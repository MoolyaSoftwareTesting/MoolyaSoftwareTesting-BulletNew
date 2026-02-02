package scenarios.stepDefinitions;

import context.TestContext;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.PendingException;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pages.EmailNavigatorPage;
import pages.LoginPage;
import utilities.ConfigLoader;
import utilities.CredsLoader;


public class LoginStepdefs {
    private static final Logger log = LoggerFactory.getLogger(LoginStepdefs.class);
    private final LoginPage loginPage;
    private final TestContext context;
    CredsLoader credsLoader;
    ConfigLoader configLoader;
    Scenario scenario;

    public LoginStepdefs(TestContext context) {
        loginPage = context.loginPage;
        this.context = context;
        this.credsLoader = context.credsLoader;
        this.configLoader = context.configLoader;
        this.scenario = context.scenario;
    }

    @Given("User click the arrow button")
    public void userLaunchTheBulletApp() throws InterruptedException {
        loginPage.clickarrowTick();
    }


    @When("User click on {} Text Box And Enter The Number")
    public void user_Click_onTextBoxAndEnterTheNumber(String mobileNumber) throws InterruptedException {
        loginPage.enterMobileNum(mobileNumber);
    }

    @Then("User Click on the arrow button")
    public void userClickOnTheArrowButton() throws InterruptedException {
        loginPage.clickNextArrow();
    }

    @Then("User Enter The OTP Number")
    public void userEnterTheOTPNumber() {
        loginPage.clickOTP();
    }

    @Then("User should select the language preference")
    public void userShouldSelectTheLanguagePreference() {
        loginPage.selectLanguagePreference();
    }

    @Then("User should select add button after selecting the language")
    public void userShouldSelectAddButtonAfterSelectingTheLanguage() {
        Assert.assertTrue(loginPage.isLanguageAddButtonDisplayed(),"Language preference add button is not displayed");
       loginPage.languageAddButton();
    }

    @Then("User should select email icon")
    public void userShouldSelectEmailIcon() {
        loginPage.emailIconClick();
    }

//    @When("User navigates to email in mobile")
//    public void userNavigatesToEmailInMobile() {
//        emailNavigatorPage.retrieveOtpFromGmail();
//    }


    @Then("User Enter the OTP Number in the respective field")
    public void userEnterTheOTPNumberInTheRespectiveField() {
        Assert.assertTrue(loginPage.isOTPfieldisDisplayed(),"Otp entry field is not visible");
        loginPage.otpEntry();
    }

    @Then("User should select Google icon")
    public void userShouldSelectGoogleIcon() {
        loginPage.googleIconClick();
    }

    @Then("User should select the google account")
    public void userShouldSelectTheGoogleAccount() {
        Assert.assertTrue(loginPage.isGoogleAccountSelectisDisplayed(),"Google account field is not visible");
        loginPage.googleAccountSelection();
    }

    @Then("User click on resend button")
    public void userClickOnResendButton() throws InterruptedException {
        loginPage.resendButtonClick();
    }

    @Then("User Enter the wrong OTP Number in the respective field")
    public void userEnterTheWrongOTPNumberInTheRespectiveField() {
        Assert.assertTrue(loginPage.isOTPfieldisDisplayed(),"Otp entry field is not visible");
        loginPage.wrongOtpEntry();
    }

    @Then("User should check the mobile number is valid")
    public void userShouldCheckTheMobileNumberIsValid() {
        Assert.assertTrue(loginPage.isMobileNumberDisplayed(),"Mobile field is not displayed");
            loginPage.mobileNumberValidation();
    }

    @Then("User should verify the otp resent message")
    public void userShouldVerifyTheOtpResentMessage() {
        Assert.assertTrue(loginPage.isOTPfieldisDisplayed(),"Otp entry field is not visible");
        loginPage.otpResentSuccessfullyMessageReader();
    }

    @Then("User click on {} text box")
    public void userClickOnTextBox(String EmailField) {
        loginPage.enterTextInMail(EmailField);
//        loginPage.emailTextField(EmailField);
        loginPage.clickNextArrow();

    }

    @Then("User Enter The OTP for mail")
    public void userEnterTheOTPForMail() {
       Assert.assertTrue(loginPage.OTPFieldVisible(),"OTP field is not displayed");
       loginPage.OTPCLick();
        loginPage.getOtpFromGmailAndroid();
    }

    @Then("User navigate to gmail and get the OTP")
    public void userNavigateToGmailAndGetTheOTP(String otp) {
       loginPage.enterOtpInBulletAndroid(otp);
    }

    @And("User retrieve OTP from Gmail")
    public void userRetrieveOTPFromGmail() {
        String otp = loginPage.getOtpFromGmailAndroid();
        context.otp = otp;
        context.scenario.log("✅ OTP retrieved from Gmail: " + otp);
    }

    @And("User enter OTP in Bullet")
    public void userEnterOTPInBullet() {
        loginPage.enterOtpInBulletAndroid(context.otp);
        context.scenario.log("✅ OTP entered in Bullet");
    }

    @Then("User should not see the arrow key")
    public void userShouldNotSeeTheArrowKey() {
        Assert.assertTrue(loginPage.isArrowKeyDisplayed(),"Arrow key is not displayed");
    }

    @When("User click on {} Text Box")
    public void userClickOnMobileNumberTextBox(String mobileNumber) {
        loginPage.enterMobileNum(mobileNumber);
    }

    @Then("User click on {} text field")
    public void userClickOnEmailIDTextField(String EmailField) {
        loginPage.enterTextInMail(EmailField);
    }

    @Then("User should see the Terms of Use & Privacy Policy")
    public void userShouldSeeTheTermsOfUsePrivacyPolicy() {
       Assert.assertTrue(loginPage.isTermsDisplayed(),"Terms and conditions is not displayed");
    }

    @Then("User should click the Terms of Use & Privacy Policy")
    public void userShouldClickTheTermsOfUsePrivacyPolicy() {
      loginPage.clickTermsConditions();
    }

    @Then("User should see the terms displayed")
    public void userShouldSeeTheTermsDisplayed() {
      Assert.assertTrue(loginPage.isTermsOfUseDisplayed(),"Terms of use is not displayed");
    }

    @Then("User should see coins bonus banner")
    public void userShouldSeeCoinsBonusBanner() {
       Assert.assertTrue(loginPage.isSigninBonusBannerDisplayed(),"Signin bonus banner is not displayed");
    }

    @Then("user should click on back button")
    public void userShouldClickOnBackButton() {
      loginPage.backButtonClick();
    }
}
