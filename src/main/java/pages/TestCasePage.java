package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PageBase;

public class TestCasePage extends PageBase{

	public TestCasePage(WebDriver driver) {

		super(driver);

	}

	//locate webelements
	public static By testCasesHeader = By.xpath("//b [text() = 'Test Cases']");
	
	
	public boolean verifyTestCasesHeaderVisible() {

		return super.getWebElemnt(testCasesHeader).isDisplayed();
		

	}
}