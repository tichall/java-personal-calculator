package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번쨰 숫자를 입력해주세요! : ");
        int firstNum = sc.nextInt();

        System.out.print("두 번째 숫자를 입력해주세요! : ");
        int secondNum = sc.nextInt();

        System.out.println("firstNum, secondNum = " +firstNum + ","+ secondNum);


    }
}
