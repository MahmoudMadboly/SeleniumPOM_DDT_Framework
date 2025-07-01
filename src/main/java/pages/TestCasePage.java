package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PageBase;

public class TestCasePage extends PageBase{

	public TestCasePage(WebDriver driver) {

		super(driver);

	}

	//locate webelements
	By testCasesHeader = By.xpath("//h2 [text() = 'Contact ']");



}