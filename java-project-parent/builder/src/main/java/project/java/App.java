package project.java;

import lombok.Data;

public class App {
    public static void main(String[] args) {
        Director director = new Director();
        System.out.println(director.createFord());
        System.out.println(director.createSubaru());
    }
}


enum Color {
    BLUE, YELLOW, GRAY, BLACK
}

@Data
class Car {
    private String name;
    private double weight;
    private Color color;
    private double price;
    private double maxSpeed;
}

abstract class CarBuilder {

    abstract CarBuilder name(String name);

    abstract CarBuilder weight(double w);

    abstract CarBuilder maxSpeed(double s);

    abstract CarBuilder color(Color c);

    abstract CarBuilder price(double p);

    abstract Car build();

    public static CarBuilder builder() {
        return new CarBuilderImpl();
    }
}

class CarBuilderImpl extends CarBuilder {
    Car car = new Car();
    @Override
    public CarBuilder name(String name) {
        car.setName(name);
        return this;
    }
    @Override
    public CarBuilder weight(double w) {
        car.setWeight(w);
        return this;
    }
    @Override
    public CarBuilder maxSpeed(double s) {
        car.setMaxSpeed(s);
        return this;
    }
    @Override
    public CarBuilder color(Color c) {
        car.setColor(c);
        return this;
    }
    @Override
    public CarBuilder price(double p) {
        car.setPrice(p);
        return this;
    }
    @Override
    public Car build() {
        return car;
    }
}

class Director {

    Car createSubaru() {
        return CarBuilder.builder()
                .name("Subaru")
                .color(Color.BLUE)
                .price(4500000)
                .weight(1500)
                .maxSpeed(250)
                .build();
    }

    Car createFord() {
        return CarBuilder.builder()
                .name("Ford")
                .color(Color.BLACK)
                .price(2500000)
                .weight(2000)
                .maxSpeed(150)
                .build();
    }
}