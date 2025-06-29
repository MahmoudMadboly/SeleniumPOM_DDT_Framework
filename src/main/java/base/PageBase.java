package base;

import org.openqa.selenium.WebElement;

public class PageBase {
	
	public void clickOnElement(WebElement element) {
		
		element.click();
		
	}
	
	public void sendKeysToField(WebElement element , String text) {
		
		element.sendKeys(text);
		
	}

	
}