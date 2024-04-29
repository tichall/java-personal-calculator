package calculator;

public class NumberException extends Exception{
    public NumberException(String errMsg) {
        super("[피연산자 에러 발생] " + errMsg);
    }
}
