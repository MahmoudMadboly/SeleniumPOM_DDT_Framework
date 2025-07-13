package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import config.ConfigReader;

public class ExtentReportManger {
	
	private static ExtentReports extentReport;
	
	public static ExtentReports getReport() {
		
		if(extentReport == null) {
			
			String reportPath = "/Users/mahmoudmadboly/Automation/SeleniumPOM_DDT_Framework/SeleniumPOMDDTProject/test-output";

			ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
			
			sparkReport.config().setReportName(ConfigReader.getConfigValue("reportName"));
			
			sparkReport.config().setDocumentTitle(ConfigReader.getConfigValue("documentTitle"));
			
			extentReport = new ExtentReports();
			
			extentReport.attachReporter(sparkReport);
			
			extentReport.setSystemInfo(ConfigReader.getConfigValue("executerTitle"), ConfigReader.getConfigValue("executerName"));
			
			extentReport.setSystemInfo(ConfigReader.getConfigValue("SystemInfo_environment"), ConfigReader.getConfigValue("environment"));	
			
		}
		
		return extentReport;
	}
}