package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WarningMessagesPage{
	
	WebDriver driver;
	public WarningMessagesPage( WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningDuplicateemail;

	@FindBy(xpath="//input[@name='firstname']/following-sibling::div")
	private WebElement firstNameWarningText;
	
	@FindBy(xpath="//input[@name='lastname']/following-sibling::div")
	private WebElement lastNameWarningText;
	
	@FindBy(xpath="//input[@name='email']/following-sibling::div")
	private WebElement emailWarningText;
	
	@FindBy(xpath="//input[@name='telephone']/following-sibling::div")
	private WebElement telephoneWarningText;
	
	@FindBy(xpath="//input[@name='password']/following-sibling::div")
	private WebElement passwordWarningText;
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement noProductMatching;
	
	public String warningForDuplicateEmail() {
		return warningDuplicateemail.getText();
	}
	
	public String firstNameWarningMessage() {
		return firstNameWarningText.getText();
	}
	
	public String lastNameWarningMessage() {
		return lastNameWarningText.getText();
	}
	
	public String emailWarningMessage() {
		return emailWarningText.getText();
	}

	public String telephoneWarningMessage() {
		return telephoneWarningText.getText();
	}
	
	public String passwordWarningMessages() {
		return passwordWarningText.getText();
	}
	
	public String noProductMatchingWarningMessage() {
		return noProductMatching.getText();
	}
}
