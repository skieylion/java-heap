package project.java;

import java.util.HashMap;
import java.util.Map;

public final class FacadeProperty {
    private final Map<String, Object> properties;

    private FacadeProperty(Map<String, Object> properties) {
        this.properties = properties;
    }

    public static FacadeProperty of(Map<String, Object> properties) {
        return new FacadeProperty(properties);
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    void init() {
        System.out.println("init facade property");
    }

    void destroy() {
        System.out.println("destroy facade property");
    }
}
