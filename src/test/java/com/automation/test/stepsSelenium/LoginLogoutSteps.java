package com.automation.test.stepsSelenium;

import com.automation.pageobjects.HeaderPage;
import com.automation.pageobjects.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.automation.utils.ChooseOfWebDriver.getDriver;
import static org.junit.jupiter.api.Assertions.*;

public class LoginLogoutSteps {
    LandingPage landingPage = new LandingPage(getDriver());
    HeaderPage headerPage = new HeaderPage(getDriver());

    @Given("user enters valid data in {string} and {string} field")
    public void enterValidData(String email, String pass) {
        landingPage.genericLogin(email, pass);
    }

    @Given("user leaves mandatory fields blank")
    public void userLeavesMandatoryFieldsBlank() {
        assertAll(
                () -> assertTrue(landingPage.getLoginFormItems().getEmailField().getText().isBlank()),
                () -> assertTrue(landingPage.getLoginFormItems().getPasswordField().getText().isBlank())
        );
    }

    @When("user clicks Login button on login form")
    public void userClicksLoginButtonOnLoginForm() throws InterruptedException {
        landingPage.getLoginFormItems().getLoginFormButton().click();
        landingPage.waitMaindashboardPage();
    }

    @Then("user is redirected to main dashboard page {string}")
    public void userIsRedirectedToMainDashboardPage(String msg) {
        assertEquals(msg, headerPage.getWelcomeText().getText());
    }

    @Then("user gets error messages displayed under {} fields")
    public void userGetsErrorMessagesDisplayed(String fieldErrorMessage) throws InterruptedException {
        switch (fieldErrorMessage) {
            case "email":
                assertEquals(fieldErrorMessage, landingPage.getLoginFormItems().getLoginFieldErrorMsg().getText());
                break;
            case "password":
                assertEquals(fieldErrorMessage, landingPage.getLoginFormItems().getPasswordFieldErrorMsg().getText());
                break;
        }
    }

    @Given("user enters a wrong email or password in {string},{string} fields")
    public void userEntersAWrongEmailPasswordInEmailPasswordFields(String emailData, String passwordData) {
        landingPage.genericLogin(emailData, passwordData);
    }

    @Then("user gets error messages displayed {string}")
    public void userGetsErrorMessagesDisplayedWrongEmailPasswordMessage(String fieldErrorMessage) throws InterruptedException {
        switch (fieldErrorMessage) {
            case "Please enter a valid email address":
                assertEquals(fieldErrorMessage, landingPage.getLoginFormItems().getLoginFieldErrorMsg().getText());
                break;
            case "Please enter a password":
                assertEquals(fieldErrorMessage, landingPage.getLoginFormItems().getPasswordFieldErrorMsg().getText());
                break;
            case "The password contains white spaces":
                assertEquals(fieldErrorMessage, landingPage.getLoginFormItems().getPasswordWhiteSpaceError().getText());
                break;
        }
    }

    @Given("user enters spaces instead of valid credentials in {string},{string} fields")
    public void userEntersSpacesInsteadOfValidCredentialsInEmailPasswordFields(String emailData, String passwordData) {
        landingPage.genericLogin(emailData, passwordData);
    }
}
