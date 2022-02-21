package ro.sda.javaremote26.finalproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.javaremote26.finalproject.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
