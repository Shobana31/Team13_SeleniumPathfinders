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
import utilities.CommonMethods;

public class Batch_Edit_batch_validation extends CommonMethods {

	WebDriver driver = appHooks.getDriver();
	BatchDetailsPage bdp = new BatchDetailsPage(driver);
	BatchPage bp = new BatchPage(driver);
	DashboardPage dp = new DashboardPage(driver);
	LoginSteps ls = new LoginSteps();
	
	@Given("Admin is on the Batch Details Page")
	public void admin_is_on_the_batch_details_page() {
	  
		getURL();
		ls.admin_enter_valid_credentials_and_clicks_login_button();
		implicitlyWait();
		dp.clickBatchLink();
		bp.clickEdit(); 
		
	}
	@When("Admin Updates any fields with invalid data and click save button")
	public void admin_updates_any_fields_with_invalid_data_and_click_save_button() {
		bdp.editDescriptionNoOfClassesDetails();
	}
	
	@Then("Admin should get a error message under the respective field")
	public void admin_should_get_a_error_message_under_the_respective_field() {
		Assert.assertEquals( bdp.getError(), "This field should start with an alphabet and min 2 character.");
		Assert.assertEquals( bdp.getError(), "Number of classes is required.");
		
	}
	
	
	@When("Admin enters the valid data to all the mandatory fields and click save button")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_save_button() {
	    bdp.editMandatoryDetails("Save");
		
	}
	
	@Then("Admin should get a succesesful message for editing the batch")
	public void admin_should_get_a_succesesful_message_for_editing_the_batch() {
	 
		Assert.assertEquals(bdp.getToast(), "Successful");
	}
	
	
	@When("Admin enters the valid data to all the mandatory fields and click cancel button")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_cancel_button() {
		bdp.editMandatoryDetails("Cancel");
	}
	
	@Then("Admin can see the batch details popup closes without editing the batch")
	public void admin_can_see_the_batch_details_popup_closes_without_editing_the_batch() {
	    
		String title = bp.getBatchTitle();
		Assert.assertEquals(title, "Manage Batch");
	}
	
	
	
	
	
}
