package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@FindBy(id="login")
	WebElement btnLogin;
	
	@FindBy(xpath="//span[normalize-space()='LMS - Learning Management System']")
	WebElement titleofDashboardpage;
	
	@FindBy(xpath="//p[text()='Please login to LMS application']")
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 WebElement titleofDashboardpage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='LMS - Learning Management System']")));

		return titleofDashboardpage.getText();
	}
	public String getLoginTitle() {
		return titleofLoginpage.getText();
	}

}
