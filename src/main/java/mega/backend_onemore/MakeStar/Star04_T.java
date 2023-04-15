package mega.backend_onemore.MakeStar;

public class Star04_T {

  public static void main(String[] args) {

//    for(int i = 0;i<5;i++) {  // 0 1 2 3 4
//      for(int j = 4;j>=0;j--) { // 4 3 2 1 0
//        if(i<j) { //4 3 2 1 / 4 3 2 /4 3 / 4
//          System.out.print(" ");
//        }
//        else { //0 / 1 0 / 2 1 0 / 3 2 1 0 / 4 3 2 1 0
//          // 1 (+2씩 는다)  3 5 7 9 (i*2)
//          for(int k = 0;k<=i*2;k++) {
//            System.out.print("*");
//          }
//          break;
//        }
//      }
//      System.out.println();
//    }

    for(int i = 0; i<5; i++) {  // 0 1 2 3 4
      for(int j = 4; j>i; j--) { // 4 3 2 1 // 4 3 2 // 4 3 // 4 // 안찍힘
        System.out.print(" ");
      }
      for(int j = 0; j<=i*2; j++) { // 0 // 0 1 2 // 0 1 2 3 4 // 0 1 2 3 4 5 6 // 0 1 2 3 4 5 6 7 8
        System.out.print("*");
      }
      System.out.println();
    }
  }

}
