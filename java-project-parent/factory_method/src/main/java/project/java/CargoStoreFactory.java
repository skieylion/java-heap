package project.java;

public class CargoStoreFactory implements CargoFactory {
    @Override
    public Cargo createCargo(String body) {
        //..преобразование xml -> object
        return new CargoStore();
    }
}
