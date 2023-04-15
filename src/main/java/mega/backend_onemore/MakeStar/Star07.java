package mega.backend_onemore.MakeStar;

public class Star07 {

  public static void main(String[] args) {

    for(int k = 0; k<5; k++) {
      for (int j = 0; j<k; j++) {
        System.out.print(" ");
      }
      for (int i = 0; i<5-k; i++) {
        System.out.print("*");
      }
      System.out.println("");
    }
  /*
  k 0 1 2 3 4
  i 5 4 3 2 1

  k를 가지고 x로 만든다.
  k 0 1 2 3 4
  x 0 1 2 3 4
  따라서 x = k 성랍

  k를 가지고 y로 만든다.(단, 변수는 오로지 k, 나머진 상수)
  k 0, y =  5-0
  k 1  y 5-1
  k 2  y 5-2
  k 3  y 5-3
  k 4  y 5-4  5-k

  여기서부터 조작 시작해야 함.
    for(int k = 0; k<5; k++) {
    for (int j = 0; j<x; j++) {
      System.out.print(" ");
    }
    for (int i = 0; i<y; i++) {
      System.out.print("*");
    }
    System.out.println("");
  }
   */

/*
  for (int j = 0; j<0; j++) {
    System.out.print(" "); // 공백 0개
  }
  for (int i = 0; i<5; i++) {
    System.out.print("*"); // 별 5개
  }
    System.out.println("");




    for (int j = 0; j<1; j++) {
      System.out.print(" "); // 공백 1개
    }
    for (int i = 0; i<4; i++) {
      System.out.print("*"); // 별 4개
    }
    System.out.println("");


    for(int j = 0; j<2; j++ ) {
      System.out.print(" "); // 공백 2개
    }
    for(int i = 0; i<3; i++) { // 별 3개
      System.out.print("*");
    }
    System.out.println("");


    for (int j = 0; j<3; j++) {
      System.out.print(" "); // 공백 3개
    }
    for(int i = 0; i<2; i++) { // 별 2개
      System.out.print("*");
    }
    System.out.println("");

    for (int j = 0; j<4; j++) {
      System.out.print(" "); // 공백 4개
    }
    for(int i = 0; i<1; i++) { // 별 2개
      System.out.print("*");
    }
    System.out.println("");

    끝!!!
 */


  }

}
/*
 *****
 ****
 ***
 **
 *
 */