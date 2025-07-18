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
	int time = 7;	


	@Test
	public void signUp() throws InterruptedException{

		try {

			homePageObject = new HomePage(driver);

			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");

			homePageObject.openSignUpScreen();

			signUpObject = new RegisterUserPage(driver);

			signUpObject.waitTillSignUpScreenLoaded(Duration.ofSeconds(time));

			assertTrue(signUpObject.verifySignUpPageHeaderVisible(), ConfigReader.getConfigValue("signUpPageHeading"));

			signUpObject.enterUserName(ConfigReader.getConfigValue("accountUserName"));

			signUpObject.enterEmailAdress(ConfigReader.getConfigValue("accountMail"));

			signUpObject.clickSignUp();

			//add wait logic 
			signUpObject.waitDublicationMessage(Duration.ofSeconds(time));

			assertEquals(signUpObject.getMailDublicationMessageText(), ConfigReader.getConfigValue("emailDublicationMessage"));


		}catch(Exception e) {

			e.printStackTrace();

			System.out.println("Error message/   " + e.getMessage());

			System.out.println("it seems some issues happened during account creation! ");

		}
	}
}