package tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.annotations.Test;

import base.TestBase;
import config.ConfigReader;
import pages.AllProductsPage;
import pages.BrandsPage;
import pages.HomePage;
import pages.MenCategoryScreenPage;
import pages.WomenCategoryScreenPage;

public class ViewAndCartBrandProductsTC extends TestBase{



	HomePage homePageObject;
	AllProductsPage allProductObject;
	BrandsPage brandPageObject;
	int time = Integer.parseInt(ConfigReader.getConfigValue("globalWaitTime"));

	//TC 19
	//Done
	@Test
	public void viewAndCartBrandProductsScenario() {

		try {

			homePageObject = new HomePage(driver);

			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");

			homePageObject.navigateToAllProductsScreen(Duration.ofSeconds(time));

			allProductObject = new AllProductsPage(driver);
			
			assertTrue(allProductObject.verifyBrandsVisible(), 
					"It seems brand list is not visible.");

			allProductObject.getAndLoopInsideBrandsCategoryChoices(ConfigReader.getConfigValue("firstBrandName"),
					Duration.ofSeconds(time));

			brandPageObject = new BrandsPage(driver);


			assertTrue(brandPageObject.verifyNaviagtionToBrandScreen()
					.contains(ConfigReader.getConfigValue("firstBrandName")), 
					"It seems navigation to polo brand screen failed");

			assertTrue(brandPageObject.verifyBrandListSize() > 0, 
					"Ist Case/ It seems there is no relted-brand product");


			brandPageObject.selectBrand(ConfigReader.getConfigValue("secondBrandName") , Duration.ofSeconds(time));

			assertTrue(brandPageObject.verifyNaviagtionToBrandScreen().contains(ConfigReader.getConfigValue("secondBrandName")), 
					"It seems navigation to H&M brand screen failed");

			assertTrue(brandPageObject.verifyBrandListSize() > 0, 
					"2nd case/ It seems there is no relted-brand product");



		}catch(Exception e) {

			e.printStackTrace();

			System.out.println("Error message/   " + e.getMessage());

			System.out.println("it seems some issues happened during View And Cart Brand Products test case! ");	

			throw e;

		}
	}
}
