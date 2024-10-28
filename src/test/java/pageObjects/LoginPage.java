package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.PropertyLoader;

public class LoginPage {

    private WebDriver driver;
    private PropertyLoader propertyLoader;
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        propertyLoader = new PropertyLoader();
    }
    



    @FindBy(how=How.XPATH, using = "//img[@class='images']")
    public WebElement logo;

    @FindBy(how = How.XPATH, using = "(//p[normalize-space()='Please login to LMS application'])[1]")
    public WebElement visibletxtLoginToLMS;

    @FindBy(how= How.XPATH, using = "//body[@class='mat-typography']")
    public WebElement loginPageBody;

    @FindBy(how= How.XPATH, using = "//input[@id='username']")
    public WebElement txtUserName;

    @FindBy(how= How.XPATH, using = "//input[@id='password']")
    public WebElement txtPassword;

    @FindBy(how=How.ID, using = "login")
    public WebElement btnLogin;

    @FindBy(how=How.XPATH, using = "//span[@class='mat-placeholder-required mat-form-field-required-marker ng-tns-c78-1 ng-star-inserted']")
    public WebElement astriPassword;

    @FindBy(how=How.XPATH, using = "//span[@class='mat-placeholder-required mat-form-field-required-marker ng-tns-c78-0 ng-star-inserted']")
    public WebElement astriUser;

    @FindBy(how=How.XPATH, using = "mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted")
    public WebElement dashboardMenuBar;

    @FindBy(how=How.XPATH, using = "//mat-error[@id='mat-error-0']")
    public WebElement errMsgUsername;

    @FindBy(how=How.XPATH, using = "//mat-error[@id='mat-error-1']")
    public WebElement errMsgPassword;

    @FindBy(how = How.XPATH, using = "//mat-error[@id='errormessage']")
    public WebElement errMsg;

	public void enterUsername() {
		
		txtUserName.sendKeys(propertyLoader.getProperty("Username"));
		
	}

	public void enterPassword() {
		
		txtPassword.sendKeys(propertyLoader.getProperty("Password"));
		
	}

	public void clickLogin() {
		btnLogin.click();
	}

    public void sendUnamePwd(String username,String password) {
        txtUserName.sendKeys(username);
        txtPassword.sendKeys(password);

    }

   public void loginKeyboardActions(){
       Actions actions = new Actions(driver);
       actions.click(txtUserName)
               .sendKeys(propertyLoader.getProperty("Username")) // replace with actual username
               .perform();
       actions.sendKeys(Keys.TAB)
               .sendKeys(propertyLoader.getProperty("Password")) // replace with actual password
               .perform();
       actions.sendKeys(Keys.ENTER).perform();
   }

    public void loginMouseActions(){
        Actions actions = new Actions(driver);
        actions.moveToElement(txtUserName).click()
                .sendKeys(propertyLoader.getProperty("Username")) // replace with actual username
                .perform();
        actions.moveToElement(txtPassword).click()
                .sendKeys(propertyLoader.getProperty("Password")) // replace with actual password
                .perform();
        actions.moveToElement(btnLogin).click().perform();
    }
//    @FindBy(how=How.XPATH, using = "mat-form-field-label")
}
