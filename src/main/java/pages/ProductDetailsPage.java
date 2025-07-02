package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PageBase;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {

		super(driver);

	}
	
	By productName = By.xpath("//h2 [text() = 'Blue Top']");
	
	By productCategory = By.xpath("//p[contains(text(), 'Category:')]");
	
	By productPrice = By.xpath("//p[contains(text(), 'Rs. ')]");
	
	By productAvailability = By.xpath("//b [text() = 'Availability:']");
	
	By productCondition = By.xpath("//b [text() = 'Condition:']");
	
	By productBrand = By.xpath("//b [text() = 'Brand:']");
	
}




