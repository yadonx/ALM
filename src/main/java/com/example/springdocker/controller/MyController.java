package com.example.springdocker.controller;

import com.example.springdocker.model.Food;
import com.example.springdocker.service.MyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MyController {
    private final MyService service;

    @GetMapping("foods")
    public List<Food> getFoods() {
        return service.getFoods();
    }

    @PostMapping("/foods")
    public void saveNewFood(@RequestBody Food food) {
        service.saveNewFood(food);
    }
}
