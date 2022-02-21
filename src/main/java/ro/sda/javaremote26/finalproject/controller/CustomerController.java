package ro.sda.javaremote26.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.sda.javaremote26.finalproject.dto.CustomerDto;
import ro.sda.javaremote26.finalproject.entities.Customer;
import ro.sda.javaremote26.finalproject.mapper.CustomerMapper;
import ro.sda.javaremote26.finalproject.repositories.CustomerRepository;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerMapper customerMapper;

    @GetMapping("/")
    public String showAllCustomers(Model model) {
        model.addAttribute("customerList", customerRepository.findAll());
        return "customerList";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        CustomerDto customerDto = new CustomerDto();
        model.addAttribute("customerDto", customerDto);
        return "addCustomer";
    }

    @PostMapping("/add")
    public String addCustomer(CustomerDto customerDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addCustomer";
        }
        Customer customer = customerMapper.mapToEntity(customerDto);
        customerRepository.save(customer);
        return "redirect:/customer/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Optional<Customer> result = customerRepository.findById(id);
        if (result.isEmpty()){
            throw new RuntimeException("Customer not found");
        } else {
            CustomerDto customerDto = customerMapper.mapToDto(result.get());
            model.addAttribute("customerDto", customerDto);
        }
        return "editCustomer";
    }

    @PostMapping("/edit/{id}")
    public String editCustomer(@PathVariable("id") int id, CustomerDto customerDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            customerDto.setId(id);
            return "editCustomer";
        }
        Customer customer = customerMapper.mapToEntity(customerDto);
        customerRepository.save(customer);
        return "redirect:/customer/";
    }
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") int id){
        customerRepository.deleteById(id);
        return "redirect:/customer/";
    }
}
