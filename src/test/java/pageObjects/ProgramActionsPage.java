package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonMethods;
import utilities.LoggerLoad;

public class ProgramActionsPage  extends CommonMethods {

	WebDriver driver;
	public Actions action;
	
	//locators
	@FindBy(xpath = "html/body/app-root/app-program/div/mat-card/mat-card-title/div[1]")
	public WebElement ProgramPageTitle;
//	@FindBy(xpath="//*[@id=\"mat-menu-panel-0\"]/div/button")
//	public WebElement AddNewProgrambtn;
	@FindBy(xpath="//app-root/app-program/p-dialog//div[2]/div[1]/label/span")
	public WebElement asteriksmark;
	@FindBy(xpath="//html/body/app-root/app-program/p-dialog/div/div/div[2]/div[1]/label/text()")
	public WebElement Pname_Fieldtxt;
	@FindBy(xpath="//input[@id='programName']")
	public WebElement Pname_textBox;
	@FindBy(xpath="//label[text()='Description']")
	public WebElement PDescription_Fieldtxt;
	@FindBy(xpath="//*[@id='programDescription']")
	public WebElement PDesc_textBox;
	@FindBy(xpath="//lable[text()='Status']")
	//small[text()='Status is required.']
	public WebElement PStatus_Fieldtxt;
	//span[@class='p-radiobutton-icon'][1]
	@FindBy(xpath="//span[@class='p-radiobutton-icon'][1]")
	public WebElement ActiveStatusbtn;
	@FindBy(xpath="//span[@class='p-radiobutton-icon'][2]")
	public WebElement InactiveStatusbtn;
	@FindBy(xpath="//button[@label='Cancel']")
	public WebElement Cancelbtn;
	@FindBy (xpath="//button[@label='Save']")
	public WebElement Savebtn;
	@FindBy (xpath="//*[@header='Program Details']//button[@type='button']")
	public WebElement Crossbtn;
	@FindBy (xpath="//span[normalize-space()='Program Details']") //(xpath="//span[@id='pr_id_19-label']")
//	@FindBy (xpath="//span[text()='Program Details']")
	public WebElement ProgramDetails_Text;
    @FindBy (xpath="//small[text()='This field should start with an alphabet, no special char and min 2 char.']")
    public WebElement Invalid_Error;
    @FindBy (xpath="//small[text()='This field should start with an alphabet and min 2 char.']")
    public WebElement InvalidDesc_Error;
    @FindBy (xpath="//small[text()='Description is required.']")
    public WebElement Missing_PDesc_Error;
    @FindBy (xpath="//small[text()='Program name is required.']")
    public WebElement Missing_Pname_Error;
    @FindBy (xpath="//small[text()='Status is required.']")
    public WebElement Missing_PStatus_Error;
    @FindBy(xpath = "//div[contains(@class, 'p-toast-summary') and text()='Successful']")
	public WebElement successMessage;
    @FindBy(xpath="//div[@class='action']//button[@icon='pi pi-pencil']")
    public WebElement Editbtn;
    @FindBy(xpath="//div[contains(@class, 'p-toast-summary') and text()='Successful']")
    public WebElement EditsuccessMessage;
    @FindBy(xpath="//div[contains(@class, 'p-toast-summary') and text()='Successful']")
    public WebElement DeletesuccessMessage;
    @FindBy (xpath = "//div[@class='action']//button[@icon='pi pi-trash']")//"//*[@id='deleteProgram']")
    public WebElement Deletebtn;
    @FindBy (xpath="//div[@class='p-dialog-footer ng-tns-c204-7 ng-star-inserted']/button[1]")
	public WebElement NoDeletebtn;
    @FindBy (xpath="//div[@class='p-dialog-footer ng-tns-c204-7 ng-star-inserted']/button[2]")
	public WebElement YesDeletebtn;
    @FindBy (xpath="//div[@class='p-dialog-header-icons ng-tns-c204-7']/button[1]")
    public WebElement CrossDeletebtn;
    @FindBy (xpath="//span[normalize-space()='Confirm']")
    public  WebElement Confirm_text;
    @FindBy(xpath = "//button[contains(@class, 'p-paginator-next')]")
	WebElement nextPagination;
	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-double-right']")
	WebElement lastPagination;
	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-left']")
	WebElement previousPagination;
	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-double-left']")
	WebElement firstPagination;
    private int beforeCount;
	private int afterCount;
	private int selectedRows;
    //FindBy (xpath=)
    private WebDriverWait wait;
   public  ProgramActionsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.action = new Actions(driver);
		this.driver =driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
	
	private void assertsEquals(String value, String string) {
	}
	
	public void setDataFromExcel() {
		String Pdata = getDataFromExcel("Program_sheet", "Program Name", 1);
		System.out.println("Data from Excel: " + Pdata);
	}
	//Add new program
	
	public String getProgramPageTitle() {
		return ProgramPageTitle.getText();
	}
	
	
//	public String getProgramDetails_Text() {
//		return ProgramDetails_Text.getText();}
			
		
	
	public String getProgramDetails_Text() {
		return elementGetText(ProgramDetails_Text);
			
//	String windowtext= ProgramDetails_Text.getText();
//	return windowtext;
		}
	
    public void AddnewProgramPage_Display(String String) {	
	if (" Name".equals(String)) {
		String value = Pname_Fieldtxt.getText();
		assertsEquals(value, String);
		LoggerLoad.info(value);
		} else if (" Description".equals(String)) {
			String value = PDescription_Fieldtxt.getText();
			assertsEquals(value, String);
			LoggerLoad.info(value);
		} else if (" Status".equals(String)) {
			String value = PStatus_Fieldtxt.getText();
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
	
    public String ValidDataForProgramName() {
    	return getDataFromExcel("Program_sheet", "Program Name",1);
    }
    public String ValidDataForProgramDesc() {
    	return getDataFromExcel("Program_sheet", "Program Description",1);
    }
	
    public String ValidDataForProgramStatus() {
    	return getDataFromExcel("Program_sheet", "Program Status",1);
    }
    public boolean isStatusRadioButton() {
    	getActiveStatusRadioButton();
    	WebElement PStatusbtn = driver.findElement(By.xpath("//input[@type='radio']//"));
     return PStatusbtn.getTagName().equals("input") &&
    		 PStatusbtn.getAttribute("type").equals("radio");
    }
    public void getActiveStatusRadioButton() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ActiveStatusbtn);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ActiveStatusbtn);
	}
    public WebElement getInActiveStatusRadioButton() {
		return InactiveStatusbtn;
	}
    public void leavemissingField(String fieldToLeavemissing, int rowIndex) {
    if (!fieldToLeavemissing.equalsIgnoreCase("Program Name")) {
    	Pname_textBox.sendKeys(getDataFromExcel("Program_sheet", "Program Name", rowIndex));
    	
    	}
        if (!fieldToLeavemissing.equalsIgnoreCase("Program Description")) {
        	PDesc_textBox.sendKeys(getDataFromExcel("Program_sheet", "Program Description", rowIndex));
        }
        getActiveStatusRadioButton();
        Savebtn.click();
    }
	public String InValidChar_ForProgramName() {
    	return getDataFromExcel("Program_sheet", "Program Name",3);
    }
    public String SetInValidSpchar_ForProgramName() {
    	return getDataFromExcel("Program_sheet", "Program Name",4);
    }
    public String InValidint_ForProgramName() {
    	return getDataFromExcel("Program_sheet", "Program Name",9);
    }
    public String MissingProgramName() {
    	return getDataFromExcel("Program_sheet", "Program Name",6);
    }
    public String InvalidChar_ProgramDesc() {
    	return getDataFromExcel("Program_sheet", "Program Description",10);
    }
    public String Invalidspchar_ProgramDesc() {
    	return getDataFromExcel("Program_sheet", "Program Description",8);
    }
    public String MissingProgramDesc() {
    	return getDataFromExcel("Program_sheet", "Program Description",7);
    }
    public String MissingProgramStatus() {
    	return getDataFromExcel("Program_sheet", "Program Status",5);
    }
    public void ValidData_AddNewProgram() {
    	Pname_textBox.sendKeys(getDataFromExcel("Program_sheet", "Program Name",1));
    	PDesc_textBox.sendKeys(getDataFromExcel("Program_sheet", "Program Description",1));
    	getActiveStatusRadioButton();
    	Savebtn.click();
    }
    public void ValidData_AddNewProgram_Cancel() {
    	PDesc_textBox.sendKeys(getDataFromExcel("Program_sheet", "Program Name",2));
    	Pname_textBox.sendKeys(getDataFromExcel("Program_sheet", "Program Description",2));
    	getActiveStatusRadioButton();
    	Cancelbtn.click();
    }
    public void ValidData_AddNewProgram_Cross() {
    	Pname_textBox.sendKeys(getDataFromExcel("Program_sheet", "Program Name",1));
    	PDesc_textBox.sendKeys(getDataFromExcel("Program_sheet", "Program Description",2));
    	getActiveStatusRadioButton();
    	Crossbtn.click();
    }
	public String getMissing_Pname_Error() {
	
		return Missing_Pname_Error.getText();
	}
	public String getMissing_PDesc_Error() {
	
		return Missing_PDesc_Error.getText();
	}
	public String getMissing_PStatus_Error() {
	   return Missing_PStatus_Error.getText();
	}
	
	public String getSuccess_message() {
		return successMessage.getText();
	}
	public String getInvalid_Error() {
		return Invalid_Error.getText();
	}
	
    public String getInvalidDesc_Error() {
		return InvalidDesc_Error.getText();
	}
	public WebElement getPname_textBox() {
		return Pname_textBox;
		
	}
	public WebElement getPDesc_textBox() {
		return PDesc_textBox;
		
	}
	public WebElement getActiveStatusbtn() {
		return ActiveStatusbtn;
	}
	
	public void editDescriptionfield() throws ElementClickInterceptedException {
		PDesc_textBox.clear();
		PDesc_textBox.sendKeys(getDataFromExcel("Program_Sheet", "Program Description", 3));
        getActiveStatusRadioButton();
//		noOfClasses.clear();
//
//		noOfClasses.sendKeys(getDataFromExcel("Batch", "Number of Classes", 2));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
		try {
			wait.until(ExpectedConditions.visibilityOf(Savebtn));
			wait.until(ExpectedConditions.elementToBeClickable(Savebtn)).click();
		} catch (ElementNotInteractableException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Savebtn);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Savebtn);
		}
	}
    public void getEditbtn() {
	
	}
//	public boolean PDetails_Header_Display() {
//		return ProgramDetails_Text.isDisplayed();
//	}
	public String getEditsuccessMessage() {
		return EditsuccessMessage.getText();
	}
	public void clickEditbtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		WebElement editgreenIcon = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@icon='pi pi-pencil']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editgreenIcon);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editgreenIcon);
	}
	
	public void editNamefield_invalid() throws ElementClickInterceptedException {
		Pname_textBox.clear();
		Pname_textBox.sendKeys(getDataFromExcel("Program_Sheet", "Program Name", 7));
        getActiveStatusRadioButton();
        PDesc_textBox.clear();
		PDesc_textBox.sendKeys(getDataFromExcel("Program_Sheet", "Program Description", 3));
        getActiveStatusRadioButton();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
		try {
			wait.until(ExpectedConditions.visibilityOf(Savebtn));
			wait.until(ExpectedConditions.elementToBeClickable(Savebtn)).click();
		} catch (ElementNotInteractableException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Savebtn);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Savebtn);
		}
	}
	public void editMandatoryfields_valid() throws ElementClickInterceptedException {
		Pname_textBox.clear();
		Pname_textBox.sendKeys(getDataFromExcel("Program_Sheet", "Program Name",11));
		
		PDesc_textBox.clear();
		PDesc_textBox.sendKeys(getDataFromExcel("Program_Sheet", "Program Description",11));
		
        getActiveStatusRadioButton();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
		try {
			wait.until(ExpectedConditions.visibilityOf(Savebtn));
			wait.until(ExpectedConditions.elementToBeClickable(Savebtn)).click();
		} catch (ElementNotInteractableException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Savebtn);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Savebtn);
		}
	}
	
	public void editMandatoryfields_Cancel() throws ElementClickInterceptedException {
		Pname_textBox.clear();
		Pname_textBox.sendKeys(getDataFromExcel("Program_Sheet", "Program Name",11));
		
		PDesc_textBox.clear();
		PDesc_textBox.sendKeys(getDataFromExcel("Program_Sheet", "Program Description",11));
		
        getActiveStatusRadioButton();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
		try {
			wait.until(ExpectedConditions.visibilityOf(Cancelbtn));
			wait.until(ExpectedConditions.elementToBeClickable(Cancelbtn)).click();
		} catch (ElementNotInteractableException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Cancelbtn);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Cancelbtn);
		}
	}	
		public void editMandatoryfields_Cross() throws ElementClickInterceptedException {
			Pname_textBox.clear();
			Pname_textBox.sendKeys(getDataFromExcel("Program_Sheet", "Program Name",11));
			
			PDesc_textBox.clear();
			PDesc_textBox.sendKeys(getDataFromExcel("Program_Sheet", "Program Description",11));
			
	        getActiveStatusRadioButton();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
			try {
				wait.until(ExpectedConditions.visibilityOf(Crossbtn));
				wait.until(ExpectedConditions.elementToBeClickable(Crossbtn)).click();
			} catch (ElementNotInteractableException e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Crossbtn);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", Crossbtn);
			}
	}
		public String getDeletebtn_text() {
			return Deletebtn.getText();
			
			}
		public String getYesDeletebtn_text() {
			return YesDeletebtn.getText();
			
			}
		
		public String getNoDeletebtn_text() {
			return NoDeletebtn.getText();
			
			}
		public String getConfirmbox_text() {
			return Confirm_text.getText();
			
			}
//		public String getConfirmbox_text() {
//			return Confirm_text.getText();
//			
//			}
//		
		public void clickonDeleteButtons(String ButtonName) {
			WebElement overlay = driver.findElement(By.className("cdk-overlay-backdrop"));
			overlay.click();
			if (ButtonName.equalsIgnoreCase("yes")) {
				YesDeletebtn.click();
			} else if (ButtonName.equalsIgnoreCase("no")) {
				NoDeletebtn.click();
			} else {
				CrossDeletebtn.click();
			}
		}
		
		public void clickdeleteAllButton() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
			WebElement deleteButton = driver
					.findElement(By.xpath("//*[@class='mat-card-title']//button[contains(@class, 'p-button-danger')]"));
			wait.until(ExpectedConditions.visibilityOf(deleteButton));
			wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
			try {
				deleteButton.click();
			} catch (ElementClickInterceptedException e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteButton);
			}
		}
		
		public void click_Deletebtn() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			WebElement deleteIcon1 = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[@class='action']//button[@icon='pi pi-trash']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteIcon1);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteIcon1);
		}
		public String getDeletesuccessMessage() {
			// TODO Auto-generated method stub
			return DeletesuccessMessage.getText();
		}
		
		public void storeAfterCount() {
			String countText = driver.findElement(By.xpath("//span[@class='p-paginator-current ng-star-inserted']"))
					.getText();
			String[] parts = countText.split("of ");
			this.afterCount = Integer.parseInt(parts[1].trim().split(" ")[0]);
		}
		public boolean validateCount() {
			boolean flag = false;
			int expectedCount = beforeCount - selectedRows;
			storeAfterCount();
			if (afterCount != expectedCount) {
				throw new AssertionError(
						"Count validation failed: Expected " + expectedCount + ", but found " + afterCount);
			} else {
				flag=true;
			}
			return flag;
		}
		public void nextPageLink() {
			invisibilityBatch();
			nextPagination.click();
		}
	
		public WebElement lastPageLink() {
			return lastPagination;
		}
		public void previousPageLink() {
			invisibilityBatch();
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", previousPagination);
		}
		public void firstPageLink() {
			invisibilityBatch();
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstPagination);
		}
		public boolean isPaginationEnabled(String pageLink) {
			boolean flag = false;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
			WebElement paginationElement;
			switch (pageLink.toLowerCase()) {
			case "next":
				waitForElementToBeVisible(nextPagination, 10);
				paginationElement = nextPagination;
				break;
			case "last":
				waitForElementToBeVisible(lastPagination, 10);
				paginationElement = lastPagination;
				break;
			case "previous":
				waitForElementToBeVisible(previousPagination, 10);
				paginationElement = previousPagination;
				break;
			default:
				waitForElementToBeVisible(firstPagination, 10);
				paginationElement = firstPagination;
			}
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paginationElement);
			wait.until(ExpectedConditions.elementToBeClickable(paginationElement));
			try {
				paginationElement.click();
				flag = true;
			} catch (ElementClickInterceptedException e) {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", paginationElement);
			} catch (StaleElementReferenceException e) {
				isPaginationEnabled(pageLink);
			}
			return flag;
		}
		public void waitForElementToBeVisible(WebElement nextPagination2, int i) {
			// TODO Auto-generated method stub
			
		}
		
	
}
