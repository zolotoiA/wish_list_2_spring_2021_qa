package com.automation.test.stepsSelenium;

import com.automation.actions.AccessTheWebsiteAction;
import com.automation.components.NewWishlistFormComponent;
import com.automation.components.RegisterFormComponent;
import com.automation.pageobjects.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Random;

import static com.automation.utils.ChooseOfWebDriver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrivacyBetweenUsersCheck {
    private MainDashboardPage dashboard = new MainDashboardPage(getDriver());
    private LandingPage landingPage = new LandingPage(getDriver());
    private AccessTheWebsiteAction action = new AccessTheWebsiteAction();

    @Given("New User is created")
    public void newUserIsCreated() {
        Random rand = new Random();
        int random = rand.nextInt(1000);
        action.accessTheWebsite();
        landingPage.clickRegister();
        landingPage.isRegisterFormDisplayed();
        landingPage.getRegisterFormComponent().enterFullName("Test");
        landingPage.getRegisterFormComponent().enterEmailAddress("email" + random + "@test.com");
        landingPage.getRegisterFormComponent().enterPassword("password");
        landingPage.getRegisterFormComponent().enterConfirmPassword("password");
        landingPage.getRegisterFormComponent().getRegisterButton().click();
    }

    @And("User is logged in")
    public void userIsLoggedIn() {
        //landingPage.getRegisterFormComponent().checkLoggedIn(getDriver());
        landingPage.headerItems.getWelcomeTitle().isDisplayed();
    }

    @Given("No Wishlists are seen at the Main Dashboard")
    public void noWishlistsAreSeenAtTheMainDashboard() {
        assertEquals(0, dashboard.cardsQuantity());
    }

    @When("User Creates one new Wishlist")
    public void userCreatesOneNewWishlist() {
        dashboard.getNewWishlistButton().click();
        dashboard.getNewWishlistFormComponent().inputTitle("Test");
        dashboard.getNewWishlistFormComponent().inputType("Wedding");
        dashboard.getNewWishlistFormComponent().clickSaveButton();
    }

    @And("Only one Wishlist is seen at the Main Dashboard")
    public void onlyOneWishlistIsSeenAtTheMainDashboard() {
        assertEquals(1, dashboard.cardsQuantity());
    }

    @And("User logs out")
    public void userLogsOut() {
        dashboard.headerItems.getLogoutButton().click();
    }

    @And("User logs into another account")
    public void userLogsIntoAnotherAccount() {
        Random rand = new Random();
        int random = rand.nextInt(1000);
        action.accessTheWebsite();
        landingPage.getRegisterFormComponent().getRegisterButtonFromHeader().click();
        landingPage.isRegisterFormDisplayed();
        landingPage.getRegisterFormComponent().enterFullName("Test");
        landingPage.getRegisterFormComponent().enterEmailAddress("email" + random + "@test.com");
        landingPage.getRegisterFormComponent().enterPassword("password");
        landingPage.getRegisterFormComponent().enterConfirmPassword("password");
        landingPage.getRegisterFormComponent().getRegisterButton().click();
        landingPage.waitPageOrElement();
    }

    @Then("No Wishlists is seen at the Main Dashboard")
    public void noWishlistsIsSeenAtTheMainDashboard() {
        assertEquals(0, dashboard.cardsQuantity());
    }
}
