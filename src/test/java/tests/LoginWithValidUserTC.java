package tests;

import static org.testng.Assert.assertEquals;
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
	int time = Integer.parseInt(ConfigReader.getConfigValue("globalWaitTime"));
	
	//TC 2
	//Done
	@Test(groups = {"regression"})
	public void LoginWithValidUserCredentials() {
		
		
		try {
			
			homePageObject = new HomePage(driver);
			
			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");
			
			homePageObject.navigateToSignUpScreen(Duration.ofSeconds(time));
		
			loginPageObject = new LoginPage(driver);
			
			loginPageObject.waitTillLoginScreenLoaded(Duration.ofSeconds(time));
			
			assertTrue(loginPageObject.verifyLoginToAccountHeaderVisible(), 
					ConfigReader.getConfigValue("logInScreenHeader"));
			
			
			loginPageObject.enterUserMail(ConfigReader.getConfigValue("accountMail"));
			
			loginPageObject.enterAccountPass(ConfigReader.getConfigValue("accountPass"));
			
			loginPageObject.clickLogin();
			
			loginPageObject.waitInCaseLoginWithvalidCredentials(Duration.ofSeconds(time));
			
			assertEquals(homePageObject.verifyUserLoggedIn().trim(), 
					ConfigReader.getConfigValue("LoginSuccessMessage") + 
					ConfigReader.getConfigValue("accountUserName"),
					"It seems there is an issue with the user credentials");
				
			
			
		}catch (Exception e) {
			
			e.printStackTrace();

			System.out.println("Error message/   " + e.getMessage());

			System.out.println("it seems some issues happened during login with valid credentials Scenario! ");	

		}
	}
}