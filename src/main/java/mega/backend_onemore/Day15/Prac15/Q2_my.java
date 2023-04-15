package mega.backend_onemore.Day15.Prac15;

import java.util.Random;
import java.util.Scanner;

public class Q2_my {

  public static void main(String[] args) {
    run();
  }

  static void run() {

    Scanner sc = new Scanner(System.in);
    Random r = new Random();

    //1. 5X5 호수 만들기
    int[][] hosu = new int[5][5];

    //2. Random을 통해서 물고기 배치
    int fishCount = 3;
    setFish(r, hosu, fishCount);
    printHosuBeforeCasting(hosu);

    //캐스팅
    int[] hy = casting(sc);
    int h = hy[0];
    int y = hy[1];

    printHosuAfterCasting(hosu, h, y);

    //물고기 확인
    if (checkFish(hosu, h, y)) {
      hosu[h][y] = 0;
      fishCount--;
    }

    while (fishCount > 0) {
      System.out.print("1. 위 2. 아래 3. 왼쪽 4. 오른쪽 : ");
      int num = sc.nextInt();
      hy = move(num, h, y);
      h = hy[0];
      y = hy[1];

      //물고기체크
      if (checkFish(hosu, h, y)) {
        hosu[h][y] = 0;
        fishCount--;
      }

      //출력
      printHosuAfterCasting(hosu, h, y);
    }
    System.out.println("낚시게임을 종료합니다.");
  }

  private static int checkRight(int y) {
    if (y > 4) {
      System.out.println("더이상 오른쪽으로 움직일 수 없습니다.");
      y = 4;
    }
    return y;
  }

  private static int checkLeft(int y) {
    if (y < 0) {
      System.out.println("더이상 왼쪽으로 움직일 수 없습니다.");
      y = 0;
    }
    return y;
  }

  private static int checkDown(int h) {
    if (h > 4) {
      System.out.println("더이상 아래로 움직일 수 없습니다.");
      h = 4;
    }
    return h;
  }

  static void setFish(Random r, int[][] hosu, int fishCount) {
    int i = 0;
    while (i < fishCount) {
      int h = r.nextInt(5); //행 랜덤
      int y = r.nextInt(5); //열 랜덤
      if (hosu[h][y] == 0) {
        hosu[h][y] = 1;
        i++;
      }
    }
  }

  static void printHosuBeforeCasting(int[][] hosu) {
    for (int i = 0; i < hosu.length; i++) {
      for (int j = 0; j < hosu[i].length; j++) {
        if (hosu[i][j] == 0) {
          System.out.print("○");
        } else {
          System.out.print("●");
        }
      }
      System.out.println();
    }
  }

  static int[] casting(Scanner sc) {
    int h;
    int y;
    while (true) {
      System.out.print("행 입력 : ");
      h = sc.nextInt();
      System.out.print("열 입력 : ");
      y = sc.nextInt();

      if (h > -1 && h < 5 && y > -1 && y < 5) {
        break;
      }

      System.out.println("잘못된 입력입니다.");
    }

    System.out.println(h + "," + y);

    int[] hy = {h, y};
    return hy;
  }

  static void printHosuAfterCasting(int[][] hosu, int h, int y) {
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
  }

  static boolean checkFish(int[][] hosu, int h, int y) {
    if (hosu[h][y] == 1) {
      System.out.println("물고기를 잡았습니다.");
      return true;
    }
    return false;
  }

  static int checkUp(int h) {
    if (h < 0) {
      System.out.println("더이상 위로 움직일 수 없습니다.");
      h = 0; //다시 움직일 수 있는 위치로 복귀시킴
    }
    return h;
  }

  static int[] move(int num, int h, int y) {
    if (num == 1) {
      h--;
      h = checkUp(h);
    } else if (num == 2) {
      h++;
      h = checkDown(h);
    } else if (num == 3) {
      y--;
      y = checkLeft(y);
    } else if (num == 4) {
      y++;
      y = checkRight(y);
    } else {
      System.out.println("잘못된 입력입니다.");
    }
    int[] hy = {h, y};
    return hy;
  }

}
