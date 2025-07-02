package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PageBase;

public class ProductsPage extends PageBase{


	public ProductsPage(WebDriver driver) {

		super(driver);

	}

	By allProductsHeader = By.xpath("//h2 [text() = 'All Products']");

	By viewFirstProduct = By.linkText("/product_details/1");

	By searchField = By.id("search_product");

	By searchFieldButton = By.id("submit_search");


	public void enterSearchCriteria(String searchCriteria) {

		sendKeysToField(searchField, searchCriteria);

	}

	public void clickSearchButton() {

		clickOnElement(searchFieldButton);

	}
}