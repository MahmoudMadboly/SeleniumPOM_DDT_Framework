package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PageBase;

public class ProductsPage extends PageBase{

	
	public ProductsPage(WebDriver driver) {

		super(driver);

	}
	
	By allProductsHeader = By.xpath("/h2 [text() = 'All Products']");
	
	By viewFirstProduct = By.linkText("/product_details/1");
}
