package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.PageBase;
import utilities.browserUtils;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {

		super(driver);

	}


	//locate webelements
	public By automationExcersieHeader = By.xpath("//h2 [text() = 'Full-Fledged practice website for Automation Engineers']");

	By testCaseButton = By.linkText("/test_cases");

	By productsCaseButton = By.linkText("/products");

	static By signUpButton = By.partialLinkText("Signup");

	By qartButton = By.partialLinkText("Cart");

	public static By homePageHeader = By.xpath("//h2[text() = 'Full-Fledged practice website for Automation Engineers']");

	By logOutButton = By.xpath("//a[@href='/logout' and normalize-space()='Logout']");

	By contactUsButton = By.partialLinkText("Contact us");

	By testCasesButton = By.partialLinkText("Test Cases");

	By ProductsButton = By.partialLinkText("Products");

	By subscriptionMail = By.id("susbscribe_email");

	By subscriptionScuccessMessage = By.xpath("//div [@class = 'alert-success alert']");

	By subscribeButton = By.id("subscribe");

	By viewProductButton = By.xpath("//a [text() = 'View Product']");

	By addToCartButton = By.xpath("//a[@class='btn btn-default add-to-cart' and contains(text(), 'Add to cart')][1]");

	By continueShoppingButton = By.xpath("//button [@class = 'btn btn-success close-modal btn-block']");

	static By logedInAsUserName = By.xpath("//a[contains(text(),'Logged in as')]");

	By category = By.xpath("//h2 [text() = 'Category']");
	
	By womenCategory = By.xpath("//a[@href='#Women' and contains(normalize-space(.), 'Women')]");
	
	By womenCategoryChoices = By.xpath("//div[@id='Women']//div[@class='panel-body']/ul/li/a");

	By recommendedItemsHeader = By.id("recommended-item-carousel");

	By addToCart_recommendedItemsHeader = By.xpath("//a[@class='btn btn-default add-to-cart' and @data-product-id='4']");

	By viewCartButton = AllProductsPage.viewCartButton;

	By arrowButton = By.xpath("//i [@class = 'fa fa-angle-up']");




	public boolean verifytHomePageHeaderVisible() {

		return super.getWebElemnt(automationExcersieHeader).isDisplayed();


	}


	public String verifyUserLoggedIn() {

		return super.getWebElemnt(logedInAsUserName).getText();


	}

	
	public boolean verifytSuccessfulLoginHeaderVisible() {

		return super.getWebElemnt(logedInAsUserName).isDisplayed();


	}


	public void navigateToSignUpScreen(Duration time) {

		navigateToScreen(signUpButton);

		waitForElemnt(time, ExpectedConditions.presenceOfElementLocated(RegisterUserPage.signUpScreenHeader));

	}

	public void navigateToLogOut(Duration time) {

		navigateToScreen(logOutButton);	

		waitForElemnt(time, ExpectedConditions.presenceOfElementLocated(RegisterUserPage.signUpScreenHeader));

	}


	public void navigateToContactUsScreen(Duration time) {

		navigateToScreen(contactUsButton);

		waitForElemnt(time, ExpectedConditions.presenceOfElementLocated(ContactUsPage.contactUsHeader));

	}

	public void navigateToTestCasesScreen(Duration time) {

		navigateToScreen(testCasesButton);

		waitForElemnt(time, ExpectedConditions.presenceOfElementLocated(TestCasePage.testCasesHeader));

	}


	public void navigateToAllProductsScreen(Duration time) {

		navigateToScreen(ProductsButton);

		waitForElemnt(time, ExpectedConditions.presenceOfElementLocated(AllProductsPage.allProductsHeader));

	}

	public void enteSubscriptionMailID(String subscrMail) {

		sendKeysToField(subscriptionMail, subscrMail);

	}

	public void clickOnSubscribeButton() {

		clickOnElement(subscribeButton);

	}

	public void getSubscribtionMailWebElement() {

		getWebElemnt(subscriptionMail);

	}


	public void scrollToSubscribeField() {

		browserUtils.scrollIntoElement(driver, getWebElemnt(subscriptionMail));

	}

	public boolean verifySubscriptionFieldIsVisible() {

		return getWebElemnt(subscriptionMail).isDisplayed();

	}

	public String getWebElementOfSubscriptionSuccessMessage() {

		return getWebElemnt(subscriptionScuccessMessage).getText();

	}

	public void navigateToQartScreen(Duration time) {

		navigateToScreen(qartButton);
		waitForElemnt(time, ExpectedConditions.presenceOfElementLocated(QartPage.shoppingCartHeader));

	}


	public void clickOnViewProductButton(Duration time) {

		clickOnElement(viewProductButton);
		waitForElemnt(time, ExpectedConditions.presenceOfElementLocated(ProductDetailsPage.productCategory));	

	}
	
	public void clickOnViewQartButton(Duration time) {

		clickOnElement(viewCartButton);
		waitForElemnt(time, ExpectedConditions.presenceOfElementLocated(QartPage.shoppingCartHeader));	

	}


	public void addProductToCart(Duration time) {

		clickOnElement(addToCartButton);
		waitForElemnt(time, ExpectedConditions.elementToBeClickable(continueShoppingButton));

	}	

	public void clickOnContinueShoppingButton() {

		clickOnElement(continueShoppingButton);

	}

	public boolean verifyCategoryVisible() {

		return super.getWebElemnt(category).isDisplayed();


	}

	public void expandWomanCategory() {

		clickOnElement(womenCategory);

	}

	public void getAndLoopInsideWomanCategoryChoices(String womentargetChoice , Duration time) {
		

		waitForElemnt(time, ExpectedConditions.visibilityOfElementLocated(womenCategoryChoices));
		
		
		List<WebElement> choices = getWebElementList(womenCategoryChoices);
		

		for(WebElement choice : choices) {
			

			if(choice.getText().trim().equalsIgnoreCase(womentargetChoice)) {
				

				choice.click();
				
				waitForElemnt(time, ExpectedConditions.visibilityOfElementLocated(WomenCategoryScreenPage.womenCategoryHeader));

				break;

			}
		}
	}


	public void scrollToBottomOfPage() {

		browserUtils.scrollDown(driver);

	}


	public boolean verifyRecommendedItemsVisible() {

		return getWebElemnt(recommendedItemsHeader).isDisplayed();

	}


	public void addRecommendedItemToCart() {

		clickOnElement(addToCart_recommendedItemsHeader);

	}


	public void scrollUpUsingArrowButton() {

		clickOnElement(arrowButton);

	}

	public void scrollUpWithoutArrowButton() {

		browserUtils.scrollup(driver);		

	}
	
	public void waitTillHomePageHeaderBeDisplayed(Duration time) {
		
		waitForElemnt(time, ExpectedConditions.visibilityOfElementLocated(homePageHeader));
		
	}
	
	/*
	public void getList() {
		
		 List<WebElement> lists = getWebElementList(womenCategoryChoices);
		
		for(WebElement list : lists) {
			
			System.out.println(list.getText());
			
		}
		
	}
*/



}