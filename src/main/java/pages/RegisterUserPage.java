package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.PageBase;
import utilities.WaitUtuls;

public class RegisterUserPage extends PageBase{


	public RegisterUserPage(WebDriver driver) {

		super(driver);

	}



	//locate webelements
	public static By signUpScreenHeader = By.xpath("//h2 [text() = 'New User Signup!']");

	By name = By.name("name");

	By email = By.xpath("//input[@data-qa='signup-email']");

	By signUpButton = By.xpath("//button [text() = 'Signup']");

	public By mailDublicationMessage = By.xpath("//p [text() = 'Email Address already exist!']");



	public String getMailDublicationMessageText() {

		return getWebElemnt(mailDublicationMessage).getText();

	}
	
	
	public boolean verifySignUpPageHeaderVisible() {

		return super.getWebElemnt(signUpScreenHeader).isDisplayed();
		

	}


	//wait till DOM be loaded & the required elements be present 
	public void waitTillSignUpScreenLoaded(Duration timeDuration) {
		
		
		super.waitForElemnt(timeDuration,
				ExpectedConditions.presenceOfElementLocated(signUpScreenHeader));


	}


	//enter username to signup
	public void enterUserName(String userName) {

		sendKeysToField(name, userName);

	}


	//enter user mail to signup
	public void enterEmailAdress(String userMail) {

		sendKeysToField(email, userMail);

	}

	//hit sign up button
	public void clickSignUp() {

		super.clickOnElement(signUpButton);	

	}


	//wait till DOM be loaded & the required elements be present 
	public void waitDublicationMessage(Duration timeDuration ) {


		super.waitForElemnt(timeDuration,
				ExpectedConditions.presenceOfElementLocated(mailDublicationMessage));


	}

}