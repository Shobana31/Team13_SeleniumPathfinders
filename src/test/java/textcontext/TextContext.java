package textcontext;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import pageObjects.BasePage;
import pageObjects.BatchPage;
import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.ProgramPage;
import utilities.PropertiesFile;

public class TextContext {
	

	protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	WebDriver driver;
	
	HomePage hp;
	BasePage bp;
	BatchPage bchp;
	DashboardPage dp;
	ProgramPage pp;
	
	public void setDriver(WebDriver driver) throws Throwable {
		String browser = PropertiesFile.readPropertiesFile("browser");
		
		// Uncomment for cross Browser testing
		//String browser = TestNgConfigReader.getBrowserType();
		//
		System.out.println("The browser value from properties file is: "+ browser);
		
		if (browser.equalsIgnoreCase("Chrome")){
			ChromeOptions co = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			
			//co.addArguments("--headless");
			co.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new ChromeDriver(co);
			threadLocalDriver.set(driver);
		}

		else if(browser.equalsIgnoreCase("Edge")){
			EdgeOptions eo = new EdgeOptions();
			WebDriverManager.edgedriver().setup();
			
			//eo.addArguments("--headless");
			driver = new EdgeDriver(eo);
			threadLocalDriver.set(driver);
		}

		else if(browser.equalsIgnoreCase("FireFox")) {
			
			FirefoxOptions fo = new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();
			
			//fo.addArguments("--headless");
			driver = new FirefoxDriver(fo);
			threadLocalDriver.set(driver);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return threadLocalDriver.get();
	}

	public HomePage getHp() {
		return hp;
	}
	
	public BasePage getBp() {
		return bp;
	}	
	public BatchPage getBchp() {
		return bchp;
	}
	public DashboardPage getDp() {
		return dp;
	}	
	public ProgramPage getPp() {
		return pp;
	}
	
	public void initializePageObjects(WebDriver driver) {

		this.hp = new HomePage(driver);
		this.dp = new DashboardPage(driver);
		this.bp = new BasePage(driver);
		this.bchp = new BatchPage(driver);
		this.pp = new ProgramPage();

		

	}
}
