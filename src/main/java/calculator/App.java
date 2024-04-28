package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int[] resultArr = new int[10];
        int count = 0;
        String flagStr; // 실행 여부 받아올 변수
        boolean flag = true; // 실행 여부 및 오류 여부를 판단하는 변수
        boolean errFlag;

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

                System.out.print("사칙연산 기호를 입력해주세요! (+, -, *, /): ");

                /* next()의 반환값은 String 타입이므로 형변환 필요! => charAt(0)으로 형변환
                charAt()의 매개변수는 변환할 문자열의 index 값 */
                char operator = sc.next().charAt(0);

                int result = 0;
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

                if (!errFlag) {
                    System.out.println("결과 : " + result);
                    if (count < 10) {
                        resultArr[count] = result;
                        System.out.println("resultArr[" + count + "] = " + result);
                        count++;
                    }
                }

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
