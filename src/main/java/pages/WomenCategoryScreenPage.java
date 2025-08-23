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

	By menCategory = By.partialLinkText("Men");

	By menCategoryChoices = By.xpath("//ul/li/a");


	public boolean verifytWomanPageHeaderVisible() {

		return super.getWebElemnt(womenCategoryHeader).isDisplayed();

	}



	public void getAndLoopInsideMenCategoryChoices(String menTargetChoice , Duration time) {

		List<WebElement> choices = getWebElementList(menCategoryChoices);

		for(WebElement choice : choices) {

			if(choice.getText().trim().equalsIgnoreCase(menTargetChoice)) {

				choice.click();

				waitForElemnt(time, ExpectedConditions.visibilityOfElementLocated(MenCategoryScreenPage.menCategoryHeader));

				break;

			}
		}
	}	
}