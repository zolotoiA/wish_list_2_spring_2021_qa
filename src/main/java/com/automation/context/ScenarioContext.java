package com.automation.context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private static final ScenarioContext instance = new ScenarioContext();
    private final Map<String, Object> context;

    private ScenarioContext() {
        this.context = new HashMap<>();
    }

    public static ScenarioContext getInstance() {
        return instance;
    }
    public void setData(String key, Object value) {
        context.put(key, value);
    }

    public Object getData(String key) {
        return context.get(key);
    }
}
