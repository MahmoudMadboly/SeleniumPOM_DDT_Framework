package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.TestBase;
import config.ConfigReader;
import listnener.Testlistner;
import pages.AllProductsPage;
import pages.HomePage;
import pages.QartPage;
import utilities.browserUtils;


@Listeners(Testlistner.class)
public class AddProductInCartTC extends TestBase{


	HomePage homePageObject;
	AllProductsPage allProductObject;
	QartPage QartPageObject;
	int time = Integer.parseInt(ConfigReader.getConfigValue("globalWaitTime"));

//TC 12
	//done
	
	@Test(groups = {"regression"})
	public void AddProductInCartScenario() {

		try {

			homePageObject = new HomePage(driver);

			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");

			homePageObject.navigateToAllProductsScreen(Duration.ofSeconds(time));


			allProductObject = new AllProductsPage(driver);

			allProductObject.scrollToFirstElement();

			allProductObject.waitSomeTimeTillFirstProductsBeVisible(Duration.ofSeconds(time));

			allProductObject.hoverOnFirstElement();

			allProductObject.clickAddProductToCart_1(Duration.ofSeconds(time));

			allProductObject.clickContinueShoppingButton();

			allProductObject.scrollToSecondElement();

			allProductObject.waitSomeTimeTillSecondProductsBeVisible(Duration.ofSeconds(time));

			allProductObject.hoverOnSecondElement();

			allProductObject.clickAddProductToCart_2(Duration.ofSeconds(time));

			allProductObject.clickViewCartButton(Duration.ofSeconds(time));

			QartPageObject = new QartPage(driver);

			//verify the products added to the cart
			assertEquals(QartPageObject.VerifyQartProducts(), Integer.parseInt(ConfigReader.getConfigValue("tableSize")));



		}catch(Exception e) {

			e.printStackTrace();

			System.out.println("Error message/   " + e.getMessage());

			System.out.println("it seems some issues happened during verifying add product in cart test case! ");	

		}
	}

}