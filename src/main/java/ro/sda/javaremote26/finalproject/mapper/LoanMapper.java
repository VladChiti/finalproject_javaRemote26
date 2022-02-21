package ro.sda.javaremote26.finalproject.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.javaremote26.finalproject.dto.LoanDto;
import ro.sda.javaremote26.finalproject.entities.Loan;
import ro.sda.javaremote26.finalproject.repositories.EmployeeRepository;
import ro.sda.javaremote26.finalproject.repositories.LoanRepository;
import ro.sda.javaremote26.finalproject.repositories.ReservationRepository;

@Service
public class LoanMapper implements Mapper<Loan, LoanDto> {
    @Autowired
    LoanRepository loanRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ReservationRepository reservationRepository;

    public LoanDto mapToDto(Loan loan){
        LoanDto loanDto = new LoanDto();
        loanDto.setId(loan.getId());
        loanDto.setRentalDate(loan.getRentalDate());
        loanDto.setComments(loan.getComments());
        if (loan.getEmployee() != null) {
            loanDto.setEmployeeId(loan.getEmployee().getId());
        }
        if (loan.getReservation() != null) {
            loanDto.setReservationId(loan.getReservation().getId());
        }
        return loanDto;
    }

    public Loan mapToEntity(LoanDto loanDto){
        Loan loan = new Loan();
        if (loanDto.getId() != null){
            loan = loanRepository.getById(loanDto.getId());
        }
        loan.setRentalDate(loanDto.getRentalDate());
        loan.setComments(loanDto.getComments());
        if (loanDto.getEmployeeId() != null) {
            loan.setEmployee(employeeRepository.getById(loanDto.getEmployeeId()));
        }
        if (loanDto.getReservationId() != null) {
            loan.setReservation(reservationRepository.getById(loanDto.getReservationId()));
        }
        return loan;
    }
}