package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.PageBase;

public class MenCategoryScreenPage extends PageBase{

	public MenCategoryScreenPage(WebDriver driver) {

		super(driver);	

	}


	static By menCategoryHeader = By.xpath("//h2[contains(text(),'Men')]");



	public boolean verifytMenPageHeaderVisible() {

		return super.getWebElemnt(menCategoryHeader).isDisplayed();

	}

}