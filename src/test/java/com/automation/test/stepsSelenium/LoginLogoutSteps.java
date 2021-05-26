package com.automation.test.stepsSelenium;

import com.automation.pageobjects.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.automation.utils.ChooseOfWebDriver.getDriver;
import static org.junit.jupiter.api.Assertions.*;

public class LoginLogoutSteps {
    private LandingPage landingPage = new LandingPage(getDriver());

    @Given("user enters valid data in {string} and {string} field")
    public void enterValidData(String email, String pass) {
        landingPage.userLogin(email, pass);
    }

    @Given("user leaves mandatory fields blank")
    public void userLeavesMandatoryFieldsBlank() {
        landingPage.loginButtonDisplayed();
        assertAll(
                () -> assertTrue(landingPage.getLoginFormComponent().getEmailField().getText().isBlank()),
                () -> assertTrue(landingPage.getLoginFormComponent().getPasswordField().getText().isBlank())
        );
    }

    @When("user clicks Login button on login form")
    public void userClicksLoginButtonOnLoginForm() throws InterruptedException {
        landingPage.getLoginFormComponent().getLoginFormButton().click();
        landingPage.waitPageOrElement();
    }

    @Then("user is redirected to main dashboard page {string}")
    public void userIsRedirectedToMainDashboardPage(String msg) {
        assertEquals(msg, landingPage.headerItems.getWelcomeText().getText());
    }

    @Then("user gets error messages displayed under {} fields")
    public void userGetsErrorMessagesDisplayed(String fieldErrorMessage) {
        switch (fieldErrorMessage) {
            case "email":
                assertEquals(fieldErrorMessage, landingPage.getLoginFormComponent().getLoginFieldErrorMsg().getText());
                break;
            case "password":
                assertEquals(fieldErrorMessage, landingPage.getLoginFormComponent().getPasswordFieldErrorMsg().getText());
                break;
        }
    }

    @Given("user enters a wrong email or password in {string},{string} fields")
    public void userEntersAWrongEmailPasswordInEmailPasswordFields(String emailData, String passwordData) {
        landingPage.userLogin(emailData, passwordData);
    }

    @Then("user gets error messages displayed {string}")
    public void userGetsErrorMessagesDisplayedWrongEmailPasswordMessage(String fieldErrorMessage) {
        switch (fieldErrorMessage) {
            case "Please enter a valid email address":
                assertEquals(fieldErrorMessage, landingPage.getLoginFormComponent().getLoginFieldErrorMsg().getText());
                break;
            case "Please enter a password":
                assertEquals(fieldErrorMessage, landingPage.getLoginFormComponent().getPasswordFieldErrorMsg().getText());
                break;
            case "The password contains white spaces":
                assertEquals(fieldErrorMessage, landingPage.getLoginFormComponent().getPasswordWhiteSpaceError().getText());
                break;
        }
    }

    @Given("user enters spaces instead of valid credentials in {string},{string} fields")
    public void userEntersSpacesInsteadOfValidCredentialsInEmailPasswordFields(String emailData, String passwordData) {
        landingPage.userLogin(emailData, passwordData);
    }
}
