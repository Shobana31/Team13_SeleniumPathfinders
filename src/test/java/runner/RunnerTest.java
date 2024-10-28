package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
glue = {"stepDefinitions","hooks"},
plugin = {"pretty"},
monochrome=true)
//extends AbstractTestNGCucumberTests 
public class RunnerTest extends AbstractTestNGCucumberTests {

}
