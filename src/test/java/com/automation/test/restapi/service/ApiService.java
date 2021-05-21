package com.automation.test.restapi.service;

import com.automation.dto.RegisterUserDTO;
import com.automation.propertyreader.PropertiesFileReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiService {
    public static final String registerPath = "/api/auth/register";
    public static final String loggedPath = "/api/wishlists";

    public static Response postRequestRegisterPath(RegisterUserDTO userDTO) {
        Response response = given().log().all()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .body(userDTO)
                .post(PropertiesFileReader.getProperty("urlBE") + registerPath);
        return response;
    }

    public static Response getRequestLoggedPath(Map<String, String> headers) {
        Response response = given().log().all()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .headers(headers)
                .get(PropertiesFileReader.getProperty("urlBE") + loggedPath);
        return response;
    }
}
