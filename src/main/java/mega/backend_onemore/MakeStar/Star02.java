package mega.backend_onemore.MakeStar;

public class Star02 {

  public static void main(String[] args) {

    for(int i = 0; i<=5; i++) {
      for (int j = 0; j < i; j++) { // 지금 i만큼 반복한다는 것을 확인할 수가 있지.
        System.out.print("*");
      }
      System.out.println();

    }
    /*

    지금 아래에 있는 반복문들을 다 종합하면은,
    for (int i= 0; i<k; i++) {
      System.out.print("*")
    }
    System.out.println(); // 지금 k는 반복되는 수이므로 그냥 임의의 k로 설정했음. 임시로


    for (int i = 0; i<1; i++) {
      System.out.print("*");
    }
    System.out.println(); // 다섯줄 반복

    for (int i = 0; i<2; i++) {
      System.out.print("*");
    }
    System.out.println();

    for (int i = 0; i<3; i++) {
      System.out.print("*");
    }
    System.out.println();

    for (int i = 0; i<4; i++) {
      System.out.print("*");
    }
    System.out.println();

    for (int i = 0; i<5; i++) {
      System.out.print("*");
    }
    System.out.println();

     */


  }

}
