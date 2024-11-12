package com.example.jenkin1111;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CalculatorController {
    private final Calculator calculator;


    @RequestMapping("/")
    public String index(@RequestParam("a") int a, @RequestParam("b") int b) {
        return String.valueOf(calculator.sum(a, b));
    }
}
