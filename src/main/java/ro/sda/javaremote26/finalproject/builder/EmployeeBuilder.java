package ro.sda.javaremote26.finalproject.builder;

import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import ro.sda.javaremote26.finalproject.repositories.EmployeeRepository;

@Builder
public class EmployeeBuilder {
    @Autowired
    private EmployeeRepository employeeRepository;
}
