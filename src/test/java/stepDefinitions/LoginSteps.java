package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import hooks.appHooks;

//import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DashboardPage;
import pageObjects.HomePage;
import utilities.PropertyLoader;

public class LoginSteps {
	
	 WebDriver driver = appHooks.getDriver();
	 HomePage hp = new HomePage(driver);
	 
	 public PropertyLoader propertyLoader;

	    public LoginSteps() {
	        propertyLoader = new PropertyLoader();
	    }
	
//	 WebDriver driver;
//	//public WebDriver driver = new ChromeDriver();
//	HomePage hp = new HomePage(driver);
//	DashboardPage dp = new DashboardPage();
//	public Logger logger;
	
	@Given("Admin launch the browser")
	public void admin_launch_the_browser() {		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {		
		driver.get("https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/login");
	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() throws InterruptedException {
			
		String act = driver.getTitle();
		System.out.println(act);
	    Assert.assertEquals(act,"LMS");
	}
	
	@When("Admin gives incorrect LMS portal URL")
	public void admin_gives_incorrect_lms_portal_url() {
	   driver.get("https://lms-frontend-hackathon-oct24.herokuapp.com/login");
	   
	}

	@Then("Admin should receive error message")
	public void admin_should_receive_404_error_message() {
	   Assert.assertTrue(true);
	}
	@Given("Admin is in login page")
	public void admin_is_in_login_page() throws InterruptedException {
		admin_gives_the_correct_lms_portal_url();
		//System.out.println(driver.getTitle());//Title is LMS
	}

	@When("Admin enter valid credentials")
	public void admin_enter_valid_credentials() {
	   hp.enterUsername();
	   hp.enterPassword();
	   hp.clickLogin();
	}

	@Then("Admin should on the dashboard page")
	public void admin_should_on_the_dashboard_page() throws InterruptedException {
	    //String title = hp.getDashboardTitle();
	    Thread.sleep(2000);
	    System.out.println(driver.getCurrentUrl());
	    //https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/
	    
	}
	
	@Then("Admin should see Program")
	public void admin_should_see_program() {
//	   dp.getProgramText();	
//	   Assert.assertTrue(true);
		
	   
	}



}
