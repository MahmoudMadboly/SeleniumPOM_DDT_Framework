package pages;

import java.net.http.WebSocket;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.PageBase;

public class BrandsPage extends PageBase{

	public BrandsPage(WebDriver driver) {

		super(driver);

	}


	static By brandHeader = By.xpath("//h2[contains(text(),'Brand -')]");

	By brandProductList = By.xpath("//div[@class='features_items']//div[@class='col-sm-4']");

	By brandList = AllProductsPage.brandsCategoryChoices;


	public String verifyNaviagtionToBrandScreen() {

		return getWebElemnt(brandHeader).getText();

	}

	public int verifyBrandListSize() {

		return getWebElementList(brandProductList).size();

	}
	

	public void selectBrand(String targetedBrand , Duration time) {

		List<WebElement> brandChoices = getWebElementList(brandList);

		for(WebElement brand : brandChoices) {

			if(brand.getText().replaceAll("\\(\\d+\\)", "").trim().equalsIgnoreCase(targetedBrand)) {

				brand.click();
				
				waitForElemnt(time, ExpectedConditions.textToBePresentInElementLocated(brandHeader, targetedBrand));
				
				return;

			}	
		} 
		
		throw new NoSuchElementException("Brand '" + targetedBrand + "' not found in brand list.");
		
	}
}











