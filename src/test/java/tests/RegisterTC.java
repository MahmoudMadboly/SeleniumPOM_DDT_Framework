package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.PageBase;
import base.TestBase;
import config.ConfigReader;
import pages.HomePage;
import pages.RegisterUserPage;
import pages.SignUp_AccountInformationPage;
import utilities.WaitUtuls;

public class RegisterTC extends TestBase{


	PageBase pageBaseObject;
	HomePage homePageObject;
	RegisterUserPage signUpObject;
	SignUp_AccountInformationPage accountInfoObject;
	int time = Integer.parseInt(ConfigReader.getConfigValue("globalWaitTime"));	


	//TC 1
	//Done
	@Test(groups = {"regression"})
	public void signUp() throws InterruptedException{

		try {

			homePageObject = new HomePage(driver);

			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");

			homePageObject.navigateToSignUpScreen(Duration.ofSeconds(time));

			signUpObject = new RegisterUserPage(driver);

			signUpObject.waitTillSignUpScreenLoaded(Duration.ofSeconds(time));

			assertTrue(signUpObject.verifySignUpPageHeaderVisible(),
					"It seems that SignUp Page Header is not displayed");

			signUpObject.enterUserName(ConfigReader.getConfigValue("accountUserName"));

			signUpObject.enterEmailAdress(ConfigReader.getConfigValue("accountMail"));

			signUpObject.clickSignUp();

			accountInfoObject = new SignUp_AccountInformationPage(driver);

			accountInfoObject.waitTillAccountInfoLoaded(Duration.ofSeconds(time));

			assertTrue(accountInfoObject.verifyEnterAccountInfoHeaderVisible(), 
					"It seems that Enter Account Info Header is not displayed");

			accountInfoObject.selectTitle();

			accountInfoObject.setAccountPassword(ConfigReader.getConfigValue("accountPass"));

			accountInfoObject.selectDayOfBirth(ConfigReader.getConfigValue("menuSelectionType"), 
					ConfigReader.getConfigValue("day"));

			accountInfoObject.selectMonthOfBirth(ConfigReader.getConfigValue("menuSelectionType"), 
					ConfigReader.getConfigValue("month"));

			accountInfoObject.selectYearOfBirth(ConfigReader.getConfigValue("menuSelectionType"), 
					ConfigReader.getConfigValue("year"));

			accountInfoObject.checkNewsLetterOption();

			accountInfoObject.checkSpecialOferOption();

			accountInfoObject.enterAccountFirstName(ConfigReader.getConfigValue("accountFirstName"));

			accountInfoObject.enterAccountLastName(ConfigReader.getConfigValue("accountlastName"));

			accountInfoObject.enterAccountCompany(ConfigReader.getConfigValue("accountCompany"));

			accountInfoObject.enterAccountAdress1(ConfigReader.getConfigValue("accountAddress1"));

			accountInfoObject.enterAccountAdress2(ConfigReader.getConfigValue("accountAddress2"));

			accountInfoObject.selectAccountCountry("value", "India");

			accountInfoObject.enterAccountstate(ConfigReader.getConfigValue("accountState"));

			accountInfoObject.enterAccountCity(ConfigReader.getConfigValue("accountCity"));

			accountInfoObject.enterAccountZipCode(ConfigReader.getConfigValue("accountZipCode"));

			accountInfoObject.enterAccountMobileNumber(ConfigReader.getConfigValue("accountMobNO"));

			accountInfoObject.clickCreateAccountButton();

			accountInfoObject.waitTillSuccessMessageAppear(Duration.ofSeconds(time));

			assertEquals(accountInfoObject.getSuccessMessageText(),
					ConfigReader.getConfigValue("accountCreationSuccessMessage"),
					"It seems that a new account creation is failed");


		}catch(Exception e) {

			e.printStackTrace();

			System.out.println("Error message/   " + e.getMessage());

			System.out.println("it seems some issues happened during account creation scenario! ");

		}
	}
}
