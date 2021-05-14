package com.example.springdocker.service;

import com.example.springdocker.model.Car;
import com.example.springdocker.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CarService {
    private final CarRepository repository;

    public List<Car> getCars() {
        return repository.findAll();
    }

    public Car saveNewCar(Car car) {
       return repository.save(car);
    }

    public List<String> getCarsWithWheels() {

        List<Car> carsWithWheels = repository.findCarByHaveFourWheels(true);

        return carsWithWheels.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
