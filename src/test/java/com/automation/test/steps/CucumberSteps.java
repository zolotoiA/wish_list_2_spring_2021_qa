package com.automation.test.steps;

import com.automation.pageobjects.MainDashboardPage;
import com.automation.propertyreader.PropertiesFileReader;
import com.automation.utils.ChooseOfWebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class CucumberSteps extends ChooseOfWebDriver {

    MainDashboardPage testPom = new MainDashboardPage(getDriver());
    Actions action = new Actions(getDriver());

    @Given("^Cucumber dependencies$")
    public void cucumber_dependencies() {
        System.out.println("Given executed");
        getDriver().get(PropertiesFileReader.getProperty("url"));
    }

    @When("Test starts")
    public void test_starts() {
        System.out.println("When executed");
        testPom.getCardByTitle("41").getEditButton().click();
    }

    @Then("^Cucumber works$")
    public void cucumber_works() {
        System.out.println("Then executed");
    }
}
