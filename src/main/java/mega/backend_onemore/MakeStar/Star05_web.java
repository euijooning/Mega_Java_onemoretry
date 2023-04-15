package mega.backend_onemore.MakeStar;

public class Star05_web {
  public static void main(String[] args) {
    for (int i = 0; i < 3; i++) {  // 0 1 2 3 4
      for (int j = 2; j > i; j--) { // 4 3 2 1 // 4 3 2 // 4 3 // 4 // 안찍힘
        System.out.print(" ");
      }
      for (int j = 0; j <= i * 2;
          j++) { // 0 // 0 1 2 // 0 1 2 3 4 // 0 1 2 3 4 5 6 // 0 1 2 3 4 5 6 7 8
        System.out.print("*");
      }
      System.out.println();
    }
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j <= i; j++) {
        System.out.print(" ");
      }
      for (int j = 3; j > i * 2; j--) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
