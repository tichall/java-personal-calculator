package calculator;

public class ModOperator implements Operator{

    @Override
    public int operate(int firstNum, int secondNum) throws NumberException {
        int modResult;
        if (secondNum == 0) {
            throw new NumberException("나눗셈에서 분모로 0을 사용할 수 없습니다.");
        }
        modResult = firstNum % secondNum;
        return modResult;
    }
}
