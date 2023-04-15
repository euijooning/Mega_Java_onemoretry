package mega.backend_onemore.Day15.Prac15;

import java.util.Scanner;

public class Q1_my {
  public static void main(String[] args) {
    run(new Scanner(System.in));
  }

  private static void run(Scanner sc) {
    // 좌석은 총 18 / 9행 2열
    int[][] seat = new int[9][2];  //[8][1]
    int count = 18;

    while (count > 0) {
      int[] hy = inputHy(sc, count);
      int h = hy[0];
      int y = hy[1];

      //잘못된 입력
      if (!validHy(h, y)) {
        continue;
      }

      //예약 여부확인
      if (isEmpty(seat, h, y)) {
        System.out.println("예약이 완료 됐습니다.");
        count--;
        seat[h - 1][y - 1]++;
      } else {
        printEmptySeats(seat);
      }
    }

    System.out.println("모든 자리가 예약됐습니다.");
  }

  private static boolean isEmpty(int[][] seat, int h, int y) {
    return seat[h - 1][y - 1] == 0;
  }

  static int[] inputHy(Scanner sc, int count) {
    System.out.println("예약하실 좌석을 입력해주세요(총" + count + "석)");
    System.out.print("행 : ");
    int h = sc.nextInt();
    System.out.print("열 : ");
    int y = sc.nextInt();

    int[] hy = {h, y};
    return hy;
  }

  static boolean validHy(int h, int y) {
    if (h < 1 || h > 9 || y > 2 || y < 1) {
      System.out.println("잘못된 입력입니다.");
      return false;
    }

    return true;
  }

  static void printEmptySeats(int[][] seat) {
    System.out.println("비어있는 좌석 ");
    for (int i = 0; i < seat.length; i++) {
      for (int j = 0; j < seat[i].length; j++) {
        if (seat[i][j] == 0) {
          System.out.println("행 : " + (i + 1) + "열 : " + (j + 1));
        }
      }
    }
  }


}
