package ro.sda.javaremote26.finalproject.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.javaremote26.finalproject.dto.CarDto;
import ro.sda.javaremote26.finalproject.entities.Car;
import ro.sda.javaremote26.finalproject.repositories.BranchRepository;
import ro.sda.javaremote26.finalproject.repositories.CarRepository;

@Service
public class CarMapper implements Mapper<Car,CarDto> {
    @Autowired
    CarRepository carRepository;
    @Autowired
    BranchRepository branchRepository;

    public CarDto mapToDto(Car car){
        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setBrand(car.getBrand());
        carDto.setModel(car.getModel());
        carDto.setBodyType(car.getBodyType());
        carDto.setManufacturingYear(car.getManufacturingYear());
        carDto.setColor(car.getColor());
        carDto.setMileage(car.getMileage());
        carDto.setStatus(car.getStatus());
        carDto.setAmount(car.getAmount());
        if (car.getBranch() != null) {
            carDto.setBranchId(car.getBranch().getId());
        }

        return carDto;
    }

    public Car mapToEntity(CarDto carDto){
        Car car = new Car();
        if (carDto.getId() != null){
            car = carRepository.getById(carDto.getId());
        }
        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setBodyType(carDto.getBodyType());
        car.setManufacturingYear(carDto.getManufacturingYear());
        car.setColor(carDto.getColor());
        car.setMileage(carDto.getMileage());
        car.setStatus(carDto.getStatus());
        car.setAmount(carDto.getAmount());
        if (carDto.getBranchId() != null) {
            car.setBranch(branchRepository.getById(carDto.getBranchId()));
        }
        return car;
    }
}
