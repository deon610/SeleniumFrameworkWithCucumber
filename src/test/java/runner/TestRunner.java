package runner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/feature",
		glue= {"stepdefinition"},
		plugin= {"pretty", "html:test-output"},
		tags = {"@Regression"},
		monochrome = true,
		dryRun = false,
		strict = true
)

//@CucumberOptions(
//		   features = the path of the feature files
//		   glue=the path of the step definition files
//		   format= {"pretty", "html:test-output"} to generate different types of reporting //not in use apparently use plugin
//		   monochrome = true | display the console  //has many formats; output in a proper readable format
//		   strict = true | it will check if any step is not defined in step definition file and fail it
//		   dryRun = true | to check the mapping is proper between feature file and step def file
//		   )
public class TestRunner
{

}
