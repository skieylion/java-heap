package project.java;

import lombok.Data;

import java.util.Date;

@Data
public class CargoStore implements Cargo {
    private String code;
    private Date dateCome;

    @Override
    public void writeStatus() {
        System.out.println("CargoStore");
    }
}
