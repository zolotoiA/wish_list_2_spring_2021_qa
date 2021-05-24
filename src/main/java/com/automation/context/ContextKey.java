package com.automation.context;

public enum ContextKey {
    AUTH_TOKEN("authToken"),
    RESPONSE_POST("response"),
    GET_REQUEST("get"),
    FULLNAME("fullName"),
    WISHLIST_ID("id");
    private final String message;

    ContextKey(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
