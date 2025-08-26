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
	int time = Integer.parseInt(ConfigReader.getConfigValue("globalWaitTime"));
	
	//TC 3
	//Done
	@Test(groups = {"regression"})
	public void loginWithInValidUserCredentialsScenario() {
		
		
		try {
			
			homePageObject = new HomePage(driver);
			
			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");
			
			homePageObject.navigateToSignUpScreen(Duration.ofSeconds(time));
		
			loginPageObject = new LoginPage(driver);
			
			loginPageObject.waitTillLoginScreenLoaded(Duration.ofSeconds(time));
			
			assertTrue(loginPageObject.verifyLoginToAccountHeaderVisible(), 
					ConfigReader.getConfigValue("logInScreenHeader"));
			
			loginPageObject.enterUserMail(ConfigReader.getConfigValue("inValidAccountMail"));
			
			loginPageObject.enterAccountPass(ConfigReader.getConfigValue("inValidePassword"));
			
			loginPageObject.clickLogin();
			
			loginPageObject.waitInCaseLoginWithInvalidCredentials(Duration.ofSeconds(time));
			
			assertTrue(loginPageObject.verifyWrongLoginCredentialMessageHeaderVisible(), 
					ConfigReader.getConfigValue("WrongUserCredentialMessage"));
			
			
			
		}catch (Exception e) {
			
			e.printStackTrace();

			System.out.println("Error message/   " + e.getMessage());

			System.out.println("it seems some issues happened during login With InValid User Credentials Scenario! ");	

		}		
	}
}	