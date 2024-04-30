package calculator;

public class OperationException extends Exception{
    public OperationException(char wrongOperator) {
        super("[연산자 에러 발생] "+ wrongOperator + " 올바른 사칙연산 기호를 입력해주세요!");
    }
}
