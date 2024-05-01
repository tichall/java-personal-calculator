package calculator;
import java.util.*;

public class App {
    public static void main(String[] args) {

        String flagStr; // 실행 여부 메시지
        boolean flag = true; // 실행 여부를 판단하는 변수
        final String intTypeErrMsg = "[피연산자 에러 발생] 숫자(정수)를 입력해주세요.";
        final String numberRangeErrMsg = "양의 정수만 계산 가능합니다!";
        Calculator arithCal = new ArithmeticCalculator(new ArrayList<>(), new AddOperator(), new SubtractOperator(), new MultiplyOperator(), new DivideOperator());
        Calculator circleCal = new CircleCalculator(new ArrayList<>());

        double result;

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
                        int radius;
                        System.out.print("원의 반지름을 입력해주세요! : ");
                        // 반지름 값에 음수 또는 int 타입이 아닌 값이 들어온 경우 예외 처리
                        try {
                            radius = sc.nextInt();
                            if (radius < 0) {
                                throw new NumberException(numberRangeErrMsg);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println(intTypeErrMsg);
                            break;
                        } catch (NumberException e) {
                            System.out.println(e.getMessage());
                            break;
                        }

                        result = circleCal.calculate(radius);
                        circleCal.setResultArr(result); // 결과값 리스트에 추가
                        System.out.println("원의 넓이 : " + result + " (저장 완료!)");

                        System.out.println("==================");
                        circleCal.inquiryResults();

                        break;

                    // 사칙연산 계산기 선택 시
                    case "2" :
                        int firstNum, secondNum;
                        System.out.print("첫 번째 숫자를 입력해주세요! : ");
                        // 숫자에 음수 또는 int 타입이 아닌 값이 들어온 경우 예외 처리
                        try {
                            firstNum = sc.nextInt();
                            if (firstNum < 0) {
                                throw new NumberException(numberRangeErrMsg);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println(intTypeErrMsg);
                            break;
                        } catch (NumberException e) {
                            System.out.println(e.getMessage());
                            break;
                        }

                        System.out.print("두 번째 숫자를 입력해주세요! : ");
                        try {
                            secondNum = sc.nextInt();
                            if (secondNum < 0) {
                                throw new NumberException(numberRangeErrMsg);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println(intTypeErrMsg);
                            break;
                        } catch (NumberException e) {
                            System.out.println(e.getMessage());
                            break;
                        }

                        System.out.print("사칙연산 기호를 입력해주세요! (+, -, *, /): ");

                        char operator = sc.next().charAt(0);
                        try {
                            result = arithCal.calculate(firstNum, secondNum, operator);
                        } catch (Exception e) {
                        // calculate에서 발생하는 예외의 종류가 여러가지이므로 특정 exception명이 아닌 Exception 사용
                            System.out.println(e.getMessage());
                            break;
                        }

                        // 이미 이전에 오류가 발생하면 해당 switch문을 빠져나가기 때문에 결과값 저장 구문은 만날 수 없다. 따라서 이전에 사용했던 errFlag 변수는 삭제했다.
                        arithCal.setResultArr((int) result);
                        System.out.println("결과 : " + (int) result + " (저장 완료!)");

                        System.out.println("==================");

                        // 결과값 리스트에 값이 존재할 때만 삭제, 조회 메시지 표시
                        if (!arithCal.getResultArr().isEmpty()) {
                            System.out.print("첫 번째로 저장된 결과값을 삭제하시겠습니까? (remove 입력 시 삭제) : ");
                            String selectRemove = sc.next();
                            // 삭제 진행
                            if (selectRemove.equals("remove")) {
                                // resultArr 이 private 아닐 때 사용하던 값인데, 이제 어떻게 받아와야 할 지 모르겠음. get(0) 만을 위한 getter를 추가해야 하는 건지..
                                // int removeNum = cal.resultArr.get(0);

                                arithCal.removeResult();
                                System.out.println("삭제 완료!");
                                // System.out.println("결과값 " + removeNum + " 삭제 완료! (남은 결과값 개수 " + cal.getResultArrSize() + "개)");
                            }

                            System.out.println("==================");
                            System.out.print("저장된 결과값을 조회하시겠습니까? (inquiry 입력 시 조회) : ");
                            String selectView = sc.next();
                            // 조회 진행
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
                // 계산 중간에 예외 발생하면 이 구문으로 바로 이동
                System.out.println("==================");

                System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");
                sc.nextLine(); // 에러 발생한 경우 버퍼에 남아있는 값 비워주기
                flagStr = sc.next();
                if (flagStr.equals("exit")) {
                    flag = false;
                }

                System.out.println("==================");
            }
        }
    }
}

