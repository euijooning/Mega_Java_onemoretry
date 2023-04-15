package mega.backend_onemore.Day11.Prac11;

/*
1. 호수 배열 만들기
2. 랜덤 수 2개 만들어 물고기 배치(fishcount<3 일 때 반복)
=> 호수의 i,j 자리가 0이면, 그 자리는 하나씩 늘어나고 fishcount++;
3. 실제 물고기를 잡기
3-1. 행과 열 입력받기(스캐너)
3-2. 잘못된 입력 출력
3-3. 이중 반복문 돌면서...
3-3-1. if(h == i && y == j) : 사용자의 위치
3-3-2. else if(hosu[i][j] == 0) : 빈 위치
3-3-3. else 그렇지 않으면 물고기 있음.

4, 물고기 잡혔는지 확인
		//물고기 확인
		if(hosu[h][y] == 1) {
			System.out.println("물고기를 잡았습니다.");
			hosu[h][y] = 0;
			fishCount--;
		}

5. 사용자 이동(while (fishCount > 0))
- 이동 입력받는 스캐너 생성
=> 1번 누르면 / 2번 누르면 / 3번 누르면 / 4번 누르면 / 잘못된 입력
=> 잘못된 입력 시 위치 초기화 식 필요함.

6. 물고기 잡았는지 다시 확인
(4번 로직과 완전히 동일함)

7. 다시 출력
 */

import java.util.Random;
import java.util.Scanner;

public class Q3_T {

  public static void main(String[] args) {
    // Scanner 객체와 Random 객체 생성
    Scanner sc = new Scanner(System.in);
    Random r = new Random();

    // 1. 5X5 호수 만들기
    int[][] hosu = new int[5][5];

    // 2. Random을 통해서 물고기 배치
    int fishCount = 0;

    while (fishCount < 3) { // 물고기 3마리 배치하기
      int h = r.nextInt(5); // 행 랜덤으로 생성
      int y = r.nextInt(5); // 열 랜덤으로 생성
      if (hosu[h][y] == 0) { // 빈칸인 경우에만 물고기 배치
        hosu[h][y] = 1;
        fishCount++;
      }
    }

    // 호수 상태 출력
    for (int i = 0; i < hosu.length; i++) {
      for (int j = 0; j < hosu[i].length; j++) {
        if (hosu[i][j] == 0) {
          System.out.print("○"); // 빈칸 출력
        } else {
          System.out.print("●"); // 물고기 출력
        }
      }
      System.out.println();
    }

    // 캐스팅 (사용자 입력 받기)
    int h;
    int y;
    while (true) { // 적절한 좌표를 입력할 때까지 반복
      System.out.print("행 입력 : ");
      h = sc.nextInt();
      System.out.print("열 입력 : ");
      y = sc.nextInt();

      if (h > -1 && h < 5 && y > -1 && y < 5) { // 좌표가 유효한 경우
        break;
      }

      System.out.println("잘못된 입력입니다.");
    }

    // 입력 받은 좌표에 X 출력
    System.out.println(h + "," + y);
    for (int i = 0; i < hosu.length; i++) {
      for (int j = 0; j < hosu[i].length; j++) {
        if (h == i && y == j) {
          System.out.print("X");
        } else if (hosu[i][j] == 0) {
          System.out.print("○");
        } else {
          System.out.print("●");
        }
      }
      System.out.println();
    }

    // 물고기 확인
    if (hosu[h][y] == 1) {
      System.out.println("물고기를 잡았습니다.");
      hosu[h][y] = 0; // 물고기 잡음
      fishCount--;
    }

    // 물고기를 다 잡을 때까지 반복
    while (fishCount > 0) {
      System.out.print("1. 위 2. 아래 3. 왼쪽 4. 오른쪽 : ");
      int num = sc.nextInt(); // 이동 방향 입력 받기
      if (num == 1) { // 위로 이동
        h--;
        if (h < 0) {
          System.out.println("더이상 위로 움직일 수 없습니다.");
          h = 0; //다시 움직일 수 있는 위치로 복귀시킴
        }
      } else if (num == 2) { // 아래로 이동
        h++;
        if (h > 4) {
          System.out.println("더이상 아래로 움직일 수 없습니다.");
          h = 4; //다시 움직일 수 있는 위치로 복귀시킴
        }
      } else if (num == 3) { // 왼쪽으로 이동
        y--;
        if (y < 0) {
          System.out.println("더이상 왼쪽으로 움직일 수 없습니다.");
          y = 0; //다시 움직일 수 있는 위치로 복귀시킴
        }
      } else if (num == 4) { // 오른쪽으로 이동
        y++;
        if (y > 4) {
          System.out.println("더이상 오른쪽으로 움직일 수 없습니다.");
          y = 4; //다시 움직일 수 있는 위치로 복귀시킴
        }
      } else { // 잘못된 입력 처리
        System.out.println("잘못된 입력입니다.");
      }
      //물고기체크
      if (hosu[h][y] == 1) {
        System.out.println("물고기를 잡았습니다.");
        hosu[h][y] = 0;
        fishCount--;
      }
      //출력
      for (int i = 0; i < hosu.length; i++) {
        for (int j = 0; j < hosu[i].length; j++) {
          if (h == i && y == j) {
            System.out.print("X"); // 캐스팅 위치 표시
          } else if (hosu[i][j] == 0) {
            System.out.print("○"); // 물고기가 없는 칸 표시
          } else {
            System.out.print("●"); // 물고기가 있는 칸 표시
          }
        }
        System.out.println();
      }
    }
    System.out.println("낚시게임을 종료합니다.");

  }

}

