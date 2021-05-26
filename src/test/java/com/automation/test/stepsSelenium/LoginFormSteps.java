package com.automation.test.stepsSelenium;

import com.automation.pageobjects.LandingPage;
import com.automation.propertyreader.PropertiesFileReader;
import com.automation.utils.ChooseOfWebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

import java.util.NoSuchElementException;

import static com.automation.utils.ChooseOfWebDriver.getDriver;
import static org.junit.jupiter.api.Assertions.*;
@Log4j2
public class LoginFormSteps{
    private LandingPage landingPage = new LandingPage(getDriver());

    @Given("user is on landing page")
    public void userIsOnLandingPage() {
        getDriver().get(PropertiesFileReader.getProperty("urlUI"));
    }

    @When("user clicks Login button")
    public void userClicksLoginButton() {
        landingPage.clickLogin();
        assertAll(
                () -> assertTrue(landingPage.getLoginFormComponent().isDisplayed()),
                () -> assertEquals("Login", landingPage.loginGetText())
        );
    }

    @Then("{} is displayed to user")
    public void loginFormIsTriggered(String item) {
        switch (item) {
            case "Login form":
                assertEquals("Login", landingPage.getLoginFormComponent().getLoginFormTitle().getText());
                break;
            case "Email field":
                assertTrue(landingPage.getLoginFormComponent().getEmailField().isDisplayed());
                break;
            case "Password field":
                assertTrue(landingPage.getLoginFormComponent().getPasswordField().isDisplayed());
                break;
            case "Login button":
                assertTrue(landingPage.getLoginFormComponent().getLoginFormButton().isDisplayed());
                break;
            default:
                throw new NoSuchElementException();
        }
    }
}
