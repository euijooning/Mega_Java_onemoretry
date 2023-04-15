package mega.backend_onemore.Day02.Prac02;

// 입력 0 or 1 입력
// 비가 온다 안온다.
// 비가 오나요(0:안온다 1:온다) :
// 사용자가 0 안온다 -> "우산 없이 친구를 만나러 갑니다."
// 사용자자 1 온다 -> "우산을 들고 친구를 만나러 갑니다."

import java.util.Scanner;

public class Q2 {

  public static void main(String[] args) {

    //1. 입력 받기
    Scanner sc = new Scanner(System.in);
    System.out.print("비가 오나요(0:안오다 1:온다) : ");
    int select = sc.nextInt();

    // if, else 분기
    if(select == 0) {
      System.out.println("우산 없이 친구를 만나러 갑니다.");
    }
    else {
      System.out.println("우산을 들고 친구를 만나러 갑니다.");
    }

  }
}
