package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.PageBase;

public class RegisterUserPage extends PageBase{


	public RegisterUserPage(WebDriver driver) {

		super(driver);

	}

	//locate webelements
	public static By signUpScreenHeader = By.xpath("//h2 [text() = 'New User Signup!']");

	By name = By.name("name");

	By email = By.name("email");

	By signUpButton = By.xpath("//button [text() = 'Signup']");

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

		clickOnElement(signUpButton);

	}
}