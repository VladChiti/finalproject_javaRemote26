package ro.sda.javaremote26.finalproject.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ro.sda.javaremote26.finalproject.enums.Status;
@NoArgsConstructor
@Data
public class CarDto {
    private Integer id;
    private String brand;
    private String model;
    private String bodyType;
    private int manufacturingYear;
    private String color;
    private int mileage;
    private Status status;
    private int amount;
    private Integer branchId;
}