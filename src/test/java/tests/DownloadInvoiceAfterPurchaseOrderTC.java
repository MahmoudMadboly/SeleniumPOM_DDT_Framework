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
import pages.PaymentPage;
import pages.ProductDetailsPage;
import pages.QartPage;
import pages.RegisterUserPage;
import pages.SignUp_AccountInformationPage;
import utilities.browserUtils;

public class DownloadInvoiceAfterPurchaseOrderTC extends TestBase{


	HomePage homePageObject;
	AllProductsPage allProductObject;
	QartPage QartPageObject;
	RegisterUserPage signUpObject;
	SignUp_AccountInformationPage accountInfoObject;
	CheckoutPage CheckoutPageObject;
	PaymentPage PaymentPageObject;

	int time = Integer.parseInt(ConfigReader.getConfigValue("globalWaitTime"));

//TC 24
	@Test 
	public void downloadInvoiceAfterPurchaseOrderScenario() {

		try {

			homePageObject = new HomePage(driver);

			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");

			homePageObject.addProductToCart(Duration.ofSeconds(time));

			homePageObject.clickOnViewQartButton(Duration.ofSeconds(time));

			QartPageObject = new QartPage(driver);

			assertTrue(QartPageObject.verifyShoppingCartHeaderVisible(), 
					"It seems that cart screen did not diaplyed");

			QartPageObject.clickOnproceedToCheckOutButtonWithoutRegisterOrLogin(Duration.ofSeconds(time));
			
			QartPageObject.clickRegisterOrLoginButton(Duration.ofSeconds(time));
			
			signUpObject = new RegisterUserPage(driver);

			signUpObject.enterUserName(ConfigReader.getConfigValue("DownloadInvoice_accountUserName"));

			signUpObject.enterEmailAdress(ConfigReader.getConfigValue("DownloadInvoice_accountMail"));

			signUpObject.clickSignUp();

			accountInfoObject = new SignUp_AccountInformationPage(driver);

			accountInfoObject.waitTillAccountInfoLoaded(Duration.ofSeconds(time));

			assertTrue(accountInfoObject.verifyEnterAccountInfoHeaderVisible(), 
					ConfigReader.getConfigValue("enterAccountInfoPageHeading"));

			accountInfoObject.selectTitle();

			accountInfoObject.setAccountPassword(ConfigReader.getConfigValue("accountPass"));

			accountInfoObject.selectDayOfBirth(ConfigReader.getConfigValue("DownloadInvoice_menuSelectionType"), 
					ConfigReader.getConfigValue("DownloadInvoice_day"));

			accountInfoObject.selectMonthOfBirth(ConfigReader.getConfigValue("DownloadInvoice_menuSelectionType"), 
					ConfigReader.getConfigValue("DownloadInvoice_month"));

			accountInfoObject.selectYearOfBirth(ConfigReader.getConfigValue("DownloadInvoice_menuSelectionType"), 
					ConfigReader.getConfigValue("DownloadInvoice_year"));

			accountInfoObject.checkNewsLetterOption();

			accountInfoObject.checkSpecialOferOption();

			accountInfoObject.enterAccountFirstName(ConfigReader.getConfigValue("DownloadInvoice_accountFirstName"));

			accountInfoObject.enterAccountLastName(ConfigReader.getConfigValue("DownloadInvoice_accountlastName"));

			accountInfoObject.enterAccountCompany(ConfigReader.getConfigValue("DownloadInvoice_accountCompany"));

			accountInfoObject.enterAccountAdress1(ConfigReader.getConfigValue("DownloadInvoice_accountAddress1"));

			accountInfoObject.enterAccountAdress2(ConfigReader.getConfigValue("DownloadInvoice_accountAddress2"));

			accountInfoObject.selectAccountCountry(
					"DownloadInvoice_menuSelectionType", "DownloadInvoice_AccountCountry");

			accountInfoObject.enterAccountstate(ConfigReader.getConfigValue("DownloadInvoice_accountState"));

			accountInfoObject.enterAccountCity(ConfigReader.getConfigValue("DownloadInvoice_accountCity"));

			accountInfoObject.enterAccountZipCode(ConfigReader.getConfigValue("DownloadInvoice_accountZipCode"));

			accountInfoObject.enterAccountMobileNumber(ConfigReader.getConfigValue("DownloadInvoice_accountMobNO"));

			accountInfoObject.clickCreateAccountButton();

			accountInfoObject.waitTillSuccessMessageAppear(Duration.ofSeconds(time));

			assertEquals(accountInfoObject.getSuccessMessageText(),
					ConfigReader.getConfigValue("accountCreationSuccessMessage"));

			accountInfoObject.clickOnContinueButton(Duration.ofSeconds(time));


			assertTrue(homePageObject.verifyUserLoggedIn()
					.contains(ConfigReader.getConfigValue("LoginSuccessMessage")),
					"It seems login with user name is not matched");
			
		
			
			
			homePageObject.navigateToQartScreen(Duration.ofSeconds(time));
			
			assertTrue(QartPageObject.verifyShoppingCartHeaderVisible(), 
					"It seems that cart screen did not diaplyed");
			
			
			
			
			QartPageObject.clickOnproceedToCheckOutButton(Duration.ofSeconds(time));
			
			CheckoutPageObject = new CheckoutPage(driver);

			assertTrue(CheckoutPageObject.verifyAddressDetailsHeaderIsDiaplyed(),
					"It seems the checkout screen did not displayed");

			assertTrue(CheckoutPageObject.verifyDeliveryAddressTableIsDiaplyed(),
					"It seems delivery address table is not displayed");

			assertTrue(CheckoutPageObject.verifyBillingAddressTableIsDiaplyed(),
					"It seems billing address table is not displayed");

			assertTrue(CheckoutPageObject.verifyreviewYourOrderTableIsDiaplyed(),
					"It seems review your order table is not displayed");
			
			CheckoutPageObject.addCommentAboutTheOrder(ConfigReader.getConfigValue("DownloadInvoice_commentAboutOrder"));

			CheckoutPageObject.clickOnPlaceOrderButton(Duration.ofSeconds(time));
			
			PaymentPageObject = new PaymentPage(driver);

			PaymentPageObject.verifyPaymentHeaderIsDiaplyed();

			PaymentPageObject.enterNameOnCard(ConfigReader.getConfigValue("DownloadInvoice_nameOnCard"));

			PaymentPageObject.enterCardNumber(ConfigReader.getConfigValue("DownloadInvoice_cardNumber"));

			PaymentPageObject.enterCVC(ConfigReader.getConfigValue("DownloadInvoice_CVC"));

			PaymentPageObject.enterExpirationMonth(ConfigReader.getConfigValue("DownloadInvoice_monthOfExpiration"));

			PaymentPageObject.enterExpirationYear(ConfigReader.getConfigValue("DownloadInvoice_yearOfExpiration"));

			PaymentPageObject.clickPayAndConfirmButton();
			
			assertEquals(PaymentPageObject.getplaceOrderSuccessMessageText(),
					ConfigReader.getConfigValue("orderPlacedSuccessMessage"),
					"It seems the place order success messgae is not matched");
			
			PaymentPageObject.waitTillOrdrPlacedHeaderToBeDisplayed(Duration.ofSeconds(time));
			
			PaymentPageObject.downloadInvoice();
			
			PaymentPageObject.verifyInvoiceDownloaded(ConfigReader.getConfigValue("downloadedFilePath"),
					ConfigReader.getConfigValue("fileName"));
			
			PaymentPageObject.continueAfterPayment(Duration.ofSeconds(time));
			
			
			PaymentPageObject.deleteAccount(Duration.ofSeconds(time));

			assertEquals(PaymentPageObject.getAccountDeletedHeaderText(), 
					ConfigReader.getConfigValue("accountDeltedHeader"),
					"It seems the account deleted header text is not matched");
			
		

		}catch(Exception e) {

			e.printStackTrace();

			System.out.println("Error message/   " + e.getMessage());

			System.out.println("it seems some issues happened during Download Invoice After Purchase Order Scenario! ");	

		}
	}

}