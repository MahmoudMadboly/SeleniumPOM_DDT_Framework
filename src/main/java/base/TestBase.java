package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	WebDriver driver;

	String browserName = "";

	String portalEndPoint = "";


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

		}

		driver.manage().window().maximize();

		driver.get(portalEndPoint);
	}



	//close the browser
	public void closeBrowser() {

		if(driver != null) {

			driver.quit();	
		}else {

			System.out.println("Most probably Driver is null");

		}
	}
}