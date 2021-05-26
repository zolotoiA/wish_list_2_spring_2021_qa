package com.automation.test.stepsSelenium;

import com.automation.pageobjects.*;
import com.automation.propertyreader.PropertiesFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;

import static com.automation.utils.ChooseOfWebDriver.getDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Log4j2
public class DisplayEditFormSteps {

    private MainDashboardPage dashboardPage = new MainDashboardPage(getDriver());
    private LandingPage landingPage = new LandingPage(getDriver());

    @Given("Navigate to wishlist page")
    public void wishlistPageIsAccessed() {
        getDriver().get(PropertiesFileReader.getProperty("urlUI"));
    }

    @When("Customer click on login button from header panel")
    public void customerClickOnLoginButton() {
        landingPage.clickLogin();
    }

    @When("Customer input login credentials")
    public void loginFormIsPopulated() throws InterruptedException {
        landingPage.userLogin("caramba@mail.ru", "usernamebl1");
    }

    @Then("Customer click login button")
    public void clickToLoginButton() {
        landingPage.getLoginFormComponent().getLoginFormButton().click();
        landingPage.waitPageOrElement();
        assertAll(
                () -> assertTrue(landingPage.getLoginFormComponent().isDisplayed()),
                () -> assertEquals("Login", landingPage.getLandingPageLoginBtn().getText())
        );
    }

    @Then("user is redirected to main dashboard page")
    public void mainDashboardIsDisplayed() {
        assertEquals("Welcome back, username", dashboardPage.headerItems.getWelcomeText().getText());
    }

    @Given("Customer click to edit button")
    public void clickEditButton() {
        dashboardPage.getExistingWishlistByTitle("ANATOLII").getEditButton().click();
    }

    @When("Edit popup is present")
    public void checkAllElementIsPresent() {
        dashboardPage.getEditFormComponent().waitEditFormElement();
        assertThat("When button is clicked", dashboardPage.getEditFormComponent().getWishlistHeaderTitle().isDisplayed());
    }

    @Then("All element is present")
    public void allElementISPresent() {
        dashboardPage.getEditFormComponent().waitEditFormElement();
        assertAll("All element should be displayed",
                () -> assertTrue(dashboardPage.getEditFormComponent().getTitleLabel().isDisplayed()),
                () -> assertTrue(dashboardPage.getEditFormComponent().getTitleField().isDisplayed()),
                () -> assertTrue(dashboardPage.getEditFormComponent().getTextField().isDisplayed()),
                () -> assertTrue(dashboardPage.getEditFormComponent().getTypeLabel().isDisplayed()),
                () -> assertTrue(dashboardPage.getEditFormComponent().getDescriptionLabel().isDisplayed()),
                () -> assertTrue(dashboardPage.getEditFormComponent().getDateLabel().isDisplayed()),
                () -> assertTrue(dashboardPage.getEditFormComponent().getPrivacyLabel().isDisplayed()),
                () -> assertTrue(dashboardPage.getEditFormComponent().getSaveChangesButton().isDisplayed()));
    }
}
