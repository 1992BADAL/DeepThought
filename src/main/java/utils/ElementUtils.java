package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	WebDriver driver;
	
	public ElementUtils(WebDriver driver) {
		
		this.driver=driver;
	}
	
	//Click on element method
	public void clickOnElement(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForElement(element,durationInSeconds);
		webElement.click();
	}
	
	//Text type/send method
	public void typeTextIntoElement(WebElement element,String TextToBeTyped,long durationInSeconds) {
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		
		webElement.click();
		webElement.clear();
		webElement.sendKeys(TextToBeTyped);
	}
	
	public WebElement waitForElement(WebElement element,long durationInSeconds) {
		
		WebElement webElement = null;
		
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		 webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return webElement;
	}
	
	public void selectOptionInDropdown(WebElement element,String dropDownOption,long durationInSeconds) {
		WebElement webElement = waitForElement(element, durationInSeconds); 
		Select select = new Select(webElement);
		select.selectByVisibleText(dropDownOption);
	}
	
	public void acceptAlert(long durationInSecond) {
		
		Alert alert = waitForAlert(durationInSecond);
		alert.accept();
	}
	
	public void dismissAlert(long durationInSeconds) {
		Alert alert = waitForAlert(durationInSeconds);
		alert.dismiss();
	}
	
	public Alert waitForAlert(long durationInSecong) {
		Alert alert = null;
		
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSecong));
		alert = wait.until(ExpectedConditions.alertIsPresent());
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		return alert;
	}
	
	public void mouseOverAndClick(WebElement element, long durationInSeconds) {
		
		 WebElement webElement = waitForVisiblityOfElement(element,durationInSeconds);
		 
		 Actions actions = new Actions(driver);
		 actions.moveToElement(webElement).click().build().perform();
	}
	
	public WebElement waitForVisiblityOfElement(WebElement element, long durationInSeconds) {
		
		WebElement webElement = null;
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		  webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Throwable e) {
			e.printStackTrace();
			
		}
		return webElement;
	}
	
	public void javaScriptClick(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForVisiblityOfElement(element,durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click();", webElement);
	}
	
	public void javscriptType(WebElement element, long durationInSeconds,String TextToBeTyped) {
		WebElement webElement = waitForVisiblityOfElement(element,durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].value='"+TextToBeTyped+"'", webElement);
	}
	
	public String getTextFromElement(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForElement(element, durationInSeconds); 
		return webElement.getText();
	}
	
	public boolean displayStatusOfElement(WebElement element, long durationInSeconds) {
		try {
		WebElement webElement = waitForVisiblityOfElement(element,durationInSeconds);
		return webElement.isDisplayed();
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return false;
	}


}
