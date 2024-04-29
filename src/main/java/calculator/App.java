package calculator;
import java.util.*;

public class App {

    public static void main(String[] args) {
        ArrayList<Integer> resultArr = new ArrayList<Integer>();
        String flagStr; // 실행 여부 메시지
        boolean flag = true; // 실행 여부를 판단하는 변수
        boolean errFlag; // 오류 여부 판단하는 변수
        int result = 0; // 연산 결과값
        Scanner sc = new Scanner(System.in);

        while (true) {
            if (!flag) {
                System.out.println("시스템이 종료됩니다.");
                System.exit(0);
            } else {
                errFlag = false; // errFlag 초기화
                System.out.print("첫 번째 숫자를 입력해주세요! : ");
                int firstNum = sc.nextInt();

                System.out.print("두 번째 숫자를 입력해주세요! : ");
                int secondNum = sc.nextInt();

                // 양의 정수만 입력 가능
                if (firstNum < 0 || secondNum < 0) {
                    System.out.println("양의 정수만 계산 가능합니다!");
                    errFlag = true;
                } else {
                    System.out.print("사칙연산 기호를 입력해주세요! (+, -, *, /): ");

                    /* next()의 반환값은 String 타입이므로 형변환 필요! => charAt(0)으로 형변환
                    charAt()의 매개변수는 변환할 문자열의 index 값 */
                    char operator = sc.next().charAt(0);
                    switch (operator) {
                        case '+' :
                            result = firstNum + secondNum; break;
                        case '-' :
                            result = firstNum - secondNum; break;
                        case '*' :
                            result = firstNum * secondNum; break;
                        case '/' :
                            if (secondNum == 0) {
                                System.out.println("나눗셈에서 분모로 0을 사용할 수 없습니다.");
                                errFlag = true;
                            } else {
                                result = firstNum / secondNum;
                            }
                            break;
                        default:
                            System.out.println("잘못된 연산 기호를 입력하셨습니다. +, -, *, / 중 하나를 입력해주세요!");
                            errFlag = true;
                    }
                }

                // 계산 중 오류가 없는 경우만 결과 출력 및 결과값 저장
                if (!errFlag) {
                    System.out.println("결과 : " + result + " (저장 완료!)");
                    resultArr.add(result);
                }

                System.out.println("==================");

                // 결과값 리스트에 값이 존재할 때만 삭제 메시지 표시
                if (!resultArr.isEmpty()) {
                    System.out.print("첫 번째로 저장된 결과값을 삭제하시겠습니까? (remove 입력 시 삭제) : ");
                    String selectRemove = sc.next();
                    if (selectRemove.equals("remove")) {
                        int removeNum = resultArr.get(0);
                        resultArr.remove(0);
                        System.out.println("결과값 " + removeNum + " 삭제 완료! (남은 결과값 개수 " + resultArr.size() + "개)");
                    }
                } else {
                    System.out.println("저장된 결과값이 없습니다.");
                }

                System.out.println("==================");

                System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");
                flagStr = sc.next();
                if (flagStr.equals("exit")) {
                    flag = false;
                }

                System.out.println("==================");
            }
        }
    }
}

