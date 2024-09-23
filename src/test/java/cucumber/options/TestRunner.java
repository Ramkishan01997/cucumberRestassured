package cucumber.options;

import org.junit.runner.RunWith;

//import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",plugin="json:target/jsonReports/cucumberReports/cucumber-report.json",glue={"stepDefinations"},tags = "@User")
public class TestRunner {
//tags = "@DeletePlace"
}
