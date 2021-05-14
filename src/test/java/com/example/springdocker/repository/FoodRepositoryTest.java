package com.example.springdocker.repository;

import com.example.springdocker.model.Food;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Emil Johansson
 * Date: 2021-05-14
 * Time: 12:50
 * Project: springdocker
 * Package: com.example.springdocker.repository
 */

@DataMongoTest
class FoodRepositoryTest {

    @Autowired
    FoodRepository repo;

    @BeforeEach
     void init(){
        repo.deleteAll();
    }

    @DisplayName("Find cook able food")
    @Test
    void findFoodByCanICookIt_true() {
        Food f1 = new Food();
        Food f2 = new Food();

        f1.setName("Tomato");
        f1.setCanICookIt(true);
        f2.setName("Potato");
        f2.setCanICookIt(true);

        repo.save(f1);
        repo.save(f2);

        List<Food> test = repo.findFoodByCanICookIt(true);

        assertEquals(2,test.size());
        assertEquals("Tomato", test.get(0).getName());
        assertTrue(test.get(0).isCanICookIt());
    }

    @DisplayName("Find no cook able food")
    @Test
    void findFoodByCanICookIt_false() {
        Food food = new Food();

        food.setName("stuff");
        food.setCanICookIt(false);

        repo.save(food);

        List<Food> test = repo.findFoodByCanICookIt(false);

        assertEquals(1,test.size());
        assertEquals("stuff", test.get(0).getName());
    }


}