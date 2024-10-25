package hooks;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import utilities.CommonMethods;
import utilities.FileDownloader;
import utilities.LoggerLoad;
import utilities.PropertyLoader;

public class appHooks {

	private static WebDriver driver;
	private PropertyLoader propertyLoader;
	private static String saveDir;

	@Before
	public void setup() throws Throwable {
		propertyLoader = new PropertyLoader(); // Initialize the PropertyLoader
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
		CommonMethods.driver = driver;
		downloadFile(); // Download the file before executing scenarios
	}

	@After
	public void teardown(Scenario scenario) {
		if (driver != null && scenario.isFailed()) {

			LoggerLoad.info("Taking screenshot for a failed sceanrio " + scenario);

			TakesScreenshot ts = (TakesScreenshot) driver;

			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

			scenario.attach(screenshot, "image/png", "errorscreen");

			Allure.addAttachment("failed scenario screenshot", new ByteArrayInputStream(screenshot));

		}

		if (driver != null) {
			LoggerLoad.info("Quitting the browser ");
			driver.quit();
			driver = null;
		}
	}

	private void downloadFile() {

		String fileURL = "https://docs.google.com/spreadsheets/d/1yJnBrcNqL196xoXOuVO99XOw4ACQLjAucmZEog3UdX4/export?format=xlsx";
		saveDir = "src/test/resources/LMSData.xlsx";
		try {
			FileDownloader.downloadFile(fileURL, saveDir);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static String getSaveDir() {
		return saveDir;
	}

}
