package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.annotations.Test;

import base.TestBase;
import config.ConfigReader;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PaymentPage;
import pages.QartPage;
import pages.RegisterUserPage;
import pages.SignUp_AccountInformationPage;

public class PlaceOrder_LoginBeforeCheckoutTC extends TestBase{

	HomePage homePageObject;
	QartPage QartPageObject;
	RegisterUserPage signUpObject;
	LoginPage LoginPageObject;
	SignUp_AccountInformationPage accountInfoObject;
	CheckoutPage CheckoutPageObject;
	PaymentPage PaymentPageObject;

	int time = 10;


	@Test
	public void PlaceOrder_LoginBeforeCheckoutScenario() {

		try {

			homePageObject = new HomePage(driver);

			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");

			homePageObject.navigateToSignUpScreen(Duration.ofSeconds(time));

			LoginPageObject.enterUserMail(ConfigReader.getConfigValue("validUserName"));

			LoginPageObject.enterAccountPass(ConfigReader.getConfigValue("validPassword"));

			LoginPageObject.clickLogin(Duration.ofSeconds(time));

			homePageObject.addProductToCart(Duration.ofSeconds(time));

			homePageObject.clickOnContinueShoppingButton();

			homePageObject.navigateToQartScreen(Duration.ofSeconds(time));

			QartPageObject = new QartPage(driver);

			assertTrue(QartPageObject.verifyShoppingCartHeaderVisible());


			QartPageObject.clickOnproceedToCheckOutButton(Duration.ofSeconds(time));


			CheckoutPageObject = new CheckoutPage(driver);

			assertTrue(CheckoutPageObject.verifyAddressDetailsHeaderIsDiaplyed(),
					"It seems the checkout screen did not displayed");

			assertTrue(CheckoutPageObject.verifyDeliveryAddressTableIsDiaplyed(),
					"It seems delivery address table is not displayed");

			assertTrue(CheckoutPageObject.verifyBillingAddressTableIsDiaplyed(),
					"It seems billing address table is not displayed");

			assertTrue(CheckoutPageObject.verifyreviewYourOrderTableIsDiaplyed(),
					"It seems revie your order table is not displayed");

			CheckoutPageObject.addCommentAboutTheOrder(ConfigReader.getConfigValue("commentAboutOrder"));

			CheckoutPageObject.clickOnPlaceOrderButton(Duration.ofSeconds(time));

			PaymentPageObject = new PaymentPage(driver);

			PaymentPageObject.verifyPaymentHeaderIsDiaplyed();

			PaymentPageObject.enterNameOnCard(ConfigReader.getConfigValue("nameOnCard"));

			PaymentPageObject.enterCardNumber(ConfigReader.getConfigValue("cardNumber"));

			PaymentPageObject.enterCVC(ConfigReader.getConfigValue("CVC"));

			PaymentPageObject.enterExpirationMonth(ConfigReader.getConfigValue("monthOfExpiration"));

			PaymentPageObject.enterExpirationYear(ConfigReader.getConfigValue("yearOfExpiration"));

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

			System.out.println("it seems some issues happened during place order-Login before checkout test case! ");	

		}
	}
}