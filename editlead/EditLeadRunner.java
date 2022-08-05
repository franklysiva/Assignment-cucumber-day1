package editlead;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/editlead/LeadEdit.feature", glue = "editlead",
monochrome = true, publish = true)
public class EditLeadRunner extends AbstractTestNGCucumberTests {
	
}
