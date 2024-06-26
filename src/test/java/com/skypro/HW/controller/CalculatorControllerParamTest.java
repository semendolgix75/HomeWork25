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

    private static Stream<Arguments> argumentPlusParameterTest() {
        return Stream.of(
                Arguments.of(5, 5, 10),
                Arguments.of(-5, 5, 0),
                Arguments.of(0, 0, 0),
                Arguments.of(-5, -5, -10)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentPlusParameterTest")
    public void checkPlusParameterTest(int num1, int num2, int expected) {
        Integer actual = calculatorService.plus(num1, num2);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"-1,2,1", "5,0,5", "0,10,10"})
    void checkPlusTest(Integer num1, Integer num2, Integer expected) {
        assertEquals(expected, calculatorService.plus(num1, num2));
    }

    private static Stream<Arguments> argumentMinusParameterTest() {
        return Stream.of(
                Arguments.of(5, 5, 0),
                Arguments.of(-5, 15, -20),
                Arguments.of(0, 0, 0),
                Arguments.of(-5, -5, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentMinusParameterTest")
    public void checkMinusParameterTest(Integer num1, Integer num2, Integer expected) {
        Integer actual = calculatorService.minus(num1, num2);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"10,2,8", "5,0,5", "20,10,10"})
    void checkMinusTest(Integer num1, Integer num2, Integer expected) {
        assertEquals(expected, calculatorService.minus(num1, num2));
    }

    private static Stream<Arguments> argumentMultipleParameterTest() {
        return Stream.of(
                Arguments.of(5, 5, 25),
                Arguments.of(-5, 1, -5),
                Arguments.of(0, 0, 0),
                Arguments.of(-5, -5, 25)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentMultipleParameterTest")
    public void checkMultipleParameterTest(Integer num1, Integer num2, Integer expected) {
        Integer actual = calculatorService.multiple(num1, num2);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"5,5,25", "5,3,15", "9,10,90"})
    void checkMultipleTest(Integer num1, Integer num2, Integer expected) {
        assertEquals(expected, calculatorService.multiple(num1, num2));
    }

    private static Stream<Arguments> argumentDivideParameterTest() {
        return Stream.of(
                Arguments.of(5, 5, 1.0),
                Arguments.of(-5, 1, -5.0),
                Arguments.of(0, 0, 0),
                Arguments.of(-5, -5, 1.0)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentDivideParameterTest")
    public void checkDivideParameterTest(Integer num1, Integer num2, double expected) {
        Double actual = calculatorService.divide(num1, num2);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"16,4,4", "20,5,4", "36,6,6"})
    void checkDivideTest(Integer num1, Integer num2, Double expected) {

        assertEquals(expected, calculatorService.divide(num1, num2));
    }

}
