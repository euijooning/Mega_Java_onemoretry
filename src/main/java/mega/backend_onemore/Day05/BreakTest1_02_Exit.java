package mega.backend_onemore.Day05;

public class BreakTest1_02_Exit {

  public static void main(String[] args) {
    int a = 0;
/*
    while(true) {
      switch(a){
        case 0:
          System.out.println(a);
          break;
        default:
          System.out.println("값이 없습니다. ");

      }
    }
    이거 탈출하려면?
 */
    boolean check = true;
    while (check) {
      switch (a) {
        case 0:
          System.out.println(a);
          check = false;
          break;
        default:
          System.out.println("값이 없습니다. ");
      }
    }
  }

}
