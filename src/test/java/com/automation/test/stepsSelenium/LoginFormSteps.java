package com.automation.test.stepsSelenium;

import com.automation.pageobjects.LandingPage;
import com.automation.propertyreader.PropertiesFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.NoSuchElementException;

import static com.automation.utils.ChooseOfWebDriver.getDriver;
import static org.junit.jupiter.api.Assertions.*;

public class LoginFormSteps {
    LandingPage landingPage = new LandingPage(getDriver());

    @Given("user is on landing page")
    public void userIsOnLandingPage() {
        getDriver().get(PropertiesFileReader.getProperty("urlUI"));
    }

    @When("user clicks Login button")
    public void userClicksLoginButton() {
        landingPage.getLandingPageLoginBtn().click();
        assertAll(
                () -> assertTrue(landingPage.getLoginFormItems().isDisplayed()),
                () -> assertEquals("Login", landingPage.getLandingPageLoginBtn().getText())
        );
    }

    @Then("{} is displayed to user")
    public void loginFormIsTriggered(String item) {
        switch (item) {
            case "Login form":
                assertEquals("Login", landingPage.getLoginFormItems().getLoginFormTitle().getText());
                break;
            case "Email field":
                assertTrue(landingPage.getLoginFormItems().getEmailField().isDisplayed());
                break;
            case "Password field":
                assertTrue(landingPage.getLoginFormItems().getPasswordField().isDisplayed());
                break;
            case "Login button":
                assertTrue(landingPage.getLoginFormItems().getLoginFormButton().isDisplayed());
                break;
            default:
                throw new NoSuchElementException();
        }
    }
}
