package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.annotations.Test;

import base.TestBase;
import config.ConfigReader;
import pages.AllProductsPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.QartPage;
import pages.RegisterUserPage;
import pages.SignUp_AccountInformationPage;

public class VerifyAddressDetailsInCheckoutPageTC extends TestBase{


	HomePage homePageObject;
	AllProductsPage allProductObject;
	ProductDetailsPage ProductDetailsPageObject;
	QartPage QartPageObject;
	RegisterUserPage signUpObject;
	SignUp_AccountInformationPage accountInfoObject;


	int time = 10;


	@Test
	public void AddReviewOnProductScenario() {

		try {

			homePageObject = new HomePage(driver);

			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");


			homePageObject.navigateToSignUpScreen(Duration.ofSeconds(time));

			signUpObject = new RegisterUserPage(driver);

			assertTrue(signUpObject.verifySignUpPageHeaderVisible(),
					ConfigReader.getConfigValue("signUpPageHeading"));

			signUpObject.enterUserName(ConfigReader.getConfigValue("accountUserName"));

			signUpObject.enterEmailAdress(ConfigReader.getConfigValue("accountMail"));

			signUpObject.clickSignUp();

			accountInfoObject = new SignUp_AccountInformationPage(driver);

			accountInfoObject.waitTillAccountInfoLoaded(Duration.ofSeconds(time));

			assertTrue(accountInfoObject.verifyEnterAccountInfoHeaderVisible(), 
					ConfigReader.getConfigValue("enterAccountInfoPageHeading"));

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

			assertEquals(accountInfoObject.getSuccessMessageText(), ConfigReader.getConfigValue("accountCreationSuccessMessage"));


			accountInfoObject.clickOnContinueButton(Duration.ofSeconds(time));

			assertEquals(homePageObject.verifyUserLoggedIn(), 
					ConfigReader.getConfigValue("LoginSuccessMessage") + ConfigReader.getConfigValue("accountUserName"));

			allProductObject = new AllProductsPage(driver);

			allProductObject.scrollToFirstElement();

			allProductObject.waitSomeTimeTillFirstProductsBeVisible(Duration.ofSeconds(time));

			allProductObject.hoverOnFirstElement();

			allProductObject.clickAddProductToCart_1(Duration.ofSeconds(time));
			
			allProductObject.clickViewCartButton(Duration.ofSeconds(time));
			
			
			QartPageObject = new QartPage(driver);

			assertTrue(QartPageObject.verifyShoppingCartHeaderVisible());
			
			
			QartPageObject.clickOnproceedToCheckOutButton(Duration.ofSeconds(time));


		}catch(Exception e) {

			e.printStackTrace();

			System.out.println("Error message/   " + e.getMessage());

			System.out.println("it seems some issues happened during Add Review On Product Scenario! ");	

		}
	}	
}