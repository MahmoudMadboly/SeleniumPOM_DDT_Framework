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

public class AddReviewOnProductScenario extends TestBase{


	@Test
	public class AddReviewOnProductTC extends TestBase{

		HomePage homePageObject;
		AllProductsPage allProductObject;
		ProductDetailsPage ProductDetailsPageObject;
		QartPage QartPageObject;

		int time = 10;


		@Test
		public void AddReviewOnProductScenario() {

			try {

				homePageObject = new HomePage(driver);

				assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
						"Home page header is not visible.");


				homePageObject.scrollToBottomOfPage();

				assertTrue(homePageObject.verifyRecommendedItemsVisible(), 
						"It seems that Home page header is not visible.");

				homePageObject.navigateToQartScreen(Duration.ofSeconds(time));

				QartPageObject = new QartPage(driver);


				assertTrue(QartPageObject.VerifyQartProducts() > 0, 
						"It seems that Home page header is not visible.");



			}catch(Exception e) {

				e.printStackTrace();

				System.out.println("Error message/   " + e.getMessage());

				System.out.println("it seems some issues happened during Add Review On Product Scenario! ");	

			}
		}	
	}
}
