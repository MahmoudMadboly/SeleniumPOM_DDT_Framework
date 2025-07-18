package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PageBase;

public class AllProductsPage extends PageBase{


	public AllProductsPage(WebDriver driver) {

		super(driver);

	}

	public static By allProductsHeader = By.xpath("//h2 [text() = 'All Products']");

	By viewFirstProduct = By.xpath("//a[@href='/product_details/1' and contains(text(), 'View Product')]");

	By searchField = By.id("search_product");

	By searchFieldButton = By.id("submit_search");

	//By searchedProduct = By.xpath("//h2 [text() = 'Searched Products']");


	public void enterSearchCriteria(String searchCriteria) {

		sendKeysToField(searchField, searchCriteria);

	}

	public void clickSearchButton() {

		clickOnElement(searchFieldButton);

	}


	public boolean verifyAllProductsHeaderVisible() {

		return super.getWebElemnt(allProductsHeader).isDisplayed();

	}


	public void clickViewProduct() {

		clickOnElement(viewFirstProduct);

	}

	public void enterSearchedProductName(String productName) {

		sendKeysToField(searchField, productName);

	}
	
	public void clickOnSearchButton() {

		clickOnElement(searchFieldButton);

	}

}