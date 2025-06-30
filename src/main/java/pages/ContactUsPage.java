package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PageBase;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {

		super(driver);

	}


	//locate webelements
	public static By contactUsHeader = By.xpath("//h2 [text() = 'Contact ']");

	By contactName = By.name("email");

	By contactEmail = By.name("email");

	By contactSubject = By.name("email");

	By contactMessage = By.name("email");

	By contactfile = By.name("email");

	By contactSubmit = By.name("email");

	
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

			sendKeysToField(contactSubject, contact_Subject);

		}

	//handle uploading file
		/*
		 * 
		 * public void uploadContactFile() {

		sendKeysToField(contactMessage	, contact_Message);

	}

		 * */
	
	//submit contact request
	public void clickContactSubmit() {

		clickOnElement(contactSubmit);

	}
}