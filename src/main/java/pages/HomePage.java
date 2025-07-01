package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PageBase;

public class HomePage extends PageBase{
	
	public HomePage(WebDriver driver) {

		super(driver);

	}

	
	//locate webelements
	By automationExcersieHeader = By.xpath("//h2 [text() = 'Full-Fledged practice website for Automation Engineers']");
	
	By testCaseButton = By.linkText("/test_cases");
	
	By productsCaseButton = By.linkText("/products");
	
	
}