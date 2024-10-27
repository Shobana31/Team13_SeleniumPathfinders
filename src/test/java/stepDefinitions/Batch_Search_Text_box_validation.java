package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import hooks.appHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BatchDetailsPage;
import pageObjects.BatchPage;
import pageObjects.DashboardPage;
import utilities.CommonMethods;

public class Batch_Search_Text_box_validation extends CommonMethods{

	WebDriver driver = appHooks.getDriver();
	DashboardPage dp = new DashboardPage(driver);
	LoginSteps ls = new LoginSteps();
	BatchPage bp = new BatchPage(driver);
	BatchDetailsPage bdp = new BatchDetailsPage(driver);
	
	@Given("Admin is on the batch page for search")
	public void admin_is_on_the_batch_page_for_search() {
		getURL();
		ls.admin_enter_valid_credentials_and_clicks_login_button();
		implicitlyWait();	
		dp.clickBatchLink();
	}
	
	
	@When("Admin enters the batch name in the serach text box")
	public void admin_enters_the_batch_name_in_the_serach_text_box() {
		bdp.enterSearch();
	}
	
	@Then("Admin should see the filtered batches in the data table")
	public void admin_should_see_the_filtered_batches_in_the_data_table() {
	   
		Assert.assertTrue(bdp.validateSearch());
	}

	
	
}
