package mega.backend_onemore.Day02.Prac02;

import java.util.Scanner;

public class Q1 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in); // 스캐너 사용하는 객체를 생성함.
    System.out.print("숫자1 입력 : ");
    int a = sc.nextInt();
    System.out.print("숫자2 입력 : ");
    int b = sc.nextInt();

    System.out.println("더하기 결과 값: " + (a + b));
    System.out.println("빼기 결과 값: " + (a - b));
    System.out.println("곱하기 결과 값: " + (a * b));
    System.out.println("나누기 결과 값: " + (a / b));
    System.out.println("나머지 연산 값: " + (a % b));
  }

}
