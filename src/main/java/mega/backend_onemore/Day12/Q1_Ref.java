package mega.backend_onemore.Day12;

import java.util.Scanner;

public class Q1_Ref {

  static int add(int a, int b) {
    return a + b;
  }

  static int minus(int a, int b) {
    return a - b;
  }

  static int mul(int a, int b) {
    return a * b;
  }

  static int div(int a, int b) {
    return a / b;
  }

  static int[] input(Scanner sc) {
    int[] a = new int[2];
    System.out.print("숫자1 입력 : ");
    a[0] = sc.nextInt();
    System.out.print("숫자2 입력 : ");
    a[1] = sc.nextInt();
    return a;
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    //1. 입력
    System.out.print("연산자 입력 : ");
    String op = sc.next(); //위로 뺀다

    if (op.equals("+")) {
      int[] array = getInts(sc);
      int sum = add(array[0], array[1]);
      System.out.println("결과값 : " + sum + " 입니다.");
    }
    else if (op.equals("-")) {
      int[] array = getInts(sc);
      int substraction = minus(array[0], array[1]);
      System.out.println("결과값 : " + substraction + " 입니다.");
    }
    else if (op.equals("*")) {
//      Scanner sc = new Scanner(System.in); // 이미 메서드에서 만들었으므로 이것도 삭제
      int[] array = getInts(sc);
      int multiple = mul(array[0], array[1]);
      System.out.println("결과값 : " + multiple + " 입니다.");
      /*
      또는
      mul(array[0], array[1]);
      System.out.println("결과값 : " + mul(array[0], array[1]) + " 입니다.");
      이렇게 쓸 수도 있음.
       */

    }
    else if (op.equals("/")) {
      int[] array = getInts(sc);
      int divide = div(array[0], array[1]);
      System.out.println("결과값 : " + divide + " 입니다.");
    } else {
      System.out.println("잘못된 연산자 입니다.");
    }
  }

  private static int[] getInts(Scanner sc) {
    int[] array = input(sc);
    return array;
  }

}
