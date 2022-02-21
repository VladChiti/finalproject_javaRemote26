package ro.sda.javaremote26.finalproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

import static javax.persistence.GenerationType.AUTO;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Integer id;
    private LocalDate bookingDate;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Car car;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    @ManyToOne
    private Branch loanBranch;
    @ManyToOne
    private Branch returnBranchDepartment;
    private int amount;
}
