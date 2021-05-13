package com.automation.test.restapi.enums;

public enum AssertionDescription {
    ASSERT_EQUALS("assertEquals failed"),
    ASSERT_WITH_TIME("assertTrue failed. Response time is Not Within Limit");
    private final String message;

    AssertionDescription(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
