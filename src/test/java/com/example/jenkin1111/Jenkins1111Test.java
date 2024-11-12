package com.example.jenkin1111;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Jenkins1111Test {

    //테스트할 메서드를 가진 클래스를 가져오기
    private Calculator calculator = new Calculator();

    @Test
    public void testService(){
        assertEquals(3, calculator.sum(1, 2));
    }
}
