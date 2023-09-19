package stepDefinations;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import pages.WarningMessagesPage;
import utils.CommonUtils;

public class Registration {
	
	WebDriver driver;
	
	RegisterPage RegisterPg;
	HomePage HomePg;
	WarningMessagesPage WarningMessagePg;
	AccountSuccessPage AccountSuccessPg;
	
	@Given("User navigates to Registration Account page")
	public void user_navigates_to_registration_account_page() {
	    driver = DriverFactory.getDriver();
	    
	    // Initialize all the objects
	    HomePg = new HomePage(driver);
		RegisterPg = new RegisterPage(driver);
		WarningMessagePg = new WarningMessagesPage(driver);
		HomePg.clickOnRegisterLink();
		AccountSuccessPg = new AccountSuccessPage(driver);
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);

		RegisterPg.enterFirstNameField(dataMap.get("Username"));
		RegisterPg.enterEmail(CommonUtils.getEmailWithTimeStamp());
		RegisterPg.enterPasswordField(dataMap.get("password"));
		RegisterPg.enterConfirmedPassword(dataMap.get("password"));
		
	} 
	
	@When("User enters the details into below fields with the duplicate email")
	public void user_enters_the_details_into_below_fields_with_the_duplicate_email(DataTable dataTable) {
Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		driver.findElement(By.id("email")).sendKeys(dataMap.get("email"));
		driver.findElement(By.id("username")).sendKeys(dataMap.get("firstName"));
		driver.findElement(By.id("password")).sendKeys(dataMap.get("password"));
		driver.findElement(By.id("password-confirm")).sendKeys(dataMap.get("password"));
		
	}

	
	@When("User clicks on continue button")
	public void User_clicks_on_registerNow_button() {
		RegisterPg.clickOnRegistrButton();
	}

	@Then("User account should created successfully")
	public void user_account_should_created_successfully() {
	    Assert.assertEquals("You seem to have stumbled upon a page that does not exist. Return to the home page.", AccountSuccessPg.getPageHeading());
	}

	
	@Then("User should get a proper warning about duplicate emali")
	public void user_should_get_a_proper_warning_about_duplicate_emali() {
	    Assert.assertTrue(WarningMessagePg.warningForDuplicateEmail().contains("Warning: E-Mail Address is already registered!"));
	}
	
	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
	    //Intentionally kept blank
	}

}
