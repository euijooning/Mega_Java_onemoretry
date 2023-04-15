package mega.backend_onemore.Day08;

import java.util.Random;
import java.util.Scanner;
//배열 숫자 야구

//1. 컴퓨터 랜덤 숫자 생성 단, 중복제거 필요
//2. 유저 숫자 입력 단, 1~9값만 허용, 중복허용 X
//3. 컴퓨터 랜덤 숫자와 유저 입력 숫자 비교
//3-1. 자리와 숫자가 같으면 strike
//3-2. 숫자는 같지만 자리가 다르면 ball
//3-3. strike, ball이 없으면 out
//3-4. 3 strike -> 홈런 프로그램 종료
//3-5. 홈런이 나오기 전까지는 strike ball을 출력 or out 출력

public class BaseballArray_T {

  public static void main(String[] args) {
    Random r = new Random();
    Scanner sc = new Scanner(System.in);
    // 값 저장할 배열 생성
    int[] com = new int[3];
    int[] user = new int[3];

    //1. 컴퓨터 랜덤 숫자 생성 단, 중복제거 필요
    // 1-1. 랜덤수 생성
    for (int i = 0; i < com.length; i++) {
      com[i] = r.nextInt(9) + 1;

      // 1-2. 두 번재 반복문 생성 : 숫자 중복 방지를 위한 검사
      for (int j = 0; j < i; j++) {
        if (com[i] == com[j]) {
          i--;
          break;
        }
      }
    }
    System.out.println(com[0] + ", " + com[1] + ", " + com[2]); // 정답 숫자 출력

    //3. 컴퓨터 랜덤 숫자와 유저 입력 숫자 비교
    int strike = 0;
    int ball = 0; // 카운트 변수 미리 초기화

    while (strike < 3) {
      for (int i = 0; i < user.length; i++) {
        System.out.println((i + 1) + "번째 숫자 입력 : ");
        user[i] = sc.nextInt();

        // 범위가 잘못된 경우(1~9가 x)
        if (user[i] < 1 || user[i] > 9) {
          System.out.println("잘못된 입력입니다."); // 헷갈리지 않으려면 "범위를 벗어났습니다."
          i--; // 횟수에서 제외
          continue; // 다시 입력받도록 함.
        }

        // 값이 중복된 경우
        for (int j = 0; j < i; j++) {
          if (user[i] == user[j]) {
            System.out.println("잘못된 입력입니다."); // 헷갈리지 않으려면 "값이 중복됩니다. 다시 입력해야 합니다."
            i--; // 횟수에서 차감
            break; // 값이 중복된 경우 이후에 검사할 필요가 없으므로 반복문 탈출(다시 입력하는 곳으로 가겠네)
          }
        }
      }
      //3-1. 자리와 숫자가 같으면 strike
      //3-2. 숫자는 같지만 자리가 다르면 ball
      strike = 0;
      ball = 0;
      // 현재 조건,
      //  숫자 && 자리  => 스트라이크 / 숫자 같으면 => 볼
      // 여기서 공통된 것은 숫자!. 그래서 숫자를 보는 거다.
      for (int i = 0; i < user.length; i++) {
        for (int j = 0; j < com.length; j++) {
          if (user[i] == com[j]) { // 숫자가 같으면
            if (i == j) { // (숫자 +)자리까지 같으면
              strike++;
            } else { // 숫자만 같고 자리가 다르면,
              ball++;
            }
          }
        }
      }
      //3-3. 3-4. 3-5
      // if-else if로 묶을 수 있음.
      if(strike == 0 && ball == 0) { // 모두 겹치는 게 없으면
        System.out.println("OUT 입니다.");
      }
      else if(strike == 3) { // 모두 겹친다면
        System.out.println("홈런입니다.");
      }
      else { // 겹치는 게 있으나 스트라이크가 아닌 경우
        System.out.println("strike : "+strike+", ball : "+ball);
      }

    }

  }
}
