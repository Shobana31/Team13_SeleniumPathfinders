package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import hooks.appHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import utilities.CommonMethods;
import utilities.LoggerLoad;
import utilities.PropertyLoader;

public class LoginSteps extends CommonMethods {
	
	 WebDriver driver = appHooks.getDriver();
	 LoginPage lp = new LoginPage(driver);
	 LoggerLoad logs = new LoggerLoad();
	 private PropertyLoader propertyLoader;

	 public LoginSteps() {
	        propertyLoader = new PropertyLoader();
	    }

	
	@Given("Admin launch the browser")
	public void admin_launch_the_browser() {
		implicitlyWait();
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
		getURL();
	 }


	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
		Assert.assertEquals(getPageTitle(driver), "LMS");
	}


	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() {
		driver.get(propertyLoader.getProperty("LMSUrl2"));
	}
	
	@Then("Admin should recieve {int} page not found error")
	public void admin_should_recieve_page_not_found_error(Integer int1) {
		retriveStatusCode(int1);
	}


	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer int1) throws IOException {
		CommonMethods.findBrokenLink(driver, lp.loginPageBody, int1);
	}

	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() {
      Assert.assertEquals(elementGetText(lp.visibletxtLoginToLMS), "Please login to LMS application");
	}

	@Then("Admin should see logo on the left  side")
	public void admin_should_see_logo_on_the_left_side() {

	}

	@Then("Admin should see  LMS - Learning Management System")
	public void admin_should_see_lms_learning_management_system() {
	    Assert.assertEquals(elementGetText(lp.visibletxtLoginToLMS), "Please login to LMS application");
	}

	@Then("Admin should see company name below the app name")
	public void admin_should_see_company_name_below_the_app_name() {

	}

	@Then("Admin should see {string}")
	public void admin_should_see(String string) {
		Assert.assertEquals(elementGetText(lp.visibletxtLoginToLMS), string);
	}

	@Then("Admin should see two text field")
	public void admin_should_see_two_text_field() {
		Assert.assertTrue(isElementPresent(lp.txtUserName));
		Assert.assertTrue(isElementPresent(lp.txtPassword));
	}

	@Then("Admin should {string} in the first text field")
	public void admin_should_in_the_first_text_field(String string) {
       Assert.assertEquals(getAttributeValue(lp.txtUserName,"data-placeholder"),"User");
	}

	@Then("Admin should see field mandatory \\(*) symbol next to Admin text")
	public void admin_should_see_field_mandatory_symbol_next_to_admin_text() {
		Assert.assertEquals(elementGetText(lp.astriUser),"*");
	}

	@Then("Admin should {string} in the second text field")
	public void admin_should_in_the_second_text_field(String string) {
		Assert.assertEquals(getAttributeValue(lp.txtPassword,"data-placeholder"),"Password");
	}

	@Then("Admin should see * symbol next to password text")
	public void admin_should_see_symbol_next_to_password_text() {
		Assert.assertEquals(elementGetText(lp.astriPassword),"*");
	}

	@Then("Admin should see input field on the centre of the page")
	public void admin_should_see_input_field_on_the_centre_of_the_page() {

	}

	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
		Assert.assertTrue(isElementPresent(lp.btnLogin));
	}

	@Then("Admin should see login button on the centre of the page")
	public void admin_should_see_login_button_on_the_centre_of_the_page() {
		String btnCenter = lp.btnLogin.getCssValue("text-align");
		 Assert.assertEquals(btnCenter, "center");
	}

	@Then("Admin should see Admin in gray color")
		public void admin_should_see_admin_in_gray_color() {
		String textColor =lp.txtUserName.getCssValue("color");
		Assert.assertEquals("rgba(0, 0, 0, 0.87)", textColor);
	 }

	@Then("Admin should see password in gray color")
	public void admin_should_see_password_in_gray_color() {
		String textColor =lp.txtPassword.getCssValue("color");
		Assert.assertEquals("rgba(0, 0, 0, 0.87)", textColor);
	}

	@Given("Admin is in login Page")
	public void admin_is_in_login_page() {
		admin_gives_the_correct_lms_portal_url();
	}
	
	@When("Admin enter invalid credentials  and clicks login button")
	public void admin_enter_invalid_credentials_and_clicks_login_button() {
		lp.enterIncorrectUserName();
		lp.enterIncorrectPassword();
		lp.clickLogin();
	}
	
	@Then("Admin should land on dashboard page \\( centre of the page will be empty , menu bar is present).")
	public void admin_should_land_on_dashboard_page_centre_of_the_page_will_be_empty_menu_bar_is_present() {
		Assert.assertTrue(isElementPresent(lp.dashboardMenuBar));
	}

	@When("Admin enter valid credentials and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() {
		
		lp.enterUsername();
		lp.enterPassword();
		lp.clickLogin();
	
	}
	
	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() {
	    Assert.assertEquals(getPageTitle(driver), "LMS");
		logs.info("Admin logged in successfully");
	}

	@When("Admin enter valid credentials  and clicks login button through keyboard")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() {
		lp.loginKeyboardActions();
	}

	@When("Admin enter valid credentials  and clicks login button through mouse")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_mouse() {
		lp.loginMouseActions();
	}



	@Then("Error message invalid username and password")
	public void error_message_invalid_username_and_password() {
		Assert.assertEquals(lp.getErrorMessage(), "Invalid username and password Please try again");

	}

	@When("Admin enter value only in password and clicks login button")
	public void admin_enter_value_only_in_password_and_clicks_login_button() {
	    lp.enterPassword();
	    lp.clickLogin();
	}
	
	@Then("verify the error message Please enter your user name")
	public void verify_the_error_message_please_enter_your_user_name() {
		Assert.assertFalse(lp.getPasswordcssColor());
	}

	@When("Admin enter value only in Adminname and clicks login button")
	public void admin_enter_value_only_in_adminname_and_clicks_login_button() {
	   lp.enterUsername();
	   lp.clickLogin();
	}
	
	@Then("verify Error message Please enter your password")
	public void verify_error_message_please_enter_your_password() {
		Assert.assertEquals(lp.getUsernamecssColor(), "rgba(0, 0, 0, 0.87)");
	}
	@Then("Verify Error message Invalid username and password Please try again.")
	public void verify_error_message_invalid_username_and_password_please_try_again() {
		Assert.assertEquals(lp.errMsg.getText(),"Invalid username and password Please try again");
	}




}
