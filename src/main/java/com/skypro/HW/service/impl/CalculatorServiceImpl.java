package com.skypro.HW.service.impl;

import com.skypro.HW.service.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public Integer plus(Integer num1, Integer num2) {
        return num1+num2;
    }

    @Override
    public Integer minus(Integer num1, Integer num2) {
        return num1-num2;
    }

    @Override
    public Integer multiple(Integer num1, Integer num2) {
        return num1*num2;
    }

    @Override
    public Integer divide(Integer num1, Integer num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Деление на ноль");
        }

        return (Integer) num1/num2;
    }
}
