package mega.backend_onemore.Day15.Prac15;

import java.util.Random;
import java.util.Scanner;

/*
1. 물고기 랜덤 배치 / 주고 받고
- 2차원 배열 호수 매개변수로 받고
- 랜덤 클래스 생성
- 물고기 개수 0으로 초기화
- while(fishCount<3) 일 때
- 행, 열 각각 랜덤 수 받음
1-1. 호수의 행열이 비어 있으면, 그 곳을 1로 바꾸고
     fishCount++;
- return fishCount;



2. 호수 상태 출력 메서드 / 주고 받고
int[][] hosu, int[] input, boolean check를 매개변수로 받고

<Boolean이 매개변수로 쓰인 이유는
이 메서드가 두 번 쓰인다.
한 번은 캐스팅 전(초기 상태)
한 번은 캐스팅 하고 나서 낚시 찌의 위치를 나타낼 때 쓰일 것이다.

그래서 선생님의 main문을 보면 캐스팅 전에는 false(수행 전)고, 캐스팅 후에는 true(수행 후) 로 표기한다.>

- 호수의 길이만큼 이중 for문을 돌면서 if문 분기
-- (input[0] == i && input[1] == j && check) 사용자 위치 X
-- (hosu[i][j] == 0) 빈 곳 o
-- 아니면 물고기 있는 곳 ●
-- 끝나는 곳 맞춰서 이차원 배열이므로 println()


3. 행 열 입력 메서드 / 안주고 받고
- int[] input, Scanner sc를 매개변수로 받고
- while(true) 안에서
- input[x] 가 범위를 벗어나면(1~4가 아니면) break. 그리고 잘못된 입력입니다 출력.

4. 물고기 체크 메서드 / 주고 받고
- int[][] hosu, int[] input, int fishCount 를 매개변수로 받고
- if문 분기
4-1 행 열 입력한게 물고기 위치와 일치(hosu[input[0]][input[1]] == 1)하면
-- 물고기를 잡았습니다 출력
-- 그 위치에 들어있는 것을 없애주고(hosu[input[0]][input[1]] = 0;)
-- 물고기 숫자를 하나 감소시킴
- } 물고기 숫자를 반환

5. 동서남북 움직임 // 안주고 받고
 // 1 입력 시 input[0]--;
 // 이 위치가 0보다 작으면 움직일 수 없으며 다시 0으로 초기화 input[0] = 0
 // 네 개 동일
 // 그리고 잘못된 입력

6. main문
    Scanner sc = new Scanner(System.in);
    //1. 5X5 호수 만들기
    int[][] hosu = new int[5][5];
    //2. Random을 통해서 물고기 배치
    int fishCount = 0;
    int[] input = new int[2];
    fishCount = randomFish(hosu);
    hosuPrint(hosu, input, false);
    //캐스팅
    input(input, sc);
    System.out.println(input[0] + "," + input[1]);
    //물고기 확인
    fishCount = fishCheck(hosu, input, fishCount);
    while (fishCount > 0) {
      int num = newsInput(sc);
      newsMove(num, input);
      //물고기체크
      fishCount = fishCheck(hosu, input, fishCount);
      //출력
      hosuPrint(hosu, input, true);
    }
    System.out.println("낚시게임을 종료합니다.");
  }

}

 */



public class Q2T {

  static int randomFish(int[][] hosu) {
    Random r = new Random();
    int fishCount = 0;
    while (fishCount < 3) {
      int h = r.nextInt(5); //행 랜덤
      int y = r.nextInt(5); //열 랜덤
      if (hosu[h][y] == 0) {
        hosu[h][y] = 1;
        fishCount++;
      }
    }
    return fishCount;
  }

  static void hosuPrint(int[][] hosu, int[] input, boolean check) {
    for (int i = 0; i < hosu.length; i++) {
      for (int j = 0; j < hosu[i].length; j++) {
        //행과 열이 사용자 위치와 일치하고 캐스팅 x일 때
        if (input[0] == i && input[1] == j && check) {
          System.out.print("X");
          // 호수의 행 열에 물고기가 없다면
        } else if (hosu[i][j] == 0) {
          System.out.print("○");
        } else { // 그렇지 않으면(물고기 존재)
          System.out.print("●");
        }
      }
      System.out.println();
    }
  }

  static void input(int[] input, Scanner sc) {
    while (true) {
      System.out.print("행 입력 : ");
      input[0] = sc.nextInt();
      System.out.print("열 입력 : ");
      input[1] = sc.nextInt();

      // 입력값이 범위를 벗어났을 때(1~4 아닌 경우)
      if (input[0] > -1 && input[0] < 5 && input[1] > -1 && input[1] < 5) {
        break;
      }

      System.out.println("잘못된 입력입니다.");
    }
  }

  static int fishCheck(int[][] hosu, int[] input, int fishCount) {
    if (hosu[input[0]][input[1]] == 1) { // 행 열 입력한게 물고기 위치와 일치
      System.out.println("물고기를 잡았습니다.");
      hosu[input[0]][input[1]] = 0; // 그 위치에 들어있는 것을 없애주고
      fishCount--; // 물고기 숫자를 하나 감소시킴
    }
    return fishCount; // 결과값을 반환
  }

  static int newsInput(Scanner sc) {
    System.out.print("1. 위 2. 아래 3. 왼쪽 4. 오른쪽 : ");
    return sc.nextInt();
  }

  static void newsMove(int num, int[] input) {
    if (num == 1) {
      input[0]--;
      if (input[0] < 0) {
        System.out.println("더이상 위로 움직일 수 없습니다.");
        input[0] = 0;
      }
    } else if (num == 2) {
      input[0]++;
      if (input[0] > 4) {
        System.out.println("더이상 아래로 움직일 수 없습니다.");
        input[0] = 4;
      }
    } else if (num == 3) {
      input[1]--;
      if (input[1] < 0) {
        System.out.println("더이상 왼쪽으로 움직일 수 없습니다.");
        input[1] = 0;
      }
    } else if (num == 4) {
      input[1]++;
      if (input[1] > 4) {
        System.out.println("더이상 오른쪽으로 움직일 수 없습니다.");
        input[1] = 4;
      }
    } else {
      System.out.println("잘못된 입력입니다.");
    }
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    //1. 5X5 호수 만들기
    int[][] hosu = new int[5][5];
    //2. Random을 통해서 물고기 배치
    int fishCount = 0;
    int[] input = new int[2];
    fishCount = randomFish(hosu);
    hosuPrint(hosu, input, false);
    //캐스팅
    input(input, sc);
    System.out.println(input[0] + "," + input[1]);
    //물고기 확인
    fishCount = fishCheck(hosu, input, fishCount);
    while (fishCount > 0) {
      int num = newsInput(sc);
      newsMove(num, input);
      //물고기체크
      fishCount = fishCheck(hosu, input, fishCount);
      //출력
      hosuPrint(hosu, input, true);
    }
    System.out.println("낚시게임을 종료합니다.");
  }

}
