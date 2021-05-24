package com.automation.test.restapi.service;

import com.automation.dto.LoginUserDTO;
import com.automation.dto.RegisterUserDTO;
import com.automation.propertyreader.PropertiesFileReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiService {
    private static final String registerPath = "/api/auth/register";
    private static final String loginPath = "/api/auth/login";
    private static final String loggedPath = "/api/wishlists";

    public static Response postRequestRegisterPath(RegisterUserDTO userDTO) {
        Response response = given().log().all()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .body(userDTO)
                .post(PropertiesFileReader.getProperty("urlBE") + registerPath);
        return response;
    }

    public static Response postRequestLoginPath(LoginUserDTO userDTO) {
        Response response = given().log().all()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .body(userDTO)
                .post(PropertiesFileReader.getProperty("urlBE") + loginPath);
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
