package com.automation.test.runnerApi;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/featuresApi/"},
        glue = {"com.automation.test.stepsApi"},
        stepNotifications = true)
public class CucumberRunnerApi {

}