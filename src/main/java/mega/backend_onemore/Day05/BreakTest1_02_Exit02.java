package mega.backend_onemore.Day05;

public class BreakTest1_02_Exit02 {
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
    /*
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
        // check를 안 쓰고 싶다면?
     */

    while (a==0) {
      switch (a) {
        case 0:
          System.out.println(a);
          a++; //요기
        default:
          System.out.println("값이 없습니다. ");
      }
    }
  }
}
/*
a++는 a 변수의 값을 1 증가시키는 연산입니다.
따라서 while 루프의 조건인 a==0이 더 이상 참이 아닌 경우(즉, a가 1이 되는 경우)
while 루프가 종료됩니다. a++ 이후의 다음 코드는 실행되지 않습니다.
 */

