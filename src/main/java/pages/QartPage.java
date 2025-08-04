package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.PageBase;
import utilities.WaitUtuls;
import utilities.browserUtils;

public class QartPage extends PageBase{


	public QartPage(WebDriver driver) {

		super(driver);

	}


	public static By shoppingCartHeader = By.xpath("//li [text() = 'Shopping Cart']");

	By subscriptionMailField = By.id("susbscribe_email");

	By subscriptionButton = By.id("subscribe");

	By cartTable = By.id("cart_info_table");

	By tableRows = By.xpath("//table[@id='cart_info_table']//tbody/tr");

	static By productQuantityInTable = By.xpath("//tr[@id='product-1']//td[@class='cart_quantity']/button");

	By subscriptionScuccessMessage = By.xpath("//div [text() = 'You have been successfully subscribed!']");



	public void scrollToFooter(String pixel) {

		browserUtils.scrollIntoElementByPixel(driver, pixel);

	}

	public void enteSubscriptionMailID(String subscrMail) {

		sendKeysToField(subscriptionMailField, subscrMail);

	}

	public void clickOnSubscribeButton(Duration time) {

		clickOnElement(subscriptionButton);
		WaitUtuls.waitExplicily(driver, time, ExpectedConditions.visibilityOfAllElementsLocatedBy(subscriptionScuccessMessage));

	}

	public void getSubscribtionMailWebElement() {

		getWebElemnt(subscriptionScuccessMessage);

	}

	public String getWebElementOfSubscriptionSuccessMessage() {

		return getWebElemnt(subscriptionScuccessMessage).getText();

	}

	public boolean verifyShoppingCartHeaderVisible() {

		return super.getWebElemnt(shoppingCartHeader).isDisplayed();
	}

	public int VerifyQartProducts() {

		return getWebElementList(cartTable).size();

	}

	public String getActualProductQuantity() {

		getWebElementList(tableRows);
		return getWebElemnt(productQuantityInTable).getText();

	}
}