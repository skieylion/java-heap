package project.java;


/**
 * Задача:
 * Имеется очередь из которой считываются сообщения.
 * На входе тип сообщения и тело сообщения.
 * Нужно эти сообщения преобразовать в соответствующие
 * объекты из xsd схемы.
 * То есть
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Cargo cargo = CargoFactoryFactory.createFactory("CargoStore").createCargo("<CargoMove>...</CargoMove>");
        cargo.writeStatus();
    }
}
