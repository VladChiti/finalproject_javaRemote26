package ro.sda.javaremote26.finalproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.sda.javaremote26.finalproject.enums.Status;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import static javax.persistence.GenerationType.AUTO;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Integer id;
    private String brand;
    private String model;
    private String bodyType;
    private int manufacturingYear;
    private String color;
    private int mileage;
    private Status status; //status applies to a specific date; unavailable, i.e. broken, under repair, under inspection, etc.
    private int amount; //per day of rental (double pentru sume de bani, generally)
    @ManyToOne
    private Branch branch;


}
