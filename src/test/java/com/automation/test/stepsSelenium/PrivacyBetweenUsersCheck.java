package com.automation.test.stepsSelenium;

import com.automation.actions.AccessTheWebsiteAction;
import com.automation.pageobjects.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Random;

import static com.automation.utils.ChooseOfWebDriver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrivacyBetweenUsersCheck {
    MainDashboardPage dashboard = new MainDashboardPage(getDriver());
    RegisterFormPage registerFormPage = new RegisterFormPage(getDriver());
    AccessTheWebsiteAction action = new AccessTheWebsiteAction();

    @Given("New User is created")
    public void newUserIsCreated() {
        Random rand = new Random();
        int random = rand.nextInt(1000);
        action.accessTheWebsite();
        registerFormPage.getRegisterButtonFromHeader().click();
        registerFormPage.checkRegisterFormDisplaying(getDriver());
        registerFormPage.enterFullName("Test");
        registerFormPage.enterEmailAddress("email" + random + "@test.com");
        registerFormPage.enterPassword("password");
        registerFormPage.enterConfirmPassword("password");
        registerFormPage.getRegisterButton().click();
    }

    @And("User is logged in")
    public void userIsLoggedIn() {
        registerFormPage.checkLoggedIn(getDriver());
    }

    @Given("No Wishlists are seen at the Main Dashboard")
    public void noWishlistsAreSeenAtTheMainDashboard() {
        assertEquals(0, dashboard.cardsQuantity());
    }

    @When("User Creates one new Wishlist")
    public void userCreatesOneNewWishlist() {
        NewWishlistFormPage wishlist = new NewWishlistFormPage(getDriver());
        dashboard.getNewWishlistButton().click();
        wishlist.inputTitle("Test");
        wishlist.inputType("Wedding");
        wishlist.clickSaveButton();
    }

    @And("Only one Wishlist is seen at the Main Dashboard")
    public void onlyOneWishlistIsSeenAtTheMainDashboard() {
        assertEquals(1, dashboard.cardsQuantity());
    }

    @And("User logs out")
    public void userLogsOut() {
        dashboard.getLogoutButton().click();
    }

    @And("User logs into another account")
    public void userLogsIntoAnotherAccount() {
        Random rand = new Random();
        int random = rand.nextInt(1000);
        action.accessTheWebsite();
        registerFormPage.getRegisterButtonFromHeader().click();
        registerFormPage.checkRegisterFormDisplaying(getDriver());
        registerFormPage.enterFullName("Test");
        registerFormPage.enterEmailAddress("email" + random + "@test.com");
        registerFormPage.enterPassword("password");
        registerFormPage.enterConfirmPassword("password");
        registerFormPage.getRegisterButton().click();
        registerFormPage.checkLoggedIn(getDriver());
    }

    @Then("No Wishlists is seen at the Main Dashboard")
    public void noWishlistsIsSeenAtTheMainDashboard() {
        assertEquals(0, dashboard.cardsQuantity());
    }
}
