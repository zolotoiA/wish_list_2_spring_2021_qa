package com.automation.test.restapi.config;

import com.automation.propertyreader.PropertiesFileReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

public class RestApiSetUp {
    public static void setUpRestAssured() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri(PropertiesFileReader.getProperty("urlBE"))
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addFilter(new RequestLoggingFilter(LogDetail.ALL, true, System.out))
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL, true, System.out));
        RestAssured.requestSpecification = requestSpecBuilder.build().log().all();
    }
}
