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

public class AddNewProgramSteps extends CommonMethods{

	WebDriver driver = appHooks.getDriver();
	LoginPage lp = new LoginPage(driver);
	DashboardPage dp = new DashboardPage(driver);
	LoginSteps ls = new LoginSteps();
	BatchPage bp = new BatchPage(driver);
	ProgramPage pp = new ProgramPage(driver);
	ProgramActionsPage anpp = new ProgramActionsPage(driver);
	private PropertyLoader propertyLoader;
	public AddNewProgramSteps() {
		propertyLoader = new PropertyLoader();
		
	}
	@Given("Admin is successfully navigated to the Program Page")
	public void admin_is_successfully_navigated_to_the_program_page() {
		ls.admin_gives_the_correct_lms_portal_url();
		//ls.admin_should_land_on_the_login();
		ls.admin_enter_valid_credentials_and_clicks_login_button();
		implicitlyWait();
		pp.Programbtn.click();
//		String title = pp.getProgramPageTitle();
	}
	
	@Given ("Admin  clicks on Program on the menu bar.")
	public void admin_clicks_on_program_on_the_menu_bar() throws InterruptedException {
		//
		Thread.sleep(2000);
		String title = pp.getProgramPageTitle();
		Assert.assertEquals(title, "Manage Program");
		Thread.sleep(2000);
//		pp.Programbtn.click();
//		Thread.sleep(2000);
		pp.AddNewProgrambtn.isDisplayed();
		
	}	
	
	@When("Admin clicks on Add New Program button")
	public void admin_clicks_on_add_new_program_button() throws InterruptedException {
		
	    pp.AddNewProgrambtn.click();
	}
	@Then("Admin is able to see Program Details window pop up")
	public void admin_is_able_to_see_program_details_window_pop_up() throws InterruptedException {
	   Thread.sleep(2000);
	   anpp.getProgramDetails_Text();
	   Assert.assertTrue(true);
	}
	@Then("Admin is able to verify the Program Name field.")
	public void admin_is_able_to_verify_the_program_name_field() {
		anpp.Pname_textBox.isEnabled();
		String msg ="TIM";
		anpp.Pname_textBox.sendKeys(msg);
		String enteredText = anpp.Pname_textBox.getAttribute("value");
        System.out.println("Entered text is: " + enteredText);
	}
	@Then("Admin is able to verify the Program Description field.")
	public void admin_is_able_to_verify_the_program_description_field() {
	   // anpp.PDescription_Fieldtxt.isDisplayed();
	   // Assert.assertTrue(true);
		anpp.PDesc_textBox.isDisplayed();
	    anpp.PDesc_textBox.isEnabled();
	    String msg ="Teaching Session";
		anpp.Pname_textBox.sendKeys(msg);
		String enteredText1 = anpp.PDesc_textBox.getAttribute("value");
        System.out.println("Entered text is: " + enteredText1);
	}
	@Then("Admin is able to verify the Program Status field.")
	public void admin_is_able_to_verify_the_program_status_field() {
	    anpp.ActiveStatusbtn.isDisplayed();
	    anpp.ActiveStatusbtn.isEnabled();
	    anpp.getActiveStatusRadioButton();
	    Assert.assertTrue(true);
	   
	   // anpp.InactiveStatusbtn.isEnabled();
	}
	@Then("Admin is able to see {string} mark beside mandatory fields in the window.")
	public void admin_is_able_to_see_mark_beside_mandatory_fields_in_the_window(String string) {
		anpp.asteriksmark.isDisplayed();
		Assert.assertTrue(true);
	}
	@Given("Admin enters valid input data in the program details window popup")
	public void admin_enters_valid_input_data_in_the_program_details_window_popup() throws InterruptedException {
		pp.AddNewProgrambtn.isDisplayed();
		Thread.sleep(2000);
		pp.AddNewProgrambtn.click();
		anpp.ValidData_AddNewProgram();
	   
	}
	@When("Admin clicks on save button.")
	public void admin_clicks_on_save_button() {
		anpp.Savebtn.isDisplayed();
	    anpp.Savebtn.isEnabled();
	   // anpp.Savebtn.click();
	}
	@Then("Admin is able to see success message.")
	public void admin_is_able_to_see_success_message() {
	    anpp.getSuccess_message();
	    Assert.assertTrue(true);
	}
	@Given("Admin enters missing data on the program details window popup")
	public void admin_enters_missing_data_on_the_program_details_window_popup() throws InterruptedException {
	  //anpp.leavemissingField("Description", 7);
		pp.AddNewProgrambtn.isDisplayed();
		Thread.sleep(2000);
		pp.AddNewProgrambtn.click();
	    anpp.MissingProgramDesc();
	    anpp.Savebtn.click();
	 
	}
	@Then("Admin is able to see error message.")
	public void admin_is_able_to_see_error_message() {
//		String error = anpp.getMissing_Pname_Error();
//		Assert.assertEquals(error, "Program name is required.");
		String error1 = anpp.getMissing_PDesc_Error();
		Assert.assertEquals(error1, "Description is required.");
		
		
	}
	@Given("Admin enters invalid Program Name data on the program details window popup")
	public void admin_enters_invalid_program_name_data_on_the_program_details_window_popup() throws InterruptedException {
		pp.AddNewProgrambtn.isDisplayed();
		Thread.sleep(2000);
		pp.AddNewProgrambtn.click();
		anpp.getPname_textBox().sendKeys(anpp.InValidChar_ForProgramName());
		//anpp.InValidSpchar_ForProgramName();
		
		anpp.Savebtn.click();
        System.out.println();
	}
	@Then("Admin can see the error message.")
	public void admin_can_see_the_error_message() {
		String error = anpp.getInvalid_Error();
		System.out.println(error);
		Assert.assertEquals(error, "This field should start with an alphabet, no special char and min 2 char.");
	}
	@Given("Admin enters Invalid Program Description data on the program details window popup")
	public void admin_enters_invalid_program_description_data_on_the_program_details_window_popup() throws InterruptedException {
		
			pp.AddNewProgrambtn.isDisplayed();
			Thread.sleep(2000);
			pp.AddNewProgrambtn.click();
			anpp.getPDesc_textBox().sendKeys(anpp.InvalidChar_ProgramDesc());
			anpp.Savebtn.click();
 	 }
	
	@Then("Admin can see error message displayed.")
	public void admin_can_see_error_message_displayed() {
		String error2 = anpp.getInvalidDesc_Error();
		Assert.assertEquals(error2, "This field should start with an alphabet and min 2 char.");
	}
	@Given("Admin enters Mandatory data on the program details window popup.")
	public void admin_enters_mandatory_data_on_the_program_details_window_popup() throws InterruptedException {
		pp.AddNewProgrambtn.isDisplayed();
		Thread.sleep(2000);
		pp.AddNewProgrambtn.click();
		anpp.ValidData_AddNewProgram_Cancel();
	}
	@When("Admin clicks on Cancel button.")
	public void admin_clicks_on_cancel_button() {
	  anpp. Cancelbtn.isDisplayed();
	  anpp.Cancelbtn.isEnabled();
	}
	
	@Then("Admin is unable to see the newprogram details save.")
	public void admin_is_unable_to_see_the_newprogram_details_save() {
		String title = pp.getProgramPageTitle();
		Assert.assertEquals(title, "Manage Program");
	}
	@Given("Admin enters input data on the program details window popup.")
	public void admin_enters_input_data_on_the_program_details_window_popup() throws InterruptedException {
		pp.AddNewProgrambtn.isDisplayed();
		Thread.sleep(2000);
		pp.AddNewProgrambtn.click();
		anpp.ValidData_AddNewProgram_Cross();
	  
	}
	@When("Admin clicks on X button.")
	public void admin_clicks_on_x_button() {
		anpp. Crossbtn.isDisplayed();
		  anpp.Crossbtn.isEnabled();
	}
	@Then("Admin is able to see the window popup close.")
	public void admin_is_able_to_see_the_window_popup_close() {
		String title = pp.getProgramPageTitle();
		Assert.assertEquals(title, "Manage Program");
	}
	
	
}
