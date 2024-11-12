package com.example.jenkin1111;

import org.springframework.stereotype.Service;

@Service
public class Calculator {

    public int sum(int a, int b){
       int result = a * b;
       return result;
    }
}
