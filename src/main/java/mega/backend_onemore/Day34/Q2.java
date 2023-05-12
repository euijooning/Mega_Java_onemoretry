package mega.backend_onemore.Day34;

interface Repairable{}
interface Heal{}

class Unit{
  int attack;
  int hitPoint;
  final int MAX_HP; //상수
  Unit(int hp, int attack){
    MAX_HP = hp;
    this.attack = attack;
  }
}
class GroundUnit extends Unit{
  GroundUnit(int hp, int attack){
    super(hp,attack);
  }
}
class AirUnit extends Unit{
  AirUnit(int hp, int attack){
    super(hp,attack);
  }
}

class Marine extends GroundUnit implements Heal{
  Marine(){
    super(40,10);
    hitPoint = MAX_HP;
  }
}

class Medic extends GroundUnit implements Heal{
  Medic(){
    super(80,0);
    hitPoint = MAX_HP;
  }

  void heal(Heal h) { // 받을 때 Heal로 받음(필터링)
    // 그래서 여기서 Heal인지 검사할 필요 x
    if(h instanceof Unit) { // Heal && Unit 인지 물어보기만 했음
      // 유닛일 때만 // 여기까지는 아직 타입은 Heal
      Unit u = (Unit)h; //참조 자료형변환 => 여기서 Heal로 바꿔줌.
      if(u != null && u.MAX_HP != u.hitPoint) {
        u.hitPoint += 2; // Heal && Unit인 경우에만 수행
      }
    }
  }
}

class Tank extends GroundUnit implements Repairable{
  Tank(){
    super(150,10);
    hitPoint = MAX_HP;
  }
  //뭐죠? 오버라이딩 class Object
  public String toString() {
    return "Tank";
  }
}
class SCV extends GroundUnit implements Repairable{
  SCV(){
    super(60,5);
    hitPoint = MAX_HP;
  }
  void repair(Repairable r) { //Repairable만 받을거야.
    if(r instanceof Unit) { // 그 중에서 Unit만 받을거야.
      // 역시 여기까지는 아직 타입이 Repairable

      Unit u = (Unit)r; //참조 자료형변환
      if(u != null && u.MAX_HP != u.hitPoint) {
        u.hitPoint += 5;
      }
    }
  }
}

public class Q2 {

  public static void main(String[] args) {

    Unit[] team1 = new Unit[2]; // 탱크, SCV
    Unit[] team2 = new Unit[2]; // 마린 두 마리

    int team1Index = 0;
    int team2Index = 0;

    // 객체 생성
    team1[0] = new Tank();
    team1[1] = new SCV();
    for(int i = 0;i<team2.length;i++) {
      team2[i] = new Marine();
    }

    // 반복 시작
    while(true) {
      //1. team1
      //1-1 탱크를 공격
      // %2는 범위를 bound시킨 것.(둘이 번갈아가면서 하겠다.)
      if(team1[team1Index++ % 2] instanceof Tank) { //탱크면 공격할 준비
        int i;
        // 살아있는 유닛 중 가장 앞에 있는 유닛의 인덱스 구하기
        for(i=0;i<team2.length;i++) {
          if(team2[i] != null) { // 마린이 존재하면
            break;
          }
        }

        // 공격
        System.out.println("탱크가 마린을 공격합니다.");
        team2[i].hitPoint -= team1[0].attack; //탱크인걸 알았으니 [0]으로 고정함.
        // 살아있는 마린의 공격력을 깜(감소시킴).

        if(team2[i].hitPoint <= 0) {
          team2[i] = null; // null처리
          System.out.println("마린"+i+"번째가 죽었습니다.");
        }
      }

      //1-2 SCV 수리
      else { // 탱크가 아니면(SCV)
        if(team1[0] != null) { //탱크가 살아있다면,
//          SCV s = (SCV)team1[1];
//          s.repair((Tank)team1[0]);
          SCV scv = (SCV)team1[1];
          Tank tank = (Tank)team1[0];
          scv.repair(tank);
          // Unit 자체에 repaire 개념이 없었으니까
          // SCV로 바꿔야만 수리가 가능하게 되는 것.
          // 수리 당하는 애도 Unit에 Repairable 개념이 없으니
          // Tank로 강제로 바뀌어야 수리 당할 수 있게 됨.
          System.out.println("SCV가 Tank를 수리합니다.");
        }
      }

      //팀1 -> 팀2 모두 전멸 했는지
      int i;
      for(i=0;i<team2.length;i++) {
        if(team2[i] != null) {
          break;
        }
      }
      // 다 돌면 배열의 길이와 같아지게 된다.
      if(i == team2.length) { //team2에서 생존한게 없다는 소리
        System.out.println("Team1이 이겼습니다.");
        break;
      }

      //2. team2
      int j;
      for(j=0;j<team2.length;j++) {
        if(team2[j] != null) {
          break;
        }
      }


      if(team2Index % team2.length >= j) {
        team1[0].hitPoint -= team2[team2Index++ % team2.length].attack;
      }
      else {
        int temp = j - (team2Index % team2.length);
        team2Index += temp;
        team1[0].hitPoint -= team2[team2Index++ % team2.length].attack;

      }
      System.out.println("마린"+((team2Index-1) % team2.length)+"이 탱크를 공격합니다.");
      // 여기서 -1은 위에서 때리고 나면 항상 ++를 했으니 1을 빼줘야 진짜 때린 애가 되는 것.

      if(team1[0].hitPoint <=0) {
        team1[0] = null; //SCV와는 관계없이 Tank가 죽으면 패배인가봄
        System.out.println("Team2가 이겼습니다.");
        break;
      }
    }

  }
}
