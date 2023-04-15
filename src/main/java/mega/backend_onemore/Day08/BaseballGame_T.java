package mega.backend_onemore.Day08;

import java.util.Random;
import java.util.Scanner;

//1. 컴퓨터 랜덤 숫자 생성 단, 중복제거 O
//2. 유저 숫자 입력 단, 1~9값만 허용, 중복허용X
//3. 컴퓨터 랜덤 숫자와 유저 입력 숫자 비교
//3-1. 자리와 숫자가 같으면 strike
//3-2. 숫자는 같지만 자리가 다르면 ball
//3-3. strike, ball이 없으면 out
//3-4. 3 strike -> 홈런 프로그램 종료
//홈런이 나오기 전까지는 strike ball을 출력 or out 출력
public class BaseballGame_T {

  public static void main(String[] args) {
    // 1. 랜덤 숫자 생성, 중복 제거 필요(com)
    Random r = new Random();
    Scanner sc = new Scanner(System.in);

    int com1 = 0;
    int com2 = 0;
    int com3 = 0; // com 입력받을 수 한꺼번에 초기화
    while (com1==com2 || com1==com3 || com2==com3) {
      com1 = r.nextInt(9) + 1; // com1 난수 생성
      com2 = r.nextInt(9) + 1; // com2 난수 생성
      com3 = r.nextInt(9) + 1; // com3 난수 생성
    }
    System.out.println(com1 + ", " + com2 + ", " + com3); //정답 숫자 출력


    // 2. 유자 숫자 입력
    // 먼저 strike, ball 초기화
    int strike = 0;
    int ball = 0;

    // 숫자 입력 받기 => 반복 조건 : 0스트라이크 ~ 2스트라이크 (3스트라이크 되면 안 됨)
    while (strike<3) {
      System.out.println("첫 번째 숫자 : ");
      int user1 = sc.nextInt();
      System.out.println("두 번째 숫자 : ");
      int user2 = sc.nextInt();
      System.out.println("세 번째 숫자 : ");
      int user3 = sc.nextInt();

    // 비교 시작
      //1) 잘못된 입력 : 입력 후 출력된 난수의 중복  또는 난수가 1~9 범위가 넘어가면 안 됨
      //2) 그렇지 않으면, strike, ball 하나씩 추가
      if(user1 == user2 || user1 == user3 || user2 == user3
          || user1 < 1 || user1 > 9 || user2 < 1 || user2 > 9 || user3 < 1 || user3 > 9) {
        System.out.println("잘못된 입력입니다.");
      }
      else { // s, b 하나씩 추가, out도 있음. 다시 if문 분기 (모두 독립시행이므로 단일 if 처리)
        strike = 0;
        ball = 0;

        //3-1
        if(user1 == com1) {
          strike++;
        }
        if(user2 == com2) {
          strike++;
        }
        if(user3 == com3) {
          strike++;
        }
        //3-2
        if(user1 == com2 || user1 == com3) {
          ball++;
        }
        if(user2 == com1 || user2 == com3) {
          ball++;
        }
        if(user3 == com1 || user3 == com2) {
          ball++;
        }

        if (strike == 0 && ball == 0) {
          System.out.println("OUT 입니다.");
        } else if (strike == 3) {
          System.out.println("홈런입니다. 축하합니다!");
        } else {
          System.out.println("스트라이크 : " + strike + " / " + "볼 : " + ball );
        }

      }
    }
  }
}
