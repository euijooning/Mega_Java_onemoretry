package mega.backend_onemore.Day11.Prac11;

import java.util.Scanner;

// 최소공배수, 최대공약수 찍기 문제
/*
1. 두 가지 숫자 입력 받기
2. 두 수 중 앞의 수가 작을 때 서로 치환
if (num1 < num2) {
      int temp = num1;
      num1 = num2;
      num2 = temp;
    }
3. 원래 입력받은 수 저장해두기 + 나머지 구하는 식

4. 계산 조건 식 쓰기
    // 계산 조건 식
    while (remainder != 0) {
      num1 = num2;
      num2 = remainder;
      remainder = num1 % num2;
    }
5. 최대공약수와 최소공배수 구하기

*/



public class Q1_Homework {
  //gcd: 최대공약수 약자 / lcm: 최소공배수 약자

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("첫 번째 숫자 입력 > ");
    int num1 = sc.nextInt();

    System.out.print("두 번째 숫자 입력 > ");
    int num2 = sc.nextInt();

    // num1이 num2보다 작을 때 두 수를 서로 바꿔준다.(유클리드 호제법의 조건)
    // temp는 값을 담기 위한 임시 변수
    if (num1 < num2) {
      int temp = num1;
      num1 = num2;
      num2 = temp;
    }

    // 원래 처음에 입력받은 수 저장해 둠.
    int originNum1 = num1;
    int originNum2 = num2;

    int remainder = num1 % num2; // 나머지

    // 계산 조건 식
    while (remainder != 0) {
      num1 = num2;
      num2 = remainder;
      remainder = num1 % num2;
    }

    // 최대공약수와 최소공배수 구하기

    int gcd = num2; // 여기서 num2는 계산이 완료된 수(변경된 수)
    int lcm = (originNum1 * originNum2) / gcd;

    // 출력
    System.out.println("최대공약수 : " + gcd);
    System.out.println("최소공배수 : " + lcm);
  }

}
