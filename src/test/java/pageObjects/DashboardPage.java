package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
public WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
			PageFactory.initElements(driver, this);
	}
	
	//Locating Elements ////button[normalize-space()='Add New Program']
	@FindBy(xpath="//span[normalize-space()='Program']")
	WebElement lnkProgram;
	
	@FindBy(xpath="//button[normalize-space()='Add New Program']")
	WebElement lnkAddProgram;
	
	@FindBy(xpath="//span[normalize-space()='Batch']")
	WebElement lnkBatch;

	@FindBy(xpath="//button[normalize-space()='Add New Batch']")
	WebElement lnkAddBatch;
	
	@FindBy(xpath="//span[normalize-space()='Class']")
	WebElement lnkClass;
	
	@FindBy(xpath="//button[normalize-space()='Add New Class']")
	WebElement lnkAddClass;
	
	@FindBy(xpath="//span[normalize-space()='Logout']")
	WebElement lnkLogout;
	
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
		lnkLogout.click();
	}


}
