package mega.backend_onemore.Day07.Prac07;

import java.util.Scanner;

public class Q1_Star02_T {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("1.직사각형");
      System.out.println("2.정직삼각형");
      System.out.println("3.역직삼각형");
      System.out.println("4.피라미드");
      System.out.println("5.다이아몬드");
      System.out.println("6.종료");
      int num = sc.nextInt();
      if (num == 1) {
        System.out.print("숫자 입력 : ");
        int num1 = sc.nextInt();
        for (int i = 0; i < num1; i++) {
          for (int j = 0; j < num1; j++) {
            System.out.print("*");
          }
          System.out.println();
        }
      } else if (num == 2) {
        System.out.print("숫자 입력 : ");
        int num1 = sc.nextInt();
        for (int i = 0; i < num1; i++) {
          for (int j = 0; j <= i; j++) {
            System.out.print("*");
          }
          System.out.println();
        }
      } else if (num == 3) {
        System.out.print("숫자 입력 : ");
        int num1 = sc.nextInt();
        for (int i = 0; i < num1; i++) {  // 0 1 2 3 4
          for (int j = num1 - 1; j >= 0; j--) { // 4 3 2 1 0
            if (i < j) { //4 3 2 1 / 4 3 2 /4 3 / 4
              System.out.print(" ");
            } else { //0 / 1 0 / 2 1 0 / 3 2 1 0 / 4 3 2 1 0
              System.out.print("*");
            }
          }
          System.out.println();
        }
      } else if (num == 4) {
        System.out.print("숫자 입력 : ");
        int num1 = sc.nextInt();
        for (int i = 0; i < num1; i++) {  // 0 1 2 3 4
          for (int j = num1 - 1; j > i; j--) { // 4 3 2 1 // 4 3 2 // 4 3 // 4
            System.out.print(" ");
          }
          for (int j = 0; j <= i * 2;
              j++) { // 0 // 0 1 2 // 0 1 2 3 4 // 0 1 2 3 4 5 6 // 0 1 2 3 4 5 6 7 8
            System.out.print("*");
          }
          System.out.println();
        }
      } else if (num == 5) {
        System.out.print("숫자 입력 : ");
        int num1 = sc.nextInt();
        for (int i = 0; i < num1 / 2 + 1; i++) {  // 0 1 2 3 4
          for (int j = num1 / 2; j > i; j--) { // 4 3 2 1 // 4 3 2 // 4 3 // 4
            System.out.print(" ");
          }
          for (int j = 0; j <= i * 2;
              j++) { // 0 // 0 1 2 // 0 1 2 3 4 // 0 1 2 3 4 5 6 // 0 1 2 3 4 5 6 7 8
            System.out.print("*");
          }
          System.out.println();
        }
        for (int i = 0; i < num1 / 2; i++) {
          for (int j = 0; j <= i; j++) {
            System.out.print(" ");
          }
          for (int j = num1 - 2; j > i * 2; j--) { //13/2 6 + 1 7
            System.out.print("*");
          }
          System.out.println();
        }
      } else if (num == 6) {
        System.out.println("프로그램을 종료합니다.");
        break;
      } else {
        System.out.println("잘못된 입력입니다.");
      }
    }
  }
}

