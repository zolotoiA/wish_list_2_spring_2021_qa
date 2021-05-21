package com.automation.test.stepsSelenium;

import com.automation.context.ScenarioContext;
import com.automation.pageobjects.RegisterFormPage;
import com.automation.propertyreader.PropertiesFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.automation.utils.ChooseOfWebDriver.getDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RegFormDisplaySteps {
    RegisterFormPage registerFormPage = new RegisterFormPage(getDriver());
    ScenarioContext context = ScenarioContext.getInstance();

    @Given("Wishlist homepage is accessed")
    public void wishlistHomepageIsDisplayed() {
        getDriver().get(PropertiesFileReader.getProperty("urlUI"));
    }

    @When("user clicks on {} button")
    public void userClicksOnButton(String button) throws InterruptedException {
        switch (button.toLowerCase()) {
            case "register":
                registerFormPage.getRegisterButtonFromHeader().click();
                break;
            default:
                throw new RuntimeException("There's no such button.");
        }
    }

    @Then("the registration pop-up is displayed")
    public void theRegistrationPopUpIsDisplayed() {
        Assert.assertTrue(registerFormPage.getRegisterUserPopUp().isDisplayed());
    }

    @Given("registration form is displayed")
    public void registrationFormIsDisplayed() {
        getDriver().get(PropertiesFileReader.getProperty("urlUI"));
        registerFormPage.getRegisterButtonFromHeader().click();
    }

    @When("user access the registration form")
    public void userAccessTheRegistrationForm() {
        registerFormPage.getRegisterUserPopUp().isSelected();
    }

    @Then("the {} element is present")
    public void theFullNameFieldIsPresent(String field) {
        switch (field.toLowerCase()) {
            case "full name":
                Assert.assertTrue(registerFormPage.getFullName().isDisplayed());
                break;
            case "email address":
                Assert.assertTrue(registerFormPage.getEmailAddress().isDisplayed());
                break;
            case "password":
                Assert.assertTrue(registerFormPage.getPassword().isDisplayed());
                break;
            case "confirm password":
                Assert.assertTrue(registerFormPage.getConfirmPassword().isDisplayed());
                break;
            case "register button":
                Assert.assertTrue(registerFormPage.getRegisterButton().isDisplayed());
                break;
            default:
                throw new RuntimeException("There's no such field.");
        }
    }

    @When("user access a {}")
    public void userAccessAField(String field) {
        String label;
        switch (field.toLowerCase()) {
            case "full name":
                registerFormPage.getFullName().click();
                label = registerFormPage.getFullNameLbl().getText();
                label = label.replaceAll("[^A-Za-z *]", ""); //to delete unwanted and unrecognizable symbols
                break;
            case "email address":
                registerFormPage.getEmailAddress().click();
                label = registerFormPage.getEmailLbl().getText();
                label = label.replaceAll("[^A-Za-z *]", "");
                break;
            case "password":
                registerFormPage.getPassword().click();
                label = registerFormPage.getPasswordLbl().getText();
                label = label.replaceAll("[^A-Za-z *]", "");
                break;
            case "confirm password":
                registerFormPage.getConfirmPassword().click();
                label = registerFormPage.getConfirmPasswordLbl().getText();
                label = label.replaceAll("[^A-Za-z *]", "");
                break;
            default:
                throw new RuntimeException("There's no such field.");
        }
        context.setData("label", label);
    }

    @Then("the field {} with an asterisk is displayed")
    public void theFieldLabelIsDisplayed(String expectedResult) {
        String actualResult = (String) context.getData("label");
        assertThat("The results do not match.", actualResult, is(expectedResult));
        Assert.assertTrue(actualResult.contains("*"));
    }
}