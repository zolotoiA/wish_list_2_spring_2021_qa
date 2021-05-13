package com.automation.utils;

public enum WebDriverEnum {
    CHROME("CHROME"),
    FIREFOX("FIREFOX"),
    IE("IE");

    private final String webDriver;

    WebDriverEnum(String webDriver) {
        this.webDriver = webDriver;
    }

    public String getWebDriver() {
        return webDriver;
    }
}
