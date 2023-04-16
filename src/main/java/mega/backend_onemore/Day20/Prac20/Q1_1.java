package mega.backend_onemore.Day20.Prac20;

import java.util.Random;
import java.util.Scanner;

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
