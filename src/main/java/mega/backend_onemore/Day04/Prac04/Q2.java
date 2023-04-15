package mega.backend_onemore.Day04.Prac04;
// 8의 약수를 출력하는 프로그램 만들기

import java.util.Scanner;

public class Q2 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.print("약수를 구하고 싶은 숫자를 입력하세요. : ");
    int inputNum = sc.nextInt();
    String ment = "";

    for(int i = 1; i <= inputNum; i++ ) {
      if (i != inputNum) { // 마지막 숫자에 ,가 붙지 않게 만들어줌
        if (inputNum % i ==0) { // 약수 구하기
          ment += i; // 표기법을 위해 String 방식으로 합산을 해준다.
          ment += ", ";

        }
      }
    }
    System.out.println(inputNum + "의 약수는 " + ment + inputNum + " 입니다.");
  }

}
