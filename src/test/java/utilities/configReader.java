package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {
	
	/*
		private static Properties properties;		
		private final static String propertyFilePath = "./src/test/resources/config.properties";	
		
		public static void loadConfig() throws Throwable {

			try {
				FileInputStream fis;
				fis = new FileInputStream(propertyFilePath);
				properties = new Properties();
				try {
					properties.load(fis);
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
			}
			Constant.APP_URL=properties.getProperty("LMSUrl");
			Constant.BROWSER=properties.getProperty("browser");
			Constant.USERNAME=properties.getProperty("Username");
			Constant.PASSWORD=properties.getProperty("Password");
			
			
		}
		
		*/

}
