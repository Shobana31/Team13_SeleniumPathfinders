	@LMS
	Feature: Program feature
	  I want to use this template for my feature file
Background:	
Given Admin successfully Logged on to the Portal 
	  
	
	 @P1
	   Scenario: Program Page navigation validation scenario
	    Given   Admin is on Dashboard Page
	    When    Admin selects Program from the menu
	    Then    Admin is navigated to the Program page 
	   
	 @P2
	   Scenario Outline: Program page menubar validation 
	    Given Admin is on the Dashboard Page
	    When  Admin selects Program from the menu
	    Then  Admin is able to see the "<name>" links in the menubar on the program page
	    
	     Examples: 
	      | name  |
	      |LMS|
	      |Program|
	      |Batch|
	      |Class|
	      |Logout|
	      
	      
#	 @P3
#	   Scenario: Program Page navigation validation scenario
#	    Given   Admin is on Dashboard Page
#	    When    Admin selects Program from the menu
#	    Then    Admin is navigated to the Program page   
	  
	  
	  
	     