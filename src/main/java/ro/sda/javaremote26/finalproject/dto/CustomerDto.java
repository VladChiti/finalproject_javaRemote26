package ro.sda.javaremote26.finalproject.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CustomerDto {
    private Integer id;
    private String firstName;
    private String name;
    private String email;
    private String address;
}
