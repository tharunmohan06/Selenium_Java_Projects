package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./src/test/resources/Features/login2.feature", 
		glue = "StepDefinitions",
		monochrome = true,
		plugin = {"pretty","html:reports/htmlreport.html","json:reports/jsonreport.json"}	
)

public class TestRunner {

}
