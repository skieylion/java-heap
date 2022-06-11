package project.java;

import java.util.HashMap;
import java.util.Map;

public class CargoFactoryFactory {

    private static final Map<String, CargoFactory> factoryMap = new HashMap<>();

    static {
        factoryMap.put("CargoMove", new CargoMoveFactory());
        factoryMap.put("CargoStore", new CargoStoreFactory());
    }

    public static CargoFactory createFactory(String type) {
        return factoryMap.get(type);
    }
}
