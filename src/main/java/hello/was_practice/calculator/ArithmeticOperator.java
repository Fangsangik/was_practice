package hello.was_practice.calculator;

import java.util.Arrays;

public enum ArithmeticOperator {
    ADDITION("+"){
        @Override
        public int arithmeticCalculate(int a, int b) {
            return a + b;
        }
    },
    SUBTRACTION("-") {
        @Override
        public int arithmeticCalculate(int a, int b) {
            return a - b;
        }
    },
    MULTIPLICATION("*") {
        @Override
        public int arithmeticCalculate(int a, int b) {
            return a * b;
        }
    },
    DIVISION("/"){
        @Override
        public int arithmeticCalculate(int a, int b) {
            return a /b;
        }
    };

    private String operator;

    ArithmeticOperator(String operator) {
        this.operator = operator;
    }

    public static int calculate(int a, String operator, int b) {
        ArithmeticOperator arithmeticOperator = Arrays.stream(values())
                .filter(x -> x.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
     return arithmeticOperator.arithmeticCalculate(a, b);
    }

    public abstract int arithmeticCalculate(final int a, final int b);
}
