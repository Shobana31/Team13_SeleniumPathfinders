package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import hooks.appHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BatchDetailsPage;
import pageObjects.BatchPage;
import pageObjects.DashboardPage;
import utilities.CommonMethods;
import utilities.LoggerLoad;

public class Batch_Delete_batch_validation extends CommonMethods {

	WebDriver driver = appHooks.getDriver();
	DashboardPage dp = new DashboardPage(driver);
	LoginSteps ls = new LoginSteps();
	BatchPage bp = new BatchPage(driver);
	BatchDetailsPage bdp = new BatchDetailsPage(driver);
	LoggerLoad logs = new LoggerLoad();

	@Given("Admin is on the batch page for Delete")
	public void admin_is_on_the_batch_page_for_delete() {
		getURL();
		ls.admin_enter_valid_credentials_and_clicks_login_button();
		implicitlyWait();
		dp.clickBatchLink();
	}

	@When("Admin clicks the delete Icon on any of the row")
	public void admin_clicks_the_delete_icon_on_any_of_the_row() {
		bp.clickDelete();
	}

	@Then("Admin should see the confirm alert box with yes and no button")
	public void admin_should_see_the_confirm_alert_box_with_yes_and_no_button() {
		Assert.assertEquals(bdp.getDeleteTitle(), "Confirm");
		Assert.assertEquals(bdp.getDeleteNoButton(), "No");
		Assert.assertEquals(bdp.getDeleteYesButton(), "Yes");
	}

	@When("Admin clicks on the delete icon and click yes buttton")
	public void admin_clicks_on_the_delete_icon_and_click_yes_buttton() {
		bp.clickDelete();
		bdp.clickDeleteButtons("yes");
	}

	@Then("Admin should see the successfull message and the batch should be deleted")
	public void admin_should_see_the_successfull_message_and_the_batch_should_be_deleted() {
		Assert.assertEquals(bdp.getToast(), "Successful");
		logs.info("Batch successully deleted");
	}

	@When("Admin clicks on the delete icon and click no buttton")
	public void admin_clicks_on_the_delete_icon_and_click_no_buttton() {
		bp.clickDelete();
		bdp.clickDeleteButtons("no");
	}

	@Then("Admin should see the alert box closed and the batch is not deleted")
	public void admin_should_see_the_alert_box_closed_and_the_batch_is_not_deleted() {
		Assert.assertEquals(bp.getBatchTitle(), "Manage Batch");
	}

	@When("Admin clicks on the close icon on alert box")
	public void admin_clicks_on_the_close_icon_on_alert_box() {
		bp.clickDelete();
		bdp.clickDeleteButtons("close");
	}

	@Then("Admin should see the alert box closed")
	public void admin_should_see_the_alert_box_closed() {
		Assert.assertEquals(bp.getBatchTitle(), "Manage Batch");
	}

}
