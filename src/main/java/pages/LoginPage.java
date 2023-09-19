package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(id = "username")
	private WebElement emailField;
	
	@FindBy(id = "password")
	private WebElement passwordfield;
	
	@FindBy(id = "login")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement WarningMessage;
	
	public void enterEmaiAddress(String emailText) {
		elementUtils.typeTextIntoElement(emailField, emailText, 15);
	}
	
	public void enterPassword(String passwordText) {
		elementUtils.typeTextIntoElement(passwordfield, passwordText, 15);
	}
	
	public void clickOnLogin() {
		elementUtils.clickOnElement(loginButton, 15);
		
	}
	
	public String getWarningMessage() {
		return elementUtils.getTextFromElement(WarningMessage, 15);
	}
	
}
