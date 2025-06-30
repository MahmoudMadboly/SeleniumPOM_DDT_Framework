package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PageBase;

public class LoginClass extends PageBase{


	public LoginClass(WebDriver driver) {

		super(driver);

	}

	//locate webelements
	public static By loginAccountHeader = By.xpath("//h2 [text() = 'Login to your account']");

	By email = By.name("email");

	By password = By.name("password");

	By loginButton = By.xpath("//button [text() = 'Login']");


	//enter mail to login
	public void userMail(String mailAddress) {

		sendKeysToField(email, mailAddress);

	}
	//enter user pass to login
	public void enterAccountPass(String accountPassWord) {

		sendKeysToField(password, accountPassWord);

	}

	//hit login button
	public void clickLogin() {

		clickOnElement(loginButton);

	}
}