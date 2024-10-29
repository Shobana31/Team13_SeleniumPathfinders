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
	//AddNewProgram_ActionPage anpp = new AddNewProgram_ActionPage(driver);
	private PropertyLoader propertyLoader;
	public ProgramSteps() {
		propertyLoader = new PropertyLoader();
	}
	@Given("Admin successfully Logged on to the Portal")
	public void admin_successfully_logged_on_to_the_portal() {
		ls.admin_gives_the_correct_lms_portal_url();
		//ls.admin_should_land_on_the_login();
		ls.admin_enter_valid_credentials_and_clicks_login_button();
	}
	@Given("Admin is on Dashboard Page")
	public void admin_is_on_dashboard_page() {
		ls.admin_should_land_on_dashboard_page();
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
		//System.out.println(string);
	}
	
	
}
