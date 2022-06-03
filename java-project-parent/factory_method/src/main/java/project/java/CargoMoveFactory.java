package project.java;

public class CargoMoveFactory implements CargoFactory {

    @Override
    public Cargo createCargo(String body) {
        //..преобразование xml -> object
        return new CargoMove();
    }
}
