package ro.sda.javaremote26.finalproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.javaremote26.finalproject.entities.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer> {
}
