package ro.sda.javaremote26.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.sda.javaremote26.finalproject.dto.CarDto;
import ro.sda.javaremote26.finalproject.entities.Car;
import ro.sda.javaremote26.finalproject.enums.Status;
import ro.sda.javaremote26.finalproject.mapper.CarMapper;
import ro.sda.javaremote26.finalproject.repositories.BranchRepository;
import ro.sda.javaremote26.finalproject.repositories.CarRepository;

import java.util.Optional;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarRepository carRepository;
    @Autowired
    BranchRepository branchRepository;
    @Autowired
    CarMapper carMapper;

    @GetMapping("/")
    public String showAllCars(Model model) {
        model.addAttribute("carList", carRepository.findAll());
        return "carList";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        CarDto carDto = new CarDto();
        model.addAttribute("carDto", carDto);
        model.addAttribute("availableBranches", branchRepository.findAll());
        model.addAttribute("statusValues", Status.values());
        return "addCar";
    }

    @PostMapping("/add")
    public String addCar(CarDto carDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addCar";
        }
        Car car = carMapper.mapToEntity(carDto);
        carRepository.save(car);
        return "redirect:/car/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Optional<Car> result = carRepository.findById(id);
        if (result.isEmpty()){
            throw new RuntimeException("Car not found");
        } else {
            CarDto carDto = carMapper.mapToDto(result.get());
            model.addAttribute("carDto", carDto);
        }
        model.addAttribute("availableBranches", branchRepository.findAll());
        model.addAttribute("statusValues", Status.values());
        return "editCar";
    }

    @PostMapping("/edit/{id}")
    public String editCar(@PathVariable("id") int id, CarDto carDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            carDto.setId(id);
            return "editCar";
        }
        Car car = carMapper.mapToEntity(carDto);
        carRepository.save(car);
        return "redirect:/car/";
    }
    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") int id){
        carRepository.deleteById(id);
        return "redirect:/car/";
    }
}


