package mega.backend_onemore.Day21;

import java.util.Random;
import java.util.Scanner;

/*
객체 있고 없고 여부를 나타내도록 수정, 클래스화 진행하지 않으면 전부 땡임.
물고기의 역할 x
낚시꾼 클래스 - 캐스팅, 이동 전부 가져간다.
호수 - 물고기를 줘야 한다. 낚시꾼 가방에 물고기 채울 수 있게 만들어줘야 함.
- 물고기는 호수가 가지고 있어야 하며,
- 낚시꾼이 캐스팅 해서 그 위치로 가면 호수가 물고기 존재 여부를 줘서
낚시꾼 가방에 물고기 채울 수 있게 만들어줘야 함. 다 차면 끝내면 된다.
 */
/*
다시 역할 정리
물고기 > 역할 x
호수 > 물고기 5X5 배열, 물고기 객체를 3개 만들어서 랜덤하게 배치
      물고기 5X5 배열 출력, 물고기를 낚시꾼에게 전달
      낚시꾼에게 물고기가 전달되면 null로 변경
낚시꾼 > 캐스팅, 호수가 주는 물고기 받기, 위 아래 왼쪽 오른쪽 이동,
        물고기 게임 종료 체크*물고기 담는 통이 다 차면 된다.
 */
/* cf. 알아두기
자료형 타입 instance of 객체
 */
class Fish { // 하는 거 없음. 객체 만들어서 배열에 들어가기만 하면 되기 때문.
}

class Lake {

  // 5*5 배열 만들기
  Fish[][] lake = new Fish[5][5];

  Lake() { // 물고기 배치 집어넣기
    // 물고기 배치는 한 번만 하면 되기 때문에 굳이 메서드가 필요하지 않다.
    // 그냥 생성자에 넣고 한번만 하자.
    Random r = new Random();
    int fishCount = 0;
    while (fishCount < 3) {
      int h = r.nextInt(5); //행 랜덤
      int y = r.nextInt(5); //열 랜덤
      if(lake[h][y] == null) {
        lake[h][y] = new Fish(); // 들어가지 않았으면 나머지는 null 이 되겠지.
        fishCount++;
      }
    }
  }

  // 처음엔 프린트를 한 번으로 하려고 생각했으나,
  // Before에는 캐스팅 전 상황이기 때문에 int[] position을 받아올 수가 없었따.
  void lakeBeforePrint() { // 캐스팅 전 상태 출력
    for(int i = 0; i<lake.length; i++) {
      for (int j= 0; j< lake[i].length; j++) {
        if (lake[i][j] == null) {
          System.out.print("o");
        }
        else {
          System.out.println("●");
        }
      }
      System.out.println();
    }
  }

  void lakeAfterPrint(int[] position) { // 낚시꾼의 좌표값.
    for (int i = 0; i<lake.length; i++) {
      for (int j = 0; j<lake[i].length; j++) {
        if (position[0] == i && position[1] == j) {
          System.out.println("X"); //사용자의 위치
        }
        else if (lake[i][j] == null) {
          System.out.println("O");
        }
        else {
          System.out.println("●");
        }
      }
      System.out.println();
    }
  }

  /*
  물고기 확인이 가장 복잡,
  물고기 확인하러 가서, position에 입력된 것을 줘요. 호수한테,
  그럼 거기에 입력되어 있는 것을 낚시꾼에게 줘야해요.
  낚시꾼이 자기 것에 넣고, 그다음에 호수에서 null 작업이 들어가야 해요.
   즉, 호수가 주고, 낚시꾼이 받고, 그다음에 null.
   */

  // 얘가 주고(물고기를 낚시꾼에게 주는 것)
  Fish giveFish(int[] position) { // 물고기를 줘야 하므로 Fish를 리턴.
    return lake[position[0]][position[1]];
    // null 줘도 무방하다. null인 경우도 있을 거니까.
  }

  // 얘가 null로 바꿔주고.
  void nullChange(int[] position) {
    lake[position[0]][position[1]] = null;
  }
}

class Person {
  int[] position = new int[2]; // 사용자의 위치.
  Fish[] bowl = new Fish[3]; // 물고기 담을 통 생성한 것.
  Scanner sc = new Scanner(System.in);

  Person() {
    // 두 번째 방법은,
    // 캐스팅은 한 번만 쓰는 것이므로, 메서드로 따로 뺄 수도 있다.
    while (true) {
      System.out.print("행 입력 : ");
      position[0] = sc.nextInt();
      System.out.print("열 입력 : ");
      position[1] = sc.nextInt();

      if (position[0]> -1 && position[0] < 5 && position[1]> -1 && position[1]<5) {
        break;
      }
      System.out.println("잘못된 입력입니다.");
    }
    System.out.println(position[0] + ", " +position[1]);
  }



  void receiveFish(Fish fish) { // 물고기를 받아워야 함.
    if (fish != null) {
      System.out.println("물고기를 잡았습니다.");
    }

    // 얘가 받고
    // 물고기 bowl을 돌면서 null인 공간에 물고기가 들어갈 테니까(잡았으니),
    // 그다음 턴을 돌 때는 0번에서 넘어가고 1번 되는 등...
    for (int i = 0; i<bowl.length; i++ ) {
      if (bowl[i] == null) {
        bowl[i] = fish;
        //이렇게 되면 null인데 null 넣으면 그냥 넘어가는 거고
        // 객체 있으면 넣어주고, 그 다음 텀 부터는 넘어가서 다른 공간에 채워주고
        // 이 두 가지를 한꺼번에 써줄 수 있다는 말.
        break;
      }
    }
  }

  // 게임 종료 로직
  boolean checkFish() {
    for (int i = 0; i<bowl.length; i++) {
      if (bowl[i] == null) { // 게임이 계속되어야 한다.
        return true;
      }
    }
    return false; // null이 없을 때, 다 찬 것.
  }

  void move() {
    System.out.print("1. 위 2. 아래 3. 왼쪽 4. 오른쪽 : ");
    int moveNum = sc.nextInt();
    if(moveNum == 1) {
      position[0]--;
      if(position[0]<0) {
        System.out.println("더이상 위로 움직일 수 없습니다.");
        position[0] = 0;
      }
    }
    else if(moveNum == 2) {
      position[0]++;
      if(position[0]>4) {
        System.out.println("더이상 아래로 움직일 수 없습니다.");
        position[0] = 4;
      }
    }
    else if(moveNum == 3) {
      position[1]--;
      if(position[1]<0) {
        System.out.println("더이상 왼쪽으로 움직일 수 없습니다.");
        position[1] = 0;
      }
    }
    else if(moveNum ==4) {
      position[1]++;
      if(position[1]>4) {
        System.out.println("더이상 오른쪽으로 움직일 수 없습니다.");
        position[1] = 4;
      }
    }
    else {
      System.out.println("잘못된 입력입니다.");
    }
  }

}

public class Q3 {

  public static void main(String[] args) {
    Lake hosu = new Lake(); // 이거 하는 순간 랜덤 물고기 배치까지 끝(생성자에서 했으니까)
    hosu.lakeBeforePrint(); // 캐스팅 전 물고기 출력

    // 캐스팅 위해 물고기 객체 생성
    Person person = new Person(); // 물고기 캐스팅 끝
    // 물고기 확인
    int[] position = person.position; // 낚시꾼의 위치를 저장.

    Fish f = hosu.giveFish(position);
    person.receiveFish(f); // 물고기 받기
    // person.receiveFish(person.givefish(human.position); 이게 위에꺼 뜯은 것.
    hosu.nullChange(position); // human.position 지금 변수에 집어넣었기 때문에
    // 괄호 속에 position만 들어가는 게 가능해짐.

    while (person.checkFish()) {
      person.move();
      person.receiveFish(hosu.giveFish(position));
      hosu.nullChange(position);
      hosu.lakeAfterPrint(position);
    }
    System.out.println("낚시게임을 종료합니다.");
  }
}
