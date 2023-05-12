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
// 지금 필드랑 생성자가 아무 필요가 없음.

  int add(int num1, int num2) {
    return num1+num2;
  }
  // 만약에 기존처럼 필드가 있었고
  /*
  int add() {
    return a+b;
  }
  이렇게 만들면, 활용도가 매우 떨어짐.
  항상 같은 결과를 내놓게 될 거니까,
  의도한 바와 달라짐.
  우리는 데이터를 사용자가 가져오게 만들고 싶어.
   */

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

    Scanner sc = new Scanner(System.in); // 스캐너는 딱 한번만 만들어지면 된다.
    Controll01 ct = new Controll01(); // 받아올 인자가 필요없어짐.
    // 왜냐하면, 값 계산할 때 어차피 숫자를 일일이 받으니까.
    // 클래스는 Stateless니까 매번 state를 바꿔줄 필요는 없다.


    int select; //태어나는 것만
    while(true) { //제대로 입력이 됐는지 여부만 반복.
      System.out.println("1. 정수연산, 2. 실수연산, 3. 종료 ");
      select = sc.nextInt(); // 입력은 여기서 받는다.
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

      System.out.println("더하기 결과는 : " + ct.add(num1,num2));
      System.out.println("빼기 결과는 : " + ct.minus(num1, num2));
      System.out.println("곱하기 결과는 : " + ct.multiply(num1, num2));
      System.out.println("나누기 결과는 : " + ct.divide(num1, num2));

    } else if (select == 2) {
      System.out.print("첫 번째 숫자 입력 : ");
      double num3 = sc.nextDouble();
      System.out.print("두 번째 숫자 입력 : ");
      double num4 = sc.nextDouble();

      System.out.println("더하기 결과는 : " + ct.add(num3, num4));
      System.out.println("빼기 결과는 : " + ct.minus(num3, num4));
      System.out.println("곱하기 결과는 : " + ct.multiply(num3, num4));
      System.out.println("나누기 결과는 : " + ct.divide(num3, num4));
    }

    else if(select == 3) {
      System.out.println("종료합니다.");
    }

  }

}
