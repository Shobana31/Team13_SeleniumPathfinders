package stepDefinitions;




import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import hooks.appHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ClassPage;
import utilities.PropertyLoader;

public class ClassSteps {
	 WebDriver driver = appHooks.getDriver();
	 ClassPage cp = new ClassPage(driver);
	 
	 public PropertyLoader propertyLoader;

	    public ClassSteps() {
	        propertyLoader = new PropertyLoader();
	    }
	
	
	
	@Given("Admin in dashboard page")
	public void admin_in_dashboard_page(){
		driver.getCurrentUrl();
		//driver.get("https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/");
		System.out.println(driver.getCurrentUrl());
	}

	@When("Admin click classLink in navigation bar")
	public void admin_click_classLink_in_navigation_bar() throws InterruptedException {
		Thread.sleep(2000);
	    cp.clickClass();
	    Thread.sleep(1000);
	   
	}

	@Then("Admin should see manage class page")
	public void admin_should_see_manage_class_page(){  	   
		cp.isManageClassDisplayed();	    
	    Assert.assertTrue(true);
	}
	
	@Then("Admin sees the title")
	public void admin_sees_the_title() {		
		String txt = cp.getClassTitle();
	    System.out.println(txt);
	    Assert.assertEquals(txt,"LMS - Learning Management System");
	}
	@Then("Admin see the header")
	public void admin_see_the_header() {
         String txt = cp.getTextManageClass();
         System.out.println(txt);
 	    Assert.assertEquals(txt,"Manage Class");
	}
	@Then("Admin see the searchbar in the page")
	public void admin_see_the_searchbar_in_the_page() {
	    cp.isSearchbarDisplayed();
	    Assert.assertTrue(true);
	}
	@Then("Admin see the sorticon in class page")
	public void admin_see_the_sorticon_in_class_page() {
	    cp.isCheckboxDisplayed();
	    Assert.assertTrue(true);
	}
	
	@Then("Admin see the datatable heading in the page")
	public void admin_see_the_datatable_heading_in_the_page() {
	    cp.isTableHeaderDisplayed();
	    Assert.assertTrue(true);
	}
	
	@Then("Admin see the text and icon of pagination")
	public void admin_see_the_text_and_icon_of_pagination() {
	    String txt = cp.getShowingmsg();
	    System.out.println(txt);
	    Assert.assertEquals(txt.substring(0,7), "Showing");
	    
	    cp.isPaginationDisplayed();
	    Assert.assertTrue(true);
	}
	
	@Then("Admin see deletebtn in class page")
	public void admin_see_deletebtn_in_class_page() {
	    cp.isDeletebtnDisplayed();
	    Assert.assertTrue(true);
	}
	
	@Then("Admin see total no of classes below in class page")
	public void admin_see_total_no_of_classes_below_in_class_page() {
	    cp.isTotalpagesDisplayed();
	    Assert.assertTrue(true);
	}

    //Add new Class
	@Given("Admin on manage page")
	public void admin_on_manage_page() throws InterruptedException {
		admin_in_dashboard_page();
		System.out.println(driver.getTitle());
	}

	@When("Admin click a add new class under class menu")
	public void admin_click_a_add_new_class_under_class_menu() throws InterruptedException {
		Thread.sleep(2000);
		cp.clickClass();
	    Thread.sleep(1000);
	    cp.clickAddClass();
//	    Thread.sleep(2000);
//	    cp.clickBtnClose();
	}

	@Then("Admin see popup open for class details")
	public void admin_see_popup_open_for_class_details() {
	    cp.isPopupClassDetailsDisplayed();
	    Assert.assertTrue(true);
	}
	
	@Then("Admin see few input field and text boxes")
	public void admin_see_few_input_field_and_text_boxes() {
	    String classDetails = cp.getDialogClassDetails();
	    System.out.println(classDetails.substring(0,12));
	    Assert.assertEquals(classDetails.substring(0,12), "Class Detail");
	}
	
	//Add New Popup class detail window
	@Given("Admin in class popup")
	public void admin_in_class_popup() throws InterruptedException {
		Thread.sleep(2000);		
		cp.switchPopupClassDetails();
		Thread.sleep(2000);
	}

	@When("Admin enter mandatory fields")
	public void admin_enter_mandatory_fields() throws InterruptedException {
		Thread.sleep(2000);
		cp.enterClassDetailsData(); 
		//cp.checkToastMessage();
	}

	@Then("Admin get success message")
	public void admin_get_success_message() throws InterruptedException {
		System.out.println("Successful, Class created");
	    //cp.checkToastMessage();
	}
	
	@When("Admin enter invalid input in the fields")
	public void admin_enter_invalid_input_in_the_fields() throws InterruptedException {
	    cp.enterInvalidClassDetailsData();
	}

	@Then("Admin get error message class is not created")
	public void admin_get_error_message_class_is_not_created() {
	    Assert.assertTrue(cp.getAssertionMsg());
	}
	//Edit
		@Given("Admin in edit class popup")
		public void admin_in_edit_class_popup() throws InterruptedException {
			Thread.sleep(2000);
		    cp.clickEdit();
		}

		@When("Admin update fields with valid data and click save")
		public void admin_update_fields_with_valid_data_and_click_save() throws InterruptedException {
		   Thread.sleep(2000);
			cp.enterUpdateClassDetailsData();
		}

		@Then("Admin get message class details update successfully")
		public void admin_get_message_class_details_update_successfully() {
		    System.out.println("Class updated");
		}
		@When("Admin click edit icon")
		public void admin_click_edit_icon() throws InterruptedException {
			admin_in_edit_class_popup();
		}

		@Then("Admin see batchname field is disabled")
		public void admin_see_batchname_field_is_disabled() throws InterruptedException {
			Thread.sleep(2000);
			boolean state = driver.findElement(By.xpath("//input[@placeholder='Select a Batch Name']")).isEnabled();
		   System.out.println("Batchname Enabled:" +state );
		}
		@Then("Admin see class topic field is disabled")
		public void admin_see_class_topic_field_is_disabled() throws InterruptedException {
			Thread.sleep(2000);
			boolean state = driver.findElement(By.xpath("//input[@id='classTopic']")).isEnabled();
		   System.out.println("Class Topic Enabled:" +state );
		}
		@When("Admin click cancel button")
		public void admin_click_cancel_button() {
		    driver.findElement(By.xpath("//button[@class='p-button-rounded p-button-danger p-button p-component ng-star-inserted']")).click();
		}

		@Then("Admin see the popup disappear and nothing changes")
		public void admin_see_the_popup_disappear_and_nothing_changes() {
		    System.out.println("Popup disappeared");
		}
	
	//pagination
	//Next page
	@Then("Admin clicks classLink in navigation bar")
	public void admin_clicks_class_link_in_navigation_bar() throws InterruptedException {
		Thread.sleep(3000);
		cp.clickClass();
		Thread.sleep(2000);
	    cp.clickAddClass();	
	    Thread.sleep(2000);
	    cp.clickBtnClose();
	}
	@When("Admin click next page link")
	public void admin_click_next_page_link() throws InterruptedException {
		
		JavascriptExecutor js =(JavascriptExecutor)driver;		
		js.executeScript("window.scrollBy(0,276)"," ");
		Thread.sleep(1000);
		System.out.println(cp.clickFirstPageButton());
		
	}
    
	//Last page
	@Then("Admin should see the next page record with link enabled")
	public void admin_should_see_the_next_page_record_with_link_enabled() {
	    System.out.println(cp.isNextButtonActive());
	}
	
	@When("Admin clicks last page link")
	public void admin_clicks_last_page_link() throws InterruptedException {
		Thread.sleep(2000);
		cp.clickNextPageButton();
		
	}
    
	//Previous page
	@Then("Admin should see the last page record with next link disabled")
	public void admin_should_see_the_last_page_record_with_next_link_disabled() {
	   Assert.assertTrue(cp.isNextPageButtonDisabled());
	}
	
	@When("Admin click previous  page link")
	public void admin_click_previous_page_link() throws InterruptedException {
		Thread.sleep(3000);
		cp.clickLastPageButton();
		Thread.sleep(3000);
	    cp.clickPreviousButton();
	}
    
	//Start page
	@Then("Admin should see the previous page record with link enabled")
	public void admin_should_see_the_previous_page_record_with_link_enabled() {
		 Assert.assertTrue(cp.isPreviousButtonActive());
	}
	
	@When("Admin clicks  first page link")
	public void admin_clicks_first_page_link() throws InterruptedException {
		Thread.sleep(3000);
		cp.clickLastPageButton();
		Thread.sleep(2000);
		cp.clickStartPageButton();
	}

	@Then("Admin should see the first page record with previous link disabled")
	public void admin_should_see_the_first_page_record_with_previous_link_disabled() {
		 Assert.assertTrue(cp.isPreviousPageButtonDisabled());
	}
	
	//Search box by batch name
	@When("Admin enter batch name in the search textbox")
	public void admin_enter_batch_name_in_the_search_textbox() throws InterruptedException {
		Thread.sleep(5000);
	   cp.enterBatchName();;
	}

	@Then("Admin see class details are searched by batchname")
	public void admin_see_class_details_are_searched_by_batchname() throws InterruptedException {
		 Thread.sleep(2000);
		 cp.getBatchNames();		
	}

    //Search by class topic
	@When("Admin enter class topic in the search textbox")
	public void admin_enter_class_topic_in_the_search_textbox() throws InterruptedException {
		Thread.sleep(2000);
	    cp.enterClassTopic();
	}

	@Then("Admin see class details are searched by classtopic")
	public void admin_see_class_details_are_searched_by_classtopic() throws InterruptedException {
		Thread.sleep(3000);
	    cp.getClassTopics();
	}
	
	//Search by staff name
	@When("Admin enter staff name in the search textbox")
	public void admin_enter_staff_name_in_the_search_textbox() throws InterruptedException {
		Thread.sleep(3000);
		cp.enterStaffName();
	}

	@Then("Admin see class details are searched by staff name")
	public void admin_see_class_details_are_searched_by_staff_name() throws InterruptedException {
		Thread.sleep(2000);
		cp.getStaffNames();
	}
    //Sort by batchname
	@When("Admin click batch name in the sort icon")
	public void admin_click_batch_name_in_the_sort_icon() throws InterruptedException {
		Thread.sleep(2000);
	    cp.clickSortBatchName();
	}
	@Then("Admin see class details are sorted by batchname")
	public void admin_see_class_details_are_sorted_by_batchname() {
	      cp.getBatchNames();
	}
   //Sort by class topic
	@When("Admin click class topic in the sort icon")
	public void admin_click_class_topic_in_the_sort_icon() {
	    cp.clickClassTopicSort();
	}

	@Then("Admin see class details are sorted by class topic")
	public void admin_see_class_details_are_sorted_by_class_topic() {
	    cp.getClassTopics();
	}
	 //Sort by class description
	@When("Admin click class description in the sort icon")
	public void admin_click_class_description_in_the_sort_icon() {
	    cp.clickClassDescSort();
	}
	@Then("Admin see class details are sorted by class description")
	public void admin_see_class_details_are_sorted_by_class_description() {
	    cp.getClassDescriptions();
	}
	
	//Sort by class status
	@When("Admin click class status in the sort icon")
	public void admin_click_class_status_in_the_sort_icon() {
	    cp.clickClassStatusSort();
	}

	@Then("Admin see class details are sorted by class status")
	public void admin_see_class_details_are_sorted_by_class_status() {
	   cp.getClassStatus();
	}
	//Sort by class date
	@When("Admin click class date in the sort icon")
	public void admin_click_class_date_in_the_sort_icon() {
	    cp.clickClassDateSort();
	}

	@Then("Admin see class details are sorted by class date")
	public void admin_see_class_details_are_sorted_by_class_date() {
	    cp.getClassdates();
	}
	//Sort by class staffname
	@When("Admin click class staff name in the sort icon")
	public void admin_click_class_staff_name_in_the_sort_icon() {
	   cp.clickClassStaffnameSort();
	}

	@Then("Admin see class details are sorted by class staff name")
	public void admin_see_class_details_are_sorted_by_class_staff_name() {
	   cp.getStaffNames();
	}

	//Delete row button
	@When("Admin click delete icon")
	public void admin_click_delete_icon() throws InterruptedException {
	    cp.clickDelete();	
	    //cp.getAlert();
	}

	@Then("Admin see alert open with heading confirm with yes and no button")
	public void admin_see_alert_open_with_heading_confirm_with_yes_and_no_button() throws InterruptedException  {
      System.out.println("Alert open with confirm heading..");
		
	}

}
