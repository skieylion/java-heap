package project.java;


/**
 * Задача:
 * Имеется очередь из которой считываются сообщения.
 * На входе тип сообщения и тело сообщения.
 * В зависимости от типа сообщения и тела сообщения
 * нужно создать соответствующий объект и наполнить данными из тела сообщения
 */
public class App {
    public static void main(String[] args) {
        Cargo cargo = CargoFactoryFactory.createFactory("CargoMove").createCargo("<CargoMove>...</CargoMove>");
        cargo.writeStatus();
    }
}
