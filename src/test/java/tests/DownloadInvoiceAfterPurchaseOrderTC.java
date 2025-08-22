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

public class DownloadInvoiceAfterPurchaseOrderTC extends TestBase{

	
	HomePage homePageObject;
	AllProductsPage allProductObject;
	QartPage QartPageObject;

	int time = 10;


	@Test 
	public void downloadInvoiceAfterPurchaseOrderScenario() {

		try {

			homePageObject = new HomePage(driver);

			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");
			
			homePageObject.addProductToCart(Duration.ofSeconds(time));
			
			homePageObject.navigateToQartScreen(Duration.ofSeconds(time));
			
			QartPageObject = new QartPage(driver);

			assertTrue(QartPageObject.verifyShoppingCartHeaderVisible());
			
			QartPageObject.clickOnproceedToCheckOutButton(Duration.ofSeconds(time));
			
			homePageObject.navigateToSignUpScreen(Duration.ofSeconds(time));

			//start from step 9


		}catch(Exception e) {

			e.printStackTrace();

			System.out.println("Error message/   " + e.getMessage());

			System.out.println("it seems some issues happened during verify address details in checkout page Scenario! ");	

		}
	}
	
}