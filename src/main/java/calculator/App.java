package calculator;
import java.util.*;

public class App {
    public static void main(String[] args) {

        String flagStr; // 실행 여부 메시지
        boolean flag = true; // 실행 여부를 판단하는 변수
        boolean errFlag; // 오류 여부 판단하는 변수

        Calculator arithCal = new Calculator(new ArrayList<>());
        Calculator circleCal = new Calculator(new ArrayList<>(), "circle");

        double result = 0;

        Scanner sc = new Scanner(System.in);

        while (true) {

            if (!flag) {
                System.out.println("프로그램이 종료됩니다.");
                System.exit(0);
            } else {
                System.out.print("계산기를 선택해주세요! [1. 원의 넓이 계산기 (1 입력)] [2. 사칙연산 계산기 (2 입력)] : ");
                String option = sc.next();
                switch (option) {
                    // 원의 넓이 계산기 선택 시
                    case "1" :
                        System.out.print("원의 반지름을 입력해주세요! : ");
                        int radius = sc.nextInt();
                        if (radius < 0) {
                            System.out.println("양의 정수만 계산 가능합니다.");
                        } else {
                            result = circleCal.calculateCircleArea(radius);
                            circleCal.setCircleResultArr(result);
                            System.out.println("원의 넓이 : " + result + " (저장 완료!)");

                            System.out.println("==================");
                            circleCal.inquiryCircleResults();
                        }
                        break;

                    // 사칙연산 계산기 선택 시
                    case "2" :
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
                                result = arithCal.calculate(firstNum, secondNum, operator);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                errFlag = true;
                            }
                        }

                        // 계산 중 오류가 없는 경우만 결과 출력 및 결과값 저장
                        if (!errFlag) {
                            arithCal.setArithResultArr((int) result);
                            System.out.println("결과 : " + (int) result + " (저장 완료!)");
                        }

                        System.out.println("==================");

                        // 결과값 리스트에 값이 존재할 때만 삭제, 조회 메시지 표시
                        if (!arithCal.getArithResultArr().isEmpty()) {
                            System.out.print("첫 번째로 저장된 결과값을 삭제하시겠습니까? (remove 입력 시 삭제) : ");
                            String selectRemove = sc.next();
                            if (selectRemove.equals("remove")) {
                                //int removeNum = cal.resultArr.get(0);

                                arithCal.removeResult();
                                System.out.println("삭제 완료!");
                                //System.out.println("결과값 " + removeNum + " 삭제 완료! (남은 결과값 개수 " + cal.getResultArrSize() + "개)");
                            }

                            System.out.println("==================");
                            System.out.print("저장된 결과값을 조회하시겠습니까? (inquiry 입력 시 조회) : ");
                            String selectView = sc.next();
                            if (selectView.equals("inquiry")) {
                                System.out.println("==================");
                                arithCal.inquiryResults();
                            }

                        } else {
                            System.out.println("저장된 결과값이 없습니다.");
                        }
                        break;
                    // 1,2 이외의 다른 값을 입력한 경우
                    default :
                        System.out.println("잘못된 옵션을 선택하셨습니다. 1 또는 2를 입력해주세요!");
                        break;
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

