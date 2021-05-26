package com.automation.test.runnerSelenium;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = {"src/test/resources/featuresSelenium/"},
        glue = {"com.automation.test.stepsSelenium", "com.automation.test.hooks"},
        stepNotifications = true
)
public class CucumberRunnerSelenium {

}