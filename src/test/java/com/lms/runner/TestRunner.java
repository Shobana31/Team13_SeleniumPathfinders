package com.lms.runner;


import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",glue = {"com/lms/steps"},
        plugin = {"pretty","html:target/cucumber-reports/cucumber.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class TestRunner {
}
