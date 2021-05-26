package com.automation.test.stepsSelenium;

import com.automation.pageobjects.LandingPage;
import com.automation.propertyreader.PropertiesFileReader;
import com.automation.utils.ChooseOfWebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;

import static com.automation.test.restapi.enums.AssertionDescription.ASSERT_THAT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@Log4j2
public class AbilityToRegisterStepsSelenium extends ChooseOfWebDriver {

    private LandingPage landingPage = new LandingPage(getDriver());

    @Given("Wishlist page is accessed")
    public void wishlistPageIsAccessed() {
        getDriver().get(PropertiesFileReader.getProperty("urlUI"));
    }

    @When("Customer click on Register button from header panel")
    public void customerClickOnRegisterButton() {
        landingPage.clickRegister();
    }

    @Then("Register form is displayed to customer")
    public void registerFormIsDisplayed() {
        landingPage.isRegisterFormDisplayed();
    }

    @Given("Customer enters valid{string}, {string}, {string}, {string}")
    public void customerEntersValid(String fullName, String email, String password, String confirmPassword) {
        landingPage.getRegisterFormComponent().enterFullName(fullName);
        landingPage.getRegisterFormComponent().enterEmailAddress(email);
        landingPage.getRegisterFormComponent().enterPassword(password);
        landingPage.getRegisterFormComponent().enterConfirmPassword(confirmPassword);
    }

    @When("Clicking on Register button")
    public void clickingOnRegisterButton() {
        landingPage.getRegisterFormComponent().getRegisterButton().click();
    }

    @Then("Customer should get notification with confirmation email")
    public void customerShouldBeCreatedAndLoggedIn() {
        landingPage.isRegisterFormDisplayed();
    }

    @Given("Customer enters invalid{string}, {string}, {string}, {string}")
    public void customerEntersInvalid(String fullName, String email, String password, String confirmPassword) {
        landingPage.getRegisterFormComponent().enterFullName(fullName);
        landingPage.getRegisterFormComponent().enterEmailAddress(email);
        landingPage.getRegisterFormComponent().enterPassword(password);
        landingPage.getRegisterFormComponent().enterConfirmPassword(confirmPassword);
    }

    @Then("Error should be displayed {string}")
    public void errorShouldBeDisplayed(String errorMessage) {
        landingPage.waitPageOrElement();
        switch (errorMessage) {
            case "There is an existing account with this email":
                assertThat(ASSERT_THAT.getMessage(), errorMessage, is(equalTo(landingPage.getRegisterFormComponent().getEmailExistingError().getText())));
                break;
            case "Please enter a full name":
                assertThat(ASSERT_THAT.getMessage(), errorMessage, is(equalTo(landingPage.getRegisterFormComponent().getFullNameError().getText())));
                break;
            case "Please enter a valid email address":
                assertThat(ASSERT_THAT.getMessage(), errorMessage, is(equalTo(landingPage.getRegisterFormComponent().getEmailError().getText())));
                break;
            case "Please enter a password":
                assertThat(ASSERT_THAT.getMessage(), errorMessage, is(equalTo(landingPage.getRegisterFormComponent().getPasswordEmptyError().getText())));
                break;
            case "The password is too short":
                assertThat(ASSERT_THAT.getMessage(), errorMessage, is(equalTo(landingPage.getRegisterFormComponent().getPasswordToShortError().getText())));
                break;
            case "Passwords do not match":
                assertThat(ASSERT_THAT.getMessage(), errorMessage, is(equalTo(landingPage.getRegisterFormComponent().getConfirmPasswordError().getText())));
                break;
            case "The password contains white spaces":
                assertThat(ASSERT_THAT.getMessage(), errorMessage, is(equalTo(landingPage.getRegisterFormComponent().getPasswordWithSpaceError().getText())));
                break;
        }
    }
}
