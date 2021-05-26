package com.automation.context;

public enum ContextKey {
    AUTH_TOKEN("authToken"),
    RESPONSE_POST("response"),
    GET_REQUEST("get"),
    FULLNAME("fullName"),
    WISHLIST_ID("id"),
    LABEL("label");

    private final String message;

    ContextKey(String message) {
        this.message = message;
    }
}
