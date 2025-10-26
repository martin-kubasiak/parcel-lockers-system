package com.app.userservice.domain.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UserPreferences {

    private final Map<String, UserPreferences> preferences = new HashMap<>();

    Map<String, UserPreferences> getPreferences() {
        return Collections.unmodifiableMap(preferences);
    }
}
