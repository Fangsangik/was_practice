package hello.was_practice.calculator.function;

public interface NewArithmeticOperator {

    boolean supports(String operator);
    int calculate(PositiveNumber a, PositiveNumber b);
}
