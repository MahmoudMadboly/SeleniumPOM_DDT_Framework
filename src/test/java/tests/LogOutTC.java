package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.TestBase;
import config.ConfigReader;
import pages.HomePage;
import pages.LoginPage;

public class LogOutTC extends TestBase{

	LoginWithValidUserTC loginObject;
	HomePage homePageObject;
	LoginPage loginPageObject;

	
	@Test
	public void LogOUT() {
		
		loginObject = new LoginWithValidUserTC();
		
		loginObject.LoginWithValidUserCredentials();
		
		homePageObject = new HomePage(driver);
		
		homePageObject.clickLogOut();
		
		
		assertTrue(loginPageObject.verifyLoginToAccountHeaderVisible(), 
				ConfigReader.getConfigValue("logInScreenHeader"));

		
	}
	
}