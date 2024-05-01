package calculator;

public class AddOperator implements Operator {

    @Override
    public int operate(int firstNum, int secondNum) {
        int addResult;
        addResult = firstNum + secondNum;
        return addResult;
    }
}
