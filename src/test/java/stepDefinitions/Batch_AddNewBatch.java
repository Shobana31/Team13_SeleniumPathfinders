package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import hooks.appHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BatchPage;
import pageObjects.DashboardPage;
import utilities.CommonMethods;

public class Batch_AddNewBatch extends CommonMethods {

	WebDriver driver = appHooks.getDriver();
	BatchPage bp = new BatchPage(driver);
	DashboardPage dp = new DashboardPage(driver);
	LoginSteps ls = new LoginSteps();


@Given("Admin is on the Batch page")
public void admin_is_on_the_batch_page() {
	getURL();
	ls.admin_enter_valid_credentials_and_clicks_login_button();
	implicitlyWait();	
}

@When("Admin clicks {string} on the navigation bar")
public void admin_clicks_on_the_navigation_bar(String string) {
	dp.clickBatchLink();
}

@Then("Admin should see sub menu in menu bar as {string}")
public void admin_should_see_sub_menu_in_menu_bar_as(String string) {
	dp.getAddBatch();
}

@When("Admin clicks on {string} under the {string} menu bar")
public void admin_clicks_on_under_the_menu_bar(String string, String string2) {
	dp.clickBatchLink();
 dp.clickAddBatchLink();   
}

@Then("Admin should see the Batch Details pop up window")
public void admin_should_see_the_batch_details_pop_up_window() {
	Assert.assertEquals(bp.getBatchDetails(), "Batch Details");
}








	
	
}
