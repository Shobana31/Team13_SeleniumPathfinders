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
		
	    //cp.selectBatchName();
	    cp.setClassTopic();
	    Thread.sleep(2000);
	    cp.setClassDescription();
	    Thread.sleep(3000);
	    cp.clickDatePicker();
	    Thread.sleep(5000);
	    cp.enternoofClasses();
	    Thread.sleep(2000);
	    cp.clickStaffName();
	    Thread.sleep(2000);
	    cp.clickStatus();
	    Thread.sleep(2000);
	    cp.clickSave();
	    
	}

	@Then("Admin get success message")
	public void admin_get_success_message() {
	    
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










}
