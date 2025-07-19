package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PageBase;
import utilities.browserUtils;

public class QartPage extends PageBase{

	
	public QartPage(WebDriver driver) {

		super(driver);

	}
	
	
	public static By proceedToCheckoutButton = By.xpath("//a [@calss = 'btn btn-default check_out']");
	
	By subscriptionMailField = By.id("susbscribe_email");
	
	By subscriptionButton = By.id("subscribe");
	
	By subscriptionScuccessMessage = By.xpath("//div [calss = 'alert-success alert']");
	
	
	public void scrollToFooter(String pixel) {
		
		browserUtils.scrollByPixels(driver, pixel);
		
	}
	
	public void enteSubscriptionMailID(String subscrMail) {

		sendKeysToField(subscriptionMailField, subscrMail);

	}

	public void clickOnSubscribeButton() {

		clickOnElement(subscriptionButton);

	}

	public void getSubscribtionMailWebElement() {

		getWebElemnt(subscriptionScuccessMessage);

	}
	
	public String getWebElementOfSubscriptionSuccessMessage() {

		return getWebElemnt(subscriptionScuccessMessage).getText();

	}
}