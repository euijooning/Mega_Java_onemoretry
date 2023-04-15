package mega.backend_onemore.Day04.Prac04;

import java.util.Scanner;
// 숫자 두 개 입력받아 계산기 만들기

public class Q1_T {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    //1. 입력
    System.out.print("숫자1 입력 : ");
    int num1 = sc.nextInt();

    System.out.print("숫자2 입력 : ");
    int num2 = sc.nextInt();

    System.out.print("연산자 입력 : ");
    String op = sc.next();


    if(op.equals("+")) {
      System.out.println("결과값 : " + (num1+num2) + " 입니다.");
    }
    else if(op.equals("-")) {
      System.out.println("결과값 : " + (num1-num2) + " 입니다.");
    }
    else if(op.equals("*")) {
      System.out.println("결과값 : " + (num1*num2) + " 입니다.");
    }
    else if(op.equals("/")) {
      System.out.printf("결과값 : %.1f 입니다.", (double)num1 / num2);
    }
    else {
      System.out.println("잘못된 연산자 입니다.");
    }
  }

}
