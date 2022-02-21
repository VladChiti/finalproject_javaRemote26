package ro.sda.javaremote26.finalproject.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.javaremote26.finalproject.dto.EmployeeDto;
import ro.sda.javaremote26.finalproject.entities.Employee;
import ro.sda.javaremote26.finalproject.repositories.BranchRepository;
import ro.sda.javaremote26.finalproject.repositories.EmployeeRepository;

@Service
public class EmployeeMapper implements Mapper<Employee, EmployeeDto> {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    BranchRepository branchRepository;

    public EmployeeDto mapToDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setName(employee.getName());
        employeeDto.setPosition(employee.getPosition());
        if (employee.getBranch() != null) {
            employeeDto.setBranchId(employee.getBranch().getId());
        }
        return employeeDto;
    }

    public Employee mapToEntity(EmployeeDto employeeDto){
        Employee employee = new Employee();
        if (employeeDto.getId() != null){
            employee = employeeRepository.getById(employeeDto.getId());
        }
        employee.setFirstName(employeeDto.getFirstName());
        employee.setName(employeeDto.getName());
        employee.setPosition(employeeDto.getPosition());
        if (employeeDto.getBranchId() != null) {
            employee.setBranch(branchRepository.getById(employeeDto.getBranchId()));
        }
        return employee;
    }
}