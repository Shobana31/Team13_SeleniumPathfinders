package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.LoggerLoad;

public class ProgramPage {
	
	WebDriver driver;
	public Actions action;
	
	
	//locators
	@FindBy(xpath ="//span[@class='mat-button-wrapper' and text()= 'Program']")
	public WebElement Programbtn;
	@FindBy(xpath = "//div[normalize-space()='Manage Program']")
	//"//div[@class='box' and text()=' Manage Program']]")
	public WebElement ProgramPageTitle;
	@FindBy (xpath="//span[@class='mat-button-wrapper' and text()= 'Batch']")
	public WebElement Batchbtn;
	@FindBy (xpath="//span[@class='mat-button-wrapper' and text()= 'Class']")
	public WebElement Classbtn;
	@FindBy (xpath="//span[@class='mat-button-wrapper' and text()= 'Logout']")
	public WebElement Logoutbtn;
	@FindBy (xpath="//span[normalize-space()='LMS - Learning Management System'][1]")
	public WebElement LMSbtn;
	@FindBy(xpath="//div[@class='mat-ripple mat-menu-ripple']/..")
	public WebElement AddNewProgrambtn;
	
	
	
	
	//private WebDriverWait wait;
    public ProgramPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.action = new Actions(driver);
		this.driver =driver;
		//this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
//    public void LMSbtn() {
//	}
    public void ProgramPage_modules_Display(String String) {

		if ("LMS-Learning Management System".equals(String)) {
			String value = LMSbtn.getText();
			assertsEquals(value, String);
			LoggerLoad.info(value);
			} else if ("Program".equals(String)) {
				String value = Programbtn.getText();
				assertsEquals(value, String);
				LoggerLoad.info(value);
			} else if ("Batch".equals(String)) {
				String value = Batchbtn.getText();
				assertsEquals(value, String);
				LoggerLoad.info(value);
			} else if ("Class".equals(String)) {
				String value = Classbtn.getText();
				assertsEquals(value, String);
				LoggerLoad.info(value);
			} else if ("Logout".equals(String)) {
				String value = Logoutbtn.getText();
				assertsEquals(value, String);
				LoggerLoad.info(value);
			}
	//			else if ("Add New Program".equals(String)) {
//				String value = AddNewProgrambtn.getText();
//				assertsEquals(value, String);
//				LoggerLoad.info(value);
//			}
    }
//	public String LMSTitle_display() {
//    	
//		return LMSbtn.getText();
//	}
//	public String programbtn_display() {
//		
//		return Programbtn.getText();
//	}
//	public String Batchbtn_display() {
//		
//		return Batchbtn.getText();
//	}
//	public String Classbtn_display() {
//		
//		return Classbtn.getText();
//	}
//	public String Logoutbtn_display() {
//		
//		return Logoutbtn.getText();
//	}
	private void assertsEquals(String value, String string) {

	}
	public void Savebtn(){
		
	};
	
	
	public String getProgramPageTitle() {

		return ProgramPageTitle.getText();

	}
		


	}
	

