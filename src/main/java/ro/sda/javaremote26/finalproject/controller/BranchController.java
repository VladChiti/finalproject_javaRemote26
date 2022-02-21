package ro.sda.javaremote26.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.sda.javaremote26.finalproject.dto.BranchDto;
import ro.sda.javaremote26.finalproject.entities.Branch;
import ro.sda.javaremote26.finalproject.mapper.BranchMapper;
import ro.sda.javaremote26.finalproject.repositories.BranchRepository;
import ro.sda.javaremote26.finalproject.repositories.RentalRepository;

@Controller
@RequestMapping("/branch")
public class BranchController {
    @Autowired
    BranchRepository branchRepository;
    @Autowired
    RentalRepository rentalRepository;
    @Autowired
    BranchMapper branchMapper;

    @GetMapping("/")
    public String showAllBranches(Model model) {
        model.addAttribute("branchList", branchRepository.findAll());
        return "branchList";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        BranchDto branchDto = new BranchDto();
        model.addAttribute("branchDto", branchDto);
        model.addAttribute("rental", rentalRepository.findAll());
        return "addBranch";
    }

    @PostMapping("/add")
    public String addBranch(BranchDto branchDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addBranch";
        }
        Branch branch = branchMapper.mapToEntity(branchDto);
        branchRepository.save(branch);
        return "redirect:/branch/";
    }

    @GetMapping("/edit")
    public String showEditForm(Model model) {
        return "editBranch";
    }

    @PostMapping("/edit")
    public String editBranch(Model model) {
        return "addBranch";
    }
}