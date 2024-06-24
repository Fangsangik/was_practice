package hello.was_practice.calculator;

import java.util.List;

public class Calculator {

    private static final List<NewArithmeticOperator> arithmeticOperators
            = List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());

    public static int calculate(PositiveNumber a, String operator, PositiveNumber b) {
        return arithmeticOperators.stream().filter(arithmeticOperators -> arithmeticOperators.supports(operator))
                .map(arithmeticOperators -> arithmeticOperators.calculate(a , b)) //int로 받기 위해 map
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 사칙 연산 입니다."));
    }
}
