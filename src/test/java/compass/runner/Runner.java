package compass.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = "", 
		features = "src/test/resources/compass.feature", 
		glue = {"compass/stepDefinitions"},
		plugin = {"json:target/cucumber-reports/cucumber.json","html:target/cucumber-reports/cucumber.html"},
		monochrome = true
		)
public class Runner {
	
}
