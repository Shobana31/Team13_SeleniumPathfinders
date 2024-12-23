package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import hooks.appHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BatchPage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import utilities.CommonMethods;
import utilities.LoggerLoad;
import utilities.PropertyLoader;

public class Batch_BatchPageNavigation extends CommonMethods {

	WebDriver driver = appHooks.getDriver();
	DashboardPage dp = new DashboardPage(driver);
	LoginSteps ls = new LoginSteps();
	BatchPage bp = new BatchPage(driver);
	LoggerLoad logs = new LoggerLoad();

	@Given("Admin successfully Logged on to LMS Portal")
	public void admin_successfully_logged_on_to_the_lms_portal() {
		getURL();
		ls.admin_enter_valid_credentials_and_clicks_login_button();
		implicitlyWait();
	}

	@When("Admin Clicks on the Batch menu from the header")
	public void admin_clicks_on_the_batch_menu_from_the_header() {
		dp.clickBatchLink();
	}

	@Then("Admin should be in the Manage Batch Page")
	public void admin_should_be_in_the_manage_batch_page() {
		Assert.assertEquals(bp.getBatchTitle(), "Manage Batch");
		logs.info("Manage Batch Page navigation worked");
	}

}
