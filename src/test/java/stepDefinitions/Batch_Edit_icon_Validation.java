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

public class Batch_Edit_icon_Validation extends CommonMethods {

	WebDriver driver = appHooks.getDriver();
	BatchPage bp = new BatchPage(driver);
	BatchDetailsPage bdp = new BatchDetailsPage(driver);
	DashboardPage dp = new DashboardPage(driver);
	LoginSteps ls = new LoginSteps();

	
	@Given("Admin is on the batch page")
	public void admin_is_on_the_batch_page() {
		getURL();
		ls.admin_enter_valid_credentials_and_clicks_login_button();
		implicitlyWait();	
		dp.clickBatchLink();
	}
	
	
	@When("Admin clicks the edit icon")
	public void admin_clicks_the_edit_icon() {
	
		bp.clickEdit();
		
	}
	
	@Then("Admin should see the Batch details pop up window")
	public void admin_should_see_the_batch_details_pop_up_window() {
		Assert.assertEquals(bp.getBatchDetails(), "Batch Details");
	}
	
	
	@Then("Admin should see Program name value field is disabled for editing")
	public void admin_should_see_program_name_value_field_is_disabled_for_editing() {
		Assert.assertFalse(isElementEnabled(bdp.getProgramNameText()));  
	}

	@Then("Admin should see batch name value field is disabled for editing")
	public void admin_should_see_batch_name_value_field_is_disabled_for_editing() {
		Assert.assertFalse(isElementEditable(bdp.getBatchNamePrefixTextBox()));  
	}
	
	
	
}
