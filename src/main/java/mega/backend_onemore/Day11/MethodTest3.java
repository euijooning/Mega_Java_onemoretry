package mega.backend_onemore.Day11;

import java.util.Scanner;

public class MethodTest3 {

  //1. 두수를 입력
  static int input() { //2번.주고 안받고
    // 입력 객체
    Scanner sc = new Scanner(System.in);
    // 입력 값 리턴
    System.out.print("숫자 입력 : ");
    int num = sc.nextInt();
    return num;
  }

  //2. 대소비교
  //3. 출력
  static void compare(int a, int b) { //3번.안주고 받고
    if(a > b) {
      System.out.println("앞에 값이 더 큽니다.");
    }
    else if(a == b) {
      System.out.println("값이 같습니다.");
    }
    else {
      System.out.println("뒤에 값이 더 큽니다.");
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int num1 = input();
    int num2 = input();
    compare(num1, num2);
  }
}
