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
import pages.QartPage;

public class AddReviewOnProductTC extends TestBase{


		HomePage homePageObject;
		AllProductsPage allProductObject;
		ProductDetailsPage ProductDetailsPageObject;
		QartPage QartPageObject;

		int time = Integer.parseInt(ConfigReader.getConfigValue("globalWaitTime"));

//TC 21
		//Done
		@Test(groups = {"regression"})
		public void AddReviewOnProductScenario() {

			try {

				homePageObject = new HomePage(driver);

				assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
						"Home page header is not visible.");
				
				homePageObject.navigateToAllProductsScreen(Duration.ofSeconds(time));


				allProductObject = new AllProductsPage(driver);

				allProductObject.scrollToFirstElement();

				allProductObject.waitSomeTimeTillFirstProductsBeVisible(Duration.ofSeconds(time));
				
				allProductObject.clickViewProduct(Duration.ofSeconds(time));
				
				ProductDetailsPageObject = new ProductDetailsPage(driver);
	
				assertTrue(ProductDetailsPageObject.verifyWriteYourReviewVisible(), 
						"It seems that write your review is not visible.");
				
				ProductDetailsPageObject.setReviewerName(ConfigReader.getConfigValue("reviewer_Name"));
				
				ProductDetailsPageObject.setReviewerEmail(ConfigReader.getConfigValue("reviewer_Email"));
				
				ProductDetailsPageObject.setReviewerComment(ConfigReader.getConfigValue("review"));
				
				ProductDetailsPageObject.submitReview(Duration.ofSeconds(time));
				
				assertTrue(ProductDetailsPageObject.verifyAddReviewSuccessMessage().
						contains(ConfigReader.getConfigValue("addReviewSuccessNessage")), 
						"It seems that write review on product scenario is failed!");



			}catch(Exception e) {

				e.printStackTrace();

				System.out.println("Error message/   " + e.getMessage());

				System.out.println("it seems some issues happened during Add Review On Product Scenario! ");	

			}
		}	
	}
