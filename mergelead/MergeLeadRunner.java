package mergelead;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/mergelead/LeadMerge.feature", glue = "mergelead",
monochrome = true, publish = true)
public class MergeLeadRunner extends AbstractTestNGCucumberTests {

}
