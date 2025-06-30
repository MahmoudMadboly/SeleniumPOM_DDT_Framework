package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageBase {
	
	WebDriver driver;
	
	public PageBase(WebDriver driver) {
		
		this.driver = driver;
		
	} 
	
	public void clickOnElement(By element) {
		
		driver.findElement(element).click();
			
		}
	
	
	public void sendKeysToField(By element , String text) {
		
		driver.findElement(element).sendKeys(text);
		
	}	
}