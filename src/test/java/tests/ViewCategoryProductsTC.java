package tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.annotations.Test;

import base.TestBase;
import config.ConfigReader;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MenCategoryScreenPage;
import pages.PaymentPage;
import pages.QartPage;
import pages.RegisterUserPage;
import pages.SignUp_AccountInformationPage;
import pages.WomenCategoryScreenPage;
import pages.MenCategoryScreenPage;

public class ViewCategoryProductsTC extends TestBase{

	HomePage homePageObject;
	WomenCategoryScreenPage WomenCategoryObject;
	MenCategoryScreenPage menCategoryObject;

	int time = Integer.parseInt(ConfigReader.getConfigValue("globalWaitTime"));

	//test case 18
	@Test(groups = {"regression"}) 
	public void viewCategoryProductsScenario() {

		try {

			homePageObject = new HomePage(driver);

			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");

			assertTrue(homePageObject.verifyCategoryVisible(), 
					"It seems category list is not visible.");


			homePageObject.expandWomanCategory();

			homePageObject.getAndLoopInsideWomanCategoryChoices(
					ConfigReader.getConfigValue("womancategoryListchoice") , Duration.ofSeconds(time));

			WomenCategoryObject = new WomenCategoryScreenPage(driver);

			WomenCategoryObject.verifytWomanPageHeaderVisible();
			
			WomenCategoryObject.expandMenCategory();

			WomenCategoryObject.getAndLoopInsideMenCategoryChoices(ConfigReader
					.getConfigValue("mencategoryListchoice"), Duration.ofSeconds(time));

			menCategoryObject = new MenCategoryScreenPage(driver);

			menCategoryObject.verifytMenPageHeaderVisible();


		}catch(Exception e) {

			e.printStackTrace();

			System.out.println("Error message/   " + e.getMessage());

			System.out.println("it seems some issues happened during view category product test case! ");	

		}
	}
}