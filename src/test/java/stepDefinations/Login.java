package stepDefinations;

import org.openqa.selenium.WebDriver;
import Factory.DriverFactory;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.AccountPage;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import pages.WarningMessagesPage;
import utils.CommonUtils;

public class Login {
	
	public WebDriver driver;
	
	public HomePage HomePg ;
	public LoginPage loginPg ;
	public AccountPage AccountPg;
	
	@Given("User has navigates to login page")
	public void user_has_navigates_to_login_page() {
		driver = DriverFactory.getDriver();
		
		HomePg = new HomePage(driver);
		loginPg = new LoginPage(driver);
		AccountPg = new AccountPage(driver);
	}

	@When("^User enters valid email address (.+) into email field$")
	public void user_enters_valid_email_address_into_email_field(String emailText) {
		
		loginPg.enterEmaiAddress(emailText);
	   }

	@When("^User has enterd valid password (.+) into the password field$")
	public void user_has_enterd_valid_password_into_the_password_field(String passwordText) {
	   
		loginPg.enterPassword(passwordText);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPg.clickOnLogin();
	}
	
	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		
	   Assert.assertTrue(AccountPg.displayStatusOfEditYourAccountInformation());
	}
	
	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		
		loginPg.enterEmaiAddress(CommonUtils.getEmailWithTimeStamp());
	}

	@When("User has enterd invalid password {string} into the password field")
	public void user_has_enterd_invalid_password_into_the_password_field(String invalidpasswordText) {
		
		loginPg.enterPassword(invalidpasswordText);
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
	    Assert.assertTrue(loginPg.getWarningMessage().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User dont enters any email address into email field")
	public void user_dont_enters_any_email_address_into_email_field() {
		loginPg.enterEmaiAddress("");
	}

	@When("User dont enterd any password into the password field")
	public void user_dont_enterd_any_password_into_the_password_field() {
	    
		loginPg.enterPassword("");
	}

}
