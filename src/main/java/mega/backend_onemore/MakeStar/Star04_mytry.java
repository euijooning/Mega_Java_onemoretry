package mega.backend_onemore.MakeStar;

public class Star04_mytry {

  public static void main(String[] args) {
    // 별찍기 일일이 만들기

    // 첫 번째 줄
    for (int j = 4; j > 0; j--) { // 공백 4개
      System.out.print(" ");
    }
    for (int j = 0; j <= 0 * 2; j++) { // 별 1개
      System.out.print("*");
    }
    System.out.println();

    for (int j = 4; j > 1; j--) { // 공백 3개
      System.out.print(" ");
    }
    for (int j = 0; j <= 1 * 2; j++) { //별 3개
      System.out.print("*");
    }
    System.out.println();

    for (int j = 4; j > 2; j--) { // 공백 2개
      System.out.print(" ");
    }
    for (int j = 0; j <= 2 * 2; j++) { // 별 5개
      System.out.print("*");
    }
    System.out.println();

    for (int j = 4; j > 3; j--) { // 공백 1개
      System.out.print(" ");
    }
    for (int j = 0; j <= 3 * 2;
        j++) { // 0 // 0 1 2 // 0 1 2 3 4 // 0 1 2 3 4 5 6 // 0 1 2 3 4 5 6 7 8
      System.out.print("*");
    }
    System.out.println();

    for (int j = 4; j > 4; j--) { // 공백 제로
      System.out.print(" ");
    }
    for (int j = 0; j <= 4 * 2;
        j++) { // 0 // 0 1 2 // 0 1 2 3 4 // 0 1 2 3 4 5 6 // 0 1 2 3 4 5 6 7 8
      System.out.print("*");
    }
    System.out.println();
  }

}



/*
    for(int i = 0;i<5;i++) {  // 0 1 2 3 4
      for(int j = 4;j>i;j--) { // 4 3 2 1 // 4 3 2 // 4 3 // 4
        System.out.print(" ");
      }
      for(int j = 0;j<=i*2;j++) { // 0 // 0 1 2 // 0 1 2 3 4 // 0 1 2 3 4 5 6 // 0 1 2 3 4 5 6 7 8
        System.out.print("*");
      }
      System.out.println();

 */
