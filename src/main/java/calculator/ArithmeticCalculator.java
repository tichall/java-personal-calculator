package calculator;

import java.util.List;

public class ArithmeticCalculator extends Calculator{
    AddOperator add;
    SubtractOperator subtract;
    MultiplyOperator multiply;
    DivideOperator divide;

    public ArithmeticCalculator(List<Double> arithResultArr, AddOperator add, SubtractOperator subtract, MultiplyOperator multiply, DivideOperator divide) {
        // 부모 생성자 호출
        super(arithResultArr);
        this.add = add;
        this.subtract = subtract;
        this.multiply = multiply;
        this.divide = divide;
    }

    @Override
    public double calculate(int number) {
        System.out.println("다른 계산기에서 사용되는 기능입니다.");
        return 0;
    }

    @Override
    public double calculate(int firstNum, int secondNum, char operator) throws Exception {

        switch (operator) {
            case '+' : super.result = add.operate(firstNum, secondNum); break;
            case '-' : super.result = subtract.operate(firstNum, secondNum); break;
            case '*' : super.result = multiply.operate(firstNum, secondNum); break;
            case '/' : super.result = divide.operate(firstNum, secondNum); break;
            default :
                // 잘못된 연산자 예외 처리
                throw new OperationException(operator);
        }
        return super.result;
    }
}
