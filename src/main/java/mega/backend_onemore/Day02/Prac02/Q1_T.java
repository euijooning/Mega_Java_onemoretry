package mega.backend_onemore.Day02.Prac02;
/*
1. 숫자를 두 개 입력받고
2. 입력 받은 숫자를 더하기, 빼기, 곱하기, 나누기, 나머지 연산자로 연산한 결과값을 출력하세요.
 */

import java.util.Scanner;

public class Q1_T {

  public static void main(String[] args) {
    //1. 입력
    Scanner sc = new Scanner(System.in);
    System.out.print("숫자 1: ");
    int a = sc.nextInt();
    System.out.print("숫자 2: ");
    int b = sc.nextInt();

    //2. 연산+출력
    System.out.printf("더하기 결과 : %d\n",a+b);
    System.out.println("빼기 결과 : " + (a-b));
    System.out.println("곱하기 결과 : " + (a*b));
    System.out.println("나누기 결과 : " + (a/b));
    System.out.println("나머지 결과 : " + (a%b));
  }

}
