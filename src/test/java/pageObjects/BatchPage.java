package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReader;

public class BatchPage {

	public WebDriver driver;
	private ExcelReader excelReader;
		
		//constructor
	public BatchPage(WebDriver driver, String excelPath) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	    this.excelReader = new ExcelReader(excelPath);
	}
		
		//Locating Element
		@FindBy(xpath="//div[normalize-space()='Manage Batch']")
		WebElement titleofBatchPage;
		
		@FindBy(xpath="//*[@class=\"mat-card-title\"]/child::div[2]//button")
		WebElement deleteIconManageBatch;
		
		@FindBy(xpath="//p-paginator[@class='ng-star-inserted']")
		WebElement paginationControl;
		
		@FindBy(xpath="//div[@class='action']//button[@icon='pi pi-pencil']")
		WebElement editIcon;
		
		@FindBy(xpath="//div[@class='action']//button[@icon='pi pi-trash']")
		WebElement deleteIcon;
		
		@FindBy(xpath="//tbody[@class='p-datatable-tbody']//div[@class='p-hidden-accessible']/input")
		WebElement checkboxRow;
		
		@FindBy(xpath="//thead[@class='p-datatable-thead']//th")
		WebElement dataTableHeader;
		
		@FindBy(xpath="//thead[@class='p-datatable-thead']//div[@class='p-hidden-accessible']")
		WebElement checkboxHeader;
		
		@FindBy(xpath="//thead[@class='p-datatable-thead']//th/p-sorticon")
		WebElement sortIconHeader;
		
		//Action methods

		public String getBatchTitle() {
		
			return titleofBatchPage.getText();
		}
		
		public boolean clickDeleteIconManage() {
			return deleteIconManageBatch.isEnabled();	
			
		}
		
		public boolean clickPaginationControl() {
			return paginationControl.isEnabled();
					}
		
		public int clickEditIcon() {
			List<WebElement> li = driver.findElements(By.xpath("//div[@class='action']//button[@icon='pi pi-pencil']"));
			return li.size();
		}
		
		public int clickDeleteIcon() {
			List<WebElement> li = driver.findElements(By.xpath("//div[@class='action']//button[@icon='pi pi-trash']"));
			return li.size();
		}
		
		public int clickCheckBoxRow() {
			List<WebElement> li = driver.findElements(By.xpath("//tbody[@class='p-datatable-tbody']//div[@class='p-hidden-accessible']/input"));
			return li.size();
		}
		
		public boolean clickCheckBoxHeader() {
			return checkboxHeader.isDisplayed();
			
		}
		public String[] verifyHeader() {
			List<WebElement> li = driver.findElements(By.xpath("//thead[@class='p-datatable-thead']//th"));
			String[] headers = new String[li.size()-1];
			for(int i=1; i<li.size(); i++) {
				 headers[i-1] = li.get(i).getText();	
			}
			return headers;
		}
		
		public int clickSortIconHeader() {
			List<WebElement> li = driver.findElements(By.xpath("//thead[@class='p-datatable-thead']//th/p-sorticon"));
			return li.size();
		}
		
		 public String getDataFromExcel(String sheetName, String header, int rowNum) {
		        excelReader.setSheet(sheetName); // Set the sheet you want to read
		        return excelReader.getCellData(header, rowNum); // Get the cell data based on header and row number
		    }

		    public void closeExcel() {
		        excelReader.close(); // Close the Excel reader when done
		    }
		


	
}
