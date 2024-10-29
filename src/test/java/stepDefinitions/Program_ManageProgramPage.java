package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import hooks.appHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BatchPage;
import pageObjects.DashboardPage;
import pageObjects.ManageProgramPage;
import pageObjects.MultiDeleteProgramPage;
import utilities.CommonMethods;
import utilities.LoggerLoad;


public class Program_ManageProgramPage extends CommonMethods {

	
		WebDriver driver = appHooks.getDriver();
		DashboardPage dp = new DashboardPage(driver);
		LoginSteps ls = new LoginSteps();
		BatchPage bp = new BatchPage(driver);
		ManageProgramPage pp=new ManageProgramPage(driver);
		MultiDeleteProgramPage mp= new MultiDeleteProgramPage(driver);
		
		
		@Given("Admin is logged in to LMS Portal")
		public void admin_is_logged_in_to_lms_portal() {
			getURL();
			ls.admin_enter_valid_credentials_and_clicks_login_button();
			implicitlyWait();
		}
	
	

		@Given("Admin is on dashboard page after Login")
		public void admin_is_on_dashboard_page_after_Login() {
		 String title = getPageTitle(driver);
		    Assert.assertEquals(title, "LMS");
		    LoggerLoad.info("Dashboard page " + title);
		}

		@When("Admin clicks Program on the navigation bar")
		public void admin_clicks_program_on_the_navigation_bar() {
		   pp.getprogramLink().click();
		   
		   
		}

		@Then("Admin should see the heading Manage Program")
		public void admin_should_see_the_heading_manage_program() {
			 // This may vary based on your layout
			Actions actions = new Actions(driver);
			 actions.moveToElement(mp.getsortby()).click().perform();
			 
			String ActualHeadertext=pp.getmanagePgmMainHeader();
			String Expectheader="Manage Program";
			Assert.assertEquals(ActualHeadertext,Expectheader);
			
			
		   
		    
		    
		 
		    }
		

		@Then("Admin should able to see Program name, description, and status for each program")
		public void admin_should_able_to_see_program_name_description_and_status_for_each_program() {
			int rowCount = pp.managePgmTbleRow.size();
			LoggerLoad.info("No of Rows in First Page of table: " + rowCount);
		}


		@Then("Admin should see a Delete button in left top is disabled")
		public void admin_should_see_a_delete_button_in_left_top_is_disabled() {
			WebElement deleteButton = pp.getmultiDeleteBtn();
			Assert.assertTrue(deleteButton.isDisplayed());
			if (deleteButton.isDisplayed()) {
	           LoggerLoad.info("The button is displayed.");
	        } else {
	            LoggerLoad.info("The button is NOT displayed.");
	        }
		
			// Get the button's position
	        int xPosition = deleteButton.getLocation().getX();
	        int yPosition = deleteButton.getLocation().getY();
	        LoggerLoad.info("The button xPosition is: " +xPosition);
	        LoggerLoad.info("The button yPosition is: " +yPosition);
	        

	       Assert.assertEquals(xPosition, 243, "The delete button should be positioned at x=243.");
	       Assert.assertEquals(yPosition, 148, "The delete button should be positioned at y=148.");

	       
		}
		
		@Then("Admin should see Search bar with text as Search...")
		public void admin_should_see_search_bar_with_text_as_search() {
			
			// Assuming pp.getsearchBarText() returns the WebElement for the search bar
			WebElement searchBar = pp.getsearchBarText();

			// Retrieve the placeholder text
			String actualSearchText = searchBar.getAttribute("placeholder");

			// Log the actual search text
			LoggerLoad.info("Actual Search Placeholder: " + actualSearchText);

			// Validate that the search bar is displayed
			Assert.assertTrue(searchBar.isDisplayed(), "The search bar is not displayed.");

			// Validate that the placeholder text is as expected
			String expectedPlaceholder = "Search..."; // Replace with your expected text
			Assert.assertEquals(actualSearchText, expectedPlaceholder, "The placeholder text is not as expected.");

			}

		@Then("Admin should see data table with column header on Manage Program Page as  Program Name, Program Description, Program Status, Edit or Delete")
		public void admin_should_see_data_table_with_column_header_on_manage_program_page_as_program_name_program_description_program_status_edit_or_delete() {
			List<WebElement> managePgmHeader = pp.getmanagePgmTbleRowHeaders();
			 for (WebElement header : managePgmHeader) {  
			{
				String headerText = header.getText(); // Get the text of each header
		        LoggerLoad.info(headerText);
				if (headerText.equals("Program Name")) {
			        LoggerLoad.info(header + " is a valid header.");
			    } else if (headerText.equals("Program Description")) {
			    	LoggerLoad.info(header + " is a valid header.");
			    } else if (headerText.equals("Program Status")) {
			    	LoggerLoad.info(header + " is a valid header.");
			    } else if (headerText.equals("Edit / Delete")) {
			        LoggerLoad.info(headerText + " is a valid header.");
			    } else {
			    	LoggerLoad.info(headerText + " is not a valid header.");
			    }
			}
				    }
				}
		
		@Then("Admin should see checkbox default state as unchecked beside Program Name column header")
		public void admin_should_see_checkbox_default_state_as_unchecked_beside_program_name_column_header() {
			WebElement default_checkbox = pp.getcheckbox_default();
			Assert.assertTrue(default_checkbox.isDisplayed());
			Assert.assertFalse(default_checkbox.isSelected());
		}
			
		
		@Then("Admin should see check box default state as unchecked on the left side in all rows against program name")
		public void admin_should_see_check_box_default_state_as_unchecked_on_the_left_side_in_all_rows_against_program_name() {
			List<WebElement> pgm_default_checkboxes= pp.getprgm_default_checkbox();
			for(WebElement checkboxes:pgm_default_checkboxes )
			{
				Assert.assertFalse(checkboxes.isSelected());
				LoggerLoad.info("Checkboxes next to Programs are Not selected");
			}
			}

		@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
		public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
		    
			List<WebElement> managePgmSort = pp.getprgm_sort_icon();
			for (WebElement sort : managePgmSort) {  
			{
				sort.isDisplayed();
				LoggerLoad.info("Sorting Arrow Icon is Displayed: " +sort);
				    
				}
			}
		}
		
		@Then("Admin should see the text as Showing x to y of z entries along with Pagination icon below the table. x- starting record number on that page.	y-ending record number on that page. z-Total number of records")
		public void admin_should_see_the_text_as_showing_x_to_y_of_z_entries_along_with_pagination_icon_below_the_table_x_starting_record_number_on_that_page_y_ending_record_number_on_that_page_z_total_number_of_records() {
			
			String pagination_Text = pp.getpagination_icon().getText();
			
			LoggerLoad.info("Pagination Text: " +pagination_Text);

			// Assert that the pagination text is NOT empty
			Assert.assertFalse(pagination_Text.isEmpty(), "Pagination text should not be empty.");
			 
			
		}
		
		
		@Then("Admin should see the footer as In total there are z programs.z- Total number of records")
		public void admin_should_see_the_footer_as_in_total_there_are_z_programs_z_total_number_of_records() {
		  
			
			String pagination_footerText = pp.getpgm_footer_message().getText();
			
			LoggerLoad.info("Pagination Text: " +pagination_footerText);

			// Assert that the pagination text is NOT empty
			Assert.assertFalse(pagination_footerText.isEmpty(), "Pagination text should not be empty.");
		}
		}

	
	
		

		
		



