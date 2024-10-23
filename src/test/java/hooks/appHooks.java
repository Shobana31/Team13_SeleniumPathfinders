package hooks;



import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.Constant;
import utilities.configReader;
import utilities.driverfactory;

public class appHooks {
	
	public WebDriver driver;
	
	
	@Before
	public void setup() throws Throwable {
		//Loading config file
		configReader.loadConfig();
		String browser = Constant.BROWSER;
		
		if(driver == null) {
			driver = driverfactory.initializeDrivers(browser);
		}
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/login");
//		driver.manage().window().maximize();
	}
	
	@After
	public void teardown() 
	{
		driver.quit();
	}

}
