package tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.annotations.Test;

import base.TestBase;
import config.ConfigReader;
import pages.ContactUsPage;
import pages.HomePage;
import pages.TestCasePage;

public class VerifyTestCasesTC extends TestBase{

	HomePage homePageObject;
	TestCasePage TestCasePageObject;

	int time = 5;


	@Test
	public void verifyTestCasesScreenScenario() {

		try {

			homePageObject = new HomePage(driver);
			
			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					ConfigReader.getConfigValue("homePageHeading"));
			
			homePageObject.navigateToTestCasesScreen(Duration.ofSeconds(time));
			
			TestCasePageObject = new TestCasePage(driver);
			
			TestCasePageObject.verifyTestCasesHeaderVisible();
			
			

		}catch(Exception e) {

			e.printStackTrace();

			System.out.println("Error message/   " + e.getMessage());

			System.out.println("it seems some issues happened during verifying test cases screen creation! ");	

		}	
	}
}

