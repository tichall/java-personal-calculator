package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // 우선 Calculator 객체가 여러 개 생성됨에 따라 각 결과값 리스트는 독립적으로 운용되어야 하므로 static 키워드를 붙이는 건 부적절해보인다. 계속 리스트 내부가 수정되므로 final 키워드도 부적절하다.
    private List<Integer> arithResultArr;
    private List<Double> circleResultArr;

    // result 값은 계속 수정되기 때문에 final은 불가능, result 변수가 객체마다 꼭 하나씩 필요한 건 아닌 것 같아보이면서도 static을 안 붙이는 편이 이해상 더 좋아보이는 느낌이 든다.
    double result;

    public Calculator(List<Integer> arithResultArr) {
        this.arithResultArr =  arithResultArr;
    }

    // 사용하지 않을 type 값을 받아서 생성자를 정의하는 것이 좋지 않아보인다. 하지만 같은 형식의 컬렉션 두 개를 어떻게 구분해서 매개변수로 전달하고 클래스 내부 컬렉션에 할당해줘야 할 지 감이 잘 안 와서 이런 방법을 사용하게 되었다.
    public Calculator(List<Double> circleResultArr, String type) {
        this.circleResultArr =  circleResultArr;
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
        return (int) this.result;
    }

    //
    public List<Integer> getArithResultArr () {
        return this.arithResultArr;
    }

    public void setArithResultArr(int result) {
            this.arithResultArr.add(result);
    }

    public void removeResult() {
        this.arithResultArr.remove(0);
    }

    public void inquiryResults() {
        System.out.println("[ 총 결과값 개수 : " + getArithResultArr().size() + " ]");
        for (Integer i : this.arithResultArr) {
            System.out.println(i);
        }
    }

    // 원의 넓이 계산 후 반납
    public double calculateCircleArea(int radius) {
        this.result = radius * 3.14;
        return this.result;
    }
    public List<Double> getCircleResultArr() {
        return this.circleResultArr;
    }

    public void setCircleResultArr(double result) {
        this.circleResultArr.add(result);
    }
    public void inquiryCircleResults() {
        System.out.println("[ 총 결과값 개수 : " + getCircleResultArr().size() + " ]");
        for (Double i : this.circleResultArr) {
            System.out.println(i);
        }
    }
}
