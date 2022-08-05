package deletelead;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/deletelead/LeadDelete.feature", glue = "deletelead",
				 monochrome = true, publish = true)
public class DeleteLeadRunner extends AbstractTestNGCucumberTests {

}
