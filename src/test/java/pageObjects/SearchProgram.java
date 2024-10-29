package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hooks.appHooks;
import utilities.CommonMethods;

public class SearchProgram extends CommonMethods{

WebDriver driver = appHooks.getDriver();
	

	
	public SearchProgram(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locating Element
		@FindBy(xpath = "//input[@id ='filterGlobal']")
		WebElement programLink;
		
		public void getprogramLink() {
			 programLink.click();;
		}
	
}
