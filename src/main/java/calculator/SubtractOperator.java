package calculator;

public class SubtractOperator implements Operator{
    @Override
    public int operate(int firstNum, int secondNum) {
        int subtractResult;
        subtractResult = firstNum - secondNum;
        return subtractResult;
    }
}
