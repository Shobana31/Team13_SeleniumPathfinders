package runner;



import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;



@CucumberOptions(features="src/test/resources/features/TC04_02_Batch_Page_Validation.feature",
glue={"stepDefinitions","hooks"},
plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
"html:reports/Cucumber-Reports/Reports.html"}
		)

public class TestRunner extends AbstractTestNGCucumberTests{

	
	
}

