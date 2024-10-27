package stepDefinitions;

import org.openqa.selenium.WebDriver;

import hooks.appHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BatchDetailsPage;
import pageObjects.BatchPage;
import pageObjects.DashboardPage;
import utilities.CommonMethods;

public class Batch_Delete_multiple_batches_with_check_box extends CommonMethods{

	WebDriver driver = appHooks.getDriver();
	DashboardPage dp = new DashboardPage(driver);
	LoginSteps ls = new LoginSteps();
	BatchPage bp = new BatchPage(driver);
	BatchDetailsPage bdp = new BatchDetailsPage(driver);
	
	@Given("Admin is on the batch page for delete multiple")
	public void admin_is_on_the_batch_page_for_delete_multiple() {
		getURL();
		ls.admin_enter_valid_credentials_and_clicks_login_button();
		implicitlyWait();	
		dp.clickBatchLink();
	}
	
	
	@When("Admin clicks on the delete icon under the Manage batch header for single row")
	public void admin_clicks_on_the_delete_icon_under_the_manage_batch_header_for_single_row() {
	  
		 bdp.storeBeforeCount();          // Store the count before deletion
		    bdp.selectCheckboxes(1); 
	}
	
	
	@Then("The respective row in the table should be deleted")
	public void the_respective_row_in_the_table_should_be_deleted() {
	    bdp.validateCount(); 
	}
	
	@When("Admin clicks on the delete icon under the Manage batch header for multiple row")
	public void admin_clicks_on_the_delete_icon_under_the_manage_batch_header_for_multiple_row() {
		bdp.storeBeforeCount();          // Store the count before deletion
	    bdp.selectCheckboxes(3); 
	}
	
	
	
	
	
}
