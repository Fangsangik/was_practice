package hello.was_practice.calculator;

//valueObject
public class PositiveNumber {
    private final int num;

    public PositiveNumber(int num) {
        validation(num);
        this.num = num;
    }

    private void validation(int num) {
        if (isNegativeNumber(num)) {
            throw new IllegalArgumentException("0또는 음수를 전달할 수 없습니다");
        }
    }

    private boolean isNegativeNumber(int num) {
        return num <= 0;
    }

    public int toInt() {
        return num;
    }
}
