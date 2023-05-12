package mega.backend_onemore.Day23.Prac23;
// 오버로딩 문제

import java.util.Scanner;

class Controll {
  int a;
  int b;
  double c;
  double d;

  Controll(int num1, int num2) {
    this.a = num1;
    this.b = num2;

  }

  Controll(double num3, double num4) {
    this.c = num3;
    this.d = num4;
  }

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


public class Q2_my {

  public static void main(String[] args) {

    while(true) {
      Scanner sc = new Scanner(System.in);
      System.out.println("1. 정수연산, 2. 실수연산, 3. 종료 ");
      int select = sc.nextInt();

      if(select == 1) {
        System.out.print("첫 번째 숫자 입력 : ");
        int num1 = sc.nextInt();
        System.out.print("두 번째 숫자 입력 : ");
        int num2 = sc.nextInt();

        Controll ct1 = new Controll(num1, num2);
        System.out.println("더하기 결과는 : " + ct1.add(num1, num2)) ;
        System.out.println("빼기 결과는 : " + ct1.minus(num1, num2));
        System.out.println("곱하기 결과는 : "+ ct1.multiply(num1, num2));
        System.out.println("나누기 결과는 : " + ct1.divide(num1, num2));
        break;
      }
      else if(select == 2) {
        System.out.print("첫 번째 숫자 입력 : ");
        double num3 = sc.nextDouble();
        System.out.print("두 번째 숫자 입력 : ");
        double num4 = sc.nextDouble();

        Controll ct2 = new Controll(num3, num4);
        System.out.println("더하기 결과는 : " + ct2.add(num3, num4)) ;
        System.out.println("빼기 결과는 : " + ct2.minus(num3, num4));
        System.out.println("곱하기 결과는 : "+ ct2.multiply(num3, num4));
        System.out.println("나누기 결과는 : " + ct2.divide(num3, num4));
        break;
      }
      else if(select == 3) {
        System.out.println("종료합니다.");
        break;
      }
      else {
        System.out.println("잘못된 입력입니다.");

      }
    }

  }
}
