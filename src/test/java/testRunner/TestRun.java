package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = ".//Features/Customers.feature",
                glue = "stepDefinitions",
                dryRun = false,
                strict = false,
                monochrome = true,
                plugin = {"pretty","html:test-output"},
                tags= {"@sanity"}
        )
public class TestRun {

}
