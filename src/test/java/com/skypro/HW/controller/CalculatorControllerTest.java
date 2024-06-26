package com.skypro.HW.controller;

import com.skypro.HW.service.CalculatorService;
import com.skypro.HW.service.impl.CalculatorServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorControllerTest {

    CalculatorService calculatorService = new CalculatorServiceImpl();

    @Test
    void add() {
        Integer expected = 20;
        Integer num1 = 15;
        Integer num2 = 5;
        Integer result = calculatorService.plus(num1, num2);
        assertEquals(expected, result);
    }


}