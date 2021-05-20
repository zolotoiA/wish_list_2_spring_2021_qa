package com.automation.test.stepsApi;

import com.automation.context.ScenarioContext;
import com.automation.dto.RegisterUserDTO;
import com.automation.test.restapi.config.RestApiSetUp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.automation.context.ContextKey.AUTH_TOKEN;
import static com.automation.context.ContextKey.FULLNAME;
import static com.automation.context.ContextKey.GET_REQUEST;
import static com.automation.context.ContextKey.RESPONSE_POST;
import static com.automation.test.restapi.enums.AssertionDescription.ASSERT_EQUALS;
import static com.automation.test.restapi.enums.AssertionDescription.ASSERT_THAT;
import static com.automation.test.restapi.service.ApiService.getRequestLoggedPath;
import static com.automation.test.restapi.service.ApiService.postRequestRegisterPath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class AbilityToRegisterStepsApi extends RestApiSetUp {

    ScenarioContext scenarioContext = ScenarioContext.getInstance();
    public static String invalidToken = "";

    @Before
    public static void setUp() {
        setUpRestAssured();
    }

    @When("Customer enters valid{string}, {string}, {string}, {string} and click register")
    public void registerCustomerTest(String fullName, String email, String pass, String confPass) {
        String authToken = "";
        RegisterUserDTO userDTO = RegisterUserDTO
                .builder()
                .fullName(fullName)
                .username(email)
                .password(pass)
                .confirmPassword(confPass)
                .build();
        scenarioContext.setData(RESPONSE_POST.getMessage(), postRequestRegisterPath(userDTO));
        scenarioContext.setData(FULLNAME.getMessage(), fullName);
        Response response = (Response) scenarioContext.getData("response");
        log.info("Response time is : {}", response.getTimeIn(TimeUnit.MILLISECONDS));

        authToken = response.path("jwt").toString();
        scenarioContext.setData(AUTH_TOKEN.getMessage(), authToken);
        log.info("Extracted Token is  : {}", authToken);

    }

    @Then("Customer should be created and logged in the system")
    public void checkLoggedInRegisteredUser() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + scenarioContext.getData(AUTH_TOKEN.getMessage()));
        scenarioContext.setData(GET_REQUEST.getMessage(), getRequestLoggedPath(headers));

        Response getResponse = (Response) scenarioContext.getData("get");
        Response postResponse = (Response) scenarioContext.getData("response");
        log.info("Response time is : {}", getResponse.getTimeIn(TimeUnit.MILLISECONDS));
        assertAll(
                () -> assertEquals(postResponse.getStatusCode(), HttpStatus.SC_CREATED, ASSERT_EQUALS.getMessage()),
                () -> assertThat(ASSERT_THAT.getMessage(), postResponse.jsonPath().get("fullName"), is(equalTo(scenarioContext.getData(FULLNAME.getMessage())))),
                () -> assertEquals(getResponse.getStatusCode(), HttpStatus.SC_OK, ASSERT_EQUALS.getMessage())
        );
    }

    @When("Customer enters valid credentials {string}, {string}, {string}, {string} and click register")
    public void registerCustomerNegativeTest(String fullName, String email, String pass, String confPass) {
        RegisterUserDTO userDTO = RegisterUserDTO
                .builder()
                .fullName(fullName)
                .username(email)
                .password(pass)
                .confirmPassword(confPass)
                .build();
        scenarioContext.setData(RESPONSE_POST.getMessage(), postRequestRegisterPath(userDTO));
        scenarioContext.setData(FULLNAME.getMessage(), fullName);
        Response postResponse = (Response) scenarioContext.getData("response");
        log.info("Response time is : {}", postResponse.getTimeIn(TimeUnit.MILLISECONDS));
    }

    @Then("Error message is displayed")
    public void checkErrorMessageWithStatusCode() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + invalidToken);
        scenarioContext.setData(GET_REQUEST.getMessage(), getRequestLoggedPath(headers));
        Response getResponse = (Response) scenarioContext.getData("get");
        Response postResponse = (Response) scenarioContext.getData("response");
        log.info("Response time is : {}", getResponse.getTimeIn(TimeUnit.MILLISECONDS));
        assertAll(
                () -> assertEquals(postResponse.getStatusCode(), HttpStatus.SC_CONFLICT, ASSERT_EQUALS.getMessage()),
                () -> assertEquals(getResponse.getStatusCode(), HttpStatus.SC_UNAUTHORIZED, ASSERT_EQUALS.getMessage())
        );
    }

    @When("Customer enter invalid{string}, {string}, {string}, {string} and click register")
    public void customerEnterInvalidAndClickRegister(String fullName, String email, String pass, String confPass) {
        RegisterUserDTO userDTO = RegisterUserDTO
                .builder()
                .fullName(fullName)
                .username(email)
                .password(pass)
                .confirmPassword(confPass)
                .build();
        scenarioContext.setData(RESPONSE_POST.getMessage(), postRequestRegisterPath(userDTO));
    }

    @Then("Customer account is not registered")
    public void errorMessageWithBadRequestIsDisplayed() {
        Response postResponse = (Response) scenarioContext.getData("response");
        log.info("Response time is : {}", postResponse.getTimeIn(TimeUnit.MILLISECONDS));
        assertAll(
                () -> assertEquals(postResponse.getStatusCode(), HttpStatus.SC_BAD_REQUEST, ASSERT_EQUALS.getMessage())
        );
    }

}
