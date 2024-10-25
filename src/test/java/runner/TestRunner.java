package runner;



import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;



@CucumberOptions(features="src/test/resources/features/LoginPage.feature",
glue={"stepDefinitions","hooks"},
plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
"html:reports/Cucumber-Reports/Reports.html"}
		)

public class TestRunner extends AbstractTestNGCucumberTests{

	
	
}

