package listnener;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.TestBase;
import utilities.ExtentReportManger;

public class Testlistner implements ITestListener{

	static ExtentReports er = ExtentReportManger.getReport();

	static ExtentTest et;

	//ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public void onTestStart(ITestResult result) {

		et = er.createTest(result.getMethod().getMethodName());
		

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		et.log(Status.PASS, "Test passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {

		et.log(Status.FAIL, "Test Failed: " + result.getThrowable());

		//take a screenshot
		WebDriver driver = TestBase.getDriver();

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String path = config.ConfigReader.getConfigValue("screenShotFilePath") + result.getMethod().getMethodName() + ".png";

		try {

			Files.createDirectories(Paths.get(config.ConfigReader.getConfigValue("screenShotFilePath")));

			Files.copy(src.toPath(), Paths.get(path));

			et.addScreenCaptureFromPath(path);

		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		et.log(Status.SKIP, "Test is skipped");

	}

	@Override
	public void onFinish(ITestContext context) {
		
		er.flush();

	}
}