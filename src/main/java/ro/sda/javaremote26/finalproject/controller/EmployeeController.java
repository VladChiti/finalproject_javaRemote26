package ro.sda.javaremote26.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.sda.javaremote26.finalproject.dto.EmployeeDto;
import ro.sda.javaremote26.finalproject.entities.Employee;
import ro.sda.javaremote26.finalproject.enums.Position;
import ro.sda.javaremote26.finalproject.mapper.EmployeeMapper;
import ro.sda.javaremote26.finalproject.repositories.BranchRepository;
import ro.sda.javaremote26.finalproject.repositories.EmployeeRepository;

import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    BranchRepository branchRepository;
    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/")
    public String showAllEmployees(Model model) {
        model.addAttribute("employeeList", employeeRepository.findAll());
        return "employeeList";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        EmployeeDto employeeDto = new EmployeeDto();
        model.addAttribute("employeeDto", employeeDto);
        model.addAttribute("branch", branchRepository.findAll());
        model.addAttribute("positionValues", Position.values());
        return "addEmployee";
    }

    @PostMapping("/add")
    public String addEmployee(EmployeeDto employeeDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addEmployee";
        }
        Employee employee = employeeMapper.mapToEntity(employeeDto);
        employeeRepository.save(employee);
        return "redirect:/employee/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Optional<Employee> result = employeeRepository.findById(id);
        if (result.isEmpty()){
            throw new RuntimeException("Employee not found");
        } else {
            EmployeeDto employeeDto = employeeMapper.mapToDto(result.get());
            model.addAttribute("employeeDto", employeeDto);
        }
        model.addAttribute("branch", branchRepository.findAll());
        model.addAttribute("positionValues", Position.values());
        return "editEmployee";
    }

    @PostMapping("/edit/{id}")
    public String editEmployee(@PathVariable("id") int id, EmployeeDto employeeDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            employeeDto.setId(id);
            return "editEmployee";
        }
        Employee employee = employeeMapper.mapToEntity(employeeDto);
        employeeRepository.save(employee);
        return "redirect:/employee/";
    }
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        employeeRepository.deleteById(id);
        return "redirect:/employee/";
    }
}

