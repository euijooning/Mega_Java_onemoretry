package mega.backend_onemore.Day07.Prac07;

import java.util.Random;
/*
3개 변수에 1~9까지 랜덤 수를 부여합니다.
각각의 변수에 숫자가 다르게 저장될 수 있도록 구현하세요.
 */
public class Q3_Random {
  // 방법 1. 하나 받고, 두개째 받아서 숫자 1, 2끼리 비교 => 세개째 받아서 숫자 1,3 / 숫자2, 3 비교 // 출력
  // 방법 2. 한꺼번에 초기화 => 최소 두 수가 같은 동안, 3개를 재추출하게 만든다.

  public static void main(String[] args) {
    Random r = new Random();

    int num1 = r.nextInt(9) + 1; // 이래야 1~9인 수
    int num2 = r.nextInt(9) + 1;

    while (num1 == num2) {
      num2 = r.nextInt(9) + 1; // 하나 다시 뽑음
    }

    int num3 = r.nextInt(9) + 1; // 세번째 수 추출
    while (num1 == num3 || num2 == num3) {
      num3 = r.nextInt();
    }

    System.out.println(num1 + ", " + num2 + ", " + num3 );

    System.out.println("=================");
    // 방법 2
    int num4 = 0;
    int num5 = 0;
    int num6 = 0; // 일단 세 수 모두 초기화

    // 한 번에 비교
    while (num4 == num5 || num4 == num6 || num5 == num6 ) {
      num4 = r.nextInt(9) + 1;
      num5 = r.nextInt(9) + 1;
      num6 = r.nextInt(9) + 1;
    }
    System.out.println(num4 + ", " + num5 + ", " + num6 );

  }
}
