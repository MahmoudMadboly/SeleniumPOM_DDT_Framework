package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.PageBase;
import base.TestBase;
import config.ConfigReader;
import pages.HomePage;
import pages.RegisterUserPage;

public class RegisterTC extends TestBase{


	PageBase pageBaseObject;
	HomePage homePageObject;
	RegisterUserPage signUpObject;

	
	@Test
	public void signUp() throws InterruptedException{

		homePageObject = new HomePage(driver);
		
		homePageObject.openSignUpScreen();
		
		signUpObject = new RegisterUserPage(driver);
		
		Thread.sleep(5000);
		
		signUpObject.enterUserName(ConfigReader.getConfigValue("signUpUserName"));
		
		signUpObject.enterEmailAdress(ConfigReader.getConfigValue("signUpMail"));
		
		signUpObject.clickSignUp();



	}

}
