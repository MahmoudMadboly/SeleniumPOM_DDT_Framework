package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.annotations.Test;

import base.TestBase;
import config.ConfigReader;
import pages.AllProductsPage;
import pages.CheckoutPage;
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
	CheckoutPage CheckoutPageObject;

	int time = Integer.parseInt(ConfigReader.getConfigValue("globalWaitTime"));

	//TC 23
	//Done
	@Test (groups = {"regression"})
	public void VerifyAddressDetailsInCheckoutPageScenario() {

		try {

			homePageObject = new HomePage(driver);

			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");


			homePageObject.navigateToSignUpScreen(Duration.ofSeconds(time));

			signUpObject = new RegisterUserPage(driver);

			assertTrue(signUpObject.verifySignUpPageHeaderVisible(),
					"It seems that SignUp Page Header is not Visible");

			signUpObject.enterUserName(ConfigReader.getConfigValue("verifyAddressDetailsInCheckoutPage_AccountUserName"));

			signUpObject.enterEmailAdress(ConfigReader.getConfigValue("verifyAddressDetailsInCheckoutPage_accountMail"));

			signUpObject.clickSignUp();

			accountInfoObject = new SignUp_AccountInformationPage(driver);

			accountInfoObject.waitTillAccountInfoLoaded(Duration.ofSeconds(time));

			assertTrue(accountInfoObject.verifyEnterAccountInfoHeaderVisible(), 
					"It seems that Enter Account Info Headeris not Visible");

			accountInfoObject.selectTitle();

			accountInfoObject.setAccountPassword(ConfigReader.getConfigValue("verifyAddressDetailsInCheckoutPage_accountPass"));

			accountInfoObject.selectDayOfBirth(ConfigReader.getConfigValue("verifyAddressDetailsInCheckoutPage_menuSelectionType"), 
					ConfigReader.getConfigValue("verifyAddressDetailsInCheckoutPage_day"));

			accountInfoObject.selectMonthOfBirth(ConfigReader.getConfigValue("verifyAddressDetailsInCheckoutPage_menuSelectionType"), 
					ConfigReader.getConfigValue("verifyAddressDetailsInCheckoutPage_month"));

			accountInfoObject.selectYearOfBirth(ConfigReader.getConfigValue("verifyAddressDetailsInCheckoutPage_menuSelectionType"), 
					ConfigReader.getConfigValue("verifyAddressDetailsInCheckoutPage_year"));

			accountInfoObject.checkNewsLetterOption();

			accountInfoObject.checkSpecialOferOption();

			accountInfoObject.enterAccountFirstName(ConfigReader.getConfigValue("verifyAddressDetailsInCheckoutPage_accountFirstName"));

			accountInfoObject.enterAccountLastName(ConfigReader.getConfigValue("verifyAddressDetailsInCheckoutPage_accountlastName"));

			accountInfoObject.enterAccountCompany(ConfigReader.getConfigValue("verifyAddressDetailsInCheckoutPage_accountCompany"));

			accountInfoObject.enterAccountAdress1(ConfigReader.getConfigValue("verifyAddressDetailsInCheckoutPage_accountAddress1"));

			accountInfoObject.enterAccountAdress2(ConfigReader.getConfigValue("verifyAddressDetailsInCheckoutPage_accountAddress2"));

			accountInfoObject.selectAccountCountry("verifyAddressDetailsInCheckoutPage_menuSelectionType", "verifyAddressDetailsInCheckoutPage_accountCountry");

			accountInfoObject.enterAccountstate(ConfigReader.getConfigValue("verifyAddressDetailsInCheckoutPage_accountState"));

			accountInfoObject.enterAccountCity(ConfigReader.getConfigValue("verifyAddressDetailsInCheckoutPage_accountCity"));

			accountInfoObject.enterAccountZipCode(ConfigReader.getConfigValue("verifyAddressDetailsInCheckoutPage_accountZipCode"));

			accountInfoObject.enterAccountMobileNumber(ConfigReader.getConfigValue("verifyAddressDetailsInCheckoutPage_accountMobNO"));

			accountInfoObject.clickCreateAccountButton();

			accountInfoObject.waitTillSuccessMessageAppear(Duration.ofSeconds(time));

			assertEquals(accountInfoObject.getSuccessMessageText(), 
					ConfigReader.getConfigValue("accountCreationSuccessMessage"),
					"It seems that account creation is failed");


			accountInfoObject.clickOnContinueButton(Duration.ofSeconds(time));


			assertTrue(homePageObject.verifyUserLoggedIn()
					.contains(ConfigReader.getConfigValue("LoginSuccessMessage")), 
					"It seems user did not loged in successfully");


			allProductObject = new AllProductsPage(driver);

			allProductObject.scrollToFirstElement();

			allProductObject.waitSomeTimeTillFirstProductsBeVisible(Duration.ofSeconds(time));

			allProductObject.hoverOnFirstElement();

			allProductObject.clickAddProductToCart_1(Duration.ofSeconds(time));

			allProductObject.clickViewCartButton(Duration.ofSeconds(time));


			QartPageObject = new QartPage(driver);

			assertTrue(QartPageObject.verifyShoppingCartHeaderVisible(),
					"It seems that Shopping Cart Header is not visible");


			QartPageObject.clickOnproceedToCheckOutButton(Duration.ofSeconds(time));

			CheckoutPageObject = new CheckoutPage(driver);



			//verify address 1
			assertTrue(CheckoutPageObject.verifyDeliveryAddress(
					ConfigReader.getConfigValue("verifyAddressDetailsInCheckoutPage_accountAddress1")),
					"It seems address 1 is not matched");

			//verify address 2
			assertTrue(CheckoutPageObject.verifyDeliveryAddress(
					ConfigReader.getConfigValue("verifyAddressDetailsInCheckoutPage_accountAddress2")), 
					"It seems address 2 is not matched");


			//verify address city, state name & postcode 
			assertTrue(CheckoutPageObject.verifyDeliveryAddress(

					ConfigReader.getConfigValue("verifyAddressDetailsInCheckoutPage_accountCity")

					+ " " + ConfigReader.getConfigValue("verifyAddressDetailsInCheckoutPage_accountState")
					+ " " + ConfigReader.getConfigValue("verifyAddressDetailsInCheckoutPage_accountZipCode")

					), 
					"It seems address city, state name & postcode are not matched");


			//verify address country name 
			assertTrue(CheckoutPageObject.verifyDeliveryAddress(
					ConfigReader.getConfigValue("verifyAddressDetailsInCheckoutPage_accountCountry")), 
					"It seems country name is not matched");


		}catch(Exception e) {

			e.printStackTrace();

			System.out.println("Error message/   " + e.getMessage());

			System.out.println("it seems some issues happened during verify address details in checkout page Scenario! ");	

		}
	}	
}