package ro.sda.javaremote26.finalproject.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.javaremote26.finalproject.dto.CustomerDto;
import ro.sda.javaremote26.finalproject.entities.Customer;
import ro.sda.javaremote26.finalproject.repositories.CustomerRepository;

@Service
public class CustomerMapper implements Mapper<Customer, CustomerDto> {
    @Autowired
    CustomerRepository customerRepository;

    public CustomerDto mapToDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setAddress(customer.getAddress());
        return customerDto;
    }

    public Customer mapToEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        if (customerDto.getId() != null) {
            customer = customerRepository.getById(customerDto.getId());
        }
        customer.setFirstName(customerDto.getFirstName());
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setAddress(customerDto.getAddress());
        return customer;
    }
}