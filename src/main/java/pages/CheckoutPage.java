package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.PageBase;

public class CheckoutPage extends PageBase{
	
	
	public CheckoutPage(WebDriver driver) {
		
		super(driver);
		
	}
	
	
	By addressDetailsHeader = By.xpath("//h2 [text() = 'Address Details']");
	
	By yourDeliveryAddressTable = By.id("address_delivery");
	
	By yourBillingAddressTable = By.id("Your billing address");
	
	By reviewYourOrder = By.id("Review Your Order");
	
	By textArea = By.xpath("//textarea [@name = 'message']");
	
	By placeOrderButton = By.xpath("//a [text() = 'Place Order']");
	
	
	public boolean verifyAddressDetailsHeaderIsDiaplyed() {

		return super.getWebElemnt(addressDetailsHeader).isDisplayed();

	}
	
	public boolean verifyDeliveryAddressTableIsDiaplyed() {

		return super.getWebElemnt(yourDeliveryAddressTable).isDisplayed();

	}
	
	
	public boolean verifyBillingAddressTableIsDiaplyed() {

		return super.getWebElemnt(yourBillingAddressTable).isDisplayed();

	}
	
	
	public boolean verifyreviewYourOrderTableIsDiaplyed() {

		return super.getWebElemnt(reviewYourOrder).isDisplayed();

	}
	
	
	public void addCommentAboutTheOrder(String comment) {

		sendKeysToField(textArea, comment);

	}
	
	
	public void clickOnPlaceOrderButton(Duration time) {

		clickOnElement(placeOrderButton);
		
		waitForElemnt(time, ExpectedConditions.presenceOfElementLocated(PaymentPage.paymentHeader));

	}
	
	
	
	
	
}