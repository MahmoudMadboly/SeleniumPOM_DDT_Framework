package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.annotations.Test;

import base.TestBase;
import config.ConfigReader;
import pages.AllProductsPage;
import pages.HomePage;
import pages.SearchedProductPage;

public class VerifySubscriptionFromHomePageTC extends TestBase{

	
	HomePage homePageObject;
	int time = 5;

	

	@Test
	public void subscriptionFromHomePageScenario() {

		try {

			homePageObject = new HomePage(driver);

			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");


			homePageObject.scrollToSubscribeField(ConfigReader.getConfigValue("pixel"));
			
			homePageObject.enteSubscriptionMailID(ConfigReader.getConfigValue("subscriptionMailID"));
				
			homePageObject.clickOnSubscribeButton();

			assertEquals(homePageObject.getWebElementOfSubscriptionSuccessMessage(), 
					ConfigReader.getConfigValue("subscriptionSuccessfulMessage"));
			
			
		}catch(Exception e) {

			e.printStackTrace();

			System.out.println("Error message/   " + e.getMessage());

			System.out.println("it seems some issues happened during verifying subscription from home page test case! ");	

		}
	}
}