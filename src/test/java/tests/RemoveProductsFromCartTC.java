package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.annotations.Test;

import base.TestBase;
import config.ConfigReader;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PaymentPage;
import pages.QartPage;
import pages.RegisterUserPage;
import pages.SignUp_AccountInformationPage;

public class RemoveProductsFromCartTC extends TestBase{

	HomePage homePageObject;
	QartPage QartPageObject;
	RegisterUserPage signUpObject;
	LoginPage LoginPageObject;
	SignUp_AccountInformationPage accountInfoObject;
	CheckoutPage CheckoutPageObject;
	PaymentPage PaymentPageObject;

	int time = Integer.parseInt(ConfigReader.getConfigValue("globalWaitTime"));

	//TC 17
	//Done
	@Test(groups = {"regression"})
	public void removeProductsFromCartScenario() {

		try {

			homePageObject = new HomePage(driver);

			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");

			homePageObject.addProductToCart(Duration.ofSeconds(time));

			homePageObject.clickOnContinueShoppingButton();

			homePageObject.navigateToQartScreen(Duration.ofSeconds(time));

			QartPageObject = new QartPage(driver);

			assertTrue(QartPageObject.verifyShoppingCartHeaderVisible());

			QartPageObject.removeElementFromCart(Duration.ofSeconds(time));

			assertTrue(QartPageObject.verifyCartEmpty().
					contains(ConfigReader.getConfigValue("cartEmptyMessage")),
					"It seems that cart is not empty");


		}catch(Exception e) {

			e.printStackTrace();

			System.out.println("Error message/   " + e.getMessage());

			System.out.println("it seems some issues happened during remove a product from cart test case! ");	

		}
	}
}