package com.automation.context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private static final ScenarioContext instance = new ScenarioContext();
    private final Map<ContextKey, Object> context;

    private ScenarioContext() {
        this.context = new HashMap<>();
    }

    public static ScenarioContext getInstance() {
        return instance;
    }
    public void setData(ContextKey key, Object value) {
        context.put(key, value);
    }

    public Object getData(ContextKey key) {
        return context.get(key);
    }
}
