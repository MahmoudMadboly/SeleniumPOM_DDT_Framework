package tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.annotations.Test;

import base.TestBase;
import config.ConfigReader;
import pages.HomePage;
import pages.LoginPage;

public class LogOutTC extends TestBase{

	LoginWithValidUserTC loginObject;
	HomePage homePageObject;
	LoginPage loginPageObject;
	int time = Integer.parseInt(ConfigReader.getConfigValue("globalWaitTime"));

	//TC 4
	//Done
	@Test(groups = {"regression"})
	public void LogOUT() {


		try {

			homePageObject = new HomePage(driver);

			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");

			homePageObject.navigateToSignUpScreen(Duration.ofSeconds(time));

			loginPageObject = new LoginPage(driver);

			loginPageObject.waitTillLoginScreenLoaded(Duration.ofSeconds(time));

			assertTrue(loginPageObject.verifyLoginToAccountHeaderVisible(), 
					ConfigReader.getConfigValue("logInScreenHeader"));


			loginPageObject.enterUserMail(ConfigReader.getConfigValue("LogOutUser_validUserName"));

			loginPageObject.enterAccountPass(ConfigReader.getConfigValue("LogOutUser_validPassword"));

			loginPageObject.clickLogin();

			loginPageObject.waitInCaseLoginWithvalidCredentials(Duration.ofSeconds(time));



			assertTrue(homePageObject.verifytSuccessfulLoginHeaderVisible(), 
					"it seems login did not happen successfully");


			homePageObject.navigateToLogOut(Duration.ofSeconds(time));


			assertTrue(loginPageObject.verifyLoginToAccountHeaderVisible(), 
					"it seems that login to account header is not displayed");



		}catch (Exception e) {


			e.printStackTrace();

			System.out.println("Error message/   " + e.getMessage());

			System.out.println("it seems some issues happened during logout test case! ");	

		}
	}
}