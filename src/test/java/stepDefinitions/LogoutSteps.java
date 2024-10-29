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
import utilities.PropertyLoader;


public class LogoutSteps extends CommonMethods {

    WebDriver driver = appHooks.getDriver();
    LoginPage lp = new LoginPage(driver);
    DashboardPage dp = new DashboardPage(driver);
    private PropertyLoader propertyLoader;

    public LogoutSteps() {
        propertyLoader = new PropertyLoader();
    }

    @Given("Admin landed in login Page")
    public void admin_landed_in_login_page() {
        implicitlyWait();
        getURL();
    }
    @When("Admin enter valid credentials and clicks login button")
    public void admin_enter_valid_credentials_and_clicks_login_button() {
        lp.txtUserName.sendKeys(propertyLoader.getProperty("Username"));
        lp.txtPassword.sendKeys(propertyLoader.getProperty("Password"));
        lp.clickLogin();
    }
    @Given("Admin is in dashboard page")
    public void admin_is_in_dashboard_page() {
        Assert.assertEquals(getPageTitle(driver), "LMS");
    }
    @When("Admin clicks on the logout in the menu bar")
    public void admin_clicks_on_the_logout_in_the_menu_bar() {
       elementClick(dp.lnkLogout);
    }
    @Then("Admin should be redirected to login page")
    public void admin_should_be_redirected_to_login_page() {
        Assert.assertEquals(getPageTitle(driver), "LMS");
    }
}
