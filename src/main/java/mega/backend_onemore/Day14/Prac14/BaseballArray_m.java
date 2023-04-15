package mega.backend_onemore.Day14.Prac14;

import java.util.Random;
import java.util.Scanner;

public class BaseballArray_m {

  static int[] randomMake(Random r) {
    int[] com = new int[3];
    for(int i = 0;i<com.length;i++) {
      com[i] = r.nextInt(9) + 1;   // 예를 들면 com[0] = 8 com[1] = 7 com[2] = 7
      for(int j = 0;j<i;j++) {
        if(com[i] == com[j]) {
          i--; // i의 값을 변동시켜 com[i]에 계속 다른 값을 넣기 위함. 결국 i가 3이 되고 [0], [1], [2]의 값이 모두 다르면 탈출함.
          break;
        }
      }
    }
  return com;
  }

  static void comPrint(int[] com) {
    System.out.println(com[0]+","+com[1]+","+com[2]);
  }

  static int[] userInput(Scanner sc) {
    int[] user = new int[3];
    for(int i = 0;i<user.length;i++) {
      System.out.print((i+1)+"번째 숫자 : ");
      user[i] = sc.nextInt();
      //범위 1~9 아닌경우
      if(user[i]<1 || user[i] >9) {
        System.out.println("범위를 벗어났습니다.");
        i--;
        continue;
        // 그 값만 보면 되기 때문에 반복문 안 쓴다.
      }
      //값이 중복되는 경우
      for(int j = 0;j<i;j++) { // 일일이 확인해줘야 하기 때문에 반복문 출력
        if(user[i] == user[j]) {
          System.out.println("값이 중복됩니다. 다시 입력해야 합니다.");
          i--;
          break;
        }
      }
    }
    return user;
  }
  /*
  지금 com은 한 번 받고 keep 해놓고 걔만 계속 쓴다.
  user은 할 때마다 새로운 값을 받아줘야지.
  요청을 할 때마다 random을 만들어준다.
   */

  static void sbCount(int[] user, int[] com, int[] result) {
    // 스트라이크, 볼 계산해서 밖으로 빼줘야 하므로 배열이 필요하다!
    // 0번을 strike, 1번을 ball로 간주한다.
    // 그런데, 뒤에서 해본 고민처럼.
    // 이 값은 시작할 때부터 있어야 하므로 아예 받아온다.(여기서 만들면 안 됨.)
    // 초기화만 해주자
    result[0] =0;
    result[1] =0;

    //그럼 result를 반환할 필요가 없어져버리지.

    for(int i = 0;i<user.length;i++) {  //0일때 0 1 2 다 비교  / 1일때 0 1 2 다 비교/ 2일 때 0 1 2 다 비교
      for(int j = 0;j<com.length;j++) {
        if(user[i] == com[j]) { // i, j의 인덱스는 신경쓰지 않아도 된다.
          if(i==j) {
            result[0]++; // result[0] +=1;
          }
          else {
            result[1]++;
          }
        }
      }
    }
  }


  static void printResult(int[] result) {
    if(result[0] == 0 && result[1] == 0) {
      System.out.println("OUT 입니다.");
    }
    else if(result[0] == 3) {
      System.out.println("홈런입니다.");
    }
    else {
      System.out.println("strike : "+result[0] + ", ball : " + result[1]);
    }
  }


  static boolean gameRunCheck(int strike) { // 게임이 돌고 말고니까, 이것도 불리언 타입.
    if (strike == 3) {
      return false;
    }
    return true;
  }
  // 여기서 고민, 조건을 만들려고 하다보니, strike/ball을 어떻게 받아올지 고민.
  // 스트라이크/볼은 결과 이후에 알 수 있는 것이잖아. 그 전에는 초깃값이 들어가 있으니까.
  // 그럼 위 메서드에서 받아오면 안되네, 미리 알아야 하는 거니까.
  //sbCount에서 result를 만들어서 끌어올리면 안된다는 말. 받아와야 한다!!!

  public static void main(String[] args) {
    Random r = new Random();
    Scanner sc = new Scanner(System.in);
    //1. 클리어
    int[] com = randomMake(r);
    comPrint(com);

    int[] result = new int[2];

    while(gameRunCheck(result[0])) { // 돌아갈 건지 아닌지를 체크
      sbCount(userInput(sc), com, result);
      printResult(result);

    }
  }

}
