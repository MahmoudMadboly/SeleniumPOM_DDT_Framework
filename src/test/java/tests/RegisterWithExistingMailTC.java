package tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.testng.annotations.Test;

import base.PageBase;
import base.TestBase;
import config.ConfigReader;
import pages.HomePage;
import pages.RegisterUserPage;
import pages.SignUp_AccountInformationPage;

public class RegisterWithExistingMailTC extends TestBase{
	
	PageBase pageBaseObject;
	HomePage homePageObject;
	RegisterUserPage signUpObject;
	SignUp_AccountInformationPage accountInfoObject;
	int time = 7;	


	@Test
	public void signUp() throws InterruptedException{
		
		try {
	
			homePageObject = new HomePage(driver);

			homePageObject.openSignUpScreen();

			signUpObject = new RegisterUserPage(driver);

			signUpObject.wait(Duration.ofSeconds(time));

			signUpObject.enterUserName(ConfigReader.getConfigValue("accountUserName"));

			signUpObject.enterEmailAdress(ConfigReader.getConfigValue("accountMail"));

			signUpObject.clickSignUp();
			
			//add wait logic 
			
			if(signUpObject.getMailDublicationMessageText().equals(ConfigReader.getConfigValue("emailDublicationMessage"))) {
				
				System.out.println("Email Address already exist!");
				
				return;
			
			} else
				
				System.out.println("It seems there is an issue as the dublication error did not displayed");
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
			System.out.println("Error message/   " + e.getMessage());
			
			System.out.println("it seems some issues happened during account creation! ");
			
		}
	}
}