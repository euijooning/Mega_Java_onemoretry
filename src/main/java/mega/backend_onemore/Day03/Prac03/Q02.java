package mega.backend_onemore.Day03.Prac03;

/*
여기에 온도 값이 없거나 계절의 월 범위가 벗어나면 잘못된 입력입니다를 출력합니다.
# 월을 입력 받고, 온도를 입력받습니다
(3~5월 "봄입니다" / 6~8월 "여름입니다" / 9~11월 "가을입니다" / 12~2월 "겨울입니다")
# 온도가 각 계절별 날씨와 일치하지 않으면 "계절과 온도가 맞지 않습니다" 출력

ex1) 월 입력 : 3 / 온도도 입력 : 8
=> 출력 : 계절은 봄입니다. 온도는 8도입니다.
ex2) 월 입력 : 3 / 온도 입력 : 38
=> 출력 : 계절과 온도가 맞지 않습니다.
 */


// 나의 풀이 : 이렇게 푸는 것은 지양한다.
/*
풀이한 순서 : 월 입력, 온도 입력 받고, 벗어나는 범위 먼저 IF문으로 설정
이후 switch문 사용하여 적절한 범위 설정 후 알맞은 메시지 출력하게 작성함.

선생님 평가 : 틀린 건 아니나 난잡한 풀이.
 */

import java.util.Scanner;

public class Q02 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.print("월을 입력하세요. : ");
    int month = sc.nextInt();

    System.out.println("온도를 입력하세요. : ");
    int temp = sc.nextInt();

    if ((month < 1 || month > 13) && (temp < -15 || temp > 37)) {
      System.out.println("잘못된 입력입니다.");
    }

//		String weather;
//		String overTemp;

    switch(month) {
      case 12:
      case 1:
      case 2:
        if (temp >= 2 && temp <= -15) {
          System.out.println("겨울입니다.");
        } else {
          System.out.println("계절과 온도가 맞지 않습니다.");
        }
        break;

      case 3:
      case 4:
      case 5:
        if (temp >= 3 && temp <= 15) {
          System.out.println("봄입니다.");
        } else {
          System.out.println("계절과 온도가 맞지 않습니다.");
        }
        break;

      case 6:
      case 7:
      case 8:
        if (temp >= 18 && temp <= 37) {
          System.out.println("여름입니다.");
        } else {
          System.out.println("계절과 온도가 맞지 않습니다.");
        }
        break;

      case 9:
      case 10:
      case 11:
        if (temp >= 3 && temp <= 15) {
          System.out.println("가을입니다.");
        } else {
          System.out.println("계절과 온도가 맞지 않습니다.");
        }
        break;

      default:
//			weather = "달의 범위를 벗어났습니다.";
//			overTemp = "온도의 범위를 벗어났습니다.";
        break;
    }
    System.out.println("프로그램을 종료합니다.");
  }

}
