package config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	
	private static Properties Properties;
	
	static {
		
		try {
			
		FileInputStream fileInput = new FileInputStream("/Users/mahmoudmadboly/Automation/SeleniumPOM_DDT_Framework/SeleniumPOMDDTProject/src/test/resources/config.properties");	
			
		Properties = new Properties();
		
		Properties.load(fileInput);
		
		}catch(Exception e) {
			
			e.getStackTrace();
			e.printStackTrace();
			
		}		
	}
	
	
	public static String getConfigValue(String key) {
		
		return Properties.getProperty(key);
		
	}
}