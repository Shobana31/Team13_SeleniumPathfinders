package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import hooks.appHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BatchDetailsPage;
import pageObjects.BatchPage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import utilities.CommonMethods;

public class Batch_LogOut_of_the_application_from_the_batch_page extends CommonMethods{

	WebDriver driver = appHooks.getDriver();
	DashboardPage dp = new DashboardPage(driver);
	LoginSteps ls = new LoginSteps();
	BatchPage bp = new BatchPage(driver);
	BatchDetailsPage bdp = new BatchDetailsPage(driver);
	 LoginPage lp = new LoginPage(driver);
	
	@Given("Admin is on the batch page for logout")
	public void admin_is_on_the_batch_page_for_logout() {
		getURL();
		ls.admin_enter_valid_credentials_and_clicks_login_button();
		implicitlyWait();	
		dp.clickBatchLink();
	}
	
	
	@When("Admin clicks on the logout button")
	public void admin_clicks_on_the_logout_button() {
	    dp.clickLogout();
		
	}
	@Then("Admin should see the Login screen Page")
	public void admin_should_see_the_login_screen_page() {
	  
		 Assert.assertEquals(elementGetText(lp.visibletxtLoginToLMS), "Please login to LMS application");

	}
	
	
}
