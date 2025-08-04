package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class browserUtils {


	int time = 5;
	static JavascriptExecutor js;
	static Actions action;

	public static void scrollIntoElement(WebDriver driver , WebElement element) {

		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}
	
	
	public static void scrollIntoElementByPixel(WebDriver driver , String pixel) {

		js = (JavascriptExecutor) driver;

		 js.executeScript("window.scrollBy(0, arguments[0]);", Integer.parseInt(pixel));

	}
	
	
}