package mega.backend_onemore.Day23.Prac23;

import java.util.Scanner;

// 오버로딩 문제
/*
오버로딩 문제
컨트롤 클래스를 만듭니다.
컨트롤 클래스에는 더하기 곱하기 빼기 나누기 연산을 하는 함수를 만들어주세요.
실수와 정수 연산이 될 수 있도록 오버로딩을 사용해서 만들어주세요.
입력도 출력도 컨트롤 클래스에 만들어주세요.
main에서 연산이 되도록 구현해주세요.

1. 정수연산 2. 실수연산 3.종료 (입력)
1. 더하기 2. 빼기 3. 곱하기 4. 나누기 (입력)
숫자 1 입력
숫자 2 입력
결과값

이렇게 출력한 이후에 다시 첫화면으로 이동하고, 잘못된 입력도 만드세요.
 */

class Controll01 {
// 아예 필드 다 빼버리고, 그냥 입력받는 값만 사용함.

  int add(int num1, int num2) {
    return num1+num2;
  }

  int minus(int num1, int num2) {
    return num1-num2;
  }

  int multiply(int num1, int num2) {
    return num1*num2;
  }

  int divide(int num1, int num2) {
    return num1/num2;
  }

  double add(double num3, double num4) {
    return num3+num4;
  }

  double minus(double num3, double num4) {
    return num3-num4;
  }
  double multiply(double num3, double num4) {
    return num3*num4;
  }
  double divide(double num3, double num4) {
    return num3/num4;
  }

}

public class Q2_refector {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    Controll01 ct1 = new Controll01();

    int select;
    while(true) {
      System.out.println("1. 정수연산, 2. 실수연산, 3. 종료 ");
      select = sc.nextInt();
      if (select == 1 || select == 2 || select == 3) {
        break;
      } else {
        System.out.println("잘못된 입력입니다.");
      }
    }

    if (select == 1) {
      System.out.print("첫 번째 숫자 입력 : ");
      int num1 = sc.nextInt();
      System.out.print("두 번째 숫자 입력 : ");
      int num2 = sc.nextInt();

      System.out.println("더하기 결과는 : " + ct1.add(num1,num2));
      System.out.println("빼기 결과는 : " + ct1.minus(num1, num2));
      System.out.println("곱하기 결과는 : " + ct1.multiply(num1, num2));
      System.out.println("나누기 결과는 : " + ct1.divide(num1, num2));

    } else if (select == 2) {
      System.out.print("첫 번째 숫자 입력 : ");
      double num3 = sc.nextDouble();
      System.out.print("두 번째 숫자 입력 : ");
      double num4 = sc.nextDouble();

      System.out.println("더하기 결과는 : " + ct1.add(num3, num4));
      System.out.println("빼기 결과는 : " + ct1.minus(num3, num4));
      System.out.println("곱하기 결과는 : " + ct1.multiply(num3, num4));
      System.out.println("나누기 결과는 : " + ct1.divide(num3, num4));
    }

    else if(select == 3) {
      System.out.println("종료합니다.");
    }

  }

}
