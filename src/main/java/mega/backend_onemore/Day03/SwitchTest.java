package mega.backend_onemore.Day03;

// 숫자를 입력받고, 알맞은 계절 출력하는 예제

import java.util.Scanner;

public class SwitchTest {

  public static void main(String[] args) {

    // 입력
    Scanner sc = new Scanner(System.in);
    System.out.print("월을 입력하세요 : ");
    int month = sc.nextInt();

    // 계절을 담을 변수 초기화
    String season;

    switch(month) {
      case 12:
      case 1:
      case 2:
        season = "겨울입니다.";
        break;
      case 3:
      case 4:
      case 5:
        season = "봄입니다.";
        break;
      case 6:
      case 7:
      case 8:
        season = "여름입니다.";
        break;
      case 9:
      case 10:
      case 11:
        season = "가을입니다.";
        break;
      default: // 모두 해당하지 않는 경우
        season = "계절에 포함되는 올바른 달이 아닙니다.";
        break;
    }
    System.out.println(season);
  }
}
