package com.automation.test.stepsSelenium;

import com.automation.context.ScenarioContext;
import com.automation.pageobjects.LandingPage;
import com.automation.propertyreader.PropertiesFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.automation.context.ContextKey.LABEL;
import static com.automation.utils.ChooseOfWebDriver.getDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RegFormDisplaySteps {
    private LandingPage landingPage = new LandingPage(getDriver());
    private ScenarioContext context = ScenarioContext.getInstance();

    @Given("Wishlist homepage is accessed")
    public void wishlistHomepageIsDisplayed() {
        getDriver().get(PropertiesFileReader.getProperty("urlUI"));
    }

    @When("user clicks on {} button")
    public void userClicksOnButton(String button) {
        switch (button.toLowerCase()) {
            case "register":
                landingPage.clickRegister();
                break;
            default:
                throw new RuntimeException("There's no such button.");
        }
    }

    @Then("the registration pop-up is displayed")
    public void theRegistrationPopUpIsDisplayed() {
        Assert.assertTrue(landingPage.isRegisterFormDisplayed());
    }

    @Given("registration form is displayed")
    public void registrationFormIsDisplayed() {
        getDriver().get(PropertiesFileReader.getProperty("urlUI"));
        landingPage.clickRegister();
    }

    @When("user access the registration form")
    public void userAccessTheRegistrationForm() {
        landingPage.isRegisterFormDisplayed();
    }

    @Then("the {} element is present")
    public void theFullNameFieldIsPresent(String field) {
        switch (field.toLowerCase()) {
            case "full name":
                Assert.assertTrue(landingPage.getRegisterFormComponent().getFullName().isDisplayed());
                break;
            case "email address":
                Assert.assertTrue(landingPage.getRegisterFormComponent().getEmailAddress().isDisplayed());
                break;
            case "password":
                Assert.assertTrue(landingPage.getRegisterFormComponent().getPassword().isDisplayed());
                break;
            case "confirm password":
                Assert.assertTrue(landingPage.getRegisterFormComponent().getConfirmPassword().isDisplayed());
                break;
            case "register button":
                Assert.assertTrue(landingPage.getRegisterFormComponent().getRegisterButton().isDisplayed());
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
                landingPage.getRegisterFormComponent().getFullName().click();
                label = landingPage.getRegisterFormComponent().getFullNameLbl().getText();
                label = label.replaceAll("[^A-Za-z *]", ""); //to delete unwanted and unrecognizable symbols
                break;
            case "email address":
                landingPage.getRegisterFormComponent().getEmailAddress().click();
                label = landingPage.getRegisterFormComponent().getEmailLbl().getText();
                label = label.replaceAll("[^A-Za-z *]", "");
                break;
            case "password":
                landingPage.getRegisterFormComponent().getPassword().click();
                label = landingPage.getRegisterFormComponent().getPasswordLbl().getText();
                label = label.replaceAll("[^A-Za-z *]", "");
                break;
            case "confirm password":
                landingPage.getRegisterFormComponent().getConfirmPassword().click();
                label = landingPage.getRegisterFormComponent().getConfirmPasswordLbl().getText();
                label = label.replaceAll("[^A-Za-z *]", "");
                break;
            default:
                throw new RuntimeException("There's no such field.");
        }
        context.setData(LABEL, label);
    }

    @Then("the field {} with an asterisk is displayed")
    public void theFieldLabelIsDisplayed(String expectedResult) {
        String actualResult = (String) context.getData(LABEL);
        assertThat("The results do not match.", actualResult, is(expectedResult));
        Assert.assertTrue(actualResult.contains("*"));
    }
}