package mega.backend_onemore.Day14.Prac14;

import java.util.Scanner;

public class StarAndGugu {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("[원하시는 메뉴를 선택하세요]");
      System.out.println("1. 구구단 출력");
      System.out.println("2. 별 찍기 출력");
      System.out.println("3. 종료");
      System.out.print("번호 선택 > ");
      int num = sc.nextInt();

      if(num == 1) {
        System.out.println("[다음 중에서 고르시오]");
        System.out.println("1.원하는 구구단 출력");
        System.out.println("2.전체 구구단 출력");
        System.out.print("선택 > ");
        int gugu = sc.nextInt();

        if (gugu == 1) {
          System.out.print("원하는 구구단 입력 : ");
          int dan = sc.nextInt();
          System.out.println(dan + "단");
          for (int j = 1; j < 10; j++) {
            System.out.println(dan + "X" + j + "=" + (dan * j));
          }
        } else if (gugu == 2) {
          for (int i = 2; i < 10; i++) { // 단
            System.out.println(i + "단");
            for (int j = 1; j < 10; j++) { // 곱해지는 수
              System.out.println(i + "X" + j + "=" + (i * j));
            }
          }
        }
        else {
          System.out.println("잘못된 번호 선택입니다.");
        }
      }
      else if (num == 2) {
        System.out.println("[별의 모양을 선택하세요]");
        System.out.println("1.직사각형");
        System.out.println("2.정직삼각형");
        System.out.println("3.역직삼각형");
        System.out.println("4.피라미드");
        System.out.println("5.다이아몬드");
        System.out.print("모양 선택 > ");
        int starShape = sc.nextInt();

        if(starShape == 1) {
          System.out.print("숫자 입력 : ");
          int starnum = sc.nextInt();
          for(int i = 0;i<starnum;i++) {
            for(int j = 0;j<starnum;j++) {
              System.out.print("*");
            }
            System.out.println();
          }
        }
        else if(starShape == 2) {
          System.out.print("숫자 입력 : ");
          int starnum = sc.nextInt();
          for(int i = 0;i<starnum;i++) {
            for(int j = 0;j<=i;j++) {
              System.out.print("*");
            }
            System.out.println();
          }
        }
        else if(starShape == 3) {
          System.out.print("숫자 입력 : ");
          int starnum = sc.nextInt();
          for(int i = 0;i<starnum;i++) {  // 0 1 2 3 4
            for(int j = starnum-1;j>=0;j--) { // 4 3 2 1 0
              if(i<j) { //4 3 2 1 / 4 3 2 /4 3 / 4
                System.out.print(" ");
              }
              else { //0 / 1 0 / 2 1 0 / 3 2 1 0 / 4 3 2 1 0
                System.out.print("*");
              }
            }
            System.out.println();
          }
        }
        else if(starShape == 4) {
          System.out.print("숫자 입력 : ");
          int starnum = sc.nextInt();
          for(int i = 0;i<starnum;i++) {  // 0 1 2 3 4
            for(int j = starnum-1;j>i;j--) { // 4 3 2 1 // 4 3 2 // 4 3 // 4
              System.out.print(" ");
            }
            for(int j = 0;j<=i*2;j++) { // 0 // 0 1 2 // 0 1 2 3 4 // 0 1 2 3 4 5 6 // 0 1 2 3 4 5 6 7 8
              System.out.print("*");
            }
            System.out.println();
          }
        }
        else if (starShape == 5) {
          System.out.print("숫자 입력 : ");
          int starnum = sc.nextInt();
          for(int i = 0;i<starnum/2+1;i++) {  // 0 1 2 3 4
            for(int j = starnum/2;j>i;j--) { // 4 3 2 1 // 4 3 2 // 4 3 // 4
              System.out.print(" ");
            }
            for(int j = 0;j<=i*2;j++) { // 0 // 0 1 2 // 0 1 2 3 4 // 0 1 2 3 4 5 6 // 0 1 2 3 4 5 6 7 8
              System.out.print("*");
            }
            System.out.println();
          }
          for(int i = 0;i<starnum/2;i++) {
            for(int j =0;j<=i;j++) {
              System.out.print(" ");
            }
            for(int j = starnum-2; j>i*2;j--) { //13/2 6 + 1 7
              System.out.print("*");
            }
            System.out.println();
          }
        }
        else {
          System.out.println("잘못된 모양 선택입니다.");
        }

      }
      else if (num == 3) {
        System.out.println("프로그램을 종료합니다.");
        break;
      }
      else {
        System.out.println("잘못된 입력입니다.");
      }
    }
  }

}
