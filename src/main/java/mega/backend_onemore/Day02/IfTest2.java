package mega.backend_onemore.Day02;

// 땅에 떨어진 돈 줍기
// 1000원 이상이면 돈을 주워서 간다 출력
// 그렇지 않을 경우 그냥 간다 출력

import java.util.Scanner;

public class IfTest2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("땅에 떨어진 돈 입력 : ");
    int money = sc.nextInt();

    if(money >= 1000) {
      System.out.print(money+"원을 주어서 ");
    } else {
      System.out.println("그냥 ");
    }

    System.out.print("간다.");
  }

}
