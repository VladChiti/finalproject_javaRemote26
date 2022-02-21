package ro.sda.javaremote26.finalproject.builder;

import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import ro.sda.javaremote26.finalproject.repositories.CarRepository;

import java.util.List;

@Builder
public class CarBuilder {
    @Autowired
    private CarRepository carRepository;




}
