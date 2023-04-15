package mega.backend_onemore.Day05;

public class BreakTest1_01 {

  public static void main(String[] args) {
    int a = 0;
    while(true) {
      while (true) {
        System.out.println("a : " + a);
        if(a==10) {
          break;
        }
        a++; // 변수는 계속 초기화되기 때문에 0~9까지는 반드시 찍히는데 10이 워낙 많다는 것
        // 그래서 10만 출력된다. 스톱 누를때까지
      }
    }
  }

}
