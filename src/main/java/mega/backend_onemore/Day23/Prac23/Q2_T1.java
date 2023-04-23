package mega.backend_onemore.Day23.Prac23;

// 선생님 풀이 2.

import java.util.Scanner;

class Controller01{
  void add(int a, int b) {
    System.out.println("결과 값 : "+(a+b));
  }
  void add(double a, double b) {
    System.out.println("결과 값 : "+(a+b));
  }

  void minus(int a, int b) {
    System.out.println("결과 값 : "+(a-b));
  }

  void minus(double a, double b) {
    System.out.println("결과 값 : "+(a-b));
  }

  void mul(int a, int b) {
    System.out.println("결과 값 : "+(a*b));
  }

  void mul(double a, double b) {
    System.out.println("결과 값 : "+(a*b));
  }

  void div(int a, int b) {
    System.out.println("결과 값 : "+(a/b));
  }

  void div(double a, double b) {
    System.out.println("결과 값 : "+(a/b));
  }

  void resultSelect(int num1, int[] numInt) {
    if(num1 == 1) {
      add(numInt[0], numInt[1]);
    }
    else if(num1 == 2) {
      minus(numInt[0], numInt[1]);
    }
    else if(num1 == 3) {
      mul(numInt[0], numInt[1]);
    }
    else {
      div(numInt[0], numInt[1]);
    }
  }
  void resultSelect(int num1, double[] numDouble) {
    if(num1 == 1) {
      add(numDouble[0], numDouble[1]);
    }
    else if(num1 == 2) {
      minus(numDouble[0], numDouble[1]);
    }
    else if(num1 == 3) {
      mul(numDouble[0], numDouble[1]);
    }
    else {
      div(numDouble[0], numDouble[1]);
    }
  }

}


public class Q2_T1 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    Controller01 c1 = new Controller01();
    int[] numInt = new int[2];
    double[] numDouble = new double[2];

    while(true) {
      System.out.print("1.정수연산 2.실수연산 3.종료 : ");
      int num = sc.nextInt();

      if(num == 1) {
        System.out.print("숫자 1 입력 : ");
        numInt[0] = sc.nextInt();
        System.out.print("숫자 2 입력 : ");
        numInt[1] = sc.nextInt();
      }
      else if(num == 2) {
        System.out.print("숫자 1 입력 : ");
        numDouble[0] = sc.nextFloat();
        System.out.print("숫자 2 입력 : ");
        numDouble[1] = sc.nextFloat();
      }
      else if(num == 3) {
        System.out.println("종료합니다.");
        break;
      }
      else {
        System.out.println("잘못된 입력입니다.");
        continue;
      }

      System.out.print("1. 더하기 2.빼기 3.곱하기 4.나누기 : ");
      int num1 = sc.nextInt();
      if(num1 >0 && num1 <5) {
        if(num ==1) {
          c1.resultSelect(num1, numInt);
        }
        else {
          c1.resultSelect(num1, numDouble);
        }
      }
      else {
        System.out.println("잘못된 입력입니다.");
      }
    }

  }
}

