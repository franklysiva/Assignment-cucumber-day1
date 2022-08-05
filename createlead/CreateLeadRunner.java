package createlead;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/createlead/LeadCreate.feature", glue = "createlead",
				 monochrome = true, publish = true)
public class CreateLeadRunner extends AbstractTestNGCucumberTests {

}
