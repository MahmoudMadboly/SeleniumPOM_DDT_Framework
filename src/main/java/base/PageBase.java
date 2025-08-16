package base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitUtuls;

public class PageBase {

	protected WebDriver driver;

	Actions action;
	
	JavascriptExecutor js;

	public PageBase(WebDriver driver) {

		this.driver = driver;

	} 

	public void clickOnElement(By element) {

		driver.findElement(element).click();

	}


	public void sendKeysToField(By element , String text) {

		driver.findElement(element).sendKeys(text);

	}	


	public void navigateToScreen(By element) {

		clickOnElement(element);

	}


	public void selectFromDropDownList(WebElement element ,String selectionType, String value) {

		Select select = new Select(element);

		switch(selectionType.toLowerCase()) {

		case "value":

			select.selectByValue(value);
			break;


		case "text":

			select.selectByVisibleText(value);
			break;


		case "index":

			select.selectByIndex(Integer.parseInt(value));
			break;

		default:

			throw new IllegalArgumentException("Invalid selection type: " + selectionType);

		}
	}


	//return a single element
	public WebElement getWebElemnt(By element) {

		return driver.findElement(element);

	}


	//return list of elements
	public List<WebElement> getWebElementList(By element) {


		return driver.findElements(element);

	}


	public <T> void waitForElemnt(Duration durationTime , ExpectedCondition<T> condition) {

		WaitUtuls.waitExplicily(driver, durationTime, condition);		

	}

	public void hoverOnElement(WebElement element) {

		action = new Actions(driver);

		action.moveToElement(element).perform();

	}

	public void clearField(By element) {

		driver.findElement(element).clear();

	}
	
	public void clickUsingJavaScript(WebElement element) {
		
		js = (JavascriptExecutor) driver;
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
	}
}