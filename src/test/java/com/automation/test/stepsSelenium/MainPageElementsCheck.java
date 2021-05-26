package com.automation.test.stepsSelenium;

import com.automation.actions.AccessTheWebsiteAction;
import com.automation.pageobjects.LandingPage;
import com.automation.test.restapi.config.RestApiSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.automation.utils.ChooseOfWebDriver.getDriver;
import static org.junit.jupiter.api.Assertions.*;

public class MainPageElementsCheck extends RestApiSetUp {

    @Given("The Landing page is accessed")
    public void theLandingPageIsAccessed() {
        AccessTheWebsiteAction action = new AccessTheWebsiteAction();
        action.accessTheWebsite();
    }

    @Then("Header, footer, Register and Login buttons are displayed")
    public void headerFooterRegisterAndLoginButtonsAreDisplayed() {
        LandingPage landingPage = new LandingPage(getDriver());
        assertAll(
                () -> assertTrue(landingPage.footerDisplayed()),
                () -> assertTrue(landingPage.headerDisplayed()),
                () -> assertTrue(landingPage.loginButtonDisplayed()),
                () -> assertTrue(landingPage.registerButtonDisplayed()));
    }
}
