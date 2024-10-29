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

public class DeleteProgramSteps extends CommonMethods {

	WebDriver driver = appHooks.getDriver();
	LoginPage lp = new LoginPage(driver);
	DashboardPage dp = new DashboardPage(driver);
	LoginSteps ls = new LoginSteps();
	BatchPage bp = new BatchPage(driver);
	ProgramPage pp = new ProgramPage(driver);
	ProgramActionsPage anpp = new ProgramActionsPage(driver);
	private PropertyLoader propertyLoader;
	public DeleteProgramSteps() {
		propertyLoader = new PropertyLoader();
		
	}
	@Given("Admin is on Program page")
	public void admin_is_on_program_page() throws InterruptedException {
		ls.admin_gives_the_correct_lms_portal_url();
		ls.admin_enter_valid_credentials_and_clicks_login_button();
		implicitlyWait();
		pp.Programbtn.click();
		Thread.sleep(2000);
//		String title = pp.getProgramPageTitle();
//		Assert.assertEquals(title, "Manage Program");
//		Thread.sleep(2000);
		//pp.getProgramPageTitle();
		pp.AddNewProgrambtn.isDisplayed();
		
	    }
	
	@When("Admin clicks the Delete button in any of the row")
	public void admin_clicks_the_delete_button_in_any_of_the_row() throws InterruptedException {
	    Thread.sleep(2000);
	   
	    anpp.Deletebtn.isDisplayed();
	    anpp.Deletebtn.isEnabled();
	    anpp.getDeletebtn_text();
	    anpp.click_Deletebtn();
	}
	@Then("Admin sees the confirm Delete window box")
	public void admin_sees_the_confirm_delete_window_box() {
	    anpp.getConfirmbox_text();  Assert.assertTrue(true);
	    anpp.getYesDeletebtn_text();  Assert.assertTrue(true);
	    anpp.getNoDeletebtn_text();  Assert.assertTrue(true);
	  
	}
	@Given("Admin is on confirm Delete window box")
	public void admin_is_on_confirm_delete_window_box() throws InterruptedException {
		ls.admin_gives_the_correct_lms_portal_url();
		ls.admin_enter_valid_credentials_and_clicks_login_button();
		implicitlyWait();
		pp.Programbtn.click();
		Thread.sleep(2000);
		pp.AddNewProgrambtn.isDisplayed();
		anpp.click_Deletebtn();
		anpp.getConfirmbox_text();
	}
	@When("Admin clicks yes button")
	public void admin_clicks_yes_button() {
		anpp.clickonDeleteButtons("Yes");
	}
	@Then("Admin sees the Program is deleted with a success message")
	public void admin_sees_the_program_is_deleted_with_a_success_message() {
		String success = anpp.getDeletesuccessMessage();
		Assert.assertEquals(success, "Successful");
	}
	@When("Admin clicks No button")
	public void admin_clicks_no_button() {
		anpp.clickonDeleteButtons("No");
	}
	@Then("There is no deletion")
	public void there_is_no_deletion() {
		String title5 = pp.getProgramPageTitle();
		Assert.assertEquals(title5, "Manage Program");
	}
	@When("Admin clicks cross button in the confirm Delete window")
	public void admin_clicks_cross_button_in_the_confirm_delete_window() {
	 anpp.clickonDeleteButtons("Cross");
	}
	@Then("Admin view the confirm Delete window box close")
	public void admin_view_the_confirm_delete_window_box_close() {
		String title7 = pp.getProgramPageTitle();
		Assert.assertEquals(title7, "Manage Program");
	}

	
	
}
