package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.PageBase;

public class SearchedProductPage extends PageBase{
	
	public SearchedProductPage(WebDriver driver) {

		super(driver);

	}
	
	By searchedProductHeader = By.id("submit_search");
	
	By searchedProductName =  By.xpath("//div[@class='productinfo text-center']/p");
	
	By addToCartButton =  By.xpath("//a[@data-product-id='1']");
	
	By viewCartButton =  By.linkText("View Cart");
	
	
	                  

	
	
	public boolean verifysearchedProductHeaderVisible() {

		return super.getWebElemnt(searchedProductHeader).isDisplayed();

	}
	
	public String getWebElementOfSearchedProductName() {
		
		return getWebElemnt(searchedProductName).getText();
		
	}
	
	public void addProductToCart(Duration time) {
		
	clickOnElement(addToCartButton);
	
	waitForElemnt(time, ExpectedConditions.elementToBeClickable(viewCartButton));
		
	}	
	
	
	public void navigateToCartScreen(Duration time)
	{
		
		clickOnElement(viewCartButton);
		
		waitForElemnt(time, ExpectedConditions.visibilityOfElementLocated(QartPage.shoppingCartHeader));
		
	}
}










