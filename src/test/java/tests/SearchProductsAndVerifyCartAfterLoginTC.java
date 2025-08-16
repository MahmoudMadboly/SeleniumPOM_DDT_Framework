package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.annotations.Test;

import base.TestBase;
import config.ConfigReader;
import pages.AllProductsPage;
import pages.BrandsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.QartPage;
import pages.SearchedProductPage;

public class SearchProductsAndVerifyCartAfterLoginTC extends TestBase{


	HomePage homePageObject;
	AllProductsPage allProductObject;
	SearchedProductPage SearchedProductObject;
	SearchedProductPage SearchedProductPageObject;
	QartPage QartPageObject;
	LoginPage loginPageObject;

	int time = 10;


	@Test
	public void SearchProductsAndVerifyCartAfterLoginScenario() {

		try {

			homePageObject = new HomePage(driver);

			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");

			homePageObject.navigateToAllProductsScreen(Duration.ofSeconds(time));

			allProductObject = new AllProductsPage(driver);

			assertTrue(allProductObject.verifyBrandsVisible(), 
					"It seems brand list is not visible.");

			allProductObject.enterSearchedProductName(ConfigReader.getConfigValue("SearchedProductName"));

			allProductObject.clickOnSearchButton();

			SearchedProductObject = new SearchedProductPage(driver);

			assertTrue(SearchedProductObject.verifysearchedProductHeaderVisible(), 
					"Searched product header is not visible.");

			
			assertTrue(SearchedProductObject.getWebElementOfSearchedProductName()
					.contains(ConfigReader.getConfigValue("SearchedProductName")), 
					"Searched product header is not visible.");
			
			SearchedProductPageObject = new SearchedProductPage(driver);
			
			SearchedProductPageObject.addProductToCart();
			
			SearchedProductPageObject.navigateToCartScreen(Duration.ofSeconds(time));
			
			assertTrue(QartPageObject.verifyShoppingCartHeaderVisible(), 
					"It seems that Qart screen is not visible.");
			
			
			QartPageObject = new QartPage(driver);
			
			assertTrue(QartPageObject.VerifyQartProducts() > 0, 
					"It seems that there is no products in the cart");
			
			QartPageObject.navigateToLoginScreen(Duration.ofSeconds(time));
			
			loginPageObject = new LoginPage(driver);
			
			
			loginPageObject.enterUserMail(ConfigReader.getConfigValue("accountMail"));
			
			loginPageObject.enterAccountPass(ConfigReader.getConfigValue("accountPass"));
			
			loginPageObject.clickLogin(Duration.ofMinutes(time));
			
			assertEquals(homePageObject.verifyUserLoggedIn(), 
					ConfigReader.getConfigValue("LoginSuccessMessage") +
					ConfigReader.getConfigValue("accountUserName"));
			
			
			homePageObject.navigateToQartScreen(Duration.ofSeconds(time));
			
			assertTrue(QartPageObject.verifyShoppingCartHeaderVisible(), 
					"It seems that Qart screen is not visible.");
			
			assertTrue(QartPageObject.VerifyQartProducts() > 0, 
					"It seems that there is no products in the cart");
			
	
		}catch(Exception e) {

			e.printStackTrace();

			System.out.println("Error message/   " + e.getMessage());

			System.out.println("it seems some issues happened during view category product test case! ");	

		}
	}
}
