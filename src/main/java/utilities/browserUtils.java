package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class browserUtils {



	static JavascriptExecutor js;
	static Actions action;

	public void scrollIntoView(WebDriver driver , WebElement element) {

		js = (JavascriptExecutor) driver;

		//js.executeScript(null, null)

	}

	public static void scrollByPixels(WebDriver driver, String pixels) {

		js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0," + pixels + ")");
	}


	public static void scrollToElement(WebDriver driver , WebElement element) {

		action = new Actions(driver);
		
		action.moveToElement(element).perform();

	}
}