package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.PageBase;
import utilities.WaitUtuls;

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

	public By accountCreationSuccess = By.xpath("//b [text() = 'Account Created!']");
	



	public String getSuccessMessageText() {

		return getWebElemnt(accountCreationSuccess).getText();

	}
	
	
	public boolean verifyEnterAccountInfoHeaderVisible() {

		return super.getWebElemnt(accountInformationHeader).isDisplayed();
		

	}
	
	

	public void waitTillAccountInfoLoaded(Duration time) {
		
		
		super.waitForElemnt(time,
				ExpectedConditions.visibilityOfElementLocated(accountInformationHeader));		

	}


	public void selectTitle() {

		clickOnElement(title);

	}

	public void setAccountPassword(String accountPassword) {

		sendKeysToField(password, accountPassword);

	}


	public void selectDayOfBirth(String selectionType , String value) {

		//locate DOB webelements
		WebElement dayListElement = driver.findElement(dayList);


		//select an option from lists
		selectFromDropDownList(dayListElement, selectionType, value);

	}


	public void selectMonthOfBirth(String selectionType , String value) {

		//locate DOB webelements
		WebElement monthListElement = driver.findElement(monthList);


		//select an option from lists

		selectFromDropDownList(monthListElement, selectionType, value);

	}


	public void selectYearOfBirth(String selectionType , String value) {

		//locate DOB webelements

		WebElement yearListElement = driver.findElement(yearList);


		//select an option from lists
		selectFromDropDownList(yearListElement, selectionType, value);

	}


	public void checkNewsLetterOption() {


		clickOnElement(newsLetter);

	} 


	public void checkSpecialOferOption() {


		clickOnElement(receiveSpecialOffersFromOurPartners);

	} 



	public void enterAccountFirstName(String accountFirstName) {


		sendKeysToField(first_name, accountFirstName);

	} 


	public void enterAccountLastName(String accountLastName) {


		sendKeysToField(last_name, accountLastName);

	} 


	public void enterAccountCompany(String accountCompany) {


		sendKeysToField(company, accountCompany);

	} 

	public void enterAccountAdress1(String accountAdress1) {


		sendKeysToField(address1, accountAdress1);

	} 


	public void enterAccountAdress2(String accountAdress2) {


		sendKeysToField(address2, accountAdress2);

	} 


	public void selectAccountCountry(String selectionType , String value) {

		WebElement countryListElement = driver.findElement(countryList);

		selectFromDropDownList(countryListElement, selectionType, value);

	} 


	public void enterAccountstate(String accountState) {


		sendKeysToField(state, accountState);

	} 


	public void enterAccountCity(String accountCity) {


		sendKeysToField(city, accountCity);

	} 


	public void enterAccountZipCode(String accountZipCode) {


		sendKeysToField(zipCode, accountZipCode);

	}


	public void enterAccountMobileNumber(String accountMobileNumber) {


		sendKeysToField(mobileNumber, accountMobileNumber);

	}



	public void clickCreateAccountButton() {


		clickOnElement(createAccountButton);

	}
	
	
	public void waitTillSuccessMessageAppear(Duration time) {
		
		
		super.waitForElemnt(time,
				ExpectedConditions.presenceOfElementLocated(accountCreationSuccess));	


	}
}