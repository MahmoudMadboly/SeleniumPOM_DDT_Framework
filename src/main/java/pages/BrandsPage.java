package pages;

import java.net.http.WebSocket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PageBase;

public class BrandsPage extends PageBase{

	public BrandsPage(WebDriver driver) {

		super(driver);

	}


	static By brandCategoryHeader = By.xpath("//h2 [contains(text(),'Brand')]");
	
	By brandProductList = By.xpath("//div [class = 'features_items']");
	
	By brandList = AllProductsPage.brandsCategoryChoices;


	public String verifyNaviagtionToBrandScreen() {

		return driver.getCurrentUrl();

	}

	public int verifyBrandListSize() {

		return getWebElementList(brandProductList).size();

	}
	
	public void selectBrand() {
		
		
		
	}
}