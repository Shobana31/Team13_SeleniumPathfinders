package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{
	
	public WebDriver driver;
	
	//constructor
	public HomePage(WebDriver driver) {	
		 this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locating Element
	@FindBy(xpath="//input[@id='username']")
	WebElement txtUsername;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//span[@class='mat-button-wrapper']")
	WebElement btnLogin;
	
	@FindBy(xpath="//span[contains(text(),'LMS')]")
	WebElement titleofDashboardpage;
	
	@FindBy(xpath="//p[normalize-space()='Please login to LMS application']")
	WebElement titleofLoginpage;
	

	
	//Action methods
	
	public void enterUsername() {
		txtUsername.sendKeys("sdet@gmail.com");
	}
	
	public void enterPassword() {
		txtPassword.sendKeys("LmsHackathon@2024");
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	public String getDashboardTitle() {
		return titleofDashboardpage.getText();
	}
	public String getLoginTitle() {
		return titleofLoginpage.getText();
	}
	

}
