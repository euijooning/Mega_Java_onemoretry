package mega.backend_onemore.Day20.Prac20;

import java.util.Random;
import java.util.Scanner;

/*
업다운 게임.
컴퓨터가 랜덤으로 1~31까지의 수를 정하고, 유저가 1~31까지 숫자를 입력
잘못된 입력 표시
비교해서 업 / 다운
컴퓨터의 랜덤 숫자를 맞추면 종료
 */
/*
idea
- 랜덤, 스캐너, com 랜덤
- 유저 숫자 입력하고 분기
- 마지막 else에 break는 붙어 있다.
 */
public class Q1_1 {

  public static void main(String[] args) {
    Random r = new Random();
    Scanner sc = new Scanner(System.in);
    int com = r.nextInt(31) + 1;

    while (true) {
      System.out.println("유저 숫자 입력 : ");
      int user = sc.nextInt();
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
