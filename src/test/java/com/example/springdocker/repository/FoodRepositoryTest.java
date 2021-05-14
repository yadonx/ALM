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

        Food f1 = new Food();
        f1.setName("Tomato");
        f1.setCanICookIt(true);
        Food f2 = new Food();
        f2.setName("Potato");
        f2.setCanICookIt(true);
        Food f3 = new Food();
        f3.setName("stuff");
        f3.setCanICookIt(false);

        repo.save(f1);
        repo.save(f2);
        repo.save(f3);
    }

    @DisplayName("Find cook able food")
    @Test
    void findFoodByCanICookIt_true() {
        List<Food> test = repo.findFoodByCanICookIt(true);

        assertEquals(2,test.size());
        assertEquals("Tomato", test.get(0).getName());
    }

    @DisplayName("Find no cook able food")
    @Test
    void findFoodByCanICookIt_false() {
        List<Food> test = repo.findFoodByCanICookIt(false);

        assertEquals(1,test.size());
        assertEquals("stuff", test.get(0).getName());
    }


}