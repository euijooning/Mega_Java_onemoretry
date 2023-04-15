package mega.backend_onemore.Day11.Prac11;

import java.util.Random;
import java.util.Scanner;

public class Q3_HWver02 {
  static void run() {
    Scanner sc = new Scanner(System.in);
    Random r = new Random();

    //1. 5X5 호수 만들기
    int[][] hosu = new int[5][5];
    int fishCount = 3; // 여러군데서 다 쓰고 있으므로, 그냥 main문에서 한꺼번에 선언(유연하게 쓰려고 3으로 바꿈)

    //2. Random을 통해서 물고기 배치
    setFish(r, hosu, fishCount);


    // 3. 호수의 잡기 전 상태 출력
    printHosuBeforeCasting(hosu);

    //4. 캐스팅
    int[] hy = castFish(sc);// 배열로 받아야 하므로 형태 살짝 변환, 그리고 요소 하나씩 꺼내준다.
    int h = hy[0];
    int y = hy[1];

    // 5. 물고기를 잡은 후 현재 호수의 상태 출력
    printHosuAfterCasting(hosu, h, y);

    // 6. 내가 캐스팅한 자리에 물고기 있는지 확인
    if (checkFish(hosu, h, y)) {
      hosu[h][y] = 0;
      fishCount--; // 메서드에서는 체크만 하고, 여기서 물고기 수를 직접 빼버린다.
    }

    // 7. 이동
    while (fishCount > 0) {
      System.out.print("1. 위 2. 아래 3. 왼쪽 4. 오른쪽 : ");
      int num = sc.nextInt();
      hy = moveLocation(num, h, y); // 아예 하나의 동작으로 합쳐버리기
      h = hy[0];
      y = hy[1];


      //7. 또 물고기 확인 => 이것은 위의 함수 그대로 활용할 수 있음.
      if (checkFish(hosu, h, y)) {
        hosu[h][y] = 0;
        fishCount--; // 메서드에서는 체크만 하고, 여기서 물고기 수를 직접 빼버린다.
      }

      //8. 출력 => 이것 역시 위에서 메서드로 분리해놨으니, 그대로 사용 가능
      printHosuAfterCasting(hosu, h, y);
    }
    System.out.println("낚시게임을 종료합니다.");
  }

  static void setFish(Random r, int hosu[][], int fishcount) { // 호수는 참조형이므로, 값을 받을 때 주소가 복사된다.(원본 값 변경)
    //<변동> fishcount를 밖으로 뺐으므로, 3 대신에 아예 fishcount로 바꿔서 더 유연하게 사용.
    int i = fishcount;

    while (i < fishcount) {
      int h = r.nextInt(5); //행 랜덤
      int y = r.nextInt(5); //열 랜덤
      if (hosu[h][y] == 0) {
        hosu[h][y] = 1; // 호수 배열 값을 세팅 중. 그런데 배열은 primitive x.
        i++; // 얘는 원본의 값을 바꿨으므로,

        /*
        여기서는 호수에 물고기가 배치된 결과를 돌려주길 바라는데(호수를 돌려주길),
        호수는 클래스지. 리턴을 주지 않아도 여기서 바꾸면 밖에서도 영향을 받는다.
        (Call by Reference)
        따라서 void 가능
         */
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
  /*
  요기서는 반드시 호수를 입력을 받아야 한다.
  만약 메서드 내부에서 새로 호수를 만들게 되면, 이 때 호수는
  메서드 밖에서 보는 호수와 다르다(새로 만들어진 것이니까)
  출력만 하므로 리턴값이 따로 필요가 없다.
   */

  static int[] castFish(Scanner sc) {
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

    int[] hy = new int[2];
    return hy;
  }
  /*
Scanner는 위에서 만들었으므로 받아오기만 하면 될 것 같고,
아래 다른 코드들을 보니까, h랑 y는 계속 쓰이고 있음.
그렇다면, h와 y는 계속 쓸 수 있도록 리턴을 반드시 해줘야 함.
근데 리턴은 하나만 해줄 수 있으므로, 배운 것처럼 배열 활용
 */


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
  /*
  얘도 상태출력하는 메서드 이므로 따로 리턴값은 필요 없어 보임.
   */

  static boolean checkFish(int[][] hosu, int h, int y) {
    if (hosu[h][y] == 1) {
      System.out.println("물고기를 잡았습니다.");
      //hosu[h][y] = 0;
      //fishCount--; 이 두개는 밖으로 뺀다. 여기는 단순 check만.
      return true;
    }
    return false;
  }
  /*
  여기서는 물고기 개수 변화에 대해 바로바로 변동값을 어떻게 전달할 것이냐는 문제가 생긴다.
  이 메서드에서 물고기를 잡아서 개수를 변동시켜도
  main에서는 아무 영향이 없으니까.
  따라서 이 메서드에서는 개수를 감소시키는 게 아니라 잡았는지 여부만 판단시킨다 .
  좋은 방법은 boolean
   */

  static int moveUpstair(int h) {
    if (h < 0) {
      System.out.println("더이상 위로 움직일 수 없습니다.");
      h = 0; //다시 움직일 수 있는 위치로 복귀시킴
    }
    return h;
  }
  /*
  h를 밖에까지 영향을 미치게 해야하므로 리턴 값을 명시적으로 줘야 한다.
  아니면 static으로 빼거나.
   */

  static int moveDownstair(int h) {
    if (h > 4) {
      System.out.println("더이상 아래로 움직일 수 없습니다.");
      h = 4;
    }
    return h;
  }

  static int moveLeft(int y) {
    if (y < 0) {
      System.out.println("더이상 왼쪽으로 움직일 수 없습니다.");
      y = 0;
    }
    return y;
  }

  static int moveRight(int y) {
    if (y > 4) {
      System.out.println("더이상 오른쪽으로 움직일 수 없습니다.");
      y = 4;
    }
    return y;
  }

  static int[] moveLocation(int num, int h, int y) {
    if (num == 1) {
      h--;
      h = moveUpstair(h);

    } else if (num == 2) {
      h++;
      h = moveDownstair(h);

    } else if (num == 3) {
      y--;
      y = moveLeft(y);

    } else if (num == 4) {
      y++;
      y = moveRight(y);

    } else {
      System.out.println("잘못된 입력입니다.");
    }
    int[] hy = {h,y};
    return hy;
  }


  public static void main(String[] args) {
    run();

  }

}
