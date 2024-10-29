package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonMethods;

public class DashboardPage extends CommonMethods {

	public WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(how = How.XPATH, using = "//body")
	public WebElement DB_Body;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()='LMS - Learning Management System']")
	public WebElement DB_Title;

	@FindBy(how = How.XPATH, using = "//mat-toolbar[@class='mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted']//div[@class='ng-star-inserted']")
	public WebElement DB_MenuItems;

	//Locating Elements ////button[normalize-space()='Add New Program']

	//mat-toolbar[@class='mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted']//div[@class='ng-star-inserted']/button[@id='program']
	@FindBy(xpath="//span[normalize-space()='Program']")
	public WebElement lnkProgram;
	
	@FindBy(xpath="//button[normalize-space()='Add New Program']")
	public WebElement lnkAddProgram;
	
	@FindBy(xpath="//span[normalize-space()='Batch']")
 	public WebElement lnkBatch;

	@FindBy(xpath="//button[normalize-space()='Add New Batch']")
	public WebElement lnkAddBatch;
	
	@FindBy(xpath="//span[normalize-space()='Class']")
	public WebElement lnkClass;
	
	@FindBy(xpath="//button[normalize-space()='Add New Class']")
	public WebElement lnkAddClass;
	
	@FindBy(xpath="//span[normalize-space()='Logout']")
	public WebElement lnkLogout;
	

	public void clickProgramLink() {
		lnkProgram.click();
	}

	public void clickAddProgramLink() {
		lnkAddProgram.click();
	}

	public void clickBatchLink() {
		lnkBatch.click();
	}

	public void clickAddBatchLink() {
		lnkAddBatch.click();
	}

	public void clickClassLink() {
		lnkClass.click();
	}

	public void clickAddClassLink() {
		lnkAddClass.click();
	}

	public void clickLogout() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lnkLogout);
		wait.until(ExpectedConditions.elementToBeClickable(lnkLogout));
		try {
			lnkLogout.click();
		} catch (ElementClickInterceptedException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", lnkLogout);
		}

	}

	public String getAddBatch() {
		return elementGetText(lnkAddBatch);
	}
}
