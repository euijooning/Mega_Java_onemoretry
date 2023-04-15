package mega.backend_onemore.Day05.Prac05;

// 문제 8 : 짝수, 홀수 구분하여 출력하는 프로그램 만들기

import java.util.Scanner;

public class Q02 {

  // 내 답안
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("숫자를 입력하세요. : ");
    int inputNum = sc.nextInt();

    String num1 = " ";
    String num2 = " ";

    for(int i = 1; i<inputNum; i++) {
      if (i % 2 == 0) { //짝수일때 if 를 진행한다.
        num2 += i; // num2(짝수)에 i를 계속 넣어준다.
        continue; // 즉, 짝수일 때 다시 for 반복문으로 돌아간다..
      }
      num1 += i; // 홀수일 때 진행
    }
    System.out.println(num1);
    System.out.println(num2);
  }

}
