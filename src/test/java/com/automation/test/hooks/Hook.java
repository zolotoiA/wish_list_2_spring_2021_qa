package com.automation.test.hooks;

import com.automation.utils.TakeScreenShot;
import com.automation.utils.ChooseOfWebDriver;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static com.automation.utils.TakeScreenShot.reportDir;

@Log4j2
public class Hook extends ChooseOfWebDriver {
   public Scenario scenario;

    @Before
    public void beforeStep(Scenario scenario) throws IOException {
        this.scenario = scenario;
        if ((new File(reportDir)).exists())
            FileUtils.cleanDirectory(new File(reportDir));
    }

    @AfterStep
    public void afterStepHook(Scenario addScreenShotAfterEachStep) throws IOException {
        ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(TakeScreenShot.getScreenShot(getDriver()));
        log.info("ScreenShot captured to report");
        addScreenShotAfterEachStep.log("ScreenShot added");
    }

    @After
    public void tearDown() {
        quitDriver();
    }
}
