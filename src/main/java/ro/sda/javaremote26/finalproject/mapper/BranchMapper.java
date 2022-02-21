package ro.sda.javaremote26.finalproject.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.javaremote26.finalproject.dto.BranchDto;
import ro.sda.javaremote26.finalproject.entities.Branch;
import ro.sda.javaremote26.finalproject.repositories.BranchRepository;
import ro.sda.javaremote26.finalproject.repositories.RentalRepository;

@Service
public class BranchMapper implements Mapper<Branch, BranchDto> {
    @Autowired
    RentalRepository rentalRepository;
    @Autowired
    BranchRepository branchRepository;

    public BranchDto mapToDto(Branch branch){
        BranchDto branchDto = new BranchDto();
        branchDto.setId(branch.getId());
        branchDto.setBranchName(branch.getBranchName());
        branchDto.setBranchAddress(branch.getBranchAddress());
        if (branch.getRental() != null) {
            branchDto.setRentalId(branch.getRental().getId());
        }

        return branchDto;
    }

    public Branch mapToEntity(BranchDto branchDto){
        Branch branch = new Branch();
        if (branchDto.getId() != null){
            branch = branchRepository.getById(branchDto.getId());
        }
        branch.setBranchName(branch.getBranchName());
        branch.setBranchAddress(branch.getBranchAddress());
        if (branchDto.getRentalId() != null) {
            branch.setRental(rentalRepository.getById(branchDto.getRentalId()));
        }
        return branch;
    }
}
