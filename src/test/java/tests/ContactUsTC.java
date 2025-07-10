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

		int time = 5;

	
		@Test
		public void contactUsScenario() {

			try {
				
				homePageObject = new HomePage(driver);
				
				assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
						ConfigReader.getConfigValue("homePageHeading"));
				
				homePageObject.clickContactUs(Duration.ofSeconds(time));
				
				ContactUsPageObject = new ContactUsPage(driver);
				
				ContactUsPageObject.enterContactName(ConfigReader.getConfigValue("contactName"));
				
				ContactUsPageObject.enterContactEmail(ConfigReader.getConfigValue("contactEmail"));
				
				ContactUsPageObject.enterContactSubject(ConfigReader.getConfigValue("contactSubject"));
				
				ContactUsPageObject.enterContactMessage(ConfigReader.getConfigValue("contactMessage"));
				
				ContactUsPageObject.uploadContactFile(ConfigReader.getConfigValue("contactFilePath"));
				
				ContactUsPageObject.clickContactSubmit();
				
				
			}catch(Exception e) {
				
				e.printStackTrace();

				System.out.println("Error message/   " + e.getMessage());

				System.out.println("it seems some issues happened during account creation! ");
				
			}

		}
	}
