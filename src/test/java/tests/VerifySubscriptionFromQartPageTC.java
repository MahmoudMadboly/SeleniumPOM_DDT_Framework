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


	//TC 11
	//Done
	@Test(groups = {"regression"})
	public void verifySubscriptionFromQartPageScenario() {

		try {

			homePageObject = new HomePage(driver);

			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");


			homePageObject.navigateToQartScreen(Duration.ofSeconds(time));


			QartPageObject = new QartPage(driver);

			assertTrue(QartPageObject.verifyShoppingCartHeaderVisible(), 
					"Shopping Cart page header is not visible.");

			QartPageObject.scrollToFooter(ConfigReader.getConfigValue("pixel"));


			QartPageObject.enteSubscriptionMailID(ConfigReader.getConfigValue("subscriptionMailID"));

			QartPageObject.clickOnSubscribeButton(Duration.ofSeconds(time));

			assertEquals(QartPageObject.getWebElementOfSubscriptionSuccessMessage(), 
					ConfigReader.getConfigValue("subscriptionSuccessfulMessage"),
					"It seems that subscription from cart page is failed");


		}catch(Exception e) {

			e.printStackTrace();

			System.out.println("Error message/   " + e.getMessage());

			System.out.println("it seems some issues happened during verifying subscription from qart page test case! ");	

		}
	}
}