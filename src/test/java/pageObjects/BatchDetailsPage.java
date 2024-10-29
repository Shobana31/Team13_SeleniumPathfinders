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

	@FindBy(xpath = "//div[@role='button']")
	WebElement programNameDropdown;

	@FindBy(xpath = "//input[@placeholder='Select a Program name']")
	WebElement programName;

	@FindBy(xpath = "//label[@for='batchName']/following-sibling::input[1]")
	WebElement BatchNamePrefix;

	@FindBy(xpath = "//label[@for='batchName']/following-sibling::input[2]")
	WebElement BatchNameSuffix;

	@FindBy(xpath = "//label[@for='batchDescription']/following-sibling::input")
	WebElement description;

	@FindBy(xpath = "//div[@class='p-radiobutton-box'][1]")
	WebElement activeStatus;

	@FindBy(xpath = "//div[@class='p-radiobutton-box']/span[2]")
	WebElement inactiveStatus;

	@FindBy(id = "batchNoOfClasses")
	WebElement noOfClasses;

	@FindBy(id = "text-danger")
	WebElement error;

	@FindBy(xpath = "//button[@label='Save']")
	WebElement saveButton;

	@FindBy(xpath = "//button[@label='Cancel']")
	WebElement cancelButton;

	@FindBy(xpath = "//*[@header='Batch Details']//button[@type='button']")
	WebElement closeButton;

	@FindBy(xpath = "//div[contains(@class, 'p-toast-summary') and text()='Successful']")
	WebElement toastMessage;

	@FindBy(xpath = "//div[contains(@class, 'p-toast-detail ng-tns-c91-73') and text()='Batch Created Successfully']")
	WebElement toastCheckMessage;

	@FindBy(xpath = "//*[@class='p-invalid ng-star-inserted']")
	WebElement BlankFieldError;

	@FindBy(xpath = "//span[normalize-space()='Confirm']")
	WebElement deleteTitle;

	@FindBy(xpath = "//div[@class='p-dialog-footer ng-tns-c204-8 ng-star-inserted']/button[1]")
	WebElement deleteNoButton;

	@FindBy(xpath = "//div[@class='p-dialog-footer ng-tns-c204-8 ng-star-inserted']/button[2]")
	WebElement deleteYesButton;

	@FindBy(xpath = "//div[@class='p-dialog-header ng-tns-c204-8 ng-star-inserted']//button[@type='button']")
	WebElement deleteCloseButton;

	@FindBy(xpath = "//*[@class='mat-card-title']//button[@icon='pi pi-trash']")
	WebElement deleteAllButton;

	@FindBy(xpath = "//button[contains(@class, 'p-paginator-next')]")
	WebElement nextPagination;

	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-double-right']")
	WebElement lastPagination;

	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-left']")
	WebElement previousPagination;

	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-double-left']")
	WebElement firstPagination;

	@FindBy(id = "filterGlobal")
	WebElement searchTextBox;

	private int beforeCount;
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
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", activeStatus);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", activeStatus);
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
		WebElement programNameListBox = driver.findElement(
				By.xpath("//ul[@role='listbox']/p-dropdownitem/li[@aria-label='" + selectDataForProgramName() + "']"));
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
		return statusElement.getTagName().equals("input") && statusElement.getAttribute("type").equals("radio");
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
		if (saveCancel.equalsIgnoreCase("Save")) {
			saveButtonClick();
		} else {
			cancelButtonClick();
		}

	}

	public void leaveBlankField(String fieldToLeaveBlank, int rowIndex) {
		if (!fieldToLeaveBlank.equalsIgnoreCase("programNameDropdown")) {
			selectProgramNameDD();
			WebElement programNameListBox = driver
					.findElement(By.xpath("//ul[@role='listbox']/p-dropdownitem/li[@aria-label='"
							+ getDataFromExcel("Batch", "Program Name", rowIndex) + "']"));
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

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));

		try {
			wait.until(ExpectedConditions.visibilityOf(saveButton));
			wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
		} catch (ElementNotInteractableException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButton);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
		}

	}

	public void editMandatoryDetails(String saveCancel) {
		description.clear();
		description.sendKeys(getDataFromExcel("Batch", "Description", 10));
		getActiveStatusRadioButton();

		noOfClasses.clear();
		noOfClasses.sendKeys(getDataFromExcel("Batch", "Number of Classes", 10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));

		try {
			if (saveCancel.equalsIgnoreCase("Save")) {
				wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
			} else {
				wait.until(ExpectedConditions.elementToBeClickable(cancelButton)).click();
			}
		} catch (ElementClickInterceptedException e) {
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

	public void clickDeleteButtons(String buttonName) {
		WebElement overlay = driver.findElement(By.className("cdk-overlay-backdrop"));
		overlay.click();
		if (buttonName.equalsIgnoreCase("yes")) {
			deleteYesButton.click();
		} else if (buttonName.equalsIgnoreCase("no")) {
			deleteNoButton.click();
		} else {
			deleteCloseButton.click();
		}
	}

	public void storeBeforeCount() {
		String countText = driver.findElement(By.xpath("//span[@class='p-paginator-current ng-star-inserted']"))
				.getText();
		String[] parts = countText.split("of ");
		this.beforeCount = Integer.parseInt(parts[1].trim().split(" ")[0]);
	}

	public void selectCheckboxes(int rows) {

		List<WebElement> checkboxes = driver
				.findElements(By.xpath("//tbody[@class='p-datatable-tbody']//div[@role='checkbox']"));

		if (rows > checkboxes.size()) {
			throw new IllegalArgumentException("Count exceeds the number of available checkboxes");
		}
		this.selectedRows = rows;
		for (int i = 0; i < rows; i++) {
			WebElement checkbox = checkboxes.get(i);
			if (!checkbox.isSelected()) {

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));

				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
				try {

					wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
				} catch (ElementClickInterceptedException e) {

					((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
				}
			}
		}
		clickdeleteAllButton();
		clickDeleteButtons("yes");

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

	public void enterSearch() {
		searchTextBox.clear();
		searchTextBox.sendKeys(getDataFromExcel("Batch", "Batch Name", 11));
	}

	public boolean validateSearch() {
		boolean flag = false;
		WebElement dataTable = driver
				.findElement(By.xpath("//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']"));
		waitForElementToBeVisible(dataTable, 10);
		int retryCount = 0;
	    while (retryCount < 3) { 
	        try {
		List<WebElement> batchRows = driver.findElements(By.xpath("//tbody[@class='p-datatable-tbody']/tr/td[2]"));
		 if (batchRows.size() > 0) {
		for (WebElement row : batchRows) {
			String rowText = row.getText();
			if (rowText.contains(getDataFromExcel("Batch", "Batch Name", 11))) {
				flag = true;
				break;
			 }
        }
    } else {
        System.out.println("No results found in the data table.");
    }
		 break; 
	        } catch (StaleElementReferenceException e) {
	            retryCount++;
	            System.out.println("StaleElementReferenceException encountered. Retrying... " + retryCount);
	        }
	    }
	    if (retryCount >= 3) {
	        System.out.println("Failed to validate search due to stale elements after multiple retries.");
	    }
		return flag;
	}

}
