package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "E:\\QA\\Selenium_WorkSpace\\BDDCucumberProject\\src\\main\\java\\features" }, glue = {
		"stepDefinations" }, // path of the step definations file
		monochrome = true, // display the console output in a proper readable format
		dryRun = false) // to check whether mapping is proper or not
// , format = { "pretty", "html:test-output" })
public class TestRunner {

}
