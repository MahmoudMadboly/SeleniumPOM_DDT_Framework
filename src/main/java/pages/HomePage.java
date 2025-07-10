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
	
	
	
	public boolean verifytHomePageHeaderVisible() {

		return super.getWebElemnt(automationExcersieHeader).isDisplayed();
		

	}
	
	
	public boolean verifytSuccessfulLoginHeaderVisible() {

		return super.getWebElemnt(SuccessfulLoginHeader).isDisplayed();
		

	}
	
	
	public void openSignUpScreen() {
		
		navigateToScreen(signUpButton);
		
	}
	
public void clickLogOut(Duration time) {
		
		clickOnElement(logOutButton);
		
		waitForElemnt(time, ExpectedConditions.presenceOfElementLocated(RegisterUserPage.signUpScreenHeader));
		
	}
	
	
}