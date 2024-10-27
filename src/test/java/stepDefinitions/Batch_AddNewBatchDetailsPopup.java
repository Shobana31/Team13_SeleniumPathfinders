package stepDefinitions;


import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import hooks.appHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BatchDetailsPage;
import pageObjects.BatchPage;
import pageObjects.DashboardPage;
import utilities.CommonMethods;

public class Batch_AddNewBatchDetailsPopup extends CommonMethods {

	WebDriver driver = appHooks.getDriver();
	BatchDetailsPage bdp = new BatchDetailsPage(driver);
	BatchPage bp = new BatchPage(driver);
	DashboardPage dp = new DashboardPage(driver);
	LoginSteps ls = new LoginSteps();
	
	
	@Given("Admin is on the Add new batch pop up")
	public void admin_is_on_the_add_new_batch_pop_up() {
		getURL();
		ls.admin_enter_valid_credentials_and_clicks_login_button();
		implicitlyWait();
		dp.clickBatchLink();
		 dp.clickAddBatchLink();  
		
	}
	
	@When("Admin checks all the fields are enabled")
	public void admin_checks_all_the_fields_are_enabled() {
		isElementEnabled(bdp.getBatchNamePrefixTextBox());
		isElementEnabled(bdp.getBatchNameSuffixTextBox());
		isElementEnabled(bdp.getNumberOfClassesTextBox());
		isElementEnabled(bdp.getDescriptionTextBox());
       isElementEnabled(bdp.getProgramNameDropdown());
       bdp.getActiveStatusRadioButton();
   }
	
	@Then("The pop up should include the fields Batch Name,Number of classes and Description as text box, Program Name as drop down Status as radio button")
	public void the_pop_up_should_include_the_fields_batch_name_number_of_classes_and_description_as_text_box_program_name_as_drop_down_status_as_radio_button() {
		 assertTrue(isElementDisplayed(bdp.getBatchNamePrefixTextBox()));
		 assertTrue(isElementDisplayed(bdp.getBatchNameSuffixTextBox()));
		 assertTrue(isElementDisplayed(bdp.getNumberOfClassesTextBox()));
		 assertTrue(isElementDisplayed(bdp.getDescriptionTextBox()));
		 assertTrue(isElementDisplayed(bdp.getProgramNameDropdown()));
		 assertTrue(bdp.isStatusRadioButton());
	}
	
	@When("Admin selects program name present in the dropdown")
	public void admin_selects_program_name_present_in_the_dropdown() {
		 bdp.selectProgramNameDD();
		 bdp.selectProgramNameListBox();
	}
	@Then("Admin should see selected program name in the batch name prefix box")
	public void admin_should_see_selected_program_name_in_the_batch_name_prefix_box() {
		String batchNamePrefix = bdp.getBatchNamePrefix();
		 assertTrue(batchNamePrefix.startsWith(bdp.selectDataForProgramName()));    
	}
	
	@When("Admin enters alphabets in batch name suffix box")
	public void admin_enters_alphabets_in_batch_name_suffix_box() {
		bdp.getBatchNameSuffixTextBox().sendKeys(bdp.setInvalidDataFromBatchName());
		
	}
	@Then("Admin should get error message below the text box of respective field")
	public void admin_should_get_error_message_below_the_text_box_of_respective_field() {
		Assert.assertEquals( bdp.getError(), "This field accept only numbers and max 5 count.");
	}
	
	
	@When("Admin enters alphabets in batch name prefix box")
	public void admin_enters_alphabets_in_batch_name_prefix_box() {
		 bdp.selectProgramNameDD();
    	 bdp.selectProgramNameListBox(); 
		bdp.getBatchNamePrefixTextBox().sendKeys("abc");
	}
	
	@Then("Admin should see empty text box")
	public void admin_should_see_empty_text_box() {
		 Assert.assertFalse(isElementEditable(bdp.getBatchNamePrefixTextBox()));  
	}
	
	@When("Admin enters the data only to the mandatory fiields and clicks save button")
	public void admin_enters_the_data_only_to_the_mandatory_fiields_and_clicks_save_button() {
		bdp.enterMandatoryDetails();
	}
	
	@Then("Admin should get a successful message")
	public void admin_should_get_a_successful_message() {
		
	//    bdp.getToast();
	    Assert.assertEquals(bdp.getToast(), "Successful");
	//    Assert.assertEquals(bdp.getToastCheck(), "Batch Created Successfully");
	 
	}
	
	@When("Admin leaves blank one of the mandatory fields")
	public void admin_leaves_blank_one_of_the_mandatory_fields() {
		bdp.leaveBlankField("programNameDropdown", 5);
		//bdp.leaveBlankField("BatchNameSuffix", 6);
		
	}
	

	@Then("Admin should get a error message on the respective mandatory field")
	public void admin_should_get_a_error_message_on_the_respective_mandatory_field() {
		
		Assert.assertEquals(bdp.getblankFieldText(), "Program Name is required.");
		
	}
	
	
	@When("Admin enters the valid data to all the mandatory fields and click save button in batch details")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_save_button_in_batch_details() {
		bdp.enterAllDetails("save");
	}
	@Then("Admin should get a succesesful message")
	public void admin_should_get_a_succesesful_message() {
	//	 bdp.getToast();
		    Assert.assertEquals(bdp.getToast(), "Successful");
		//    Assert.assertEquals(bdp.getToastCheck(), "Batch Created Successfully");
		 
	}
	
	

	
	@When("Admin enters the valid data to all the mandatory fields and click cancel button in Batch details")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_cancel_button_in_batch_details() {
		bdp.enterAllDetails("cancel");
		
	}
	@Then("Admin can see the batch details popup closes without creating any batch")
	public void admin_can_see_the_batch_details_popup_closes_without_creating_any_batch() {
		String title = bp.getBatchTitle();
		Assert.assertEquals(title, "Manage Batch");
	}
	
	@When("Admin clicks on the close icon")
	public void admin_clicks_on_the_close_icon() {
	   bdp.closeButtonClick();
		
	}
	@Then("batch details pop up closes")
	public void batch_details_pop_up_closes() {
		String title = bp.getBatchTitle();
		Assert.assertEquals(title, "Manage Batch");
	}
	
	
	
	
	
	
	
	
}
