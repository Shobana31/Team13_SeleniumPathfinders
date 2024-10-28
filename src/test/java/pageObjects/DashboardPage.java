package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {
	
	public DashboardPage() {
		//DashboardPage dp = new DashboardPage(driver);
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
	
	@FindBy(xpath="//button[@id='program']")
	WebElement txtProgram;
	
	public boolean getProgramText() {
		 return txtProgram.isDisplayed();
	}
	
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
	public boolean isProgramDisplayed() {
		lnkProgram.isDisplayed();
		return true;
		
	}

}
