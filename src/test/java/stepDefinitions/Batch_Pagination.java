package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import hooks.appHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BatchDetailsPage;
import pageObjects.BatchPage;
import pageObjects.DashboardPage;
import utilities.CommonMethods;
import utilities.LoggerLoad;

public class Batch_Pagination extends CommonMethods {

	WebDriver driver = appHooks.getDriver();
	DashboardPage dp = new DashboardPage(driver);
	LoginSteps ls = new LoginSteps();
	BatchPage bp = new BatchPage(driver);
	BatchDetailsPage bdp = new BatchDetailsPage(driver);
	LoggerLoad logs = new LoggerLoad();

	@Given("Admin is on the batch page for Pagination")
	public void admin_is_on_the_batch_page_for_pagination() {
		getURL();
		ls.admin_enter_valid_credentials_and_clicks_login_button();
		implicitlyWait();
		dp.clickBatchLink();
	}

	@When("Admin clicks next page link on the data table")
	public void admin_clicks_next_page_link_on_the_data_table() {
		dp.clickAddBatchLink();
		bdp.closeButtonClick();
		bdp.nextPageLink();
	}

	@Then("Admin should see the Next enabled link")
	public void admin_should_see_the_next_enabled_link() {
		Assert.assertTrue(bdp.isPaginationEnabled("next"));
		logs.info("Pagination validated for Next page");
	}

	@When("Admin clicks backward page link on the data table")
	public void admin_clicks_backward_page_link_on_the_data_table() {
		dp.clickAddBatchLink();
		bdp.closeButtonClick();
		bdp.nextPageLink();
		bdp.previousPageLink();
	}

	@Then("Admin should see the previous page on the table")
	public void admin_should_see_the_previous_page_on_the_table() {
		Assert.assertFalse(bdp.isPaginationEnabled("previous"));
		logs.info("Pagination validated for Previous page");
	}

	@When("Admin clicks first page link on the data table")
	public void admin_clicks_first_page_link_on_the_data_table() {
		dp.clickAddBatchLink();
		bdp.closeButtonClick();
		bdp.lastPageLink().click();
		bdp.firstPageLink();
	}

	@Then("Admin should see the very first page on the data table")
	public void admin_should_see_the_very_first_page_on_the_data_table() {
		Assert.assertFalse(bdp.isPaginationEnabled("first"));
		logs.info("Pagination validated for First page");
	}

	@When("Admin clicks last page link on the data table")
	public void admin_clicks_last_page_link_on_the_data_table() {
		dp.clickAddBatchLink();
		bdp.closeButtonClick();
		bdp.lastPageLink().click();
	}

	@Then("Admin should see the last page link with next page link disabled on the table")
	public void admin_should_see_the_last_page_link_with_next_page_link_disabled_on_the_table() {
		Assert.assertFalse(bdp.isPaginationEnabled("last"));
		logs.info("Pagination validated for Last page");
	}

}
