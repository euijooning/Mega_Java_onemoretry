package mega.backend_onemore.Day19;

import java.util.Random;
import java.util.Scanner;
/*
업다운 문제
1. 랜덤 수 1~31까지 입력받고, 스캐너도 생성
2. 유저가 숫자를 입력받는데, 범위를 벋어나면 잘못된 입력
 */
public class Q1 {

  public static void main(String[] args) {
    Random r = new Random();
    Scanner sc = new Scanner(System.in);

    int com = r.nextInt(31) + 1;
    System.out.println(com);

    while (true) {
      System.out.print("유저 숫자 입력 : ");
      int user = sc.nextInt();

      if (user<1 || user>31) {
        System.out.println("잘못된 입력입니다. 숫자를 다시 입력합니다.");
        continue;
      }

      // 결과 비교 후 끝내기
      if (com > user) {
        System.out.println("컴퓨터 업");
      }
      else if (com < user) {
        System.out.println("컴퓨터 다운");
      }
      else {
        System.out.println("축하드립니다. 게임을 종료합니다.");
        break;
      }
    }
  }

}
