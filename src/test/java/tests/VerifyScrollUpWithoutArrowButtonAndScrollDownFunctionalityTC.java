package tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.annotations.Test;

import base.TestBase;
import config.ConfigReader;
import io.opentelemetry.api.internal.ConfigUtil;
import pages.AllProductsPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.PaymentPage;
import pages.QartPage;
import pages.RegisterUserPage;
import pages.SignUp_AccountInformationPage;

public class VerifyScrollUpWithoutArrowButtonAndScrollDownFunctionalityTC extends TestBase{
	
	
	HomePage homePageObject;
	AllProductsPage allProductObject;
	QartPage QartPageObject;
	RegisterUserPage signUpObject;
	SignUp_AccountInformationPage accountInfoObject;
	CheckoutPage CheckoutPageObject;
	PaymentPage PaymentPageObject;

	int time = Integer.parseInt(ConfigReader.getConfigValue("globalWaitTime"));

	//TC26
	// Done
	@Test(groups = {"regression"}) 
	public void VerifyScrollUpWithoutArrowButtonAndScrollDownFunctionalityScenario() {

		try {

			homePageObject = new HomePage(driver);

			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");
			
			homePageObject.scrollToSubscribeField();
			
			assertTrue(homePageObject.verifySubscriptionFieldIsVisible(), 
					"Subscription mail field is not visible.");
		
			homePageObject.scrollUpWithoutArrowButton();
			
			homePageObject.waitTillHomePageHeaderBeDisplayed(Duration.ofSeconds(time));
			
			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");
		


		}catch(Exception e) {

			e.printStackTrace();

			System.out.println("Error message/   " + e.getMessage());

			System.out.println("it seems some issues happened during Verify Scroll Up without 'Arrow' button and Scroll Down functionality Scenario! ");	

		}
	}	

}