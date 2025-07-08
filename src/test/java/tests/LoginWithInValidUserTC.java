package tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.annotations.Test;

import base.TestBase;
import config.ConfigReader;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterUserPage;

public class LoginWithInValidUserTC extends TestBase{
	
	
	HomePage homePageObject;
	RegisterTC signUpObject;
	LoginPage loginPageObject;
	int time = 5;
	
	
	@Test
	public void LoginWithInValidUserCredentials() {
		
	
		homePageObject = new HomePage(driver);
		
		assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
				ConfigReader.getConfigValue("homePageHeading"));
		
		homePageObject.openSignUpScreen();
	
		loginPageObject = new LoginPage(driver);
		
		loginPageObject.waitTillLoginScreenLoaded(Duration.ofSeconds(time));
		
		loginPageObject.enterUserMail(ConfigReader.getConfigValue("inValidAccountMail"));
		
		loginPageObject.enterAccountPass(ConfigReader.getConfigValue("inValidePassword"));
		
		loginPageObject.clickLogin(Duration.ofMinutes(time));
		
		assertTrue(loginPageObject.verifyWrongLoginCredentialMessageHeaderVisible(), 
				ConfigReader.getConfigValue("WrongUserCredentialMessage"));
			
	}
}	