package utilities;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class driverfactory {
	
	/*
	public static WebDriver driver;


	public static WebDriver initializeDrivers(String browser) {

		if (browser.equalsIgnoreCase("firefox")) {			
				driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("chrome")) {			
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("safari")) {			
			driver = new SafariDriver();

		} else if (browser.equalsIgnoreCase("edge")) {			
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		return driver;
	}

	public static WebDriver getdriver() {
		return driver;
	}

	public static void closeallDriver() {
		driver.quit();
	}
*/
}
