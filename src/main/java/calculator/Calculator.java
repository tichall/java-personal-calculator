package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Integer> resultArr;
    int result = 0;

    public Calculator(List<Integer> resultArr) {
        this.resultArr =  resultArr;
    }
    public int calculate(int firstNum, int secondNum, char operator) throws Exception {

        switch (operator) {
            case '+' : this.result = firstNum + secondNum; break;
            case '-' : this.result = firstNum - secondNum; break;
            case '*' : this.result = firstNum * secondNum; break;
            case '/' :
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
    public List<Integer> getResultArr () {
        return this.resultArr;
    }
    public int getResultArrSize() {
        return this.resultArr.size();
    }

    public void setResultArr(int result) {
            this.resultArr.add(result);
    }

    public void removeResult() {
        this.resultArr.remove(0);
    }

    public void inquiryResults() {
        for (Integer i : this.resultArr) {
            System.out.println(i);
        }
        System.out.println("[ 총 결과값 개수 : " + getResultArrSize() + " ]");
    }
}
