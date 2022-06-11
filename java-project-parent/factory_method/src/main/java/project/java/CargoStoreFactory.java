package project.java;

public class CargoStoreFactory extends CargoFactory {
    @Override
    public Cargo createCargo(String body) {
        //..преобразование xml -> object
        return new CargoStore();
    }
}
