package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.annotations.Test;

import base.PageBase;
import base.TestBase;
import config.ConfigReader;
import pages.HomePage;
import pages.RegisterUserPage;
import pages.SignUp_AccountInformationPage;

public class RegisterWithExistingMailTC extends TestBase{


	HomePage homePageObject;
	RegisterUserPage signUpObject;
	SignUp_AccountInformationPage accountInfoObject;
	int time = Integer.parseInt(ConfigReader.getConfigValue("globalWaitTime"));	

//TC 5
	//Done
	
	@Test(groups = {"regression"})
	public void registerWithExistingMailScenario() throws InterruptedException{

		try {

			homePageObject = new HomePage(driver);

			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");

			homePageObject.navigateToSignUpScreen(Duration.ofSeconds(time));

			signUpObject = new RegisterUserPage(driver);

			signUpObject.waitTillSignUpScreenLoaded(Duration.ofSeconds(time));

			assertTrue(signUpObject.verifySignUpPageHeaderVisible(),
					"It seems that SignUp Page Header is not visible");

			signUpObject.enterUserName(ConfigReader.getConfigValue("existingAccountUserName"));

			signUpObject.enterEmailAdress(ConfigReader.getConfigValue("existingAccountMail"));

			signUpObject.clickSignUp();

			//add wait logic 
			signUpObject.waitDublicationMessage(Duration.ofSeconds(time));

			assertEquals(signUpObject.getMailDublicationMessageText(), 
					ConfigReader.getConfigValue("emailDublicationMessage"),
					"It seems that Register With Existing Mail is failed");


		}catch(Exception e) {

			e.printStackTrace();

			System.out.println("Error message/   " + e.getMessage());

			System.out.println("it seems some issues happened during Register With Existing Mail scenario");

		}
	}
}