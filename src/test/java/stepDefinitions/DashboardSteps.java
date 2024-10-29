package stepDefinitions;

import hooks.appHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.DashboardPage;
import utilities.CommonMethods;
import utilities.PropertyLoader;

import java.io.IOException;

public class DashboardSteps extends CommonMethods {
    WebDriver driver = appHooks.getDriver();
    DashboardPage dp = new DashboardPage(driver);
    private PropertyLoader propertyLoader;

    public DashboardSteps(){
        propertyLoader = new PropertyLoader();
    }

    @Given("Admin is in login page")
    public void admin_is_in_login_page() {
        implicitlyWait();
        getURL();
    }
    @Then("Admin should see dashboard")
    public void admin_should_see_dashboard() {
        Assert.assertEquals(getPageTitle(driver), "LMS");
    }

    @Then("Maximum navigation time in milliseconds, defaults to {int} seconds")
    public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(Integer int1) throws IOException {
        CommonMethods.findBrokenLink(driver, dp.DB_Body, int1);
    }

    @Then("Admin should see LMS -Learning management system as title")
    public void admin_should_see_lms_learning_management_system_as_title() {
        Assert.assertEquals(elementGetText(dp.DB_Title), "LMS - Learning Management System");
    }

  

    @Then("Admin should see correct spelling in navigation bar text")
    public void admin_should_see_correct_spelling_in_navigation_bar_text() {
        Assert.assertEquals(elementGetText(dp.DB_Title), "LMS - Learning Management System");
        Assert.assertEquals(elementGetText(dp.lnkProgram), "Program");
        Assert.assertEquals(elementGetText(dp.lnkBatch), "Batch");
        Assert.assertEquals(elementGetText(dp.lnkClass), "Class");
        Assert.assertEquals(elementGetText(dp.lnkLogout), "Logout");
    }

    @Then("Admin should see correct spelling and space in LMS title")
    public void admin_should_see_correct_spelling_and_space_in_lms_title() {
        Assert.assertEquals(elementGetText(dp.DB_Title), "LMS - Learning Management System");
    }

    @Then("Admin should see the navigation bar text on the top right side")
    public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
        int xPosition = dp.DB_MenuItems.getLocation().getX();
        int yPosition = dp.DB_MenuItems.getLocation().getY();

    }

  

  

}
