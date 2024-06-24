package hello.was_practice.controller;

import hello.was_practice.calculator.Calculator;
import hello.was_practice.calculator.PositiveNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class CalculateController {

    private Calculator calculator;

    @GetMapping("/calculate/{a}/{operator}/{b}")
    public String getCalculate(@PathVariable("a") PositiveNumber a,
                               @PathVariable("operator") String operator,
                               @PathVariable("b") PositiveNumber b) {
        int result = calculator.calculate(a, operator, b);

        return "결과  = " + result;
    }
}
