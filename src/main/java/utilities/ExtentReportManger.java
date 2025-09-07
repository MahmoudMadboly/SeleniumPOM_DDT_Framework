package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import config.ConfigReader;

public class ExtentReportManger {
	
	private static ExtentReports extentReport;
	
	public static ExtentReports getReport() {
		
		if(extentReport == null) {
			
			//Create an HTML reporter
			
			String reportPath = ConfigReader.getConfigValue("extentReportPath");

			ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
			
			sparkReport.config().setReportName(ConfigReader.getConfigValue("reportName"));
			
			sparkReport.config().setDocumentTitle(ConfigReader.getConfigValue("documentTitle"));
			
			
			
			//Create ExtentReports and attach the reporter
			
			extentReport = new ExtentReports();
			
			extentReport.attachReporter(sparkReport);
			
			
			// Add system info
			
			extentReport.setSystemInfo(ConfigReader.getConfigValue("executerTitle"), 
					ConfigReader.getConfigValue("executerName"));
			
			extentReport.setSystemInfo(ConfigReader.getConfigValue("SystemInfo_environment"),
					ConfigReader.getConfigValue("environment"));	
			
		}
		
		return extentReport;
	}
}