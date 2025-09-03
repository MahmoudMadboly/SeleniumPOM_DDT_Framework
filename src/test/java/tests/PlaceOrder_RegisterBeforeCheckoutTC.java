package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.annotations.Test;

import base.TestBase;
import config.ConfigReader;
import pages.CheckoutPage;
import pages.HomePage;
import pages.PaymentPage;
import pages.QartPage;
import pages.RegisterUserPage;
import pages.SignUp_AccountInformationPage;

public class PlaceOrder_RegisterBeforeCheckoutTC extends TestBase{
	
	HomePage homePageObject;
	QartPage QartPageObject;
	RegisterUserPage signUpObject;
	SignUp_AccountInformationPage accountInfoObject;
	CheckoutPage CheckoutPageObject;
	PaymentPage PaymentPageObject;

	int time = Integer.parseInt(ConfigReader.getConfigValue("globalWaitTime"));

//TC = 15
	@Test
	public void PlaceOrder_RegisterBeforeCheckoutScenario() {

		try {

			homePageObject = new HomePage(driver);

			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");
			
			homePageObject.navigateToSignUpScreen(Duration.ofSeconds(time));
			
			signUpObject = new RegisterUserPage(driver);

			signUpObject.enterUserName(ConfigReader.getConfigValue("registerbeforeCheckout_accountUserName"));

			signUpObject.enterEmailAdress(ConfigReader.getConfigValue("registerbeforeCheckout_accountMail"));

			signUpObject.clickSignUp();


			accountInfoObject = new SignUp_AccountInformationPage(driver);

			accountInfoObject.waitTillAccountInfoLoaded(Duration.ofSeconds(time));

			assertTrue(accountInfoObject.verifyEnterAccountInfoHeaderVisible(), 
					ConfigReader.getConfigValue("enterAccountInfoPageHeading"));

			accountInfoObject.selectTitle();

			accountInfoObject.setAccountPassword(ConfigReader.getConfigValue("registerbeforeCheckout_accountPass"));

			accountInfoObject.selectDayOfBirth(ConfigReader.getConfigValue("registerbeforeCheckout_menuSelectionType"), 
					ConfigReader.getConfigValue("registerbeforeCheckout__day"));

			accountInfoObject.selectMonthOfBirth(ConfigReader.getConfigValue("registerbeforeCheckout_menuSelectionType"), 
					ConfigReader.getConfigValue("registerbeforeCheckout_month"));

			accountInfoObject.selectYearOfBirth(ConfigReader.getConfigValue("registerbeforeCheckout_menuSelectionType"), 
					ConfigReader.getConfigValue("registerbeforeCheckout_year"));

			accountInfoObject.checkNewsLetterOption();

			accountInfoObject.checkSpecialOferOption();

			accountInfoObject.enterAccountFirstName(ConfigReader.getConfigValue("registerbeforeCheckout_accountFirstName"));

			accountInfoObject.enterAccountLastName(ConfigReader.getConfigValue("registerbeforeCheckout_accountlastName"));

			accountInfoObject.enterAccountCompany(ConfigReader.getConfigValue("registerbeforeCheckout_accountCompany"));

			accountInfoObject.enterAccountAdress1(ConfigReader.getConfigValue("registerbeforeCheckout_accountAddress1"));

			accountInfoObject.enterAccountAdress2(ConfigReader.getConfigValue("registerbeforeCheckout_accountAddress2"));

			accountInfoObject.selectAccountCountry(ConfigReader.getConfigValue("registerbeforeCheckout_menuSelectionType"),
					ConfigReader.getConfigValue("registerbeforeCheckout_accountCountry"));

			accountInfoObject.enterAccountstate(ConfigReader.getConfigValue("registerbeforeCheckout_accountState"));

			accountInfoObject.enterAccountCity(ConfigReader.getConfigValue("registerbeforeCheckout_accountCity"));

			accountInfoObject.enterAccountZipCode(ConfigReader.getConfigValue("registerbeforeCheckout_accountZipCode"));

			accountInfoObject.enterAccountMobileNumber(ConfigReader.getConfigValue("registerbeforeCheckout_accountMobNO"));

			accountInfoObject.clickCreateAccountButton();

			accountInfoObject.waitTillSuccessMessageAppear(Duration.ofSeconds(time));

			assertEquals(accountInfoObject.getSuccessMessageText(),
					ConfigReader.getConfigValue("accountCreationSuccessMessage"));

			accountInfoObject.clickOnContinueButton(Duration.ofSeconds(time));
			

			assertTrue(homePageObject.verifyUserLoggedIn()
					.contains(ConfigReader.getConfigValue("LoginSuccessMessage")),
					"It seems login with user name is not matched");
			
		
			homePageObject.addProductToCart(Duration.ofSeconds(time));

			homePageObject.clickOnContinueShoppingButton();

			homePageObject.navigateToQartScreen(Duration.ofSeconds(time));

			QartPageObject = new QartPage(driver);

			assertTrue(QartPageObject.verifyShoppingCartHeaderVisible());
			

			QartPageObject.clickOnproceedToCheckOutButtonWithoutRegisterOrLogin(Duration.ofSeconds(time));

			CheckoutPageObject = new CheckoutPage(driver);

			assertTrue(CheckoutPageObject.verifyAddressDetailsHeaderIsDiaplyed(),
					"It seems the checkout screen did not displayed");

			assertTrue(CheckoutPageObject.verifyDeliveryAddressTableIsDiaplyed(),
					"It seems delivery address table is not displayed");

			assertTrue(CheckoutPageObject.verifyBillingAddressTableIsDiaplyed(),
					"It seems billing address table is not displayed");

			assertTrue(CheckoutPageObject.verifyreviewYourOrderTableIsDiaplyed(),
					"It seems revie your order table is not displayed");
			
			CheckoutPageObject.addCommentAboutTheOrder(ConfigReader
					.getConfigValue("registerbeforeCheckout_commentAboutOrder"));

			CheckoutPageObject.clickOnPlaceOrderButton(Duration.ofSeconds(time));
			
			PaymentPageObject = new PaymentPage(driver);

			PaymentPageObject.verifyPaymentHeaderIsDiaplyed();

			PaymentPageObject.enterNameOnCard(ConfigReader.getConfigValue("registerbeforeCheckout_nameOnCard"));

			PaymentPageObject.enterCardNumber(ConfigReader.getConfigValue("registerbeforeCheckout_cardNumber"));

			PaymentPageObject.enterCVC(ConfigReader.getConfigValue("registerbeforeCheckout_CVC"));

			PaymentPageObject.enterExpirationMonth(ConfigReader.getConfigValue("registerbeforeCheckout_monthOfExpiration"));

			PaymentPageObject.enterExpirationYear(ConfigReader.getConfigValue("registerbeforeCheckout_yearOfExpiration"));

			PaymentPageObject.clickPayAndConfirmButton();

			assertEquals(PaymentPageObject.getplaceOrderSuccessMessageText(),
					ConfigReader.getConfigValue("orderPlacedSuccessMessage"),
					"It seems the place order success messgae is not matched");
			
			PaymentPageObject.deleteAccount(Duration.ofSeconds(time));

			assertEquals(PaymentPageObject.getAccountDeletedHeaderText(), 
					ConfigReader.getConfigValue("accountDeltedHeader"),
					"It seems the account deleted header text is not matched");
			
			

		}catch(Exception e) {

			e.printStackTrace();

			System.out.println("Error message/   " + e.getMessage());

			System.out.println("it seems some issues happened during place order-register before checkout test case! ");	

		}
	}
}