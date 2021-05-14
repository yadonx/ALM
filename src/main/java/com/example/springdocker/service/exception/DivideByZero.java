package com.example.springdocker.service.exception;

/**
 * Created by Emil Johansson
 * Date: 2021-05-14
 * Time: 12:01
 * Project: springdocker
 * Package: com.example.springdocker.service.exception
 */
public class DivideByZero extends RuntimeException{

    public DivideByZero(String errorMessage) {
        super(errorMessage);
    }
}
