package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.PageBase;

public class SignUp_AccountInformationPage extends PageBase{


	public SignUp_AccountInformationPage (WebDriver driver) {

		super(driver);

	}


	//locate page elements
	By accountInformationHeader = By.xpath("//b [text() = 'Enter Account Information']");

	By title = By.id("uniform-id_gender1");

	By password = By.id("password");

	By dayList = By.id("days");

	By monthList = By.id("months");

	By yearList = By.id("years");

	By newsLetter = By.id("newsletter");

	By receiveSpecialOffersFromOurPartners = By.id("optin");

	By first_name = By.id("first_name");

	By last_name = By.id("last_name");

	By company = By.id("company");

	By address1 = By.id("address1");

	By address2 = By.id("address2");

	By countryList = By.id("country");

	By state = By.id("state");

	By city = By.id("city");

	By zipCode = By.id("zipcode");

	By mobileNumber = By.id("mobile_number");

	By createAccountButton = By.xpath("//button [text() = 'Create Account']");



	public void selectTitle() {

		clickOnElement(title);

	}

	public void setAccountPassword(String accountPassword) {

		sendKeysToField(password, accountPassword);

	}
	
	
	public void selectDOB(String selectionType , String value) {

		//locate DOB webelements
		WebElement dayListElement = driver.findElement(dayList);
		
		WebElement monthListElement = driver.findElement(monthList);
		
		WebElement yearListElement = driver.findElement(yearList);
		
		
		//select an option from lists
		selectFromDropDownList(dayListElement, selectionType, value);
		
		selectFromDropDownList(monthListElement, selectionType, value);
		
		selectFromDropDownList(yearListElement, selectionType, value);

	}
	
	
	public void checkNewsLetterOption() {
		
		
		clickOnElement(newsLetter);
		
	} 
	
	
public void checkSpecialOfferOption() {
		
		
		clickOnElement(receiveSpecialOffersFromOurPartners);
		
	} 
}












