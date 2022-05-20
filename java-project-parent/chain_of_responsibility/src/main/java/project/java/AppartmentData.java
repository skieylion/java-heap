package project.java;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AppartmentData {
    private double price;
    private double area;
    private short countRoom;
    private short age;

    public AppartmentData(double price, double area, int countRoom, int age) {
    }
}
