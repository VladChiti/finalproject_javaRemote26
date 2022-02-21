package ro.sda.javaremote26.finalproject.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BranchDto {
    private Integer id;
    private String branchName;
    private String branchAddress;
    private Integer rentalId;

}