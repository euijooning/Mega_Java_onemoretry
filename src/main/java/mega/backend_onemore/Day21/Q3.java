package mega.backend_onemore.Day21;

import java.util.Random;
import java.util.Scanner;

/*
idea
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
  // 사실상 Fish는 하는 것 없는데, 그냥 이름 붙이기용이라고 봐야할 것이다.
  //"물고기가 있는 호수다" 느낌을 주기 위함 같음.
  // 결정적인 차이를 생각해보면 기본자료형과 참조자료형의 차이인데,
  // 참조자료형은 null을 가질 수 있기 때문에,
  // 잡았는지 못 잡았는지를 null로 편하게 표현하려고 사용.
  // 만약 int로 표현하고, 잡았으면 count-1로 표현하겠다고 하면 클래스 형태가 필요가 없겠죠.
  // 즉, 정리하자면 이름도 붙이고 싶고, 잡았단 표시도 null로 명확하게 할 수 있으니까.

  Lake() { // 물고기 배치 집어넣기
    // 물고기 배치는 한 번만 하면 되기 때문에 굳이 메서드가 필요하지 않다.
    // 그냥 생성자에 넣고 한번만 하자.
    Random r = new Random();
    int fishCount = 0;
    while (fishCount < 3) {
      int h = r.nextInt(5); //행 랜덤
      int y = r.nextInt(5); //열 랜덤
      if(lake[h][y] == null) { // 물고기가 없는 경우에만
        lake[h][y] = new Fish(); // 그 위치에 물고기를 채워줌
        // 들어가지 않았으면 나머지는 null 이 되겠지.(22칸)
        fishCount++; // 이 과정이 끝나면 25칸 중에 3칸만 객체가 있게 됨.
      }
    }
  }

  // 처음엔 프린트를 한 번으로 하려고 생각했으나,
  // Before에는 캐스팅 전 상황이기 때문에 int[] position을 받아올 수가 없었따.
  void lakeBeforePrint() { // 캐스팅 전 상태 출력
    for(int i = 0; i<lake.length; i++) {
      for (int j= 0; j< lake[i].length; j++) {
        if (lake[i][j] == null) { // 클래스 형태로 만들었기 때문에 없으면 null로 편하게 표현가능.
          System.out.print("o");
        }
        else {
          System.out.println("●");
        }
      }
      System.out.println();
    }
  }

  // int[] position 매개변수를 따라가보니,
  // Person의 객체에서 사용하고 있었고,
  // 더 확인해보니 Person클래스의 생성자에서
  // 낚시꾼의 좌표값 입력받을 때 배열에 저장했음을 확인할 수 있었음.
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

  // 얘가 주고(물고기를 낚시꾼에게 주는 것) 낚시꾼 입장에서는 물고기를 받는 것.
  // 호출자 입장에서는 받아 오는 거고, 메서드 입장에서는 주는 거고.
  Fish giveFish(int[] position) { // 물고기를 줘야 하므로 Fish를 리턴.
    return lake[position[0]][position[1]];
    // null 줘도 무방하다. null인 경우도 있을 거니까.
  }

  // 얘가 물고기 잡고 나서 칸을 null로 바꿔주는 역할.
  void nullChange(int[] position) {
    lake[position[0]][position[1]] = null;
  }
}

/*
Person이 하는 일
- 물고기 받기
- 물고기 확인
- 움직이기
 */
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
    if (fish != null) { // 물고기가 있는 경우에
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
        /*
        원래 물고기가 없을 때 로직이 안 도는 게 일반적이긴 한데...
        여기서 하는 일은 물고기가 없는 빈 통에 물고기를 넣는 과정.
        빈 그릇에 없는 물고기를 넣는 것도 가능.
        그렇다면 아무 의미가 없는 행동이지만, 행위는 똑같잖아.
        아무 변화 없으니까 괜찮다.(원래 null인데 null로 업데이트)

        그래서 애는 물고기가 있건 없건 동일하게 실행되어도 괜찮은 코드이다.
         */
      }
    }
  }

  // 게임 종료 로직
  boolean checkFish() { // 물고기가 들어갈 공간이 있는지 검사하는 메서드
    for (int i = 0; i<bowl.length; i++) {
      if (bowl[i] == null) { // 하나라도 빈칸이 있으면(3마리 못 잡았으면)
        return true; // 게임이 계속되어야 한다.
      }
    }
    return false; // null이 없을 때, 다 찬 것.
  }
  /*
  Tip.
  "모두 A인지를 검사하라" 라고 요구할 때, 쉽게 해결하는 방법?
  => 그 중 하나만이라도 A가 아닌지를 찾아보면 됨.
   */

  void move() {
    System.out.print("1. 위 2. 아래 3. 왼쪽 4. 오른쪽 : ");
    int moveNum = sc.nextInt();
    if(moveNum == 1) {
      position[0]--;
      if(position[0]<0) { // 천장에 닿았는지 검사
        System.out.println("더이상 위로 움직일 수 없습니다.");
        position[0] = 0; // 처음 위치로 재배치
      }
    }
    else if(moveNum == 2) {
      position[0]++;
      if(position[0]>4) { // 바닥에 닿았는지 검사
        System.out.println("더이상 아래로 움직일 수 없습니다.");
        position[0] = 4; // 처음 위치로 재배치
      }
    }
    else if(moveNum == 3) {
      position[1]--;
      if(position[1]<0) { // 왼쪽 벽에 닿았는지 검사
        System.out.println("더이상 왼쪽으로 움직일 수 없습니다.");
        position[1] = 0; // 처음 위치로 재배치
      }
    }
    else if(moveNum ==4) {
      position[1]++;
      if(position[1]>4) { // 오른쪽 벽에 담았는지 검사
        System.out.println("더이상 오른쪽으로 움직일 수 없습니다.");
        position[1] = 4; // 처음 위치로 재배치
      }
    }
    else { //1,2,3,4 입력이 아닌 경우
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

    Fish f = hosu.giveFish(position); // 낚시꾼이 있는 현재 위치에 물고기도 있는지를 확인
    person.receiveFish(f); // 물고기 받기
    // person.receiveFish(person.givefish(human.position); 이게 위에꺼 뜯은 것.
    hosu.nullChange(position);  // null로 변경해줌. 있으면 null로 변경해주고 없어도 원래 null이었으니까 괜찮아.
    // human.position 지금 변수에 집어넣었기 때문에
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
/*
    person.receiveFish(person.givefish(person.position);
    hosu.nullChange(position);
    이렇게 세팅해주면 사실 위, 아래가 같아서 읽기는 더 편해짐.
 */