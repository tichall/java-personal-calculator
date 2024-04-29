package calculator;

import java.util.ArrayList;

public class Calculator {
    ArrayList<Integer> resultArr = new ArrayList<>();
    int result = 0;

    public int calculate(int firstNum, int secondNum, String operator) throws Exception {
        if (firstNum < 0 || secondNum < 0) {
            throw new NumberException("음수는 사용할 수 없습니다.");
        }
        switch (operator) {
            case "+" : this.result = firstNum + secondNum; break;
            case "-" : this.result = firstNum - secondNum; break;
            case "*" : this.result = firstNum * secondNum; break;
            case "/" :
                // 분모 0인 경우 예외 처리
                if (secondNum == 0) {
                    throw new NumberException("나눗셈에서 분모로 0을 사용할 수 없습니다.");
                }
                this.result = firstNum / secondNum; break;
            default :
                // 잘못된 연산자 예외 처리
                throw new OperationException(operator);
        }
        return this.result;
    }
}
