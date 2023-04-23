package mega.backend_onemore.Day23.Prac23;

import java.util.Scanner;

// 선생님 원본 풀이

class Controller {
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
  void multiply(int a, int b){
    System.out.println("결과 값 : "+(a*b));
  }
  void multiply(double a, double b){
    System.out.println("결과 값 : "+(a*b));
  }
  void divide(int a, int b) {
    System.out.println("결과 값 : "+(a/b));
  }
  void divide(double a, double b) {
    System.out.println("결과 값 : "+(a/b));
  }
}

public class Q2_T {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    Controller ct = new Controller();
    int[] numInt = new int[2];
    double[] numDouble = new double[2];

    while (true) {
      System.out.print("1.정수연산 2.실수연산 3.종료 : ");
      int type = sc.nextInt();

      if (type == 1) {
        System.out.print("숫자 1 입력 : ");
        numInt[0] = sc.nextInt();
        System.out.print("숫자 2 입력 : ");
        numInt[1] = sc.nextInt();
      } else if (type == 2) {
        System.out.print("숫자 1 입력 : ");
        numDouble[0] = sc.nextFloat();
        System.out.print("숫자 2 입력 : ");
        numDouble[1] = sc.nextFloat();
      } else if (type == 3) {
        System.out.println("종료합니다.");
        break;
      } else {
        System.out.println("잘못된 입력입니다.");
        continue;
      }

      System.out.print("<연산 선택> 1.더하기 2.빼기 3.곱하기 4.나누기 > ");
      int selectOp = sc.nextInt();
      if (selectOp == 1) {
        if (type == 1) {
          ct.add(numInt[0], numInt[1]);
        }
        else {
          ct.add(numDouble[0], numDouble[1]);
        }
      }
      else if (selectOp == 2) {
        if (type == 1) {
          ct.minus(numInt[0], numInt[1]);
        }
        else {
          ct.minus(numDouble[0], numDouble[1]);
        }
      } else if (selectOp ==3) {
        if (type == 1) {
          ct.multiply(numInt[0], numInt[1]);
        }
        else {
          ct.multiply(numDouble[0], numDouble[1]);
        }
      }
      else if (type == 4) {
        if (type == 1) {
          ct.divide(numInt[0], numInt[1]);
        }
        else {
          ct.divide(numDouble[0], numDouble[1]);
        }
      }
      else {
        System.out.println("잘못된 입력입니다.");
      }
    }
  }
}
