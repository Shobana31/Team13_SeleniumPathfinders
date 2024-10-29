package stepDefinitions;

import hooks.appHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import utilities.CommonMethods;
import utilities.LoggerLoad;
import utilities.PropertyLoader;


public class LogoutSteps extends CommonMethods {

    WebDriver driver = appHooks.getDriver();
    LoginPage lp = new LoginPage(driver);
    DashboardPage dp = new DashboardPage(driver);
	 LoggerLoad logs = new LoggerLoad();
    private PropertyLoader propertyLoader;

    public LogoutSteps() {
        propertyLoader = new PropertyLoader();
    }

    @Given("Admin is in dashboard page")
    public void admin_is_in_dashboard_page() {
    	 implicitlyWait();
         getURL();
         lp.txtUserName.sendKeys(propertyLoader.getProperty("Username"));
         lp.txtPassword.sendKeys(propertyLoader.getProperty("Password"));
         lp.clickLogin();
    }
  
    @When("Admin clicks on the logout in the menu bar")
    public void admin_clicks_on_the_logout_in_the_menu_bar() {
       elementClick(dp.lnkLogout);
    }
    @Then("Admin should be redirected to login page")
    public void admin_should_be_redirected_to_login_page() {
    	 Assert.assertEquals(elementGetText(lp.visibletxtLoginToLMS), "Please login to LMS application");
 		logs.info("Admin logged out successfully");
    }
}
