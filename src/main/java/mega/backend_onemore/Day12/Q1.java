package mega.backend_onemore.Day12;

import java.util.Scanner;

public class Q1 {

  // 지금 받는 값이 없으니까,
  static int temp1;
  static int temp2;
  // 곱하기에서 값을 받을 수가 없으니 활용할 수 있는 방법은 두 가지
  // 스태틱을 만들어서 쓰거나 아예 입력을 메소드 쪽으로 빼거나 / 여기선 1번 방법을 사용함.

  // 더하기연산  1. 주고받고 (리턴값O, 매개변수O)
  static int add(int a, int b) {
    return a + b;
  }

  // 빼기 연산    3. 안주고 받고 (리턴값x, 매개변수O)
  static void minus(int a, int b) {
    System.out.println("결과값 : "+(a-b)+" 입니다.");
    //num1과 num2의 값이 a와 b로 값만 넘어왔다.
  }

  // 곱하기 연산 2. 주고안받고 (리턴값o, 매개변수x)
  static int mul() {
    return temp1 * temp2;
  }

  // 나누기연산  4.안주고 안받고 (리턴값x, 매개변수x)
  static void div() {
    System.out.printf("결과값 : %.1f 입니다.", (double)temp1/(double)temp2);
  }

  public static void main(String[] args) {


    Scanner sc = new Scanner(System.in);
    //1. 입력
    System.out.print("연산자 입력 : ");
    String op = sc.next();
    // static 변수를 쓰기 싫으면 연산자를 여기로(위로) 올리면 됐다.

    System.out.print("숫자1 입력 : ");
    int num1 = sc.nextInt();
    System.out.print("숫자2 입력 : ");
    int num2 = sc.nextInt();


    if(op.equals("+")) {
      System.out.println("결과값 : "+add(num1,num2)+" 입니다.");
    }
    else if(op.equals("-")) {
      minus(num1, num2);
    }
    else if(op.equals("*")) {
      temp1 = num1;
      temp2 = num2;
      System.out.println("결과값 : "+mul()+" 입니다.");
    }
    else if(op.equals("/")) {
      temp1 = num1;
      temp2 = num2; //먼저 숫자를 넣어줘야 실행 될 것 아니야. 순서 중요.
      div();
    }
    else {
      System.out.println("잘못된 연산자 입니다.");
    }

  }

}