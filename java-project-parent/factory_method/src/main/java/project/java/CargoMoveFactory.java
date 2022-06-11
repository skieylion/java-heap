package project.java;

public class CargoMoveFactory extends CargoFactory {

    @Override
    public Cargo createCargo(String body) {
        //..преобразование xml -> object
        return new CargoMove();
    }
}
