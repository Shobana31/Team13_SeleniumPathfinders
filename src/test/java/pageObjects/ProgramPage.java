package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProgramPage {
	
	WebDriver driver;
	public Actions action;
	
	@FindBy(xpath = "//h5[text()='Linked List']/..//a[text()='Get Started']")
	public WebElement GetStartedLp;

}
