package tests;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.TestBase;
import config.ConfigReader;
import listnener.Testlistner;
import pages.AllProductsPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchedProductPage;

@Listeners(Testlistner.class)
public class SearchProductTC extends TestBase{

	HomePage homePageObject;
	AllProductsPage allProductObject;
	SearchedProductPage SearchedProductObject;
	int time = Integer.parseInt(ConfigReader.getConfigValue("globalWaitTime"));


	//TC 9
	//Done

	@Test(groups = {"regression"})
	public void SearchedProductScenario() {

		try {

			homePageObject = new HomePage(driver);

			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");


			homePageObject.navigateToAllProductsScreen(Duration.ofSeconds(time));

			allProductObject = new AllProductsPage(driver);

			assertTrue(allProductObject.verifyAllProductsHeaderVisible(), 
					"All products page header is not visible.");


			allProductObject.enterSearchedProductName(ConfigReader.getConfigValue("SearchedProductName"));

			allProductObject.clickOnSearchButton();


			SearchedProductObject = new SearchedProductPage(driver);

			assertTrue(SearchedProductObject.verifysearchedProductHeaderVisible(), 
					"Searched product header is not visible.");

			assertTrue(SearchedProductObject.getWebElementOfSearchedProductName()
					.contains(ConfigReader.getConfigValue("SearchedProductName")), 
					"Searched product header is not visible.");


		}catch(Exception e) {

			e.printStackTrace();

			System.out.println("Error message/   " + e.getMessage());

			System.out.println("it seems some issues happened during verifying searched product test case screen creation! ");	

		}
	}
}