package com.automation.test.stepsSelenium;

import com.automation.pageobjects.RegisterFormPage;
import com.automation.propertyreader.PropertiesFileReader;
import com.automation.utils.ChooseOfWebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.concurrent.TimeUnit;

import static com.automation.test.restapi.enums.AssertionDescription.ASSERT_THAT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@Log4j2
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AbilityToRegisterStepsSelenium extends ChooseOfWebDriver {

    RegisterFormPage registerFormPage = new RegisterFormPage(getDriver());

    @Given("Wishlist page is accessed")
    public void wishlistPageIsAccessed() {
        getDriver().get(PropertiesFileReader.getProperty("urlUI"));
    }

    @When("Customer click on Register button from header panel")
    public void customerClickOnRegisterButton() {
        registerFormPage.getRegisterButtonFromHeader().click();
    }

    @Then("Register form is displayed")
    public void registerFormIsDisplayed() {
        registerFormPage.checkRegisterFormDisplaying(getDriver());
    }

    @Given("Customer enters valid{string}, {string}, {string}, {string}")
    public void customerEntersValid(String fullName, String email, String password, String confirmPassword) {
        registerFormPage.enterFullName(fullName);
        registerFormPage.enterEmailAddress(email);
        registerFormPage.enterPassword(password);
        registerFormPage.enterConfirmPassword(confirmPassword);
    }

    @When("Clicking on Register button")
    public void clickingOnRegisterButton() {
        registerFormPage.getRegisterButton().click();
    }

    @Then("Customer should be created and logged in")
    public void customerShouldBeCreatedAndLoggedIn() {
        registerFormPage.checkLoggedIn(getDriver());
    }

    @Given("Customer enters invalid{string}, {string}, {string}, {string}")
    public void customerEntersInvalid(String fullName, String email, String password, String confirmPassword) {
        registerFormPage.enterFullName(fullName);
        registerFormPage.enterEmailAddress(email);
        registerFormPage.enterPassword(password);
        registerFormPage.enterConfirmPassword(confirmPassword);
    }

    @Then("Error should be displayed {string}")
    public void errorShouldBeDisplayed(String errorMessage) throws InterruptedException {
        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        switch (errorMessage) {
            case "There is an existing account with this email":
                assertThat(ASSERT_THAT.getMessage(), errorMessage, is(equalTo(registerFormPage.getEmailExistingError().getText())));
                break;
            case "Please enter a full name":
                assertThat(ASSERT_THAT.getMessage(), errorMessage, is(equalTo(registerFormPage.getFullNameError().getText())));
                break;
            case "Please enter a valid email address":
                assertThat(ASSERT_THAT.getMessage(), errorMessage, is(equalTo(registerFormPage.getEmailError().getText())));
                break;
            case "Please enter a password":
                assertThat(ASSERT_THAT.getMessage(), errorMessage, is(equalTo(registerFormPage.getPasswordEmptyError().getText())));
                break;
            case "The password is too short":
                assertThat(ASSERT_THAT.getMessage(), errorMessage, is(equalTo(registerFormPage.getPasswordToShortError().getText())));
                break;
            case "Passwords do not match ":
                assertThat(ASSERT_THAT.getMessage(), errorMessage, is(equalTo(registerFormPage.getConfirmPasswordError().getText())));
                break;
        }
    }


}
