package calculator;

import java.util.List;

public abstract class Calculator {
    private List<Double> resultArr;

    double result;

    public Calculator(List<Double> resultArr) {
        this.resultArr =  resultArr;
    }

    // 계산기는 반드시 계산 기능이 필요하므로 calculate 메소드를 추상메소드로 지정하긴 했는데 사칙연산 계산기와 원의 넓이 계산기가 필요로 하는 매개변수가 달라 메소드 오버로딩을 해줬다. 그런데 이렇게 되면 각 계산기에서 필요로 하지 않는 계산 메소드를 오버라이딩해줘야 한다...  만약 또다른 매개변수를 받는 계산기가 추가되었다면..?
    public abstract double calculate (int number);
    public abstract double calculate (int firstNum, int secondNum, char operator) throws Exception;

    public List<Double> getResultArr () {
        return this.resultArr;
    }

    public void setResultArr(double result) {
            this.resultArr.add(result);
    }

    public void removeResult() {
        getResultArr().remove(0);
    }

    public void inquiryResults() {
        System.out.println("[ 총 결과값 개수 : " + getResultArr().size() + " ]");
        for (Double i : this.resultArr) {
            System.out.println(i);
        }
    }
}
