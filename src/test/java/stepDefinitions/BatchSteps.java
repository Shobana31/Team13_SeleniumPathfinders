package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import hooks.appHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BatchPage;
import pageObjects.DashboardPage;
import pageObjects.HomePage;
import utilities.PropertyLoader;

public class BatchSteps {

	

	 WebDriver driver = appHooks.getDriver();
	 HomePage hp = new HomePage(driver);
	 DashboardPage dp = new DashboardPage(driver);
	 LoginSteps ls = new LoginSteps();
	 BatchPage bp = new BatchPage(driver);
	 private PropertyLoader propertyLoader;

	    public BatchSteps() {
	        propertyLoader = new PropertyLoader();
	    }
	    
	    @Given("Admin successfully Logged on to the LMS Portal")
	    public void admin_successfully_logged_on_to_the_lms_portal() {
	      
	    	ls.admin_is_in_login_page();
	    	ls.admin_enter_valid_credentials();
	    }

	    @Given("Admin is on the Dashboard Page")
	    public void admin_is_on_the_dashboard_page() {
	    	ls.admin_should_land_on_the_dashboard_page();
	    }

	    @When("Admin Clicks on the Batch menu from the header")
	    public void admin_clicks_on_the_batch_menu_from_the_header() {
	    	
	    	dp.clickBatchLink();
	    	
	    }

	    @Then("Admin should be in the Manage Batch Page")
	    public void admin_should_be_in_the_manage_batch_page() {
	    	String title = bp.getBatchTitle();
	    	 Assert.assertEquals(title, "Manage Batch");

	    }

	    

	
	
}
