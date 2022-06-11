package project.java;

import java.util.HashMap;
import java.util.Map;

public class ToolkitFactoryFactory {
    private static final Map<String, ToolkitFactory> factoryMap = new HashMap<>();

    static {
        factoryMap.put("MetalFactory", new MetalToolkitFactory());
        factoryMap.put("WoodFactory", new WoodToolkitFactory());
    }

    public static ToolkitFactory createFactory(String type) {
        return factoryMap.get(type);
    }
}
