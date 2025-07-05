package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.PageBase;
import base.TestBase;
import config.ConfigReader;
import pages.HomePage;
import pages.RegisterUserPage;
import utilities.WaitUtuls;

public class RegisterTC extends TestBase{


	PageBase pageBaseObject;
	HomePage homePageObject;
	RegisterUserPage signUpObject;
	int time = 7;	

	@Test
	public void signUp() throws InterruptedException{

		homePageObject = new HomePage(driver);

		homePageObject.openSignUpScreen();

		signUpObject = new RegisterUserPage(driver);

		signUpObject.wait(Duration.ofSeconds(time));
		
		signUpObject.enterUserName(ConfigReader.getConfigValue("signUpUserName"));

		signUpObject.enterEmailAdress(ConfigReader.getConfigValue("signUpMail"));

		signUpObject.clickSignUp();

	}

}
