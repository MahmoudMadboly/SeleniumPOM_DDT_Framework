package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import utilities.WaitUtuls;

public class TestBase {
	
	int time = 10;

	protected WebDriver driver;

	String browserName = ConfigReader.getConfigValue("browser_Name");

	String portalEndPoint = ConfigReader.getConfigValue("baseURL");;



	@BeforeTest
	//open the required browser & get the portal url
	public void openBrowser() {


		switch(browserName.toLowerCase()) {

		case "chrome":

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "safari":

			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;


		case "firefox":

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;


		case "edge":

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;


		default :

			throw new RuntimeException("Unsupported browser: " + browserName);

		}

		driver.manage().window().maximize();

		driver.get(portalEndPoint);
		
		WaitUtuls.waitExplicily(driver, Duration.ofSeconds(time),
				ExpectedConditions.presenceOfElementLocated(HomePage.homePageHeader));
		
		
	}



	//@AfterTest
	//close the browser
	public void closeBrowser() {

		if(driver != null) {

			driver.quit();	
		}else {

			System.out.println("Most probably Driver is null");

		}
	}
}