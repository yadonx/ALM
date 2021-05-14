package com.example.springdocker.service;

import com.example.springdocker.service.exception.DivideByZero;

/**
 * Created by Emil Johansson
 * Date: 2021-05-12
 * Time: 13:55
 * Project: springdocker
 * Package: com.example.springdocker.service
 */
public class MyMathCalc {

    public int add(int a, int b){
        return a+b;
    }
  
    public int multiply(int a, int b){
        return a*b;
    }
  
    public double divide(double a, double b){
        if (b == 0)
            throw new DivideByZero("Cannot divide by zero");

        return a/b;
    }
}
