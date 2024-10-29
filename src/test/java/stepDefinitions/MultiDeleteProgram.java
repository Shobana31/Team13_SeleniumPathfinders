package stepDefinitions;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BatchDetailsPage;
import pageObjects.ManageProgramPage;
import pageObjects.MultiDeleteProgramPage;
import utilities.CommonMethods;
import utilities.LoggerLoad;

public class MultiDeleteProgram extends CommonMethods{

	ManageProgramPage pp=new ManageProgramPage(driver);
	MultiDeleteProgramPage mp= new MultiDeleteProgramPage(driver);
	BatchDetailsPage bdp = new BatchDetailsPage(driver);

		
	@Given("Admin is on Program module")
	public void admin_is_on_program_module() {
		pp.getprogramLink().click(); 
		Actions actions = new Actions(driver);
		 actions.moveToElement(mp.getsortby()).click().perform();
	}

	@When("Admin selects more than one program by clicking on the checkbox")
	public void admin_selects_more_than_one_program_by_clicking_on_the_checkbox() throws InterruptedException {
		int multiCheckboxCount = mp.getmulticheckbox().size();
		LoggerLoad.info("Total Count of checkboxes: " + multiCheckboxCount);

		// Get the list of checkboxes
		java.util.List<WebElement> checkboxes = mp.getmulticheckbox(); // Assuming this method returns a list of checkboxes

		// Iterate through each checkbox
		for (WebElement checkbox : checkboxes) {
		    if (!checkbox.isSelected()) {
		        checkbox.click(); // Select the checkbox if it's not already checked
		        LoggerLoad.info("Checkbox clicked: " + checkbox.getAttribute("id")); // Optional logging
		    } else {
		        LoggerLoad.info("Checkbox already selected: " + checkbox.getAttribute("id")); // Optional logging
		    }
		}

		

		}
			

	@Then("Programs get selected")
	public void programs_get_selected() {
		
		java.util.List<WebElement> checkboxes = mp.getmulticheckbox(); // Assuming this method returns a list of checkboxes

		// Iterate through each checkbox
		for (WebElement checkbox : checkboxes) {
		    if (!checkbox.isSelected()) {
		        checkbox.click();
		   Assert.assertFalse((checkbox.isSelected()));
		    }
		}
		}
	
	
		@When("Admin clicks on the delete button on the left top of the program page")
		public void admin_clicks_on_the_delete_button_on_the_left_top_of_the_program_page() {
		    
			bdp.storeBeforeCount();
			mp.selectCheckboxes(3);
		}

		@Then("Admin lands on Confirmation form")
		public void admin_lands_on_confirmation_form() {
			
			WebElement confirmText=mp.getdeleteTitle();
		
			Assert.assertEquals(confirmText.getText(), "Confirm");
			
//			 Alert alert = driver.switchTo().alert();
//		 String alertText = alert.getText();
//			 LoggerLoad.info("Alert text: " + alertText);
//			String ConfirmText=mp.getdeleteTitle();
//			LoggerLoad.info("Actual Confirmation Text" +ConfirmText);
//			String ExpectedText="Confirm";
//			Assert.assertEquals(ConfirmText, ExpectedText);
			
			
		    
		}
		
		@Given("Admin is on Confirmation form")
		public void admin_is_on_confirmation_form() {
			pp.getprogramLink().click(); 
			Actions actions = new Actions(driver);
			 actions.moveToElement(mp.getsortby()).click().perform();
			 bdp.storeBeforeCount();
				mp.selectCheckboxes(3);
			WebElement confirmText=mp.getdeleteTitle();
			
			LoggerLoad.info("Confirmation form text is: " +confirmText);
		}

		@When("Admin clicks on Yes button")
		public void admin_clicks_on_yes_button() {
		 
			mp.getDeleteYesButton().click();
			
			
			
		}

		@Then("Admin can see Successful  program deleted message")
		public void admin_can_see_successful_program_deleted_message() {
		    bdp.getToast();
		}

		@When("Admin Searches for Deleted Program names")
		public void admin_searches_for_deleted_program_names() {
		
		}

		@Then("There should be zero results")
		public void there_should_be_zero_results() {
		  
		}

		@When("Admin clicks on No button")
		public void admin_clicks_on_no_button() {
			mp.getDeleteNoButton().click();
		}

		@Then("Admin can see Programs are still selected and not deleted")
		public void admin_can_see_programs_are_still_selected_and_not_deleted() {
		    
		}

		@Given("Admin is on Program Confirm Deletion Page after selecting a program to delete")
		public void admin_is_on_program_confirm_deletion_page_after_selecting_a_program_to_delete() {
			pp.getprogramLink().click(); 
			Actions actions = new Actions(driver);
			 actions.moveToElement(mp.getsortby()).click().perform();
			 bdp.storeBeforeCount();
				mp.selectCheckboxes(3);
			WebElement confirmText=mp.getdeleteTitle();
			
			Assert.assertEquals(confirmText.getText(), "Confirm");
		}
		

		@When("Admin Click on X button")
		public void admin_click_on_x_button() {
		  mp.getcloseConfirmationPage();
		}

		@Then("Admin can see Confirm Deletion form disappear")
		public void admin_can_see_confirm_deletion_form_disappear() {
		   
		}
	
	}



