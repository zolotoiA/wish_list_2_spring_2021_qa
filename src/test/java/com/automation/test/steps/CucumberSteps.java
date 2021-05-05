package com.automation.test.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberSteps {
    @Given("^Cucumber dependencies$")
    public void cucumber_dependencies() {
        System.out.println("Given executed");
    }

    @When("^Test starts$")
    public void test_starts() {
        System.out.println("When executed");
    }

    @Then("^Cucumber works$")
    public void cucumber_works() {
        System.out.println("Then executed");
    }
}
