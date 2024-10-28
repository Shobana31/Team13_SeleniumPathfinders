package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

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
	
	@FindBy(xpath="//div[@role='checkbox']")
	WebElement iconCheckbox;
	
	@FindBy(xpath="//span[@class='p-paginator-current ng-star-inserted']")
	WebElement txtShowingmsg;
	
	@FindBy(xpath="//div[@class='p-paginator-bottom p-paginator p-component ng-star-inserted']")
	WebElement iconPagination;
	
	@FindBy(xpath="//span[@class='p-button-icon pi pi-trash'][1]")
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
	
	@FindBy(xpath="//span[@class='p-dropdown-trigger-icon ng-tns-c171-42 pi pi-chevron-down']")
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
	public void selectBatchName() throws InterruptedException {
		Select dropdownOps = new Select(inputBatchName);
		Thread.sleep(3000);
		dropdownOps.selectByVisibleText("Micro service-01");
		//dropdownOps.selectByValue("Micro service-01");
		
//		List<WebElement> ops = dropdownOps.getOptions();
//		System.out.println("Num of options:" + ops.size());
//		
//		for(WebElement op : ops) 
//		{
//			System.out.println(op.getText());
//			
//		}
	}
	public void setClassTopic() {
		inputClassTopic.sendKeys("Typescript");
	}
	
	public void setClassDescription() {
		inputClassDes.sendKeys("Test description");
	}
	
	public void clickDatePicker() {
		///html/body/app-root/app-session/p-dialog/div/div/div[2]/div[4]/p-calendar/span/button/span[1]
		
		clkDatepicker.click();//open date picker
		clkDatepicker.sendKeys("15/11/2024");
//		String monthandyear="November 2024";
//		String date="15";
		
		//select month and year
//		while(true) {
//			String currentMonthandYear=selectMonthandYear.getText();
//			if(currentMonthandYear.equals(monthandyear))
//			{
//				break;
//			}
//			selectNext.click();
//		}
//		
//		//select date
//		for(WebElement dt:selectAllDates) {
//			if(dt.getText().equals(date)) {
//				dt.click();
//				break;
//			}
//		}
//		
		
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
    	
    	for(int r=1; r < total_rows; r++) {    		
    		String batchname = driver.findElement(By.xpath("//tbody//tr["+r+"]//td[2]")).getText();
    		if(batchname !=null) {
    		System.out.println(batchname);
    		}else {
    			System.out.println("Batch name is not present in the table!");
    		}
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
    	
    	for(int r=1; r < total_rows; r++) {
    		String classtopic = driver.findElement(By.xpath("//tbody//tr["+r+"]//td[3]")).getText();
    		if(classtopic != null) {
    		System.out.println(classtopic);
    		}else {
    			System.out.println("Class topic is not present in the table!");
    		}
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
    	
    	for(int r=1; r < total_rows; r++) {
    		String staffname = driver.findElement(By.xpath("//tbody//tr["+r+"]//td[7]")).getText();
    		System.out.println(staffname);
    		if(staffname != null) {
    		System.out.println(staffname);
    		}else {    			
    			System.out.println("Staff name is not present in the table!");
    		}
    }
    }
  
   
}
