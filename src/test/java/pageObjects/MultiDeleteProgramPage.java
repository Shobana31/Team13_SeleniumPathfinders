package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hooks.appHooks;

public class MultiDeleteProgramPage {
	private int beforeCount;
	private int afterCount;
	private int selectedRows;

WebDriver driver = appHooks.getDriver();
	

	
	public MultiDeleteProgramPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locating Element
	@FindBy(xpath = "//div[@role='checkbox']")
	List<WebElement> multicheckbox;
	
	@FindBy(xpath = "//th[@class='p-sortable-column']")
	WebElement sortby;
	
	@FindBy(xpath = "//button[@class='p-button-danger p-button p-component p-button-icon-only']")
	WebElement MultiDeleteBtn;
	
	@FindBy(xpath = "//span[normalize-space()='Confirm']")
	WebElement deleteTitle;
	
	@FindBy(xpath = "/html/body/app-root/app-session/p-confirmdialog/div/div/div[3]/button[1]")
	WebElement deleteNoButton;

	@FindBy(xpath = "ng-tns-c204-8 p-confirm-dialog-accept p-ripple p-button p-component ng-star-inserted']")
	WebElement deleteYesButton;
	
	@FindBy(xpath="ng-tns-c204-8 p-dialog-header-icon p-dialog-header-close p-link ng-star-inserted")
	WebElement closeConfirmationPage;
	
	//Actions methods
	
	public List<WebElement> getmulticheckbox() {
		return multicheckbox;
		
	}
	
	public WebElement getsortby() {
		return sortby;
		
	}
	
	public WebElement getMultiDeleteBtn() {
		return MultiDeleteBtn;
		}
	
	public WebElement getdeleteTitle() {
		return deleteTitle;
		}
	
	public WebElement getDeleteNoButton() {
		return deleteNoButton;
	}

	public WebElement getDeleteYesButton() {
		return deleteYesButton;
	}
	
	public WebElement getcloseConfirmationPage() {
		return closeConfirmationPage;
	}
	
	public void clickdeleteAllButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
		WebElement deleteButton = getMultiDeleteBtn();
		wait.until(ExpectedConditions.visibilityOf(deleteButton));
		wait.until(ExpectedConditions.elementToBeClickable(deleteButton));

		try {
			deleteButton.click();
		} catch (ElementClickInterceptedException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteButton);
		}

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
	
	}
	
	
}
