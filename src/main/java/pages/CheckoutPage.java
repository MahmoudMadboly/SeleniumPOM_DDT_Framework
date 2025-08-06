package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PageBase;

public class CheckoutPage extends PageBase{
	
	
	public CheckoutPage(WebDriver driver) {
		
		super(driver);
		
	}
	
	
	By AddressDetailsHeader = By.xpath("//h2 [text() = 'Address Details']");
	
	
	public boolean verifyAddressDetailsHeaderIsDiaplyed() {

		return super.getWebElemnt(AddressDetailsHeader).isDisplayed();


	}

}