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
	int time = 5;


	@Test
	public void LogOUT() {

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

	//	assertTrue(homePageObject.verifytSuccessfulLoginHeaderVisible(), 
			//	ConfigReader.getConfigValue("LoginSuccessMessage") + ConfigReader.getConfigValue("accountUserName"));


		homePageObject.clickLogOut(Duration.ofSeconds(time));


		assertTrue(loginPageObject.verifyLoginToAccountHeaderVisible(), 
				ConfigReader.getConfigValue("logInScreenHeader"));

	}
}