package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class AccountPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public AccountPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath = "//h5[normalize-space()='Welcome to DeepThought']")
	private WebElement editYourAccountInformationOption;
	
	
	public boolean displayStatusOfEditYourAccountInformation() {
		return elementUtils.displayStatusOfElement(editYourAccountInformationOption, 15);
	}

}
