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
import utilities.CommonMethods;
import utilities.LoggerLoad;
import utilities.PropertyLoader;

public class Batch_BatchPageValidationSteps extends CommonMethods {

	WebDriver driver = appHooks.getDriver();
	BatchPage bp = new BatchPage(driver);
	DashboardPage dp = new DashboardPage(driver);
	LoginSteps ls = new LoginSteps();
	LoggerLoad logs = new LoggerLoad();

	@Given("Admin is on the Dashboard page after Login")
	public void admin_is_on_the_dashboard_page_after_login() {
		getURL();
		ls.admin_enter_valid_credentials_and_clicks_login_button();
		implicitlyWait();
	}

	@When("Admin Clicks on the Batch menu from header")
	public void admin_clicks_on_the_batch_menu_from_header() {
		dp.clickBatchLink();
	}

	@Then("Admin should see the {string} Title")
	public void admin_should_see_the_title(String string) {
		Assert.assertEquals(getPageTitle(driver), "LMS");
	}

	@Then("Admin should see the {string} Heading")
	public void admin_should_see_the_heading(String string) {
		Assert.assertEquals(bp.getBatchTitle(), "Manage Batch");
	}

	@Then("Admin should see the disabled {string} under the header")
	public void admin_should_see_the_disabled_under_the_header(String string) {
		Assert.assertEquals(false, bp.clickDeleteIconManage());
	}

	@Then("Admin should see the enabled pagination controls under the data table")
	public void admin_should_see_the_enabled_pagination_controls_under_the_data_table() {
		Assert.assertEquals(true, bp.clickPaginationControl());
	}

	@Then("Admin should see the edit icon in each row")
	public void admin_should_see_the_edit_icon_in_each_row() {
		Assert.assertEquals(bp.clickEditIcon(), 5);
	}

	@Then("Admin should see the delete icon in each row")
	public void admin_should_see_the_delete_icon_in_each_row() {
		Assert.assertEquals(bp.clickDeleteIcon(), 5);
	}

	@Then("Admin should see the checkbox in each row")
	public void admin_should_see_the_checkbox_in_each_row() {
		Assert.assertEquals(bp.clickCheckBoxRow(), 5);
	}

	@Then("Admin should see the datatable headers Batch name, Batch Description,Batch Status, No Of classes, Program Name, Edit\\/Delete")
	public void admin_should_see_the_datatable_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete() {
		String[] actualHeaders = bp.verifyHeader();
		String[] expectedHeaders = { "Batch Name", "Batch Description", "Batch Status", "No Of Classes", "Program Name",
				"Edit / Delete" };
		Assert.assertEqualsNoOrder(actualHeaders, expectedHeaders);
		logs.info("Manage Batch page validation completed");
	}

	@Then("Admin should see the checkbox  in the datatable header row")
	public void admin_should_see_the_checkbox_in_the_datatable_header_row() {
		Assert.assertEquals(true, bp.clickCheckBoxHeader());
	}

	@Then("Admin should see the sort icon next to all Datatable headers")
	public void admin_should_see_the_sort_icon_next_to_all_datatable_headers() {
		Assert.assertEquals(bp.clickSortIconHeader(), 5);
	}

}
