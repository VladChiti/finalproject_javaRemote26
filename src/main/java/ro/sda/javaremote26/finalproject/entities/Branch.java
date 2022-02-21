package ro.sda.javaremote26.finalproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Branch {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Integer id;
    private String branchName;
    private String branchAddress; //with city (lista)
    @OneToMany(mappedBy = "branch")
    private List<Employee> facilityEmployees;
    @OneToMany(mappedBy = "branch")
    private List<Car> availableCars;
    @ManyToOne
    private Rental rental;

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                '}';
    }
}
