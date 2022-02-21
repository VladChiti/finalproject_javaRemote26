package ro.sda.javaremote26.finalproject.builder;

import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import ro.sda.javaremote26.finalproject.repositories.BranchRepository;

@Builder
public class BranchBuilder {
    @Autowired
    private BranchRepository branchRepository;

}
