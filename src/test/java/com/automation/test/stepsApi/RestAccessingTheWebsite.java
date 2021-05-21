package com.automation.test.stepsApi;

import com.automation.actions.AccessTheWebsiteAction;
import com.automation.test.restapi.config.RestApiSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RestAccessingTheWebsite extends RestApiSetUp {
    AccessTheWebsiteAction action = new AccessTheWebsiteAction();

    @Given("{} Request is submitted")
    public void requestIsSubmitted(String request) {
        action.performRequest(request);
    }

    @Then("{} Status code is provided")
    public void statusCodeIsProvided(int code) {
        assertThat(action.requestStatusCode(), is(code));
    }
}
