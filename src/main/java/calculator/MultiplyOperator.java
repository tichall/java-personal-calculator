package calculator;

public class MultiplyOperator implements Operator {
    @Override
    public int operate(int firstNum, int secondNum) {
        int multiplyResult;
        multiplyResult = firstNum * secondNum;
        return multiplyResult;
    }
}
