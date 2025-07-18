package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PageBase;

public class SearchedProductPage extends PageBase{
	
	public SearchedProductPage(WebDriver driver) {

		super(driver);

	}
	
	By searchedProductHeader = By.id("submit_search");
	
	By searchedProductName =  By.xpath("//div[@class='productinfo text-center']/p");
	
	                  

	
	
	public boolean verifysearchedProductHeaderVisible() {

		return super.getWebElemnt(searchedProductHeader).isDisplayed();

	}
	
	public String getWebElementOfSearchedProductName() {
		
		return getWebElemnt(searchedProductName).getText();
		
	}
	
	
	
	
}