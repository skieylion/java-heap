package project.java;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        CarFilter carSource = new CarSource();
        CarFilter carColorFilter = new CarColorFilter(carSource, "yellow");
        CarFilter carPriceFilter = new CarPriceFilter(carColorFilter, 400000);
        System.out.println(carPriceFilter.apply());

    }
}

@Data
@AllArgsConstructor
class Car {
    private String color;
    private double price;
    private double speed;
}

interface CarFilter {
    List<Car> apply();
}

class CarSource implements CarFilter {

    @Override
    public List<Car> apply() {
        Car car1 = new Car("green", 300000, 200);
        Car car2 = new Car("yellow", 300000, 150);
        Car car3 = new Car("green", 405000, 210);
        Car car4 = new Car("yellow", 401000, 205);
        return new ArrayList<>(Arrays.asList(car1, car2, car3, car4));
    }
}

abstract class CarFilterAbstract implements CarFilter {
    private final CarFilter carFilter;

    public CarFilterAbstract(CarFilter carFilter) {
        this.carFilter = carFilter;
    }

    public List<Car> apply() {
        return carFilter.apply();
    }

}

class CarColorFilter extends CarFilterAbstract {

    private final String colour;

    public CarColorFilter(CarFilter carFilter, String colour) {
        super(carFilter);
        this.colour = colour;
    }

    @Override
    public List<Car> apply() {
        return super.apply().stream().filter(car -> car.getColor().equals(colour)).collect(Collectors.toList());
    }
}

class CarPriceFilter extends CarFilterAbstract {

    private final double price;

    public CarPriceFilter(CarFilter carFilter, double price) {
        super(carFilter);
        this.price = price;
    }

    @Override
    public List<Car> apply() {
        return super.apply().stream().filter(car -> car.getPrice() > price).collect(Collectors.toList());
    }
}


