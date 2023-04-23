package mega.backend_onemore.Day27.SC_Prac;

class Unit {
  String name;
  int price;
  int hp;
  int attack;
  int defense;
  String target;
  double speed;
  String characteristic;

  Unit(String name, int price, int hp, int attack, int defense, String target, double speed, String characteristic) {
    this.name = name;
    this.price = price;
    this.hp = hp;
    this.attack = attack;
    this.defense = defense;
    this.target = target;
    this.speed = speed;
    this.characteristic = characteristic;
  }

  void print() {
    System.out.println(name + "의 생산비용은  " + price + ",  체력은 " + hp + ", 공격력은 " + attack
        + ", 방어력은 " + defense + ", 공격대상은 " + target + ", 이동속도는 " + speed
        + ", 유닛특성은 " + characteristic + " 입니다.");
  }

  // 이건 공통 부모인 Unit에 둬도 될 것 같다.
  // 그러나 이것만으로는 전멸 여부를 온전히 판단하기엔 부족하므로 따로 메서드를 만든다.
  boolean isAlive() { // 죽었는지 살아있는지 여부 판단.
    return hp>0;
  }
  /*
  나는 죽었는지 살았는지 여부를 hp=0으로 판단했는데,
  변 선생님은 mar[0] == null; 처럼 배열의 null 여부로 판단했음.
   */

}

/*
그런데 전멸 여부는 클래스와 관련있는 건 아닌것 같다.
마린, 저글링, 히드라는 하나의 유닛이지 여러 유닛을 통칭하는 것은 아니므로
개별적으로 만들어서 확인해줄 필요가 있다.
 */

// 테란 요소가 두개니까 공격을 하려면 저글링, 히드라 각각 만들어줘야 했어.
// 그건 비효율적이니까, 차라리 부모 클래스를 만들어서 부모타입으로 받아오면
// 메서드를 하나로 합칠 수 있게 되겠지.

class ZergUnit extends Unit {

  ZergUnit(String name, int price, int hp, int attack, int defense, String target, double speed,
      String characteristic) {
    super(name, price, hp, attack, defense, target, speed, characteristic);
  }
}

// 저그
class Zergling extends ZergUnit {

  Zergling(String name) {
    super(name, 50, 35, 5, 0, "지상", 2.612, "지상, 소형, 생체");

  }
}

// 저그
class Hydra extends ZergUnit {

  Hydra(String name) {
    super(name, 100, 80, 10, 0, "지상, 공중", 1.741, "지상, 중형, 생체");

  }
}

// 테란
class Marine extends Unit {
  Marine(String name) {
    super(name, 50, 50, 6, 0, "지상, 공중", 1.875, "지상, 중형, 생체");
  }
}


public class StarPrac {

  public static void main(String[] args) {

    Marine[] mr = new Marine[3];
    Zergling zgl = new Zergling("저글링");
    Hydra hd = new Hydra("히드라");

    for (int i = 0; i<mr.length; i++) {
      mr[i] = new Marine("마린");
    }

    int marineAttack = mr[0].attack; // 지금 매개변수가 배열이었으니까, int로 받기 위해서 일부러 정수값을 하나 빼줬음.
    int zergAttack = zgl.attack;
    int turn = 1; // 턴을 나타내기 위함


    // 테란의 어떤 유닛의 hp > 0 && 저그의 어떤 유닛의 hp가 > 0:
    while (isTerranAlive(mr) && isZergAlive(zgl, hd)) {
      if (turn % 2 == 0) { // 턴을 번갈아가면서 하니까 짝수 나머지 연산자 활용!!!
      // 저그 공격 : 테란의 hp가 줄어든다
        System.out.println(turn + "턴 저그 공격");
        for (int i = 0; i<mr.length; i++) {
          if (mr[i].isAlive()) {
            zergAttack(mr, zergAttack);
          }
        }
      } else { // 홀수 턴
        // 테란 공격(메서드)
        // 테란의 hp가 줄어든다.
        System.out.println(turn + "턴 테란 공격");

        // 요기에 저글링이 올 수도 있고, 히드라가 올 수도 있어야 함!!!
        if (zgl.isAlive()) {  // 저글링이 살아있으면
          terranAttack(zgl, marineAttack);
        } else { // 그렇지 않으면 히드라가 살아있으면,
          terranAttack(hd, marineAttack);
        }
      }

      turn++; // 턴을 번갈아가면서 하기 위해서 끝날때마다 하나씩 증가시킴.
    }

  }

  private static void zergAttack(Marine[] mr, int damage) {
    System.out.println("저그가 공격합니다.");
    String marineUnitName = "마린";

    /*
    아래 부분이
    수업시간 코드에서는
    if (mar[0] != null || mar[1] != null || mar[2] != null || mar[3] != null) {
      while (mar[turn % mar.length] == null) { // 이번 턴에 나가서 공격해야하는 주인공이 죽었으면
        turn++; // 턴을 하나씩 증가
        // [turn % mar.length]는 아무리 커도, 배열의 원소만큼만 나오면 되므로, 나머지 연산자를 활용!!!
      }
      이것임!
     */

    System.out.println(marineUnitName + "이(가) 공격을 당합니다.");
    int marineA = 0; // 살아있는 마린의 인덱스
    // 어떤 마린을 공격해야하지? -> 대상 찾기! => 살아있는 최초의 마린 찾기
    for (int i = 0; i<mr.length; i++) {
      if (mr[i].isAlive()) { // i번째 인덱스의 마린이 살아있으면
        marineA = i; // 살아있는 마린인 얘를 공격하겠다.
        break; // 공격하고 바로 끝나야한다.
      }
    }
      mr[marineA].hp -= damage; // 공격당한만큼 체력에서 제외하고, 그 체력을 다시 저장
      if (mr[marineA].hp <= 0) { // 체력이 모두 소진되었다면...
        System.out.println(marineUnitName  + "이(가) 사망했습니다.");
      }
    }
    // 나는 객체 하나가 죽을 때까지 계속 때렸는데,
    // 수업시간 선생님은 계속 번갈아가면서 공격을 시키므로 turn을 하나씩 증가시킴.
    // 3 넘어가면 숫자가 한도없이 증가하니까 나머지 연산자를 활용한 것이고.




  private static void terranAttack(ZergUnit zerg, int damage) {
    System.out.println("마린이 공격합니다.");
    String zergUnitName;

    // 타입은 부모타입인데 객체가 무엇인지 확인할 때 가장 좋은 것이 instanceof!
    if (zerg instanceof Hydra) { // 저그유닛이 히드라의 객체이면
      zergUnitName = "히드라";
    } else { // 저그유닛이 저글링의 객체이면
      zergUnitName = "저글링";
    }
    System.out.println(zergUnitName + "이(가) 공격을 당합니다.");

    zerg.hp -= damage; // 저그의 체력에서 공격당한만큼을 빼주고 다시 체력을 저장
    // 죽음 여부 알려주기
    if (zerg.hp <= 0) { // 체력이 다 소진되었으면
      System.out.println(zergUnitName + "이(가) 사망했습니다.");
    }
  }


  // 테란이 살아있는지를 판단
  // 함수 밖에서 불러오므로, 매개변수로 받거나 static으로 빼거나 해야하는데
  // 전자의 방법을 사용함.
  static boolean isTerranAlive(Marine[] marines) {
    for (Marine marine : marines) { // 마린 배열 전체를 돌면서
      if (marine.isAlive()) { // 마린이 살아있는지를 판단하고
        return true; // 살아있으면 계속 진행
      }
    }
    return false; // 아니면 종료
  }

  // 저그가 살아있는지를 판단
  static boolean isZergAlive(Zergling zergling, Hydra hydra) {
    if (zergling.isAlive()) { // 저글링이 살아있으면
      return true;
    }

    if (hydra.isAlive()) { // 히드라가 살아있으면
      return true;
    }
    return false; // 둘 다 죽은 상태
  }

}
