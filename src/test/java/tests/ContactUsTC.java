package tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.annotations.Test;

import base.TestBase;
import config.ConfigReader;
import pages.ContactUsPage;
import pages.HomePage;
import pages.LoginPage;

public class ContactUsTC extends TestBase{


	HomePage homePageObject;
	ContactUsPage ContactUsPageObject; 

	int time = Integer.parseInt(ConfigReader.getConfigValue("globalWaitTime"));

	//TC 6
	//Done
	@Test(groups = {"regression"})
	public void contactUsScenario() {

		try {

			homePageObject = new HomePage(driver);

			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");

			homePageObject.navigateToContactUsScreen(Duration.ofSeconds(time));

			ContactUsPageObject = new ContactUsPage(driver);

			ContactUsPageObject.enterContactName(ConfigReader.getConfigValue("contactName"));

			ContactUsPageObject.enterContactEmail(ConfigReader.getConfigValue("contactEmail"));

			ContactUsPageObject.enterContactSubject(ConfigReader.getConfigValue("contactSubject"));

			ContactUsPageObject.enterContactMessage(ConfigReader.getConfigValue("contactMessage"));

			ContactUsPageObject.uploadContactFile(ConfigReader.getConfigValue("contactFilePath"));

			ContactUsPageObject.clickContactSubmit(Duration.ofSeconds(time));

			ContactUsPageObject.acceptAlert();

			assertTrue(ContactUsPageObject.getSuccessMessageText()
					.contains(ConfigReader.getConfigValue("contactUs_SuccessMessage")), 
					"Contact us success message either not displayed or not correct");


		}catch(Exception e) {

			e.printStackTrace();

			System.out.println("Error message/   " + e.getMessage());

			System.out.println("it seems some issues happened during run contacting us form scenario! ");

		}

	}
}
