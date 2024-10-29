package utilities;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import hooks.appHooks;

public class CommonMethods {

	public static WebDriver driver;
	private static PropertyLoader propertyLoader = new PropertyLoader();
	private ExcelReader excelReader;

	public CommonMethods() {
		this.excelReader = new ExcelReader(appHooks.getSaveDir());
	}

	public static void enterUrl(String url) {
		driver.get(url);
	}

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public static void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public static void getURL() {
		if (driver == null) {
			throw new IllegalStateException("WebDriver is not initialized. Please check Hooks setup.");
		}
		String url = propertyLoader.getProperty("LMSUrl");
		driver.get(url);
	}

	public static String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String elementGetText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public static void elementClick(WebElement element) {
		element.click();
	}

	public static void elementSendkeysEnter(WebElement element, String data) {
		element.sendKeys(data, Keys.ENTER);
	}

	public static void elementSendkeys(WebElement element, String data) {
		element.sendKeys(data);
	}

	public static String getActiveElementAttribute(WebDriver driver) {
		WebElement activeElement = driver.switchTo().activeElement();
		String message = activeElement.getAttribute("validationMessage");
		System.out.println("Actual message appeared on the screen is: " + message);
		return message;
	}

	public static String getAttributeValue(WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}

	public static String getPlaceholderValue(WebElement element) {
		return getAttributeValue(element, "placeholder");
	}

	public static boolean isElementPresent(WebElement element) {
		try {
			boolean isPresent = element.isDisplayed();
			return isPresent;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	public static void retriveStatusCode(Integer expectedStatusCode) {
		try {
			String currentUrl = driver.getCurrentUrl();
			URL url = new URL(currentUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			int responseCode = connection.getResponseCode();
			Assert.assertEquals(responseCode, expectedStatusCode.intValue(),
					"Expected HTTP status code 404, but got: " + responseCode);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("An error occurred while checking the HTTP status code: " + e.getMessage());
		}
	}

	public static void findBrokenLink(WebDriver driver, WebElement element, Integer elt) throws IOException {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (WebElement linkElement : links) {
			String hrefattValue = linkElement.getAttribute("href");
			URL linkURL = new URL(hrefattValue);
			// open connection to the server
			HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection();
			// connect to server and sent request to the server
			conn.connect();
			if (conn.getResponseCode() >= 400) {
				System.out.println(hrefattValue + "===> Broken link");
			} else {
				System.out.println("not a broken link");
			}

		}
	}

	public String getDataFromExcel(String sheetName, String header, int rowNum) {
		excelReader.setSheet(sheetName);
		return excelReader.getCellData(header, rowNum);
	}

	public void closeExcel() {
		excelReader.close();
	}

	public static void mouseOver(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public void waitForElementToBeVisible(WebElement element, int i) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public boolean isElementEditable(WebElement element) {
		return element.isEnabled() && element.getAttribute("readonly") == null;
	}

	public void invisibilityBatch() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
	}

}
