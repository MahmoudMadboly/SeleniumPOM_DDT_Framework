package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.annotations.Test;

import base.TestBase;
import config.ConfigReader;
import pages.AllProductsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.QartPage;
import pages.SearchedProductPage;

public class AddReviewOnProductTC extends TestBase{

	HomePage homePageObject;
	AllProductsPage allProductObject;
	ProductDetailsPage ProductDetailsPageObject;

	int time = 10;


	@Test
	public void AddReviewOnProductScenario() {

		try {

			homePageObject = new HomePage(driver);

			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");
			
			homePageObject.navigateToAllProductsScreen(Duration.ofSeconds(time));
			
			allProductObject = new AllProductsPage(driver);

			assertTrue(allProductObject.verifyAllProductsHeaderVisible(), 
					"It seems brand list is not visible.");

			
			allProductObject.clickViewProduct(Duration.ofSeconds(time));
			
			ProductDetailsPageObject = new ProductDetailsPage(driver);
			
			assertTrue(ProductDetailsPageObject.verifyWriteYourReviewVisible(),
					"It seems write your review is not visible.");
			
			ProductDetailsPageObject.setReviewerEmail(ConfigReader.getConfigValue("reviewer_Name"));
			
			ProductDetailsPageObject.setReviewerEmail(ConfigReader.getConfigValue("reviewer_Email"));
			
			ProductDetailsPageObject.setReviewerComment(ConfigReader.getConfigValue("review"));
			
			ProductDetailsPageObject.submitReview();
			
			assertEquals(ProductDetailsPageObject.verifyAddReviewSuccessMessage(),
					ConfigReader.getConfigValue("addReviewSuccessNessage"),
					"It seems add review scenario failed");
			
			
	
		}catch(Exception e) {

			e.printStackTrace();

			System.out.println("Error message/   " + e.getMessage());

			System.out.println("it seems some issues happened during view category product test case! ");	

		}
	}	
}