package mega.backend_onemore.Day14.Prac14;

import java.util.Scanner;

public class StarGugu_m2 {
  static int input1(Scanner sc) {
    System.out.println("[원하시는 메뉴를 선택하세요]");
    System.out.println("1. 구구단 출력");
    System.out.println("2. 별 찍기 출력");
    System.out.println("3. 종료");
    System.out.print("번호 선택 > ");
    int num = sc.nextInt();
// 입력 받은 걸 다시 줘야 하니까 리턴이 필요할 것 같아.
    return num;
// 혹은 return sc.nextInt();
  }

  static int input2(Scanner sc) {
    System.out.println("[다음 중에서 고르시오]");
    System.out.println("1.원하는 구구단 출력");
    System.out.println("2.전체 구구단 출력");
    System.out.print("선택 > ");
    int gugu = sc.nextInt();
    return gugu;
  }

  static int inputWantGugu(Scanner sc) {
    System.out.print("원하는 구구단 입력 : ");
    int dan = sc.nextInt();
    return dan;
  }

  static void wantGugu(int dan) { // 출력만 하면 되므로 void 써도 됨.
    System.out.println(dan + "단");
    for (int j = 1; j < 10; j++) {
      System.out.println(dan + "X" + j + "=" + (dan * j));
    }
  }

  static void allGugu() {
    for (int i = 2; i < 10; i++) { // 단
      System.out.println(i + "단");
      for (int j = 1; j < 10; j++) { // 곱해지는 수
        System.out.println(i + "X" + j + "=" + (i * j));
      }
    }
  } // 입력했을 때 따로 뭐 에러났던 게 없으니까 이것도 파라미터는 필요가 없다.

  static void wrongPrint() {
    System.out.println("잘못된 번호 선택입니다.");
  }

  static int input3(Scanner sc) {
    System.out.println("[별의 모양을 선택하세요]");
    System.out.println("1.직사각형");
    System.out.println("2.정직삼각형");
    System.out.println("3.역직삼각형");
    System.out.println("4.피라미드");
    System.out.println("5.다이아몬드");
    System.out.print("모양 선택 > ");
    int starShape = sc.nextInt();
    return starShape;
  }

  static int starInput(Scanner sc) {
    System.out.print("숫자 입력 : ");
    int starnum = sc.nextInt();
    return starnum;
  }

  static void star1(int starnum) {
    for (int i = 0; i < starnum; i++) {
      for (int j = 0; j < starnum; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  static void star2(int starnum) {
    for(int i = 0;i<starnum;i++) {
      for(int j = 0;j<=i;j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  static void star3(int starnum) {
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

  static void star4(int starnum) {
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

  static void star5(int starnum) {
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


  static void run(Scanner sc) {
    while(true) {
      int num = input1(sc);// num이 계속 쓰이므로 객체로 받아야 할 것 같아. 변수저장.
      // 이렇게 하면, break 걸어서 while 조건문을 탈출할 필요가 없어진다.
      // 그런데 굳이 만들고 싶다면, 그냥 boolean false 조작해서 만들면 된다.

      if(num == 1) {
        int gugu = input2(sc);// 이것도 위의 num 상황과 마찬가지.

        if (gugu == 1) {
          /*
          inputWantGugu(sc);
          wantGugu(dan);
          이렇게 할 것이 아니라, 지금 inputWantGugu와 dan이 같은 값을 의미.
          그래서 아래와 같이 간편하게
           */
          wantGugu(inputWantGugu(sc));

        } else if (gugu == 2) {
          allGugu();
        }
        else {
          wrongPrint();
        }
      }
      else if (num == 2) {
        int starShape = input3(sc); // dnleh akcksrkwl

        if(starShape == 1) {
          /*
          starInput(sc);
          star1(starnum);
          이것도 위 주석과 원리 동일
           */
          star1(starInput(sc));
        }
        else if(starShape == 2) {
          star2(starInput(sc));
        }
        else if(starShape == 3) {
          star3(starInput(sc));
        }
        else if(starShape == 4) {
          star4(starInput(sc));

        }
        else if (starShape == 5) {
          star5(starInput(sc));

        }
        else {
          wrongPrint();
        }

      }
      else if (num == 3) {
        // 사실 이것까지 따로 뺄 필요는 없다...
        System.out.println("프로그램을 종료합니다.");
        // break;
      }
      else {
        wrongPrint();
      }
    }


  }


  public static void main(String[] args) {
    run(new Scanner(System.in));
  }

}
