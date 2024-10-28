package hooks;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;



import utilities.PropertyLoader;


public class appHooks {
	
	private static WebDriver driver;
    private PropertyLoader propertyLoader;

	
	@Before
	public void setup() throws Throwable {
		 propertyLoader = new PropertyLoader();  // Initialize the PropertyLoader
	        String browser = System.getProperty("browser"); // Get the browser from system properties

	         if (browser == null || browser.isEmpty()) {
	            browser = propertyLoader.getProperty("browser"); // Fetch browser property from config file
	        }
	         switch (browser.toLowerCase()) {
	            case "chrome":
	                driver = new ChromeDriver(new ChromeOptions());
	                break;
	            case "firefox":
	                driver = new FirefoxDriver(new FirefoxOptions());
	                break;
	            default:
	                throw new IllegalArgumentException("Unsupported browser: " + browser);
	        }

	        driver.manage().window().maximize();
	   
	}
	
	@After
	public void teardown() 
	{
		   if (driver != null) {
	            driver.quit();
	            driver = null; 
	        }
	}
	
    public static WebDriver getDriver() {
        return driver;
    }

}
