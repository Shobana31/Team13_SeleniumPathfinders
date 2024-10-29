package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hooks.appHooks;
import stepDefinitions.LoginSteps;
import utilities.CommonMethods;

public class ManageProgramPage extends CommonMethods {

	
	WebDriver driver = appHooks.getDriver();
	

	
	public ManageProgramPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locating Element
	@FindBy(xpath = "//button[@id='program']")
	WebElement programLink;

	@FindBy(xpath = "//div[normalize-space()='Manage Program']")
	String managePgmMainHeader;
	
	@FindBy(xpath= "//tbody[@class='p-datatable-tbody']/tr")
	public List<WebElement> managePgmTbleRow; 
	
	@FindBy(xpath="//tbody[@class='p-datatable-tbody']/tr/td")
	
		List<WebElement> managePgmTbleCell;
	
	
	@FindBy(xpath= "//div[@class='p-datatable-wrapper ng-star-inserted']/table/thead/tr/th")
	public List<WebElement> managePgmTbleRowHeaders;
	
	@FindBy(xpath = "//button[@class='p-button-danger p-button p-component p-button-icon-only']")
	WebElement multiDeleteBtn;
	
	@FindBy(xpath = "//span[@class='p-input-icon-left']")
	WebElement searchBar;

	@FindBy(xpath = "//input[@id='filterGlobal']")
	WebElement searchBarText;
	
	@FindBy(xpath = "//div[@class='cdk-overlay-backdrop cdk-overlay-transparent-backdrop cdk-overlay-backdrop-showing']")
	WebElement programPopUpout;
	
	@FindBy(xpath = "//div[@id='mat-menu-panel-3']")
	WebElement programPopUp;
	
	@FindBy(xpath = "//div[@class='p-checkbox-box']")
	WebElement checkbox_default;
	
	@FindBy(xpath = "//div[@class='p-checkbox-box p-component']")
	List<WebElement> prgm_default_checkbox;
	
	@FindBy(xpath = "//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']")
	List<WebElement> prgm_sort_icon;
	
	@FindBy(xpath = "/html/body/app-root/app-program/div/mat-card/mat-card-content/p-table/div/p-paginator/div/span[1]")
	WebElement pagination_icon;
	
	@FindBy(xpath = "//div[@class= 'p-d-flex p-ai-center p-jc-between ng-star-inserted']")
	WebElement pgm_footer_message;
	
	//div[@id='cdk-overlay-1']
	//div[@class='p-datatable-wrapper ng-star-inserted']/table/thead/tr/th
	
	// Action methods

	public WebElement getprogramLink() {
	return programLink;
		
		
	}
	
	public String getmanagePgmMainHeader() {
		return managePgmMainHeader;
		
	}
	
	public List<WebElement> getListmanagePgmTbleRow() {
		return managePgmTbleRow;
	}
	
	public List<WebElement> getmanagePgmTbleCell(WebElement webElement) {
		return managePgmTbleCell;
	}
	
	public List<WebElement> getmanagePgmTbleRowHeaders() {
		return managePgmTbleRowHeaders;
	}
		
		public WebElement getmultiDeleteBtn() {
			
			return multiDeleteBtn;
		
	}
	
		public WebElement getsearchBar() {
			
			return searchBar;
		}
	
public WebElement getsearchBarText() {
			
			return searchBarText;
		}

public WebElement getprogramPopUpOut() {
	
	return programPopUpout;
}

public WebElement getprogramPopUp() {
	
	return programPopUp;
}

public WebElement getcheckbox_default() {
	
	return checkbox_default;
}

public List<WebElement> getprgm_default_checkbox() {
	return prgm_default_checkbox;
}

public List<WebElement> getprgm_sort_icon() {
	return prgm_sort_icon;
}

public WebElement getpagination_icon() {
	return pagination_icon;
}

public WebElement getpgm_footer_message() {
	return pgm_footer_message;
}
}
