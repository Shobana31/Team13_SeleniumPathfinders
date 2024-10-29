package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClassPage {
	
	public WebDriver driver;
	public ClassPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@class='mat-focus-indicator mat-menu-trigger mat-button mat-button-base'][3]")
	WebElement lnkClass;
	
	@FindBy(xpath="//div[@id='cdk-overlay-0']")
	WebElement lnkAddClass;
	
	@FindBy(xpath="//div[@class='box'][1]")
	WebElement txtManageClass;
	
	@FindBy(xpath="//span[text()=' LMS - Learning Management System ']")
	WebElement titleClassPage;
	
	@FindBy(xpath="//input[@id='filterGlobal']")
	WebElement txtSearch;
	
	@FindBy(xpath="//span[@class='p-button-icon pi pi-pencil']")
	WebElement iconEdit;
	
	@FindBy(xpath="//div[@role='checkbox']")
	WebElement iconCheckbox;
	
	@FindBy(xpath="//span[@class='p-paginator-current ng-star-inserted']")
	WebElement txtShowingmsg;
	
	@FindBy(xpath="//div[@class='p-paginator-bottom p-paginator p-component ng-star-inserted']")
	WebElement iconPagination;
	
	@FindBy(xpath="//span[@class='p-button-icon pi pi-trash']")
	WebElement btnDelete;
	
	@FindBy(xpath="//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']")
	WebElement txtTotalpages;
	
	@FindBy(xpath="//table//thead[@class='p-datatable-thead']")
	WebElement tableHeader;
	
	@FindBy(xpath="//div[@class='p-dialog-header ng-tns-c168-7 ng-star-inserted']")
	WebElement popupClassDetails;
	
	@FindBy(xpath="//div[@role='dialog']")////p-dialog[@class='ng-tns-c168-7']
	WebElement dialogClassDetails;
	
	@FindBy(xpath="//p-dialog[@class='ng-tns-c168-7']")////p-dialog[@class='ng-tns-c168-7']
	WebElement ctrldialogClassDetails;
	
	@FindBy(xpath="//span[@class='p-dialog-header-close-icon ng-tns-c168-7 pi pi-times']")
	WebElement btnclose;
	
	@FindBy(xpath="//p-dropdown[@id='batchName']")
	WebElement inputBatchName;
	
	@FindBy(xpath="//input[@id='classTopic']")
	WebElement inputClassTopic;
	
	@FindBy(xpath="//input[@id='classDescription']")
	WebElement inputClassDes;
	
	@FindBy(xpath="//input[@id='icon']")
	WebElement clkDatepicker;
	
	@FindBy(xpath="//input[@id='classNo']")
	WebElement inputnoofClasses;
	
	@FindBy(xpath="//div[@class='p-datepicker-title ng-tns-c178-43']")
	WebElement selectMonthandYear;
	
	@FindBy(xpath="//span[@class='p-datepicker-next-icon pi pi-chevron-right ng-tns-c178-43']")
	WebElement selectNext;
	
	@FindBy(xpath="//table[@class='p-datepicker-calendar ng-tns-c178-43']//tr//td")
	List<WebElement> selectAllDates;
	
	
	@FindBy(xpath="//span[@class='p-dropdown-trigger-icon ng-tns-c171-44 pi pi-chevron-down']")
	WebElement clkStaffName;
	
	@FindBy(xpath="//div[@class='p-radiobutton-box'][1]")
	WebElement chkStatusradio;
	
	@FindBy(xpath="//span[@class='p-button-icon p-button-icon-left pi pi-times']")
	WebElement clkCancel;
	
	@FindBy(xpath="//span[@class='p-button-icon p-button-icon-left pi pi-check']")
	WebElement clkSave;
	
	@FindBy(xpath="//div[@class='p-hidden-accessible ng-tns-c171-24']")
	WebElement inputRecording;
	
	@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-right']")
	WebElement navNext;
	
	@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-left']")
	WebElement navPrevious;
	
	@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-double-right']")
	WebElement navLastPage;
	
	@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-double-left']")
	WebElement navStartPage;
	
	@FindBy(xpath="//button[contains(text(),'1')]")
	WebElement firstPageButton;
	
	@FindBy(xpath="//button[normalize-space()='2']")
	WebElement secondPageButton;
	
	@FindBy(xpath="//button[@class='p-paginator-next p-paginator-element p-link p-ripple p-disabled']")
	WebElement nextPageDisabledButton;
	
	@FindBy(xpath="//button[@class='p-paginator-last p-paginator-element p-link p-disabled p-ripple ng-star-inserted']")
	WebElement lastPageDisabledButton;
	
	@FindBy(xpath="//button[@class='p-paginator-prev p-paginator-element p-link p-disabled p-ripple']")
	WebElement previousPageDisabledButton;
	
	@FindBy(xpath="//button[@class='p-paginator-first p-paginator-element p-link p-disabled p-ripple ng-star-inserted']")
	WebElement startPageDisabledButton;
	
	//Search
	@FindBy(xpath="//input[@id='filterGlobal']")
	WebElement boxSearch;
	//Table rows
	@FindBy(xpath = "//table[@role='grid']//tr")    
    List<WebElement> totalRows;
	
	@FindBy(xpath = "//tbody//tr//td[2]")    
    List<WebElement> batchNames;
	
	@FindBy(xpath = "//tbody//tr//td[3]")    
    List<WebElement> classTopics;
	
	@FindBy(xpath = "//tbody//tr//td[7]")    
    List<WebElement> staffNames;
	
	@FindBy(xpath = "//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']")    
    WebElement sortBatchIcon;
	
	@FindBy(xpath = "//p-sorticon[@field='classTopic']//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']")    
    WebElement sortClassTopicIcon;
	
	@FindBy(xpath="//p-sorticon[@field='classDescription']//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']")
	WebElement sortClassDescIcon;
	
	@FindBy(xpath="//p-sorticon[@field='classStatus']//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']")
	WebElement sortClassStatusIcon;
	
	@FindBy(xpath="//p-sorticon[@field='classDate']//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']")
	WebElement sortClassDateIcon;
	
	@FindBy(xpath="//p-sorticon[@field='classStaffName']//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']")
	WebElement sortClassStaffnameIcon;

	@FindBy(xpath = "//div[@class='action']//button[@icon='pi pi-trash']")
	WebElement deleteIcon;
	
	@FindBy(xpath = "//span[@class='p-dialog-title ng-tns-c204-8 ng-star-inserted']")
	WebElement deleteTitle;

	@FindBy(xpath = "//button[@class='ng-tns-c204-8 p-confirm-dialog-reject p-ripple p-button p-component ng-star-inserted']")
	WebElement deleteNoButton;

	@FindBy(xpath = "//button[@class='ng-tns-c204-8 p-confirm-dialog-accept p-ripple p-button p-component ng-star-inserted']")
	WebElement deleteYesButton;

	@FindBy(xpath = "//div[@class='p-dialog-header ng-tns-c204-8 ng-star-inserted']//button[@type='button']")
	WebElement deleteCloseButton;

	@FindBy(xpath = "//*[@class='mat-card-title']//button[@icon='pi pi-trash']")
	WebElement deleteAllButton;
	
	
	public String getDeleteTitle() {
		return deleteTitle.getText();
	}
	
	public String getDeleteNoButton() {
		return deleteNoButton.getText();
	}
	
	public String getDeleteYesButton() {
		return deleteYesButton.getText();
	}
	public void clickEdit() {
		iconEdit.click();
	}
	public void clickYes() {
		deleteYesButton.click();
	}
	public void clickNo() {
		deleteNoButton.click();
	}
	
	public void clickClass() {
		 lnkClass.click();		
	}
	public void clickBtnClose() {
		btnclose.click();		
	}
	
	public void clickAddClass() {
		lnkAddClass.click();
	}
	
	public String getTextManageClass() {
		return txtManageClass.getText();
	}
	public boolean isManageClassDisplayed() {
		return txtManageClass.isDisplayed();
	}
	public String getClassTitle() {
		return titleClassPage.getText();
	}
	public boolean isSearchbarDisplayed() {
		return txtSearch.isDisplayed();
	}
	public boolean isCheckboxDisplayed() {
		return txtSearch.isDisplayed();
	}
	public String getShowingmsg() {
		return txtShowingmsg.getText();
	}
	public boolean isPaginationDisplayed() {
		return iconPagination.isDisplayed();
	}
	public boolean isDeletebtnDisplayed() {
		return btnDelete.isDisplayed();
	}
	public boolean isTotalpagesDisplayed() {
		return txtTotalpages.isDisplayed();
	}
	public boolean isTableHeaderDisplayed() {
		return tableHeader.isDisplayed();
	}
	public boolean isPopupClassDetailsDisplayed() {
		return popupClassDetails.isDisplayed();
	}
	public String getDialogClassDetails() {
		return dialogClassDetails.getText();
	}
	public void switchPopupClassDetails() {
		ctrldialogClassDetails.isSelected();
	}
	
	public void setClassTopic() {
		inputClassTopic.sendKeys("Typescript");
	}
	
	public void setClassDescription() {
		inputClassDes.sendKeys("Test description");
	}
	
	
	public void enternoofClasses() {
		inputnoofClasses.isEnabled();
	}
	public void clickStaffName() {
		clkStaffName.sendKeys("Karan");
	}
	public void clickStatus() {
		chkStatusradio.click();
	}
	public void clickSave() {
		clkSave.click();
	}
	
	//pagination
	public String clickFirstPageButton()
	{		
		return firstPageButton.getText();				
	}
	public  boolean isNextButtonActive()
	{		
		return navNext.isEnabled();			
	}

	//paginator-05
	public void clickNextPageButton() throws InterruptedException 
	{
		//Showing x to y of z
		String text = txtShowingmsg.getText();
        String[] txts = text.split(" ");
        float total_entries = Float.parseFloat(txts[5]); 
        float result = total_entries / 5;
        int pages = (int)Math.ceil(result);
        System.out.println("Pages: " +pages);   
        
        	 //repeating pages
	        int p =1;
	        while (p < pages) {         	        	
	        		if(navNext != null) { 
	        			Thread.sleep(2000);
	        			navNext.click();	        		
	        		}
	        		else {
	        			break;
	        		}	        		
	        		p++;  	        	   
	        	}
	        Thread.sleep(1000);
	}
	public Boolean isNextPageButtonDisabled()
    {
    	boolean result = false;			
		if ( nextPageDisabledButton != null )
		{
			result = true;
		}
		return result;
	}
    
    //paginator-06
    
    public void clickPreviousButton() throws InterruptedException
    {
    	//navPrevious.click();
    	//Showing x to y of z
    			String text = txtShowingmsg.getText();
    	        String[] txts = text.split(" ");
    	        float total_entries = Float.parseFloat(txts[5]); 
    	        float result = total_entries / 5;
    	        int pages = (int)Math.ceil(result);
    	        System.out.println("Pages: " +pages); 
    	        
    	        	 //repeating pages
    		        int p =pages;
    		        while (p > 1) {         	        	
    		        		if(navPrevious != null) { 
    		        			Thread.sleep(3000);
    		        			navPrevious.click();
    		        			Thread.sleep(2000);
    		        		}
    		        		else {
    		        			break;
    		        		}	        		
    		        		p--;  	        	   
    		        	}     	
    }
    public  boolean isPreviousButtonActive()
	{		
		return navPrevious.isEnabled();			
	}
    public Boolean isPreviousPageButtonDisabled()
    {
    	boolean result = false;			
		if ( previousPageDisabledButton != null )
		{
			result = true;
		}
		return result;
	}
    
    public void clickStartPageButton()
	{
    	navStartPage.click();
	}
    public void clickLastPageButton() {
    	navLastPage.click();
    }
    public void enterBatchName() {
    	boxSearch.clear();
    	boxSearch.sendKeys("Micro Service-01");
    }
    public void getBatchNames() {
    	//reading data from table
    	int total_rows = driver.findElements(By.xpath("//table[@role='grid']//tr")).size();
    	System.out.println(total_rows);      	        	
    	ArrayList<String> sortedList = new ArrayList<>(); 
    	for(int r=1; r < total_rows; r++) {    		
    		List<WebElement> batchnames = driver.findElements(By.xpath("//tbody//tr["+r+"]//td[2]"));
    		if(batchnames !=null) {
    			sortedList.add(batchnames.get(0).getText());
    		
    		}else {
    			System.out.println("Batch name is not present in the table!");
    		}
        }
        Collections.sort(sortedList);
		
		for(String s : sortedList) {
			System.out.println(s); 				
		}
   }
    public void enterClassTopic() {
    	boxSearch.clear();
    	boxSearch.sendKeys("Sample 1");
    }
    public void getClassTopics() {
    	//reading data from table
    	int total_rows = driver.findElements(By.xpath("//table[@role='grid']//tr")).size();
    	System.out.println(total_rows);      	        	
    	ArrayList<String> sortedList = new ArrayList<>(); 
    	for(int r=1; r < total_rows; r++) {
    		List<WebElement> classtopics = driver.findElements(By.xpath("//tbody//tr["+r+"]//td[3]"));
    		if(classtopics != null) {
    			sortedList.add(classtopics.get(0).getText());
    		}else {
    			System.out.println("Class topic is not present in the table!");
    		}
        }
        Collections.sort(sortedList);
		
		for(String s : sortedList) {
			System.out.println(s); 				
		}
    }
    public void getClassDescriptions() {
    	//reading data from table
    	int total_rows = driver.findElements(By.xpath("//table[@role='grid']//tr")).size();
    	System.out.println(total_rows);      	        	
    	ArrayList<String> sortedList = new ArrayList<>(); 
    	for(int r=1; r < total_rows; r++) {
    		List<WebElement> classdes = driver.findElements(By.xpath("//tbody//tr["+r+"]//td[4]"));
    		if(classdes != null) {
    			sortedList.add(classdes.get(0).getText());
    		}else {
    			System.out.println("Class description is not present in the table!");
    		}
        }
        Collections.sort(sortedList);
		
		for(String s : sortedList) {
			System.out.println(s); 				
		}
    }
    public void getClassStatus() {
    	//reading data from table
    	int total_rows = driver.findElements(By.xpath("//table[@role='grid']//tr")).size();
    	System.out.println(total_rows);      	        	
    	ArrayList<String> sortedList = new ArrayList<>(); 
    	for(int r=1; r < total_rows; r++) {
    		List<WebElement> classstatus = driver.findElements(By.xpath("//tbody//tr["+r+"]//td[5]"));
    		if(classstatus != null) {
    			sortedList.add(classstatus.get(0).getText());
    		}else {
    			System.out.println("Class status is not present in the table!");
    		}
        }
        Collections.sort(sortedList);
		
		for(String s : sortedList) {
			System.out.println(s); 				
		}
    }
    public void getClassdates() {
    	//reading data from table
    	int total_rows = driver.findElements(By.xpath("//table[@role='grid']//tr")).size();
    	System.out.println(total_rows);      	        	
    	ArrayList<String> sortedList = new ArrayList<>(); 
    	for(int r=1; r < total_rows; r++) {
    		
    		List<WebElement> classdates = driver.findElements(By.xpath("//tbody//tr["+r+"]//td[6]"));
    		if(classdates != null) {
    			sortedList.add(classdates.get(0).getText());
    		}else {
    			System.out.println("Class date is not present in the table!");
    		}
         }
         Collections.sort(sortedList);
		
		for(String s : sortedList) {
			System.out.println(s); 				
		}
    }
    public void enterStaffName() {
    	boxSearch.clear();
    	boxSearch.sendKeys("arunasel");
    }
    public void getStaffNames() {
    	//reading data from table
    	int total_rows = driver.findElements(By.xpath("//table[@role='grid']//tr")).size();
    	System.out.println(total_rows);      	        	
    	ArrayList<String> sortedList = new ArrayList<>(); 
    	
    	for(int r=1; r < total_rows; r++) {
    		
    		List<WebElement> staffnames = driver.findElements(By.xpath("//tbody//tr["+r+"]//td[7]"));       		
    		//Collections.sort(staffnames);
    		if(staffnames != null) {
    			sortedList.add(staffnames.get(0).getText());    
    		}
    		else {    			
    			System.out.println("Staff name is not present in the row!");
    		}
    	}
    	
		Collections.sort(sortedList);
		
		for(String s : sortedList) {
			System.out.println(s); 				
		}
    }
  
   public void clickSortBatchName() {//sortBatchIcon	   
	   sortBatchIcon.click();
   }
   public void clickClassTopicSort() {
	   sortClassTopicIcon.click();
   }
   public void clickClassDescSort() {
	   sortClassTopicIcon.click();
   }
   public void clickClassStatusSort() {
	   sortClassStatusIcon.click();
   }
   public void clickClassDateSort() {
	   sortClassDateIcon.click();
   }
   public void clickClassStaffnameSort() {
	   sortClassStaffnameIcon.click();
   }
   public void clickDelete() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		WebElement deleteIcon = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='action']//button[@icon='pi pi-trash']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteIcon);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteIcon);

	}

   public void enterClassDetailsData() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Select a Batch Name']")).sendKeys("SMPO10");
		driver.findElement(By.xpath("//input[@id='classTopic']")).sendKeys("Java");
		driver.findElement(By.xpath("//input[@id='classDescription']")).sendKeys("test01");
		// date picker
		Thread.sleep(3000);
		WebElement date = driver.findElement(By.xpath("//input[@id='icon']"));
		Thread.sleep(3000);
		date.sendKeys("10/29/2024");
		driver.findElement(By.xpath("//span[@class='p-button-icon pi pi-calendar']")).click();
		driver.findElement(By.xpath("//input[@id='classNo']")).isEnabled();
		WebElement ele = driver.findElement(By.xpath("//label[normalize-space()='Recording']"));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", ele);
		System.out.println(js.executeScript("return window.pageYOffset"));
		driver.findElement(By.xpath("//input[@placeholder='Select a Staff Name']")).sendKeys("Karan");
		driver.findElement(By.xpath(
				"//p-radiobutton[@ng-reflect-input-id='Active']//div[@ng-reflect-ng-class='[object Object]']//div[@ng-reflect-ng-class='[object Object]']"))
				.click();
		driver.findElement(By.id("saveClass")).click();
   }
   public void enterInvalidClassDetailsData() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Select a Batch Name']")).sendKeys(" ");
		driver.findElement(By.xpath("//input[@id='classTopic']")).sendKeys(" ");
		driver.findElement(By.xpath("//input[@id='classDescription']")).sendKeys("test01");
		// date picker
		Thread.sleep(3000);
		WebElement date = driver.findElement(By.xpath("//input[@id='icon']"));
		Thread.sleep(3000);
		date.sendKeys(" ");
		driver.findElement(By.xpath("//span[@class='p-button-icon pi pi-calendar']")).click();
		driver.findElement(By.xpath("//input[@id='classNo']")).isEnabled();
		WebElement ele = driver.findElement(By.xpath("//label[normalize-space()='Recording']"));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", ele);
		System.out.println(js.executeScript("return window.pageYOffset"));
		driver.findElement(By.xpath("//input[@placeholder='Select a Staff Name']")).sendKeys(" ");
		driver.findElement(By.xpath(
				"//p-radiobutton[@ng-reflect-input-id='Active']//div[@ng-reflect-ng-class='[object Object]']//div[@ng-reflect-ng-class='[object Object]']"))
				.click();
		driver.findElement(By.id("saveClass")).click();
  }
   public void enterUpdateClassDetailsData() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Select a Batch Name']")).isEnabled();
		driver.findElement(By.xpath("//input[@id='classTopic']")).isEnabled();
		driver.findElement(By.xpath("//input[@id='classDescription']")).sendKeys("test description for java");
		// date picker
		Thread.sleep(3000);
		WebElement date = driver.findElement(By.xpath("//input[@id='icon']"));
		Thread.sleep(3000);
		date.sendKeys("10/29/2024");
		driver.findElement(By.xpath("//span[@class='p-button-icon pi pi-calendar']")).click();
		driver.findElement(By.xpath("//input[@id='classNo']")).isEnabled();
		WebElement ele = driver.findElement(By.xpath("//label[normalize-space()='Recording']"));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", ele);
		System.out.println(js.executeScript("return window.pageYOffset"));
		driver.findElement(By.xpath("//input[@placeholder='Select a Staff Name']")).sendKeys("Karan");
		driver.findElement(By.xpath(
				"//p-radiobutton[@ng-reflect-input-id='Active']//div[@ng-reflect-ng-class='[object Object]']//div[@ng-reflect-ng-class='[object Object]']"))
				.click();
		driver.findElement(By.id("saveClass")).click();
  }
   @SuppressWarnings("unused")
public boolean getAssertionMsg() {			
		String classtopicErr = driver.findElement(By.xpath("//small[@class='p-invalid ng-star-inserted']")).getText();
		String classdateErr = driver.findElement(By.xpath("//small[normalize-space()='Class Date is required.']")).getText();
		String noofclassesErr = driver.findElement(By.xpath("//small[normalize-space()='No. of Classes is required.']"))
				.getText();
		return true;				
   }
   
   public void getAlert() {
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   wait.until(ExpectedConditions.alertIsPresent());
	   Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText()); 
		alt.accept();
	   
   }
   public String checkToastMessage() {
	  
	   By toastSummary = By.xpath("//div[@class='p-toast-summary ng-tns-c91-27']") ;
   	   By toastDetail = By.xpath("//div[@class='p-toast-detail ng-tns-c91-28']") ;   
	   System.out.println("waiting for toast to appear...");
		WebDriverWait wait = new WebDriverWait(driver,java.time.Duration.ofMillis(5000));
		WebElement td = wait.until(ExpectedConditions.presenceOfElementLocated(toastDetail));
	
		WebElement ts = driver.findElement(toastSummary);
		
		String alertMessage = ts.getText() + " " + td.getText();
		//String alertMessage = toastMsg.toString();
		
		System.out.println("Toast message..." + alertMessage);

		return alertMessage;
   }
}
