package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.PageBase;

public class PaymentPage extends PageBase{

	public PaymentPage(WebDriver driver) {

		super(driver);

	}


	static By paymentHeader = By.xpath("//h2 [text() = 'Payment']");

	By nameOnCard = By.name("name_on_card");

	By cardNumber = By.name("card_number");

	By CVC = By.name("cvc");

	By ExpirationMonth = By.name("expiry_month");

	By ExpirationYear = By.name("expiry_year");

	By payAndConfirmOrderButton = By.id("submit");
	
	By orderPlaced_SuccessMessage = By.xpath("//div [@class = 'alert-success alert']");
	
	By deleteAccountButton = By.partialLinkText(" Delete Account");
	
	By accountDeletedHeader = By.xpath("//h2 [@data-qa = 'account-deleted']");
	
	
	
	


	public boolean verifyPaymentHeaderIsDiaplyed() {

		return getWebElemnt(paymentHeader).isDisplayed();

	}


	public void enterNameOnCard(String cardName) {

		sendKeysToField(nameOnCard, cardName);

	}

	public void enterCardNumber(String cardNo) {

		sendKeysToField(cardNumber, cardNo);

	}

	public void enterCVC(String CVC_No) {

		sendKeysToField(CVC, CVC_No);

	}

	public void enterExpirationMonth(String month) {

		sendKeysToField(ExpirationMonth, month);

	}

	public void enterExpirationYear(String year) {

		sendKeysToField(ExpirationYear, year);

	}
	
	
	public void clickPayAndConfirmButton() {

		clickOnElement(payAndConfirmOrderButton);

	}
	

	public String getplaceOrderSuccessMessageText() {

		return getWebElemnt(orderPlaced_SuccessMessage).getText();

	}
	
	
	public void deleteAccount(Duration time) {

		clickOnElement(deleteAccountButton);
		
		waitForElemnt(time, ExpectedConditions.presenceOfElementLocated(accountDeletedHeader));

	}

	
	public String getAccountDeletedHeaderText() {

		return getWebElemnt(accountDeletedHeader).getText();

	}


}