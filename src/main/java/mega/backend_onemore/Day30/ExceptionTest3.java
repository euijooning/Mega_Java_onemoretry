package mega.backend_onemore.Day30;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest3 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = 0;
    while(true) { // 계속 입력받을 거니까.
      try {
        System.out.print("숫자 : ");
        num = sc.nextInt();
        System.out.println("입력 받은 숫자 : " + num);
        break;
      }
      catch (InputMismatchException e) { // 이상하게 입력을 받은 경우. 버퍼에 찌꺼기가 남음.
        // 리턴을 안 받으므로, 찌꺼기를 그냥 날리는 꼴이 됨.
        sc.nextLine(); // 한 줄 날려버려야 함. 이상하게 입력한 문자를 클리어
        // 날리고 나서 다시 받아야함.
        System.out.println("올바르게 숫자를 입력하세요.");

      }
    }

  }

}
