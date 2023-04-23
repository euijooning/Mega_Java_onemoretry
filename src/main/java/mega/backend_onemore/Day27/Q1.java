package mega.backend_onemore.Day27;
// 스타크래프트 문제
/*
나머지 클래스
Unit을 추상클래스로 하고, 여기에 필드 초기화, 생성자에 필드들 다 때려박음
print() 도 추상 메서드로 구현해놓음.

저글링 클래스는 유닛 클래스를 상속받고,
생성자에 super() 안에 값 다 때려 박음.
print 메서드 여기서 구현
// 히드라 클래스, 마린 클래스 모두 동일함.

<공격 구현하기>
[테란 클래스]
1. 마린 3마리 객체 배열
2. 공격 순서를 위한 턴 만들기
3. 공격을 당하는 기능
4. 공격을 하는 기능
5. 공격을 당한 후에 에너지가 0이면 null로 변경하는 기능
6. 게임 종료를 알려주는 기능

[저그 클래스]
1. 저글링 / 히드라 만들기 -> 배열 / 생성자에서 초기화
2. 턴 나타내기
3. 공격을 당하는 저글링 또는 히드라 기능
4. 공격을 하는 기능
5. 에너지 체크. 공격을 당한 후, 에너지가 0이면 null로 변경하는 기능.
6. 게임 종료를 알려주는 기능.

<main>
1. 테란 객체와 저그 객체 생성
2. 공격 횟수 초기화(1)
3. 반복문(테란&&저그 게임오버체크)
3-1. 테란 공격 => 저그가 끝나면, 테란 승리 선언 후 continue
3-2. 저그 공격 => 테란이 끝나면 저그 승리 선언
아상 끝.
 */

abstract class Unit {

  int price; // 가격
  int hp; // 에너지
  int attack; //공격력
  int defence; // 방어력
  String target; // 타깃
  double speed; // 스피드
  String characteristic; // 생체

  Unit(int price, int hp, int attack, int defence, String target,
      double speed, String characteristic) {
    this.price = price;
    this.hp = hp;
    this.attack = attack;
    this.defence = defence;
    this.target = target;
    this.speed = speed;
    this.characteristic = characteristic;
  }

  abstract void print();
}

class Juggling extends Unit {

  Juggling() {
    super(50, 35, 5, 0, "지상", 2.612, "지상,소형,생체");
  }

  void print() {
    System.out.println("저글링의 생산비용은 미네랄 :" + price + ", 체력: " + hp +
        ", 공격력: " + attack + " 방어력: " + defence +
        "\n, 공격대상: " + target + ", 이동속도: " + speed + ", 유닛특성: "
        + characteristic);
  }
}

class Hydra extends Unit {

  Hydra() {
    super(100, 80, 10, 0, "지상,공중", 1.741, "지상,중형,생체");
  }

  void print() {
    System.out.println("히드라의 생산비용은 미네랄 :" + price + ", 체력: " + hp
        + ", 공격력: " + attack + " 방어력: " + defence +
        "\n, 공격대상: " + target + ", 이동속도: " + speed +
        ", 유닛특성: " + characteristic);
  }
}

class Marine extends Unit {

  Marine() {
    super(50, 50, 6, 0, "지상,공중", 1.875, "지상,소형,생체");
  }

  void print() {
    System.out.println("마린의 생산비용은 미네랄 :" + price + ", 체력: " + hp
        + ", 공격력: " + attack + " 방어력: " + defence +
        "\n, 공격대상: " + target + ", 이동속도: " + speed +
        ", 유닛특성: " + characteristic);
  }
}

// 테란
class Terran {

  //1. 마린 3마리 객체 배열
  Marine[] mar = new Marine[4];
  //2. 공격순서를 위한 턴
  int turn = 0;

  // 생성자 통해 테란 객체 채우기
  Terran() {
    for (int i = 0; i < mar.length; i++) {
      mar[i] = new Marine();
      mar[i].print(); // 상태출력
    }
  }

  //3. 공격을 당하는 기능
  void beAttacted(Unit u) { // 부모 unit을 상속받아서
    for (int i = 0; i < mar.length; i++) {
      if (mar[i] != null) { // 객체가 있으면(살아있으면)
        System.out.println("마린" + i + "번째가 공격을 당합니다.");
        mar[i].hp -= u.attack; // 체력 감소시키고
        break; // 나감.
      }
    }
  }

  //4. 공격을 하는 기능
  Marine attackZerg() { // 선택당한 애를 끄집어내서 너 나가서 싸워 할 거다.
    // 마린 중에서 누가 나갈지 정하기
    if (mar[0] != null || mar[1] != null || mar[2] != null || mar[3] != null) {
      while (mar[turn % mar.length] == null) { // 이번 턴에 나가서 공격해야하는 주인공이 죽었으면
        turn++; // 턴을 하나씩 증가
        // [turn % mar.length]는 아무리 커도, 배열의 원소만큼만 나오면 되므로, 나머지 연산자를 활용!!!
      }
      System.out.println("마린의 " + turn % mar.length + "번째가 공격을 합니다.");
      return mar[turn++ % mar.length]; // 후치니까 당시에는 그냥 나가고, 하나 증가해있음!!
    } else {
      return null; // 다 죽은 상태.
    }
  }

  //5. 공격을 당한 후에 에너지가 0이면 null로 변경하는 기능
  void energyCheck() {
    for (int i = 0; i < mar.length; i++) {
      if (mar[i] != null && mar[i].hp <= 0) { // 객체는 존재하는데 체력이 제로인 경우
        System.out.println("마린" + i + "번째가 사망했습니다.");
        mar[i] = null; // 친절하게 죽여드림.
        // 모든 객체들을 다 체크해야하므로 굳이 break가 필요가 없다.
      }
    }
  }

  //6. 게임 종료를 알려주는 기능
  boolean gameOverCheck() {
    for (int i = 0; i < mar.length; i++) {
      if (mar[i] != null) { // 살아있는 경우
        return true; // 게임 계속 진행
      }
    }
    return false; // 죽은 경우 게임 종료!
  }
}

//[저그 클래스]
class Zerg {
  //1. 저글링 / 히드라 만들기 -> 배열 / 생성자에서 초기화
  Unit[] zg = new Unit[2];
  //2. 턴 나타내기
  int turn = 0;

  // 생성자
  Zerg() {
    zg[0] = new Juggling(); // 저글링
    zg[1] = new Hydra(); // 히드라

    // 출력을 위한 for문
    for (int i = 0; i<zg.length;i++) {
      zg[i].print();
    }
  }

  //3. 공격을 당하는 저글링 또는 히드라 기능
  void beAttacked(Marine mar) { // 마린인 게 확실하니까 마린 넘어와도 됨.
    for(int i = 0;i<zg.length;i++) {
      if(zg[i] != null) { // 객체가 있을 때
        if(i == 0) { // 저글링
          System.out.println("저글링이 공격을 당합니다.");
          zg[i].hp -= mar.attack; // 저글링 체력 감소
          break;
        }
        else { // 히드라
          System.out.println("히드라가 공격을 당합니다.");
          zg[i].hp -= mar.attack; // 히드라 체력 감소
          break;
        }
      }
    }
  }

//4. 공격을 하는 기능
  Unit attackZerg() {
    if (zg[0] != null || zg[1] != null) { // 객체가 있을 때
      while (zg[turn % zg.length] == null) {   // 이번 턴에 나가는 공격선봉장 저그 죽었으면
        turn++ ; //턴을 하나 증가시킴
      }
      if (turn % zg.length ==0) {
        System.out.println("저글링이 공격을 합니다.");
      }
      else {
        System.out.println("히드라가 공격을 합니다.");
      }
      return zg[turn++ % zg.length]; // 역시 해당 턴에는 그대로, 다음 턴 가기 전에 하나 증가해서
    }
    else {
      return null; // 역시 다 죽은 경우
    }
  }

  //5. 에너지 체크. 공격을 당한 후, 에너지가 0이면 null로 변경하는 기능.
  void energyCheck() {
    for (int i = 0; i< zg.length; i++) {
      if (zg[i] != null && zg[i].hp <= 0) { // 객체가 있는데 hp가 안 남아있는 경우
        if (i == 0) { // 저글링
          System.out.println("저글링이 사망했습니다.");
        }
        else { // 히드라
          System.out.println("히드라가 사망했습니다.");
        }
        zg[i] = null; // 둘 중 해당하는 것을 null로 바꿔눔
      }
    }
  }

  /*
  cf. 사망을 Unit에 메서드로 정의해놓고 각 클래스에서 호출해다 쓰면
  더 편하게 구현을 할 수 있을 듯(하지만 어려워)
   */

  //6. 게임 종료를 알려주는 기능.
  boolean gameOverCheck() {
    for (int i = 0; i< zg.length; i++) {
      if (zg[i] != null) { // 객체가 살아있으면
        return true; // 계속되어야 함.
      }
    }
    return false; // 다 죽었으므로 게임 탈출
  }
}



public class Q1 {

  // 여기서는 싸움만 시키면 됨.
  public static void main(String[] args) {
    //1. 테란 객체와 저그 객체 생성
    Terran terran = new Terran();
    Zerg zerg = new Zerg();

    //2. 공격 횟수 초기화(1)
    int count = 1;
    //3. 반복문(테란&&저그 게임오버체크)
    while (terran.gameOverCheck() && zerg.gameOverCheck()) {
      // 하나라도 죽으면 끝나야하기때문에, &&조건.

      //3-1. 테란이 (저그를) 공격 => 저그가 끝나면, 테란 승리 선언 후 continue
      System.out.println((count++) + "턴 테란의 공격");
      zerg.beAttacked(terran.attackZerg());
      //terran.attackZerg()는 테란! 저그를 공격(저그는 공격당함)

      zerg.energyCheck(); //저그가 죽었는지 여부 판단

      if (!zerg.gameOverCheck()) { // !zerg.gameOverCheck()는 테란 승리를 의미
        System.out.println("테란이 승리했습니다.");
        continue; // 저그 승리 여부를 굳이 확인 안 해도 되니까.
      }

      //3-2. 저그가 (테란을) 공격 => 테란이 끝나면 저그 승리 선언
      System.out.println((count++) + "턴 저그의 공격");
      terran.beAttacted(zerg.attackZerg());  //zerg.attackZerg()는 저그!
      // 저그가 테란을 공격(테란은 공격 당함)

      terran.energyCheck(); // 테란 에너지 체크 하고
      if (!terran.gameOverCheck()) { // !terran.gameOverCheck()는 저그 승리 의미
        System.out.println("저그가 승리했습니다.");
      }
    }

  }
}
