package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.annotations.Test;

import base.TestBase;
import config.ConfigReader;
import pages.AllProductsPage;
import pages.HomePage;
import pages.QartPage;
import pages.SearchedProductPage;

public class VerifySubscriptionFromQartPageTC extends TestBase{

	
	HomePage homePageObject;
	QartPage QartPageObject; 
	int time = 5;

	

	@Test
	public void subscriptionFromQartPageScenario() {

		try {

			homePageObject = new HomePage(driver);

			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");


			homePageObject.navigateToQartScreen(Duration.ofSeconds(time));
			
			
			QartPageObject = new QartPage(driver);
			
			QartPageObject.scrollToFooter(ConfigReader.getConfigValue("pixel"));
			
			
			QartPageObject.enteSubscriptionMailID(ConfigReader.getConfigValue("subscriptionMailID"));
			
			QartPageObject.clickOnSubscribeButton();

			assertEquals(QartPageObject.getWebElementOfSubscriptionSuccessMessage(), 
					ConfigReader.getConfigValue("subscriptionSuccessfulMessage"));
			
			
		}catch(Exception e) {

			e.printStackTrace();

			System.out.println("Error message/   " + e.getMessage());

			System.out.println("it seems some issues happened during verifying subscription from qart page test case! ");	

		}
	}
}