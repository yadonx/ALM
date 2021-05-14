package com.example.springdocker.controller;

import com.example.springdocker.model.Food;
import com.example.springdocker.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FoodController {
    private final FoodService service;

    @GetMapping("/foods")
    public List<Food> getFoods() {
        return service.getFoods();
    }

    @PostMapping("/foods")
    public Food saveNewFood(@RequestBody Food food) {
        return service.saveNewFood(food);
    }

    @GetMapping("/foods/cookable")
    public List<String> getCookAbleFoods() {
        return service.getCookAbleFoods();
    }
}
