package com.automation.actions;

import com.automation.context.ScenarioContext;
import com.automation.propertyreader.PropertiesFileReader;
import io.restassured.response.Response;

import static com.automation.context.ContextKey.RESPONSE_POST;
import static com.automation.utils.ChooseOfWebDriver.getDriver;
import static io.restassured.RestAssured.given;

public class AccessTheWebsiteAction {
    private final ScenarioContext context = ScenarioContext.getInstance();

    public void accessTheWebsite(){
        getDriver().get(PropertiesFileReader.getProperty("urlUI"));
    }
    public void performRequest(String request) {
        switch (request) {
            case "GET":
                context.setData(RESPONSE_POST.getMessage(), given().get(PropertiesFileReader.getProperty("urlUI")));
            case "POST":
                context.setData(RESPONSE_POST.getMessage(), given().post(PropertiesFileReader.getProperty("urlUI")));
            case "PUT":
                context.setData(RESPONSE_POST.getMessage(), given().put(PropertiesFileReader.getProperty("urlUI")));
            case "DELETE":
                context.setData(RESPONSE_POST.getMessage(), given().delete(PropertiesFileReader.getProperty("urlUI")));
            default:
                System.out.println("Unknown request");
        }
    }

    public int requestStatusCode() {
        Response response = (Response) context.getData(RESPONSE_POST.getMessage());
        return response.getStatusCode();
    }


}
