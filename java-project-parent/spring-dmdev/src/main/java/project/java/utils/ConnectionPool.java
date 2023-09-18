package project.java.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConnectionPool {
    private final String username;
    private final Integer poolSize;
    private final List<Object> args;
    private Map<String, Object> properties;
    private final Set<String> params;

    public ConnectionPool(String username, Integer poolSize, List<Object> args, Map<String, Object> properties, Set<String> params) {
        this.username = username;
        this.poolSize = poolSize;
        this.args = args;
        this.properties = properties;
        this.params = params;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }
}
