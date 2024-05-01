package calculator;

import java.util.List;

public class ArithmeticCalculator extends Calculator{

    public ArithmeticCalculator(List<Double> arithResultArr) {
        super(arithResultArr);
    }

    @Override
    public double calculate(int number) {
        System.out.println("다른 계산기에서 사용되는 기능입니다.");
        return 0;
    }

    @Override
    public double calculate(int firstNum, int secondNum, char operator) throws Exception {

        switch (operator) {
            case '+' : super.result = firstNum + secondNum; break;
            case '-' : super.result = firstNum - secondNum; break;
            case '*' : super.result = firstNum * secondNum; break;
            case '/' :
                // 분모 0인 경우 예외 처리
                if (secondNum == 0) {
                    throw new NumberException("나눗셈에서 분모로 0을 사용할 수 없습니다.");
                }
                super.result = firstNum / secondNum; break;
            default :
                // 잘못된 연산자 예외 처리
                throw new OperationException(operator);
        }
        return super.result;
    }
}
