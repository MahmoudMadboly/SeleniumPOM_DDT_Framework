package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.PageBase;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {

		super(driver);

	}

	//need to be enhanced to be more relative locator
	By productName = By.xpath("//h2 [text() = 'Blue Top']");

	public static By productCategory = By.xpath("//p[contains(text(), 'Category:')]");

	By productPrice = By.xpath("//span[contains(text(), 'Rs.')]");

	By productAvailability = By.xpath("//b [text() = 'Availability:']");

	By productCondition = By.xpath("//b [text() = 'Condition:']");

	By productBrand = By.xpath("//b [text() = 'Brand:']");

	By quantityCounterButton = By.id("quantity");

	static By addToCartButton = By.xpath("//button[normalize-space()='Add to cart']");

	By viewCartButton = By.linkText("View Cart");

	static By writeYourReview = By.xpath("//a[@href='#reviews' and text()='Write Your Review']");

	By name = By.id("name");

	By email = By.id("email");

	By myReview = By.id("review");

	By submitReview = By.id("button-review");

	By addReviewSuccessMessage = By.xpath("//span [text() = 'Thank you for your review.']");




	public boolean verifyProductNameVisible() {

		return super.getWebElemnt(productName).isDisplayed();


	}

	public boolean verifyproductCategoryVisible() {

		return super.getWebElemnt(productCategory).isDisplayed();


	}

	public boolean verifyproductPriceVisible() {

		return super.getWebElemnt(productPrice).isDisplayed();


	}

	public boolean verifyproductAvailabilityVisible() {

		return super.getWebElemnt(productAvailability).isDisplayed();


	}

	public boolean verifyproductConditionVisible() {

		return super.getWebElemnt(productCondition).isDisplayed();


	}

	public boolean verifyproductBrandVisible() {

		return super.getWebElemnt(productBrand).isDisplayed();


	}

	public void increaseProductQuantuty(int quantity) {

		for(int i=0 ; i<quantity ;i++) {

			clickOnElement(quantityCounterButton);

		}

	}

	public void clearQuantityField() {

		clearField(quantityCounterButton);

	}

	public void setProductQuantity(String productQuantity) {

		sendKeysToField(quantityCounterButton, productQuantity);

	}

	public void clickOnAddToCartButton() {


		clickOnElement(addToCartButton);

	}

	public void clickOnViewCartButton(Duration time) {


		clickOnElement(viewCartButton);

		waitForElemnt(time, ExpectedConditions.presenceOfAllElementsLocatedBy(QartPage.productQuantityInTable));

	}

	public boolean verifyWriteYourReviewVisible() {

		return super.getWebElemnt(writeYourReview).isDisplayed();


	}

	public void setReviewerName(String reviewerName) {

		sendKeysToField(name, reviewerName);

	}

	public void setReviewerEmail(String reviewerEmail) {

		sendKeysToField(email, reviewerEmail);

	}

	public void setReviewerComment(String reviewerComment) {

		sendKeysToField(myReview, reviewerComment);

	}

	public void submitReview(Duration time) {

		clickOnElement(submitReview);

		waitForElemnt(time, ExpectedConditions.visibilityOfElementLocated(addReviewSuccessMessage));

	}

	public String verifyAddReviewSuccessMessage() {

		return getWebElemnt(addReviewSuccessMessage).getText();

	}
}


