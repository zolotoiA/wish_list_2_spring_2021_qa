package com.automation.test.restapi;

import com.automation.propertyreader.PropertiesFileReader;
import com.automation.test.restapi.config.RestApiSetUp;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static com.automation.test.restapi.enums.AssertionDescription.ASSERT_EQUALS;
import static com.automation.test.restapi.enums.AssertionDescription.ASSERT_WITH_TIME;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class RestApiTest extends RestApiSetUp {

    @BeforeAll
    public static void baseSetUp() {
        setUpRestAssured();
    }

    @Test
    public void getRequestMethod() {
        Response response = given()
                .get(PropertiesFileReader.getProperty("url"));
        log.info("Response time is : {}", response.getTimeIn(TimeUnit.MILLISECONDS));
        assertAll(
                () -> assertEquals(response.getStatusCode(), HttpStatus.SC_OK, ASSERT_EQUALS.getMessage()),
                () -> assertThat(ASSERT_WITH_TIME.getMessage(), response.getTimeIn(TimeUnit.MILLISECONDS), lessThan(5000L))
        );
    }
}
