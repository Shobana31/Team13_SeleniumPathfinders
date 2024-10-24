package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BatchPage {

public WebDriver driver;
	
	//constructor
	public BatchPage(WebDriver driver) {	
		this.driver = driver;
		PageFactory.initElements(driver, this);
			}
	
	//Locating Element
	@FindBy(xpath="//div[normalize-space()='Manage Batch']")
	WebElement titleofBatchPage;
	
	
	
	//Action methods

	public String getBatchTitle() {
	
		return titleofBatchPage.getText();
	}
	
	
	

	
}
