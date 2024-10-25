package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

    @FindBy(how=How.XPATH, using = "//span[@class='mat-placeholder-required mat-form-field-required-marker ng-tns-c78-10 ng-star-inserted']")
    public WebElement astriPassword;

    @FindBy(how=How.XPATH, using = "//span[@class='mat-placeholder-required mat-form-field-required-marker ng-tns-c78-9 ng-star-inserted']")
    public WebElement astriUser;

//    @FindBy(how=How.XPATH, using = "mat-form-field-label")
}
