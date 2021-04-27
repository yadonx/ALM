package com.example.springdocker.service;

import com.example.springdocker.model.Food;
import com.example.springdocker.repository.MyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MyService {
    private final MyRepository repository;

    public List<Food> getFoods() {
        return repository.findAll();
    }

    public void saveNewFood(Food food) {
        repository.save(food);
    }
}
