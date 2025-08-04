package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.PageBase;
import utilities.WaitUtuls;
import utilities.browserUtils;

public class AllProductsPage extends PageBase{


	public AllProductsPage(WebDriver driver) {

		super(driver);

	}

	public static By allProductsHeader = By.xpath("//h2 [text() = 'All Products']");

	By viewFirstProduct = By.xpath("//div[@class='features_items']//a[@href='/product_details/1' and contains(text(), 'View Product')]");

	By viewSecondProduct = By.xpath("//div[@class='features_items']//a[@href='/product_details/2' and contains(text(), 'View Product')]");

	By addToCartButton_1 = By.xpath("//a[@class='btn btn-default add-to-cart' and contains(text(), 'Add to cart')][1]");
	
	By addToCartButton_2 = By.xpath("//a[@class='btn btn-default add-to-cart' and contains(text(), 'Add to cart')][2]");

	By continueShoppingButton = By.xpath("//button [text() = 'Continue Shopping']");

	By viewCartButton = By.partialLinkText("View Cart");

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

	public void scrollToFirstElement() {

		browserUtils.scrollIntoElement(driver, getWebElemnt(viewFirstProduct));

	}

	public void scrollToSecondElement() {

		browserUtils.scrollIntoElement(driver, getWebElemnt(viewSecondProduct));

	}

	public void hoverOnFirstElement() {

		hoverOnElement(getWebElemnt(viewFirstProduct));

	}

	public void waitSomeTimeTillFirstProductsBeVisible(Duration time) {

		waitForElemnt(time, ExpectedConditions.visibilityOfAllElementsLocatedBy(viewFirstProduct));

	}

	public void waitSomeTimeTillSecondProductsBeVisible(Duration time) {

		waitForElemnt(time, ExpectedConditions.visibilityOfAllElementsLocatedBy(viewSecondProduct));

	}

	public void hoverOnSecondElement() {	

		hoverOnElement(getWebElemnt(viewSecondProduct));

	}

	public void clickAddProductToCart_1(Duration time) {

		clickOnElement(addToCartButton_1);
		waitForElemnt(time, ExpectedConditions.presenceOfElementLocated(continueShoppingButton));

	}	
	
	public void clickAddProductToCart_2(Duration time) {

		clickOnElement(addToCartButton_2);
		waitForElemnt(time, ExpectedConditions.presenceOfElementLocated(continueShoppingButton));

	}	

	public void clickContinueShoppingButton() {

		clickOnElement(continueShoppingButton);

	}


	public void clickViewCartButton(Duration time) {

		clickOnElement(viewCartButton);
		waitForElemnt(time, ExpectedConditions.presenceOfElementLocated(QartPage.shoppingCartHeader));

	}
}