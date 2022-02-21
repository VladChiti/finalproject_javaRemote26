package ro.sda.javaremote26.finalproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.javaremote26.finalproject.entities.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
}
