package utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonMethods {
	
	
	public static boolean validator(String actual, String expected) {

		if(actual.equalsIgnoreCase(expected)) {
			return true;
		}
		else {
			return false;
		}

	}

	public static List<String> printTextForWebElements(List<WebElement> options) {

		List<String> texts = new ArrayList<String>();

		int i=0;
		for(WebElement option: options) {
			texts.add(i,option.getText());
			i++;
		}

		System.out.println("The number of items in the list are: "+ texts.size());
		return texts;
	}

	public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public static void waitForElementToBeVisible(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}

	public static String getActiveElementAttribute(WebDriver driver) {
		WebElement activeElement = driver.switchTo().activeElement();
		String message = activeElement.getAttribute("validationMessage");
		System.out.println("Actual message appeared on the screen is: " + message);
		return message;
	}

	public static void actionsClick(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		actions.click().perform();
	}
	
	public static void actionsSendKeys(WebDriver driver,WebElement element, String input ) {
		Actions actions = new Actions(driver);
		actions.sendKeys(element, input).perform();
		System.out.println();
		
	}
	
}

