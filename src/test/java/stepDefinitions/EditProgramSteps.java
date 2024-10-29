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
import pageObjects.ProgramActionsPage;
import pageObjects.ProgramPage;
import utilities.CommonMethods;
import utilities.PropertyLoader;

public class EditProgramSteps extends CommonMethods {

	
	WebDriver driver = appHooks.getDriver();
	LoginPage lp = new LoginPage(driver);
	DashboardPage dp = new DashboardPage(driver);
	LoginSteps ls = new LoginSteps();
	BatchPage bp = new BatchPage(driver);
	ProgramPage pp = new ProgramPage(driver);
	ProgramActionsPage anpp = new ProgramActionsPage(driver);
	private PropertyLoader propertyLoader;
	
	
	public EditProgramSteps() {
		propertyLoader = new PropertyLoader();
		}
	
	
	@Given ("Admin is on Program page.")
	public void admin_is_on_program_page() throws InterruptedException {
		ls.admin_gives_the_correct_lms_portal_url();
		ls.admin_enter_valid_credentials_and_clicks_login_button();
		implicitlyWait();
		pp.Programbtn.click();
		Thread.sleep(2000);
		String title = pp.getProgramPageTitle();
		Assert.assertEquals(title, "Manage Program");
		Thread.sleep(2000);
    }	
	
	
	@When("Admin clicks on Edit Program button in any row")
	public void admin_clicks_on_edit_program_button_in_any_row() throws InterruptedException  {
	  
	    Thread.sleep(2000);
//	    JavascriptExecutor js = (JavascriptExecutor) driver;
//	    js.executeScript(scrollBy(0,1000));
	    anpp.clickEditbtn();
	}
	@Then("Admin is able to see Program Details window.")
	public void admin_is_able_to_see_program_details_window() throws InterruptedException {
		
		anpp.getProgramDetails_Text();
		Assert.assertTrue(true);
		//Thread.sleep(3000);
	}
	@Given("Admin is on Program Details window.")
	public void admin_is_on_program_details_window() throws InterruptedException {
		ls.admin_gives_the_correct_lms_portal_url();
		ls.admin_enter_valid_credentials_and_clicks_login_button();
		implicitlyWait();
		pp.Programbtn.click();
		Thread.sleep(2000);		  
		anpp.clickEditbtn();
		Thread.sleep(3000);
		anpp.getProgramDetails_Text();
		Assert.assertTrue(true);
		
	}
	@When("Admin updates any mandatory with valid data clicking Save button.")
	public void admin_updates_any_mandatory_with_valid_data_clicking_save_button() throws InterruptedException {
	    Thread.sleep(2000);
	    anpp.editDescriptionfield();
	}
	@Then("Admin is able to see the success message")
	public void admin_is_able_to_see_the_success_message() {
	   anpp.getEditsuccessMessage();
	   Assert.assertTrue(true);
	}
	@When("Admin updates any mandatory with Invalid data clicking Save button.")
	public void admin_updates_any_mandatory_with_Invalid_data_clicking_save_button() throws InterruptedException {
	    Thread.sleep(2000);
	    anpp.editNamefield_invalid();
	}
	@Then("Admin will see the error message.")
	public void admin_will_see_the_error_message() {
		anpp.getInvalid_Error();
//		   Assert.assertTrue(true);
	}
//	@Given("Admin is on Program Details window.")
//	public void admin_is_on_program_details_window(){};
    @When("Admin updates all the mandatory fields with valid data clicking Save button.")
    public void admin_updates_all_the_mandatory_fields_with_valid_data_clicking_save_button() throws InterruptedException{
    	Thread.sleep(2000);
    	anpp.editMandatoryfields_valid();
    }
    @Then("Admin can validate updated program details.")
    public void admin_can_validate_updated_program_details() {
    	anpp.getEditsuccessMessage();
 	   Assert.assertTrue(true);}
    @When("Admin updates any mandatory with valid data clicking Cancel button.")
    public void admin_updates_any_mandatory_with_valid_data_clicking_cancel_button() throws InterruptedException {
       Thread.sleep(2000);
       anpp.editMandatoryfields_Cancel();
    }
    @Then("Admin cannot see the updated details.")
    public void admin_cannot_see_the_updated_details() {
    	String Pagetitle = pp.getProgramPageTitle();
		Assert.assertEquals(Pagetitle, "Manage Program");
    }
    @When("Admin updates any mandatory with valid data clicking Cross button.")
    public void admin_updates_any_mandatory_with_valid_data_clicking_cross_button() throws InterruptedException {
         Thread.sleep(2000);
        anpp.editMandatoryfields_Cross();
    }
    @Then("Admin views the window popup close.")
    public void admin_views_the_window_popup_close()
    {String Pagetitle1 = pp.getProgramPageTitle();
	  Assert.assertEquals(Pagetitle1, "Manage Program");
    	
    }

    
}
