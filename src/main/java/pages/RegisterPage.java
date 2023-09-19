package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="email")
	WebElement emailField;
	
	@FindBy(id = "username")
	WebElement Username;
	
	
	@FindBy(id="password")
	WebElement passwordField;
	
	@FindBy(id="password-confirm")
	WebElement passwordConfirmField;
	
	@FindBy(xpath="//button[@id='register']")
	WebElement RegisterNowBtn;
	
	public void enterFirstNameField(String firstNameText) {
		Username.sendKeys(firstNameText);
	}
	
	public void enterEmail(String emailText) {
		emailField.sendKeys(emailText);
	}
	
	public void enterPasswordField(String password) {
		passwordField.sendKeys(password);
	}
	
	public void enterConfirmedPassword(String confirmPassword) {
		passwordConfirmField.sendKeys(confirmPassword);
	}
	
	public void clickOnRegistrButton() {
		RegisterNowBtn.click();
	}
	
}
