package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class ConfigReader {
	//private static Properties properties;
	private final static String propertyFilePath = "./src/test/resources/Config.properties";
	 private static Properties properties = new Properties();

	public Properties  loadConfig() throws Throwable {

		try {
			FileInputStream fis; 
			fis = new FileInputStream(propertyFilePath);
			properties = new Properties();
			properties.load(getClass().getResourceAsStream("/config.properties"));
			Constant.APP_URL=properties.getProperty("url");
			Constant.USERNAME=properties.getProperty("username");
			Constant.PASSWORD=properties.getProperty("password");
			//Constant.excelpath=properties.getProperty("excelpath");
			  try { properties.load(fis); fis.close(); } catch (IOException e) {
			  e.printStackTrace(); }
			 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("config.properties not found at config file path " + propertyFilePath);
		}
		return properties;
	}

	private static String browserType=null;
	public static void setBrowserType(String browser) {
		browserType=browser;
	}

	public static String getBrowserType() {
		 browserType = properties.getProperty("browser");
		if (browserType != null)
			return browserType;
		else
			throw new RuntimeException("browser not specified in the testng.xml");
	}


}