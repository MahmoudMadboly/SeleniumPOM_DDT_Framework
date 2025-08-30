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

public class VerifyProductQuantityInCartTC extends TestBase{


	HomePage homePageObject;
	ProductDetailsPage ProductDetailsObject;
	QartPage QartPageObject; 
	int time = Integer.parseInt(ConfigReader.getConfigValue("globalWaitTime"));


	//TC 13
	//Done

	@Test(groups = {"regression"})
	public void VerifyProductQuantityInCartScenario() {

		try {

			homePageObject = new HomePage(driver);

			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");


			homePageObject.clickOnViewProductButton(Duration.ofSeconds(time));

			ProductDetailsObject = new ProductDetailsPage(driver);


			assertTrue(ProductDetailsObject.verifyproductPriceVisible(), 
					"Product price is not visible.");


			ProductDetailsObject.clearQuantityField();

			ProductDetailsObject.setProductQuantity(
					ConfigReader.getConfigValue("productQuantity"));


			ProductDetailsObject.clickOnAddToCartButton();

			ProductDetailsObject.clickOnViewCartButton(Duration.ofSeconds(time));


			QartPageObject = new QartPage(driver);


			assertEquals(QartPageObject.getActualProductQuantity(), 
					ConfigReader.getConfigValue("productQuantity"),
					"It seems product quantity doesn not match the right quantity");



		}catch(Exception e) {

			e.printStackTrace();

			System.out.println("Error message/   " + e.getMessage());

			System.out.println("it seems some issues happened during verifying Product Quantity In Cart test case! ");	

		}
	}

}