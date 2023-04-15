package mega.backend_onemore.Day03.Prac03;

import java.util.Scanner;

public class Q02_T_1 {

  public static void main(String[] args) {

    // 선생님 풀이,  중첩 if문 썼다.

    Scanner sc = new Scanner(System.in);
    //1. 입력
    System.out.print("월 입력 : ");
    int month = sc.nextInt();
    System.out.print("온도 입력 : ");
    int temp = sc.nextInt();

    //2. 올바르게 입력했는지 확인
    // 먼저 공통 조건 월 1~12 온도 -15~37 => 이후 개별 조건(봄 해당 월 => 봄의 온도...) : 중첩 if문으로 작성한다.
    if (month >= 1 && month <= 12 && temp >= -15 && temp <= 37) {
      if (month >= 3 && month <= 5) {//봄
        if (temp >= 3 && temp <= 17) {
          System.out.println("계절은 봄입니다. 온도는 " + temp + "입니다.");
        } else {
          System.out.println("계절과 온도가 맞지 않습니다.");
        }
      } else if (month >= 6 && month <= 8) {//봄
        if (temp >= 18 && temp <= 37) {
          System.out.println("계절은 여름입니다. 온도는 " + temp + "입니다.");
        } else {
          System.out.println("계절과 온도가 맞지 않습니다.");
        }
      } else if (month >= 9 && month <= 11) {//봄
        if (temp >= 3 && temp <= 17) {
          System.out.println("계절은 가을입니다. 온도는 " + temp + "입니다.");
        } else {
          System.out.println("계절과 온도가 맞지 않습니다.");
        }
      } else {
        if (temp >= -15 && temp <= 2) {
          System.out.println("계절은 겨울입니다. 온도는 " + temp + "입니다.");
        } else {
          System.out.println("계절과 온도가 맞지 않습니다.");
        }
      }
    }

  }
}
