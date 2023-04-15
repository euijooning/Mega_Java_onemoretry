package mega.backend_onemore.Day05.Prac05;

// 구구단 출력 심화

/*
1. 스캐너 객체 생성
while 트루

2. 원하는 메뉴 숫자 입력
2-1. 1번 입력하면 원하는 구구단
  2-1-1. 원하는 구구단 단수 입력
  2-1-2. 반복문 하나면 충분,
        (dan + "*" + j + " = " + (dan * j));

2-2. 2번 입력하면 전체 구구단
  2-2-1. 바깥쪽 for문은 단수
  2-2-2. 안쪽 for문은 곱하는 수, 1부터
        (i + "*" + j + " = " + (i * j));

2-3. 3번 입력하면 종료 (break)
2-4. 잘못된 입력
*/

import java.util.Scanner;

public class Q03_T {

  public static void main(String[] args) {
    //1. 무한루프 -> 3번 메뉴를 만나기 전까지
    //반복문이 실행이되는 상황에서 3번 선택을 만나야 합니다.
    //무한루프

    Scanner sc = new Scanner(System.in);

    while (true) {
      //1. 첫화면
      System.out.println("1.원하는 구구단 출력");
      System.out.println("2.전체 구구단 출력");
      System.out.println("3.종료");
      int num = sc.nextInt();

      if (num == 1) {
        System.out.print("원하는 구구단 입력 : ");
        int dan = sc.nextInt();
        System.out.println(dan + "단");
        for (int j = 1; j < 10; j++) {
          System.out.println(dan + "*" + j + " = " + (dan * j));
        }
      } else if (num == 2) {
        for (int i = 2; i < 10; i++) { // 단
          System.out.println(i + "단");
          for (int j = 1; j < 10; j++) { // 곱해지는 수
            System.out.println(i + "*" + j + " = " + (i * j));
          }
        }
      } else if (num == 3) {
        System.out.println("프로그램을 종료합니다.");
        break;

      } else {
        System.out.println("잘못된 입력입니다.");
      }
    }
  }

}
