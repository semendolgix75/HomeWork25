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
    void checkPlusExpression() {
        Integer expected = 20;
        Integer num1 = 15;
        Integer num2 = 5;
        Integer result = calculatorService.plus(num1, num2);
        assertEquals(expected, result);
    }
    @Test
    void checkMinusExpression() {
        Integer expected = 10;
        Integer num1 = 15;
        Integer num2 = 5;
        Integer result = calculatorService.minus(num1, num2);
        assertEquals(expected, result);
    }
    @Test
       void checkMultipleExpression() {
        Integer expected = 30;
        Integer num1 = 6;
        Integer num2 = 5;
        Integer result = calculatorService.multiple(num1, num2);
        assertEquals(expected, result);
    }
    @Test
        void checkDivideExpression() {
        Double expected = 3.;
        Integer num1 = 15;
        Integer num2 = 5;
        Double result = calculatorService.divide(num1, num2);
        assertEquals(expected, result);
    }
    @Test
    void checkDivideByZero() {
        Integer num1 = 15;
        Integer num2 = 0;
        assertThrows(IllegalArgumentException.class, ()->calculatorService.divide(num1, num2));
    }

}