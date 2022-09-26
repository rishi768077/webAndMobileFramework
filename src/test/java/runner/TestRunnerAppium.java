package runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import utility.ScreenRecording;

import java.awt.*;
import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/Appium.feature",glue = {"stepDefinition"},
        monochrome = true,
        plugin = {"pretty","html:target/cucumber-report-html/report.html","json:target/cucumber.json"},
        tags="@Appium")
public class TestRunnerAppium {





}
