package project.java;

public class Car {
    private String model;
    private String color;
    private double speed;

    public String getModel(boolean isFull) {
        return isFull ? "FULL MODEL" + model : model;
    }
}
