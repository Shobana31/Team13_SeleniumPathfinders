package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.CommonMethods;

public class BatchDetailsPage extends CommonMethods {


	public BatchDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Locating Element
	
		
		@FindBy(xpath="//div[@role='button']")
		WebElement programNameDropdown;
		
		@FindBy(xpath="//input[@placeholder='Select a Program name']")
		WebElement programName;
		
		@FindBy(xpath = "//label[@for='batchName']/following-sibling::input[1]")
		WebElement BatchNamePrefix;
		
		@FindBy(xpath = "//label[@for='batchName']/following-sibling::input[2]")
		WebElement BatchNameSuffix;
		
		@FindBy(xpath="//label[@for='batchDescription']/following-sibling::input")
		WebElement description;
		
		@FindBy(xpath="//p-radiobutton[@ng-reflect-input-id='ACTIVE']//following-sibling::div[@class='p-radiobutton-box']/span")
		WebElement activeStatus;
	
		@FindBy(xpath="//div[@class='p-radiobutton-box']/span[2]")
		WebElement inactiveStatus;
		
		@FindBy(id="batchNoOfClasses")
		WebElement noOfClasses;
		
		@FindBy(id="text-danger")
		WebElement error;
		
		@FindBy(xpath="//button[@label='Save']")
		WebElement saveButton;
		
		@FindBy(xpath="//button[@label='Cancel']")
		WebElement cancelButton;
		
		@FindBy(xpath="//*[@header='Batch Details']//button[@type='button']")
		WebElement closeButton;
		
		@FindBy(xpath="//div[contains(@class, 'p-toast-summary') and text()='Successful']")
		WebElement toastMessage;
		
		@FindBy(xpath="//div[contains(@class, 'p-toast-detail ng-tns-c91-73') and text()='Batch Created Successfully']")
		WebElement toastCheckMessage;
		
		@FindBy(xpath="//*[@class='p-invalid ng-star-inserted']")
		WebElement BlankFieldError;
		
		@FindBy(xpath="//span[normalize-space()='Confirm']")
		WebElement deleteTitle;
		
		@FindBy(xpath="//div[@class='p-dialog-footer ng-tns-c204-8 ng-star-inserted']/button[1]")
		WebElement deleteNoButton;
		
		@FindBy(xpath="//div[@class='p-dialog-footer ng-tns-c204-8 ng-star-inserted']/button[2]")
		WebElement deleteYesButton;
		
		@FindBy(xpath= "//div[@class='p-dialog-header ng-tns-c204-8 ng-star-inserted']//button[@type='button']")
		WebElement deleteCloseButton;
		
		@FindBy(xpath="//*[@class='mat-card-title']//button[@icon='pi pi-trash']")
		WebElement deleteAllButton;
		
		@FindBy(xpath="//button[@class='p-paginator-next p-paginator-element p-link p-ripple']")
		WebElement nextPagination;
		
		@FindBy(xpath="//button[@class='p-paginator-last p-paginator-element p-link p-ripple ng-star-inserted']")
		WebElement lastPagination;
		
		@FindBy(xpath="//button[@class='p-paginator-prev p-paginator-element p-link p-ripple']")
		WebElement previousPagination;
		
		@FindBy(xpath="//button[@class='p-paginator-first p-paginator-element p-link p-ripple ng-star-inserted']")
		WebElement firstPagination;
		
		@FindBy(id="filterGlobal")
		WebElement searchTextBox;
		
		  private int beforeCount; // To store the count of entries before deletion
		    private int afterCount; 
		    private int selectedRows;
		    
		  public WebElement getBatchNameSuffixTextBox() {
		        return BatchNameSuffix;
		    }

	    public WebElement getBatchNamePrefixTextBox() {
	        return BatchNamePrefix;
	    }

	    public WebElement getNumberOfClassesTextBox() {
	        return noOfClasses;
	    }

	    public WebElement getDescriptionTextBox() {
	        return description;
	    }

	    public WebElement getProgramNameDropdown() {
	        return programNameDropdown;
	    }

	    public WebElement getProgramNameText() {
	    	return programName;
	    }
	    public void getActiveStatusRadioButton() {
	         activeStatus.click();;
	    }
	    
	    public WebElement getInActiveStatusRadioButton() {
	        return inactiveStatus;
	    }
	    
	    public String getblankFieldText() {
	        return BlankFieldError.getText();
	    }
	    
	    public String getError() {
			return elementGetText(error);
	          }
	
	    
	    public void selectProgramNameDD() {
	    	programNameDropdown.click();
	    }
	    
	    public void selectProgramNameListBox() {
	    WebElement programNameListBox = driver.findElement(By.xpath("//ul[@role='listbox']/p-dropdownitem/li[@aria-label='"+selectDataForProgramName()+"']"));
	    System.out.println(programNameListBox);	
	    programNameListBox.click();
	    }
	    public String getBatchNamePrefix() {
	    	waitForElementToBeVisible(BatchNamePrefix, 10);
	        return BatchNamePrefix.getAttribute("value");
	    }
	    
	    public String setInvalidDataFromBatchName() {
			return getDataFromExcel("Batch", "Batch Name", 2);
			
		}
	    
	    public String selectDataForProgramName() {
	    	return getDataFromExcel("Batch", "Program Name", 3);
	    }

	    
	    public boolean isStatusRadioButton() {
	    	getActiveStatusRadioButton();
	    	WebElement statusElement = driver.findElement(By.xpath("//input[@type='radio']"));
	     return statusElement.getTagName().equals("input") && 
              statusElement.getAttribute("type").equals("radio");
	    }
	   

	  
	    
	    public void saveButtonClick() {
	    	saveButton.click();
	    }
	    
	    public void cancelButtonClick() {
	    	cancelButton.click();
	    }
	    
	    public void closeButtonClick() {
	    	closeButton.click();
	    }
	    
	    
	    
	    public String getToast() {
	    	waitForElementToBeVisible(toastMessage, 10);
	    	return toastMessage.getText();
	    }
	    
	    public String getToastCheck() {
	    	waitForElementToBeVisible(toastCheckMessage, 10);
	    	return toastCheckMessage.getText();
	    }
	    public void enterMandatoryDetails() {
	    	 selectProgramNameDD();
	    	 selectProgramNameListBox();
	    	BatchNameSuffix.sendKeys(getDataFromExcel("Batch", "Batch Name", 3));
	    	description.sendKeys(getDataFromExcel("Batch", "Description", 3));
	    	getActiveStatusRadioButton();
	    	noOfClasses.sendKeys(getDataFromExcel("Batch", "Number of Classes", 3));
	    	saveButtonClick();
	    
	    }
	    
	    public void enterAllDetails(String saveCancel) {
	    	 selectProgramNameDD();
	    	 selectProgramNameListBox();
	    	BatchNameSuffix.sendKeys(getDataFromExcel("Batch", "Batch Name", 4));
	    	description.sendKeys(getDataFromExcel("Batch", "Description", 4));
	    	getActiveStatusRadioButton();
	    	noOfClasses.sendKeys(getDataFromExcel("Batch", "Number of Classes", 4));
	    	if(saveCancel.equalsIgnoreCase("Save")) {
	    		saveButtonClick();
	    	}
	    	else {
	    		cancelButtonClick();
	    	}
	    
	    }
	    
	    public void leaveBlankField(String fieldToLeaveBlank, int rowIndex) {
	    	if (!fieldToLeaveBlank.equalsIgnoreCase("programNameDropdown")) {
	    	selectProgramNameDD();
	        WebElement programNameListBox = driver.findElement(By.xpath("//ul[@role='listbox']/p-dropdownitem/li[@aria-label='"+getDataFromExcel("Batch", "Program Name", rowIndex)+"']"));
		    System.out.println(programNameListBox);	
		    programNameListBox.click();
	    	}
	        if (!fieldToLeaveBlank.equalsIgnoreCase("BatchNameSuffix")) {
	            BatchNameSuffix.sendKeys(getDataFromExcel("Batch", "Batch Name", rowIndex));
	        }

	        if (!fieldToLeaveBlank.equalsIgnoreCase("Description")) {
	            description.sendKeys(getDataFromExcel("Batch", "Description", rowIndex));
	        }
	        getActiveStatusRadioButton();
	        if (!fieldToLeaveBlank.equalsIgnoreCase("NoOfClasses")) {
	            noOfClasses.sendKeys(getDataFromExcel("Batch", "Number of Classes", rowIndex));
	        }
	        saveButtonClick();
	    }
	    
	    public void editDescriptionNoOfClassesDetails() throws ElementClickInterceptedException {
	    	description.clear();
	    	description.sendKeys(getDataFromExcel("Batch", "Description", 2));
	    	
	    	getActiveStatusRadioButton();
	    	noOfClasses.clear();
	 
	    	noOfClasses.sendKeys(getDataFromExcel("Batch", "Number of Classes", 2));

	    	// Initialize WebDriverWait
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    	// Wait for the overlay to disappear
	    	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));

	    	// Attempt to click the Save button, using JavaScript if necessary
	    	try {
	    	    // Ensure the button is visible and clickable
	    	    wait.until(ExpectedConditions.visibilityOf(saveButton));
	    	    wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
	    	} catch (ElementNotInteractableException e) {
	    	    // Fallback: Scroll into view, then click with JavaScript
	    	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButton);
	    	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
	    	}
	    	////p-radiobutton[@ng-reflect-input-id='ACTIVE']//following-sibling::div[@class='p-radiobutton-box']

	    }
	    
	  	
	    public void editMandatoryDetails(String saveCancel) {
	    	description.clear();
	    	description.sendKeys(getDataFromExcel("Batch", "Description", 10));
	    	getActiveStatusRadioButton();

	    	noOfClasses.clear();
	    	noOfClasses.sendKeys(getDataFromExcel("Batch", "Number of Classes", 10));
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    	// Wait for the overlay to disappear
	    	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));

	    	// Click Save or Cancel based on the condition
	    	try {
	    	    if (saveCancel.equalsIgnoreCase("Save")) {
	    	        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
	    	    } else {
	    	        wait.until(ExpectedConditions.elementToBeClickable(cancelButton)).click();
	    	    }
	    	} catch (ElementClickInterceptedException e) {
	    	    // If the overlay blocks the click, use JavaScript as a fallback
	    	    WebElement buttonToClick = saveCancel.equalsIgnoreCase("Save") ? saveButton : cancelButton;
	    	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonToClick);
	    	}
	    
	    }
	    
	    public String getDeleteTitle() {
			return elementGetText(deleteTitle);
		}
		
	    
	    public String getDeleteNoButton() {
			return elementGetText(deleteNoButton);
		}
	    public String getDeleteYesButton() {
			return elementGetText(deleteYesButton);
		}
	    
	    public void clickdeleteAllButton() {
	    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	    
	    	    // Wait for any overlay to disappear
	    	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));

	    	    // Locate the delete button
	    	    WebElement deleteButton = driver.findElement(By.xpath("//*[@class='mat-card-title']//button[contains(@class, 'p-button-danger')]"));

	    	    // Wait until the delete button is visible and clickable
	    	    wait.until(ExpectedConditions.visibilityOf(deleteButton));
	    	    wait.until(ExpectedConditions.elementToBeClickable(deleteButton));

	    	    try {
	    	        // Attempt to click the button
	    	    	deleteButton.click();
	    	    } catch (ElementClickInterceptedException e) {
	    	        // If click is intercepted, use JavaScript to click the button
	    	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteButton);
	    	    }
	    	    
	    
	    }
	    public void clickDeleteButtons(String buttonName) {
	    	WebElement overlay = driver.findElement(By.className("cdk-overlay-backdrop"));
	    	overlay.click();
	    	if(buttonName.equalsIgnoreCase("yes")) {
	    		deleteYesButton.click();
	    	}
	    	else if(buttonName.equalsIgnoreCase("no")) {
	    		deleteNoButton.click();
	    	}
	    	else {
	    		deleteCloseButton.click();
	    	}
	    }
	 
	    public void storeBeforeCount() {
	        String countText = driver.findElement(By.xpath("//span[@class='p-paginator-current ng-star-inserted']")).getText();
	        // Extract the total entries from the text
	        String[] parts = countText.split("of ");
	        this.beforeCount = Integer.parseInt(parts[1].trim().split(" ")[0]);
	        System.out.println("Before Count: " + beforeCount);
	    }
	    
	    public void selectCheckboxes(int rows) {
	       
	        List<WebElement> checkboxes = driver.findElements(By.xpath("//tbody[@class='p-datatable-tbody']//div[@role='checkbox']"));

	         if (rows > checkboxes.size()) {
	            throw new IllegalArgumentException("Count exceeds the number of available checkboxes");
	        }
	         this.selectedRows = rows; 
	         for (int i = 0; i < rows; i++) {
	             WebElement checkbox = checkboxes.get(i);

	             // Check if the checkbox is not already selected
	             if (!checkbox.isSelected()) {
	                 // Wait for any overlay to disappear
	                 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	                 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));

	                 // Scroll the checkbox into view and click
	                 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
	                 try {
	                     // Click the checkbox
	                     wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
	                 } catch (ElementClickInterceptedException e) {
	                     // If the click is intercepted, try clicking using JavaScript
	                     ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
	                 }
	             }
	         }
	            	clickdeleteAllButton();
	            	clickDeleteButtons("yes");
	            
	            
	        }
	    
	    public void storeAfterCount() {
	        String countText = driver.findElement(By.xpath("//span[@class='p-paginator-current ng-star-inserted']")).getText();
	        // Extract the total entries from the text
	        String[] parts = countText.split("of ");
	        this.afterCount = Integer.parseInt(parts[1].trim().split(" ")[0]);
	        System.out.println("After Count: " + afterCount);
	    }

	    public void validateCount() {
	        // Calculate expected count after deletion
	        int expectedCount = beforeCount - selectedRows;
	        storeAfterCount(); // Store the count after deletion

	        // Verify that the afterCount matches the expected count
	        if (afterCount != expectedCount) {
	            throw new AssertionError("Count validation failed: Expected " + expectedCount + ", but found " + afterCount);
	        } else {
	            System.out.println("Count validation successful: " + afterCount + " entries remain.");
	        }
	    }
	    
	    public WebElement nextPageLink() {
	    	return nextPagination; 
	    }
	    public WebElement lastPageLink() {
	    	return lastPagination; 
	    }
	    public WebElement previousPageLink() {
	    	return previousPagination; 
	    }
	    public WebElement firstPageLink() {
	    	return firstPagination; 
	    }
	    
	    public void isPaginationEnabled(String pageLink) {
	    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	    
	    	    // Wait for the overlay to disappear
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

	    	    // Ensure the element is in view
	    	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paginationElement);

	    	    // Wait until the pagination button is clickable
	    	    wait.until(ExpectedConditions.elementToBeClickable(paginationElement));

	    	    
	    	    try {
	    	        paginationElement.click();
	    	    } catch (ElementClickInterceptedException e) {
	    	        // Recheck for overlay visibility
	    	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
	    	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", paginationElement);
	    	    } catch (StaleElementReferenceException e) {
	    	        // Retry logic in case the element became stale
	    	        isPaginationEnabled(pageLink); // Recursively call the method
	    	    }
	    }
	   
	    
	  public void enterSearch() {
		  searchTextBox.clear();
		  searchTextBox.sendKeys(getDataFromExcel("Batch", "Batch Name", 11));
	  }
	 
	  public boolean validateSearch() {
		  boolean flag = false;
		  WebElement dataTable = driver.findElement(By.xpath("//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']"));
		  waitForElementToBeVisible(dataTable, 10);
		  List<WebElement> batchRows = driver.findElements(By.xpath("//tbody[@class='p-datatable-tbody']/tr/td[2]"));
    for (WebElement row : batchRows) {
    	//System.out.println(batchRows.size());
        String rowText = row.getText();
      //  System.out.println(rowText);
        if (rowText.contains(getDataFromExcel("Batch", "Batch Name", 11))) {
        	 flag = true;
        	 break;
        }
       
    	}
	return flag;
	
    
}
	   
	    
     
}
