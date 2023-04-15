package mega.backend_onemore.Day05.Prac05;

import java.util.Scanner;


/*
1. 짝수 문자열 / 홀수 문자열 각각 생성
2. 숫자 입력받기
3. 임의의 수 i 초기화
4. while문 (조건 i<num)
4-1. 짝수이면 j에 더하기
4-2. else 홀수이면 h에 더하기
4-3. 연산 처리 후 i++;
4. 출력 : "짝수 : " + i / "홀수 : " : " + i
 */

public class Q02_T {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String h = "";
    String j = "";
    System.out.print("숫자 입력 : ");
    int num = sc.nextInt();

    int i = 1;
    while (i < num) {
      if (i % 2 == 0) { //짝수
        j = j + i + " ";
      } else {//홀수
        h = h + i + " ";
      }
      i++;
    }

    System.out.println("짝수 : " + j);
    System.out.println("홀수 : " + h);
  }

}
