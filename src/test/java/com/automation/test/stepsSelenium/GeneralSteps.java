package com.automation.test.stepsSelenium;

import com.automation.utils.ChooseOfWebDriver;
import com.automation.utils.ClickElement;
import io.cucumber.java.en.When;

import static com.automation.utils.ChooseOfWebDriver.getDriver;

public class GeneralSteps {

    @When("user clicks on {string} from {string}")
    public void userClicksOn(String button, String page) {
        ClickElement.clickElement(page, button, getDriver());
    }
}