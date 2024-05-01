package calculator;

public class DivideOperator {
    int divideResult;
    public int operate(int firstNum, int secondNum) throws NumberException {
        // 분모 0인 경우 예외 처리
        if (secondNum == 0) {
            throw new NumberException("나눗셈에서 분모로 0을 사용할 수 없습니다.");
        }
        divideResult = firstNum / secondNum;
        return divideResult;
    }
}
