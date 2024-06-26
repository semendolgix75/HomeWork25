package com.skypro.HW.controller;

import com.skypro.HW.service.CalculatorService;
import com.skypro.HW.service.impl.CalculatorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorControllerParamTest {
    CalculatorService calculatorService = new CalculatorServiceImpl();
    @ParameterizedTest
    @CsvSource(value = {"-1,2,1", "5,0,5", "0,10,10"})
    void plusInteger(Integer num1, Integer num2, Integer expected) {
        assertEquals(expected, calculatorService.plus(num1, num2));
    }
    @ParameterizedTest
    @CsvSource(value = {"10,2,8", "5,0,5", "20,10,10"})
    void minusInteger(Integer num1, Integer num2, Integer expected) {
        assertEquals(expected, calculatorService.minus(num1, num2));
    }
    @ParameterizedTest
    @CsvSource(value = {"5,5,25", "5,3,15", "9,10,90"})
    void multipleInteger(Integer num1, Integer num2, Integer expected) {
        assertEquals(expected, calculatorService.multiple(num1, num2));
    }
    @ParameterizedTest
    @CsvSource(value = {"16,4,4", "20,5,4", "36,6,6"})
    void divideInteger(Integer num1, Integer num2, Integer expected) {

        assertEquals(expected, calculatorService.divide(num1, num2));
    }
    @ParameterizedTest
    @MethodSource("Arguments")
    public void plus(int num1, int num2) {
        int expected = num1 + num2;

        Integer actual = calculatorService.plus(num1, num2);

        Assertions.assertEquals(expected, actual);
    }

    private static Stream<Arguments> Arguments() {
        return Stream.of(
                Arguments.of(5, 5),
                Arguments.of(-5, 5),
                Arguments.of(0, 0),
                Arguments.of(-5, -5)
        );
    }
}
