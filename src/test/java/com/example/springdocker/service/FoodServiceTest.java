package com.example.springdocker.service;

import com.example.springdocker.model.Food;
import com.example.springdocker.repository.FoodRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Created by Emil Johansson
 * Date: 2021-05-14
 * Time: 13:56
 * Project: springdocker
 * Package: com.example.springdocker.service
 */

@ExtendWith(MockitoExtension.class)
class FoodServiceTest {

    @Mock
    FoodRepository repo;

    @InjectMocks
    FoodService service;

    @Test
    void getFoods() {
        Food expectedFood1 = new Food();
        Food expectedFood2 = new Food();

        expectedFood1.setName("Tomato");
        expectedFood2.setName("Potato");

        List<Food> expectedList = Arrays.asList(expectedFood1,expectedFood2);

        when(repo.findAll()).thenReturn(expectedList);

        List<Food> actualList = service.getFoods();

        assertEquals(2, actualList.size());
        assertEquals(expectedList, actualList);

        verify(repo, times(1)).findAll();
    }

    @Test
    void saveNewFood() {
        Food expectedFood = new Food();

        expectedFood.setName("Tomato");

        when(repo.save(expectedFood)).thenReturn(expectedFood);

        Food tempFood = new Food();
        tempFood.setName("Tomato");

        Food actualFood = service.saveNewFood(tempFood);

        assertEquals(expectedFood, actualFood);
        assertEquals(expectedFood.getName(), actualFood.getName());

        verify(repo, times(1)).save(expectedFood);
    }

    @Test
    void getCookAbleFoods_true() {
        Food expectedFood1 = new Food();
        Food expectedFood2 = new Food();

        expectedFood1.setName("Tomato");
        expectedFood2.setName("Potato");

        when(repo.findFoodByCanICookIt(true)).thenReturn(Arrays.asList(expectedFood1,expectedFood2));

        List<String> actualFood = service.getCookAbleFoods();

        assertEquals(2, actualFood.size());
        assertEquals("Tomato", actualFood.get(0));
        assertEquals("Potato", actualFood.get(1));

        verify(repo, times(1)).findFoodByCanICookIt(true);
    }


}