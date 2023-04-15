package mega.backend_onemore.Day05;

public class BreakTest1_02 {
  // 미친듯이 0만 출력된다.
  public static void main(String[] args) {

    int a = 0;

    while(true) {
      switch(a){
        case 0:
          System.out.println(a);
          break;
        default:
          System.out.println("값이 없습니다. ");

      }
    }
  }
}
