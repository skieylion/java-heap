package project.java;

import java.util.HashMap;
import java.util.Map;

public class CargoFactoryFactory implements CargoFactory {

    private final CargoFactory cargoFactory;
    private static final Map<String, CargoFactory> factoryMap = new HashMap<>();

    static {
        factoryMap.put("CargoMove", new CargoMoveFactory());
        factoryMap.put("CargoStore", new CargoStoreFactory());
    }

    public CargoFactoryFactory(CargoFactory cargoFactory) {
        this.cargoFactory = cargoFactory;
    }

    public static CargoFactoryFactory createFactory(String type) {
        return new CargoFactoryFactory(factoryMap.get(type));
    }

    @Override
    public Cargo createCargo(String body) {
        return cargoFactory.createCargo(body);
    }
}
