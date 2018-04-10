package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		plugin= {
				"html:target/cucumber_report",
				"json:target/cucumber.json"		
				},
		tags="@heb",	
		features = "src/test/resources/features/heb_coupons.feature", 
		glue = "step_definitions",
		dryRun=false
)
public class CukesRunner extends AbstractTestNGCucumberTests {

}
