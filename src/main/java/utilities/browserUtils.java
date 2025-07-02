package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class browserUtils {

	
	
	JavascriptExecutor js;
	
	public void scrollIntoView(WebDriver driver , WebElement element) {
		
		js = (JavascriptExecutor) driver;
		
	
		
	}
	
	public void scrollByPixels(WebDriver driver, int pixels) {
		
        js = (JavascriptExecutor) driver;
        
        js.executeScript("window.scrollBy(0," + pixels + ")");
    }
}