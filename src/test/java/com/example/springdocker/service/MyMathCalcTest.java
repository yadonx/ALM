package com.example.springdocker.service;

import com.example.springdocker.service.exception.DivideByZero;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Emil Johansson
 * Date: 2021-05-14
 * Time: 11:47
 * Project: springdocker
 * Package: com.example.springdocker.service
 */
class MyMathCalcTest {

    MyMathCalc mathCalc;

    @BeforeEach
    void init(){
        mathCalc = new MyMathCalc();
    }

    @DisplayName("Add five to two")
    @Test
    void add() {
        assertEquals(7, mathCalc.add(5,2));

    }

    @DisplayName("Multiply five by two")
    @Test
    void multiply() {
        assertEquals(10, mathCalc.multiply(5,2));
    }

    @DisplayName("Divide five by two")
    @Test
    void divide(){
        assertEquals(2.5, mathCalc.divide(5,2));
    }

    @DisplayName("Divide by zero")
    @Test
    void divide_zero() {
        assertThrows(DivideByZero.class, () -> mathCalc.divide(5,0));
    }
}