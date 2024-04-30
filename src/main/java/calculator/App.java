package calculator;
import java.util.*;

public class App {
    public static void main(String[] args) {

        String flagStr; // 실행 여부 메시지
        boolean flag = true; // 실행 여부를 판단하는 변수
        boolean errFlag; // 오류 여부 판단하는 변수
        Calculator cal = new Calculator();
        int result = 0;

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

                    char operator = sc.next().charAt(0);
                    try {
                        result = cal.calculate(firstNum, secondNum, operator);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        errFlag = true;
                    }
                }

                // 계산 중 오류가 없는 경우만 결과 출력 및 결과값 저장
                if (!errFlag) {
                    System.out.println("결과 : " + result + " (저장 완료!)");
                    cal.resultArr.add(result);
                }

                System.out.println("==================");

                // 결과값 리스트에 값이 존재할 때만 삭제, 조회 메시지 표시
                if (!cal.resultArr.isEmpty()) {
                    System.out.print("첫 번째로 저장된 결과값을 삭제하시겠습니까? (remove 입력 시 삭제) : ");
                    String selectRemove = sc.next();
                    if (selectRemove.equals("remove")) {
                        int removeNum = cal.resultArr.get(0);
                        cal.resultArr.remove(0);
                        System.out.println("결과값 " + removeNum + " 삭제 완료! (남은 결과값 개수 " + cal.resultArr.size() + "개)");
                    }

                    System.out.println("==================");
                    System.out.print("저장된 결과값을 조회하시겠습니까? (inquiry 입력 시 조회) : ");
                    String selectView = sc.next();
                    if (selectView.equals("inquiry")) {
                        for (int i : cal.resultArr) {
                            System.out.println(i);
                        }
                        System.out.println("[ 총 결과값 개수 : " + cal.resultArr.size() + " ]");
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

