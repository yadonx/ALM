package com.example.springdocker.repository;

import com.example.springdocker.model.Car;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Emil Johansson
 * Date: 2021-05-14
 * Time: 13:43
 * Project: springdocker
 * Package: com.example.springdocker.repository
 */

@DataMongoTest
class CarRepositoryTest {

    @Autowired
    CarRepository repo;

    @AfterEach
    void tearDown() {
        repo.deleteAll();
    }

    @Test
    void findCarByHaveDoors_true() {
        Car car = new Car();

        car.setName("Volvo");
        car.setHaveDoors(true);

        repo.save(car);

        List<Car> list = repo.findCarByHaveDoors(true);

        assertEquals(1, list.size());
        assertEquals("Volvo", list.get(0).getName());
        assertTrue(list.get(0).isHaveDoors());

    }

    @Test
    void findCarByHaveDoors_false() {
        Car car = new Car();

        car.setName("Volvo");
        car.setHaveDoors(false);

        repo.save(car);

        List<Car> list = repo.findCarByHaveDoors(false);

        assertEquals(1, list.size());
        assertEquals("Volvo", list.get(0).getName());
        assertFalse(list.get(0).isHaveDoors());
    }

    @Test
    void findCarByHaveFourWheels_true() {
        Car car = new Car();

        car.setName("Volvo");
        car.setHaveFourWheels(true);

        repo.save(car);

        List<Car> list = repo.findCarByHaveFourWheels(true);

        assertEquals(1, list.size());
        assertEquals("Volvo", list.get(0).getName());
        assertTrue(list.get(0).isHaveFourWheels());
    }

    @Test
    void findCarByHaveFourWheels_false() {
        Car car = new Car();

        car.setName("Volvo");
        car.setHaveFourWheels(false);

        repo.save(car);

        List<Car> list = repo.findCarByHaveFourWheels(false);

        assertEquals(1, list.size());
        assertEquals("Volvo", list.get(0).getName());
        assertFalse(list.get(0).isHaveFourWheels());
    }
}