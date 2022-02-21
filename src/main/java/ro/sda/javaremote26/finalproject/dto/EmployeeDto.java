package ro.sda.javaremote26.finalproject.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ro.sda.javaremote26.finalproject.enums.Position;

@NoArgsConstructor
@Data
public class EmployeeDto {
    private Integer id;
    private String firstName;
    private String name;
    private Position position;
    private Integer branchId;
}
