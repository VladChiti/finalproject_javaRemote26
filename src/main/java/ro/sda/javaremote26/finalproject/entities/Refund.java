package ro.sda.javaremote26.finalproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

import static javax.persistence.GenerationType.AUTO;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Refund {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Integer id;
    @OneToOne
    private Employee employee;
    private LocalDate returnDate;
    @OneToOne
    private Reservation reservation;
    private int surcharge;
    private String comments;
}
