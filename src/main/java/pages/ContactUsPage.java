package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.PageBase;
import utilities.browserUtils;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {

		super(driver);

	}


	//locate webelements
	public static By contactUsHeader = By.xpath("//h2 [text() = 'Contact ']");

	By contactName = By.name("name");

	By contactEmail = By.name("email");

	By contactSubject = By.name("subject");

	By contactMessage = By.id("message");

	By contactfile = By.name("upload_file");

	By contactSubmit = By.name("submit");
	
	By contactUsSuccessMessage = By.xpath("//div[text()='Success! Your details have been submitted successfully.']");

	
//enter contact name
	public void enterContactName(String contact_Name) {

		sendKeysToField(contactName, contact_Name);

	}

	
	//enetr contact mail 
	public void enterContactEmail(String contact_Email) {

		sendKeysToField(contactEmail, contact_Email);

	}

	//enetr the discussion subject
	public void enterContactSubject(String contact_Subject) {

		sendKeysToField(contactSubject, contact_Subject); 

	}
	
	//enetr the discussion message
		public void enterContactMessage(String contact_Subject) {

			sendKeysToField(contactMessage, contact_Subject);

		}

	 public void uploadContactFile(String filePath) {

		sendKeysToField(contactfile	, filePath);
		
		

	}

	
	//submit contact request
	public void clickContactSubmit(Duration time) {

		clickOnElement(contactSubmit);
		
		waitForElemnt(time, ExpectedConditions.alertIsPresent());

	}
	
	
	public void acceptAlert() {
		
		browserUtils.acceptAlert(driver);
		
	}
	
	public String getSuccessMessageText() {
		
		return getWebElemnt(contactUsSuccessMessage).getText();
		
	}
}