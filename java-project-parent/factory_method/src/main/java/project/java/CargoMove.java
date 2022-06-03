package project.java;

import lombok.Data;

import java.util.Date;

@Data
public class CargoMove implements Cargo {
    private String code;
    private Date dateExit;
    private Date datePlanCome;

    @Override
    public void writeStatus() {
        System.out.println("CargoMove");
    }
}
