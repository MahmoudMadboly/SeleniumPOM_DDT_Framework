package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.PageBase;

public class LoginPage extends PageBase{


	public LoginPage(WebDriver driver) {

		super(driver);

	}

	//locate webelements
	public static By loginAccountHeader = By.xpath("//h2 [text() = 'Login to your account']");

	By email = By.name("email");

	By password = By.name("password");

	By loginButton = By.xpath("//button [text() = 'Login']");



	public void waitTillLoginScreenLoaded(Duration timeDuration) {


		super.waitForElemnt(timeDuration,
				ExpectedConditions.presenceOfElementLocated(loginAccountHeader));


	}


	//enter mail to login
	public void enterUserMail(String mailAddress) {

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