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
import pageObjects.ProgramPage;
import utilities.PropertyLoader;

public class ProgramSteps {

	WebDriver driver = appHooks.getDriver();
	LoginPage lp = new LoginPage(driver);
	DashboardPage dp = new DashboardPage(driver);
	LoginSteps ls = new LoginSteps();
	BatchPage bp = new BatchPage(driver);
	ProgramPage pp = new ProgramPage(driver);
	//AddNewProgramPage anpp = new AddNewProgramPage(driver);
	private PropertyLoader propertyLoader;

	public ProgramSteps() {
		propertyLoader = new PropertyLoader();
	}

	@Given("Admin successfully Logged on to the Portal")
	public void admin_successfully_logged_on_to_the_portal() {

		ls.admin_gives_the_correct_lms_portal_url();
		ls.admin_should_land_on_the_login();
		ls.admin_enter_valid_credentials();
	}

	@Given("Admin is on Dashboard Page")
	public void admin_is_on_dashboard_page() {

		ls.admin_should_land_on_the_dashboard_page();
	}

	@When("Admin selects Program from the menu")
	public void admin_selects_program_from_the_menu() {
		pp.Programbtn.click();
	}

	@Then("Admin is navigated to the Program page")
	public void admin_is_navigated_to_the_program_page() {
		String title = pp.getProgramPageTitle();
		Assert.assertEquals(title, "Manage Program");
		// LoggerLoad.info(title,);

	}

	@Then("Admin is able to see the {string} links in the menubar on the program page")
	public void admin_is_able_to_see_the_links_in_the_menubar_on_the_program_page(String string) {
		pp.ProgramPage_modules_Display(string);
	}
	@Given("Admin is successfully navigated to the Program Page")
	public void admin_is_successfully_navigated_to_the_program_page() {
		String title = pp.getProgramPageTitle();
		Assert.assertEquals(title, "Manage Program");
	}

	@Given("Admin is on the program module page")
	public void admin_is_on_the_program_module_page() {
	}

	@When("Admin clicks on Add New Program button")
	public void admin_clicks_on_add_new_program_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin is able to see Program Details window pop up")
	public void admin_is_able_to_see_program_details_window_pop_up() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Admin is on the Program Details window pop up page")
	public void admin_is_on_the_program_details_window_pop_up_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User enters the data in Add new program window from sheet {string} and {int}")
	public void user_enters_the_data_in_add_new_program_window_from_sheet_and(String string, Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

//	@Then("User clicks on save button")
//	public void user_clicks_on_save_button() {
//		pp.Savebtn.click();
//	}




}
