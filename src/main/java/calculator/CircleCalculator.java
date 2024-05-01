package calculator;

import java.util.List;

public class CircleCalculator extends Calculator{

    public CircleCalculator(List<Double> circleResultArr) {
        super(circleResultArr);
    }

    @Override
    public double calculate(int radius) {

        super.result = radius * 3.14;
        return super.result;
    }

    @Override
    public double calculate(int firstNum, int secondNum, char operator) {
        System.out.println("다른 계산기에서 사용되는 기능입니다.");
        return 0;
    }

}
