package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.PageBase;
import utilities.browserUtils;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {

		super(driver);

	}


	//locate webelements
	public By automationExcersieHeader = By.xpath("//h2 [text() = 'Full-Fledged practice website for Automation Engineers']");

	By testCaseButton = By.linkText("/test_cases");

	By productsCaseButton = By.linkText("/products");

	By signUpButton = By.partialLinkText("Signup");
	
	By qartButton = By.partialLinkText("Cart");

	public static By SuccessfulLoginHeader = By.xpath("//h2 [text() = 'Full-Fledged practice website for Automation Engineers']");

	By logOutButton = By.linkText(" Logout");

	By contactUsButton = By.partialLinkText("Contact us");

	By testCasesButton = By.partialLinkText("Test Cases");

	By ProductsButton = By.partialLinkText("Products");

	By subscriptionMail = By.id("susbscribe_email");

	By subscriptionScuccessMessage = By.xpath("//div [@class = 'alert-success alert']");

	By subscribeButton = By.id("subscribe");
	
	



	//<div class="alert-success alert">You have been successfully subscribed!</div>


	public boolean verifytHomePageHeaderVisible() {

		return super.getWebElemnt(automationExcersieHeader).isDisplayed();


	}


	public boolean verifytSuccessfulLoginHeaderVisible() {

		return super.getWebElemnt(SuccessfulLoginHeader).isDisplayed();


	}


	public void navigateToSignUpScreen() {

		navigateToScreen(signUpButton);

	}

	public void navigateToLogOut(Duration time) {

		navigateToScreen(logOutButton);	

		waitForElemnt(time, ExpectedConditions.presenceOfElementLocated(RegisterUserPage.signUpScreenHeader));

	}


	public void navigateToContactUsScreen(Duration time) {

		navigateToScreen(contactUsButton);

		waitForElemnt(time, ExpectedConditions.presenceOfElementLocated(ContactUsPage.contactUsHeader));

	}

	public void navigateToTestCasesScreen(Duration time) {

		navigateToScreen(testCasesButton);

		waitForElemnt(time, ExpectedConditions.presenceOfElementLocated(TestCasePage.testCasesHeader));

	}


	public void navigateToAllProductsScreen(Duration time) {

		navigateToScreen(ProductsButton);

		waitForElemnt(time, ExpectedConditions.presenceOfElementLocated(AllProductsPage.allProductsHeader));

	}

	public void enteSubscriptionMailID(String subscrMail) {

		sendKeysToField(subscriptionMail, subscrMail);

	}

	public void clickOnSubscribeButton() {

		clickOnElement(subscribeButton);

	}

	public void getSubscribtionMailWebElement() {

		getWebElemnt(subscriptionMail);

	}


	public void scrollToSubscribeField(String pixel) {

		browserUtils.scrollByPixels(driver, pixel);

	}

	public String getWebElementOfSubscriptionSuccessMessage() {

		return getWebElemnt(subscriptionScuccessMessage).getText();

	}
	
	public void navigateToQartScreen(Duration time) {

		navigateToScreen(qartButton);
		waitForElemnt(time, ExpectedConditions.presenceOfElementLocated(QartPage.shoppingCartHeader));

	}

}