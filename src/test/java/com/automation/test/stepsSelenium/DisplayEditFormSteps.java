package com.automation.test.stepsSelenium;

import com.automation.pageobjects.*;
import com.automation.propertyreader.PropertiesFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import static com.automation.utils.ChooseOfWebDriver.getDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Log4j2
public class DisplayEditFormSteps {

    HeaderComponent headerPage = new HeaderComponent(getDriver());
    MainDashboardPage dashboardPage = new MainDashboardPage(getDriver());
    EditFormComponent editFormElement = new EditFormComponent(getDriver());
    LandingPage landingPage = new LandingPage(getDriver());

    @Given("Navigate to wishlist page")
    public void wishlistPageIsAccessed() {
        getDriver().get(PropertiesFileReader.getProperty("urlUI"));
    }

    @When("Customer click on login button from header panel")
    public void customerClickOnLoginButton() {
        landingPage.getLandingPageLoginBtn().click();
    }

    @When("Customer input login credentials")
    public void loginFormIsPopulated() throws InterruptedException {
        landingPage.genericLogin("caramba@mail.ru", "usernamebl1");
    }

    @Then("Customer click login button")
    public void clickToLoginButton() {
        landingPage.getLoginFormItems().getLoginFormButton().click();
        landingPage.waitMaindashboardPage();
        assertAll(
                () -> assertTrue(landingPage.getLoginFormItems().isDisplayed()),
                () -> assertEquals("Login", landingPage.getLandingPageLoginBtn().getText())
        );
    }

    @Then("user is redirected to main dashboard page")
    public void mainDashboardIsDisplayed() {
        assertEquals("Welcome back, username", headerPage.getWelcomeText().getText());
    }

    @Given("Customer click to edit button")
    public void clickEditButton() {
        dashboardPage.getCardByTitle("ANATOLII").getEditButton().click();
    }

    @When("Edit popup is present")
    public void checkAllElementIsPresent() {
        editFormElement.waitEditFormElement();
        assertThat("When button is clicked", editFormElement.getWishlistHeaderTitle().isDisplayed());
    }

    @Then("All element is present")
    public void allElementISPresent() {
       editFormElement.waitEditFormElement();
        Assertions.assertAll("All element should be displayed",
                () -> assertTrue(editFormElement.getTitleLabel().isDisplayed()),
                () -> assertTrue(editFormElement.getTitleField().isDisplayed()),
                () -> assertTrue(editFormElement.getTextField().isDisplayed()),
                () -> assertTrue(editFormElement.getTypeLabel().isDisplayed()),
                () -> assertTrue(editFormElement.getDescriptionLabel().isDisplayed()),
                () -> assertTrue(editFormElement.getDateLabel().isDisplayed()),
                () -> assertTrue(editFormElement.getPrivacyLabel().isDisplayed()),
                () -> assertTrue(editFormElement.getSaveChangesButton().isDisplayed()));
    }
}