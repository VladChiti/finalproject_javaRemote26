package ro.sda.javaremote26.finalproject.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class LoanDto {
    private Integer id;
    private Integer employeeId;
    private LocalDateTime rentalDate;
    private Integer reservationId;
    private String comments;
}
