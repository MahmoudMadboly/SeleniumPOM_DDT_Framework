package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.annotations.Test;

import base.TestBase;
import config.ConfigReader;
import pages.AllProductsPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.TestCasePage;

public class VerifyAllProductsAndProductDetailPageTC extends TestBase{


	HomePage homePageObject;
	AllProductsPage allProductObject;
	ProductDetailsPage ProductDetailsObject;

	int time = Integer.parseInt(ConfigReader.getConfigValue("globalWaitTime"));

	//TC 8
	//Done
	@Test(groups = {"regression"})
	public void verifyAllProductsAndProductDetailPageScenario() {

		try {

			homePageObject = new HomePage(driver);

			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");


			homePageObject.navigateToAllProductsScreen(Duration.ofSeconds(time));

			allProductObject = new AllProductsPage(driver);

			assertTrue(allProductObject.verifyAllProductsHeaderVisible(), 
					"All products page header is not visible.");


			allProductObject.clickViewProduct(Duration.ofSeconds(time));

			ProductDetailsObject = new ProductDetailsPage(driver);


			assertTrue(ProductDetailsObject.verifyProductNameVisible(), 
					"Product name is not visible.");

			assertTrue(ProductDetailsObject.verifyproductCategoryVisible(), 
					"Product category is not visible.");

			assertTrue(ProductDetailsObject.verifyproductPriceVisible(), 
					"Product price is not visible.");

			assertTrue(ProductDetailsObject.verifyproductAvailabilityVisible(), 
					"Product availability is not visible.");

			assertTrue(ProductDetailsObject.verifyproductConditionVisible(), 
					"Product conditions is not visible.");

			assertTrue(ProductDetailsObject.verifyproductBrandVisible(), 
					"Product brand is not visible.");


		}catch(Exception e) {

			e.printStackTrace();

			System.out.println("Error message/   " + e.getMessage());

			System.out.println("it seems some issues happened during verifying All Products and product detail page scenario");	

		}
	}
}