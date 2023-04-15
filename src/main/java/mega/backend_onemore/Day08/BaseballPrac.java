package mega.backend_onemore.Day08;

import java.util.Random;
import java.util.Scanner;
/*
구조화
1. 임의의 중복되지 않을 1~9 사이의 난수 만들기
2. while(무한루프)문 속에
2-1)
- 첫째 자리 / 숫자 입력받기 // 잘못된 입력(0보다 작거나 9 초과이면)
- 둘째 자리 / 숫자 입력받기 // 잘못된 입력(0보다 작거나 9 초과이면)
- 셋째 자리 / 숫자 입력받기 // 잘못된 입력(0보다 작거나 9 초과이면)
2-2) 숫자 조건 따지기
- 하나가 맞으면 Strike 문자열에 +1
- 하나가 다르면 ball 문자열에 +1
- 세 숫자 모두 일치하면 "홈런" // break
- 그렇지 않으면
-- 모두 0(다 틀린) 경우 out
-- strike / ball 카운트 출력
 */
public class BaseballPrac {

  // 숫자야구 게임 만들기
  // 타인 코드 참고하여 풀어봄.
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); // 숫자 입력받을  스캐너
    Random r = new Random(); // 난수 생성해줄 랜덤 클래스

    // 입력받을 세 개의 숫자 초기화
    int num1 = 0;
    int num2 = 0;
    int num3 = 0;
    // 스트라이크, 볼 판단할 변수 초기화
    int s = 0;
    int b = 0;

    System.out.println("<숫자 야구, 1~9 사이의 서로 다른 숫자 세 개가 필요합니다> ");

    while (num1 == num2 || num1 == num3 || num2 == num3) { // 숫자가 서로 다른 경우여야 하므로 이를 만들어줌.
      num1 = r.nextInt(9) + 1; // 1부터 9까지 범위의 난수여야 하므로
      num2 = r.nextInt(9) + 1;
      num3 = r.nextInt(9) + 1;
    }

    // 무한루프 돌입(while문 사용)
    while (true) {
      System.out.print("첫 번째 자리 : ");
      int userNum1 = sc.nextInt();
      //범위를 벗어나면 잘못된 입력 (게임 속행)
      if (userNum1 < 0 || userNum1 > 9) {
        System.out.println("범위를 벗어났습니다.");
        continue; // 숫자 다시 선택하는 메뉴로 돌아가게 됨.
      }

      System.out.print("두 번째 자리 : ");
      int userNum2 = sc.nextInt();
      //범위를 벗어나면 잘못된 입력22 (게임 속행)
      if (userNum2 < 0 || userNum2 > 9) {
        System.out.println("범위를 벗어났습니다.");
        continue; // 숫자 다시 선택하는 메뉴로 돌아가게 됨.
      }

      System.out.print("세 번째 자리 : ");
      int userNum3 = sc.nextInt();
      //범위를 벗어나면 잘못된 입력22 (게임 속행)
      if (userNum3 < 0 || userNum3 > 9) {
        System.out.println("범위를 벗어났습니다.");
        continue; // 숫자 다시 선택하는 메뉴로 돌아가게 됨.
      }

      // 스트라이크 / 볼 판정
      if (userNum1 == num1 || userNum1 == num2 || userNum1 == num3) { // 입력한 첫 번째 자리 판정
        if (userNum1 == num1) { // 첫 번째 자리가 같은 경우
          s += 1; // 스트라이크 하나 추가
        }
        else {
          b += 1; // 볼 추가
        }
      }
      if (userNum2 == num1 || userNum2 == num2 || userNum2 == num3) { // 입력한 두 번째 자리 판정
        if (userNum2 == num2) { // 두 번째 자리가 같은 경우
          s += 1; // 스트라이크 하나 추가
        }
        else {
          b += 1; // 볼 추가
        }
      }
      if (userNum3 == num1 || userNum3 == num2 || userNum3 == num3) { // 입력한 첫 번째 자리 판정
        if (userNum3 == num3) { // 세 번째 자리가 같은 경우
          s += 1; // 스트라이크 하나 추가
        }
        else {
          b += 1; // 볼 추가
        }
      }
      // 모든 숫자가 다 알맞은 경우 종료, 그렇지 않으면 out / 카운트 알려주기
      if (s == 3) {
        System.out.println("축하합니다. 홈런입니다!");
        break; // 정답이 나왔으니 게임 종료 / 무한루프 while문 탈출함.
      }
      else {
        if (s == 0 && b == 0) {
          System.out.println("Out");
        }
        else { // 현재 카운트 출력
          System.out.println(s + "스트라이크, " + b + "볼 입니다.");

          // 게임을 지속하기 위해 카운트 세는 변수 재초기화
          s = 0;
          b = 0;
        }
      }
    }
  }
}
