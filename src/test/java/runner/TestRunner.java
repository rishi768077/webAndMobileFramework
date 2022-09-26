package runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/FlightDetails.feature",glue = {"stepDefinition"},
        monochrome = true,
        plugin = {"pretty","html:target/cucumber-report-html/report.html","json:target/cucumber.json"},
        tags="@smokeTest")
public class TestRunner {

}
