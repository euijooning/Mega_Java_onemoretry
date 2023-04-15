package mega.backend_onemore.Day11.Prac11;

import java.util.Random;
import java.util.Scanner;

public class Q3_HomeWork {
  public static void main(String[] args) {
//   비어있다: 0   // 물고기가 있다: 1 / 물고기 위치: F 로 표시

    // 배열 생성과 물고기 개수 세팅
    int[][] lake = new int[5][5];
    int fish = 3; // 물고기 수 : 3마리

    // 물고기 3마리를 랜덤한 위치에 위치시킨다 (사전준비)
    Random r = new Random();
    Scanner sc = new Scanner(System.in);


    // 물고기 위치 랜덤으로 배치하기
    for (int i = 0; i < fish; i++) {
      int row = r.nextInt(5); // 배열 행
      int col = r.nextInt(5); // 배열 열

      if (lake[row][col] == 0) { // 물고기가 없으면
        lake[row][col] = 1; // 채운다
      } else {
        i--; // 있으면 거기서 뺌
      }
    }
    int row = 0;
    int col = 0; // 사용자 위치 초기값 세팅

// 물고기 3마리를 다 잡을 때까지 아래 과정을 반복한다:
    while (fish > 0) { // 물고기가 계속 존재하고 있을 때 반복
//            //      사용자에게 안내문구를 출력
      System.out.print("이동할 위치를 선택하세요.> 1.위 2.아래 3.오른쪽 4.왼쪽 \n : ");
      int input = sc.nextInt();

      // 사용자의 입력에 따라 위치를 이동시킨다
      if (input == 1) { // 위로 이동
        if (row == 0) { // 검사 (가장 위에 있는 경우)
          System.out.println("다시 입력하세요!");
          continue; // 다시 입력하기 위해 전단계로
        }
        row--;

      } else if (input == 2) { // 아래 이동(가장 아래에 있는 경우)
        if (row == 4) { // 검사
          System.out.println("다시 입력하세요!");
          continue;
        }
        row++;

      } else if (input == 3) { // 오른쪽
        if (col == 4) { // 검사
          System.out.println("다시 입력하세요!");
          continue;
        }
        col++;

      } else if (input == 4) { // 왼쪽
        if (col == 0) { // 검사
          System.out.println("다시 입력하세요!");
          continue;
        }
        col--;

      } else {
        System.out.println("잘못된 입력입니다. 숫자를 다시 입력하세요.");
        continue;
      }

      // 사용자가 이동한 곳에 물고기가 있는지 검사
      if (lake[row][col] == 1) {
        // 만약 사용자가 이동한 곳에 물고기가 있으면 물고기를 잡는다
        fish--; // 물고기 잡기
        lake[row][col] = 0; // 물고기 개수 줄어듦
        System.out.println("축하합니다. 물고기를 잡으셨어요!");
      }

      // 현재 호수 상태 출력
      for (int i = 0; i<lake.length; i++) {
        for (int j =0; j<lake[i].length; j++) {
          if (i == row && j == col) { // 사용자 위치
            System.out.print('X');
          } else if (lake[i][j] == 0) { // 비어있음
            System.out.print('O');
          } else if (lake[i][j] == 1) { // 물고기 있음
            System.out.print('F');
          }
        }
        System.out.println();
      }
    }
    System.out.println("게임을 종료합니다. 과제 너무 어렵습니다. 틀린 부분이 너무 많은 것 같네요ㅠㅠ");
  }
}
