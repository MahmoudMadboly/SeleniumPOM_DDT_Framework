package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PageBase;

public class SearchedProduct extends PageBase{
	
	public SearchedProduct(WebDriver driver) {

		super(driver);

	}
	
	By searchedProduct = By.xpath("//h2 [text() = 'Searched Products']");

}