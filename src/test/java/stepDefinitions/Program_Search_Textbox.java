package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import hooks.appHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BatchDetailsPage;
import pageObjects.BatchPage;
import pageObjects.DashboardPage;
import pageObjects.ManageProgramPage;
import pageObjects.MultiDeleteProgramPage;
import pageObjects.SearchProgram;
import utilities.CommonMethods;
import utilities.LoggerLoad;

public class Program_Search_Textbox extends CommonMethods{

	WebDriver driver = appHooks.getDriver();
	DashboardPage dp = new DashboardPage(driver);
	LoginSteps ls = new LoginSteps();
	BatchPage bp = new BatchPage(driver);
	BatchDetailsPage bdp = new BatchDetailsPage(driver);
	LoggerLoad logs = new LoggerLoad();
	ManageProgramPage pp=new ManageProgramPage(driver);
	SearchProgram sp = new SearchProgram(driver);
	MultiDeleteProgramPage mp=new MultiDeleteProgramPage(driver);
	
	@Given("Admin is on the Program page for search")
	public void admin_is_on_the_program_page_for_search() {
		getURL();
		ls.admin_enter_valid_credentials_and_clicks_login_button();
		
	}

	@When("Admin enters the program name in the serach text box")
	public void admin_enters_the_program_name_in_the_serach_text_box() {
		pp.getprogramLink().click(); 
		
		 pp.getsearchBar().click();
	}

	@Then("Admin should see the filtered program in the data table")
	public void admin_should_see_the_filtered_program_in_the_data_table() {
		bdp.validateSearch();
		LoggerLoad.info("Search validation completed");
	}
}
