package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.PageBase;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {

		super(driver);

	}


	//locate webelements
	public By automationExcersieHeader = By.xpath("//h2 [text() = 'Full-Fledged practice website for Automation Engineers']");

	By testCaseButton = By.linkText("/test_cases");

	By productsCaseButton = By.linkText("/products");

	By signUpButton = By.partialLinkText("Signup");

	public static By SuccessfulLoginHeader = By.xpath("//h2 [text() = 'Full-Fledged practice website for Automation Engineers']");

	By logOutButton = By.linkText(" Logout");

	By contactUsButton = By.partialLinkText("Contact us");
	
	By testCasesButton = By.partialLinkText("Test Cases");
	
	By ProductsButton = By.partialLinkText("Products");



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
}