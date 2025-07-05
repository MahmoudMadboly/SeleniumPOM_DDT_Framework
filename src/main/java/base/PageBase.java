package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

	protected WebDriver driver;

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


	public WebElement getWebElemnt(By element) {

		return driver.findElement(element);

	}	


}