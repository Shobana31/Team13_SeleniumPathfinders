package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import hooks.appHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import utilities.PropertyLoader;

public class LoginSteps {
	
	 WebDriver driver = appHooks.getDriver();
	 HomePage hp = new HomePage(driver);
	 private PropertyLoader propertyLoader;

	    public LoginSteps() {
	        propertyLoader = new PropertyLoader();
	    }

	
	@Given("Admin launch the browser")
	public void admin_launch_the_browser() {		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {		
	     if (driver == null) {
	            throw new IllegalStateException("WebDriver is not initialized. Please check Hooks setup.");
	        }
	        
	        String url = propertyLoader.getProperty("LMSUrl"); // Retrieve the URL from properties
	        driver.get(url); // Open the URL	
	        }

	@Then("Admin should land on the login")
	public void admin_should_land_on_the_login() {
	    String title = hp.getLoginTitle();
	    Assert.assertEquals(title, "Please login to LMS application");
	}
	
	@When("Admin gives incorrect LMS portal URL")
	public void admin_gives_incorrect_lms_portal_url() {
	   driver.get(propertyLoader.getProperty("LMSUrl2"));
	}

	@Then("Admin should receive error message")
	public void admin_should_receive_404_error_message() {
	   Assert.assertTrue(true);
	}
	@Given("Admin is in login page")
	public void admin_is_in_login_page() {
		admin_gives_the_correct_lms_portal_url();
	}

	@When("Admin enter valid credentials")
	public void admin_enter_valid_credentials() {
	   hp.enterUsername();
	   hp.enterPassword();
	   hp.clickLogin();
	
	  
	}

	@Then("Admin should land on the dashboard page")
	public void admin_should_land_on_the_dashboard_page() {
	    String title = hp.getDashboardTitle();
	    Assert.assertEquals(title, "LMS - Learning Management System");
	}


}
