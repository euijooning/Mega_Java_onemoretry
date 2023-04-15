package mega.backend_onemore.Day14.Prac14;

import java.util.Random;
import java.util.Scanner;
/*
1. 컴 랜덤 값 받기 / 주고 받고
- Random r을 매개변수로 받는다
- com 배열 생성
- 반복문 돌면서 랜덤값 받기
- 그 안에 또 반복문 돌면서 중복 수 체크(잘못 나오면 횟수 제외)
- break;
- int배열인 com을 리턴

2. 유저 숫자 입력 메서드 / 주고 받고
- Scanner sc를 매개변수로 받는다.
- 3개짜리 user 배열 생성
- 유저 배열의 길이만큼 for문 돌면서
  i+1 번째 숫자 입력(i가 0이기 때문에)
- 숫자 범위 벗어난 경우 continue; ㅑ--;
- 중복값 입력한 경우
-- for문 돌면서 for(int j = 0;j<i;j++)
   (user[i] == user[j]) 이면 i--;
   break;
- int배열인 user 리턴

3. checkSB 주고 받고
- int[] user, int[] com를 매개변수로 받고
- 결과 저장할 result 배열 생성(2칸짜리)
- 유저 배열의 크기만큼 for문을 돌면서
- 안쪽에 컴 배열의 크기만큼 for문을 돌고,
- 그 와중에 숫자가 같으면,
- 자리까지 같을 시 strike++;
- 자리는 다르면 ball++;
(스트라이크, 볼은 result[0], result[1])
- 결과인 result(인트 배열) 리턴

4.결과 출력 메서드  / 안주고 받고
- int[] result 를 매개변수로 받고 결과를 분기
- if
- (result[0] == 3) / (result[0] == 0 && result[1] == 0) /
  else 면 현재 결과 출력

5. 게임 진행 여부 메서드 / 안주고 받고
- int[] result를 매개변수로 받고
- result[0] == 3 이면 false(게임 종료)
- 아니면 true(게임 속행)

6. main
- 랜덤, 스캐너 생성
-int[] com = comRandom(r);
    int[] result = new int[2];

    while(gameRunCheck(result)) {
      //1. 유저 입력이 올바르게
      int[] user = userInput(sc);
      //2. 스트라이크 볼계산
      result = checkSB(user, com);

      //3. 출력
      resultPrint(result);

      if(result[0] == 3) {
        break;
      }
    }

  }
 */

public class BBAnotherSample {

  static int[] comRandom(Random r) {
    int[] com = new int[3];

    for(int i = 0;i<com.length;i++) {
      com[i] = r.nextInt(9)+1;
      for(int j = 0;j<i;j++) {
        if(com[i] == com[j]) {
          i--;
          break;
        }
      }
    }

    System.out.println(com[0] + ", "+com[1] + ", "+com[2]);

    return com;
  }

  static int[] userInput(Scanner sc) {
    int[] user = new int[3];

    for(int i = 0;i<user.length;i++) {
      System.out.print((i+1)+"숫자 : ");
      user[i] = sc.nextInt();
      //숫자 범위 벗어난경우
      if(!(user[i] >=1 && user[i]<=9)) {
        i--;
        continue; // 여기서는 중복값 검사를 들어갈 필요가 없으므로
      }
      //중복값 입력한 경우
      for(int j = 0;j<i;j++) {
        if(user[i] == user[j]) {
          i--;
          break; // 다시 입력받아야 하므로
        }
      }

    }
    return user; // 유저 배열 자체를 리턴
  }

  static int[] checkSB(int[] user, int[] com) {
    int[] result = new int[2]; // 스트라이크 볼 결과 저장할 배열 생성
    for(int i =0;i<user.length;i++) {
      for(int j = 0;j<com.length;j++) {
        if(user[i] == com[j]) { // ball or strike 숫자가 같고
          if(i == j) { // 자리도 같으면
            result[0]++; // strike
          }
          else { // 숫자는 같은데 자리가 다르면
            result[1]++; // ball
          }
        }
      }
    }

    return result;
  }

  // 결과 출력 메서드 안주고 받고
  static void resultPrint(int[] result) {
    if(result[0] == 3) {
      System.out.println("홈런입니다.");
    }
    else if(result[0] == 0 && result[1] == 0) {
      System.out.println("Out입니다.");
    }
    else {
      System.out.println("strike : "+result[0]+", ball : "+result[1]);
    }
  }
  static boolean gameRunCheck(int[] result) {
    if(result[0] == 3) {
      return false;
    }
    else {
      return true;
    }
  }


  public static void main(String[] args) {
    Random r = new Random();
    Scanner sc = new Scanner(System.in);

    int[] com = comRandom(r);
    int[] result = new int[2];

    while(gameRunCheck(result)) {
      //1. 유저 입력이 올바르게
      int[] user = userInput(sc);
      //2. 스트라이크 볼계산
      result = checkSB(user, com);

      //3. 출력
      resultPrint(result);

      if(result[0] == 3) {
        break;
      }
    }

  }

}

/*
또는
gameCheck를 만들지 않고
while(true) {
   //1. 유저 입력이 올바르게
   int[] user = userInput(sc);
   //2. 스트라이크 볼계산
   int[] result=check(user, com)
   이런식으로 가는 게 더 편할 지도
 */
