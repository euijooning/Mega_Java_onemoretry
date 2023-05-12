package mega.backend_onemore.Day23.Prac23;

// 선생님 풀이 3. 오전반 ver.

import java.util.Scanner;

class Controller02 {

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



public class Q2_T2 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    Controller02 c2 = new Controller02();
    int[] a = new int[2];
    double[] b = new double[2];


    while(true) {
      System.out.print("1. 정수연산 2. 실수연산 3. 종료 :");
      int num = sc.nextInt();
      if(num == 1 || num == 2) {
        System.out.print("1. 더하기 2.빼기 3. 곱하기 4. 나누기");
        int num1 = sc.nextInt();
        if(num1 == 1) {
          if(num == 1) {
            System.out.print("숫자 1입력 : ");
            a[0] = sc.nextInt();
            System.out.print("숫자 2입력 : ");
            a[1] = sc.nextInt();
            c2.add(a[0], a[1]);
          }
          else {
            System.out.print("숫자 1입력 : ");
            b[0] = sc.nextDouble();
            System.out.print("숫자 2입력 : ");
            b[1] = sc.nextDouble();
            c2.add(b[0], b[1]);
          }


        }
        else if(num1 == 2) {
          if(num == 1) {
            System.out.print("숫자 1입력 : ");
            a[0] = sc.nextInt();
            System.out.print("숫자 2입력 : ");
            a[1] = sc.nextInt();
            c2.minus(a[0], a[1]);
          }
          else {
            System.out.print("숫자 1입력 : ");
            b[0] = sc.nextDouble();
            System.out.print("숫자 2입력 : ");
            b[1] = sc.nextDouble();
            c2.minus(b[0], b[1]);
          }
        }
        else if(num1 == 3) {
          if(num == 1) {
            System.out.print("숫자 1입력 : ");
            a[0] = sc.nextInt();
            System.out.print("숫자 2입력 : ");
            a[1] = sc.nextInt();
            c2.multiply(a[0], a[1]);
          }
          else {
            System.out.print("숫자 1입력 : ");
            b[0] = sc.nextDouble();
            System.out.print("숫자 2입력 : ");
            b[1] = sc.nextDouble();
            c2.multiply(b[0], b[1]);
          }
        }
        else if(num1 == 4) {
          if(num == 1) {
            System.out.print("숫자 1입력 : ");
            a[0] = sc.nextInt();
            System.out.print("숫자 2입력 : ");
            a[1] = sc.nextInt();
            c2.divide(a[0], a[1]);
          }
          else {
            System.out.print("숫자 1입력 : ");
            b[0] = sc.nextDouble();
            System.out.print("숫자 2입력 : ");
            b[1] = sc.nextDouble();
            c2.divide(b[0], b[1]);
          }
        }
        else {
          System.out.println("잘못된 입력입니다.");
        }
      }
      else if(num == 3) {
        System.out.println("프로그램을 종료합니다.");
        break;
      }
      else {
        System.out.println("잘못된 입력입니다.");
      }
    }

  }
}

