package utilities;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public static WebDriver driver;
//	ChromeOptions options = new ChromeOptions();
//    options.addArguments("--headless");
//	return new ChromeDriver(options);
		//@BeforeTest
//	@Parameters({"browser"})
//
//	public void beforeClass(String browser){
//
//		ConfigReader.setBrowserType(browser);
//	}
	
	public static WebDriver initializeDrivers(String browser) {

		if (browser.equalsIgnoreCase("firefox")) {
			LoggerLoad.info("Testing on firefox");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("chrome")) {
			LoggerLoad.info("Testing on chrome");
			WebDriverManager.chromedriver().setup();
//			ChromeOptions options = new ChromeOptions();
//		    options.addArguments("--headless");browser
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("safari")) {
			LoggerLoad.info("Testing on safari");
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			LoggerLoad.info("Testing on Edge");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		
		
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();

		return driver;
	}

	public static WebDriver getdriver() {
		return driver;
	}

	public static void closeallDriver() {
		driver.quit();
	}

	}
