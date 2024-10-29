package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonMethods;
import utilities.LoggerLoad;

public class ProgramPage extends CommonMethods {
	WebDriver driver;
	public Actions action;
	
	
	//locators
	@FindBy(xpath ="//button[@id='program']")
	public WebElement Programbtn;
	@FindBy(xpath="//button[normalize-space()='Add New Program']")
	public WebElement AddNewProgrambtn;
	@FindBy(xpath = "/html/body/app-root/app-program/div/mat-card/mat-card-title/div[1]")
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
//	@FindBy(xpath="//div[@class='mat-ripple mat-menu-ripple']/..")
//	public WebElement AddNewProgrambtn;
	@FindBy(xpath="//app-root/app-program/p-dialog//div[2]/div[1]/label/span")
	public WebElement asteriksmark;
	@FindBy(xpath="//small[text()='Program name is required.']")
	public WebElement Pname_requiredtxt;
	@FindBy(xpath="//small[text()='Description is required.']")
	public WebElement PDescription_requiredtxt;
	@FindBy(xpath="//small[text()='Status is required.']")
	public WebElement PStatus_requiredtxt;
	@FindBy(xpath="//span[@class='p-button-label' and text()='Cancel']")
	public WebElement Cancelbtn;
	@FindBy (xpath="//span[@class='p-button-label' and text()='Save']")
	public WebElement Savebtn;
	@FindBy (xpath="//span[@id='pr_id_5-label' and text()= 'Program Details'] ")
	public WebElement ProgramDetails_Text;
	
	
	
	
	private WebDriverWait wait;
    public ProgramPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.action = new Actions(driver);
		this.driver =driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
//	public void Savebtn(){
//		
//	};
	
	
	public String getProgramPageTitle() {
		return ProgramPageTitle.getText();
	}
	
	
	public String getPDWindowDisplay() {
		
		return ProgramDetails_Text.getText();
	}
	public String getAddNewProgrambtn() {
		 return AddNewProgrambtn.getText();
			}
	public void setDataFromExcel() {
			String Pdata = getDataFromExcel("Program_sheet", "Program Name", 1);
			System.out.println("Data from Excel: " + Pdata);
		}
	public String  getProgramDetails_Text() {
			
			return ProgramDetails_Text.getText();
		}
	
    public void AddnewProgramPage_Display(String String) {	
	if ("Program Name".equals(String)) {
		String value = Pname_requiredtxt.getText();
		assertsEquals(value, String);
		LoggerLoad.info(value);
		} else if ("Program Description".equals(String)) {
			String value = PDescription_requiredtxt.getText();
			assertsEquals(value, String);
			LoggerLoad.info(value);
		} else if ("Program Status".equals(String)) {
			String value = PStatus_requiredtxt.getText();
			assertsEquals(value, String);
			LoggerLoad.info(value);
		} else if ("Save".equals(String)) {
			String value = Savebtn.getText();
			assertsEquals(value, String);
			LoggerLoad.info(value);
		} else if ("Cancel".equals(String)) {
			String value = Cancelbtn.getText();
			assertsEquals(value, String);
			LoggerLoad.info(value);
		}
	}
    
}
