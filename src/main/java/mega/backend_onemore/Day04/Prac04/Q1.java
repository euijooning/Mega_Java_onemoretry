package mega.backend_onemore.Day04.Prac04;

// 숫자 두 개 입력받아 계산기 만들기

import java.util.Scanner;

public class Q1 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.print("첫번째 숫자를 입력하세요 : ");
    int num1 = sc.nextInt();
    System.out.print("두번째 숫자를 입력하세요 : ");
    int num2 = sc.nextInt();
    System.out.print("연산자를 입력하세요 : ");
    String cal = sc.next();
    int result = 0;
    double result2 = 0;

    if(cal.equals("+")) {
      result = num1 + num2;
      System.out.printf("결과는 %d 입니다.", result);
    } else if(cal.equals("-")) {
      result = num1 - num2;
      System.out.printf("결과는 %d 입니다.", result);
    } else if(cal.equals("*")) {
      result = num1 * num2;
      System.out.printf("결과는 %d 입니다.", result);
    } else if(cal.equals("/")) {
      result2 = (double)num1 / num2;
      System.out.printf("결과는 %.1f 입니다.", result2);
    } else {
      System.out.println("잘못된 입력입니다.");
    }
  }

}
