package com.skypro.HW.controller;

import com.skypro.HW.service.CalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;
    private  CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;

    }
    @GetMapping
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("plus")
    public ResponseEntity<String> plus(@RequestParam(required = false,name = "num1") Integer num1,@RequestParam(required = false,name = "num2") Integer num2) {


        return ResponseEntity.ok(num1+" + "+num2+"="+calculatorService.plus(num1,num2));

    }
    @GetMapping("minus")
    public String minus(@RequestParam(required = false,name = "num1") Integer num1,@RequestParam(required = false,name = "num2") Integer num2) {

        return num1+" - "+num2+"="+calculatorService.minus(num1,num2);

    }
    @GetMapping("multiple")
    public String multiple(@RequestParam(required = false,name = "num1") Integer num1,@RequestParam(required = false,name = "num2") Integer num2) {

        return num1+" * "+num2+"="+calculatorService.multiple(num1,num2);

    }
    @GetMapping("divide")
    public String divide(@RequestParam(required = false,name = "num1") Integer num1,@RequestParam(required = false,name = "num2") Integer num2) {

        return num1+" / "+num2+"="+calculatorService.divide(num1,num2);

    }
}
