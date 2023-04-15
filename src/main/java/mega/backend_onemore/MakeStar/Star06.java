package mega.backend_onemore.MakeStar;

public class Star06 {
  public static void main(String[] args) {
    int N = 5;
/*
j 0 1 2 3 4
x 5 4 3 2 1
x를 j에 관한 식. j 0 -> 0+5   5-0
               j 1 -> 1+3   5-1
               j 2          5-2
               j 3          5-3
               j 4          5-4 //x= 5-j (N-j)
  */
    for(int j = 0; j<5; j++) {
      for (int i = 0; i < 5-j; i++) {
        System.out.print("*");
      }
      System.out.println();
    }
/*
    for(int i = 0; i < 5; i++) {
      System.out.print("*");
    }
    System.out.println();

    for(int i = 0; i<4; i++) {
      System.out.print("*");
    }
    System.out.println();

    for(int i = 0; i<3; i++) {
      System.out.println("*");
    }
    System.out.println();

    for(int i = 0; i<2; i++) {
      System.out.println("*");
    }
    System.out.println();

    for(int i = 0; i<1; i++) {
      System.out.println("*");
    }
    System.out.println();
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


