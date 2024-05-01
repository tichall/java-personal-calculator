package calculator;

public interface Operator {
    int operate(int firstNum, int secondNum) throws NumberException;
}
