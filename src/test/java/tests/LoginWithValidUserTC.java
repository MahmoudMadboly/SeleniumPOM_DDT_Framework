package tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.annotations.Test;

import base.TestBase;
import config.ConfigReader;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterUserPage;

public class LoginWithValidUserTC extends TestBase{
	
	HomePage homePageObject;
	RegisterUserPage signUpObject;
	LoginPage loginPageObject;
	int time = 7;
	
	
	@Test
	public void LoginWithValidUserCredentials() {
		
	
		homePageObject = new HomePage(driver);
		
		assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
				ConfigReader.getConfigValue("homePageHeading"));
		
		homePageObject.openSignUpScreen();
	
		loginPageObject = new LoginPage(driver);
		
		loginPageObject.waitTillLoginScreenLoaded(Duration.ofSeconds(time));
		
		assertTrue(loginPageObject.verifyLoginToAccountHeaderVisible(), 
				ConfigReader.getConfigValue("logInScreenHeader"));
		
		
		loginPageObject.enterUserMail(ConfigReader.getConfigValue("accountMail"));
		
		loginPageObject.enterAccountPass(ConfigReader.getConfigValue("accountPass"));
		
		loginPageObject.clickLogin(Duration.ofMinutes(time));
		
		assertTrue(homePageObject.verifytSuccessfulLoginHeaderVisible(), 
				ConfigReader.getConfigValue("LoginSuccessMessage") + ConfigReader.getConfigValue("accountUserName"));
			
	}
}