package mega.backend_onemore.Day14;

import java.util.Scanner;

public class Q1 {

  static int input1(Scanner sc) {
    System.out.println("1. 구구단 출력");
    System.out.println("2. 별찍기 출력");
    System.out.println("3. 종료");
    return sc.nextInt();
  }
  static int input2(Scanner sc) {
    System.out.println("1.원하는 구구단 출력");
    System.out.println("2.전체 구구단 출력");
    return sc.nextInt();
  }

  static int inputWantGugu(Scanner sc) {
    System.out.print("원하는 구구단 입력 : ");
    return sc.nextInt();
  }

  static void wantGugu(int dan) {
    System.out.println(dan+"단!!!!!!!!");
    for(int j =1;j<10;j++) {
      System.out.println(dan+"X"+j+"="+(dan*j));
    }
  }
  static void allGugu() {
    for(int i =2 ;i<10;i++) { // 단
      System.out.println(i+"단!!!!!!!!");
      for(int j =1;j<10;j++) { // 곱해지는 수
        System.out.println(i+"X"+j+"="+(i*j));
      }
    }
  }

  static void wrongPrint() {
    System.out.println("잘못된 입력");
  }

  static int input3(Scanner sc) {
    System.out.println("1.직사각형");
    System.out.println("2.정직삼각형");
    System.out.println("3.역직삼각형");
    System.out.println("4.피라미드");
    System.out.println("5.다이아몬드");
    return sc.nextInt();
  }

  static int starInput(Scanner sc) {
    System.out.print("숫자 입력 : ");
    return sc.nextInt();
  }

  static void star1(int num1) {
    for(int i = 0;i<num1;i++) {
      for(int j = 0;j<num1;j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  static void star2(int num1) {
    for(int i = 0;i<num1;i++) {
      for(int j = 0;j<=i;j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  static void star3(int num1) {
    for(int i = 0;i<num1;i++) {  // 0 1 2 3 4
      for(int j = num1-1;j>=0;j--) { // 4 3 2 1 0
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

  static void star4(int num1) {
    for(int i = 0;i<num1;i++) {  // 0 1 2 3 4
      for(int j = num1-1;j>i;j--) { // 4 3 2 1 // 4 3 2 // 4 3 // 4
        System.out.print(" ");
      }
      for(int j = 0;j<=i*2;j++) { // 0 // 0 1 2 // 0 1 2 3 4 // 0 1 2 3 4 5 6 // 0 1 2 3 4 5 6 7 8
        System.out.print("*");
      }
      System.out.println();
    }
  }

  static void star5(int num1) {
    for(int i = 0;i<num1/2+1;i++) {  // 0 1 2 3 4
      for(int j = num1/2;j>i;j--) { // 4 3 2 1 // 4 3 2 // 4 3 // 4
        System.out.print(" ");
      }
      for(int j = 0;j<=i*2;j++) { // 0 // 0 1 2 // 0 1 2 3 4 // 0 1 2 3 4 5 6 // 0 1 2 3 4 5 6 7 8
        System.out.print("*");
      }
      System.out.println();
    }
    for(int i = 0;i<num1/2;i++) {
      for(int j =0;j<=i;j++) {
        System.out.print(" ");
      }
      for(int j = num1-2; j>i*2;j--) { //13/2 6 + 1 7
        System.out.print("*");
      }
      System.out.println();
    }
  }


  static boolean exitCheck(int num) {
    if(num == 3) {
      System.out.println("프로그램을 종료합니다.");
      return false;
    }
    return true;
  }

  static void run(Scanner sc) {
    int num = -1;
    while(exitCheck(num)) {
      num =input1(sc);
      if(num == 1) {
        int num1 = input2(sc);
        if(num1 == 1) {
          wantGugu(inputWantGugu(sc));
        }
        else if(num1 == 2) {
          allGugu();
        }
        else {
          wrongPrint();
        }
      }
      else if(num == 2) {
        int num2 = input3(sc);
        if(num2 == 1) {
          star1(starInput(sc));
        }
        else if(num2 == 2) {
          star2(starInput(sc));
        }
        else if(num2 == 3) {
          star3(starInput(sc));
        }
        else if(num2 == 4) {
          star4(starInput(sc));
        }
        else if(num2 == 5) {
          star5(starInput(sc));
        }
        else {
          wrongPrint();
        }
      }
      else {
        if(num != 3) {
          wrongPrint();
        }
      }

    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    run(new Scanner(System.in));
  }

}
