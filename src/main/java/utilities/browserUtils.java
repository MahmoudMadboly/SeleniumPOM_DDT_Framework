package utilities;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class browserUtils {

	static WebDriver driver;
	int time = 5;
	static JavascriptExecutor js;
	static Actions action;
	static Alert alert;

	public static void scrollIntoElement(WebDriver driver , WebElement element) {

		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}


	public static void scrollIntoElementByPixel(WebDriver driver , String pixel) {

		js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0, arguments[0]);", Integer.parseInt(pixel));

	}


	public static void scrollDown(WebDriver driver) {

		js = (JavascriptExecutor) driver;

		// Scroll to top first (optional, to ensure starting from top)
		js.executeScript("window.scrollTo(0, 0);");

		// Get the height of the entire page
		long pageHeight = (long) js.executeScript("return document.body.scrollHeight");

		// Scroll down to the bottom of the page
		js.executeScript("window.scrollTo(0, arguments[0]);", pageHeight);
	}

	public static void scrollup(WebDriver driver) {

		js = (JavascriptExecutor) driver;

		// Scroll to top first (optional, to ensure starting from top)
		js.executeScript("window.scrollTo(0, 0);");

	}


	public static boolean isFileDownloaded(String downloadPath , String fileName) {

		File file = new File(downloadPath + "/" + fileName);

		if(file.exists()) {

			return true;

		}else {

			return false;

		}


	}


	public static void acceptAlert(WebDriver driver) {

		driver.switchTo().alert().accept();

	}
}