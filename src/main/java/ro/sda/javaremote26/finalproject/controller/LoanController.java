package ro.sda.javaremote26.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.sda.javaremote26.finalproject.dto.LoanDto;
import ro.sda.javaremote26.finalproject.entities.Loan;
import ro.sda.javaremote26.finalproject.mapper.LoanMapper;
import ro.sda.javaremote26.finalproject.repositories.EmployeeRepository;
import ro.sda.javaremote26.finalproject.repositories.LoanRepository;
import ro.sda.javaremote26.finalproject.repositories.ReservationRepository;

import java.util.Optional;

@Controller
@RequestMapping("/loan")
public class LoanController {
    @Autowired
    LoanRepository loanRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    LoanMapper loanMapper;

    @GetMapping("/")
    public String showAllLoans(Model model) {
        model.addAttribute("loanList", loanRepository.findAll());
        return "loanList";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        LoanDto loanDto = new LoanDto();
        model.addAttribute("LoanDto", loanDto);
        model.addAttribute("employee", employeeRepository.findAll());
        model.addAttribute("reservation", reservationRepository.findAll());
        return "addLoan";
    }

    @PostMapping("/add")
    public String addLoan(LoanDto loanDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addLoan";
        }
        Loan loan = loanMapper.mapToEntity(loanDto);
        loanRepository.save(loan);
        return "redirect:/loan/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Optional<Loan> result = loanRepository.findById(id);
        if (result.isEmpty()){
            throw new RuntimeException("Loan not found");
        } else {
            LoanDto loanDto = loanMapper.mapToDto(result.get());
            model.addAttribute("loanDto", loanDto);
        }
        model.addAttribute("employee", employeeRepository.findAll());
        model.addAttribute("reservation", reservationRepository.findAll());
        return "editLoan";
    }

    @PostMapping("/edit/{id}")
    public String editLoan(@PathVariable("id") int id, LoanDto loanDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            loanDto.setId(id);
            return "editLoan";
        }
        Loan loan = loanMapper.mapToEntity(loanDto);
        loanRepository.save(loan);
        return "redirect:/loan/";
    }
    @GetMapping("/delete/{id}")
    public String deleteLoan(@PathVariable("id") int id){
        loanRepository.deleteById(id);
        return "redirect:/loan/";
    }
}
