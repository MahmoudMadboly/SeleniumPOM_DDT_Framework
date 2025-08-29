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

	int time = Integer.parseInt(ConfigReader.getConfigValue("globalWaitTime"));

	//TC 7
	//Done
	@Test(groups = {"regression"})
	public void verifyTestCasesScreenScenario() {

		try {

			homePageObject = new HomePage(driver);

			assertTrue(homePageObject.verifytHomePageHeaderVisible(), 
					"Home page header is not visible.");

			homePageObject.navigateToTestCasesScreen(Duration.ofSeconds(time));

			TestCasePageObject = new TestCasePage(driver);

			assertTrue(TestCasePageObject.verifyTestCasesHeaderVisible(), 
					"It seems that test case screen is not displayed!");





		}catch(Exception e) {

			e.printStackTrace();

			System.out.println("Error message/   " + e.getMessage());

			System.out.println("it seems some issues happened during verifying test cases screen creation! ");	

		}	
	}
}

