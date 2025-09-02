package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.PageBase;

public class WomenCategoryScreenPage extends PageBase{

	public WomenCategoryScreenPage(WebDriver driver) {

		super(driver);	

	}


	static By womenCategoryHeader = By.xpath("//h2 [contains(text(),'Women')]");

	By menCategory = By.xpath("//a[@href='#Men' and contains(normalize-space(.), 'Men')]");

	By menCategoryChoices = By.xpath("//div[@id='Men']//div[@class='panel-body']/ul/li/a");


	public boolean verifytWomanPageHeaderVisible() {

		return super.getWebElemnt(womenCategoryHeader).isDisplayed();

	}
	
	public void expandMenCategory() {

		clickOnElement(menCategory);

	}

	public void getAndLoopInsideMenCategoryChoices(String menTargetChoice , Duration time) {
		
		waitForElemnt(time, ExpectedConditions.elementToBeClickable(menCategoryChoices));

		List<WebElement> choices = getWebElementList(menCategoryChoices);

		for(WebElement choice : choices) {
			
			System.out.println(choice.getText());

			if(choice.getText().trim().equalsIgnoreCase(menTargetChoice)) {

				choice.click();

				waitForElemnt(time, ExpectedConditions.visibilityOfElementLocated(MenCategoryScreenPage.menCategoryHeader));

				break;

			}
		}
	}	
}