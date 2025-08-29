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

	By cartTable = By.xpath("cart_info_table");

	By tableRows = By.xpath("//table[@id='cart_info_table']//tbody/tr");

	static By productQuantityInTable = By.xpath("//tr[@id='product-1']//td[@class='cart_quantity']/button");

	By subscriptionScuccessMessage = By.xpath("//div [text() = 'You have been successfully subscribed!']");

	By proceedToCheckOutButton = By.xpath("//a [text() = 'Proceed To Checkout']");

	//By checkOutPopUpHeader = By.xpath("//h4 [text() = 'Checkout']");

	By registerOrLoginButton = By.xpath("//p[@class='text-center']/a/u[text()='Register / Login']");
	
	By deletElementButton = By.xpath("//a[@data-product-id='1']");
	
	By cartEmptyMessage = By.xpath("//p[@class='text-center']/b[text()='Cart is empty!']");
	
	By signup_loginButton = HomePage.signUpButton;

	By checkOutPopUpHeader = By.xpath("//h4[@class = 'modal-title w-100' and text() = 'Checkout']") ;


	public void scrollToFooter(String pixel) {

		browserUtils.scrollIntoElementByPixel(driver, pixel);

	}

	public void enteSubscriptionMailID(String subscrMail) {

		sendKeysToField(subscriptionMailField, subscrMail);

	}

	public void clickOnSubscribeButton(Duration time) {

		clickOnElement(subscriptionButton);
		WaitUtuls.waitExplicily(driver, time, ExpectedConditions.visibilityOfElementLocated(subscriptionScuccessMessage));

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

		return getWebElementList(tableRows).size();

	}

	public String getActualProductQuantity() {

		getWebElementList(tableRows);
		return getWebElemnt(productQuantityInTable).getText();

	}
	
	public void clickOnproceedToCheckOutButton(Duration time) {

		clickOnElement(proceedToCheckOutButton);

		waitForElemnt(time, ExpectedConditions.presenceOfElementLocated(CheckoutPage.checkOutPopUpHeader));

	}
	

	public void clickOnproceedToCheckOutButtonWithoutRegisterOrLogin(Duration time) {

		clickOnElement(proceedToCheckOutButton);

		waitForElemnt(time, ExpectedConditions.visibilityOfElementLocated(this.checkOutPopUpHeader));

	}

	

	public void clickRegisterOrLoginButton(Duration time) {

		clickOnElement(registerOrLoginButton);

		waitForElemnt(time, ExpectedConditions.visibilityOfElementLocated(RegisterUserPage.signUpScreenHeader));

	}

	
	public void removeElementFromCart(Duration time) {
		
		clickOnElement(deletElementButton);
		
		waitForElemnt(time, ExpectedConditions.visibilityOfElementLocated(cartEmptyMessage));
		
	}
	
	public String verifyCartEmpty() {
		
		return getWebElemnt(cartEmptyMessage).getText();
		
	}
	
	
public void navigateToLoginScreen(Duration time) {
		
		clickOnElement(signup_loginButton);
		
		waitForElemnt(time, ExpectedConditions.presenceOfElementLocated(LoginPage.loginAccountHeader));
		
	}
}







