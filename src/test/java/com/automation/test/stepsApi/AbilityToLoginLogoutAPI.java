package com.automation.test.stepsApi;

import com.automation.context.ScenarioContext;
import com.automation.dto.LoginUserDTO;
import com.automation.test.restapi.config.RestApiSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.automation.context.ContextKey.*;
import static com.automation.test.restapi.enums.AssertionDescription.ASSERT_EQUALS;
import static com.automation.test.restapi.enums.AssertionDescription.ASSERT_THAT;
import static com.automation.test.restapi.service.ApiService.getRequestLoggedPath;
import static com.automation.test.restapi.service.ApiService.postRequestLoginPath;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.apache.hc.core5.http.HttpStatus.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@Log4j2
public class AbilityToLoginLogoutAPI extends RestApiSetUp {
    ScenarioContext scenarioContext = ScenarioContext.getInstance();

    private String authToken = "";

    @When("user enters valid {} and {}")
    public void userLogin(String email, String password) {
        LoginUserDTO userDTO = LoginUserDTO
                .builder()
                .username(email)
                .password(password)
                .build();
        scenarioContext.setData(RESPONSE_POST.getMessage(), postRequestLoginPath(userDTO));
        Response response = (Response) scenarioContext.getData("response");
        log.info("Response time is : {}", response.getTimeIn(MILLISECONDS));

        authToken = response.path("jwt").toString();
        scenarioContext.setData(AUTH_TOKEN.getMessage(), authToken);
        log.info("Extracted Token is  : {}", authToken);
    }

    @Then("user should be logged in his account with {} displayed")
    public void userShouldBeLoggedInHisAccountWithWishlistsDisplayed(String wishlist) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + scenarioContext.getData(AUTH_TOKEN.getMessage()));
        scenarioContext.setData(GET_REQUEST.getMessage(), getRequestLoggedPath(headers));

        scenarioContext.setData(WISHLIST_ID.getMessage(), wishlist);

        Response getResponse = (Response) scenarioContext.getData("get");
        Response postResponse = (Response) scenarioContext.getData("response");
        log.info("Response time is : {}", getResponse.getTimeIn(MILLISECONDS));
        assertAll(
                () -> assertThat(getResponse.jsonPath().get("id").toString(), is(equalTo(scenarioContext.getData(WISHLIST_ID.getMessage())))),
                () -> assertEquals(getResponse.getStatusCode(), SC_OK, ASSERT_EQUALS.getMessage())
        );
    }

    @When("user enters a wrong email or password {string},{string}")
    public void userEntersAWrongEmailOrPasswordEmailPassword(String email, String password) {
        LoginUserDTO userDTO = LoginUserDTO
                .builder()
                .username(email)
                .password(password)
                .build();
        scenarioContext.setData(RESPONSE_POST.getMessage(), postRequestLoginPath(userDTO));
        Response response = (Response) scenarioContext.getData("response");
        log.info("Response time is : {}", response.getTimeIn(MILLISECONDS));
    }

    @Then("user is rejected by the server due to wrong credentials")
    public void userIsRejectedByTheSystem() {
        Response getResponse = (Response) scenarioContext.getData("get");
        Response postResponse = (Response) scenarioContext.getData("response");
        log.info("Response time is : {}", getResponse.getTimeIn(MILLISECONDS));

        assertEquals(postResponse.getStatusCode(), SC_UNAUTHORIZED, ASSERT_EQUALS.getMessage());
    }

    @Then("user gets error message displayed due to invalid data")
    public void userGetsErrorMessageDisplayedDueToUnexistingInvalidData() {
        Response getResponse = (Response) scenarioContext.getData("get");
        Response postResponse = (Response) scenarioContext.getData("response");
        log.info("Response time is : {}", getResponse.getTimeIn(MILLISECONDS));

        assertEquals(postResponse.getStatusCode(), SC_BAD_REQUEST, ASSERT_EQUALS.getMessage());
    }
}
